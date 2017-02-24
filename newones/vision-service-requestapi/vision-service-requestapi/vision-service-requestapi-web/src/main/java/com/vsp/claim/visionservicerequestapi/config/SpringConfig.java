package com.vsp.claim.visionservicerequestapi.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.Endpoint;
import org.apache.camel.ErrorHandlerFactory;
import org.apache.camel.Processor;
import org.apache.camel.Route;
import org.apache.camel.Service;
import org.apache.camel.VetoCamelContextStartException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.impl.ExplicitCamelContextNameStrategy;
import org.apache.camel.spi.LifecycleStrategy;
import org.apache.camel.spi.RouteContext;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.vsp.api.util.ApiContextPolicy;
import com.vsp.api.util.ScanForResources;
import com.vsp.camel.process.ResourceRoutingProcessor;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.ResourceUtil;
import com.vsp.jaxrs.provider.VspResourceProvider;

@Configuration("vision-service-requestapi-config")
@EnableAsync
@EnableTransactionManagement
@ComponentScan("com.vsp.**.config")
public class SpringConfig extends CamelConfiguration implements LifecycleStrategy {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringConfig.class);

	@Autowired
	private List<RouteBuilder> routes;

	@Autowired
	private ApiContextPolicy apiContextPolicy;

	@Autowired
	private VspResourceProvider vspResourceProvider;

	@Autowired
	private JacksonJsonProvider jsonProvider;

	@Autowired
	private CrossOriginResourceSharingFilter corsFilter;

	@Bean(name = "txManager")
	public PlatformTransactionManager getTransactionManager() {
		return new JtaTransactionManager();
	}

	@Bean(name = "reservedClaimEntityManagerFactory")
	public EntityManagerFactory entityManagerFactoryBean() {
		Context context = null;
		EntityManagerFactory emf = null;
		try {
			context = new javax.naming.InitialContext();
			emf = (EntityManagerFactory) context.lookup("java:/emf");
		} catch (NamingException e) {
			LOG.error("Error while creating Entity Manager Factory", e);
		}
		return emf;
	}

	@Bean(name = "jaxRsServer")
	public JAXRSServerFactoryBean jaxRsServer() {
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		Class<?>[] resourceClasses = null;
		try {
			resourceClasses = ScanForResources.scan(
					"com.vsp.claim.vision-service-requestapi",
					com.vsp.api.home.HomeResource.class);
		} catch (Exception e) {
		}
		if (resourceClasses == null || resourceClasses.length == 0) {
			throw new RuntimeException(
					"You must add the ResourceImplementor(\"com.vsp.claim.service-requestapi\") annotation to at least one resource");
		}
		factory.setServiceBeans(ResourceUtil.createResources(resourceClasses));
		factory.setAddress("/");
		factory.setProviders(Arrays.<Object> asList(vspResourceProvider,
				jsonProvider, corsFilter));
		return factory;
	}

	@Override
	public List<RouteBuilder> routes() {
		routes.add(createMainJaxRsRoute());
		return routes;
	}

	@Override
	protected void setupCamelContext(CamelContext camelContext)
			throws Exception {
		super.setupCamelContext(camelContext);

		if (!Preferences.initialized()) {
			Preferences.initialize();
		}

		camelContext.setNameStrategy(new ExplicitCamelContextNameStrategy(
				Preferences.getApplication() + "-" + Preferences.getVersion()));
		camelContext.addLifecycleStrategy(this);
	}

	@Bean(name = "argumentDataFormat")
	public JacksonDataFormat argumentDataFormat() {
		JacksonDataFormat dataFormat = new JacksonDataFormat();
		dataFormat.getObjectMapper().setSerializationInclusion(
				Include.NON_EMPTY);
		dataFormat.setUnmarshalType(Object[].class);
		return dataFormat;
	}

	private RouteBuilder createMainJaxRsRoute() {
		return new RouteBuilder() {
			public void configure() {
				from("cxfrs:bean:jaxRsServer?bindingStyle=SimpleConsumer")
						.routeId("mainJaxRs_service-requestapi-web")
						.processRef("acceptHeaderProcessor")
						.processRef("accessTokenProcessor")
						.processRef("versionDetector")
						.processRef("versionUpTransformer")
						.removeHeader("Content-Length")
						.processRef("resourceRoutingProcessor")
						.routingSlip(
								header(ResourceRoutingProcessor.HEADER_NAME))
						.processRef("beginResponseProcessor")
						.processRef("versionDownTransformer")
						.processRef("contentTypeHeaderProcessor")
						.processRef("originProcessor")
						.processRef("informationalHeaderProcessor")
						.processRef("httpResponseProcessor");
			}
		};
	}

	@Override
	public void onRouteContextCreate(RouteContext routeContext) {
		routeContext.getRoutePolicyList().add(apiContextPolicy);
	}

	@Override
	public void onContextStart(CamelContext context)
			throws VetoCamelContextStartException {
	}

	@Override
	public void onContextStop(CamelContext context) {
	}

	@Override
	public void onComponentAdd(String name, Component component) {
	}

	@Override
	public void onComponentRemove(String name, Component component) {
	}

	@Override
	public void onEndpointAdd(Endpoint endpoint) {
	}

	@Override
	public void onEndpointRemove(Endpoint endpoint) {
	}

	@Override
	public void onServiceAdd(CamelContext context, Service service, Route route) {
	}

	@Override
	public void onServiceRemove(CamelContext context, Service service,
			Route route) {
	}

	@Override
	public void onRoutesAdd(Collection<Route> routes) {
	}

	@Override
	public void onRoutesRemove(Collection<Route> routes) {
	}

	@Override
	public void onErrorHandlerAdd(RouteContext routeContext,
			Processor errorHandler, ErrorHandlerFactory errorHandlerBuilder) {
	}

	@Override
	public void onErrorHandlerRemove(RouteContext routeContext,
			Processor errorHandler, ErrorHandlerFactory errorHandlerBuilder) {
	}

	@Override
	public void onThreadPoolAdd(CamelContext camelContext,
			ThreadPoolExecutor threadPool, String id, String sourceId,
			String routeId, String threadPoolProfileId) {
	}

	@Override
	public void onThreadPoolRemove(CamelContext camelContext,
			ThreadPoolExecutor threadPool) {
	}

}

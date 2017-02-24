
package com.vsp.claim.visionservicerequestapi.servicerequest.config;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vsp.api.home.model.Home;
import com.vsp.camel.route.BaseRouteBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveAccessPointCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveClientDivisionCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveEligibilityCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveMemberPoliciesCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.factory.CommandFactory;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.factory.RetrieveAccessPointCommandFactory;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.factory.RetrieveClientDivisionCommandFactory;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.factory.RetrieveEligibilityCommandFactory;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.factory.RetrieveMemberPolicyCommandFactory;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.CreateVisionServiceRequestLifecycleBean;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.DeleteVisionServiceRequestLifecycleBean;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.SearchVisionServiceRequestsLifecycleBean;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.oauth.ApiInternalRestClientProducer;

@Configuration("vision-service-requestapi-srvservicerequest-config")
@ComponentScan(basePackages={ "com.vsp.claim.visionservicerequestapi.servicerequest" })
public class ServiceConfig extends BaseRouteBuilder {
	
	private static final String CREATE_BEAN = "createServiceRequestLifecycleBean";
	private static final String SEARCH_BEAN = "searchServiceRequestsLifecycleBean";
	private static final String DELETE_BEAN = "deleteVisionServiceRequestLifecycleBean";
	
	/*
	* SERVICES
	*/
	
	@Bean
	@Scope("prototype")
	public RetrieveAccessPointCommand accessPointCommand() {
		return new RetrieveAccessPointCommand();
	}
	
	@Bean
	@Scope("prototype")
	public RetrieveEligibilityCommand eligiblityCommand() {
		return new RetrieveEligibilityCommand();
	}
	
	@Bean
	@Scope("prototype")
	public RetrieveClientDivisionCommand clientDivisionCommand(){
		return new RetrieveClientDivisionCommand();
	}
	
	@Bean(name = "retrieveAccessPointCommandFactory")
	public CommandFactory retrieveAccessPointCommandFactory() {
		return new RetrieveAccessPointCommandFactory() {
			@Override
			protected RetrieveAccessPointCommand createAccessPointCommand() {
				return accessPointCommand();
			}
		};
	}
	
	@Bean(name = "retrieveEligibilityCommandFactory")
	public RetrieveEligibilityCommandFactory retrieveEligibilityCommandFactory() {
		return new RetrieveEligibilityCommandFactory() {
			@Override
			protected RetrieveEligibilityCommand createRetrieveEligibilityCommand() {
				return eligiblityCommand();
			}
		};
	}
	
	@Bean(name = "retrieveClientDivisionCommandFactory")
	public RetrieveClientDivisionCommandFactory retrieveClientDivisionCommmandFactory() {
		return new RetrieveClientDivisionCommandFactory() {

			@Override
			protected RetrieveClientDivisionCommand createRetrieveClientDivisionCommand() {
				return clientDivisionCommand();
			}

		};
	}
	
	@Bean
	@Scope("prototype")
	public RetrieveMemberPoliciesCommand memberPolicyCommand() {
		return new RetrieveMemberPoliciesCommand();
	}
	
	@Bean(name = "retrieveMemberPoliciesCommandFactory")
	public RetrieveMemberPolicyCommandFactory memberPolicyCommandFactory() {
		return new RetrieveMemberPolicyCommandFactory() {
			@Override
			protected RetrieveMemberPoliciesCommand createRetrieveMemberPoliciesCommand() {
				return memberPolicyCommand();
			}

		};
	}

	@Bean(name = CREATE_BEAN )
	public CreateVisionServiceRequestLifecycleBean createServiceRequestLifecycle() {
		return new CreateVisionServiceRequestLifecycleBean() {

			@Override
			protected RestClient<Home> getRestClient() {
				return restClient();
			}
			
		};
	}
	
	@Bean(name = SEARCH_BEAN)
	public SearchVisionServiceRequestsLifecycleBean searchServiceRequestsLifecycle() {
		return new SearchVisionServiceRequestsLifecycleBean();
	}
	
	@Bean(name = DELETE_BEAN)
	public DeleteVisionServiceRequestLifecycleBean deleteVisionServiceRequestLifecycle() {
		return new DeleteVisionServiceRequestLifecycleBean(){
		
			@Override
			protected RestClient<Home> getRestClient() {
				return restClient();
			}
		};
	}

	@Bean(name="myRemoteResourceDataFormat")
	public JacksonDataFormat myRemoteResourceDataFormat() {
		JacksonDataFormat dataFormat = new JacksonDataFormat();
		dataFormat.getObjectMapper().setSerializationInclusion(Include.NON_EMPTY);
		return dataFormat;
	}

	 @Bean(name="myResourceDataFormat")
	 public JacksonDataFormat myResourceDataFormat() {
		 JacksonDataFormat dataFormat = new JacksonDataFormat();
		 dataFormat.getObjectMapper().setSerializationInclusion(Include.NON_EMPTY);
		 return dataFormat;
	 }
	
	  /*
	  *  CAMEL ROUTES
	  */
	  @Override
	  public void configure() throws Exception {
		// Invoke super.configure on BaseRouteBuilder to set up exception handling
		super.configure();

		//REST
		from("direct:VisionServiceRequestResource")
			.routeId("VisionServiceRequestResourceRest_service-requestapi-srvservicerequest")
			.choice()
				.when(header("operationName").isEqualTo(ResourceOperationEnum.CREATE_VISION_SERVICE_REQUEST.getOperation()))
					.beanRef(CREATE_BEAN, ResourceOperationEnum.CREATE_VISION_SERVICE_REQUEST.getOperation() + "("
							+ "${header.clientId}, ${header.divisionId}, ${header.policyId}, ${header.consumerId}, ${header.networkId},"
							+ "${header.productPackageName}, ${header.effectiveDate}, ${body})")
				.when(header("operationName").isEqualTo(ResourceOperationEnum.SEARCH_VISION_SERVICE_REQUESTS.getOperation()))
					.beanRef(SEARCH_BEAN, ResourceOperationEnum.SEARCH_VISION_SERVICE_REQUESTS.getOperation() + "("
							+ "${header.clientId}, ${header.divisionId}, ${header.policyId}, ${header.consumerId}"
							+ ")")
				.when(header("operationName").isEqualTo(ResourceOperationEnum.DELETE_VISION_SERVICE_REQUEST.getOperation()))
					.beanRef(DELETE_BEAN, ResourceOperationEnum.DELETE_VISION_SERVICE_REQUEST.getOperation() + "("
							+ "${header.trackingNumber}"
							+ ")")	
				.endChoice()
			.end()
		;
	}

	@Bean(name = "serviceRequestApiRestClient")
	@Scope(value = "prototype")
	public RestClient<Home> restClient(){
		return new ApiInternalRestClientProducer().createRestClient();
	}
		 
}
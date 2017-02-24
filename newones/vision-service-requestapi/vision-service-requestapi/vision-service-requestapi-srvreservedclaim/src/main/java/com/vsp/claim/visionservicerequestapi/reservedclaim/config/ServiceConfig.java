package com.vsp.claim.visionservicerequestapi.reservedclaim.config;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vsp.camel.route.BaseRouteBuilder;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.CreateReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.DeleteReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.RetrieveReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.SearchReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.UpdateReservedClaimBean;

@Configuration("vision-service-requestapi-srvreservedclaim-config")
@ComponentScan(basePackages={"com.vsp.claim.visionservicerequestapi.reservedclaim.serviceclient", 
		"com.vsp.claim.visionservicerequestapi.reservedclaim.command",
		"com.vsp.claim.visionservicerequestapi.reservedclaim.command.factory",
		"com.vsp.claim.visionservicerequestapi.reservedclaim.persistence"})
public class ServiceConfig extends BaseRouteBuilder {
	
	private static final String OPERATION_NAME = "operationName";

	
	@Bean(name = "retrieveReservedClaimsService")
	public RetrieveReservedClaimsBean retrieveReservedClaims() {
		return new RetrieveReservedClaimsBean();
	}
	
	@Bean(name = "searchReservedClaimsService")
	public SearchReservedClaimsBean searchReservedClaims() {
		return new SearchReservedClaimsBean();
	}
	  
	@Bean(name = "createReservedClaimService")
	public CreateReservedClaimsBean createReservedClaims() {
		return new CreateReservedClaimsBean();
	}
	  
	@Bean(name = "updateReservedClaimService")
	public UpdateReservedClaimBean updateReservedClaims() {
		return new UpdateReservedClaimBean();
	}
	
	@Bean(name = "deleteReservedClaimsService")
	public DeleteReservedClaimsBean deleteReservedClaims() {
		return new DeleteReservedClaimsBean();
	}
	
	@Bean(name="claimDataFormat")
	public JacksonDataFormat myRemoteResourceDataFormat() {
		JacksonDataFormat dataFormat = new JacksonDataFormat();
		dataFormat.getObjectMapper().setSerializationInclusion(Include.NON_EMPTY);
		dataFormat.setUnmarshalType(com.vsp.api.claim.model.Claim.class);
		return dataFormat;
	}
	
	@Bean(name="myResourceDataFormat")
	public JacksonDataFormat myResourceDataFormat() {
		JacksonDataFormat dataFormat = new JacksonDataFormat();
	    dataFormat.getObjectMapper().setSerializationInclusion(Include.NON_EMPTY);
	    dataFormat.setUnmarshalType(com.vsp.api.claim.model.Claim.class);
	    return dataFormat;
	}
	  	
	/*
	*  CAMEL ROUTES
	*/
	@Override
	public void configure() throws Exception {
		super.configure();
		from("direct:ReservedClaimsResource")
	      .routeId("ReservedClaimsResourceRest_service-requestapi-srvreservedclaim")
	      .choice()
	        .when(header(OPERATION_NAME).isEqualTo(ReservedClaimResourceOperationEnum.RETRIEVE_CLAIM.getOperation()))
	          .beanRef("retrieveReservedClaimsService", ReservedClaimResourceOperationEnum.RETRIEVE_CLAIM.getOperation()
	        		  + "(${header.claimNumber},${header.claimExtNumber})")
	        .when(header(OPERATION_NAME).isEqualTo(ReservedClaimResourceOperationEnum.CREATE_CLAIM.getOperation()))
	          .beanRef("createReservedClaimService", ReservedClaimResourceOperationEnum.CREATE_CLAIM.getOperation() 
	        		  + "(${body})")
	        .when(header(OPERATION_NAME).isEqualTo(ReservedClaimResourceOperationEnum.CREATE_CLAIM_LINES.getOperation()))
	          .beanRef("createReservedClaimService", ReservedClaimResourceOperationEnum.CREATE_CLAIM_LINES.getOperation()
	        		  + "(${header.claimNumber},${header.claimExtNumber},${body})")
	        .when(header(OPERATION_NAME).isEqualTo(ReservedClaimResourceOperationEnum.UPDATE_CLAIM.getOperation()))
	          .beanRef("updateReservedClaimService", ReservedClaimResourceOperationEnum.UPDATE_CLAIM.getOperation()
	        		  + "(${header.claimNumber},${header.claimExtNumber},${body})")
	        .when(header(OPERATION_NAME).isEqualTo(ReservedClaimResourceOperationEnum.DELETE_CLAIM.getOperation()))
	          .beanRef("deleteReservedClaimsService", ReservedClaimResourceOperationEnum.DELETE_CLAIM.getOperation()
	        		  + "(${header.claimNumber},${header.claimExtNumber})")
	        .when(header(OPERATION_NAME).isEqualTo(ReservedClaimResourceOperationEnum.DELETE_CLAIM_LINE.getOperation()))
	          .beanRef("deleteReservedClaimsService", ReservedClaimResourceOperationEnum.DELETE_CLAIM_LINE.getOperation() 
	        		  + "(${header.claimNumber},${header.claimExtNumber},${header.lineNumber})")
	        .when(header(OPERATION_NAME).isEqualTo(ReservedClaimResourceOperationEnum.UPDATE_CLAIM_LINE.getOperation()))
	          .beanRef("updateReservedClaimService", ReservedClaimResourceOperationEnum.UPDATE_CLAIM_LINE.getOperation()
	        		  + "(${header.claimNumber},${header.claimExtNumber},${header.lineNumber},${body})")
	        .when(header(OPERATION_NAME).isEqualTo(ReservedClaimResourceOperationEnum.SEARCH_CLAIM.getOperation()))
	          .beanRef("searchReservedClaimsService", ReservedClaimResourceOperationEnum.SEARCH_CLAIM.getOperation()
	        		  + "(${header.clientId},${header.divisionId},${header.policyId},${header.consumerId})")
	        .endChoice()
	      .end();
	}
  
}

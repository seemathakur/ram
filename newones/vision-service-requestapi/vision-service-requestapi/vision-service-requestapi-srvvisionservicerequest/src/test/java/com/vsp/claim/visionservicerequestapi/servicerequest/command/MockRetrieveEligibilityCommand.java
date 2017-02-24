package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;

import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockObjectProvider;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;

public class MockRetrieveEligibilityCommand extends RetrieveEligibilityCommand {
	
	private MockObjectProvider objectProvider;
	private String dataFile;
	
	public MockRetrieveEligibilityCommand() {
		super();
		objectProvider = new MockObjectProvider();
		 
	}
	
	public MockRetrieveEligibilityCommand(String dataFile) {
		super();
		objectProvider = new MockObjectProvider();
		this.dataFile = dataFile;
	}
	
	@Override
	public Eligibility getReturnValue()  {
		try {
			return (Eligibility) objectProvider.mockObjectFromJson(dataFile, Eligibility.class);
		} catch (IOException e) {
			ServiceClientException wrappedException =
					new ServiceClientException("Unable to mock Eligibility object from json file", this);
			throw new WebApplicationException(wrappedException, 500);
		}
	}

	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}

}

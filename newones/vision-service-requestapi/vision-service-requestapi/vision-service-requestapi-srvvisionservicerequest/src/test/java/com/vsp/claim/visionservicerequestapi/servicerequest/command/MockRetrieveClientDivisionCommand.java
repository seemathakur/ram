package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;

import com.vsp.api.client.model.ClientDivision;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockObjectProvider;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;

public class MockRetrieveClientDivisionCommand extends RetrieveClientDivisionCommand {
	
	private MockObjectProvider objectProvider;
	private String dataFile;
	
	public MockRetrieveClientDivisionCommand() {
		super();
		objectProvider = new MockObjectProvider();
	}
	
	public MockRetrieveClientDivisionCommand(String dataFile) {
		super();
		objectProvider = new MockObjectProvider();
		this.dataFile = dataFile;
	}
	
	@Override
	public ClientDivision getReturnValue()  {
			return getClientResponse();
		}

	
	private ClientDivision getClientResponse() {
		ClientDivision serviceClientResponse = null;
		try {
			serviceClientResponse = getValidatedClientResponse();
		} catch(Exception serivceException) {
			ServiceClientException wrappedException =
					new ServiceClientException("Error mocking client object from json", this);
			throw new WebApplicationException(wrappedException, 500);
		}
		return serviceClientResponse;
	}

	private ClientDivision getValidatedClientResponse() throws Exception {
		try {
		return (ClientDivision) objectProvider.mockObjectFromJson(
				dataFile, ClientDivision.class);
		} catch (IOException e) {
			ServiceClientException wrappedException =
					new ServiceClientException("Error mocking client object from json", this);
			throw new WebApplicationException(wrappedException, 500);
		}
	}
	
	public void setDataFile(String dataFile) {
		this.dataFile = dataFile;
	}

}

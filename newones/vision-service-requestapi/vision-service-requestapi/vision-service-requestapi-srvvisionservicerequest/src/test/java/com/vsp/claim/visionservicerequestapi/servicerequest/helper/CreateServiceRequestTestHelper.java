package com.vsp.claim.visionservicerequestapi.servicerequest.helper;

import java.util.List;

import org.joda.time.DateMidnight;

import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.eligibility.model.EligibilityProductItems;

public class CreateServiceRequestTestHelper {
	
	public static final String CLIENT_ID = "12345678";
	public static final String DIV_ID = "0001";
	public static final String POLICY_ID = "4444445555";
	public static final String CONSUMER_ID = "123456";
	public static final String NETWORK_ID = "1000";
	public static final String PRODUCT_PACKAGE = "Signature"; 
	public static final String CLAIM_NUMBER = "123456789";
	public static final String CLAIM_EXT_NUMBER  = "00";
	public static final String PRODUCT_CATALOG_KEY0 = "GenExam";
	public static final String PRODUCT_CATALOG_KEY1 = "Frame";
	public static final String PRODUCT_CATALOG_KEY2 = "Lens";
	
	public static final String EFFECTIVE_DATE_STR = "2015-01-01";
	public static final DateMidnight EFFECTIVE_DATE = new DateMidnight(EFFECTIVE_DATE_STR);
	
	public static VisionServiceRequest buildServiceRequest(){
		VisionServiceRequest items = new VisionServiceRequest();
		List<EligibilityProductItem> epis =  buildEligibilityProductItems();
		items.setSelectedEligibleProductItems(epis);
		return items;
	}

	public static EligibilityProductItems buildEligibilityProductItems() {
		EligibilityProductItems epis = new EligibilityProductItems();
		epis.add(buildEligibilityProductItem("GenExam"));
		epis.add(buildEligibilityProductItem("Frame"));
		epis.add(buildEligibilityProductItem("Lens"));
		return epis;
	}
	
	public static EligibilityProductItem buildEligibilityProductItem(String productCatalogKey) {
		EligibilityProductItem epi = new EligibilityProductItem();
		epi.setProductCatalogKey(productCatalogKey);
		return epi;
	}

}

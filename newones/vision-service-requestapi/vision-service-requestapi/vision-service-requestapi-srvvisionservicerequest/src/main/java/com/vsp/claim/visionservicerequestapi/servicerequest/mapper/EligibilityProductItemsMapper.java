package com.vsp.claim.visionservicerequestapi.servicerequest.mapper;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.eligibility.model.EligibilityProductItems;

public final class EligibilityProductItemsMapper {
	
	
	private EligibilityProductItemsMapper() {
	}
	
	
	public static EligibilityProductItems mapClaimLinesToEligibilityProductItems(List<ClaimLine> claimLines) {
		EligibilityProductItems eligibilityProductItems = new EligibilityProductItems();
		if (CollectionUtils.isNotEmpty(claimLines)) {
			for (ClaimLine claimLine : claimLines) {
				eligibilityProductItems.add(EligibilityProductItemMapper.mapClaimLineToEligibilityProductItem(claimLine));
			}
		}
		return eligibilityProductItems;
	}
	
	
}

package com.vsp.claim.visionservicerequestapi.reservedclaim.helper;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;

public class ClaimLineMatcher {
	
	public static Matcher<ClaimLine> matchesJpaClaimLine(
			final PreClaimLine jpaClaimLine) {
		
		return new TypeSafeMatcher<ClaimLine>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("Mapping failed. Claim line does not match JPA claim line"); 
				
			}

			@Override
			public boolean matchesSafely(ClaimLine claimLine) {
				return claimLineMatchesSafely(claimLine);
			}		
			
			private  boolean claimLineMatchesSafely(ClaimLine claimLine){
				return  IndicatorToBooleanComparator.compare(jpaClaimLine.getClmlnOvrdElgInd(), claimLine.getOverrideEligibilityIndicator())
						&& jpaClaimLine.getClmlnPicNm().equalsIgnoreCase(claimLine.getProductCatalogKey())
						&& DateComparator.isDateEqualToDateMidnight(jpaClaimLine.getClmlnRsvdBeginDt(), claimLine.getReservationInterval().getBegin())
						&& DateComparator.isDateEqualToDateMidnight(jpaClaimLine.getClmlnRsvdEndDt(), claimLine.getReservationInterval().getEnd())
						&& jpaClaimLine.getClmlnUsdAlowAmt().equals(claimLine.getAllowanceUsedAmount());
			}
		};
	}
}

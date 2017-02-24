package com.vsp.claim.visionservicerequestapi.reservedclaim.helper;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;

public class PreClaimLineMatcher {
	
	public static Matcher<ClaimLine> matchesClaimLine(
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
				return 	NullBooleanToIndicatorComparator.compare(claimLine.getOverrideEligibilityIndicator(), jpaClaimLine.getClmlnOvrdElgInd())
						&& IgnoreNullComparator.compare(claimLine.getProductCatalogKey(), jpaClaimLine.getClmlnPicNm())
						&& NullDateComparator.isDateEqualToDateMidnight(claimLine.getReservationInterval().getBegin(), jpaClaimLine.getClmlnRsvdBeginDt())
						&& NullDateComparator.isDateEqualToDateMidnight(claimLine.getReservationInterval().getEnd(), jpaClaimLine.getClmlnRsvdEndDt())
						&& IgnoreNullComparator.compare(claimLine.getAllowanceUsedAmount(), jpaClaimLine.getClmlnUsdAlowAmt());
			}
			
		};
	}
}

package com.vsp.claim.visionservicerequestapi.reservedclaim.helper;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

import com.vsp.api.claim.model.Claim;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;

public class ClaimMatcher {
	public static Matcher<Claim> matchesJpaClaim(
			final PreClaim jpaClaim) {

		return new TypeSafeMatcher<Claim>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("Mapping failed. Claim does not match JPA claim");
			}

			@Override
			public boolean matchesSafely(Claim claim) {
				return matchesPreClaimSafely(claim);
			}
			
			private boolean matchesPreClaimSafely(Claim claim){
				return matchesOverrideRuleCodes(claim)
						&& jpaClaim.getRsvdAprvdByBypassCd().equalsIgnoreCase(claim.getReservationApprovedByBypassCode())
						&& jpaClaim.getRsvdAprvdByNm().equalsIgnoreCase(claim.getReservationApprovedByName())
						&& DateComparator.isDateEqualToDateMidnight(jpaClaim.getRsvdIsuDt(), claim.getReservationIssueDate())
						&& jpaClaim.getRsvdSrcCd().equalsIgnoreCase(claim.getReservationSourceCode())
						&& jpaClaim.getClmPpNm().equalsIgnoreCase(claim.getProductPackageName())
						&& jpaClaim.getClmAffEligCd().equalsIgnoreCase(claim.getAffectEligibilityCode());
			}

			private boolean matchesOverrideRuleCodes(Claim claim) {
				return jpaClaim.getClmOvrdRulCd1().equalsIgnoreCase(claim.getOverrideRuleCodes().get(0))
						&& jpaClaim.getClmOvrdRulCd2().equalsIgnoreCase(claim.getOverrideRuleCodes().get(1))
						&& jpaClaim.getClmOvrdRulCd3().equalsIgnoreCase(claim.getOverrideRuleCodes().get(2))
						&& jpaClaim.getClmOvrdRulCd4().equalsIgnoreCase(claim.getOverrideRuleCodes().get(3))
						&& jpaClaim.getClmOvrdRulCd5().equalsIgnoreCase(claim.getOverrideRuleCodes().get(4))
						&& jpaClaim.getClmOvrdRulCd6().equalsIgnoreCase(claim.getOverrideRuleCodes().get(5))
						&& jpaClaim.getClmOvrdRulCd7().equalsIgnoreCase(claim.getOverrideRuleCodes().get(6))
						&& jpaClaim.getClmOvrdRulCd8().equalsIgnoreCase(claim.getOverrideRuleCodes().get(7))
						&& jpaClaim.getClmOvrdRulCd9().equalsIgnoreCase(claim.getOverrideRuleCodes().get(8))
						&& jpaClaim.getClmOvrdRulCd10().equalsIgnoreCase(claim.getOverrideRuleCodes().get(9));
			}
		};
	}

}

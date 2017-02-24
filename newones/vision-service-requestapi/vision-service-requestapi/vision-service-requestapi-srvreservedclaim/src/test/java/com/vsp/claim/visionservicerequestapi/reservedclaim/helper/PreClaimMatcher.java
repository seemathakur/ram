package com.vsp.claim.visionservicerequestapi.reservedclaim.helper;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.internal.matchers.TypeSafeMatcher;

import com.vsp.api.claim.model.Claim;
import com.vsp.claim.common.mapping.factory.jpa.JPAClaimDefaults;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;

public class PreClaimMatcher {
	
	public static Matcher<Claim> matchesClaim(
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

			private boolean matchesPreClaimSafely(Claim claim) {
				return matchesOverrideRuleCodes(claim)
				&& IgnoreNullComparator.compare(claim.getReservationApprovedByBypassCode(),jpaClaim.getRsvdAprvdByBypassCd())
				&& IgnoreNullComparator.compare(claim.getReservationApprovedByName(),jpaClaim.getRsvdAprvdByNm())
				&& NullDateComparator.isDateEqualToDateMidnight(claim.getReservationIssueDate(), jpaClaim.getRsvdIsuDt())
				&& IgnoreNullComparator.compare(claim.getReservationSourceCode(),jpaClaim.getRsvdSrcCd())
				&& IgnoreNullComparator.compare(claim.getProductPackageName(),jpaClaim.getClmPpNm())
				&& IgnoreNullComparator.compare(claim.getAffectEligibilityCode(),jpaClaim.getClmAffEligCd());
			}
			
			private boolean matchesOverrideRuleCodes(Claim claim) {
				boolean matches = true; 
				if(claim.getOverrideRuleCodes()!= null){
					for(int i=0; i < claim.getOverrideRuleCodes().size();i++){
						if(i==0){
							matches= matches && jpaClaim.getClmOvrdRulCd1().equalsIgnoreCase(claim.getOverrideRuleCodes().get(0));
						}else if(i==1){
							matches= matches && jpaClaim.getClmOvrdRulCd2().equalsIgnoreCase(claim.getOverrideRuleCodes().get(1));
						}else if(i==2){
							matches= matches && jpaClaim.getClmOvrdRulCd3().equalsIgnoreCase(claim.getOverrideRuleCodes().get(2));
						}else if(i==3){
							matches= matches && jpaClaim.getClmOvrdRulCd4().equalsIgnoreCase(claim.getOverrideRuleCodes().get(3));
						}else if(i==4){
							matches= matches && jpaClaim.getClmOvrdRulCd5().equalsIgnoreCase(claim.getOverrideRuleCodes().get(4));
						}else if(i==5){
							matches= matches && jpaClaim.getClmOvrdRulCd6().equalsIgnoreCase(claim.getOverrideRuleCodes().get(5));
						}else if(i==6){
							matches= matches && jpaClaim.getClmOvrdRulCd7().equalsIgnoreCase(claim.getOverrideRuleCodes().get(6));
						}else if(i==7){
							matches= matches && jpaClaim.getClmOvrdRulCd8().equalsIgnoreCase(claim.getOverrideRuleCodes().get(7));
						}else if(i==8){
							matches= matches && jpaClaim.getClmOvrdRulCd9().equalsIgnoreCase(claim.getOverrideRuleCodes().get(8));
						}else if(i==9){
							matches= matches && jpaClaim.getClmOvrdRulCd10().equalsIgnoreCase(claim.getOverrideRuleCodes().get(9));
						}
					}
					
				}else{
					matches = jpaClaim.getClmOvrdRulCd1().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING)
							&& jpaClaim.getClmOvrdRulCd2().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING)
							&& jpaClaim.getClmOvrdRulCd3().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING)
							&& jpaClaim.getClmOvrdRulCd4().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING)
							&& jpaClaim.getClmOvrdRulCd5().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING)
							&& jpaClaim.getClmOvrdRulCd6().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING)
							&& jpaClaim.getClmOvrdRulCd7().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING)
							&& jpaClaim.getClmOvrdRulCd8().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING)
							&& jpaClaim.getClmOvrdRulCd9().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING)
							&& jpaClaim.getClmOvrdRulCd10().equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING);
				}
				return matches; 
			}
			
		};
		
	}

}

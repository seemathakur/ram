package com.vsp.claim.visionservicerequestapi.shared.util;

import java.util.List;

import org.joda.time.DateMidnight;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.ClaimLines;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.api.consumer.model.Membership;
import com.vsp.api.core.Link;
import com.vsp.api.network.model.ProviderNetworkKey;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.provider.model.ServiceLocation;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimLineNotFoundException;

/**
 * @author huyng
 *
 *         Utility class to help with common tasks when extracting information
 *         out of a ReservedClaim
 */
public final class ReservedClaimUtil {
	
	private static final String CREATE_LINES_REL = "createlines";
	
	private ReservedClaimUtil() { }
	
	public static MemberPolicyKey getMemberPolicyKeyFromClaim(Claim claim) {
		MemberPolicyKey policyKey;
		Membership membership = claim.getSubscriber(); 
		policyKey = membership.getMemberPolicyKey();
		
		if(policyKey == null) {
			membership = claim.getPatient(); 
			policyKey = membership.getMemberPolicyKey();
		}
		return policyKey;
	}
	
	public static Link<ClaimLines> getCreateLinesLink(Claim claim) {
		Link<ClaimLines> toReturn = null;
			for (Link<?> link : claim.getValidClaimOperations()){
				if (link.getRel().contains(CREATE_LINES_REL)) {
					toReturn = (Link<ClaimLines>) link;
				}
			}
		return toReturn;
	}
	
	public static String getNetworkId(Claim claim) {
		ProviderNetworkAccessPoint location = claim.getProviderNetworkAccessPoint();
		ProviderNetworkKey networkKey = location.getProviderNetworkKey();
		
		return networkKey.getNetworkId();
	} 
	
	public static DateMidnight findEarliestReservationIntervalDate(Claim claim){
		List<ClaimLine> lines = claim.getClaimLines();
		if (lines.size()==0){
			return new DateMidnight();
		}
		DateMidnight toReturn = lines.get(0).getReservationInterval().getBegin();
		for (ClaimLine line : lines){
			if (line.getReservationInterval().getBegin().compareTo(toReturn) < 0) {
				toReturn = line.getReservationInterval().getBegin();
			}
		}
		return toReturn;
	}


	public static boolean isServiceExisted(Claim claim) {
		List<ClaimLine> claimLines = claim.getClaimLines();

		if (claimLines != null && claimLines.size() > 0) {
			return true;
		}

		return false;
	}

	public static String getDrPhoneNumberFromClaim(Claim claim) {
		String phoneNumber = null;
		ProviderNetworkAccessPoint location = claim.getProviderNetworkAccessPoint(); 
		ServiceLocation serviceLocation = location.getServiceLocation();
		
		if (serviceLocation != null) {
			phoneNumber = serviceLocation.getPhoneNumber();
		}

		return phoneNumber;
	}
	
	public static void setClaimStatus(Claim claim, String status) {
		claim.setStatusCode(status);		
	}
	
	public static void setClaimLinesStatus(Claim claim, String status) {
		if (isServiceExisted(claim)) {
			List<ClaimLine> lines = modifyClaimLinesStatus(claim.getClaimLines(), status);
			claim.setClaimLines(lines);
		}
	}

	private static List<ClaimLine> modifyClaimLinesStatus(
			List<ClaimLine> claimLines, String status) {

		for (ClaimLine claimLine : claimLines) {
			claimLine.setStatusCode(status);
		}

		return claimLines;
	}	
	
	public static String getClaimKeyAsString(ClaimKey claimKey) {
		StringBuilder claimKeyMessageBuilder = new StringBuilder(claimKey.getClaimNumber())
			.append("-")
			.append(claimKey.getClaimExtNumber());
		return claimKeyMessageBuilder.toString();
	}
	
	public static int findClaimLineIndexByLineNumber(Claim claim, int lineNumber) throws ClaimLineNotFoundException {
		int i = 0;
		
		for (ClaimLine line : claim.getClaimLines()) {
			if (line.getLineNumber() == lineNumber) {
				break;
			}
			
			i++;
		}
		
		if(claim.getClaimLines().size() <= i){
			throw new ClaimLineNotFoundException(lineNumber); 
		}
		
		return i;
	}

	public static ClaimLine removeClaimLineByLineNumber(Claim claim, int lineNumber) throws ClaimLineNotFoundException {
		ClaimLine claimLine = null;
		int index = findClaimLineIndexByLineNumber(claim, lineNumber);		
		claimLine = claim.getClaimLines().get(index);
		claim.getClaimLines().remove(index);
		return claimLine;
	}

	public static void replaceClaimLine(Claim claim, ClaimLine line) throws ClaimLineNotFoundException {
		List<ClaimLine> lines = claim.getClaimLines();
		int index = findClaimLineIndexByLineNumber(claim, line.getLineNumber());
		lines.set(index, line);
	}
	
	public static ClaimLine retrieveClaimLineByLineNumber(Claim claim, int lineNumber) throws ClaimLineNotFoundException {
		List<ClaimLine> lines = claim.getClaimLines();
		int index = findClaimLineIndexByLineNumber(claim, lineNumber);
		return lines.get(index);
	}

	public static ClaimLine retrieveClaimLineByProductCatalogKey(Claim claim, String productCatalogKeyName) throws ClaimLineNotFoundException {
		List<ClaimLine> lines = claim.getClaimLines();
		int index = findClaimLineIndexByProductCatalogKey(claim, productCatalogKeyName);
		return lines.get(index);		
	}

	private static int findClaimLineIndexByProductCatalogKey(Claim claim, String productCatalogKeyName) throws ClaimLineNotFoundException {
		int i = 0;
		
		for (ClaimLine line : claim.getClaimLines()) {
			if (line.getProductCatalogKey().equalsIgnoreCase(productCatalogKeyName)) {
				break;
			}
			
			i++;
		}
		
		if(claim.getClaimLines().size() <= i){
			throw new ClaimLineNotFoundException("Unable to find claim line by product catalog key: " + productCatalogKeyName); 
		}
		
		return i;
	}
		
	public static int getHighestLineNumber(List<ClaimLine> lines){
		int maxLineNumber = 0;
		for (ClaimLine line: lines){
			if(line.getLineNumber() > maxLineNumber){
				maxLineNumber = line.getLineNumber();
			}
		}

		return maxLineNumber;
	}

}

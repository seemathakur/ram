package com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vsp.claim.common.model.jpa.BaseClaim;
import com.vsp.claim.common.model.jpa.ClaimKey;
import com.vsp.jpa.StringTrimListener;
import com.vsp.jpa.Trim;


/**
 * The persistent class for the CLM2342T database table.
 * 
 */
@Entity
@Table(name="CLM2342T")
@NamedQueries({
	@NamedQuery(name="getPreClaimByGrpDivMbr", query="SELECT c FROM PreClaim c WHERE c.membrId = :mbrId AND c.membrGroupId = :grpId and c.membrGroupDiv = :divId"),
	@NamedQuery(name="getPreClaimByGrpMbr", query="SELECT c FROM PreClaim c WHERE c.membrId = :mbrId AND c.membrGroupId in (:grpIdList)"),
	@NamedQuery(name="getPreClaimByKey", query="SELECT c FROM PreClaim c where c.claimKey.claimNumber= :claimNumber AND c.claimKey.claimExtNumber = :claimExtNumber")
})
@EntityListeners(StringTrimListener.class)
@Trim
public class PreClaim extends BaseClaim<PreClaimLine> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final int RSVD_APRVD_BY_NM_LENGTH = 30;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="claim")
	private List<PreClaimLine> claimLines;

	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="claim")
	private Set<PreClaimError> claimErrors;
	
	@Column(name="CLM_OVRD_RUL_CD_1", nullable = false, length = 2)
	private String clmOvrdRulCd1;

	@Column(name="CLM_OVRD_RUL_CD_10", nullable = false, length = 2)
	private String clmOvrdRulCd10;

	@Column(name="CLM_OVRD_RUL_CD_2", nullable = false, length = 2)
	private String clmOvrdRulCd2;

	@Column(name="CLM_OVRD_RUL_CD_3", nullable = false, length = 2)
	private String clmOvrdRulCd3;

	@Column(name="CLM_OVRD_RUL_CD_4", nullable = false, length = 2)
	private String clmOvrdRulCd4;

	@Column(name="CLM_OVRD_RUL_CD_5", nullable = false, length = 2)
	private String clmOvrdRulCd5;

	@Column(name="CLM_OVRD_RUL_CD_6", nullable = false, length = 2)
	private String clmOvrdRulCd6;

	@Column(name="CLM_OVRD_RUL_CD_7", nullable = false, length = 2)
	private String clmOvrdRulCd7;

	@Column(name="CLM_OVRD_RUL_CD_8", nullable = false, length = 2)
	private String clmOvrdRulCd8;

	@Column(name="CLM_OVRD_RUL_CD_9", nullable = false, length = 2)
	private String clmOvrdRulCd9;

	@Column(name="RSVD_APRVD_BY_BYPASS_CD", nullable = false, length = 1)
	private String rsvdAprvdByBypassCd;

	@Column(name="RSVD_APRVD_BY_NM", nullable = false, length = RSVD_APRVD_BY_NM_LENGTH)
	private String rsvdAprvdByNm;

	@Temporal(TemporalType.DATE)
	@Column(name="RSVD_ISU_DT", nullable = false)
	private Date rsvdIsuDt;

	@Column(name="RSVD_SRC_CD", nullable = false, length = 1)
	private String rsvdSrcCd;
	
	@Column(name="CLM_PP_NM", nullable=false, length=60)
	private String clmPpNm;

	@Column(name="CLM_AFF_ELIG_CD", nullable=false, length=2)
	private String clmAffEligCd;
	
	public PreClaim() {
	}
	
	public ClaimKey getClaimKey() {
		return claimKey;
	}

	public void setClaimKey(ClaimKey claimKey) {
		this.claimKey = claimKey;
	}

	public String getClmOvrdRulCd1() {
		return this.clmOvrdRulCd1;
	}

	public void setClmOvrdRulCd1(String clmOvrdRulCd1) {
		this.clmOvrdRulCd1 = clmOvrdRulCd1;
	}

	public String getClmOvrdRulCd10() {
		return this.clmOvrdRulCd10;
	}

	public void setClmOvrdRulCd10(String clmOvrdRulCd10) {
		this.clmOvrdRulCd10 = clmOvrdRulCd10;
	}

	public String getClmOvrdRulCd2() {
		return this.clmOvrdRulCd2;
	}

	public void setClmOvrdRulCd2(String clmOvrdRulCd2) {
		this.clmOvrdRulCd2 = clmOvrdRulCd2;
	}

	public String getClmOvrdRulCd3() {
		return this.clmOvrdRulCd3;
	}

	public void setClmOvrdRulCd3(String clmOvrdRulCd3) {
		this.clmOvrdRulCd3 = clmOvrdRulCd3;
	}

	public String getClmOvrdRulCd4() {
		return this.clmOvrdRulCd4;
	}

	public void setClmOvrdRulCd4(String clmOvrdRulCd4) {
		this.clmOvrdRulCd4 = clmOvrdRulCd4;
	}

	public String getClmOvrdRulCd5() {
		return this.clmOvrdRulCd5;
	}

	public void setClmOvrdRulCd5(String clmOvrdRulCd5) {
		this.clmOvrdRulCd5 = clmOvrdRulCd5;
	}

	public String getClmOvrdRulCd6() {
		return this.clmOvrdRulCd6;
	}

	public void setClmOvrdRulCd6(String clmOvrdRulCd6) {
		this.clmOvrdRulCd6 = clmOvrdRulCd6;
	}

	public String getClmOvrdRulCd7() {
		return this.clmOvrdRulCd7;
	}

	public void setClmOvrdRulCd7(String clmOvrdRulCd7) {
		this.clmOvrdRulCd7 = clmOvrdRulCd7;
	}

	public String getClmOvrdRulCd8() {
		return this.clmOvrdRulCd8;
	}

	public void setClmOvrdRulCd8(String clmOvrdRulCd8) {
		this.clmOvrdRulCd8 = clmOvrdRulCd8;
	}

	public String getClmOvrdRulCd9() {
		return this.clmOvrdRulCd9;
	}

	public void setClmOvrdRulCd9(String clmOvrdRulCd9) {
		this.clmOvrdRulCd9 = clmOvrdRulCd9;
	}

	public String getRsvdAprvdByBypassCd() {
		return this.rsvdAprvdByBypassCd;
	}

	public void setRsvdAprvdByBypassCd(String rsvdAprvdByBypassCd) {
		this.rsvdAprvdByBypassCd = rsvdAprvdByBypassCd;
	}

	public String getRsvdAprvdByNm() {
		return this.rsvdAprvdByNm;
	}

	public void setRsvdAprvdByNm(String rsvdAprvdByNm) {
		this.rsvdAprvdByNm = rsvdAprvdByNm;
	}

	public Date getRsvdIsuDt() {
		return this.rsvdIsuDt;
	}

	public void setRsvdIsuDt(Date rsvdIsuDt) {
		this.rsvdIsuDt = rsvdIsuDt;
	}

	public String getRsvdSrcCd() {
		return this.rsvdSrcCd;
	}

	public void setRsvdSrcCd(String rsvdSrcCd) {
		this.rsvdSrcCd = rsvdSrcCd;
	}
		
	public List<PreClaimLine> getClaimLines() {
		return this.claimLines;
	}

	public void setClaimLines(List<PreClaimLine> claimLines) {
		this.claimLines = claimLines;
	}

	public Set<PreClaimError> getClaimErrors() {
		return this.claimErrors;
	}

	public void setClaimErrors(Set<PreClaimError> claimErrors) {
		this.claimErrors = claimErrors;
	}

	public String getClmPpNm() {
		return clmPpNm;
	}

	public void setClmPpNm(String clmPpNm) {
		this.clmPpNm = clmPpNm;
	}

	public String getClmAffEligCd() {
		return clmAffEligCd;
	}

	public void setClmAffEligCd(String clmAffEligCd) {
		this.clmAffEligCd = clmAffEligCd;
	}

}

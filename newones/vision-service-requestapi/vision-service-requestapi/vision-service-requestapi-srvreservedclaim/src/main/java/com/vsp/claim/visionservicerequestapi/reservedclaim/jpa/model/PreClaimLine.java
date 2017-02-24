package com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.vsp.claim.common.model.jpa.BaseClaimLine;
import com.vsp.jpa.StringTrimListener;
import com.vsp.jpa.Trim;


/**
 * The persistent class for the CLM2343T database table.
 * 
 */
@Entity
@Table(name="CLM2343T",uniqueConstraints = {@UniqueConstraint(columnNames={"CLM_NBR", "CLM_EXT_NBR", "CLMLN_NBR"})})
@Trim
@EntityListeners(StringTrimListener.class)
public class PreClaimLine extends BaseClaimLine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final int CLMLN_PIC_NM_LENGTH = 50;
	private static final int CLMLN_USD_ALOW_AMT_LENGTH = 9;
	private static final int CLMLN_USD_ALOW_AMT_SCALE = 2;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="CLM_EXT_NBR", referencedColumnName="CLM_EXT_NBR", nullable=false, updatable=false, insertable=false),
		@JoinColumn(name="CLM_NBR", referencedColumnName="CLM_NBR", nullable=false, updatable=false, insertable=false)
	})
	private PreClaim claim;

	@Column(name="CLMLN_OVRD_ELG_IND", nullable=false, length=1)
	private String clmlnOvrdElgInd;

	@Column(name="CLMLN_PIC_NM", nullable=false, length=CLMLN_PIC_NM_LENGTH)
	private String clmlnPicNm;

	@Temporal(TemporalType.DATE)
	@Column(name="CLMLN_RSVD_BEGIN_DT", nullable=false)
	private Date clmlnRsvdBeginDt;

	@Temporal(TemporalType.DATE)
	@Column(name="CLMLN_RSVD_END_DT", nullable =false)
	private Date clmlnRsvdEndDt;

	@Column(name="CLMLN_USD_ALOW_AMT", nullable=false, length=CLMLN_USD_ALOW_AMT_LENGTH, scale=CLMLN_USD_ALOW_AMT_SCALE)
	private BigDecimal clmlnUsdAlowAmt;


	public PreClaimLine() {
	}

	public String getClmlnOvrdElgInd() {
		return this.clmlnOvrdElgInd;
	}

	public void setClmlnOvrdElgInd(String clmlnOvrdElgInd) {
		this.clmlnOvrdElgInd = clmlnOvrdElgInd;
	}

	public String getClmlnPicNm() {
		return this.clmlnPicNm;
	}

	public void setClmlnPicNm(String clmlnPicNm) {
		this.clmlnPicNm = clmlnPicNm;
	}
	
	public Date getClmlnRsvdBeginDt() {
		return this.clmlnRsvdBeginDt;
	}

	public void setClmlnRsvdBeginDt(Date clmlnRsvdBeginDt) {
		this.clmlnRsvdBeginDt = clmlnRsvdBeginDt;
	}

	public Date getClmlnRsvdEndDt() {
		return this.clmlnRsvdEndDt;
	}

	public void setClmlnRsvdEndDt(Date clmlnRsvdEndDt) {
		this.clmlnRsvdEndDt = clmlnRsvdEndDt;
	}

	public BigDecimal getClmlnUsdAlowAmt() {
		return this.clmlnUsdAlowAmt;
	}

	public void setClmlnUsdAlowAmt(BigDecimal clmlnUsdAlowAmt) {
		this.clmlnUsdAlowAmt = clmlnUsdAlowAmt;
	}
	
	public PreClaim getClaim() {
		return claim;
	}

	public void setClaim(PreClaim claim) {
		this.claim = claim;
	}

}
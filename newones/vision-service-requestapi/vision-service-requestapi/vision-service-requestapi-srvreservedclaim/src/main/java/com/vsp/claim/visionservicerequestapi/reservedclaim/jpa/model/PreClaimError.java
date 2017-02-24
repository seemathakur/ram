package com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.vsp.claim.common.model.jpa.BaseClaimError;
import com.vsp.jpa.StringTrimListener;
import com.vsp.jpa.Trim;


/**
 * The persistent class for the CLM2344T database table.
 * 
 */

@Trim
@EntityListeners(StringTrimListener.class)
@Entity
@Table(name="CLM2344T",uniqueConstraints = {@UniqueConstraint(columnNames={"CLM_NBR", "CLM_EXT_NBR", "ERROR_CATEGORY", "ID", "ERROR_NBR" })})
public class PreClaimError extends BaseClaimError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="CLM_EXT_NBR", referencedColumnName="CLM_EXT_NBR", nullable=false, updatable=false, insertable=false),
		@JoinColumn(name="CLM_NBR", referencedColumnName="CLM_NBR", nullable=false, updatable=false, insertable=false)
	})
	private PreClaim claim;
	
	public PreClaimError() {
	}

	public PreClaim getClaim() {
		return claim;
	}

	public void setClaim(PreClaim claim) {
		this.claim = claim;
	}

}
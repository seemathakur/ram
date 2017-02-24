package com.vsp.claim.visionservicerequestapi.reservedclaim.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vsp.claim.common.mapping.factory.api.ClaimDefaults;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;

@Repository("claimKeyDao")
@Transactional
public class ClaimKeyDao { 
	
	@PersistenceContext(unitName = "reservedClaimEntityManagerFactory")
	private EntityManager entityManager; 
	
	private static final Logger LOG = LoggerFactory.getLogger(ClaimKeyDao.class);
	
	public Integer getClaimNumber() {
		int procedureResult = ClaimDefaults.EMPTY_INTEGER;
		DebugLogger.debugEnabled(LOG, "execute query");
		
		Query q = entityManager.createNativeQuery(
				"SELECT NEXT VALUE FOR {h-schema}CLMS0001 FROM SYSIBM.SYSDUMMY1 WITH UR");
		List<?> resultList = q.getResultList();
		procedureResult = (Integer)resultList.get(0);
		
		DebugLogger.debugEnabled(LOG, "Generated claim number = {}", procedureResult);
		return procedureResult;
	}

}

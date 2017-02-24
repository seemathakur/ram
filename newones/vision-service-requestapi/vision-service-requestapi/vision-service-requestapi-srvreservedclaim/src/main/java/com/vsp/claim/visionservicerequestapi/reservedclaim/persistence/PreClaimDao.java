package com.vsp.claim.visionservicerequestapi.reservedclaim.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;
import com.vsp.il.util.NameValuePair;

@Repository("preClaimDao")
public class PreClaimDao {
	
	@PersistenceContext(unitName = "reservedClaimEntityManagerFactory")
	private EntityManager entityManager;

	public PreClaim create(PreClaim preClaim) {
		return createEntity(preClaim);
	}
	
	public PreClaim update(PreClaim preClaim) {
		return updateEntity(preClaim);
	}
	
	public PreClaim delete(PreClaim preClaim) {
		PreClaim mergeResult = entityManager.merge(preClaim);
		entityManager.remove(preClaim);
		entityManager.flush();
		return mergeResult;
	}
	
	public PreClaim deleteLine(PreClaim preClaim, PreClaimLine preClaimLine) {
		preClaim.getClaimLines().remove(preClaimLine);
		return removeDependentEntity(preClaim, preClaimLine);
	}
  
	private <T> T createEntity(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}
	
	private <T> T updateEntity(T entity) {
		T mergeResult = entityManager.merge(entity);
		entityManager.flush();
		return mergeResult;
	}
	
	private PreClaim removeDependentEntity(PreClaim preClaim, PreClaimLine dependentEntity) {
		PreClaim mergeResult = entityManager.merge(preClaim);
		entityManager.remove(dependentEntity);
		entityManager.flush();
		return mergeResult;
	}
	
	public PreClaim retrieveByClaimKey(List<NameValuePair> claimKeyCriteria) {		
		Query query = createGetPreClaimByKeyQuery();
		setQueryParameters(query, claimKeyCriteria);
		
		return (PreClaim) query.getSingleResult();
	}

	private Query createGetPreClaimByKeyQuery() {
		return entityManager.createNamedQuery("getPreClaimByKey");
	}
	
	private void setQueryParameters(Query query, List<NameValuePair> criteria) {
		for(NameValuePair criterion : criteria) {
			query.setParameter(criterion.getName(), criterion.getValue());
		}
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	
	
	public List<PreClaim> search(List<NameValuePair> criteria){
		SearchCriteriaQueryBuilder builder = new SearchCriteriaQueryBuilder(entityManager.getCriteriaBuilder(), criteria); 
		TypedQuery<PreClaim> query = entityManager.createQuery(builder.buildQuery());
		return query.getResultList(); 
	}
		
}

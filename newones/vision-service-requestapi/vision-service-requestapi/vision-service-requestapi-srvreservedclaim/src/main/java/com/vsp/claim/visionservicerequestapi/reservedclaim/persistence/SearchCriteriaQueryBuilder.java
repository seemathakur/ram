package com.vsp.claim.visionservicerequestapi.reservedclaim.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;
import com.vsp.il.util.NameValuePair;

public class SearchCriteriaQueryBuilder {
	
	private CriteriaBuilder criteriaBuilder;
	private List<NameValuePair> searchCriteria; 
	
	public SearchCriteriaQueryBuilder(CriteriaBuilder criteriaBuilder, List<NameValuePair> searchCriteria){
		this.criteriaBuilder = criteriaBuilder;
		this.searchCriteria = searchCriteria;
	}
	
	public CriteriaQuery<PreClaim> buildQuery(){
		CriteriaQuery<PreClaim> query = createCriteriaQuery();  

		Root<PreClaim> preClaim = buildFromClause(query); 
		query = buildSelectClause(query, preClaim); 
		query = buildWhereClause(query, preClaim); 
				
		return query;
	}

	private CriteriaQuery<PreClaim> createCriteriaQuery() {
		return criteriaBuilder.createQuery(PreClaim.class);
	}

	private Root<PreClaim> buildFromClause(CriteriaQuery<PreClaim> query) {
		return query.from(PreClaim.class); 
	}

	private CriteriaQuery<PreClaim> buildSelectClause(CriteriaQuery<PreClaim> query, Root<PreClaim> claimLocation) {
		return query.select(claimLocation); 
	}

	private CriteriaQuery<PreClaim> buildWhereClause(CriteriaQuery<PreClaim> query, Root<PreClaim> claimLocation) {
		Predicate predicate = criteriaBuilder.conjunction();
		
		for(NameValuePair criteria: searchCriteria){
			predicate = criteriaBuilder.and(predicate, buildPredicate(claimLocation, criteria));
		}
		 
		query.where(predicate); 
		
		return query;  
	}

	private Predicate buildPredicate(Root<PreClaim> claimLocation, NameValuePair criteria) {
		return claimLocation.get(getName(criteria)).in(getValue(criteria));
		
	}

	private String getName(NameValuePair criteria) {
		return criteria.getName();  
	}

	private Object getValue(NameValuePair criteria) {
		return criteria.getValue(); 
	}

}

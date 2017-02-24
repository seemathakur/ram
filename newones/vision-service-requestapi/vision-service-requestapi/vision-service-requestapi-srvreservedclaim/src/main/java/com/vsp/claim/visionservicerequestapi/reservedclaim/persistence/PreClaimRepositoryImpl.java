package com.vsp.claim.visionservicerequestapi.reservedclaim.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.Claims;
import com.vsp.claim.common.model.jpa.ClaimErrorKey;
import com.vsp.claim.common.model.jpa.ClaimLineKey;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimError;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.PreClaimMapper;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimLineNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.ClaimNotFoundException;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.il.util.NameValuePair;

@Repository
public class PreClaimRepositoryImpl implements PreClaimRepository {
	
	private static final int CLAIM_NUMBER_INDEX = 0;
	private static final int CLAIM_EXT_NUMBER_INDEX = 1;
		
	@Autowired
	private PreClaimDao preClaimDao;
	
	@Autowired
	private ClaimKeyDao claimKeyDao;
	
	private PreClaimMapper mapper;
	
	private String logMsg;
	
	private static final Logger LOG = LoggerFactory.getLogger(PreClaimRepositoryImpl.class);
	
	public PreClaimRepositoryImpl() {
		mapper = PreClaimMapper.getInstance();
	}
	
	@Override
	public Claim retrieve(ClaimKey claimKey) throws ClaimNotFoundException, DatabaseIOException {
		Claim result = new Claim();
		PreClaim daoResult = retrieveFromDao(claimKey);		
		result = mapToClaim(daoResult);
		if(result != null){
			DebugLogger.debugEnabled(LOG, "Claim with ClaimNumber {} and ExtensionNumber {} retrieved using a claimKey of: {}",
					result.getClaimKey().getClaimNumber(), result.getClaimKey().getClaimExtNumber(), daoResult.getClaimKey());
		}
		return result;
	}
	
	public Claim create(Claim claim) throws DatabaseIOException {
		Claim result = new Claim();
		claim = setClaimNumberOnClaim(claim); 
		claim = setLineNumbersOnClaim(claim); 
		PreClaim preclaim = mapToPreClaim(claim);
		PreClaim daoResult = createToDao(preclaim);
		result = mapToClaim(daoResult);
		if(result.getClaimKey() != null){
			DebugLogger.debugEnabled(LOG, "Claim created: ClaimNumber {}, ExtensionNumber {}", result.getClaimKey().getClaimNumber(), result.getClaimKey().getClaimExtNumber());
		}
		return result;
	}
	
	private Claim setClaimNumberOnClaim(Claim claim) {
		Claim toReturn = claim;
		if(claimDoesNotHaveClaimNumber(claim)){
			ClaimKeyBuilderCommand command = new ClaimKeyBuilderCommand(claimKeyDao);
			command.run();
			toReturn.setClaimKey(command.getReturnValue());
		}
		return toReturn;
	}

	private boolean claimDoesNotHaveClaimNumber(Claim claim) {
		ClaimKey claimKey = claim.getClaimKey();
		return claimKey == null || claimKey.getClaimNumber().isEmpty();
	}

	private Claim setLineNumbersOnClaim(Claim claim) {
		int num = 1; 
		Claim toReturn = claim;
		if(hasClaimLines(claim.getClaimLines())){
			for(ClaimLine claimLine : claim.getClaimLines()){
				claimLine.setLineNumber(num++);
			}
		}
		return toReturn;
	}

	private boolean hasClaimLines(List<ClaimLine> claimLines) {
		return claimLines != null && !claimLines.isEmpty(); 
	}

	private PreClaim retrieveFromDao(ClaimKey claimKey) 
			throws ClaimNotFoundException, DatabaseIOException {
		List<NameValuePair> claimKeySearchCriteria = buildClaimKeySearchCriteria(claimKey);
		return retrieveFromDao(claimKeySearchCriteria);
	}

	private List<NameValuePair> buildClaimKeySearchCriteria(ClaimKey claimKey) {
		List<NameValuePair> criteria = new ArrayList<NameValuePair>();
		
		criteria.add(new NameValuePair("claimNumber", claimKey.getClaimNumber()));
		criteria.add(new NameValuePair("claimExtNumber", claimKey.getClaimExtNumber()));
		if(!criteria.isEmpty()){
			DebugLogger.debugEnabled(LOG, "Claim key search criteria contains: {} {}", criteria.get(CLAIM_NUMBER_INDEX), criteria.get(CLAIM_EXT_NUMBER_INDEX));
		}
		return criteria;
	}
	
	private PreClaim retrieveFromDao(List<NameValuePair> claimKeySearchCriteria) 
			throws ClaimNotFoundException, DatabaseIOException {
		PreClaim result;
		try {
			result = preClaimDao.retrieveByClaimKey(claimKeySearchCriteria);
			if(result == null) {
				LOG.error("Result is empty when using the search criteria: {}", claimKeySearchCriteria.toString());
				ClaimNotFoundException e = new ClaimNotFoundException(claimKeySearchCriteria);
				LOG.error("Result is empty when using the search criteria: {}.  Exception :{}", claimKeySearchCriteria.toString(),
						ExceptionUtils.getStackTrace(e));
				throw new ClaimNotFoundException(claimKeySearchCriteria);
			}
		} catch(NoResultException nre) {
			LOG.error("Claim not found for the given criteria ({}), exception message:{}", claimKeySearchCriteria.toString(), ExceptionUtils.getStackTrace(nre));
			throw new ClaimNotFoundException(claimKeySearchCriteria, nre);
		} catch(PersistenceException | IllegalStateException e) {
			logMsg = "Unable to connect to database for criteria: " + claimKeySearchCriteria;
			DatabaseIOException exception = new DatabaseIOException(logMsg, e);
			LOG.error("{}, Exception :{}",logMsg, ExceptionUtils.getStackTrace(e));
			throw exception;
		}
		if(result != null){
			DebugLogger.debugEnabled(LOG, "Result's claimKey value: {}", result.getClaimKey());
		}
		return result;
	}

	private PreClaim createToDao(PreClaim preClaim)  
			throws DatabaseIOException {
		PreClaim result;
		try {
			result = preClaimDao.create(preClaim);
			
		} catch(Exception e) {
			logMsg = "Unable to connect to database: " + ExceptionUtils.getStackTrace(e);
			LOG.error("Exception: {}", logMsg);
			throw new DatabaseIOException(logMsg);
		}
		if(result != null){
			DebugLogger.debugEnabled(LOG, "Result of createToDao: {}", result.toString());
		}else{
			DebugLogger.debugEnabled(LOG, "Result is null");
		}
		return result;
	}

	private Claim mapToClaim(PreClaim preClaim) {
		if(preClaim != null){
			DebugLogger.debugEnabled(LOG, "mapToClaim Called with preclaim: Claim Number {}, Ext Number {}", 
				preClaim.getClaimKey().getClaimNumber(), preClaim.getClaimKey().getClaimExtNumber());
		}
		return mapper.map(preClaim, Claim.class);
	}
	
	private PreClaim mapToPreClaim(Claim claim) {
		PreClaim preClaim = mapper.map(claim, PreClaim.class);
		setPreClaimLineKeyOnPreClaimLines(preClaim); 
		setPreClaimErrorKeyOnPreClaimErrors(preClaim);
		if(preClaim.getClaimKey() != null && claim.getClaimKey() != null){
			DebugLogger.debugEnabled(LOG, "Mapping the api-gb claim model object to the jpa object");
		}
		return preClaim;
	}
	
	protected PreClaim setPreClaimErrorKeyOnPreClaimErrors(PreClaim preClaim) {
		com.vsp.claim.common.model.jpa.ClaimKey key = preClaim.getClaimKey(); 
		List<PreClaimError> preClaimErrors = new ArrayList<PreClaimError>();
				
		if(hasPreClaimErrors(preClaim.getClaimErrors())){
			preClaimErrors.addAll(preClaim.getClaimErrors()); 
			for(PreClaimError preClaimError : preClaimErrors){
				setPreClaimErrorKey(preClaimError, key) ;
			}
		}
		return preClaim;
	}

	private void setPreClaimErrorKey(PreClaimError preClaimError,
			com.vsp.claim.common.model.jpa.ClaimKey key) {
		ClaimErrorKey errorKey = preClaimError.getErrorKey();
		errorKey.setClaimNumber(key.getClaimNumber());
		errorKey.setClaimExtNumber(key.getClaimExtNumber());
		
		preClaimError.setErrorKey(errorKey);
		if(preClaimError.getClaim() != null && errorKey.getErrorNumber() !=null){
			DebugLogger.debugEnabled(LOG, "Claim key {} , error number {}", preClaimError.getClaim().getClaimKey(), errorKey.getErrorNumber());
		}
	}

	private boolean hasPreClaimErrors(Set<PreClaimError> preClaimErrors) {
		return preClaimErrors !=null;
	}

	protected PreClaim setPreClaimLineKeyOnPreClaimLines(PreClaim preClaim){
		com.vsp.claim.common.model.jpa.ClaimKey key = preClaim.getClaimKey(); 
		List<PreClaimLine> preClaimLines = preClaim.getClaimLines(); 
		
		if(hasPreClaimLines(preClaimLines)){
			for(PreClaimLine preClaimLine : preClaimLines){
				setPreClaimLineKey(preClaimLine, key); 
			}
		}else{
			DebugLogger.debugEnabled(LOG, "Claim key does not have preClaimLines");
		}

		return preClaim; 
	}
	
	private boolean hasPreClaimLines(List<PreClaimLine> preClaimLines){
		return preClaimLines != null;
	}
	
	private void setPreClaimLineKey(PreClaimLine preClaimLine, com.vsp.claim.common.model.jpa.ClaimKey claimKey){
		ClaimLineKey claimLineKey = preClaimLine.getClaimLineKey(); 
		claimLineKey.setClaimNumber(claimKey.getClaimNumber());
		claimLineKey.setClaimExtNumber(claimKey.getClaimExtNumber());
		
		preClaimLine.setClaimLineKey(claimLineKey);
		if(preClaimLine.getClaimLineKey() != null){
		DebugLogger.debugEnabled(LOG, "PreClaimLine set with claimLineKey with ClaimNumber {} and ClaimExtNumber {}",
				preClaimLine.getClaimLineKey().getClaimNumber(), preClaimLine.getClaimLineKey().getClaimExtNumber());
		}
	}
	
	@Override
	public Claims search(List<NameValuePair> criteria) {
		List<PreClaim> searchResults = preClaimDao.search(criteria);
		return mapToClaims(searchResults);
	}

	private Claims mapToClaims(List<PreClaim> preClaims) {
		Claims claims = new Claims(); 
		if(preClaims != null){
			for(PreClaim preClaim:preClaims){
				claims.add(mapToClaim(preClaim));
			}
		}
		return claims;
	}

	@Override
	public Claim update(Claim claim) throws DatabaseIOException {
		claim = setLineNumbersOnClaim(claim); 
		PreClaim daoRequest = mapToPreClaim(claim);
		PreClaim daoResponse = update(daoRequest);
		return mapToClaim(daoResponse);
	}
	
	private PreClaim update(PreClaim preClaim) throws DatabaseIOException {
		try {
			return preClaimDao.update(preClaim);
		} catch(IllegalArgumentException | PersistenceException databaseException) {
			logMsg = makePersistenceErrorMessage(preClaim.getClaimKey(), PreClaim.class);
			LOG.error("Update Database error, " + logMsg);
			throw new DatabaseIOException(logMsg, databaseException);
		} 
	}
	
	private String makePersistenceErrorMessage(com.vsp.claim.common.model.jpa.ClaimKey claimKey, Class<?> clazz) {
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append("Unable to persist: ")
			.append(clazz.getName())
			.append(claimKey.getClaimNumber())
			.append("-")
			.append(claimKey.getClaimExtNumber());
		return errorMessage.toString();
	}

	@Override
	public Claim delete(ClaimKey claimKey) throws DatabaseIOException, ClaimNotFoundException {
		PreClaim deletedClaim = preClaimDao.delete(retrieveFromDao(claimKey));
		return mapToClaim(deletedClaim); 
	}
	
	@Override
	public ClaimLine deleteLine(ClaimKey key, Integer lineNumber) throws DatabaseIOException, ClaimNotFoundException, ClaimLineNotFoundException {
		return removeLineFromClaim(retrieveFromDao(key),lineNumber);
	}
	
	private ClaimLine removeLineFromClaim(PreClaim preClaim, Integer lineNumber) throws ClaimLineNotFoundException, DatabaseIOException {
		PreClaimLine preClaimLine = retrievePreClaimLineByLineNumber(preClaim, lineNumber);
		try {
			preClaimDao.deleteLine(preClaim, preClaimLine);
		} catch(IllegalArgumentException | PersistenceException databaseException) {
			String message = "Unable to connect to database to remove line from claim: line number " + lineNumber;
			LOG.error(message);
			throw new DatabaseIOException(message, databaseException);
		}
		if(preClaimLine.getClaimLineKey() != null){
			DebugLogger.debugEnabled(LOG, "PreClaimLine {} removed from preClaim with claim number {}", 
					preClaimLine.getClaimLineKey().getLineNumber(), preClaim.getClaimKey().getClaimNumber());
		}
		
		return mapper.map(preClaimLine, ClaimLine.class);
	}

	public PreClaimLine retrievePreClaimLineByLineNumber(PreClaim preClaim, int lineNumber) throws ClaimLineNotFoundException {
		PreClaimLine preClaimLine = null;
		int i = 0;
		for (PreClaimLine line : preClaim.getClaimLines()) {
			if (line.getClaimLineKey().getLineNumber() == lineNumber) {
				preClaimLine = line;
				break;
			}
			i++;
		}
		if(preClaim.getClaimLines().size() <= i){
			String message = "Claim not found for lineNumber: " + lineNumber;
			ClaimLineNotFoundException e = new ClaimLineNotFoundException(message);
			LOG.error("preClaim ClaimLines size smaller than the requested lineNumber: {}, ClaimLineNotFoundException: {}", message, ExceptionUtils.getStackTrace(e));
			throw e; 
		}
		if(preClaimLine != null){
			DebugLogger.debugEnabled(LOG, "Retrieved lineNumber {}: claim number {}", lineNumber, preClaimLine.getClaimLineKey().getClaimNumber());
		}
		
		return preClaimLine;
	}
}

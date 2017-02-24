package com.vsp.claim.visionservicerequestapi.reservedclaim.mapping;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.TypeFactory;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimError;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.common.mapping.ConfigurableClaimMapper;
import com.vsp.claim.common.mapping.DiagnosisCodesMapper;
import com.vsp.claim.common.mapping.DiagnosisPointerMapper;
import com.vsp.claim.common.model.jpa.BaseClaim;
import com.vsp.claim.common.model.jpa.BaseClaimError;
import com.vsp.claim.common.model.jpa.BaseClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimError;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.factories.PreClaimErrorFactory;
import com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.factories.PreClaimFactory;
import com.vsp.claim.visionservicerequestapi.reservedclaim.mapping.factories.PreClaimLineFactory;

public final class PreClaimMapper extends ConfigurableClaimMapper {
	private static PreClaimMapper instance;

	private PreClaimMapper() {
		super();
	}
	
	public static PreClaimMapper getInstance(){
		if(instance == null){
			instance = new PreClaimMapper(); 
		}
		return instance;
	}

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);
		configurePreClaimMapper(factory);
		configurePreClaimLineMapper(factory);
		configurePreClaimErrorMapper(factory);
		registerPreClaimFactories(factory);
	}
	
	private void configurePreClaimMapper(MapperFactory factory) {
		factory.classMap(PreClaim.class, Claim.class)
				.use(BaseClaim.class, Claim.class)
				.mapNulls(false).mapNullsInReverse(false)
				.field("clmOvrdRulCd1", "overrideRuleCodes[0]")
				.field("clmOvrdRulCd2", "overrideRuleCodes[1]")
				.field("clmOvrdRulCd3", "overrideRuleCodes[2]")
				.field("clmOvrdRulCd4", "overrideRuleCodes[3]")
				.field("clmOvrdRulCd5", "overrideRuleCodes[4]")
				.field("clmOvrdRulCd6", "overrideRuleCodes[5]")
				.field("clmOvrdRulCd7", "overrideRuleCodes[6]")
				.field("clmOvrdRulCd8", "overrideRuleCodes[7]")
				.field("clmOvrdRulCd9", "overrideRuleCodes[8]")
				.field("clmOvrdRulCd10", "overrideRuleCodes[9]")
				.field("clmPpNm", "productPackageName")
				.field("rsvdAprvdByBypassCd", "reservationApprovedByBypassCode")
				.field("rsvdAprvdByNm", "reservationApprovedByName")
				.field("rsvdIsuDt", "reservationIssueDate")
				.field("rsvdSrcCd", "reservationSourceCode")
				.field("clmAffEligCd", "affectEligibilityCode")
				.customize(new DiagnosisCodesMapper<PreClaim, PreClaimLine>())
				.byDefault()
				.register();
	}
	
	private void configurePreClaimLineMapper(MapperFactory factory) {
		factory.classMap(PreClaimLine.class, ClaimLine.class)
		.use(BaseClaimLine.class, ClaimLine.class)
		.mapNulls(false).mapNullsInReverse(false)
			.field("clmlnOvrdElgInd", "overrideEligibilityIndicator")
			.field("clmlnPicNm", "productCatalogKey")
			.field("clmlnRsvdBeginDt", "reservationInterval.begin")
			.field("clmlnRsvdEndDt", "reservationInterval.end")
			.field("clmlnSvcCopamt","serviceCopayAmount")
			.field("clmlnUsdAlowAmt", "allowanceUsedAmount")
			.customize(new DiagnosisPointerMapper<PreClaimLine>()) 
			.byDefault()
			.register();
	}
	
	private void configurePreClaimErrorMapper(MapperFactory factory){
		factory.classMap(PreClaimError.class, ClaimError.class)
		.use(BaseClaimError.class, ClaimError.class)
		.byDefault()
		.register(); 
	}
	
	private void registerPreClaimFactories(MapperFactory factory) {
		factory.registerObjectFactory(new PreClaimFactory(), 
				TypeFactory.valueOf(PreClaim.class));
		factory.registerObjectFactory(new PreClaimLineFactory(), 
				TypeFactory.valueOf(PreClaimLine.class));
		factory.registerObjectFactory(new PreClaimErrorFactory(), 
				TypeFactory.valueOf(PreClaimError.class));
	}
}

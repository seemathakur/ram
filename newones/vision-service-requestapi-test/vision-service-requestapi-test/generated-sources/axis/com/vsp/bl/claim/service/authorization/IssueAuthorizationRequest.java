/**
 * IssueAuthorizationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class IssueAuthorizationRequest  extends com.vsp.bl.service.v001.ServiceRequest  implements java.io.Serializable {
    private com.vsp.bl.consumer.dto.member.v001.MemberKey[] akaMembers;

    private com.vsp.xl.dto.v002.Date asOfDate;

    private com.vsp.bl.consumer.dto.member.v001.MemberKey memberKey;

    private com.vsp.bl.ancillary.dto.personandcontact.v001.Address address;

    private com.vsp.xl.dto.v002.SimpleCode benefitType;

    private java.lang.String classId;

    private java.lang.String cobSSN;

    private java.lang.String drPhoneNumber;

    private java.lang.Boolean isMemberAddress;

    private com.vsp.xl.dto.v002.SimpleCode originationSource;

    private com.vsp.xl.dto.v002.SimpleCode processSource;

    private com.vsp.xl.dto.v002.SimpleCode[] serviceTypes;

    private java.lang.String approvedBy;

    private com.vsp.xl.dto.v002.SimpleCode[] bypassCodes;

    private com.vsp.xl.dto.v002.SimpleCode claimCode;

    private com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey previousAuthorizationKey;

    private java.lang.Boolean replacePreviousAuthorization;

    private java.lang.String comments;

    private java.lang.String faxNumber;

    private java.lang.Boolean validateEligibility;

    private com.vsp.xl.dto.v002.SimpleCode coverageType;

    private com.vsp.bl.consumer.dto.plan.v004.BenefitSummary benefitOverrides;

    private java.lang.Boolean affectsFutureEligibility;

    private java.lang.Boolean issueWithSuspend;

    private java.lang.Boolean addMemberIndicator;

    private java.lang.String memberID9Digit;

    private com.vsp.bl.ancillary.dto.personandcontact.v001.Name memberName;

    private com.vsp.xl.dto.v002.Date memberDOB;

    public IssueAuthorizationRequest() {
    }

    public IssueAuthorizationRequest(
           java.lang.String serviceThreadId,
           java.lang.String businessTransactionId,
           java.lang.String requesterProcessName,
           java.lang.String userId,
           com.vsp.bl.consumer.dto.member.v001.MemberKey[] akaMembers,
           com.vsp.xl.dto.v002.Date asOfDate,
           com.vsp.bl.consumer.dto.member.v001.MemberKey memberKey,
           com.vsp.bl.ancillary.dto.personandcontact.v001.Address address,
           com.vsp.xl.dto.v002.SimpleCode benefitType,
           java.lang.String classId,
           java.lang.String cobSSN,
           java.lang.String drPhoneNumber,
           java.lang.Boolean isMemberAddress,
           com.vsp.xl.dto.v002.SimpleCode originationSource,
           com.vsp.xl.dto.v002.SimpleCode processSource,
           com.vsp.xl.dto.v002.SimpleCode[] serviceTypes,
           java.lang.String approvedBy,
           com.vsp.xl.dto.v002.SimpleCode[] bypassCodes,
           com.vsp.xl.dto.v002.SimpleCode claimCode,
           com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey previousAuthorizationKey,
           java.lang.Boolean replacePreviousAuthorization,
           java.lang.String comments,
           java.lang.String faxNumber,
           java.lang.Boolean validateEligibility,
           com.vsp.xl.dto.v002.SimpleCode coverageType,
           com.vsp.bl.consumer.dto.plan.v004.BenefitSummary benefitOverrides,
           java.lang.Boolean affectsFutureEligibility,
           java.lang.Boolean issueWithSuspend,
           java.lang.Boolean addMemberIndicator,
           java.lang.String memberID9Digit,
           com.vsp.bl.ancillary.dto.personandcontact.v001.Name memberName,
           com.vsp.xl.dto.v002.Date memberDOB) {
        super(
            serviceThreadId,
            businessTransactionId,
            requesterProcessName,
            userId);
        this.akaMembers = akaMembers;
        this.asOfDate = asOfDate;
        this.memberKey = memberKey;
        this.address = address;
        this.benefitType = benefitType;
        this.classId = classId;
        this.cobSSN = cobSSN;
        this.drPhoneNumber = drPhoneNumber;
        this.isMemberAddress = isMemberAddress;
        this.originationSource = originationSource;
        this.processSource = processSource;
        this.serviceTypes = serviceTypes;
        this.approvedBy = approvedBy;
        this.bypassCodes = bypassCodes;
        this.claimCode = claimCode;
        this.previousAuthorizationKey = previousAuthorizationKey;
        this.replacePreviousAuthorization = replacePreviousAuthorization;
        this.comments = comments;
        this.faxNumber = faxNumber;
        this.validateEligibility = validateEligibility;
        this.coverageType = coverageType;
        this.benefitOverrides = benefitOverrides;
        this.affectsFutureEligibility = affectsFutureEligibility;
        this.issueWithSuspend = issueWithSuspend;
        this.addMemberIndicator = addMemberIndicator;
        this.memberID9Digit = memberID9Digit;
        this.memberName = memberName;
        this.memberDOB = memberDOB;
    }


    /**
     * Gets the akaMembers value for this IssueAuthorizationRequest.
     * 
     * @return akaMembers
     */
    public com.vsp.bl.consumer.dto.member.v001.MemberKey[] getAkaMembers() {
        return akaMembers;
    }


    /**
     * Sets the akaMembers value for this IssueAuthorizationRequest.
     * 
     * @param akaMembers
     */
    public void setAkaMembers(com.vsp.bl.consumer.dto.member.v001.MemberKey[] akaMembers) {
        this.akaMembers = akaMembers;
    }


    /**
     * Gets the asOfDate value for this IssueAuthorizationRequest.
     * 
     * @return asOfDate
     */
    public com.vsp.xl.dto.v002.Date getAsOfDate() {
        return asOfDate;
    }


    /**
     * Sets the asOfDate value for this IssueAuthorizationRequest.
     * 
     * @param asOfDate
     */
    public void setAsOfDate(com.vsp.xl.dto.v002.Date asOfDate) {
        this.asOfDate = asOfDate;
    }


    /**
     * Gets the memberKey value for this IssueAuthorizationRequest.
     * 
     * @return memberKey
     */
    public com.vsp.bl.consumer.dto.member.v001.MemberKey getMemberKey() {
        return memberKey;
    }


    /**
     * Sets the memberKey value for this IssueAuthorizationRequest.
     * 
     * @param memberKey
     */
    public void setMemberKey(com.vsp.bl.consumer.dto.member.v001.MemberKey memberKey) {
        this.memberKey = memberKey;
    }


    /**
     * Gets the address value for this IssueAuthorizationRequest.
     * 
     * @return address
     */
    public com.vsp.bl.ancillary.dto.personandcontact.v001.Address getAddress() {
        return address;
    }


    /**
     * Sets the address value for this IssueAuthorizationRequest.
     * 
     * @param address
     */
    public void setAddress(com.vsp.bl.ancillary.dto.personandcontact.v001.Address address) {
        this.address = address;
    }


    /**
     * Gets the benefitType value for this IssueAuthorizationRequest.
     * 
     * @return benefitType
     */
    public com.vsp.xl.dto.v002.SimpleCode getBenefitType() {
        return benefitType;
    }


    /**
     * Sets the benefitType value for this IssueAuthorizationRequest.
     * 
     * @param benefitType
     */
    public void setBenefitType(com.vsp.xl.dto.v002.SimpleCode benefitType) {
        this.benefitType = benefitType;
    }


    /**
     * Gets the classId value for this IssueAuthorizationRequest.
     * 
     * @return classId
     */
    public java.lang.String getClassId() {
        return classId;
    }


    /**
     * Sets the classId value for this IssueAuthorizationRequest.
     * 
     * @param classId
     */
    public void setClassId(java.lang.String classId) {
        this.classId = classId;
    }


    /**
     * Gets the cobSSN value for this IssueAuthorizationRequest.
     * 
     * @return cobSSN
     */
    public java.lang.String getCobSSN() {
        return cobSSN;
    }


    /**
     * Sets the cobSSN value for this IssueAuthorizationRequest.
     * 
     * @param cobSSN
     */
    public void setCobSSN(java.lang.String cobSSN) {
        this.cobSSN = cobSSN;
    }


    /**
     * Gets the drPhoneNumber value for this IssueAuthorizationRequest.
     * 
     * @return drPhoneNumber
     */
    public java.lang.String getDrPhoneNumber() {
        return drPhoneNumber;
    }


    /**
     * Sets the drPhoneNumber value for this IssueAuthorizationRequest.
     * 
     * @param drPhoneNumber
     */
    public void setDrPhoneNumber(java.lang.String drPhoneNumber) {
        this.drPhoneNumber = drPhoneNumber;
    }


    /**
     * Gets the isMemberAddress value for this IssueAuthorizationRequest.
     * 
     * @return isMemberAddress
     */
    public java.lang.Boolean getIsMemberAddress() {
        return isMemberAddress;
    }


    /**
     * Sets the isMemberAddress value for this IssueAuthorizationRequest.
     * 
     * @param isMemberAddress
     */
    public void setIsMemberAddress(java.lang.Boolean isMemberAddress) {
        this.isMemberAddress = isMemberAddress;
    }


    /**
     * Gets the originationSource value for this IssueAuthorizationRequest.
     * 
     * @return originationSource
     */
    public com.vsp.xl.dto.v002.SimpleCode getOriginationSource() {
        return originationSource;
    }


    /**
     * Sets the originationSource value for this IssueAuthorizationRequest.
     * 
     * @param originationSource
     */
    public void setOriginationSource(com.vsp.xl.dto.v002.SimpleCode originationSource) {
        this.originationSource = originationSource;
    }


    /**
     * Gets the processSource value for this IssueAuthorizationRequest.
     * 
     * @return processSource
     */
    public com.vsp.xl.dto.v002.SimpleCode getProcessSource() {
        return processSource;
    }


    /**
     * Sets the processSource value for this IssueAuthorizationRequest.
     * 
     * @param processSource
     */
    public void setProcessSource(com.vsp.xl.dto.v002.SimpleCode processSource) {
        this.processSource = processSource;
    }


    /**
     * Gets the serviceTypes value for this IssueAuthorizationRequest.
     * 
     * @return serviceTypes
     */
    public com.vsp.xl.dto.v002.SimpleCode[] getServiceTypes() {
        return serviceTypes;
    }


    /**
     * Sets the serviceTypes value for this IssueAuthorizationRequest.
     * 
     * @param serviceTypes
     */
    public void setServiceTypes(com.vsp.xl.dto.v002.SimpleCode[] serviceTypes) {
        this.serviceTypes = serviceTypes;
    }


    /**
     * Gets the approvedBy value for this IssueAuthorizationRequest.
     * 
     * @return approvedBy
     */
    public java.lang.String getApprovedBy() {
        return approvedBy;
    }


    /**
     * Sets the approvedBy value for this IssueAuthorizationRequest.
     * 
     * @param approvedBy
     */
    public void setApprovedBy(java.lang.String approvedBy) {
        this.approvedBy = approvedBy;
    }


    /**
     * Gets the bypassCodes value for this IssueAuthorizationRequest.
     * 
     * @return bypassCodes
     */
    public com.vsp.xl.dto.v002.SimpleCode[] getBypassCodes() {
        return bypassCodes;
    }


    /**
     * Sets the bypassCodes value for this IssueAuthorizationRequest.
     * 
     * @param bypassCodes
     */
    public void setBypassCodes(com.vsp.xl.dto.v002.SimpleCode[] bypassCodes) {
        this.bypassCodes = bypassCodes;
    }


    /**
     * Gets the claimCode value for this IssueAuthorizationRequest.
     * 
     * @return claimCode
     */
    public com.vsp.xl.dto.v002.SimpleCode getClaimCode() {
        return claimCode;
    }


    /**
     * Sets the claimCode value for this IssueAuthorizationRequest.
     * 
     * @param claimCode
     */
    public void setClaimCode(com.vsp.xl.dto.v002.SimpleCode claimCode) {
        this.claimCode = claimCode;
    }


    /**
     * Gets the previousAuthorizationKey value for this IssueAuthorizationRequest.
     * 
     * @return previousAuthorizationKey
     */
    public com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey getPreviousAuthorizationKey() {
        return previousAuthorizationKey;
    }


    /**
     * Sets the previousAuthorizationKey value for this IssueAuthorizationRequest.
     * 
     * @param previousAuthorizationKey
     */
    public void setPreviousAuthorizationKey(com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey previousAuthorizationKey) {
        this.previousAuthorizationKey = previousAuthorizationKey;
    }


    /**
     * Gets the replacePreviousAuthorization value for this IssueAuthorizationRequest.
     * 
     * @return replacePreviousAuthorization
     */
    public java.lang.Boolean getReplacePreviousAuthorization() {
        return replacePreviousAuthorization;
    }


    /**
     * Sets the replacePreviousAuthorization value for this IssueAuthorizationRequest.
     * 
     * @param replacePreviousAuthorization
     */
    public void setReplacePreviousAuthorization(java.lang.Boolean replacePreviousAuthorization) {
        this.replacePreviousAuthorization = replacePreviousAuthorization;
    }


    /**
     * Gets the comments value for this IssueAuthorizationRequest.
     * 
     * @return comments
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this IssueAuthorizationRequest.
     * 
     * @param comments
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }


    /**
     * Gets the faxNumber value for this IssueAuthorizationRequest.
     * 
     * @return faxNumber
     */
    public java.lang.String getFaxNumber() {
        return faxNumber;
    }


    /**
     * Sets the faxNumber value for this IssueAuthorizationRequest.
     * 
     * @param faxNumber
     */
    public void setFaxNumber(java.lang.String faxNumber) {
        this.faxNumber = faxNumber;
    }


    /**
     * Gets the validateEligibility value for this IssueAuthorizationRequest.
     * 
     * @return validateEligibility
     */
    public java.lang.Boolean getValidateEligibility() {
        return validateEligibility;
    }


    /**
     * Sets the validateEligibility value for this IssueAuthorizationRequest.
     * 
     * @param validateEligibility
     */
    public void setValidateEligibility(java.lang.Boolean validateEligibility) {
        this.validateEligibility = validateEligibility;
    }


    /**
     * Gets the coverageType value for this IssueAuthorizationRequest.
     * 
     * @return coverageType
     */
    public com.vsp.xl.dto.v002.SimpleCode getCoverageType() {
        return coverageType;
    }


    /**
     * Sets the coverageType value for this IssueAuthorizationRequest.
     * 
     * @param coverageType
     */
    public void setCoverageType(com.vsp.xl.dto.v002.SimpleCode coverageType) {
        this.coverageType = coverageType;
    }


    /**
     * Gets the benefitOverrides value for this IssueAuthorizationRequest.
     * 
     * @return benefitOverrides
     */
    public com.vsp.bl.consumer.dto.plan.v004.BenefitSummary getBenefitOverrides() {
        return benefitOverrides;
    }


    /**
     * Sets the benefitOverrides value for this IssueAuthorizationRequest.
     * 
     * @param benefitOverrides
     */
    public void setBenefitOverrides(com.vsp.bl.consumer.dto.plan.v004.BenefitSummary benefitOverrides) {
        this.benefitOverrides = benefitOverrides;
    }


    /**
     * Gets the affectsFutureEligibility value for this IssueAuthorizationRequest.
     * 
     * @return affectsFutureEligibility
     */
    public java.lang.Boolean getAffectsFutureEligibility() {
        return affectsFutureEligibility;
    }


    /**
     * Sets the affectsFutureEligibility value for this IssueAuthorizationRequest.
     * 
     * @param affectsFutureEligibility
     */
    public void setAffectsFutureEligibility(java.lang.Boolean affectsFutureEligibility) {
        this.affectsFutureEligibility = affectsFutureEligibility;
    }


    /**
     * Gets the issueWithSuspend value for this IssueAuthorizationRequest.
     * 
     * @return issueWithSuspend
     */
    public java.lang.Boolean getIssueWithSuspend() {
        return issueWithSuspend;
    }


    /**
     * Sets the issueWithSuspend value for this IssueAuthorizationRequest.
     * 
     * @param issueWithSuspend
     */
    public void setIssueWithSuspend(java.lang.Boolean issueWithSuspend) {
        this.issueWithSuspend = issueWithSuspend;
    }


    /**
     * Gets the addMemberIndicator value for this IssueAuthorizationRequest.
     * 
     * @return addMemberIndicator
     */
    public java.lang.Boolean getAddMemberIndicator() {
        return addMemberIndicator;
    }


    /**
     * Sets the addMemberIndicator value for this IssueAuthorizationRequest.
     * 
     * @param addMemberIndicator
     */
    public void setAddMemberIndicator(java.lang.Boolean addMemberIndicator) {
        this.addMemberIndicator = addMemberIndicator;
    }


    /**
     * Gets the memberID9Digit value for this IssueAuthorizationRequest.
     * 
     * @return memberID9Digit
     */
    public java.lang.String getMemberID9Digit() {
        return memberID9Digit;
    }


    /**
     * Sets the memberID9Digit value for this IssueAuthorizationRequest.
     * 
     * @param memberID9Digit
     */
    public void setMemberID9Digit(java.lang.String memberID9Digit) {
        this.memberID9Digit = memberID9Digit;
    }


    /**
     * Gets the memberName value for this IssueAuthorizationRequest.
     * 
     * @return memberName
     */
    public com.vsp.bl.ancillary.dto.personandcontact.v001.Name getMemberName() {
        return memberName;
    }


    /**
     * Sets the memberName value for this IssueAuthorizationRequest.
     * 
     * @param memberName
     */
    public void setMemberName(com.vsp.bl.ancillary.dto.personandcontact.v001.Name memberName) {
        this.memberName = memberName;
    }


    /**
     * Gets the memberDOB value for this IssueAuthorizationRequest.
     * 
     * @return memberDOB
     */
    public com.vsp.xl.dto.v002.Date getMemberDOB() {
        return memberDOB;
    }


    /**
     * Sets the memberDOB value for this IssueAuthorizationRequest.
     * 
     * @param memberDOB
     */
    public void setMemberDOB(com.vsp.xl.dto.v002.Date memberDOB) {
        this.memberDOB = memberDOB;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IssueAuthorizationRequest)) return false;
        IssueAuthorizationRequest other = (IssueAuthorizationRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.akaMembers==null && other.getAkaMembers()==null) || 
             (this.akaMembers!=null &&
              java.util.Arrays.equals(this.akaMembers, other.getAkaMembers()))) &&
            ((this.asOfDate==null && other.getAsOfDate()==null) || 
             (this.asOfDate!=null &&
              this.asOfDate.equals(other.getAsOfDate()))) &&
            ((this.memberKey==null && other.getMemberKey()==null) || 
             (this.memberKey!=null &&
              this.memberKey.equals(other.getMemberKey()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.benefitType==null && other.getBenefitType()==null) || 
             (this.benefitType!=null &&
              this.benefitType.equals(other.getBenefitType()))) &&
            ((this.classId==null && other.getClassId()==null) || 
             (this.classId!=null &&
              this.classId.equals(other.getClassId()))) &&
            ((this.cobSSN==null && other.getCobSSN()==null) || 
             (this.cobSSN!=null &&
              this.cobSSN.equals(other.getCobSSN()))) &&
            ((this.drPhoneNumber==null && other.getDrPhoneNumber()==null) || 
             (this.drPhoneNumber!=null &&
              this.drPhoneNumber.equals(other.getDrPhoneNumber()))) &&
            ((this.isMemberAddress==null && other.getIsMemberAddress()==null) || 
             (this.isMemberAddress!=null &&
              this.isMemberAddress.equals(other.getIsMemberAddress()))) &&
            ((this.originationSource==null && other.getOriginationSource()==null) || 
             (this.originationSource!=null &&
              this.originationSource.equals(other.getOriginationSource()))) &&
            ((this.processSource==null && other.getProcessSource()==null) || 
             (this.processSource!=null &&
              this.processSource.equals(other.getProcessSource()))) &&
            ((this.serviceTypes==null && other.getServiceTypes()==null) || 
             (this.serviceTypes!=null &&
              java.util.Arrays.equals(this.serviceTypes, other.getServiceTypes()))) &&
            ((this.approvedBy==null && other.getApprovedBy()==null) || 
             (this.approvedBy!=null &&
              this.approvedBy.equals(other.getApprovedBy()))) &&
            ((this.bypassCodes==null && other.getBypassCodes()==null) || 
             (this.bypassCodes!=null &&
              java.util.Arrays.equals(this.bypassCodes, other.getBypassCodes()))) &&
            ((this.claimCode==null && other.getClaimCode()==null) || 
             (this.claimCode!=null &&
              this.claimCode.equals(other.getClaimCode()))) &&
            ((this.previousAuthorizationKey==null && other.getPreviousAuthorizationKey()==null) || 
             (this.previousAuthorizationKey!=null &&
              this.previousAuthorizationKey.equals(other.getPreviousAuthorizationKey()))) &&
            ((this.replacePreviousAuthorization==null && other.getReplacePreviousAuthorization()==null) || 
             (this.replacePreviousAuthorization!=null &&
              this.replacePreviousAuthorization.equals(other.getReplacePreviousAuthorization()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments()))) &&
            ((this.faxNumber==null && other.getFaxNumber()==null) || 
             (this.faxNumber!=null &&
              this.faxNumber.equals(other.getFaxNumber()))) &&
            ((this.validateEligibility==null && other.getValidateEligibility()==null) || 
             (this.validateEligibility!=null &&
              this.validateEligibility.equals(other.getValidateEligibility()))) &&
            ((this.coverageType==null && other.getCoverageType()==null) || 
             (this.coverageType!=null &&
              this.coverageType.equals(other.getCoverageType()))) &&
            ((this.benefitOverrides==null && other.getBenefitOverrides()==null) || 
             (this.benefitOverrides!=null &&
              this.benefitOverrides.equals(other.getBenefitOverrides()))) &&
            ((this.affectsFutureEligibility==null && other.getAffectsFutureEligibility()==null) || 
             (this.affectsFutureEligibility!=null &&
              this.affectsFutureEligibility.equals(other.getAffectsFutureEligibility()))) &&
            ((this.issueWithSuspend==null && other.getIssueWithSuspend()==null) || 
             (this.issueWithSuspend!=null &&
              this.issueWithSuspend.equals(other.getIssueWithSuspend()))) &&
            ((this.addMemberIndicator==null && other.getAddMemberIndicator()==null) || 
             (this.addMemberIndicator!=null &&
              this.addMemberIndicator.equals(other.getAddMemberIndicator()))) &&
            ((this.memberID9Digit==null && other.getMemberID9Digit()==null) || 
             (this.memberID9Digit!=null &&
              this.memberID9Digit.equals(other.getMemberID9Digit()))) &&
            ((this.memberName==null && other.getMemberName()==null) || 
             (this.memberName!=null &&
              this.memberName.equals(other.getMemberName()))) &&
            ((this.memberDOB==null && other.getMemberDOB()==null) || 
             (this.memberDOB!=null &&
              this.memberDOB.equals(other.getMemberDOB())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAkaMembers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAkaMembers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAkaMembers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAsOfDate() != null) {
            _hashCode += getAsOfDate().hashCode();
        }
        if (getMemberKey() != null) {
            _hashCode += getMemberKey().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getBenefitType() != null) {
            _hashCode += getBenefitType().hashCode();
        }
        if (getClassId() != null) {
            _hashCode += getClassId().hashCode();
        }
        if (getCobSSN() != null) {
            _hashCode += getCobSSN().hashCode();
        }
        if (getDrPhoneNumber() != null) {
            _hashCode += getDrPhoneNumber().hashCode();
        }
        if (getIsMemberAddress() != null) {
            _hashCode += getIsMemberAddress().hashCode();
        }
        if (getOriginationSource() != null) {
            _hashCode += getOriginationSource().hashCode();
        }
        if (getProcessSource() != null) {
            _hashCode += getProcessSource().hashCode();
        }
        if (getServiceTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getApprovedBy() != null) {
            _hashCode += getApprovedBy().hashCode();
        }
        if (getBypassCodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBypassCodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBypassCodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getClaimCode() != null) {
            _hashCode += getClaimCode().hashCode();
        }
        if (getPreviousAuthorizationKey() != null) {
            _hashCode += getPreviousAuthorizationKey().hashCode();
        }
        if (getReplacePreviousAuthorization() != null) {
            _hashCode += getReplacePreviousAuthorization().hashCode();
        }
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        if (getFaxNumber() != null) {
            _hashCode += getFaxNumber().hashCode();
        }
        if (getValidateEligibility() != null) {
            _hashCode += getValidateEligibility().hashCode();
        }
        if (getCoverageType() != null) {
            _hashCode += getCoverageType().hashCode();
        }
        if (getBenefitOverrides() != null) {
            _hashCode += getBenefitOverrides().hashCode();
        }
        if (getAffectsFutureEligibility() != null) {
            _hashCode += getAffectsFutureEligibility().hashCode();
        }
        if (getIssueWithSuspend() != null) {
            _hashCode += getIssueWithSuspend().hashCode();
        }
        if (getAddMemberIndicator() != null) {
            _hashCode += getAddMemberIndicator().hashCode();
        }
        if (getMemberID9Digit() != null) {
            _hashCode += getMemberID9Digit().hashCode();
        }
        if (getMemberName() != null) {
            _hashCode += getMemberName().hashCode();
        }
        if (getMemberDOB() != null) {
            _hashCode += getMemberDOB().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IssueAuthorizationRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "IssueAuthorizationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("akaMembers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "akaMembers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asOfDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "asOfDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.personandcontact.dto.ancillary.bl.vsp.com", "Address"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("benefitType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "benefitType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cobSSN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cobSSN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drPhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "drPhoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMemberAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMemberAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originationSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originationSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approvedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "approvedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bypassCodes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bypassCodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previousAuthorizationKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "previousAuthorizationKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.authorization.dto.claim.bl.vsp.com", "AuthorizationKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("replacePreviousAuthorization");
        elemField.setXmlName(new javax.xml.namespace.QName("", "replacePreviousAuthorization"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faxNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "faxNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validateEligibility");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validateEligibility"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("benefitOverrides");
        elemField.setXmlName(new javax.xml.namespace.QName("", "benefitOverrides"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.plan.dto.consumer.bl.vsp.com", "BenefitSummary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affectsFutureEligibility");
        elemField.setXmlName(new javax.xml.namespace.QName("", "affectsFutureEligibility"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issueWithSuspend");
        elemField.setXmlName(new javax.xml.namespace.QName("", "issueWithSuspend"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addMemberIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addMemberIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberID9Digit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberID9Digit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.personandcontact.dto.ancillary.bl.vsp.com", "Name"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberDOB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberDOB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

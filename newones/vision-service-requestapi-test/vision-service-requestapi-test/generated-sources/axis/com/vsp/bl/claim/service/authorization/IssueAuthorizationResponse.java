/**
 * IssueAuthorizationResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class IssueAuthorizationResponse  extends com.vsp.bl.service.v001.ServiceResponse  implements java.io.Serializable {
    private com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey;

    private com.vsp.bl.consumer.dto.eligibility.v007.MemberEligibility eligibility;

    private com.vsp.bl.consumer.dto.member.v001.MemberKey[] akaMembers;

    public IssueAuthorizationResponse() {
    }

    public IssueAuthorizationResponse(
           com.vsp.bl.service.helper.v001.ServiceMessage[] severeMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] errorMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] warningMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] informationMessageList,
           boolean messagesEmpty,
           boolean severe,
           boolean error,
           boolean warning,
           boolean information,
           int severeCount,
           int errorCount,
           int warningCount,
           int informationCount,
           com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey,
           com.vsp.bl.consumer.dto.eligibility.v007.MemberEligibility eligibility,
           com.vsp.bl.consumer.dto.member.v001.MemberKey[] akaMembers) {
        super(
            severeMessageList,
            errorMessageList,
            warningMessageList,
            informationMessageList,
            messagesEmpty,
            severe,
            error,
            warning,
            information,
            severeCount,
            errorCount,
            warningCount,
            informationCount);
        this.authorizationKey = authorizationKey;
        this.eligibility = eligibility;
        this.akaMembers = akaMembers;
    }


    /**
     * Gets the authorizationKey value for this IssueAuthorizationResponse.
     * 
     * @return authorizationKey
     */
    public com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey getAuthorizationKey() {
        return authorizationKey;
    }


    /**
     * Sets the authorizationKey value for this IssueAuthorizationResponse.
     * 
     * @param authorizationKey
     */
    public void setAuthorizationKey(com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey) {
        this.authorizationKey = authorizationKey;
    }


    /**
     * Gets the eligibility value for this IssueAuthorizationResponse.
     * 
     * @return eligibility
     */
    public com.vsp.bl.consumer.dto.eligibility.v007.MemberEligibility getEligibility() {
        return eligibility;
    }


    /**
     * Sets the eligibility value for this IssueAuthorizationResponse.
     * 
     * @param eligibility
     */
    public void setEligibility(com.vsp.bl.consumer.dto.eligibility.v007.MemberEligibility eligibility) {
        this.eligibility = eligibility;
    }


    /**
     * Gets the akaMembers value for this IssueAuthorizationResponse.
     * 
     * @return akaMembers
     */
    public com.vsp.bl.consumer.dto.member.v001.MemberKey[] getAkaMembers() {
        return akaMembers;
    }


    /**
     * Sets the akaMembers value for this IssueAuthorizationResponse.
     * 
     * @param akaMembers
     */
    public void setAkaMembers(com.vsp.bl.consumer.dto.member.v001.MemberKey[] akaMembers) {
        this.akaMembers = akaMembers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IssueAuthorizationResponse)) return false;
        IssueAuthorizationResponse other = (IssueAuthorizationResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.authorizationKey==null && other.getAuthorizationKey()==null) || 
             (this.authorizationKey!=null &&
              this.authorizationKey.equals(other.getAuthorizationKey()))) &&
            ((this.eligibility==null && other.getEligibility()==null) || 
             (this.eligibility!=null &&
              this.eligibility.equals(other.getEligibility()))) &&
            ((this.akaMembers==null && other.getAkaMembers()==null) || 
             (this.akaMembers!=null &&
              java.util.Arrays.equals(this.akaMembers, other.getAkaMembers())));
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
        if (getAuthorizationKey() != null) {
            _hashCode += getAuthorizationKey().hashCode();
        }
        if (getEligibility() != null) {
            _hashCode += getEligibility().hashCode();
        }
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IssueAuthorizationResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "IssueAuthorizationResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorizationKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.authorization.dto.claim.bl.vsp.com", "AuthorizationKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eligibility");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eligibility"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v007.eligibility.dto.consumer.bl.vsp.com", "MemberEligibility"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("akaMembers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "akaMembers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey"));
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

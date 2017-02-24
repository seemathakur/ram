/**
 * ReleaseAuthorizationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class ReleaseAuthorizationRequest  extends com.vsp.bl.service.v001.ServiceRequest  implements java.io.Serializable {
    private com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey;

    private java.lang.String approvedBy;

    private java.lang.String comments;

    private com.vsp.xl.dto.v002.Date releaseDate;

    public ReleaseAuthorizationRequest() {
    }

    public ReleaseAuthorizationRequest(
           java.lang.String serviceThreadId,
           java.lang.String businessTransactionId,
           java.lang.String requesterProcessName,
           java.lang.String userId,
           com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey,
           java.lang.String approvedBy,
           java.lang.String comments,
           com.vsp.xl.dto.v002.Date releaseDate) {
        super(
            serviceThreadId,
            businessTransactionId,
            requesterProcessName,
            userId);
        this.authorizationKey = authorizationKey;
        this.approvedBy = approvedBy;
        this.comments = comments;
        this.releaseDate = releaseDate;
    }


    /**
     * Gets the authorizationKey value for this ReleaseAuthorizationRequest.
     * 
     * @return authorizationKey
     */
    public com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey getAuthorizationKey() {
        return authorizationKey;
    }


    /**
     * Sets the authorizationKey value for this ReleaseAuthorizationRequest.
     * 
     * @param authorizationKey
     */
    public void setAuthorizationKey(com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey) {
        this.authorizationKey = authorizationKey;
    }


    /**
     * Gets the approvedBy value for this ReleaseAuthorizationRequest.
     * 
     * @return approvedBy
     */
    public java.lang.String getApprovedBy() {
        return approvedBy;
    }


    /**
     * Sets the approvedBy value for this ReleaseAuthorizationRequest.
     * 
     * @param approvedBy
     */
    public void setApprovedBy(java.lang.String approvedBy) {
        this.approvedBy = approvedBy;
    }


    /**
     * Gets the comments value for this ReleaseAuthorizationRequest.
     * 
     * @return comments
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this ReleaseAuthorizationRequest.
     * 
     * @param comments
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }


    /**
     * Gets the releaseDate value for this ReleaseAuthorizationRequest.
     * 
     * @return releaseDate
     */
    public com.vsp.xl.dto.v002.Date getReleaseDate() {
        return releaseDate;
    }


    /**
     * Sets the releaseDate value for this ReleaseAuthorizationRequest.
     * 
     * @param releaseDate
     */
    public void setReleaseDate(com.vsp.xl.dto.v002.Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReleaseAuthorizationRequest)) return false;
        ReleaseAuthorizationRequest other = (ReleaseAuthorizationRequest) obj;
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
            ((this.approvedBy==null && other.getApprovedBy()==null) || 
             (this.approvedBy!=null &&
              this.approvedBy.equals(other.getApprovedBy()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments()))) &&
            ((this.releaseDate==null && other.getReleaseDate()==null) || 
             (this.releaseDate!=null &&
              this.releaseDate.equals(other.getReleaseDate())));
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
        if (getApprovedBy() != null) {
            _hashCode += getApprovedBy().hashCode();
        }
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        if (getReleaseDate() != null) {
            _hashCode += getReleaseDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReleaseAuthorizationRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "ReleaseAuthorizationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorizationKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.authorization.dto.claim.bl.vsp.com", "AuthorizationKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approvedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "approvedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "releaseDate"));
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

/**
 * DeleteAuthorizationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class DeleteAuthorizationRequest  extends com.vsp.bl.service.v001.ServiceRequest  implements java.io.Serializable {
    private com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey;

    private java.lang.String comments;

    public DeleteAuthorizationRequest() {
    }

    public DeleteAuthorizationRequest(
           java.lang.String serviceThreadId,
           java.lang.String businessTransactionId,
           java.lang.String requesterProcessName,
           java.lang.String userId,
           com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey,
           java.lang.String comments) {
        super(
            serviceThreadId,
            businessTransactionId,
            requesterProcessName,
            userId);
        this.authorizationKey = authorizationKey;
        this.comments = comments;
    }


    /**
     * Gets the authorizationKey value for this DeleteAuthorizationRequest.
     * 
     * @return authorizationKey
     */
    public com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey getAuthorizationKey() {
        return authorizationKey;
    }


    /**
     * Sets the authorizationKey value for this DeleteAuthorizationRequest.
     * 
     * @param authorizationKey
     */
    public void setAuthorizationKey(com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey) {
        this.authorizationKey = authorizationKey;
    }


    /**
     * Gets the comments value for this DeleteAuthorizationRequest.
     * 
     * @return comments
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this DeleteAuthorizationRequest.
     * 
     * @param comments
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteAuthorizationRequest)) return false;
        DeleteAuthorizationRequest other = (DeleteAuthorizationRequest) obj;
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
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments())));
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
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeleteAuthorizationRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorizationKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.authorization.dto.claim.bl.vsp.com", "AuthorizationKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

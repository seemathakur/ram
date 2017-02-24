/**
 * HoldAuthorizationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class HoldAuthorizationRequest  extends com.vsp.bl.service.v001.ServiceRequest  implements java.io.Serializable {
    private com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey;

    private com.vsp.xl.dto.v002.SimpleCode dispositionReason;

    private java.lang.String approvedBy;

    private java.lang.String comments;

    private java.lang.Integer priority;

    private java.lang.Boolean routeIndicator;

    private java.lang.Boolean notify;

    public HoldAuthorizationRequest() {
    }

    public HoldAuthorizationRequest(
           java.lang.String serviceThreadId,
           java.lang.String businessTransactionId,
           java.lang.String requesterProcessName,
           java.lang.String userId,
           com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey,
           com.vsp.xl.dto.v002.SimpleCode dispositionReason,
           java.lang.String approvedBy,
           java.lang.String comments,
           java.lang.Integer priority,
           java.lang.Boolean routeIndicator,
           java.lang.Boolean notify) {
        super(
            serviceThreadId,
            businessTransactionId,
            requesterProcessName,
            userId);
        this.authorizationKey = authorizationKey;
        this.dispositionReason = dispositionReason;
        this.approvedBy = approvedBy;
        this.comments = comments;
        this.priority = priority;
        this.routeIndicator = routeIndicator;
        this.notify = notify;
    }


    /**
     * Gets the authorizationKey value for this HoldAuthorizationRequest.
     * 
     * @return authorizationKey
     */
    public com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey getAuthorizationKey() {
        return authorizationKey;
    }


    /**
     * Sets the authorizationKey value for this HoldAuthorizationRequest.
     * 
     * @param authorizationKey
     */
    public void setAuthorizationKey(com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey) {
        this.authorizationKey = authorizationKey;
    }


    /**
     * Gets the dispositionReason value for this HoldAuthorizationRequest.
     * 
     * @return dispositionReason
     */
    public com.vsp.xl.dto.v002.SimpleCode getDispositionReason() {
        return dispositionReason;
    }


    /**
     * Sets the dispositionReason value for this HoldAuthorizationRequest.
     * 
     * @param dispositionReason
     */
    public void setDispositionReason(com.vsp.xl.dto.v002.SimpleCode dispositionReason) {
        this.dispositionReason = dispositionReason;
    }


    /**
     * Gets the approvedBy value for this HoldAuthorizationRequest.
     * 
     * @return approvedBy
     */
    public java.lang.String getApprovedBy() {
        return approvedBy;
    }


    /**
     * Sets the approvedBy value for this HoldAuthorizationRequest.
     * 
     * @param approvedBy
     */
    public void setApprovedBy(java.lang.String approvedBy) {
        this.approvedBy = approvedBy;
    }


    /**
     * Gets the comments value for this HoldAuthorizationRequest.
     * 
     * @return comments
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this HoldAuthorizationRequest.
     * 
     * @param comments
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }


    /**
     * Gets the priority value for this HoldAuthorizationRequest.
     * 
     * @return priority
     */
    public java.lang.Integer getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this HoldAuthorizationRequest.
     * 
     * @param priority
     */
    public void setPriority(java.lang.Integer priority) {
        this.priority = priority;
    }


    /**
     * Gets the routeIndicator value for this HoldAuthorizationRequest.
     * 
     * @return routeIndicator
     */
    public java.lang.Boolean getRouteIndicator() {
        return routeIndicator;
    }


    /**
     * Sets the routeIndicator value for this HoldAuthorizationRequest.
     * 
     * @param routeIndicator
     */
    public void setRouteIndicator(java.lang.Boolean routeIndicator) {
        this.routeIndicator = routeIndicator;
    }


    /**
     * Gets the notify value for this HoldAuthorizationRequest.
     * 
     * @return notify
     */
    public java.lang.Boolean getNotify() {
        return notify;
    }


    /**
     * Sets the notify value for this HoldAuthorizationRequest.
     * 
     * @param notify
     */
    public void setNotify(java.lang.Boolean notify) {
        this.notify = notify;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HoldAuthorizationRequest)) return false;
        HoldAuthorizationRequest other = (HoldAuthorizationRequest) obj;
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
            ((this.dispositionReason==null && other.getDispositionReason()==null) || 
             (this.dispositionReason!=null &&
              this.dispositionReason.equals(other.getDispositionReason()))) &&
            ((this.approvedBy==null && other.getApprovedBy()==null) || 
             (this.approvedBy!=null &&
              this.approvedBy.equals(other.getApprovedBy()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments()))) &&
            ((this.priority==null && other.getPriority()==null) || 
             (this.priority!=null &&
              this.priority.equals(other.getPriority()))) &&
            ((this.routeIndicator==null && other.getRouteIndicator()==null) || 
             (this.routeIndicator!=null &&
              this.routeIndicator.equals(other.getRouteIndicator()))) &&
            ((this.notify==null && other.getNotify()==null) || 
             (this.notify!=null &&
              this.notify.equals(other.getNotify())));
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
        if (getDispositionReason() != null) {
            _hashCode += getDispositionReason().hashCode();
        }
        if (getApprovedBy() != null) {
            _hashCode += getApprovedBy().hashCode();
        }
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        if (getRouteIndicator() != null) {
            _hashCode += getRouteIndicator().hashCode();
        }
        if (getNotify() != null) {
            _hashCode += getNotify().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HoldAuthorizationRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HoldAuthorizationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorizationKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.authorization.dto.claim.bl.vsp.com", "AuthorizationKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispositionReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dispositionReason"));
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
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routeIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routeIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notify");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notify"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
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

/**
 * ServiceRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.service.v001;

public class ServiceRequest  implements java.io.Serializable {
    private java.lang.String serviceThreadId;

    private java.lang.String businessTransactionId;

    private java.lang.String requesterProcessName;

    private java.lang.String userId;

    public ServiceRequest() {
    }

    public ServiceRequest(
           java.lang.String serviceThreadId,
           java.lang.String businessTransactionId,
           java.lang.String requesterProcessName,
           java.lang.String userId) {
           this.serviceThreadId = serviceThreadId;
           this.businessTransactionId = businessTransactionId;
           this.requesterProcessName = requesterProcessName;
           this.userId = userId;
    }


    /**
     * Gets the serviceThreadId value for this ServiceRequest.
     * 
     * @return serviceThreadId
     */
    public java.lang.String getServiceThreadId() {
        return serviceThreadId;
    }


    /**
     * Sets the serviceThreadId value for this ServiceRequest.
     * 
     * @param serviceThreadId
     */
    public void setServiceThreadId(java.lang.String serviceThreadId) {
        this.serviceThreadId = serviceThreadId;
    }


    /**
     * Gets the businessTransactionId value for this ServiceRequest.
     * 
     * @return businessTransactionId
     */
    public java.lang.String getBusinessTransactionId() {
        return businessTransactionId;
    }


    /**
     * Sets the businessTransactionId value for this ServiceRequest.
     * 
     * @param businessTransactionId
     */
    public void setBusinessTransactionId(java.lang.String businessTransactionId) {
        this.businessTransactionId = businessTransactionId;
    }


    /**
     * Gets the requesterProcessName value for this ServiceRequest.
     * 
     * @return requesterProcessName
     */
    public java.lang.String getRequesterProcessName() {
        return requesterProcessName;
    }


    /**
     * Sets the requesterProcessName value for this ServiceRequest.
     * 
     * @param requesterProcessName
     */
    public void setRequesterProcessName(java.lang.String requesterProcessName) {
        this.requesterProcessName = requesterProcessName;
    }


    /**
     * Gets the userId value for this ServiceRequest.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this ServiceRequest.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceRequest)) return false;
        ServiceRequest other = (ServiceRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.serviceThreadId==null && other.getServiceThreadId()==null) || 
             (this.serviceThreadId!=null &&
              this.serviceThreadId.equals(other.getServiceThreadId()))) &&
            ((this.businessTransactionId==null && other.getBusinessTransactionId()==null) || 
             (this.businessTransactionId!=null &&
              this.businessTransactionId.equals(other.getBusinessTransactionId()))) &&
            ((this.requesterProcessName==null && other.getRequesterProcessName()==null) || 
             (this.requesterProcessName!=null &&
              this.requesterProcessName.equals(other.getRequesterProcessName()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getServiceThreadId() != null) {
            _hashCode += getServiceThreadId().hashCode();
        }
        if (getBusinessTransactionId() != null) {
            _hashCode += getBusinessTransactionId().hashCode();
        }
        if (getRequesterProcessName() != null) {
            _hashCode += getRequesterProcessName().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.service.bl.vsp.com", "ServiceRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceThreadId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceThreadId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessTransactionId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessTransactionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requesterProcessName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requesterProcessName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
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

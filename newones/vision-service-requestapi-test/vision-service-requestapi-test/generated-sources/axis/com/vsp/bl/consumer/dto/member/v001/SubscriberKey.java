/**
 * SubscriberKey.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.member.v001;

public class SubscriberKey  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.String clientId;

    private java.lang.String divisionId;

    private java.lang.String subscriberId;

    public SubscriberKey() {
    }

    public SubscriberKey(
           java.lang.String clientId,
           java.lang.String divisionId,
           java.lang.String subscriberId) {
        this.clientId = clientId;
        this.divisionId = divisionId;
        this.subscriberId = subscriberId;
    }


    /**
     * Gets the clientId value for this SubscriberKey.
     * 
     * @return clientId
     */
    public java.lang.String getClientId() {
        return clientId;
    }


    /**
     * Sets the clientId value for this SubscriberKey.
     * 
     * @param clientId
     */
    public void setClientId(java.lang.String clientId) {
        this.clientId = clientId;
    }


    /**
     * Gets the divisionId value for this SubscriberKey.
     * 
     * @return divisionId
     */
    public java.lang.String getDivisionId() {
        return divisionId;
    }


    /**
     * Sets the divisionId value for this SubscriberKey.
     * 
     * @param divisionId
     */
    public void setDivisionId(java.lang.String divisionId) {
        this.divisionId = divisionId;
    }


    /**
     * Gets the subscriberId value for this SubscriberKey.
     * 
     * @return subscriberId
     */
    public java.lang.String getSubscriberId() {
        return subscriberId;
    }


    /**
     * Sets the subscriberId value for this SubscriberKey.
     * 
     * @param subscriberId
     */
    public void setSubscriberId(java.lang.String subscriberId) {
        this.subscriberId = subscriberId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubscriberKey)) return false;
        SubscriberKey other = (SubscriberKey) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.clientId==null && other.getClientId()==null) || 
             (this.clientId!=null &&
              this.clientId.equals(other.getClientId()))) &&
            ((this.divisionId==null && other.getDivisionId()==null) || 
             (this.divisionId!=null &&
              this.divisionId.equals(other.getDivisionId()))) &&
            ((this.subscriberId==null && other.getSubscriberId()==null) || 
             (this.subscriberId!=null &&
              this.subscriberId.equals(other.getSubscriberId())));
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
        if (getClientId() != null) {
            _hashCode += getClientId().hashCode();
        }
        if (getDivisionId() != null) {
            _hashCode += getDivisionId().hashCode();
        }
        if (getSubscriberId() != null) {
            _hashCode += getSubscriberId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubscriberKey.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "SubscriberKey"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("divisionId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "divisionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscriberId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subscriberId"));
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

/**
 * HasAccessResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class HasAccessResponse  extends com.vsp.bl.service.v002.ServiceResponse  implements java.io.Serializable {
    private boolean hasAccess;

    public HasAccessResponse() {
    }

    public HasAccessResponse(
           com.vsp.bl.service.helper.v001.ServiceMessage[] errorMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] warningMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] informationMessageList,
           boolean hasAccess) {
        super(
            errorMessageList,
            warningMessageList,
            informationMessageList);
        this.hasAccess = hasAccess;
    }


    /**
     * Gets the hasAccess value for this HasAccessResponse.
     * 
     * @return hasAccess
     */
    public boolean isHasAccess() {
        return hasAccess;
    }


    /**
     * Sets the hasAccess value for this HasAccessResponse.
     * 
     * @param hasAccess
     */
    public void setHasAccess(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HasAccessResponse)) return false;
        HasAccessResponse other = (HasAccessResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.hasAccess == other.isHasAccess();
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
        _hashCode += (isHasAccess() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HasAccessResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HasAccessResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasAccess");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hasAccess"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
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

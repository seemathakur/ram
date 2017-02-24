/**
 * SimpleCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.xl.dto.v002;

public class SimpleCode  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.String codeType;

    private java.lang.String codeValue;

    public SimpleCode() {
    }

    public SimpleCode(
           java.lang.String codeType,
           java.lang.String codeValue) {
        this.codeType = codeType;
        this.codeValue = codeValue;
    }


    /**
     * Gets the codeType value for this SimpleCode.
     * 
     * @return codeType
     */
    public java.lang.String getCodeType() {
        return codeType;
    }


    /**
     * Sets the codeType value for this SimpleCode.
     * 
     * @param codeType
     */
    public void setCodeType(java.lang.String codeType) {
        this.codeType = codeType;
    }


    /**
     * Gets the codeValue value for this SimpleCode.
     * 
     * @return codeValue
     */
    public java.lang.String getCodeValue() {
        return codeValue;
    }


    /**
     * Sets the codeValue value for this SimpleCode.
     * 
     * @param codeValue
     */
    public void setCodeValue(java.lang.String codeValue) {
        this.codeValue = codeValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SimpleCode)) return false;
        SimpleCode other = (SimpleCode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.codeType==null && other.getCodeType()==null) || 
             (this.codeType!=null &&
              this.codeType.equals(other.getCodeType()))) &&
            ((this.codeValue==null && other.getCodeValue()==null) || 
             (this.codeValue!=null &&
              this.codeValue.equals(other.getCodeValue())));
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
        if (getCodeType() != null) {
            _hashCode += getCodeType().hashCode();
        }
        if (getCodeValue() != null) {
            _hashCode += getCodeValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SimpleCode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeValue"));
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

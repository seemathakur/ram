/**
 * CurrencyValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.xl.dto.v003;

public class CurrencyValue  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.Integer dollarValue;

    private java.lang.Integer centValue;

    public CurrencyValue() {
    }

    public CurrencyValue(
           java.lang.Integer dollarValue,
           java.lang.Integer centValue) {
        this.dollarValue = dollarValue;
        this.centValue = centValue;
    }


    /**
     * Gets the dollarValue value for this CurrencyValue.
     * 
     * @return dollarValue
     */
    public java.lang.Integer getDollarValue() {
        return dollarValue;
    }


    /**
     * Sets the dollarValue value for this CurrencyValue.
     * 
     * @param dollarValue
     */
    public void setDollarValue(java.lang.Integer dollarValue) {
        this.dollarValue = dollarValue;
    }


    /**
     * Gets the centValue value for this CurrencyValue.
     * 
     * @return centValue
     */
    public java.lang.Integer getCentValue() {
        return centValue;
    }


    /**
     * Sets the centValue value for this CurrencyValue.
     * 
     * @param centValue
     */
    public void setCentValue(java.lang.Integer centValue) {
        this.centValue = centValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CurrencyValue)) return false;
        CurrencyValue other = (CurrencyValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dollarValue==null && other.getDollarValue()==null) || 
             (this.dollarValue!=null &&
              this.dollarValue.equals(other.getDollarValue()))) &&
            ((this.centValue==null && other.getCentValue()==null) || 
             (this.centValue!=null &&
              this.centValue.equals(other.getCentValue())));
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
        if (getDollarValue() != null) {
            _hashCode += getDollarValue().hashCode();
        }
        if (getCentValue() != null) {
            _hashCode += getCentValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CurrencyValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dollarValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dollarValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("centValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "centValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
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

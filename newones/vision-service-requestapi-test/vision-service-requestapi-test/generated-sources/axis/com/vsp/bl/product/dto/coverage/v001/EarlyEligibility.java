/**
 * EarlyEligibility.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v001;

public class EarlyEligibility  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.Integer gracePeriodDays;

    private java.lang.Integer numberMonthsEarly;

    public EarlyEligibility() {
    }

    public EarlyEligibility(
           java.lang.Integer gracePeriodDays,
           java.lang.Integer numberMonthsEarly) {
        this.gracePeriodDays = gracePeriodDays;
        this.numberMonthsEarly = numberMonthsEarly;
    }


    /**
     * Gets the gracePeriodDays value for this EarlyEligibility.
     * 
     * @return gracePeriodDays
     */
    public java.lang.Integer getGracePeriodDays() {
        return gracePeriodDays;
    }


    /**
     * Sets the gracePeriodDays value for this EarlyEligibility.
     * 
     * @param gracePeriodDays
     */
    public void setGracePeriodDays(java.lang.Integer gracePeriodDays) {
        this.gracePeriodDays = gracePeriodDays;
    }


    /**
     * Gets the numberMonthsEarly value for this EarlyEligibility.
     * 
     * @return numberMonthsEarly
     */
    public java.lang.Integer getNumberMonthsEarly() {
        return numberMonthsEarly;
    }


    /**
     * Sets the numberMonthsEarly value for this EarlyEligibility.
     * 
     * @param numberMonthsEarly
     */
    public void setNumberMonthsEarly(java.lang.Integer numberMonthsEarly) {
        this.numberMonthsEarly = numberMonthsEarly;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EarlyEligibility)) return false;
        EarlyEligibility other = (EarlyEligibility) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.gracePeriodDays==null && other.getGracePeriodDays()==null) || 
             (this.gracePeriodDays!=null &&
              this.gracePeriodDays.equals(other.getGracePeriodDays()))) &&
            ((this.numberMonthsEarly==null && other.getNumberMonthsEarly()==null) || 
             (this.numberMonthsEarly!=null &&
              this.numberMonthsEarly.equals(other.getNumberMonthsEarly())));
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
        if (getGracePeriodDays() != null) {
            _hashCode += getGracePeriodDays().hashCode();
        }
        if (getNumberMonthsEarly() != null) {
            _hashCode += getNumberMonthsEarly().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EarlyEligibility.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "EarlyEligibility"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gracePeriodDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gracePeriodDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberMonthsEarly");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberMonthsEarly"));
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

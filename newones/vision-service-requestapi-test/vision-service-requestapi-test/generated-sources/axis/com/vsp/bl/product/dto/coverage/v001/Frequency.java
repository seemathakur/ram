/**
 * Frequency.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v001;

public class Frequency  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.Integer numberOfTimePeriods;

    private com.vsp.xl.dto.v002.DayInYear periodBegins;

    private com.vsp.xl.dto.v002.SimpleCode periodType;

    private com.vsp.xl.dto.v002.SimpleCode timePeriod;

    public Frequency() {
    }

    public Frequency(
           java.lang.Integer numberOfTimePeriods,
           com.vsp.xl.dto.v002.DayInYear periodBegins,
           com.vsp.xl.dto.v002.SimpleCode periodType,
           com.vsp.xl.dto.v002.SimpleCode timePeriod) {
        this.numberOfTimePeriods = numberOfTimePeriods;
        this.periodBegins = periodBegins;
        this.periodType = periodType;
        this.timePeriod = timePeriod;
    }


    /**
     * Gets the numberOfTimePeriods value for this Frequency.
     * 
     * @return numberOfTimePeriods
     */
    public java.lang.Integer getNumberOfTimePeriods() {
        return numberOfTimePeriods;
    }


    /**
     * Sets the numberOfTimePeriods value for this Frequency.
     * 
     * @param numberOfTimePeriods
     */
    public void setNumberOfTimePeriods(java.lang.Integer numberOfTimePeriods) {
        this.numberOfTimePeriods = numberOfTimePeriods;
    }


    /**
     * Gets the periodBegins value for this Frequency.
     * 
     * @return periodBegins
     */
    public com.vsp.xl.dto.v002.DayInYear getPeriodBegins() {
        return periodBegins;
    }


    /**
     * Sets the periodBegins value for this Frequency.
     * 
     * @param periodBegins
     */
    public void setPeriodBegins(com.vsp.xl.dto.v002.DayInYear periodBegins) {
        this.periodBegins = periodBegins;
    }


    /**
     * Gets the periodType value for this Frequency.
     * 
     * @return periodType
     */
    public com.vsp.xl.dto.v002.SimpleCode getPeriodType() {
        return periodType;
    }


    /**
     * Sets the periodType value for this Frequency.
     * 
     * @param periodType
     */
    public void setPeriodType(com.vsp.xl.dto.v002.SimpleCode periodType) {
        this.periodType = periodType;
    }


    /**
     * Gets the timePeriod value for this Frequency.
     * 
     * @return timePeriod
     */
    public com.vsp.xl.dto.v002.SimpleCode getTimePeriod() {
        return timePeriod;
    }


    /**
     * Sets the timePeriod value for this Frequency.
     * 
     * @param timePeriod
     */
    public void setTimePeriod(com.vsp.xl.dto.v002.SimpleCode timePeriod) {
        this.timePeriod = timePeriod;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Frequency)) return false;
        Frequency other = (Frequency) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.numberOfTimePeriods==null && other.getNumberOfTimePeriods()==null) || 
             (this.numberOfTimePeriods!=null &&
              this.numberOfTimePeriods.equals(other.getNumberOfTimePeriods()))) &&
            ((this.periodBegins==null && other.getPeriodBegins()==null) || 
             (this.periodBegins!=null &&
              this.periodBegins.equals(other.getPeriodBegins()))) &&
            ((this.periodType==null && other.getPeriodType()==null) || 
             (this.periodType!=null &&
              this.periodType.equals(other.getPeriodType()))) &&
            ((this.timePeriod==null && other.getTimePeriod()==null) || 
             (this.timePeriod!=null &&
              this.timePeriod.equals(other.getTimePeriod())));
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
        if (getNumberOfTimePeriods() != null) {
            _hashCode += getNumberOfTimePeriods().hashCode();
        }
        if (getPeriodBegins() != null) {
            _hashCode += getPeriodBegins().hashCode();
        }
        if (getPeriodType() != null) {
            _hashCode += getPeriodType().hashCode();
        }
        if (getTimePeriod() != null) {
            _hashCode += getTimePeriod().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Frequency.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "Frequency"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfTimePeriods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfTimePeriods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodBegins");
        elemField.setXmlName(new javax.xml.namespace.QName("", "periodBegins"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "DayInYear"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "periodType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timePeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timePeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
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

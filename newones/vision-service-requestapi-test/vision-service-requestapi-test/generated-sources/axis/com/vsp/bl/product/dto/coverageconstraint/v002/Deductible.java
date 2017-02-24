/**
 * Deductible.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v002;

public class Deductible  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v003.CurrencyValue amount;

    private com.vsp.xl.dto.v002.SimpleCode periodType;

    private com.vsp.xl.dto.v002.DayInYear periodBegins;

    public Deductible() {
    }

    public Deductible(
           com.vsp.xl.dto.v003.CurrencyValue amount,
           com.vsp.xl.dto.v002.SimpleCode periodType,
           com.vsp.xl.dto.v002.DayInYear periodBegins) {
        this.amount = amount;
        this.periodType = periodType;
        this.periodBegins = periodBegins;
    }


    /**
     * Gets the amount value for this Deductible.
     * 
     * @return amount
     */
    public com.vsp.xl.dto.v003.CurrencyValue getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this Deductible.
     * 
     * @param amount
     */
    public void setAmount(com.vsp.xl.dto.v003.CurrencyValue amount) {
        this.amount = amount;
    }


    /**
     * Gets the periodType value for this Deductible.
     * 
     * @return periodType
     */
    public com.vsp.xl.dto.v002.SimpleCode getPeriodType() {
        return periodType;
    }


    /**
     * Sets the periodType value for this Deductible.
     * 
     * @param periodType
     */
    public void setPeriodType(com.vsp.xl.dto.v002.SimpleCode periodType) {
        this.periodType = periodType;
    }


    /**
     * Gets the periodBegins value for this Deductible.
     * 
     * @return periodBegins
     */
    public com.vsp.xl.dto.v002.DayInYear getPeriodBegins() {
        return periodBegins;
    }


    /**
     * Sets the periodBegins value for this Deductible.
     * 
     * @param periodBegins
     */
    public void setPeriodBegins(com.vsp.xl.dto.v002.DayInYear periodBegins) {
        this.periodBegins = periodBegins;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Deductible)) return false;
        Deductible other = (Deductible) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.periodType==null && other.getPeriodType()==null) || 
             (this.periodType!=null &&
              this.periodType.equals(other.getPeriodType()))) &&
            ((this.periodBegins==null && other.getPeriodBegins()==null) || 
             (this.periodBegins!=null &&
              this.periodBegins.equals(other.getPeriodBegins())));
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
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getPeriodType() != null) {
            _hashCode += getPeriodType().hashCode();
        }
        if (getPeriodBegins() != null) {
            _hashCode += getPeriodBegins().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Deductible.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "Deductible"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "periodType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodBegins");
        elemField.setXmlName(new javax.xml.namespace.QName("", "periodBegins"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "DayInYear"));
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

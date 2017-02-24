/**
 * CoPay.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v002;

public class CoPay  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v003.CurrencyValue amount;

    private com.vsp.xl.dto.v002.SimpleCode appliesTo;

    private boolean applyToDeductible;

    private com.vsp.xl.dto.v002.SimpleCode frequency;

    private com.vsp.xl.dto.v002.SimpleCode coPayType;

    private java.lang.String waiverRule;

    public CoPay() {
    }

    public CoPay(
           com.vsp.xl.dto.v003.CurrencyValue amount,
           com.vsp.xl.dto.v002.SimpleCode appliesTo,
           boolean applyToDeductible,
           com.vsp.xl.dto.v002.SimpleCode frequency,
           com.vsp.xl.dto.v002.SimpleCode coPayType,
           java.lang.String waiverRule) {
        this.amount = amount;
        this.appliesTo = appliesTo;
        this.applyToDeductible = applyToDeductible;
        this.frequency = frequency;
        this.coPayType = coPayType;
        this.waiverRule = waiverRule;
    }


    /**
     * Gets the amount value for this CoPay.
     * 
     * @return amount
     */
    public com.vsp.xl.dto.v003.CurrencyValue getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this CoPay.
     * 
     * @param amount
     */
    public void setAmount(com.vsp.xl.dto.v003.CurrencyValue amount) {
        this.amount = amount;
    }


    /**
     * Gets the appliesTo value for this CoPay.
     * 
     * @return appliesTo
     */
    public com.vsp.xl.dto.v002.SimpleCode getAppliesTo() {
        return appliesTo;
    }


    /**
     * Sets the appliesTo value for this CoPay.
     * 
     * @param appliesTo
     */
    public void setAppliesTo(com.vsp.xl.dto.v002.SimpleCode appliesTo) {
        this.appliesTo = appliesTo;
    }


    /**
     * Gets the applyToDeductible value for this CoPay.
     * 
     * @return applyToDeductible
     */
    public boolean isApplyToDeductible() {
        return applyToDeductible;
    }


    /**
     * Sets the applyToDeductible value for this CoPay.
     * 
     * @param applyToDeductible
     */
    public void setApplyToDeductible(boolean applyToDeductible) {
        this.applyToDeductible = applyToDeductible;
    }


    /**
     * Gets the frequency value for this CoPay.
     * 
     * @return frequency
     */
    public com.vsp.xl.dto.v002.SimpleCode getFrequency() {
        return frequency;
    }


    /**
     * Sets the frequency value for this CoPay.
     * 
     * @param frequency
     */
    public void setFrequency(com.vsp.xl.dto.v002.SimpleCode frequency) {
        this.frequency = frequency;
    }


    /**
     * Gets the coPayType value for this CoPay.
     * 
     * @return coPayType
     */
    public com.vsp.xl.dto.v002.SimpleCode getCoPayType() {
        return coPayType;
    }


    /**
     * Sets the coPayType value for this CoPay.
     * 
     * @param coPayType
     */
    public void setCoPayType(com.vsp.xl.dto.v002.SimpleCode coPayType) {
        this.coPayType = coPayType;
    }


    /**
     * Gets the waiverRule value for this CoPay.
     * 
     * @return waiverRule
     */
    public java.lang.String getWaiverRule() {
        return waiverRule;
    }


    /**
     * Sets the waiverRule value for this CoPay.
     * 
     * @param waiverRule
     */
    public void setWaiverRule(java.lang.String waiverRule) {
        this.waiverRule = waiverRule;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CoPay)) return false;
        CoPay other = (CoPay) obj;
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
            ((this.appliesTo==null && other.getAppliesTo()==null) || 
             (this.appliesTo!=null &&
              this.appliesTo.equals(other.getAppliesTo()))) &&
            this.applyToDeductible == other.isApplyToDeductible() &&
            ((this.frequency==null && other.getFrequency()==null) || 
             (this.frequency!=null &&
              this.frequency.equals(other.getFrequency()))) &&
            ((this.coPayType==null && other.getCoPayType()==null) || 
             (this.coPayType!=null &&
              this.coPayType.equals(other.getCoPayType()))) &&
            ((this.waiverRule==null && other.getWaiverRule()==null) || 
             (this.waiverRule!=null &&
              this.waiverRule.equals(other.getWaiverRule())));
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
        if (getAppliesTo() != null) {
            _hashCode += getAppliesTo().hashCode();
        }
        _hashCode += (isApplyToDeductible() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFrequency() != null) {
            _hashCode += getFrequency().hashCode();
        }
        if (getCoPayType() != null) {
            _hashCode += getCoPayType().hashCode();
        }
        if (getWaiverRule() != null) {
            _hashCode += getWaiverRule().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CoPay.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoPay"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appliesTo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "appliesTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applyToDeductible");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applyToDeductible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coPayType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coPayType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("waiverRule");
        elemField.setXmlName(new javax.xml.namespace.QName("", "waiverRule"));
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

/**
 * Discount.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class Discount  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.SimpleCode appliesTo;

    private com.vsp.bl.product.dto.coverage.v001.Frequency frequency;

    private com.vsp.xl.dto.v002.SimpleCode valueType;

    private com.vsp.xl.dto.v003.CurrencyValue amount;

    private com.vsp.xl.dto.v002.DatePeriod effectivePeriod;

    private java.lang.Float percentage;

    private java.lang.String reason;

    private java.lang.String rules;

    private com.vsp.bl.product.dto.coverage.v001.DiscountConstraint constraint;

    public Discount() {
    }

    public Discount(
           com.vsp.xl.dto.v002.SimpleCode appliesTo,
           com.vsp.bl.product.dto.coverage.v001.Frequency frequency,
           com.vsp.xl.dto.v002.SimpleCode valueType,
           com.vsp.xl.dto.v003.CurrencyValue amount,
           com.vsp.xl.dto.v002.DatePeriod effectivePeriod,
           java.lang.Float percentage,
           java.lang.String reason,
           java.lang.String rules,
           com.vsp.bl.product.dto.coverage.v001.DiscountConstraint constraint) {
        this.appliesTo = appliesTo;
        this.frequency = frequency;
        this.valueType = valueType;
        this.amount = amount;
        this.effectivePeriod = effectivePeriod;
        this.percentage = percentage;
        this.reason = reason;
        this.rules = rules;
        this.constraint = constraint;
    }


    /**
     * Gets the appliesTo value for this Discount.
     * 
     * @return appliesTo
     */
    public com.vsp.xl.dto.v002.SimpleCode getAppliesTo() {
        return appliesTo;
    }


    /**
     * Sets the appliesTo value for this Discount.
     * 
     * @param appliesTo
     */
    public void setAppliesTo(com.vsp.xl.dto.v002.SimpleCode appliesTo) {
        this.appliesTo = appliesTo;
    }


    /**
     * Gets the frequency value for this Discount.
     * 
     * @return frequency
     */
    public com.vsp.bl.product.dto.coverage.v001.Frequency getFrequency() {
        return frequency;
    }


    /**
     * Sets the frequency value for this Discount.
     * 
     * @param frequency
     */
    public void setFrequency(com.vsp.bl.product.dto.coverage.v001.Frequency frequency) {
        this.frequency = frequency;
    }


    /**
     * Gets the valueType value for this Discount.
     * 
     * @return valueType
     */
    public com.vsp.xl.dto.v002.SimpleCode getValueType() {
        return valueType;
    }


    /**
     * Sets the valueType value for this Discount.
     * 
     * @param valueType
     */
    public void setValueType(com.vsp.xl.dto.v002.SimpleCode valueType) {
        this.valueType = valueType;
    }


    /**
     * Gets the amount value for this Discount.
     * 
     * @return amount
     */
    public com.vsp.xl.dto.v003.CurrencyValue getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this Discount.
     * 
     * @param amount
     */
    public void setAmount(com.vsp.xl.dto.v003.CurrencyValue amount) {
        this.amount = amount;
    }


    /**
     * Gets the effectivePeriod value for this Discount.
     * 
     * @return effectivePeriod
     */
    public com.vsp.xl.dto.v002.DatePeriod getEffectivePeriod() {
        return effectivePeriod;
    }


    /**
     * Sets the effectivePeriod value for this Discount.
     * 
     * @param effectivePeriod
     */
    public void setEffectivePeriod(com.vsp.xl.dto.v002.DatePeriod effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }


    /**
     * Gets the percentage value for this Discount.
     * 
     * @return percentage
     */
    public java.lang.Float getPercentage() {
        return percentage;
    }


    /**
     * Sets the percentage value for this Discount.
     * 
     * @param percentage
     */
    public void setPercentage(java.lang.Float percentage) {
        this.percentage = percentage;
    }


    /**
     * Gets the reason value for this Discount.
     * 
     * @return reason
     */
    public java.lang.String getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this Discount.
     * 
     * @param reason
     */
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }


    /**
     * Gets the rules value for this Discount.
     * 
     * @return rules
     */
    public java.lang.String getRules() {
        return rules;
    }


    /**
     * Sets the rules value for this Discount.
     * 
     * @param rules
     */
    public void setRules(java.lang.String rules) {
        this.rules = rules;
    }


    /**
     * Gets the constraint value for this Discount.
     * 
     * @return constraint
     */
    public com.vsp.bl.product.dto.coverage.v001.DiscountConstraint getConstraint() {
        return constraint;
    }


    /**
     * Sets the constraint value for this Discount.
     * 
     * @param constraint
     */
    public void setConstraint(com.vsp.bl.product.dto.coverage.v001.DiscountConstraint constraint) {
        this.constraint = constraint;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Discount)) return false;
        Discount other = (Discount) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.appliesTo==null && other.getAppliesTo()==null) || 
             (this.appliesTo!=null &&
              this.appliesTo.equals(other.getAppliesTo()))) &&
            ((this.frequency==null && other.getFrequency()==null) || 
             (this.frequency!=null &&
              this.frequency.equals(other.getFrequency()))) &&
            ((this.valueType==null && other.getValueType()==null) || 
             (this.valueType!=null &&
              this.valueType.equals(other.getValueType()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.effectivePeriod==null && other.getEffectivePeriod()==null) || 
             (this.effectivePeriod!=null &&
              this.effectivePeriod.equals(other.getEffectivePeriod()))) &&
            ((this.percentage==null && other.getPercentage()==null) || 
             (this.percentage!=null &&
              this.percentage.equals(other.getPercentage()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason()))) &&
            ((this.rules==null && other.getRules()==null) || 
             (this.rules!=null &&
              this.rules.equals(other.getRules()))) &&
            ((this.constraint==null && other.getConstraint()==null) || 
             (this.constraint!=null &&
              this.constraint.equals(other.getConstraint())));
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
        if (getAppliesTo() != null) {
            _hashCode += getAppliesTo().hashCode();
        }
        if (getFrequency() != null) {
            _hashCode += getFrequency().hashCode();
        }
        if (getValueType() != null) {
            _hashCode += getValueType().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getEffectivePeriod() != null) {
            _hashCode += getEffectivePeriod().hashCode();
        }
        if (getPercentage() != null) {
            _hashCode += getPercentage().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        if (getRules() != null) {
            _hashCode += getRules().hashCode();
        }
        if (getConstraint() != null) {
            _hashCode += getConstraint().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Discount.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "Discount"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appliesTo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "appliesTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "Frequency"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valueType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectivePeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectivePeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "DatePeriod"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percentage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percentage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rules");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rules"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("constraint");
        elemField.setXmlName(new javax.xml.namespace.QName("", "constraint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "DiscountConstraint"));
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

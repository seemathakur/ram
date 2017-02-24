/**
 * LevelOfCoverage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.levelofcoverage.v002;

public class LevelOfCoverage  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.SimpleCode levelOfCoverageType;

    private com.vsp.xl.dto.v003.CurrencyValue allowanceAmount;

    private com.vsp.xl.dto.v002.SimpleCode allowanceFrequency;

    private com.vsp.xl.dto.v002.SimpleCode allowanceType;

    private java.lang.Integer coinsurancePercentage;

    private java.lang.Float conversionFactor;

    private com.vsp.bl.product.dto.levelofcoverage.v002.AllowanceScheduleEntry[] allowanceScheduleEntries;

    private com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint overageDeniesCoverage;

    public LevelOfCoverage() {
    }

    public LevelOfCoverage(
           com.vsp.xl.dto.v002.SimpleCode levelOfCoverageType,
           com.vsp.xl.dto.v003.CurrencyValue allowanceAmount,
           com.vsp.xl.dto.v002.SimpleCode allowanceFrequency,
           com.vsp.xl.dto.v002.SimpleCode allowanceType,
           java.lang.Integer coinsurancePercentage,
           java.lang.Float conversionFactor,
           com.vsp.bl.product.dto.levelofcoverage.v002.AllowanceScheduleEntry[] allowanceScheduleEntries,
           com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint overageDeniesCoverage) {
        this.levelOfCoverageType = levelOfCoverageType;
        this.allowanceAmount = allowanceAmount;
        this.allowanceFrequency = allowanceFrequency;
        this.allowanceType = allowanceType;
        this.coinsurancePercentage = coinsurancePercentage;
        this.conversionFactor = conversionFactor;
        this.allowanceScheduleEntries = allowanceScheduleEntries;
        this.overageDeniesCoverage = overageDeniesCoverage;
    }


    /**
     * Gets the levelOfCoverageType value for this LevelOfCoverage.
     * 
     * @return levelOfCoverageType
     */
    public com.vsp.xl.dto.v002.SimpleCode getLevelOfCoverageType() {
        return levelOfCoverageType;
    }


    /**
     * Sets the levelOfCoverageType value for this LevelOfCoverage.
     * 
     * @param levelOfCoverageType
     */
    public void setLevelOfCoverageType(com.vsp.xl.dto.v002.SimpleCode levelOfCoverageType) {
        this.levelOfCoverageType = levelOfCoverageType;
    }


    /**
     * Gets the allowanceAmount value for this LevelOfCoverage.
     * 
     * @return allowanceAmount
     */
    public com.vsp.xl.dto.v003.CurrencyValue getAllowanceAmount() {
        return allowanceAmount;
    }


    /**
     * Sets the allowanceAmount value for this LevelOfCoverage.
     * 
     * @param allowanceAmount
     */
    public void setAllowanceAmount(com.vsp.xl.dto.v003.CurrencyValue allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }


    /**
     * Gets the allowanceFrequency value for this LevelOfCoverage.
     * 
     * @return allowanceFrequency
     */
    public com.vsp.xl.dto.v002.SimpleCode getAllowanceFrequency() {
        return allowanceFrequency;
    }


    /**
     * Sets the allowanceFrequency value for this LevelOfCoverage.
     * 
     * @param allowanceFrequency
     */
    public void setAllowanceFrequency(com.vsp.xl.dto.v002.SimpleCode allowanceFrequency) {
        this.allowanceFrequency = allowanceFrequency;
    }


    /**
     * Gets the allowanceType value for this LevelOfCoverage.
     * 
     * @return allowanceType
     */
    public com.vsp.xl.dto.v002.SimpleCode getAllowanceType() {
        return allowanceType;
    }


    /**
     * Sets the allowanceType value for this LevelOfCoverage.
     * 
     * @param allowanceType
     */
    public void setAllowanceType(com.vsp.xl.dto.v002.SimpleCode allowanceType) {
        this.allowanceType = allowanceType;
    }


    /**
     * Gets the coinsurancePercentage value for this LevelOfCoverage.
     * 
     * @return coinsurancePercentage
     */
    public java.lang.Integer getCoinsurancePercentage() {
        return coinsurancePercentage;
    }


    /**
     * Sets the coinsurancePercentage value for this LevelOfCoverage.
     * 
     * @param coinsurancePercentage
     */
    public void setCoinsurancePercentage(java.lang.Integer coinsurancePercentage) {
        this.coinsurancePercentage = coinsurancePercentage;
    }


    /**
     * Gets the conversionFactor value for this LevelOfCoverage.
     * 
     * @return conversionFactor
     */
    public java.lang.Float getConversionFactor() {
        return conversionFactor;
    }


    /**
     * Sets the conversionFactor value for this LevelOfCoverage.
     * 
     * @param conversionFactor
     */
    public void setConversionFactor(java.lang.Float conversionFactor) {
        this.conversionFactor = conversionFactor;
    }


    /**
     * Gets the allowanceScheduleEntries value for this LevelOfCoverage.
     * 
     * @return allowanceScheduleEntries
     */
    public com.vsp.bl.product.dto.levelofcoverage.v002.AllowanceScheduleEntry[] getAllowanceScheduleEntries() {
        return allowanceScheduleEntries;
    }


    /**
     * Sets the allowanceScheduleEntries value for this LevelOfCoverage.
     * 
     * @param allowanceScheduleEntries
     */
    public void setAllowanceScheduleEntries(com.vsp.bl.product.dto.levelofcoverage.v002.AllowanceScheduleEntry[] allowanceScheduleEntries) {
        this.allowanceScheduleEntries = allowanceScheduleEntries;
    }


    /**
     * Gets the overageDeniesCoverage value for this LevelOfCoverage.
     * 
     * @return overageDeniesCoverage
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint getOverageDeniesCoverage() {
        return overageDeniesCoverage;
    }


    /**
     * Sets the overageDeniesCoverage value for this LevelOfCoverage.
     * 
     * @param overageDeniesCoverage
     */
    public void setOverageDeniesCoverage(com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint overageDeniesCoverage) {
        this.overageDeniesCoverage = overageDeniesCoverage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LevelOfCoverage)) return false;
        LevelOfCoverage other = (LevelOfCoverage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.levelOfCoverageType==null && other.getLevelOfCoverageType()==null) || 
             (this.levelOfCoverageType!=null &&
              this.levelOfCoverageType.equals(other.getLevelOfCoverageType()))) &&
            ((this.allowanceAmount==null && other.getAllowanceAmount()==null) || 
             (this.allowanceAmount!=null &&
              this.allowanceAmount.equals(other.getAllowanceAmount()))) &&
            ((this.allowanceFrequency==null && other.getAllowanceFrequency()==null) || 
             (this.allowanceFrequency!=null &&
              this.allowanceFrequency.equals(other.getAllowanceFrequency()))) &&
            ((this.allowanceType==null && other.getAllowanceType()==null) || 
             (this.allowanceType!=null &&
              this.allowanceType.equals(other.getAllowanceType()))) &&
            ((this.coinsurancePercentage==null && other.getCoinsurancePercentage()==null) || 
             (this.coinsurancePercentage!=null &&
              this.coinsurancePercentage.equals(other.getCoinsurancePercentage()))) &&
            ((this.conversionFactor==null && other.getConversionFactor()==null) || 
             (this.conversionFactor!=null &&
              this.conversionFactor.equals(other.getConversionFactor()))) &&
            ((this.allowanceScheduleEntries==null && other.getAllowanceScheduleEntries()==null) || 
             (this.allowanceScheduleEntries!=null &&
              java.util.Arrays.equals(this.allowanceScheduleEntries, other.getAllowanceScheduleEntries()))) &&
            ((this.overageDeniesCoverage==null && other.getOverageDeniesCoverage()==null) || 
             (this.overageDeniesCoverage!=null &&
              this.overageDeniesCoverage.equals(other.getOverageDeniesCoverage())));
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
        if (getLevelOfCoverageType() != null) {
            _hashCode += getLevelOfCoverageType().hashCode();
        }
        if (getAllowanceAmount() != null) {
            _hashCode += getAllowanceAmount().hashCode();
        }
        if (getAllowanceFrequency() != null) {
            _hashCode += getAllowanceFrequency().hashCode();
        }
        if (getAllowanceType() != null) {
            _hashCode += getAllowanceType().hashCode();
        }
        if (getCoinsurancePercentage() != null) {
            _hashCode += getCoinsurancePercentage().hashCode();
        }
        if (getConversionFactor() != null) {
            _hashCode += getConversionFactor().hashCode();
        }
        if (getAllowanceScheduleEntries() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAllowanceScheduleEntries());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAllowanceScheduleEntries(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOverageDeniesCoverage() != null) {
            _hashCode += getOverageDeniesCoverage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LevelOfCoverage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.levelofcoverage.dto.product.bl.vsp.com", "LevelOfCoverage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("levelOfCoverageType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "levelOfCoverageType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowanceAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allowanceAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowanceFrequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allowanceFrequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowanceType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allowanceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coinsurancePercentage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coinsurancePercentage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conversionFactor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conversionFactor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowanceScheduleEntries");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allowanceScheduleEntries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.levelofcoverage.dto.product.bl.vsp.com", "AllowanceScheduleEntry"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overageDeniesCoverage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overageDeniesCoverage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoverageConstraint"));
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

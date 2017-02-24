/**
 * ContributionSource.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class ContributionSource  implements java.io.Serializable {
    private com.vsp.xl.dto.v003.CurrencyValue contributionAmount;

    private com.vsp.xl.dto.v002.SimpleCode contributionFrequency;

    private java.lang.Float contributionPercent;

    private com.vsp.xl.dto.v002.SimpleCode contributionValueType;

    public ContributionSource() {
    }

    public ContributionSource(
           com.vsp.xl.dto.v003.CurrencyValue contributionAmount,
           com.vsp.xl.dto.v002.SimpleCode contributionFrequency,
           java.lang.Float contributionPercent,
           com.vsp.xl.dto.v002.SimpleCode contributionValueType) {
           this.contributionAmount = contributionAmount;
           this.contributionFrequency = contributionFrequency;
           this.contributionPercent = contributionPercent;
           this.contributionValueType = contributionValueType;
    }


    /**
     * Gets the contributionAmount value for this ContributionSource.
     * 
     * @return contributionAmount
     */
    public com.vsp.xl.dto.v003.CurrencyValue getContributionAmount() {
        return contributionAmount;
    }


    /**
     * Sets the contributionAmount value for this ContributionSource.
     * 
     * @param contributionAmount
     */
    public void setContributionAmount(com.vsp.xl.dto.v003.CurrencyValue contributionAmount) {
        this.contributionAmount = contributionAmount;
    }


    /**
     * Gets the contributionFrequency value for this ContributionSource.
     * 
     * @return contributionFrequency
     */
    public com.vsp.xl.dto.v002.SimpleCode getContributionFrequency() {
        return contributionFrequency;
    }


    /**
     * Sets the contributionFrequency value for this ContributionSource.
     * 
     * @param contributionFrequency
     */
    public void setContributionFrequency(com.vsp.xl.dto.v002.SimpleCode contributionFrequency) {
        this.contributionFrequency = contributionFrequency;
    }


    /**
     * Gets the contributionPercent value for this ContributionSource.
     * 
     * @return contributionPercent
     */
    public java.lang.Float getContributionPercent() {
        return contributionPercent;
    }


    /**
     * Sets the contributionPercent value for this ContributionSource.
     * 
     * @param contributionPercent
     */
    public void setContributionPercent(java.lang.Float contributionPercent) {
        this.contributionPercent = contributionPercent;
    }


    /**
     * Gets the contributionValueType value for this ContributionSource.
     * 
     * @return contributionValueType
     */
    public com.vsp.xl.dto.v002.SimpleCode getContributionValueType() {
        return contributionValueType;
    }


    /**
     * Sets the contributionValueType value for this ContributionSource.
     * 
     * @param contributionValueType
     */
    public void setContributionValueType(com.vsp.xl.dto.v002.SimpleCode contributionValueType) {
        this.contributionValueType = contributionValueType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContributionSource)) return false;
        ContributionSource other = (ContributionSource) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contributionAmount==null && other.getContributionAmount()==null) || 
             (this.contributionAmount!=null &&
              this.contributionAmount.equals(other.getContributionAmount()))) &&
            ((this.contributionFrequency==null && other.getContributionFrequency()==null) || 
             (this.contributionFrequency!=null &&
              this.contributionFrequency.equals(other.getContributionFrequency()))) &&
            ((this.contributionPercent==null && other.getContributionPercent()==null) || 
             (this.contributionPercent!=null &&
              this.contributionPercent.equals(other.getContributionPercent()))) &&
            ((this.contributionValueType==null && other.getContributionValueType()==null) || 
             (this.contributionValueType!=null &&
              this.contributionValueType.equals(other.getContributionValueType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getContributionAmount() != null) {
            _hashCode += getContributionAmount().hashCode();
        }
        if (getContributionFrequency() != null) {
            _hashCode += getContributionFrequency().hashCode();
        }
        if (getContributionPercent() != null) {
            _hashCode += getContributionPercent().hashCode();
        }
        if (getContributionValueType() != null) {
            _hashCode += getContributionValueType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContributionSource.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ContributionSource"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contributionAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contributionAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contributionFrequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contributionFrequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contributionPercent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contributionPercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contributionValueType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contributionValueType"));
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

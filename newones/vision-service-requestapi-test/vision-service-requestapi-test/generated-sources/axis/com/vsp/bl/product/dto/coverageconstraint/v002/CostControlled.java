/**
 * CostControlled.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v002;

public class CostControlled  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v003.CurrencyValue amount;

    private java.lang.Boolean notToExceedPayable;

    private com.vsp.xl.dto.v003.CurrencyValue priceCap;

    private java.lang.Integer volumeConstraint;

    public CostControlled() {
    }

    public CostControlled(
           com.vsp.xl.dto.v003.CurrencyValue amount,
           java.lang.Boolean notToExceedPayable,
           com.vsp.xl.dto.v003.CurrencyValue priceCap,
           java.lang.Integer volumeConstraint) {
        this.amount = amount;
        this.notToExceedPayable = notToExceedPayable;
        this.priceCap = priceCap;
        this.volumeConstraint = volumeConstraint;
    }


    /**
     * Gets the amount value for this CostControlled.
     * 
     * @return amount
     */
    public com.vsp.xl.dto.v003.CurrencyValue getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this CostControlled.
     * 
     * @param amount
     */
    public void setAmount(com.vsp.xl.dto.v003.CurrencyValue amount) {
        this.amount = amount;
    }


    /**
     * Gets the notToExceedPayable value for this CostControlled.
     * 
     * @return notToExceedPayable
     */
    public java.lang.Boolean getNotToExceedPayable() {
        return notToExceedPayable;
    }


    /**
     * Sets the notToExceedPayable value for this CostControlled.
     * 
     * @param notToExceedPayable
     */
    public void setNotToExceedPayable(java.lang.Boolean notToExceedPayable) {
        this.notToExceedPayable = notToExceedPayable;
    }


    /**
     * Gets the priceCap value for this CostControlled.
     * 
     * @return priceCap
     */
    public com.vsp.xl.dto.v003.CurrencyValue getPriceCap() {
        return priceCap;
    }


    /**
     * Sets the priceCap value for this CostControlled.
     * 
     * @param priceCap
     */
    public void setPriceCap(com.vsp.xl.dto.v003.CurrencyValue priceCap) {
        this.priceCap = priceCap;
    }


    /**
     * Gets the volumeConstraint value for this CostControlled.
     * 
     * @return volumeConstraint
     */
    public java.lang.Integer getVolumeConstraint() {
        return volumeConstraint;
    }


    /**
     * Sets the volumeConstraint value for this CostControlled.
     * 
     * @param volumeConstraint
     */
    public void setVolumeConstraint(java.lang.Integer volumeConstraint) {
        this.volumeConstraint = volumeConstraint;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CostControlled)) return false;
        CostControlled other = (CostControlled) obj;
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
            ((this.notToExceedPayable==null && other.getNotToExceedPayable()==null) || 
             (this.notToExceedPayable!=null &&
              this.notToExceedPayable.equals(other.getNotToExceedPayable()))) &&
            ((this.priceCap==null && other.getPriceCap()==null) || 
             (this.priceCap!=null &&
              this.priceCap.equals(other.getPriceCap()))) &&
            ((this.volumeConstraint==null && other.getVolumeConstraint()==null) || 
             (this.volumeConstraint!=null &&
              this.volumeConstraint.equals(other.getVolumeConstraint())));
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
        if (getNotToExceedPayable() != null) {
            _hashCode += getNotToExceedPayable().hashCode();
        }
        if (getPriceCap() != null) {
            _hashCode += getPriceCap().hashCode();
        }
        if (getVolumeConstraint() != null) {
            _hashCode += getVolumeConstraint().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CostControlled.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CostControlled"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notToExceedPayable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notToExceedPayable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priceCap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "priceCap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("volumeConstraint");
        elemField.setXmlName(new javax.xml.namespace.QName("", "volumeConstraint"));
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

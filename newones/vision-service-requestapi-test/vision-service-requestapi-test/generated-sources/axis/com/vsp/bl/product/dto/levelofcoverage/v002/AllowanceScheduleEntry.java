/**
 * AllowanceScheduleEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.levelofcoverage.v002;

public class AllowanceScheduleEntry  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v003.CurrencyValue amount;

    private com.vsp.xl.dto.v002.SimpleCode lensCharacteristicType;

    public AllowanceScheduleEntry() {
    }

    public AllowanceScheduleEntry(
           com.vsp.xl.dto.v003.CurrencyValue amount,
           com.vsp.xl.dto.v002.SimpleCode lensCharacteristicType) {
        this.amount = amount;
        this.lensCharacteristicType = lensCharacteristicType;
    }


    /**
     * Gets the amount value for this AllowanceScheduleEntry.
     * 
     * @return amount
     */
    public com.vsp.xl.dto.v003.CurrencyValue getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this AllowanceScheduleEntry.
     * 
     * @param amount
     */
    public void setAmount(com.vsp.xl.dto.v003.CurrencyValue amount) {
        this.amount = amount;
    }


    /**
     * Gets the lensCharacteristicType value for this AllowanceScheduleEntry.
     * 
     * @return lensCharacteristicType
     */
    public com.vsp.xl.dto.v002.SimpleCode getLensCharacteristicType() {
        return lensCharacteristicType;
    }


    /**
     * Sets the lensCharacteristicType value for this AllowanceScheduleEntry.
     * 
     * @param lensCharacteristicType
     */
    public void setLensCharacteristicType(com.vsp.xl.dto.v002.SimpleCode lensCharacteristicType) {
        this.lensCharacteristicType = lensCharacteristicType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AllowanceScheduleEntry)) return false;
        AllowanceScheduleEntry other = (AllowanceScheduleEntry) obj;
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
            ((this.lensCharacteristicType==null && other.getLensCharacteristicType()==null) || 
             (this.lensCharacteristicType!=null &&
              this.lensCharacteristicType.equals(other.getLensCharacteristicType())));
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
        if (getLensCharacteristicType() != null) {
            _hashCode += getLensCharacteristicType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AllowanceScheduleEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.levelofcoverage.dto.product.bl.vsp.com", "AllowanceScheduleEntry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lensCharacteristicType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lensCharacteristicType"));
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

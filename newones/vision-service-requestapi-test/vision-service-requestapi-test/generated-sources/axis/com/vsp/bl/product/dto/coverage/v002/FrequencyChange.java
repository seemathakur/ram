/**
 * FrequencyChange.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class FrequencyChange  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.product.dto.coverage.v001.Frequency frequency;

    private com.vsp.bl.inventory.dto.v001.InventoryKey changedInventoryKey;

    public FrequencyChange() {
    }

    public FrequencyChange(
           com.vsp.bl.product.dto.coverage.v001.Frequency frequency,
           com.vsp.bl.inventory.dto.v001.InventoryKey changedInventoryKey) {
        this.frequency = frequency;
        this.changedInventoryKey = changedInventoryKey;
    }


    /**
     * Gets the frequency value for this FrequencyChange.
     * 
     * @return frequency
     */
    public com.vsp.bl.product.dto.coverage.v001.Frequency getFrequency() {
        return frequency;
    }


    /**
     * Sets the frequency value for this FrequencyChange.
     * 
     * @param frequency
     */
    public void setFrequency(com.vsp.bl.product.dto.coverage.v001.Frequency frequency) {
        this.frequency = frequency;
    }


    /**
     * Gets the changedInventoryKey value for this FrequencyChange.
     * 
     * @return changedInventoryKey
     */
    public com.vsp.bl.inventory.dto.v001.InventoryKey getChangedInventoryKey() {
        return changedInventoryKey;
    }


    /**
     * Sets the changedInventoryKey value for this FrequencyChange.
     * 
     * @param changedInventoryKey
     */
    public void setChangedInventoryKey(com.vsp.bl.inventory.dto.v001.InventoryKey changedInventoryKey) {
        this.changedInventoryKey = changedInventoryKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FrequencyChange)) return false;
        FrequencyChange other = (FrequencyChange) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.frequency==null && other.getFrequency()==null) || 
             (this.frequency!=null &&
              this.frequency.equals(other.getFrequency()))) &&
            ((this.changedInventoryKey==null && other.getChangedInventoryKey()==null) || 
             (this.changedInventoryKey!=null &&
              this.changedInventoryKey.equals(other.getChangedInventoryKey())));
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
        if (getFrequency() != null) {
            _hashCode += getFrequency().hashCode();
        }
        if (getChangedInventoryKey() != null) {
            _hashCode += getChangedInventoryKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FrequencyChange.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "FrequencyChange"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "Frequency"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changedInventoryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "changedInventoryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.dto.inventory.bl.vsp.com", "InventoryKey"));
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

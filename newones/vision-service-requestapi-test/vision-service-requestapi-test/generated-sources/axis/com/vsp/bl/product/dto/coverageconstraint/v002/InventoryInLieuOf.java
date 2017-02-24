/**
 * InventoryInLieuOf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v002;

public class InventoryInLieuOf  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.product.dto.coverage.v002.FrequencyChange frequencyChange;

    private com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys;

    public InventoryInLieuOf() {
    }

    public InventoryInLieuOf(
           com.vsp.bl.product.dto.coverage.v002.FrequencyChange frequencyChange,
           com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys) {
        this.frequencyChange = frequencyChange;
        this.inventoryKeys = inventoryKeys;
    }


    /**
     * Gets the frequencyChange value for this InventoryInLieuOf.
     * 
     * @return frequencyChange
     */
    public com.vsp.bl.product.dto.coverage.v002.FrequencyChange getFrequencyChange() {
        return frequencyChange;
    }


    /**
     * Sets the frequencyChange value for this InventoryInLieuOf.
     * 
     * @param frequencyChange
     */
    public void setFrequencyChange(com.vsp.bl.product.dto.coverage.v002.FrequencyChange frequencyChange) {
        this.frequencyChange = frequencyChange;
    }


    /**
     * Gets the inventoryKeys value for this InventoryInLieuOf.
     * 
     * @return inventoryKeys
     */
    public com.vsp.bl.inventory.dto.v001.InventoryKey[] getInventoryKeys() {
        return inventoryKeys;
    }


    /**
     * Sets the inventoryKeys value for this InventoryInLieuOf.
     * 
     * @param inventoryKeys
     */
    public void setInventoryKeys(com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys) {
        this.inventoryKeys = inventoryKeys;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InventoryInLieuOf)) return false;
        InventoryInLieuOf other = (InventoryInLieuOf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.frequencyChange==null && other.getFrequencyChange()==null) || 
             (this.frequencyChange!=null &&
              this.frequencyChange.equals(other.getFrequencyChange()))) &&
            ((this.inventoryKeys==null && other.getInventoryKeys()==null) || 
             (this.inventoryKeys!=null &&
              java.util.Arrays.equals(this.inventoryKeys, other.getInventoryKeys())));
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
        if (getFrequencyChange() != null) {
            _hashCode += getFrequencyChange().hashCode();
        }
        if (getInventoryKeys() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInventoryKeys());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInventoryKeys(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InventoryInLieuOf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "InventoryInLieuOf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequencyChange");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frequencyChange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "FrequencyChange"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventoryKeys");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inventoryKeys"));
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

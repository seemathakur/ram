/**
 * EligibilityRequirement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.v002;

public class EligibilityRequirement  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.Boolean eligibilityRequired;

    private com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys;

    public EligibilityRequirement() {
    }

    public EligibilityRequirement(
           java.lang.Boolean eligibilityRequired,
           com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys) {
        this.eligibilityRequired = eligibilityRequired;
        this.inventoryKeys = inventoryKeys;
    }


    /**
     * Gets the eligibilityRequired value for this EligibilityRequirement.
     * 
     * @return eligibilityRequired
     */
    public java.lang.Boolean getEligibilityRequired() {
        return eligibilityRequired;
    }


    /**
     * Sets the eligibilityRequired value for this EligibilityRequirement.
     * 
     * @param eligibilityRequired
     */
    public void setEligibilityRequired(java.lang.Boolean eligibilityRequired) {
        this.eligibilityRequired = eligibilityRequired;
    }


    /**
     * Gets the inventoryKeys value for this EligibilityRequirement.
     * 
     * @return inventoryKeys
     */
    public com.vsp.bl.inventory.dto.v001.InventoryKey[] getInventoryKeys() {
        return inventoryKeys;
    }


    /**
     * Sets the inventoryKeys value for this EligibilityRequirement.
     * 
     * @param inventoryKeys
     */
    public void setInventoryKeys(com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys) {
        this.inventoryKeys = inventoryKeys;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EligibilityRequirement)) return false;
        EligibilityRequirement other = (EligibilityRequirement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.eligibilityRequired==null && other.getEligibilityRequired()==null) || 
             (this.eligibilityRequired!=null &&
              this.eligibilityRequired.equals(other.getEligibilityRequired()))) &&
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
        if (getEligibilityRequired() != null) {
            _hashCode += getEligibilityRequired().hashCode();
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
        new org.apache.axis.description.TypeDesc(EligibilityRequirement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "EligibilityRequirement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eligibilityRequired");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eligibilityRequired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
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

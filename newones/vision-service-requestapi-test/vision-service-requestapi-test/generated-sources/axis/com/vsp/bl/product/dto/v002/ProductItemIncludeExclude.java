/**
 * ProductItemIncludeExclude.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.v002;

public class ProductItemIncludeExclude  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.SimpleCode type;

    private com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys;

    private java.lang.String classType;

    private java.lang.Integer numberOfChoices;

    public ProductItemIncludeExclude() {
    }

    public ProductItemIncludeExclude(
           com.vsp.xl.dto.v002.SimpleCode type,
           com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys,
           java.lang.String classType,
           java.lang.Integer numberOfChoices) {
        this.type = type;
        this.inventoryKeys = inventoryKeys;
        this.classType = classType;
        this.numberOfChoices = numberOfChoices;
    }


    /**
     * Gets the type value for this ProductItemIncludeExclude.
     * 
     * @return type
     */
    public com.vsp.xl.dto.v002.SimpleCode getType() {
        return type;
    }


    /**
     * Sets the type value for this ProductItemIncludeExclude.
     * 
     * @param type
     */
    public void setType(com.vsp.xl.dto.v002.SimpleCode type) {
        this.type = type;
    }


    /**
     * Gets the inventoryKeys value for this ProductItemIncludeExclude.
     * 
     * @return inventoryKeys
     */
    public com.vsp.bl.inventory.dto.v001.InventoryKey[] getInventoryKeys() {
        return inventoryKeys;
    }


    /**
     * Sets the inventoryKeys value for this ProductItemIncludeExclude.
     * 
     * @param inventoryKeys
     */
    public void setInventoryKeys(com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys) {
        this.inventoryKeys = inventoryKeys;
    }


    /**
     * Gets the classType value for this ProductItemIncludeExclude.
     * 
     * @return classType
     */
    public java.lang.String getClassType() {
        return classType;
    }


    /**
     * Sets the classType value for this ProductItemIncludeExclude.
     * 
     * @param classType
     */
    public void setClassType(java.lang.String classType) {
        this.classType = classType;
    }


    /**
     * Gets the numberOfChoices value for this ProductItemIncludeExclude.
     * 
     * @return numberOfChoices
     */
    public java.lang.Integer getNumberOfChoices() {
        return numberOfChoices;
    }


    /**
     * Sets the numberOfChoices value for this ProductItemIncludeExclude.
     * 
     * @param numberOfChoices
     */
    public void setNumberOfChoices(java.lang.Integer numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductItemIncludeExclude)) return false;
        ProductItemIncludeExclude other = (ProductItemIncludeExclude) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.inventoryKeys==null && other.getInventoryKeys()==null) || 
             (this.inventoryKeys!=null &&
              java.util.Arrays.equals(this.inventoryKeys, other.getInventoryKeys()))) &&
            ((this.classType==null && other.getClassType()==null) || 
             (this.classType!=null &&
              this.classType.equals(other.getClassType()))) &&
            ((this.numberOfChoices==null && other.getNumberOfChoices()==null) || 
             (this.numberOfChoices!=null &&
              this.numberOfChoices.equals(other.getNumberOfChoices())));
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
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
        if (getClassType() != null) {
            _hashCode += getClassType().hashCode();
        }
        if (getNumberOfChoices() != null) {
            _hashCode += getNumberOfChoices().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductItemIncludeExclude.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductItemIncludeExclude"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventoryKeys");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inventoryKeys"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.dto.inventory.bl.vsp.com", "InventoryKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfChoices");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfChoices"));
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

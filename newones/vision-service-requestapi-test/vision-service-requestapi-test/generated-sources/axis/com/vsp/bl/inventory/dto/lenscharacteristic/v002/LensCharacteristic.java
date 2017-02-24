/**
 * LensCharacteristic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.inventory.dto.lenscharacteristic.v002;

public class LensCharacteristic  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.String description;

    private com.vsp.bl.inventory.dto.lenscharacteristic.v002.SegmentedMultifocalDTO segmentedMultifocal;

    private com.vsp.xl.dto.v002.SimpleCode category;

    private com.vsp.xl.dto.v002.SimpleCode name;

    public LensCharacteristic() {
    }

    public LensCharacteristic(
           java.lang.String description,
           com.vsp.bl.inventory.dto.lenscharacteristic.v002.SegmentedMultifocalDTO segmentedMultifocal,
           com.vsp.xl.dto.v002.SimpleCode category,
           com.vsp.xl.dto.v002.SimpleCode name) {
        this.description = description;
        this.segmentedMultifocal = segmentedMultifocal;
        this.category = category;
        this.name = name;
    }


    /**
     * Gets the description value for this LensCharacteristic.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this LensCharacteristic.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the segmentedMultifocal value for this LensCharacteristic.
     * 
     * @return segmentedMultifocal
     */
    public com.vsp.bl.inventory.dto.lenscharacteristic.v002.SegmentedMultifocalDTO getSegmentedMultifocal() {
        return segmentedMultifocal;
    }


    /**
     * Sets the segmentedMultifocal value for this LensCharacteristic.
     * 
     * @param segmentedMultifocal
     */
    public void setSegmentedMultifocal(com.vsp.bl.inventory.dto.lenscharacteristic.v002.SegmentedMultifocalDTO segmentedMultifocal) {
        this.segmentedMultifocal = segmentedMultifocal;
    }


    /**
     * Gets the category value for this LensCharacteristic.
     * 
     * @return category
     */
    public com.vsp.xl.dto.v002.SimpleCode getCategory() {
        return category;
    }


    /**
     * Sets the category value for this LensCharacteristic.
     * 
     * @param category
     */
    public void setCategory(com.vsp.xl.dto.v002.SimpleCode category) {
        this.category = category;
    }


    /**
     * Gets the name value for this LensCharacteristic.
     * 
     * @return name
     */
    public com.vsp.xl.dto.v002.SimpleCode getName() {
        return name;
    }


    /**
     * Sets the name value for this LensCharacteristic.
     * 
     * @param name
     */
    public void setName(com.vsp.xl.dto.v002.SimpleCode name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LensCharacteristic)) return false;
        LensCharacteristic other = (LensCharacteristic) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.segmentedMultifocal==null && other.getSegmentedMultifocal()==null) || 
             (this.segmentedMultifocal!=null &&
              this.segmentedMultifocal.equals(other.getSegmentedMultifocal()))) &&
            ((this.category==null && other.getCategory()==null) || 
             (this.category!=null &&
              this.category.equals(other.getCategory()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getSegmentedMultifocal() != null) {
            _hashCode += getSegmentedMultifocal().hashCode();
        }
        if (getCategory() != null) {
            _hashCode += getCategory().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LensCharacteristic.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.lenscharacteristic.dto.inventory.bl.vsp.com", "LensCharacteristic"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentedMultifocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segmentedMultifocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.lenscharacteristic.dto.inventory.bl.vsp.com", "SegmentedMultifocalDTO"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("category");
        elemField.setXmlName(new javax.xml.namespace.QName("", "category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
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

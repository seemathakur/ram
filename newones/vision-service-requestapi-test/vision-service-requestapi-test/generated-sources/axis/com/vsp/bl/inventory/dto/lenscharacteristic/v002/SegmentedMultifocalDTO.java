/**
 * SegmentedMultifocalDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.inventory.dto.lenscharacteristic.v002;

public class SegmentedMultifocalDTO  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.SimpleCode powerSplit;

    private com.vsp.xl.dto.v002.SimpleCode segmentSize;

    private com.vsp.xl.dto.v002.SimpleCode shapeType;

    private com.vsp.xl.dto.v002.SimpleCode name;

    public SegmentedMultifocalDTO() {
    }

    public SegmentedMultifocalDTO(
           com.vsp.xl.dto.v002.SimpleCode powerSplit,
           com.vsp.xl.dto.v002.SimpleCode segmentSize,
           com.vsp.xl.dto.v002.SimpleCode shapeType,
           com.vsp.xl.dto.v002.SimpleCode name) {
           this.powerSplit = powerSplit;
           this.segmentSize = segmentSize;
           this.shapeType = shapeType;
           this.name = name;
    }


    /**
     * Gets the powerSplit value for this SegmentedMultifocalDTO.
     * 
     * @return powerSplit
     */
    public com.vsp.xl.dto.v002.SimpleCode getPowerSplit() {
        return powerSplit;
    }


    /**
     * Sets the powerSplit value for this SegmentedMultifocalDTO.
     * 
     * @param powerSplit
     */
    public void setPowerSplit(com.vsp.xl.dto.v002.SimpleCode powerSplit) {
        this.powerSplit = powerSplit;
    }


    /**
     * Gets the segmentSize value for this SegmentedMultifocalDTO.
     * 
     * @return segmentSize
     */
    public com.vsp.xl.dto.v002.SimpleCode getSegmentSize() {
        return segmentSize;
    }


    /**
     * Sets the segmentSize value for this SegmentedMultifocalDTO.
     * 
     * @param segmentSize
     */
    public void setSegmentSize(com.vsp.xl.dto.v002.SimpleCode segmentSize) {
        this.segmentSize = segmentSize;
    }


    /**
     * Gets the shapeType value for this SegmentedMultifocalDTO.
     * 
     * @return shapeType
     */
    public com.vsp.xl.dto.v002.SimpleCode getShapeType() {
        return shapeType;
    }


    /**
     * Sets the shapeType value for this SegmentedMultifocalDTO.
     * 
     * @param shapeType
     */
    public void setShapeType(com.vsp.xl.dto.v002.SimpleCode shapeType) {
        this.shapeType = shapeType;
    }


    /**
     * Gets the name value for this SegmentedMultifocalDTO.
     * 
     * @return name
     */
    public com.vsp.xl.dto.v002.SimpleCode getName() {
        return name;
    }


    /**
     * Sets the name value for this SegmentedMultifocalDTO.
     * 
     * @param name
     */
    public void setName(com.vsp.xl.dto.v002.SimpleCode name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SegmentedMultifocalDTO)) return false;
        SegmentedMultifocalDTO other = (SegmentedMultifocalDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.powerSplit==null && other.getPowerSplit()==null) || 
             (this.powerSplit!=null &&
              this.powerSplit.equals(other.getPowerSplit()))) &&
            ((this.segmentSize==null && other.getSegmentSize()==null) || 
             (this.segmentSize!=null &&
              this.segmentSize.equals(other.getSegmentSize()))) &&
            ((this.shapeType==null && other.getShapeType()==null) || 
             (this.shapeType!=null &&
              this.shapeType.equals(other.getShapeType()))) &&
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
        int _hashCode = 1;
        if (getPowerSplit() != null) {
            _hashCode += getPowerSplit().hashCode();
        }
        if (getSegmentSize() != null) {
            _hashCode += getSegmentSize().hashCode();
        }
        if (getShapeType() != null) {
            _hashCode += getShapeType().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SegmentedMultifocalDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.lenscharacteristic.dto.inventory.bl.vsp.com", "SegmentedMultifocalDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("powerSplit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "powerSplit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segmentSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shapeType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shapeType"));
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

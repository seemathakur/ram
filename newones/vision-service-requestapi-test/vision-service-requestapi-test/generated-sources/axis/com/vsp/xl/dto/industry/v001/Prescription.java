/**
 * Prescription.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.xl.dto.industry.v001;

public class Prescription  implements java.io.Serializable {
    private java.lang.Float add;

    private java.lang.Integer axis;

    private java.lang.Float cylinder;

    private java.lang.Float horizPrism;

    private java.lang.Integer segHeight;

    private java.lang.Integer segWidth;

    private java.lang.Float sphere;

    private java.lang.Float vertPrism;

    public Prescription() {
    }

    public Prescription(
           java.lang.Float add,
           java.lang.Integer axis,
           java.lang.Float cylinder,
           java.lang.Float horizPrism,
           java.lang.Integer segHeight,
           java.lang.Integer segWidth,
           java.lang.Float sphere,
           java.lang.Float vertPrism) {
           this.add = add;
           this.axis = axis;
           this.cylinder = cylinder;
           this.horizPrism = horizPrism;
           this.segHeight = segHeight;
           this.segWidth = segWidth;
           this.sphere = sphere;
           this.vertPrism = vertPrism;
    }


    /**
     * Gets the add value for this Prescription.
     * 
     * @return add
     */
    public java.lang.Float getAdd() {
        return add;
    }


    /**
     * Sets the add value for this Prescription.
     * 
     * @param add
     */
    public void setAdd(java.lang.Float add) {
        this.add = add;
    }


    /**
     * Gets the axis value for this Prescription.
     * 
     * @return axis
     */
    public java.lang.Integer getAxis() {
        return axis;
    }


    /**
     * Sets the axis value for this Prescription.
     * 
     * @param axis
     */
    public void setAxis(java.lang.Integer axis) {
        this.axis = axis;
    }


    /**
     * Gets the cylinder value for this Prescription.
     * 
     * @return cylinder
     */
    public java.lang.Float getCylinder() {
        return cylinder;
    }


    /**
     * Sets the cylinder value for this Prescription.
     * 
     * @param cylinder
     */
    public void setCylinder(java.lang.Float cylinder) {
        this.cylinder = cylinder;
    }


    /**
     * Gets the horizPrism value for this Prescription.
     * 
     * @return horizPrism
     */
    public java.lang.Float getHorizPrism() {
        return horizPrism;
    }


    /**
     * Sets the horizPrism value for this Prescription.
     * 
     * @param horizPrism
     */
    public void setHorizPrism(java.lang.Float horizPrism) {
        this.horizPrism = horizPrism;
    }


    /**
     * Gets the segHeight value for this Prescription.
     * 
     * @return segHeight
     */
    public java.lang.Integer getSegHeight() {
        return segHeight;
    }


    /**
     * Sets the segHeight value for this Prescription.
     * 
     * @param segHeight
     */
    public void setSegHeight(java.lang.Integer segHeight) {
        this.segHeight = segHeight;
    }


    /**
     * Gets the segWidth value for this Prescription.
     * 
     * @return segWidth
     */
    public java.lang.Integer getSegWidth() {
        return segWidth;
    }


    /**
     * Sets the segWidth value for this Prescription.
     * 
     * @param segWidth
     */
    public void setSegWidth(java.lang.Integer segWidth) {
        this.segWidth = segWidth;
    }


    /**
     * Gets the sphere value for this Prescription.
     * 
     * @return sphere
     */
    public java.lang.Float getSphere() {
        return sphere;
    }


    /**
     * Sets the sphere value for this Prescription.
     * 
     * @param sphere
     */
    public void setSphere(java.lang.Float sphere) {
        this.sphere = sphere;
    }


    /**
     * Gets the vertPrism value for this Prescription.
     * 
     * @return vertPrism
     */
    public java.lang.Float getVertPrism() {
        return vertPrism;
    }


    /**
     * Sets the vertPrism value for this Prescription.
     * 
     * @param vertPrism
     */
    public void setVertPrism(java.lang.Float vertPrism) {
        this.vertPrism = vertPrism;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Prescription)) return false;
        Prescription other = (Prescription) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.add==null && other.getAdd()==null) || 
             (this.add!=null &&
              this.add.equals(other.getAdd()))) &&
            ((this.axis==null && other.getAxis()==null) || 
             (this.axis!=null &&
              this.axis.equals(other.getAxis()))) &&
            ((this.cylinder==null && other.getCylinder()==null) || 
             (this.cylinder!=null &&
              this.cylinder.equals(other.getCylinder()))) &&
            ((this.horizPrism==null && other.getHorizPrism()==null) || 
             (this.horizPrism!=null &&
              this.horizPrism.equals(other.getHorizPrism()))) &&
            ((this.segHeight==null && other.getSegHeight()==null) || 
             (this.segHeight!=null &&
              this.segHeight.equals(other.getSegHeight()))) &&
            ((this.segWidth==null && other.getSegWidth()==null) || 
             (this.segWidth!=null &&
              this.segWidth.equals(other.getSegWidth()))) &&
            ((this.sphere==null && other.getSphere()==null) || 
             (this.sphere!=null &&
              this.sphere.equals(other.getSphere()))) &&
            ((this.vertPrism==null && other.getVertPrism()==null) || 
             (this.vertPrism!=null &&
              this.vertPrism.equals(other.getVertPrism())));
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
        if (getAdd() != null) {
            _hashCode += getAdd().hashCode();
        }
        if (getAxis() != null) {
            _hashCode += getAxis().hashCode();
        }
        if (getCylinder() != null) {
            _hashCode += getCylinder().hashCode();
        }
        if (getHorizPrism() != null) {
            _hashCode += getHorizPrism().hashCode();
        }
        if (getSegHeight() != null) {
            _hashCode += getSegHeight().hashCode();
        }
        if (getSegWidth() != null) {
            _hashCode += getSegWidth().hashCode();
        }
        if (getSphere() != null) {
            _hashCode += getSphere().hashCode();
        }
        if (getVertPrism() != null) {
            _hashCode += getVertPrism().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Prescription.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.industry.dto.xl.vsp.com", "Prescription"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("add");
        elemField.setXmlName(new javax.xml.namespace.QName("", "add"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("axis");
        elemField.setXmlName(new javax.xml.namespace.QName("", "axis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cylinder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cylinder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horizPrism");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horizPrism"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segHeight");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segHeight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segWidth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segWidth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sphere");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sphere"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vertPrism");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vertPrism"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
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

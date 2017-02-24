/**
 * ConstraintType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v002;

public class ConstraintType  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.Boolean leaveOut;

    private com.vsp.xl.dto.v002.SimpleCode[] constraintTypeValues;

    private com.vsp.bl.inventory.dto.lenscharacteristic.v001.ContactLensCharacteristic contactLensCharacteristic;

    private com.vsp.xl.dto.v002.SimpleCode constraintType;

    private com.vsp.bl.product.dto.coverageconstraint.v002.Color color;

    private com.vsp.bl.inventory.dto.lenscharacteristic.v002.LensCharacteristic lensCharacteristic;

    public ConstraintType() {
    }

    public ConstraintType(
           java.lang.Boolean leaveOut,
           com.vsp.xl.dto.v002.SimpleCode[] constraintTypeValues,
           com.vsp.bl.inventory.dto.lenscharacteristic.v001.ContactLensCharacteristic contactLensCharacteristic,
           com.vsp.xl.dto.v002.SimpleCode constraintType,
           com.vsp.bl.product.dto.coverageconstraint.v002.Color color,
           com.vsp.bl.inventory.dto.lenscharacteristic.v002.LensCharacteristic lensCharacteristic) {
        this.leaveOut = leaveOut;
        this.constraintTypeValues = constraintTypeValues;
        this.contactLensCharacteristic = contactLensCharacteristic;
        this.constraintType = constraintType;
        this.color = color;
        this.lensCharacteristic = lensCharacteristic;
    }


    /**
     * Gets the leaveOut value for this ConstraintType.
     * 
     * @return leaveOut
     */
    public java.lang.Boolean getLeaveOut() {
        return leaveOut;
    }


    /**
     * Sets the leaveOut value for this ConstraintType.
     * 
     * @param leaveOut
     */
    public void setLeaveOut(java.lang.Boolean leaveOut) {
        this.leaveOut = leaveOut;
    }


    /**
     * Gets the constraintTypeValues value for this ConstraintType.
     * 
     * @return constraintTypeValues
     */
    public com.vsp.xl.dto.v002.SimpleCode[] getConstraintTypeValues() {
        return constraintTypeValues;
    }


    /**
     * Sets the constraintTypeValues value for this ConstraintType.
     * 
     * @param constraintTypeValues
     */
    public void setConstraintTypeValues(com.vsp.xl.dto.v002.SimpleCode[] constraintTypeValues) {
        this.constraintTypeValues = constraintTypeValues;
    }


    /**
     * Gets the contactLensCharacteristic value for this ConstraintType.
     * 
     * @return contactLensCharacteristic
     */
    public com.vsp.bl.inventory.dto.lenscharacteristic.v001.ContactLensCharacteristic getContactLensCharacteristic() {
        return contactLensCharacteristic;
    }


    /**
     * Sets the contactLensCharacteristic value for this ConstraintType.
     * 
     * @param contactLensCharacteristic
     */
    public void setContactLensCharacteristic(com.vsp.bl.inventory.dto.lenscharacteristic.v001.ContactLensCharacteristic contactLensCharacteristic) {
        this.contactLensCharacteristic = contactLensCharacteristic;
    }


    /**
     * Gets the constraintType value for this ConstraintType.
     * 
     * @return constraintType
     */
    public com.vsp.xl.dto.v002.SimpleCode getConstraintType() {
        return constraintType;
    }


    /**
     * Sets the constraintType value for this ConstraintType.
     * 
     * @param constraintType
     */
    public void setConstraintType(com.vsp.xl.dto.v002.SimpleCode constraintType) {
        this.constraintType = constraintType;
    }


    /**
     * Gets the color value for this ConstraintType.
     * 
     * @return color
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.Color getColor() {
        return color;
    }


    /**
     * Sets the color value for this ConstraintType.
     * 
     * @param color
     */
    public void setColor(com.vsp.bl.product.dto.coverageconstraint.v002.Color color) {
        this.color = color;
    }


    /**
     * Gets the lensCharacteristic value for this ConstraintType.
     * 
     * @return lensCharacteristic
     */
    public com.vsp.bl.inventory.dto.lenscharacteristic.v002.LensCharacteristic getLensCharacteristic() {
        return lensCharacteristic;
    }


    /**
     * Sets the lensCharacteristic value for this ConstraintType.
     * 
     * @param lensCharacteristic
     */
    public void setLensCharacteristic(com.vsp.bl.inventory.dto.lenscharacteristic.v002.LensCharacteristic lensCharacteristic) {
        this.lensCharacteristic = lensCharacteristic;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConstraintType)) return false;
        ConstraintType other = (ConstraintType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.leaveOut==null && other.getLeaveOut()==null) || 
             (this.leaveOut!=null &&
              this.leaveOut.equals(other.getLeaveOut()))) &&
            ((this.constraintTypeValues==null && other.getConstraintTypeValues()==null) || 
             (this.constraintTypeValues!=null &&
              java.util.Arrays.equals(this.constraintTypeValues, other.getConstraintTypeValues()))) &&
            ((this.contactLensCharacteristic==null && other.getContactLensCharacteristic()==null) || 
             (this.contactLensCharacteristic!=null &&
              this.contactLensCharacteristic.equals(other.getContactLensCharacteristic()))) &&
            ((this.constraintType==null && other.getConstraintType()==null) || 
             (this.constraintType!=null &&
              this.constraintType.equals(other.getConstraintType()))) &&
            ((this.color==null && other.getColor()==null) || 
             (this.color!=null &&
              this.color.equals(other.getColor()))) &&
            ((this.lensCharacteristic==null && other.getLensCharacteristic()==null) || 
             (this.lensCharacteristic!=null &&
              this.lensCharacteristic.equals(other.getLensCharacteristic())));
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
        if (getLeaveOut() != null) {
            _hashCode += getLeaveOut().hashCode();
        }
        if (getConstraintTypeValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConstraintTypeValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConstraintTypeValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContactLensCharacteristic() != null) {
            _hashCode += getContactLensCharacteristic().hashCode();
        }
        if (getConstraintType() != null) {
            _hashCode += getConstraintType().hashCode();
        }
        if (getColor() != null) {
            _hashCode += getColor().hashCode();
        }
        if (getLensCharacteristic() != null) {
            _hashCode += getLensCharacteristic().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConstraintType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ConstraintType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leaveOut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leaveOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("constraintTypeValues");
        elemField.setXmlName(new javax.xml.namespace.QName("", "constraintTypeValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactLensCharacteristic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contactLensCharacteristic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.lenscharacteristic.dto.inventory.bl.vsp.com", "ContactLensCharacteristic"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("constraintType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "constraintType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("color");
        elemField.setXmlName(new javax.xml.namespace.QName("", "color"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "Color"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lensCharacteristic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lensCharacteristic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.lenscharacteristic.dto.inventory.bl.vsp.com", "LensCharacteristic"));
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

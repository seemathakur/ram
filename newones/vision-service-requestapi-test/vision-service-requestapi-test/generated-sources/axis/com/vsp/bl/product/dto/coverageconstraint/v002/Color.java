/**
 * Color.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v002;

public class Color  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.product.dto.coverageconstraint.v002.AbsorptionLevel absorptionLevel;

    private com.vsp.xl.dto.v002.SimpleCode colorCode;

    public Color() {
    }

    public Color(
           com.vsp.bl.product.dto.coverageconstraint.v002.AbsorptionLevel absorptionLevel,
           com.vsp.xl.dto.v002.SimpleCode colorCode) {
        this.absorptionLevel = absorptionLevel;
        this.colorCode = colorCode;
    }


    /**
     * Gets the absorptionLevel value for this Color.
     * 
     * @return absorptionLevel
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.AbsorptionLevel getAbsorptionLevel() {
        return absorptionLevel;
    }


    /**
     * Sets the absorptionLevel value for this Color.
     * 
     * @param absorptionLevel
     */
    public void setAbsorptionLevel(com.vsp.bl.product.dto.coverageconstraint.v002.AbsorptionLevel absorptionLevel) {
        this.absorptionLevel = absorptionLevel;
    }


    /**
     * Gets the colorCode value for this Color.
     * 
     * @return colorCode
     */
    public com.vsp.xl.dto.v002.SimpleCode getColorCode() {
        return colorCode;
    }


    /**
     * Sets the colorCode value for this Color.
     * 
     * @param colorCode
     */
    public void setColorCode(com.vsp.xl.dto.v002.SimpleCode colorCode) {
        this.colorCode = colorCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Color)) return false;
        Color other = (Color) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.absorptionLevel==null && other.getAbsorptionLevel()==null) || 
             (this.absorptionLevel!=null &&
              this.absorptionLevel.equals(other.getAbsorptionLevel()))) &&
            ((this.colorCode==null && other.getColorCode()==null) || 
             (this.colorCode!=null &&
              this.colorCode.equals(other.getColorCode())));
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
        if (getAbsorptionLevel() != null) {
            _hashCode += getAbsorptionLevel().hashCode();
        }
        if (getColorCode() != null) {
            _hashCode += getColorCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Color.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "Color"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("absorptionLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "absorptionLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "AbsorptionLevel"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("colorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "colorCode"));
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

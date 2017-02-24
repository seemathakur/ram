/**
 * AbsorptionLevel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v002;

public class AbsorptionLevel  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.SimpleCode absorptionLevelCode;

    public AbsorptionLevel() {
    }

    public AbsorptionLevel(
           com.vsp.xl.dto.v002.SimpleCode absorptionLevelCode) {
        this.absorptionLevelCode = absorptionLevelCode;
    }


    /**
     * Gets the absorptionLevelCode value for this AbsorptionLevel.
     * 
     * @return absorptionLevelCode
     */
    public com.vsp.xl.dto.v002.SimpleCode getAbsorptionLevelCode() {
        return absorptionLevelCode;
    }


    /**
     * Sets the absorptionLevelCode value for this AbsorptionLevel.
     * 
     * @param absorptionLevelCode
     */
    public void setAbsorptionLevelCode(com.vsp.xl.dto.v002.SimpleCode absorptionLevelCode) {
        this.absorptionLevelCode = absorptionLevelCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AbsorptionLevel)) return false;
        AbsorptionLevel other = (AbsorptionLevel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.absorptionLevelCode==null && other.getAbsorptionLevelCode()==null) || 
             (this.absorptionLevelCode!=null &&
              this.absorptionLevelCode.equals(other.getAbsorptionLevelCode())));
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
        if (getAbsorptionLevelCode() != null) {
            _hashCode += getAbsorptionLevelCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AbsorptionLevel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "AbsorptionLevel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("absorptionLevelCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "absorptionLevelCode"));
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

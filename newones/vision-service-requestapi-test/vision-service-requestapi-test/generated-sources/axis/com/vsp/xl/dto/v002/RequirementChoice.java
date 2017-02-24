/**
 * RequirementChoice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.xl.dto.v002;

public class RequirementChoice  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.Boolean isRequirement;

    private int numberOfChoices;

    public RequirementChoice() {
    }

    public RequirementChoice(
           java.lang.Boolean isRequirement,
           int numberOfChoices) {
        this.isRequirement = isRequirement;
        this.numberOfChoices = numberOfChoices;
    }


    /**
     * Gets the isRequirement value for this RequirementChoice.
     * 
     * @return isRequirement
     */
    public java.lang.Boolean getIsRequirement() {
        return isRequirement;
    }


    /**
     * Sets the isRequirement value for this RequirementChoice.
     * 
     * @param isRequirement
     */
    public void setIsRequirement(java.lang.Boolean isRequirement) {
        this.isRequirement = isRequirement;
    }


    /**
     * Gets the numberOfChoices value for this RequirementChoice.
     * 
     * @return numberOfChoices
     */
    public int getNumberOfChoices() {
        return numberOfChoices;
    }


    /**
     * Sets the numberOfChoices value for this RequirementChoice.
     * 
     * @param numberOfChoices
     */
    public void setNumberOfChoices(int numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequirementChoice)) return false;
        RequirementChoice other = (RequirementChoice) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.isRequirement==null && other.getIsRequirement()==null) || 
             (this.isRequirement!=null &&
              this.isRequirement.equals(other.getIsRequirement()))) &&
            this.numberOfChoices == other.getNumberOfChoices();
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
        if (getIsRequirement() != null) {
            _hashCode += getIsRequirement().hashCode();
        }
        _hashCode += getNumberOfChoices();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequirementChoice.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "RequirementChoice"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isRequirement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isRequirement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfChoices");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfChoices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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

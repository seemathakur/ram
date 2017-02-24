/**
 * COBExceptionRule.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.cob.v002;

public class COBExceptionRule  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.SimpleCode[] cobConstraintType;

    private com.vsp.xl.dto.v002.SimpleCode[] cobOutcomeType;

    private com.vsp.bl.product.dto.coverage.v002.PatientRelationship[] patientRelationships;

    private java.lang.Boolean required;

    public COBExceptionRule() {
    }

    public COBExceptionRule(
           com.vsp.xl.dto.v002.SimpleCode[] cobConstraintType,
           com.vsp.xl.dto.v002.SimpleCode[] cobOutcomeType,
           com.vsp.bl.product.dto.coverage.v002.PatientRelationship[] patientRelationships,
           java.lang.Boolean required) {
        this.cobConstraintType = cobConstraintType;
        this.cobOutcomeType = cobOutcomeType;
        this.patientRelationships = patientRelationships;
        this.required = required;
    }


    /**
     * Gets the cobConstraintType value for this COBExceptionRule.
     * 
     * @return cobConstraintType
     */
    public com.vsp.xl.dto.v002.SimpleCode[] getCobConstraintType() {
        return cobConstraintType;
    }


    /**
     * Sets the cobConstraintType value for this COBExceptionRule.
     * 
     * @param cobConstraintType
     */
    public void setCobConstraintType(com.vsp.xl.dto.v002.SimpleCode[] cobConstraintType) {
        this.cobConstraintType = cobConstraintType;
    }


    /**
     * Gets the cobOutcomeType value for this COBExceptionRule.
     * 
     * @return cobOutcomeType
     */
    public com.vsp.xl.dto.v002.SimpleCode[] getCobOutcomeType() {
        return cobOutcomeType;
    }


    /**
     * Sets the cobOutcomeType value for this COBExceptionRule.
     * 
     * @param cobOutcomeType
     */
    public void setCobOutcomeType(com.vsp.xl.dto.v002.SimpleCode[] cobOutcomeType) {
        this.cobOutcomeType = cobOutcomeType;
    }


    /**
     * Gets the patientRelationships value for this COBExceptionRule.
     * 
     * @return patientRelationships
     */
    public com.vsp.bl.product.dto.coverage.v002.PatientRelationship[] getPatientRelationships() {
        return patientRelationships;
    }


    /**
     * Sets the patientRelationships value for this COBExceptionRule.
     * 
     * @param patientRelationships
     */
    public void setPatientRelationships(com.vsp.bl.product.dto.coverage.v002.PatientRelationship[] patientRelationships) {
        this.patientRelationships = patientRelationships;
    }


    /**
     * Gets the required value for this COBExceptionRule.
     * 
     * @return required
     */
    public java.lang.Boolean getRequired() {
        return required;
    }


    /**
     * Sets the required value for this COBExceptionRule.
     * 
     * @param required
     */
    public void setRequired(java.lang.Boolean required) {
        this.required = required;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof COBExceptionRule)) return false;
        COBExceptionRule other = (COBExceptionRule) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cobConstraintType==null && other.getCobConstraintType()==null) || 
             (this.cobConstraintType!=null &&
              java.util.Arrays.equals(this.cobConstraintType, other.getCobConstraintType()))) &&
            ((this.cobOutcomeType==null && other.getCobOutcomeType()==null) || 
             (this.cobOutcomeType!=null &&
              java.util.Arrays.equals(this.cobOutcomeType, other.getCobOutcomeType()))) &&
            ((this.patientRelationships==null && other.getPatientRelationships()==null) || 
             (this.patientRelationships!=null &&
              java.util.Arrays.equals(this.patientRelationships, other.getPatientRelationships()))) &&
            ((this.required==null && other.getRequired()==null) || 
             (this.required!=null &&
              this.required.equals(other.getRequired())));
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
        if (getCobConstraintType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCobConstraintType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCobConstraintType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCobOutcomeType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCobOutcomeType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCobOutcomeType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPatientRelationships() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPatientRelationships());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPatientRelationships(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRequired() != null) {
            _hashCode += getRequired().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(COBExceptionRule.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.cob.dto.product.bl.vsp.com", "COBExceptionRule"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cobConstraintType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cobConstraintType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cobOutcomeType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cobOutcomeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientRelationships");
        elemField.setXmlName(new javax.xml.namespace.QName("", "patientRelationships"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PatientRelationship"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("required");
        elemField.setXmlName(new javax.xml.namespace.QName("", "required"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
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

/**
 * Condition.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class Condition  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.industry.v001.DiagnosticConditionKey diagnosticCondition;

    private com.vsp.bl.product.dto.coverage.v002.PrescriptionConstraint[] prescriptionConstraints;

    private java.lang.Boolean doctorRecommendation;

    private com.vsp.xl.dto.v002.RequirementChoice conditionType;

    public Condition() {
    }

    public Condition(
           com.vsp.xl.dto.industry.v001.DiagnosticConditionKey diagnosticCondition,
           com.vsp.bl.product.dto.coverage.v002.PrescriptionConstraint[] prescriptionConstraints,
           java.lang.Boolean doctorRecommendation,
           com.vsp.xl.dto.v002.RequirementChoice conditionType) {
        this.diagnosticCondition = diagnosticCondition;
        this.prescriptionConstraints = prescriptionConstraints;
        this.doctorRecommendation = doctorRecommendation;
        this.conditionType = conditionType;
    }


    /**
     * Gets the diagnosticCondition value for this Condition.
     * 
     * @return diagnosticCondition
     */
    public com.vsp.xl.dto.industry.v001.DiagnosticConditionKey getDiagnosticCondition() {
        return diagnosticCondition;
    }


    /**
     * Sets the diagnosticCondition value for this Condition.
     * 
     * @param diagnosticCondition
     */
    public void setDiagnosticCondition(com.vsp.xl.dto.industry.v001.DiagnosticConditionKey diagnosticCondition) {
        this.diagnosticCondition = diagnosticCondition;
    }


    /**
     * Gets the prescriptionConstraints value for this Condition.
     * 
     * @return prescriptionConstraints
     */
    public com.vsp.bl.product.dto.coverage.v002.PrescriptionConstraint[] getPrescriptionConstraints() {
        return prescriptionConstraints;
    }


    /**
     * Sets the prescriptionConstraints value for this Condition.
     * 
     * @param prescriptionConstraints
     */
    public void setPrescriptionConstraints(com.vsp.bl.product.dto.coverage.v002.PrescriptionConstraint[] prescriptionConstraints) {
        this.prescriptionConstraints = prescriptionConstraints;
    }


    /**
     * Gets the doctorRecommendation value for this Condition.
     * 
     * @return doctorRecommendation
     */
    public java.lang.Boolean getDoctorRecommendation() {
        return doctorRecommendation;
    }


    /**
     * Sets the doctorRecommendation value for this Condition.
     * 
     * @param doctorRecommendation
     */
    public void setDoctorRecommendation(java.lang.Boolean doctorRecommendation) {
        this.doctorRecommendation = doctorRecommendation;
    }


    /**
     * Gets the conditionType value for this Condition.
     * 
     * @return conditionType
     */
    public com.vsp.xl.dto.v002.RequirementChoice getConditionType() {
        return conditionType;
    }


    /**
     * Sets the conditionType value for this Condition.
     * 
     * @param conditionType
     */
    public void setConditionType(com.vsp.xl.dto.v002.RequirementChoice conditionType) {
        this.conditionType = conditionType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Condition)) return false;
        Condition other = (Condition) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.diagnosticCondition==null && other.getDiagnosticCondition()==null) || 
             (this.diagnosticCondition!=null &&
              this.diagnosticCondition.equals(other.getDiagnosticCondition()))) &&
            ((this.prescriptionConstraints==null && other.getPrescriptionConstraints()==null) || 
             (this.prescriptionConstraints!=null &&
              java.util.Arrays.equals(this.prescriptionConstraints, other.getPrescriptionConstraints()))) &&
            ((this.doctorRecommendation==null && other.getDoctorRecommendation()==null) || 
             (this.doctorRecommendation!=null &&
              this.doctorRecommendation.equals(other.getDoctorRecommendation()))) &&
            ((this.conditionType==null && other.getConditionType()==null) || 
             (this.conditionType!=null &&
              this.conditionType.equals(other.getConditionType())));
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
        if (getDiagnosticCondition() != null) {
            _hashCode += getDiagnosticCondition().hashCode();
        }
        if (getPrescriptionConstraints() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrescriptionConstraints());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrescriptionConstraints(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDoctorRecommendation() != null) {
            _hashCode += getDoctorRecommendation().hashCode();
        }
        if (getConditionType() != null) {
            _hashCode += getConditionType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Condition.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "Condition"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diagnosticCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diagnosticCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.industry.dto.xl.vsp.com", "DiagnosticConditionKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prescriptionConstraints");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prescriptionConstraints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PrescriptionConstraint"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doctorRecommendation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "doctorRecommendation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conditionType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conditionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "RequirementChoice"));
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

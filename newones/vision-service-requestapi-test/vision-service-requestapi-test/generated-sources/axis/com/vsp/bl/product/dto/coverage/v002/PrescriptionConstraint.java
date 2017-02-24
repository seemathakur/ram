/**
 * PrescriptionConstraint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class PrescriptionConstraint  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.SimpleCode constraintType;

    private com.vsp.xl.dto.industry.v001.Prescription prescription;

    private java.lang.Integer nbrOfEyeChartLines;

    public PrescriptionConstraint() {
    }

    public PrescriptionConstraint(
           com.vsp.xl.dto.v002.SimpleCode constraintType,
           com.vsp.xl.dto.industry.v001.Prescription prescription,
           java.lang.Integer nbrOfEyeChartLines) {
        this.constraintType = constraintType;
        this.prescription = prescription;
        this.nbrOfEyeChartLines = nbrOfEyeChartLines;
    }


    /**
     * Gets the constraintType value for this PrescriptionConstraint.
     * 
     * @return constraintType
     */
    public com.vsp.xl.dto.v002.SimpleCode getConstraintType() {
        return constraintType;
    }


    /**
     * Sets the constraintType value for this PrescriptionConstraint.
     * 
     * @param constraintType
     */
    public void setConstraintType(com.vsp.xl.dto.v002.SimpleCode constraintType) {
        this.constraintType = constraintType;
    }


    /**
     * Gets the prescription value for this PrescriptionConstraint.
     * 
     * @return prescription
     */
    public com.vsp.xl.dto.industry.v001.Prescription getPrescription() {
        return prescription;
    }


    /**
     * Sets the prescription value for this PrescriptionConstraint.
     * 
     * @param prescription
     */
    public void setPrescription(com.vsp.xl.dto.industry.v001.Prescription prescription) {
        this.prescription = prescription;
    }


    /**
     * Gets the nbrOfEyeChartLines value for this PrescriptionConstraint.
     * 
     * @return nbrOfEyeChartLines
     */
    public java.lang.Integer getNbrOfEyeChartLines() {
        return nbrOfEyeChartLines;
    }


    /**
     * Sets the nbrOfEyeChartLines value for this PrescriptionConstraint.
     * 
     * @param nbrOfEyeChartLines
     */
    public void setNbrOfEyeChartLines(java.lang.Integer nbrOfEyeChartLines) {
        this.nbrOfEyeChartLines = nbrOfEyeChartLines;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrescriptionConstraint)) return false;
        PrescriptionConstraint other = (PrescriptionConstraint) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.constraintType==null && other.getConstraintType()==null) || 
             (this.constraintType!=null &&
              this.constraintType.equals(other.getConstraintType()))) &&
            ((this.prescription==null && other.getPrescription()==null) || 
             (this.prescription!=null &&
              this.prescription.equals(other.getPrescription()))) &&
            ((this.nbrOfEyeChartLines==null && other.getNbrOfEyeChartLines()==null) || 
             (this.nbrOfEyeChartLines!=null &&
              this.nbrOfEyeChartLines.equals(other.getNbrOfEyeChartLines())));
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
        if (getConstraintType() != null) {
            _hashCode += getConstraintType().hashCode();
        }
        if (getPrescription() != null) {
            _hashCode += getPrescription().hashCode();
        }
        if (getNbrOfEyeChartLines() != null) {
            _hashCode += getNbrOfEyeChartLines().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrescriptionConstraint.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PrescriptionConstraint"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("constraintType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "constraintType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.industry.dto.xl.vsp.com", "Prescription"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nbrOfEyeChartLines");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nbrOfEyeChartLines"));
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

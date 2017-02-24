/**
 * PatientHistoryConstraint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v002;

public class PatientHistoryConstraint  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.SimpleCode patientHistoryConstraintCode;

    private com.vsp.bl.product.dto.coverage.v001.Frequency frequency;

    private com.vsp.bl.product.dto.v002.ProductItemIncludeExclude[] includeExcludes;

    private com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys;

    public PatientHistoryConstraint() {
    }

    public PatientHistoryConstraint(
           com.vsp.xl.dto.v002.SimpleCode patientHistoryConstraintCode,
           com.vsp.bl.product.dto.coverage.v001.Frequency frequency,
           com.vsp.bl.product.dto.v002.ProductItemIncludeExclude[] includeExcludes,
           com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys) {
        this.patientHistoryConstraintCode = patientHistoryConstraintCode;
        this.frequency = frequency;
        this.includeExcludes = includeExcludes;
        this.inventoryKeys = inventoryKeys;
    }


    /**
     * Gets the patientHistoryConstraintCode value for this PatientHistoryConstraint.
     * 
     * @return patientHistoryConstraintCode
     */
    public com.vsp.xl.dto.v002.SimpleCode getPatientHistoryConstraintCode() {
        return patientHistoryConstraintCode;
    }


    /**
     * Sets the patientHistoryConstraintCode value for this PatientHistoryConstraint.
     * 
     * @param patientHistoryConstraintCode
     */
    public void setPatientHistoryConstraintCode(com.vsp.xl.dto.v002.SimpleCode patientHistoryConstraintCode) {
        this.patientHistoryConstraintCode = patientHistoryConstraintCode;
    }


    /**
     * Gets the frequency value for this PatientHistoryConstraint.
     * 
     * @return frequency
     */
    public com.vsp.bl.product.dto.coverage.v001.Frequency getFrequency() {
        return frequency;
    }


    /**
     * Sets the frequency value for this PatientHistoryConstraint.
     * 
     * @param frequency
     */
    public void setFrequency(com.vsp.bl.product.dto.coverage.v001.Frequency frequency) {
        this.frequency = frequency;
    }


    /**
     * Gets the includeExcludes value for this PatientHistoryConstraint.
     * 
     * @return includeExcludes
     */
    public com.vsp.bl.product.dto.v002.ProductItemIncludeExclude[] getIncludeExcludes() {
        return includeExcludes;
    }


    /**
     * Sets the includeExcludes value for this PatientHistoryConstraint.
     * 
     * @param includeExcludes
     */
    public void setIncludeExcludes(com.vsp.bl.product.dto.v002.ProductItemIncludeExclude[] includeExcludes) {
        this.includeExcludes = includeExcludes;
    }


    /**
     * Gets the inventoryKeys value for this PatientHistoryConstraint.
     * 
     * @return inventoryKeys
     */
    public com.vsp.bl.inventory.dto.v001.InventoryKey[] getInventoryKeys() {
        return inventoryKeys;
    }


    /**
     * Sets the inventoryKeys value for this PatientHistoryConstraint.
     * 
     * @param inventoryKeys
     */
    public void setInventoryKeys(com.vsp.bl.inventory.dto.v001.InventoryKey[] inventoryKeys) {
        this.inventoryKeys = inventoryKeys;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PatientHistoryConstraint)) return false;
        PatientHistoryConstraint other = (PatientHistoryConstraint) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.patientHistoryConstraintCode==null && other.getPatientHistoryConstraintCode()==null) || 
             (this.patientHistoryConstraintCode!=null &&
              this.patientHistoryConstraintCode.equals(other.getPatientHistoryConstraintCode()))) &&
            ((this.frequency==null && other.getFrequency()==null) || 
             (this.frequency!=null &&
              this.frequency.equals(other.getFrequency()))) &&
            ((this.includeExcludes==null && other.getIncludeExcludes()==null) || 
             (this.includeExcludes!=null &&
              java.util.Arrays.equals(this.includeExcludes, other.getIncludeExcludes()))) &&
            ((this.inventoryKeys==null && other.getInventoryKeys()==null) || 
             (this.inventoryKeys!=null &&
              java.util.Arrays.equals(this.inventoryKeys, other.getInventoryKeys())));
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
        if (getPatientHistoryConstraintCode() != null) {
            _hashCode += getPatientHistoryConstraintCode().hashCode();
        }
        if (getFrequency() != null) {
            _hashCode += getFrequency().hashCode();
        }
        if (getIncludeExcludes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIncludeExcludes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIncludeExcludes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInventoryKeys() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInventoryKeys());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInventoryKeys(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PatientHistoryConstraint.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "PatientHistoryConstraint"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientHistoryConstraintCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "patientHistoryConstraintCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "Frequency"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeExcludes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "includeExcludes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductItemIncludeExclude"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventoryKeys");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inventoryKeys"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.dto.inventory.bl.vsp.com", "InventoryKey"));
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

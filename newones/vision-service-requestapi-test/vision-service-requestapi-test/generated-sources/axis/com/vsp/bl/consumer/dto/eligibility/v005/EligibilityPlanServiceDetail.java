/**
 * EligibilityPlanServiceDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.eligibility.v005;

public class EligibilityPlanServiceDetail  implements java.io.Serializable {
    private java.lang.String planStatusCode;

    private int numberOfBenefits;

    private int numberOfServices;

    private com.vsp.bl.consumer.dto.eligibility.v005.PlanServiceBenefit[] planServiceBenefits;

    private java.lang.String planStateCode;

    public EligibilityPlanServiceDetail() {
    }

    public EligibilityPlanServiceDetail(
           java.lang.String planStatusCode,
           int numberOfBenefits,
           int numberOfServices,
           com.vsp.bl.consumer.dto.eligibility.v005.PlanServiceBenefit[] planServiceBenefits,
           java.lang.String planStateCode) {
           this.planStatusCode = planStatusCode;
           this.numberOfBenefits = numberOfBenefits;
           this.numberOfServices = numberOfServices;
           this.planServiceBenefits = planServiceBenefits;
           this.planStateCode = planStateCode;
    }


    /**
     * Gets the planStatusCode value for this EligibilityPlanServiceDetail.
     * 
     * @return planStatusCode
     */
    public java.lang.String getPlanStatusCode() {
        return planStatusCode;
    }


    /**
     * Sets the planStatusCode value for this EligibilityPlanServiceDetail.
     * 
     * @param planStatusCode
     */
    public void setPlanStatusCode(java.lang.String planStatusCode) {
        this.planStatusCode = planStatusCode;
    }


    /**
     * Gets the numberOfBenefits value for this EligibilityPlanServiceDetail.
     * 
     * @return numberOfBenefits
     */
    public int getNumberOfBenefits() {
        return numberOfBenefits;
    }


    /**
     * Sets the numberOfBenefits value for this EligibilityPlanServiceDetail.
     * 
     * @param numberOfBenefits
     */
    public void setNumberOfBenefits(int numberOfBenefits) {
        this.numberOfBenefits = numberOfBenefits;
    }


    /**
     * Gets the numberOfServices value for this EligibilityPlanServiceDetail.
     * 
     * @return numberOfServices
     */
    public int getNumberOfServices() {
        return numberOfServices;
    }


    /**
     * Sets the numberOfServices value for this EligibilityPlanServiceDetail.
     * 
     * @param numberOfServices
     */
    public void setNumberOfServices(int numberOfServices) {
        this.numberOfServices = numberOfServices;
    }


    /**
     * Gets the planServiceBenefits value for this EligibilityPlanServiceDetail.
     * 
     * @return planServiceBenefits
     */
    public com.vsp.bl.consumer.dto.eligibility.v005.PlanServiceBenefit[] getPlanServiceBenefits() {
        return planServiceBenefits;
    }


    /**
     * Sets the planServiceBenefits value for this EligibilityPlanServiceDetail.
     * 
     * @param planServiceBenefits
     */
    public void setPlanServiceBenefits(com.vsp.bl.consumer.dto.eligibility.v005.PlanServiceBenefit[] planServiceBenefits) {
        this.planServiceBenefits = planServiceBenefits;
    }


    /**
     * Gets the planStateCode value for this EligibilityPlanServiceDetail.
     * 
     * @return planStateCode
     */
    public java.lang.String getPlanStateCode() {
        return planStateCode;
    }


    /**
     * Sets the planStateCode value for this EligibilityPlanServiceDetail.
     * 
     * @param planStateCode
     */
    public void setPlanStateCode(java.lang.String planStateCode) {
        this.planStateCode = planStateCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EligibilityPlanServiceDetail)) return false;
        EligibilityPlanServiceDetail other = (EligibilityPlanServiceDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.planStatusCode==null && other.getPlanStatusCode()==null) || 
             (this.planStatusCode!=null &&
              this.planStatusCode.equals(other.getPlanStatusCode()))) &&
            this.numberOfBenefits == other.getNumberOfBenefits() &&
            this.numberOfServices == other.getNumberOfServices() &&
            ((this.planServiceBenefits==null && other.getPlanServiceBenefits()==null) || 
             (this.planServiceBenefits!=null &&
              java.util.Arrays.equals(this.planServiceBenefits, other.getPlanServiceBenefits()))) &&
            ((this.planStateCode==null && other.getPlanStateCode()==null) || 
             (this.planStateCode!=null &&
              this.planStateCode.equals(other.getPlanStateCode())));
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
        if (getPlanStatusCode() != null) {
            _hashCode += getPlanStatusCode().hashCode();
        }
        _hashCode += getNumberOfBenefits();
        _hashCode += getNumberOfServices();
        if (getPlanServiceBenefits() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPlanServiceBenefits());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPlanServiceBenefits(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPlanStateCode() != null) {
            _hashCode += getPlanStateCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EligibilityPlanServiceDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "EligibilityPlanServiceDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planStatusCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planStatusCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfBenefits");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfBenefits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfServices");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfServices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planServiceBenefits");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planServiceBenefits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "PlanServiceBenefit"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planStateCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planStateCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

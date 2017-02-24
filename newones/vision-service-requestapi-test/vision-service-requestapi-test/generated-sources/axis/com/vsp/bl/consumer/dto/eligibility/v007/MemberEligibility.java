/**
 * MemberEligibility.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.eligibility.v007;

public class MemberEligibility  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.consumer.dto.member.v001.MemberKey member;

    private com.vsp.bl.consumer.dto.eligibility.v006.EligibilityProductPackage[] productPackages;

    private com.vsp.bl.consumer.dto.member.v001.MemberKey patient;

    private java.lang.String fehbPlanCode;

    private java.lang.String fehbPlanName;

    private com.vsp.bl.consumer.dto.eligibility.v005.EligibilityPlanServiceDetail planServiceDetail;

    public MemberEligibility() {
    }

    public MemberEligibility(
           com.vsp.bl.consumer.dto.member.v001.MemberKey member,
           com.vsp.bl.consumer.dto.eligibility.v006.EligibilityProductPackage[] productPackages,
           com.vsp.bl.consumer.dto.member.v001.MemberKey patient,
           java.lang.String fehbPlanCode,
           java.lang.String fehbPlanName,
           com.vsp.bl.consumer.dto.eligibility.v005.EligibilityPlanServiceDetail planServiceDetail) {
        this.member = member;
        this.productPackages = productPackages;
        this.patient = patient;
        this.fehbPlanCode = fehbPlanCode;
        this.fehbPlanName = fehbPlanName;
        this.planServiceDetail = planServiceDetail;
    }


    /**
     * Gets the member value for this MemberEligibility.
     * 
     * @return member
     */
    public com.vsp.bl.consumer.dto.member.v001.MemberKey getMember() {
        return member;
    }


    /**
     * Sets the member value for this MemberEligibility.
     * 
     * @param member
     */
    public void setMember(com.vsp.bl.consumer.dto.member.v001.MemberKey member) {
        this.member = member;
    }


    /**
     * Gets the productPackages value for this MemberEligibility.
     * 
     * @return productPackages
     */
    public com.vsp.bl.consumer.dto.eligibility.v006.EligibilityProductPackage[] getProductPackages() {
        return productPackages;
    }


    /**
     * Sets the productPackages value for this MemberEligibility.
     * 
     * @param productPackages
     */
    public void setProductPackages(com.vsp.bl.consumer.dto.eligibility.v006.EligibilityProductPackage[] productPackages) {
        this.productPackages = productPackages;
    }


    /**
     * Gets the patient value for this MemberEligibility.
     * 
     * @return patient
     */
    public com.vsp.bl.consumer.dto.member.v001.MemberKey getPatient() {
        return patient;
    }


    /**
     * Sets the patient value for this MemberEligibility.
     * 
     * @param patient
     */
    public void setPatient(com.vsp.bl.consumer.dto.member.v001.MemberKey patient) {
        this.patient = patient;
    }


    /**
     * Gets the fehbPlanCode value for this MemberEligibility.
     * 
     * @return fehbPlanCode
     */
    public java.lang.String getFehbPlanCode() {
        return fehbPlanCode;
    }


    /**
     * Sets the fehbPlanCode value for this MemberEligibility.
     * 
     * @param fehbPlanCode
     */
    public void setFehbPlanCode(java.lang.String fehbPlanCode) {
        this.fehbPlanCode = fehbPlanCode;
    }


    /**
     * Gets the fehbPlanName value for this MemberEligibility.
     * 
     * @return fehbPlanName
     */
    public java.lang.String getFehbPlanName() {
        return fehbPlanName;
    }


    /**
     * Sets the fehbPlanName value for this MemberEligibility.
     * 
     * @param fehbPlanName
     */
    public void setFehbPlanName(java.lang.String fehbPlanName) {
        this.fehbPlanName = fehbPlanName;
    }


    /**
     * Gets the planServiceDetail value for this MemberEligibility.
     * 
     * @return planServiceDetail
     */
    public com.vsp.bl.consumer.dto.eligibility.v005.EligibilityPlanServiceDetail getPlanServiceDetail() {
        return planServiceDetail;
    }


    /**
     * Sets the planServiceDetail value for this MemberEligibility.
     * 
     * @param planServiceDetail
     */
    public void setPlanServiceDetail(com.vsp.bl.consumer.dto.eligibility.v005.EligibilityPlanServiceDetail planServiceDetail) {
        this.planServiceDetail = planServiceDetail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MemberEligibility)) return false;
        MemberEligibility other = (MemberEligibility) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.member==null && other.getMember()==null) || 
             (this.member!=null &&
              this.member.equals(other.getMember()))) &&
            ((this.productPackages==null && other.getProductPackages()==null) || 
             (this.productPackages!=null &&
              java.util.Arrays.equals(this.productPackages, other.getProductPackages()))) &&
            ((this.patient==null && other.getPatient()==null) || 
             (this.patient!=null &&
              this.patient.equals(other.getPatient()))) &&
            ((this.fehbPlanCode==null && other.getFehbPlanCode()==null) || 
             (this.fehbPlanCode!=null &&
              this.fehbPlanCode.equals(other.getFehbPlanCode()))) &&
            ((this.fehbPlanName==null && other.getFehbPlanName()==null) || 
             (this.fehbPlanName!=null &&
              this.fehbPlanName.equals(other.getFehbPlanName()))) &&
            ((this.planServiceDetail==null && other.getPlanServiceDetail()==null) || 
             (this.planServiceDetail!=null &&
              this.planServiceDetail.equals(other.getPlanServiceDetail())));
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
        if (getMember() != null) {
            _hashCode += getMember().hashCode();
        }
        if (getProductPackages() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductPackages());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductPackages(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPatient() != null) {
            _hashCode += getPatient().hashCode();
        }
        if (getFehbPlanCode() != null) {
            _hashCode += getFehbPlanCode().hashCode();
        }
        if (getFehbPlanName() != null) {
            _hashCode += getFehbPlanName().hashCode();
        }
        if (getPlanServiceDetail() != null) {
            _hashCode += getPlanServiceDetail().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MemberEligibility.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v007.eligibility.dto.consumer.bl.vsp.com", "MemberEligibility"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("member");
        elemField.setXmlName(new javax.xml.namespace.QName("", "member"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productPackages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productPackages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v006.eligibility.dto.consumer.bl.vsp.com", "EligibilityProductPackage"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patient");
        elemField.setXmlName(new javax.xml.namespace.QName("", "patient"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fehbPlanCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fehbPlanCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fehbPlanName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fehbPlanName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planServiceDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planServiceDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "EligibilityPlanServiceDetail"));
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

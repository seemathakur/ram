/**
 * PlanServiceBenefit.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.eligibility.v005;

public class PlanServiceBenefit  implements java.io.Serializable {
    private java.lang.String[] specialClaimProcessingCode;

    private java.lang.String benefitType;

    private java.lang.String benefitProviderCode;

    private java.lang.String benefitProgramId;

    private com.vsp.bl.consumer.dto.eligibility.v004.PlanServiceDetail[] planServiceDetail;

    private java.lang.String planProgramFeeRuleCode;

    public PlanServiceBenefit() {
    }

    public PlanServiceBenefit(
           java.lang.String[] specialClaimProcessingCode,
           java.lang.String benefitType,
           java.lang.String benefitProviderCode,
           java.lang.String benefitProgramId,
           com.vsp.bl.consumer.dto.eligibility.v004.PlanServiceDetail[] planServiceDetail,
           java.lang.String planProgramFeeRuleCode) {
           this.specialClaimProcessingCode = specialClaimProcessingCode;
           this.benefitType = benefitType;
           this.benefitProviderCode = benefitProviderCode;
           this.benefitProgramId = benefitProgramId;
           this.planServiceDetail = planServiceDetail;
           this.planProgramFeeRuleCode = planProgramFeeRuleCode;
    }


    /**
     * Gets the specialClaimProcessingCode value for this PlanServiceBenefit.
     * 
     * @return specialClaimProcessingCode
     */
    public java.lang.String[] getSpecialClaimProcessingCode() {
        return specialClaimProcessingCode;
    }


    /**
     * Sets the specialClaimProcessingCode value for this PlanServiceBenefit.
     * 
     * @param specialClaimProcessingCode
     */
    public void setSpecialClaimProcessingCode(java.lang.String[] specialClaimProcessingCode) {
        this.specialClaimProcessingCode = specialClaimProcessingCode;
    }


    /**
     * Gets the benefitType value for this PlanServiceBenefit.
     * 
     * @return benefitType
     */
    public java.lang.String getBenefitType() {
        return benefitType;
    }


    /**
     * Sets the benefitType value for this PlanServiceBenefit.
     * 
     * @param benefitType
     */
    public void setBenefitType(java.lang.String benefitType) {
        this.benefitType = benefitType;
    }


    /**
     * Gets the benefitProviderCode value for this PlanServiceBenefit.
     * 
     * @return benefitProviderCode
     */
    public java.lang.String getBenefitProviderCode() {
        return benefitProviderCode;
    }


    /**
     * Sets the benefitProviderCode value for this PlanServiceBenefit.
     * 
     * @param benefitProviderCode
     */
    public void setBenefitProviderCode(java.lang.String benefitProviderCode) {
        this.benefitProviderCode = benefitProviderCode;
    }


    /**
     * Gets the benefitProgramId value for this PlanServiceBenefit.
     * 
     * @return benefitProgramId
     */
    public java.lang.String getBenefitProgramId() {
        return benefitProgramId;
    }


    /**
     * Sets the benefitProgramId value for this PlanServiceBenefit.
     * 
     * @param benefitProgramId
     */
    public void setBenefitProgramId(java.lang.String benefitProgramId) {
        this.benefitProgramId = benefitProgramId;
    }


    /**
     * Gets the planServiceDetail value for this PlanServiceBenefit.
     * 
     * @return planServiceDetail
     */
    public com.vsp.bl.consumer.dto.eligibility.v004.PlanServiceDetail[] getPlanServiceDetail() {
        return planServiceDetail;
    }


    /**
     * Sets the planServiceDetail value for this PlanServiceBenefit.
     * 
     * @param planServiceDetail
     */
    public void setPlanServiceDetail(com.vsp.bl.consumer.dto.eligibility.v004.PlanServiceDetail[] planServiceDetail) {
        this.planServiceDetail = planServiceDetail;
    }


    /**
     * Gets the planProgramFeeRuleCode value for this PlanServiceBenefit.
     * 
     * @return planProgramFeeRuleCode
     */
    public java.lang.String getPlanProgramFeeRuleCode() {
        return planProgramFeeRuleCode;
    }


    /**
     * Sets the planProgramFeeRuleCode value for this PlanServiceBenefit.
     * 
     * @param planProgramFeeRuleCode
     */
    public void setPlanProgramFeeRuleCode(java.lang.String planProgramFeeRuleCode) {
        this.planProgramFeeRuleCode = planProgramFeeRuleCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PlanServiceBenefit)) return false;
        PlanServiceBenefit other = (PlanServiceBenefit) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.specialClaimProcessingCode==null && other.getSpecialClaimProcessingCode()==null) || 
             (this.specialClaimProcessingCode!=null &&
              java.util.Arrays.equals(this.specialClaimProcessingCode, other.getSpecialClaimProcessingCode()))) &&
            ((this.benefitType==null && other.getBenefitType()==null) || 
             (this.benefitType!=null &&
              this.benefitType.equals(other.getBenefitType()))) &&
            ((this.benefitProviderCode==null && other.getBenefitProviderCode()==null) || 
             (this.benefitProviderCode!=null &&
              this.benefitProviderCode.equals(other.getBenefitProviderCode()))) &&
            ((this.benefitProgramId==null && other.getBenefitProgramId()==null) || 
             (this.benefitProgramId!=null &&
              this.benefitProgramId.equals(other.getBenefitProgramId()))) &&
            ((this.planServiceDetail==null && other.getPlanServiceDetail()==null) || 
             (this.planServiceDetail!=null &&
              java.util.Arrays.equals(this.planServiceDetail, other.getPlanServiceDetail()))) &&
            ((this.planProgramFeeRuleCode==null && other.getPlanProgramFeeRuleCode()==null) || 
             (this.planProgramFeeRuleCode!=null &&
              this.planProgramFeeRuleCode.equals(other.getPlanProgramFeeRuleCode())));
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
        if (getSpecialClaimProcessingCode() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSpecialClaimProcessingCode());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSpecialClaimProcessingCode(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBenefitType() != null) {
            _hashCode += getBenefitType().hashCode();
        }
        if (getBenefitProviderCode() != null) {
            _hashCode += getBenefitProviderCode().hashCode();
        }
        if (getBenefitProgramId() != null) {
            _hashCode += getBenefitProgramId().hashCode();
        }
        if (getPlanServiceDetail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPlanServiceDetail());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPlanServiceDetail(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPlanProgramFeeRuleCode() != null) {
            _hashCode += getPlanProgramFeeRuleCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PlanServiceBenefit.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "PlanServiceBenefit"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialClaimProcessingCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialClaimProcessingCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("benefitType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "benefitType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("benefitProviderCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "benefitProviderCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("benefitProgramId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "benefitProgramId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planServiceDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planServiceDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "PlanServiceDetail"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planProgramFeeRuleCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planProgramFeeRuleCode"));
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

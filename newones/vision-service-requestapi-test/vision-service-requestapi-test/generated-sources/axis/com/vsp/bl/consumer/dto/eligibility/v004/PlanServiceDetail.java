/**
 * PlanServiceDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.eligibility.v004;

public class PlanServiceDetail  implements java.io.Serializable {
    private java.lang.String serviceId;

    private com.vsp.bl.consumer.dto.eligibility.v004.ServiceCategory[] serviceCategory;

    private java.lang.String deductionProductTypeCode;

    private float deductionAmount;

    private java.lang.String freqProductTypeCode;

    private int freqProductMM;

    private java.lang.String freqProductCode;

    private int freqProductCount;

    private float maxAmount;

    private float coveragePercent;

    private java.lang.String percentOrderCode;

    private com.vsp.bl.consumer.dto.eligibility.v004.ServiceILOInfo[] serviceILOInfo;

    private com.vsp.bl.consumer.dto.eligibility.v004.ServiceRuleConstant[] serviceRuleConstant;

    private java.lang.String ruleCode;

    private java.lang.String maxAmountLocationCode;

    private float standardSHDAmount;

    private java.lang.String deductibleOrderCode;

    public PlanServiceDetail() {
    }

    public PlanServiceDetail(
           java.lang.String serviceId,
           com.vsp.bl.consumer.dto.eligibility.v004.ServiceCategory[] serviceCategory,
           java.lang.String deductionProductTypeCode,
           float deductionAmount,
           java.lang.String freqProductTypeCode,
           int freqProductMM,
           java.lang.String freqProductCode,
           int freqProductCount,
           float maxAmount,
           float coveragePercent,
           java.lang.String percentOrderCode,
           com.vsp.bl.consumer.dto.eligibility.v004.ServiceILOInfo[] serviceILOInfo,
           com.vsp.bl.consumer.dto.eligibility.v004.ServiceRuleConstant[] serviceRuleConstant,
           java.lang.String ruleCode,
           java.lang.String maxAmountLocationCode,
           float standardSHDAmount,
           java.lang.String deductibleOrderCode) {
           this.serviceId = serviceId;
           this.serviceCategory = serviceCategory;
           this.deductionProductTypeCode = deductionProductTypeCode;
           this.deductionAmount = deductionAmount;
           this.freqProductTypeCode = freqProductTypeCode;
           this.freqProductMM = freqProductMM;
           this.freqProductCode = freqProductCode;
           this.freqProductCount = freqProductCount;
           this.maxAmount = maxAmount;
           this.coveragePercent = coveragePercent;
           this.percentOrderCode = percentOrderCode;
           this.serviceILOInfo = serviceILOInfo;
           this.serviceRuleConstant = serviceRuleConstant;
           this.ruleCode = ruleCode;
           this.maxAmountLocationCode = maxAmountLocationCode;
           this.standardSHDAmount = standardSHDAmount;
           this.deductibleOrderCode = deductibleOrderCode;
    }


    /**
     * Gets the serviceId value for this PlanServiceDetail.
     * 
     * @return serviceId
     */
    public java.lang.String getServiceId() {
        return serviceId;
    }


    /**
     * Sets the serviceId value for this PlanServiceDetail.
     * 
     * @param serviceId
     */
    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }


    /**
     * Gets the serviceCategory value for this PlanServiceDetail.
     * 
     * @return serviceCategory
     */
    public com.vsp.bl.consumer.dto.eligibility.v004.ServiceCategory[] getServiceCategory() {
        return serviceCategory;
    }


    /**
     * Sets the serviceCategory value for this PlanServiceDetail.
     * 
     * @param serviceCategory
     */
    public void setServiceCategory(com.vsp.bl.consumer.dto.eligibility.v004.ServiceCategory[] serviceCategory) {
        this.serviceCategory = serviceCategory;
    }


    /**
     * Gets the deductionProductTypeCode value for this PlanServiceDetail.
     * 
     * @return deductionProductTypeCode
     */
    public java.lang.String getDeductionProductTypeCode() {
        return deductionProductTypeCode;
    }


    /**
     * Sets the deductionProductTypeCode value for this PlanServiceDetail.
     * 
     * @param deductionProductTypeCode
     */
    public void setDeductionProductTypeCode(java.lang.String deductionProductTypeCode) {
        this.deductionProductTypeCode = deductionProductTypeCode;
    }


    /**
     * Gets the deductionAmount value for this PlanServiceDetail.
     * 
     * @return deductionAmount
     */
    public float getDeductionAmount() {
        return deductionAmount;
    }


    /**
     * Sets the deductionAmount value for this PlanServiceDetail.
     * 
     * @param deductionAmount
     */
    public void setDeductionAmount(float deductionAmount) {
        this.deductionAmount = deductionAmount;
    }


    /**
     * Gets the freqProductTypeCode value for this PlanServiceDetail.
     * 
     * @return freqProductTypeCode
     */
    public java.lang.String getFreqProductTypeCode() {
        return freqProductTypeCode;
    }


    /**
     * Sets the freqProductTypeCode value for this PlanServiceDetail.
     * 
     * @param freqProductTypeCode
     */
    public void setFreqProductTypeCode(java.lang.String freqProductTypeCode) {
        this.freqProductTypeCode = freqProductTypeCode;
    }


    /**
     * Gets the freqProductMM value for this PlanServiceDetail.
     * 
     * @return freqProductMM
     */
    public int getFreqProductMM() {
        return freqProductMM;
    }


    /**
     * Sets the freqProductMM value for this PlanServiceDetail.
     * 
     * @param freqProductMM
     */
    public void setFreqProductMM(int freqProductMM) {
        this.freqProductMM = freqProductMM;
    }


    /**
     * Gets the freqProductCode value for this PlanServiceDetail.
     * 
     * @return freqProductCode
     */
    public java.lang.String getFreqProductCode() {
        return freqProductCode;
    }


    /**
     * Sets the freqProductCode value for this PlanServiceDetail.
     * 
     * @param freqProductCode
     */
    public void setFreqProductCode(java.lang.String freqProductCode) {
        this.freqProductCode = freqProductCode;
    }


    /**
     * Gets the freqProductCount value for this PlanServiceDetail.
     * 
     * @return freqProductCount
     */
    public int getFreqProductCount() {
        return freqProductCount;
    }


    /**
     * Sets the freqProductCount value for this PlanServiceDetail.
     * 
     * @param freqProductCount
     */
    public void setFreqProductCount(int freqProductCount) {
        this.freqProductCount = freqProductCount;
    }


    /**
     * Gets the maxAmount value for this PlanServiceDetail.
     * 
     * @return maxAmount
     */
    public float getMaxAmount() {
        return maxAmount;
    }


    /**
     * Sets the maxAmount value for this PlanServiceDetail.
     * 
     * @param maxAmount
     */
    public void setMaxAmount(float maxAmount) {
        this.maxAmount = maxAmount;
    }


    /**
     * Gets the coveragePercent value for this PlanServiceDetail.
     * 
     * @return coveragePercent
     */
    public float getCoveragePercent() {
        return coveragePercent;
    }


    /**
     * Sets the coveragePercent value for this PlanServiceDetail.
     * 
     * @param coveragePercent
     */
    public void setCoveragePercent(float coveragePercent) {
        this.coveragePercent = coveragePercent;
    }


    /**
     * Gets the percentOrderCode value for this PlanServiceDetail.
     * 
     * @return percentOrderCode
     */
    public java.lang.String getPercentOrderCode() {
        return percentOrderCode;
    }


    /**
     * Sets the percentOrderCode value for this PlanServiceDetail.
     * 
     * @param percentOrderCode
     */
    public void setPercentOrderCode(java.lang.String percentOrderCode) {
        this.percentOrderCode = percentOrderCode;
    }


    /**
     * Gets the serviceILOInfo value for this PlanServiceDetail.
     * 
     * @return serviceILOInfo
     */
    public com.vsp.bl.consumer.dto.eligibility.v004.ServiceILOInfo[] getServiceILOInfo() {
        return serviceILOInfo;
    }


    /**
     * Sets the serviceILOInfo value for this PlanServiceDetail.
     * 
     * @param serviceILOInfo
     */
    public void setServiceILOInfo(com.vsp.bl.consumer.dto.eligibility.v004.ServiceILOInfo[] serviceILOInfo) {
        this.serviceILOInfo = serviceILOInfo;
    }


    /**
     * Gets the serviceRuleConstant value for this PlanServiceDetail.
     * 
     * @return serviceRuleConstant
     */
    public com.vsp.bl.consumer.dto.eligibility.v004.ServiceRuleConstant[] getServiceRuleConstant() {
        return serviceRuleConstant;
    }


    /**
     * Sets the serviceRuleConstant value for this PlanServiceDetail.
     * 
     * @param serviceRuleConstant
     */
    public void setServiceRuleConstant(com.vsp.bl.consumer.dto.eligibility.v004.ServiceRuleConstant[] serviceRuleConstant) {
        this.serviceRuleConstant = serviceRuleConstant;
    }


    /**
     * Gets the ruleCode value for this PlanServiceDetail.
     * 
     * @return ruleCode
     */
    public java.lang.String getRuleCode() {
        return ruleCode;
    }


    /**
     * Sets the ruleCode value for this PlanServiceDetail.
     * 
     * @param ruleCode
     */
    public void setRuleCode(java.lang.String ruleCode) {
        this.ruleCode = ruleCode;
    }


    /**
     * Gets the maxAmountLocationCode value for this PlanServiceDetail.
     * 
     * @return maxAmountLocationCode
     */
    public java.lang.String getMaxAmountLocationCode() {
        return maxAmountLocationCode;
    }


    /**
     * Sets the maxAmountLocationCode value for this PlanServiceDetail.
     * 
     * @param maxAmountLocationCode
     */
    public void setMaxAmountLocationCode(java.lang.String maxAmountLocationCode) {
        this.maxAmountLocationCode = maxAmountLocationCode;
    }


    /**
     * Gets the standardSHDAmount value for this PlanServiceDetail.
     * 
     * @return standardSHDAmount
     */
    public float getStandardSHDAmount() {
        return standardSHDAmount;
    }


    /**
     * Sets the standardSHDAmount value for this PlanServiceDetail.
     * 
     * @param standardSHDAmount
     */
    public void setStandardSHDAmount(float standardSHDAmount) {
        this.standardSHDAmount = standardSHDAmount;
    }


    /**
     * Gets the deductibleOrderCode value for this PlanServiceDetail.
     * 
     * @return deductibleOrderCode
     */
    public java.lang.String getDeductibleOrderCode() {
        return deductibleOrderCode;
    }


    /**
     * Sets the deductibleOrderCode value for this PlanServiceDetail.
     * 
     * @param deductibleOrderCode
     */
    public void setDeductibleOrderCode(java.lang.String deductibleOrderCode) {
        this.deductibleOrderCode = deductibleOrderCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PlanServiceDetail)) return false;
        PlanServiceDetail other = (PlanServiceDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.serviceId==null && other.getServiceId()==null) || 
             (this.serviceId!=null &&
              this.serviceId.equals(other.getServiceId()))) &&
            ((this.serviceCategory==null && other.getServiceCategory()==null) || 
             (this.serviceCategory!=null &&
              java.util.Arrays.equals(this.serviceCategory, other.getServiceCategory()))) &&
            ((this.deductionProductTypeCode==null && other.getDeductionProductTypeCode()==null) || 
             (this.deductionProductTypeCode!=null &&
              this.deductionProductTypeCode.equals(other.getDeductionProductTypeCode()))) &&
            this.deductionAmount == other.getDeductionAmount() &&
            ((this.freqProductTypeCode==null && other.getFreqProductTypeCode()==null) || 
             (this.freqProductTypeCode!=null &&
              this.freqProductTypeCode.equals(other.getFreqProductTypeCode()))) &&
            this.freqProductMM == other.getFreqProductMM() &&
            ((this.freqProductCode==null && other.getFreqProductCode()==null) || 
             (this.freqProductCode!=null &&
              this.freqProductCode.equals(other.getFreqProductCode()))) &&
            this.freqProductCount == other.getFreqProductCount() &&
            this.maxAmount == other.getMaxAmount() &&
            this.coveragePercent == other.getCoveragePercent() &&
            ((this.percentOrderCode==null && other.getPercentOrderCode()==null) || 
             (this.percentOrderCode!=null &&
              this.percentOrderCode.equals(other.getPercentOrderCode()))) &&
            ((this.serviceILOInfo==null && other.getServiceILOInfo()==null) || 
             (this.serviceILOInfo!=null &&
              java.util.Arrays.equals(this.serviceILOInfo, other.getServiceILOInfo()))) &&
            ((this.serviceRuleConstant==null && other.getServiceRuleConstant()==null) || 
             (this.serviceRuleConstant!=null &&
              java.util.Arrays.equals(this.serviceRuleConstant, other.getServiceRuleConstant()))) &&
            ((this.ruleCode==null && other.getRuleCode()==null) || 
             (this.ruleCode!=null &&
              this.ruleCode.equals(other.getRuleCode()))) &&
            ((this.maxAmountLocationCode==null && other.getMaxAmountLocationCode()==null) || 
             (this.maxAmountLocationCode!=null &&
              this.maxAmountLocationCode.equals(other.getMaxAmountLocationCode()))) &&
            this.standardSHDAmount == other.getStandardSHDAmount() &&
            ((this.deductibleOrderCode==null && other.getDeductibleOrderCode()==null) || 
             (this.deductibleOrderCode!=null &&
              this.deductibleOrderCode.equals(other.getDeductibleOrderCode())));
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
        if (getServiceId() != null) {
            _hashCode += getServiceId().hashCode();
        }
        if (getServiceCategory() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceCategory());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceCategory(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeductionProductTypeCode() != null) {
            _hashCode += getDeductionProductTypeCode().hashCode();
        }
        _hashCode += new Float(getDeductionAmount()).hashCode();
        if (getFreqProductTypeCode() != null) {
            _hashCode += getFreqProductTypeCode().hashCode();
        }
        _hashCode += getFreqProductMM();
        if (getFreqProductCode() != null) {
            _hashCode += getFreqProductCode().hashCode();
        }
        _hashCode += getFreqProductCount();
        _hashCode += new Float(getMaxAmount()).hashCode();
        _hashCode += new Float(getCoveragePercent()).hashCode();
        if (getPercentOrderCode() != null) {
            _hashCode += getPercentOrderCode().hashCode();
        }
        if (getServiceILOInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceILOInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceILOInfo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getServiceRuleConstant() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceRuleConstant());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceRuleConstant(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRuleCode() != null) {
            _hashCode += getRuleCode().hashCode();
        }
        if (getMaxAmountLocationCode() != null) {
            _hashCode += getMaxAmountLocationCode().hashCode();
        }
        _hashCode += new Float(getStandardSHDAmount()).hashCode();
        if (getDeductibleOrderCode() != null) {
            _hashCode += getDeductibleOrderCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PlanServiceDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "PlanServiceDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceCategory"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deductionProductTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deductionProductTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deductionAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deductionAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freqProductTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "freqProductTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freqProductMM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "freqProductMM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freqProductCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "freqProductCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freqProductCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "freqProductCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coveragePercent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coveragePercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percentOrderCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percentOrderCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceILOInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceILOInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceILOInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceRuleConstant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceRuleConstant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceRuleConstant"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ruleCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ruleCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxAmountLocationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxAmountLocationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("standardSHDAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "standardSHDAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deductibleOrderCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deductibleOrderCode"));
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

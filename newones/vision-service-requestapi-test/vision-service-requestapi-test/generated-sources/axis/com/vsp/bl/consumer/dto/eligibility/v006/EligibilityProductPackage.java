/**
 * EligibilityProductPackage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.eligibility.v006;

public class EligibilityProductPackage  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.consumer.dto.eligibility.v004.EligibilityProductItem[] productItems;

    private com.vsp.bl.product.dto.v002.ProductPackage productPackage;

    private java.lang.String label;

    private java.lang.Boolean isAvailable;

    private com.vsp.bl.consumer.dto.eligibility.v004.PatientHistory[] patientHistory;

    private java.lang.String reportName;

    private com.vsp.xl.dto.v002.Date windDownDate;

    private java.lang.String windDownStatus;

    private com.vsp.bl.consumer.dto.plan.v004.BenefitSummary benefitSummary;

    public EligibilityProductPackage() {
    }

    public EligibilityProductPackage(
           com.vsp.bl.consumer.dto.eligibility.v004.EligibilityProductItem[] productItems,
           com.vsp.bl.product.dto.v002.ProductPackage productPackage,
           java.lang.String label,
           java.lang.Boolean isAvailable,
           com.vsp.bl.consumer.dto.eligibility.v004.PatientHistory[] patientHistory,
           java.lang.String reportName,
           com.vsp.xl.dto.v002.Date windDownDate,
           java.lang.String windDownStatus,
           com.vsp.bl.consumer.dto.plan.v004.BenefitSummary benefitSummary) {
        this.productItems = productItems;
        this.productPackage = productPackage;
        this.label = label;
        this.isAvailable = isAvailable;
        this.patientHistory = patientHistory;
        this.reportName = reportName;
        this.windDownDate = windDownDate;
        this.windDownStatus = windDownStatus;
        this.benefitSummary = benefitSummary;
    }


    /**
     * Gets the productItems value for this EligibilityProductPackage.
     * 
     * @return productItems
     */
    public com.vsp.bl.consumer.dto.eligibility.v004.EligibilityProductItem[] getProductItems() {
        return productItems;
    }


    /**
     * Sets the productItems value for this EligibilityProductPackage.
     * 
     * @param productItems
     */
    public void setProductItems(com.vsp.bl.consumer.dto.eligibility.v004.EligibilityProductItem[] productItems) {
        this.productItems = productItems;
    }


    /**
     * Gets the productPackage value for this EligibilityProductPackage.
     * 
     * @return productPackage
     */
    public com.vsp.bl.product.dto.v002.ProductPackage getProductPackage() {
        return productPackage;
    }


    /**
     * Sets the productPackage value for this EligibilityProductPackage.
     * 
     * @param productPackage
     */
    public void setProductPackage(com.vsp.bl.product.dto.v002.ProductPackage productPackage) {
        this.productPackage = productPackage;
    }


    /**
     * Gets the label value for this EligibilityProductPackage.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this EligibilityProductPackage.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the isAvailable value for this EligibilityProductPackage.
     * 
     * @return isAvailable
     */
    public java.lang.Boolean getIsAvailable() {
        return isAvailable;
    }


    /**
     * Sets the isAvailable value for this EligibilityProductPackage.
     * 
     * @param isAvailable
     */
    public void setIsAvailable(java.lang.Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    /**
     * Gets the patientHistory value for this EligibilityProductPackage.
     * 
     * @return patientHistory
     */
    public com.vsp.bl.consumer.dto.eligibility.v004.PatientHistory[] getPatientHistory() {
        return patientHistory;
    }


    /**
     * Sets the patientHistory value for this EligibilityProductPackage.
     * 
     * @param patientHistory
     */
    public void setPatientHistory(com.vsp.bl.consumer.dto.eligibility.v004.PatientHistory[] patientHistory) {
        this.patientHistory = patientHistory;
    }


    /**
     * Gets the reportName value for this EligibilityProductPackage.
     * 
     * @return reportName
     */
    public java.lang.String getReportName() {
        return reportName;
    }


    /**
     * Sets the reportName value for this EligibilityProductPackage.
     * 
     * @param reportName
     */
    public void setReportName(java.lang.String reportName) {
        this.reportName = reportName;
    }


    /**
     * Gets the windDownDate value for this EligibilityProductPackage.
     * 
     * @return windDownDate
     */
    public com.vsp.xl.dto.v002.Date getWindDownDate() {
        return windDownDate;
    }


    /**
     * Sets the windDownDate value for this EligibilityProductPackage.
     * 
     * @param windDownDate
     */
    public void setWindDownDate(com.vsp.xl.dto.v002.Date windDownDate) {
        this.windDownDate = windDownDate;
    }


    /**
     * Gets the windDownStatus value for this EligibilityProductPackage.
     * 
     * @return windDownStatus
     */
    public java.lang.String getWindDownStatus() {
        return windDownStatus;
    }


    /**
     * Sets the windDownStatus value for this EligibilityProductPackage.
     * 
     * @param windDownStatus
     */
    public void setWindDownStatus(java.lang.String windDownStatus) {
        this.windDownStatus = windDownStatus;
    }


    /**
     * Gets the benefitSummary value for this EligibilityProductPackage.
     * 
     * @return benefitSummary
     */
    public com.vsp.bl.consumer.dto.plan.v004.BenefitSummary getBenefitSummary() {
        return benefitSummary;
    }


    /**
     * Sets the benefitSummary value for this EligibilityProductPackage.
     * 
     * @param benefitSummary
     */
    public void setBenefitSummary(com.vsp.bl.consumer.dto.plan.v004.BenefitSummary benefitSummary) {
        this.benefitSummary = benefitSummary;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EligibilityProductPackage)) return false;
        EligibilityProductPackage other = (EligibilityProductPackage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.productItems==null && other.getProductItems()==null) || 
             (this.productItems!=null &&
              java.util.Arrays.equals(this.productItems, other.getProductItems()))) &&
            ((this.productPackage==null && other.getProductPackage()==null) || 
             (this.productPackage!=null &&
              this.productPackage.equals(other.getProductPackage()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.isAvailable==null && other.getIsAvailable()==null) || 
             (this.isAvailable!=null &&
              this.isAvailable.equals(other.getIsAvailable()))) &&
            ((this.patientHistory==null && other.getPatientHistory()==null) || 
             (this.patientHistory!=null &&
              java.util.Arrays.equals(this.patientHistory, other.getPatientHistory()))) &&
            ((this.reportName==null && other.getReportName()==null) || 
             (this.reportName!=null &&
              this.reportName.equals(other.getReportName()))) &&
            ((this.windDownDate==null && other.getWindDownDate()==null) || 
             (this.windDownDate!=null &&
              this.windDownDate.equals(other.getWindDownDate()))) &&
            ((this.windDownStatus==null && other.getWindDownStatus()==null) || 
             (this.windDownStatus!=null &&
              this.windDownStatus.equals(other.getWindDownStatus()))) &&
            ((this.benefitSummary==null && other.getBenefitSummary()==null) || 
             (this.benefitSummary!=null &&
              this.benefitSummary.equals(other.getBenefitSummary())));
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
        if (getProductItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProductPackage() != null) {
            _hashCode += getProductPackage().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getIsAvailable() != null) {
            _hashCode += getIsAvailable().hashCode();
        }
        if (getPatientHistory() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPatientHistory());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPatientHistory(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReportName() != null) {
            _hashCode += getReportName().hashCode();
        }
        if (getWindDownDate() != null) {
            _hashCode += getWindDownDate().hashCode();
        }
        if (getWindDownStatus() != null) {
            _hashCode += getWindDownStatus().hashCode();
        }
        if (getBenefitSummary() != null) {
            _hashCode += getBenefitSummary().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EligibilityProductPackage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v006.eligibility.dto.consumer.bl.vsp.com", "EligibilityProductPackage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "EligibilityProductItem"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productPackage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productPackage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductPackage"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAvailable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAvailable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientHistory");
        elemField.setXmlName(new javax.xml.namespace.QName("", "patientHistory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "PatientHistory"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reportName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("windDownDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "windDownDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("windDownStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "windDownStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("benefitSummary");
        elemField.setXmlName(new javax.xml.namespace.QName("", "benefitSummary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.plan.dto.consumer.bl.vsp.com", "BenefitSummary"));
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

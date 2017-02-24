/**
 * PatientService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class PatientService  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.product.dto.coverage.v001.EarlyEligibility earlyEligibility;

    private com.vsp.bl.product.dto.coverage.v001.InterimBenefit interimBenefit;

    private com.vsp.bl.product.dto.coverage.v002.Replace replace;

    public PatientService() {
    }

    public PatientService(
           com.vsp.bl.product.dto.coverage.v001.EarlyEligibility earlyEligibility,
           com.vsp.bl.product.dto.coverage.v001.InterimBenefit interimBenefit,
           com.vsp.bl.product.dto.coverage.v002.Replace replace) {
        this.earlyEligibility = earlyEligibility;
        this.interimBenefit = interimBenefit;
        this.replace = replace;
    }


    /**
     * Gets the earlyEligibility value for this PatientService.
     * 
     * @return earlyEligibility
     */
    public com.vsp.bl.product.dto.coverage.v001.EarlyEligibility getEarlyEligibility() {
        return earlyEligibility;
    }


    /**
     * Sets the earlyEligibility value for this PatientService.
     * 
     * @param earlyEligibility
     */
    public void setEarlyEligibility(com.vsp.bl.product.dto.coverage.v001.EarlyEligibility earlyEligibility) {
        this.earlyEligibility = earlyEligibility;
    }


    /**
     * Gets the interimBenefit value for this PatientService.
     * 
     * @return interimBenefit
     */
    public com.vsp.bl.product.dto.coverage.v001.InterimBenefit getInterimBenefit() {
        return interimBenefit;
    }


    /**
     * Sets the interimBenefit value for this PatientService.
     * 
     * @param interimBenefit
     */
    public void setInterimBenefit(com.vsp.bl.product.dto.coverage.v001.InterimBenefit interimBenefit) {
        this.interimBenefit = interimBenefit;
    }


    /**
     * Gets the replace value for this PatientService.
     * 
     * @return replace
     */
    public com.vsp.bl.product.dto.coverage.v002.Replace getReplace() {
        return replace;
    }


    /**
     * Sets the replace value for this PatientService.
     * 
     * @param replace
     */
    public void setReplace(com.vsp.bl.product.dto.coverage.v002.Replace replace) {
        this.replace = replace;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PatientService)) return false;
        PatientService other = (PatientService) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.earlyEligibility==null && other.getEarlyEligibility()==null) || 
             (this.earlyEligibility!=null &&
              this.earlyEligibility.equals(other.getEarlyEligibility()))) &&
            ((this.interimBenefit==null && other.getInterimBenefit()==null) || 
             (this.interimBenefit!=null &&
              this.interimBenefit.equals(other.getInterimBenefit()))) &&
            ((this.replace==null && other.getReplace()==null) || 
             (this.replace!=null &&
              this.replace.equals(other.getReplace())));
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
        if (getEarlyEligibility() != null) {
            _hashCode += getEarlyEligibility().hashCode();
        }
        if (getInterimBenefit() != null) {
            _hashCode += getInterimBenefit().hashCode();
        }
        if (getReplace() != null) {
            _hashCode += getReplace().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PatientService.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PatientService"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("earlyEligibility");
        elemField.setXmlName(new javax.xml.namespace.QName("", "earlyEligibility"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "EarlyEligibility"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interimBenefit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interimBenefit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "InterimBenefit"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("replace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "replace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "Replace"));
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

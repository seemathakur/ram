/**
 * ServiceILOInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.eligibility.v004;

public class ServiceILOInfo  implements java.io.Serializable {
    private java.lang.String iloId;

    private java.lang.String iloRequiredInd;

    private java.lang.String iloEligibilityInd;

    private java.lang.String iloFreqAmountInd;

    public ServiceILOInfo() {
    }

    public ServiceILOInfo(
           java.lang.String iloId,
           java.lang.String iloRequiredInd,
           java.lang.String iloEligibilityInd,
           java.lang.String iloFreqAmountInd) {
           this.iloId = iloId;
           this.iloRequiredInd = iloRequiredInd;
           this.iloEligibilityInd = iloEligibilityInd;
           this.iloFreqAmountInd = iloFreqAmountInd;
    }


    /**
     * Gets the iloId value for this ServiceILOInfo.
     * 
     * @return iloId
     */
    public java.lang.String getIloId() {
        return iloId;
    }


    /**
     * Sets the iloId value for this ServiceILOInfo.
     * 
     * @param iloId
     */
    public void setIloId(java.lang.String iloId) {
        this.iloId = iloId;
    }


    /**
     * Gets the iloRequiredInd value for this ServiceILOInfo.
     * 
     * @return iloRequiredInd
     */
    public java.lang.String getIloRequiredInd() {
        return iloRequiredInd;
    }


    /**
     * Sets the iloRequiredInd value for this ServiceILOInfo.
     * 
     * @param iloRequiredInd
     */
    public void setIloRequiredInd(java.lang.String iloRequiredInd) {
        this.iloRequiredInd = iloRequiredInd;
    }


    /**
     * Gets the iloEligibilityInd value for this ServiceILOInfo.
     * 
     * @return iloEligibilityInd
     */
    public java.lang.String getIloEligibilityInd() {
        return iloEligibilityInd;
    }


    /**
     * Sets the iloEligibilityInd value for this ServiceILOInfo.
     * 
     * @param iloEligibilityInd
     */
    public void setIloEligibilityInd(java.lang.String iloEligibilityInd) {
        this.iloEligibilityInd = iloEligibilityInd;
    }


    /**
     * Gets the iloFreqAmountInd value for this ServiceILOInfo.
     * 
     * @return iloFreqAmountInd
     */
    public java.lang.String getIloFreqAmountInd() {
        return iloFreqAmountInd;
    }


    /**
     * Sets the iloFreqAmountInd value for this ServiceILOInfo.
     * 
     * @param iloFreqAmountInd
     */
    public void setIloFreqAmountInd(java.lang.String iloFreqAmountInd) {
        this.iloFreqAmountInd = iloFreqAmountInd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceILOInfo)) return false;
        ServiceILOInfo other = (ServiceILOInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.iloId==null && other.getIloId()==null) || 
             (this.iloId!=null &&
              this.iloId.equals(other.getIloId()))) &&
            ((this.iloRequiredInd==null && other.getIloRequiredInd()==null) || 
             (this.iloRequiredInd!=null &&
              this.iloRequiredInd.equals(other.getIloRequiredInd()))) &&
            ((this.iloEligibilityInd==null && other.getIloEligibilityInd()==null) || 
             (this.iloEligibilityInd!=null &&
              this.iloEligibilityInd.equals(other.getIloEligibilityInd()))) &&
            ((this.iloFreqAmountInd==null && other.getIloFreqAmountInd()==null) || 
             (this.iloFreqAmountInd!=null &&
              this.iloFreqAmountInd.equals(other.getIloFreqAmountInd())));
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
        if (getIloId() != null) {
            _hashCode += getIloId().hashCode();
        }
        if (getIloRequiredInd() != null) {
            _hashCode += getIloRequiredInd().hashCode();
        }
        if (getIloEligibilityInd() != null) {
            _hashCode += getIloEligibilityInd().hashCode();
        }
        if (getIloFreqAmountInd() != null) {
            _hashCode += getIloFreqAmountInd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceILOInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceILOInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iloId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iloId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iloRequiredInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iloRequiredInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iloEligibilityInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iloEligibilityInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iloFreqAmountInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iloFreqAmountInd"));
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

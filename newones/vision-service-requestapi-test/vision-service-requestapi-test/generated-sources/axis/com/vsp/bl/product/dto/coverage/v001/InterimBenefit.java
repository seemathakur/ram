/**
 * InterimBenefit.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v001;

public class InterimBenefit  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.Boolean futureEligibility;

    private java.lang.Integer minimumElapsedDays;

    private java.lang.Integer minimumElapsedMonths;

    public InterimBenefit() {
    }

    public InterimBenefit(
           java.lang.Boolean futureEligibility,
           java.lang.Integer minimumElapsedDays,
           java.lang.Integer minimumElapsedMonths) {
        this.futureEligibility = futureEligibility;
        this.minimumElapsedDays = minimumElapsedDays;
        this.minimumElapsedMonths = minimumElapsedMonths;
    }


    /**
     * Gets the futureEligibility value for this InterimBenefit.
     * 
     * @return futureEligibility
     */
    public java.lang.Boolean getFutureEligibility() {
        return futureEligibility;
    }


    /**
     * Sets the futureEligibility value for this InterimBenefit.
     * 
     * @param futureEligibility
     */
    public void setFutureEligibility(java.lang.Boolean futureEligibility) {
        this.futureEligibility = futureEligibility;
    }


    /**
     * Gets the minimumElapsedDays value for this InterimBenefit.
     * 
     * @return minimumElapsedDays
     */
    public java.lang.Integer getMinimumElapsedDays() {
        return minimumElapsedDays;
    }


    /**
     * Sets the minimumElapsedDays value for this InterimBenefit.
     * 
     * @param minimumElapsedDays
     */
    public void setMinimumElapsedDays(java.lang.Integer minimumElapsedDays) {
        this.minimumElapsedDays = minimumElapsedDays;
    }


    /**
     * Gets the minimumElapsedMonths value for this InterimBenefit.
     * 
     * @return minimumElapsedMonths
     */
    public java.lang.Integer getMinimumElapsedMonths() {
        return minimumElapsedMonths;
    }


    /**
     * Sets the minimumElapsedMonths value for this InterimBenefit.
     * 
     * @param minimumElapsedMonths
     */
    public void setMinimumElapsedMonths(java.lang.Integer minimumElapsedMonths) {
        this.minimumElapsedMonths = minimumElapsedMonths;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InterimBenefit)) return false;
        InterimBenefit other = (InterimBenefit) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.futureEligibility==null && other.getFutureEligibility()==null) || 
             (this.futureEligibility!=null &&
              this.futureEligibility.equals(other.getFutureEligibility()))) &&
            ((this.minimumElapsedDays==null && other.getMinimumElapsedDays()==null) || 
             (this.minimumElapsedDays!=null &&
              this.minimumElapsedDays.equals(other.getMinimumElapsedDays()))) &&
            ((this.minimumElapsedMonths==null && other.getMinimumElapsedMonths()==null) || 
             (this.minimumElapsedMonths!=null &&
              this.minimumElapsedMonths.equals(other.getMinimumElapsedMonths())));
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
        if (getFutureEligibility() != null) {
            _hashCode += getFutureEligibility().hashCode();
        }
        if (getMinimumElapsedDays() != null) {
            _hashCode += getMinimumElapsedDays().hashCode();
        }
        if (getMinimumElapsedMonths() != null) {
            _hashCode += getMinimumElapsedMonths().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InterimBenefit.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "InterimBenefit"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("futureEligibility");
        elemField.setXmlName(new javax.xml.namespace.QName("", "futureEligibility"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minimumElapsedDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minimumElapsedDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minimumElapsedMonths");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minimumElapsedMonths"));
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

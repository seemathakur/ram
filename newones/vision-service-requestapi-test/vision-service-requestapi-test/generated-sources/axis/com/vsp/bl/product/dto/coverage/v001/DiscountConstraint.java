/**
 * DiscountConstraint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v001;

public class DiscountConstraint  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.DatePeriod validPeriod;

    public DiscountConstraint() {
    }

    public DiscountConstraint(
           com.vsp.xl.dto.v002.DatePeriod validPeriod) {
           this.validPeriod = validPeriod;
    }


    /**
     * Gets the validPeriod value for this DiscountConstraint.
     * 
     * @return validPeriod
     */
    public com.vsp.xl.dto.v002.DatePeriod getValidPeriod() {
        return validPeriod;
    }


    /**
     * Sets the validPeriod value for this DiscountConstraint.
     * 
     * @param validPeriod
     */
    public void setValidPeriod(com.vsp.xl.dto.v002.DatePeriod validPeriod) {
        this.validPeriod = validPeriod;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DiscountConstraint)) return false;
        DiscountConstraint other = (DiscountConstraint) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.validPeriod==null && other.getValidPeriod()==null) || 
             (this.validPeriod!=null &&
              this.validPeriod.equals(other.getValidPeriod())));
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
        if (getValidPeriod() != null) {
            _hashCode += getValidPeriod().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DiscountConstraint.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "DiscountConstraint"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "DatePeriod"));
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

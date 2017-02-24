/**
 * ProductItemAuthorization.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class ProductItemAuthorization  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.Integer elapsedDays;

    private com.vsp.xl.dto.v002.SimpleCode endOf;

    public ProductItemAuthorization() {
    }

    public ProductItemAuthorization(
           java.lang.Integer elapsedDays,
           com.vsp.xl.dto.v002.SimpleCode endOf) {
        this.elapsedDays = elapsedDays;
        this.endOf = endOf;
    }


    /**
     * Gets the elapsedDays value for this ProductItemAuthorization.
     * 
     * @return elapsedDays
     */
    public java.lang.Integer getElapsedDays() {
        return elapsedDays;
    }


    /**
     * Sets the elapsedDays value for this ProductItemAuthorization.
     * 
     * @param elapsedDays
     */
    public void setElapsedDays(java.lang.Integer elapsedDays) {
        this.elapsedDays = elapsedDays;
    }


    /**
     * Gets the endOf value for this ProductItemAuthorization.
     * 
     * @return endOf
     */
    public com.vsp.xl.dto.v002.SimpleCode getEndOf() {
        return endOf;
    }


    /**
     * Sets the endOf value for this ProductItemAuthorization.
     * 
     * @param endOf
     */
    public void setEndOf(com.vsp.xl.dto.v002.SimpleCode endOf) {
        this.endOf = endOf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductItemAuthorization)) return false;
        ProductItemAuthorization other = (ProductItemAuthorization) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.elapsedDays==null && other.getElapsedDays()==null) || 
             (this.elapsedDays!=null &&
              this.elapsedDays.equals(other.getElapsedDays()))) &&
            ((this.endOf==null && other.getEndOf()==null) || 
             (this.endOf!=null &&
              this.endOf.equals(other.getEndOf())));
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
        if (getElapsedDays() != null) {
            _hashCode += getElapsedDays().hashCode();
        }
        if (getEndOf() != null) {
            _hashCode += getEndOf().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductItemAuthorization.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItemAuthorization"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elapsedDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "elapsedDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endOf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endOf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
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

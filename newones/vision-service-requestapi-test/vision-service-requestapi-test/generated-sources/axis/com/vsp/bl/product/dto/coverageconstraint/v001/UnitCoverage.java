/**
 * UnitCoverage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v001;

public class UnitCoverage  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.Integer numberOfUnits;

    private com.vsp.xl.dto.v002.SimpleCode timePeriod;

    public UnitCoverage() {
    }

    public UnitCoverage(
           java.lang.Integer numberOfUnits,
           com.vsp.xl.dto.v002.SimpleCode timePeriod) {
        this.numberOfUnits = numberOfUnits;
        this.timePeriod = timePeriod;
    }


    /**
     * Gets the numberOfUnits value for this UnitCoverage.
     * 
     * @return numberOfUnits
     */
    public java.lang.Integer getNumberOfUnits() {
        return numberOfUnits;
    }


    /**
     * Sets the numberOfUnits value for this UnitCoverage.
     * 
     * @param numberOfUnits
     */
    public void setNumberOfUnits(java.lang.Integer numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }


    /**
     * Gets the timePeriod value for this UnitCoverage.
     * 
     * @return timePeriod
     */
    public com.vsp.xl.dto.v002.SimpleCode getTimePeriod() {
        return timePeriod;
    }


    /**
     * Sets the timePeriod value for this UnitCoverage.
     * 
     * @param timePeriod
     */
    public void setTimePeriod(com.vsp.xl.dto.v002.SimpleCode timePeriod) {
        this.timePeriod = timePeriod;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnitCoverage)) return false;
        UnitCoverage other = (UnitCoverage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.numberOfUnits==null && other.getNumberOfUnits()==null) || 
             (this.numberOfUnits!=null &&
              this.numberOfUnits.equals(other.getNumberOfUnits()))) &&
            ((this.timePeriod==null && other.getTimePeriod()==null) || 
             (this.timePeriod!=null &&
              this.timePeriod.equals(other.getTimePeriod())));
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
        if (getNumberOfUnits() != null) {
            _hashCode += getNumberOfUnits().hashCode();
        }
        if (getTimePeriod() != null) {
            _hashCode += getTimePeriod().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnitCoverage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.coverageconstraint.dto.product.bl.vsp.com", "UnitCoverage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfUnits");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfUnits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timePeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timePeriod"));
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

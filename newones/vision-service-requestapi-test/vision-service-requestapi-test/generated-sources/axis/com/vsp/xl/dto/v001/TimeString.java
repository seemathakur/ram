/**
 * TimeString.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.xl.dto.v001;

public class TimeString  implements java.io.Serializable {
    private java.lang.String timeValue;

    public TimeString() {
    }

    public TimeString(
           java.lang.String timeValue) {
           this.timeValue = timeValue;
    }


    /**
     * Gets the timeValue value for this TimeString.
     * 
     * @return timeValue
     */
    public java.lang.String getTimeValue() {
        return timeValue;
    }


    /**
     * Sets the timeValue value for this TimeString.
     * 
     * @param timeValue
     */
    public void setTimeValue(java.lang.String timeValue) {
        this.timeValue = timeValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TimeString)) return false;
        TimeString other = (TimeString) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.timeValue==null && other.getTimeValue()==null) || 
             (this.timeValue!=null &&
              this.timeValue.equals(other.getTimeValue())));
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
        if (getTimeValue() != null) {
            _hashCode += getTimeValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TimeString.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.dto.xl.vsp.com", "TimeString"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeValue"));
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

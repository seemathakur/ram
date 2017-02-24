/**
 * TimePeriod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.xl.dto.v001;

public class TimePeriod  implements java.io.Serializable {
    private com.vsp.xl.dto.v001.TimeString endTime;

    private com.vsp.xl.dto.v001.TimeString startTime;

    public TimePeriod() {
    }

    public TimePeriod(
           com.vsp.xl.dto.v001.TimeString endTime,
           com.vsp.xl.dto.v001.TimeString startTime) {
           this.endTime = endTime;
           this.startTime = startTime;
    }


    /**
     * Gets the endTime value for this TimePeriod.
     * 
     * @return endTime
     */
    public com.vsp.xl.dto.v001.TimeString getEndTime() {
        return endTime;
    }


    /**
     * Sets the endTime value for this TimePeriod.
     * 
     * @param endTime
     */
    public void setEndTime(com.vsp.xl.dto.v001.TimeString endTime) {
        this.endTime = endTime;
    }


    /**
     * Gets the startTime value for this TimePeriod.
     * 
     * @return startTime
     */
    public com.vsp.xl.dto.v001.TimeString getStartTime() {
        return startTime;
    }


    /**
     * Sets the startTime value for this TimePeriod.
     * 
     * @param startTime
     */
    public void setStartTime(com.vsp.xl.dto.v001.TimeString startTime) {
        this.startTime = startTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TimePeriod)) return false;
        TimePeriod other = (TimePeriod) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.endTime==null && other.getEndTime()==null) || 
             (this.endTime!=null &&
              this.endTime.equals(other.getEndTime()))) &&
            ((this.startTime==null && other.getStartTime()==null) || 
             (this.startTime!=null &&
              this.startTime.equals(other.getStartTime())));
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
        if (getEndTime() != null) {
            _hashCode += getEndTime().hashCode();
        }
        if (getStartTime() != null) {
            _hashCode += getStartTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TimePeriod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.dto.xl.vsp.com", "TimePeriod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.dto.xl.vsp.com", "TimeString"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.dto.xl.vsp.com", "TimeString"));
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

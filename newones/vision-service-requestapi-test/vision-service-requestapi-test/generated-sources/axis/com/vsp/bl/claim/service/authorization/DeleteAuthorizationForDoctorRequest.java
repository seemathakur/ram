/**
 * DeleteAuthorizationForDoctorRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class DeleteAuthorizationForDoctorRequest  extends com.vsp.bl.claim.service.authorization.DeleteAuthorizationRequest  implements java.io.Serializable {
    private java.lang.String doctorPhoneNumber;

    public DeleteAuthorizationForDoctorRequest() {
    }

    public DeleteAuthorizationForDoctorRequest(
           java.lang.String serviceThreadId,
           java.lang.String businessTransactionId,
           java.lang.String requesterProcessName,
           java.lang.String userId,
           com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey authorizationKey,
           java.lang.String comments,
           java.lang.String doctorPhoneNumber) {
        super(
            serviceThreadId,
            businessTransactionId,
            requesterProcessName,
            userId,
            authorizationKey,
            comments);
        this.doctorPhoneNumber = doctorPhoneNumber;
    }


    /**
     * Gets the doctorPhoneNumber value for this DeleteAuthorizationForDoctorRequest.
     * 
     * @return doctorPhoneNumber
     */
    public java.lang.String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }


    /**
     * Sets the doctorPhoneNumber value for this DeleteAuthorizationForDoctorRequest.
     * 
     * @param doctorPhoneNumber
     */
    public void setDoctorPhoneNumber(java.lang.String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteAuthorizationForDoctorRequest)) return false;
        DeleteAuthorizationForDoctorRequest other = (DeleteAuthorizationForDoctorRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.doctorPhoneNumber==null && other.getDoctorPhoneNumber()==null) || 
             (this.doctorPhoneNumber!=null &&
              this.doctorPhoneNumber.equals(other.getDoctorPhoneNumber())));
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
        if (getDoctorPhoneNumber() != null) {
            _hashCode += getDoctorPhoneNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeleteAuthorizationForDoctorRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationForDoctorRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("doctorPhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "doctorPhoneNumber"));
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

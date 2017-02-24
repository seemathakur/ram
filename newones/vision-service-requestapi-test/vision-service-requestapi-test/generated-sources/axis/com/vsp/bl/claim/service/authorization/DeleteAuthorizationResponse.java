/**
 * DeleteAuthorizationResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class DeleteAuthorizationResponse  extends com.vsp.bl.service.v001.ServiceResponse  implements java.io.Serializable {
    public DeleteAuthorizationResponse() {
    }

    public DeleteAuthorizationResponse(
           com.vsp.bl.service.helper.v001.ServiceMessage[] severeMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] errorMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] warningMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] informationMessageList,
           boolean messagesEmpty,
           boolean severe,
           boolean error,
           boolean warning,
           boolean information,
           int severeCount,
           int errorCount,
           int warningCount,
           int informationCount) {
        super(
            severeMessageList,
            errorMessageList,
            warningMessageList,
            informationMessageList,
            messagesEmpty,
            severe,
            error,
            warning,
            information,
            severeCount,
            errorCount,
            warningCount,
            informationCount);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteAuthorizationResponse)) return false;
        DeleteAuthorizationResponse other = (DeleteAuthorizationResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeleteAuthorizationResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationResponse"));
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

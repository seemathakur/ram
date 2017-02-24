/**
 * AuthorizationKey.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.dto.authorization.v001;

public class AuthorizationKey  implements java.io.Serializable {
    private java.lang.Integer authorizationKey;

    public AuthorizationKey() {
    }

    public AuthorizationKey(
           java.lang.Integer authorizationKey) {
           this.authorizationKey = authorizationKey;
    }


    /**
     * Gets the authorizationKey value for this AuthorizationKey.
     * 
     * @return authorizationKey
     */
    public java.lang.Integer getAuthorizationKey() {
        return authorizationKey;
    }


    /**
     * Sets the authorizationKey value for this AuthorizationKey.
     * 
     * @param authorizationKey
     */
    public void setAuthorizationKey(java.lang.Integer authorizationKey) {
        this.authorizationKey = authorizationKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AuthorizationKey)) return false;
        AuthorizationKey other = (AuthorizationKey) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authorizationKey==null && other.getAuthorizationKey()==null) || 
             (this.authorizationKey!=null &&
              this.authorizationKey.equals(other.getAuthorizationKey())));
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
        if (getAuthorizationKey() != null) {
            _hashCode += getAuthorizationKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AuthorizationKey.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.authorization.dto.claim.bl.vsp.com", "AuthorizationKey"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorizationKey"));
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

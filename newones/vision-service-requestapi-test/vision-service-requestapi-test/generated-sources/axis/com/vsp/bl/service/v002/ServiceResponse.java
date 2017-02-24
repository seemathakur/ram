/**
 * ServiceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.service.v002;

public class ServiceResponse  implements java.io.Serializable {
    private com.vsp.bl.service.helper.v001.ServiceMessage[] errorMessageList;

    private com.vsp.bl.service.helper.v001.ServiceMessage[] warningMessageList;

    private com.vsp.bl.service.helper.v001.ServiceMessage[] informationMessageList;

    public ServiceResponse() {
    }

    public ServiceResponse(
           com.vsp.bl.service.helper.v001.ServiceMessage[] errorMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] warningMessageList,
           com.vsp.bl.service.helper.v001.ServiceMessage[] informationMessageList) {
           this.errorMessageList = errorMessageList;
           this.warningMessageList = warningMessageList;
           this.informationMessageList = informationMessageList;
    }


    /**
     * Gets the errorMessageList value for this ServiceResponse.
     * 
     * @return errorMessageList
     */
    public com.vsp.bl.service.helper.v001.ServiceMessage[] getErrorMessageList() {
        return errorMessageList;
    }


    /**
     * Sets the errorMessageList value for this ServiceResponse.
     * 
     * @param errorMessageList
     */
    public void setErrorMessageList(com.vsp.bl.service.helper.v001.ServiceMessage[] errorMessageList) {
        this.errorMessageList = errorMessageList;
    }


    /**
     * Gets the warningMessageList value for this ServiceResponse.
     * 
     * @return warningMessageList
     */
    public com.vsp.bl.service.helper.v001.ServiceMessage[] getWarningMessageList() {
        return warningMessageList;
    }


    /**
     * Sets the warningMessageList value for this ServiceResponse.
     * 
     * @param warningMessageList
     */
    public void setWarningMessageList(com.vsp.bl.service.helper.v001.ServiceMessage[] warningMessageList) {
        this.warningMessageList = warningMessageList;
    }


    /**
     * Gets the informationMessageList value for this ServiceResponse.
     * 
     * @return informationMessageList
     */
    public com.vsp.bl.service.helper.v001.ServiceMessage[] getInformationMessageList() {
        return informationMessageList;
    }


    /**
     * Sets the informationMessageList value for this ServiceResponse.
     * 
     * @param informationMessageList
     */
    public void setInformationMessageList(com.vsp.bl.service.helper.v001.ServiceMessage[] informationMessageList) {
        this.informationMessageList = informationMessageList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceResponse)) return false;
        ServiceResponse other = (ServiceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorMessageList==null && other.getErrorMessageList()==null) || 
             (this.errorMessageList!=null &&
              java.util.Arrays.equals(this.errorMessageList, other.getErrorMessageList()))) &&
            ((this.warningMessageList==null && other.getWarningMessageList()==null) || 
             (this.warningMessageList!=null &&
              java.util.Arrays.equals(this.warningMessageList, other.getWarningMessageList()))) &&
            ((this.informationMessageList==null && other.getInformationMessageList()==null) || 
             (this.informationMessageList!=null &&
              java.util.Arrays.equals(this.informationMessageList, other.getInformationMessageList())));
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
        if (getErrorMessageList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErrorMessageList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErrorMessageList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWarningMessageList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWarningMessageList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWarningMessageList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInformationMessageList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInformationMessageList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInformationMessageList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.service.bl.vsp.com", "ServiceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessageList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorMessageList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.helper.service.bl.vsp.com", "ServiceMessage"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warningMessageList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "warningMessageList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.helper.service.bl.vsp.com", "ServiceMessage"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informationMessageList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "informationMessageList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.helper.service.bl.vsp.com", "ServiceMessage"));
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

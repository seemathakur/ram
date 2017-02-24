/**
 * ServiceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.service.v001;

public class ServiceResponse  implements java.io.Serializable {
    private com.vsp.bl.service.helper.v001.ServiceMessage[] severeMessageList;

    private com.vsp.bl.service.helper.v001.ServiceMessage[] errorMessageList;

    private com.vsp.bl.service.helper.v001.ServiceMessage[] warningMessageList;

    private com.vsp.bl.service.helper.v001.ServiceMessage[] informationMessageList;

    private boolean messagesEmpty;

    private boolean severe;

    private boolean error;

    private boolean warning;

    private boolean information;

    private int severeCount;

    private int errorCount;

    private int warningCount;

    private int informationCount;

    public ServiceResponse() {
    }

    public ServiceResponse(
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
           this.severeMessageList = severeMessageList;
           this.errorMessageList = errorMessageList;
           this.warningMessageList = warningMessageList;
           this.informationMessageList = informationMessageList;
           this.messagesEmpty = messagesEmpty;
           this.severe = severe;
           this.error = error;
           this.warning = warning;
           this.information = information;
           this.severeCount = severeCount;
           this.errorCount = errorCount;
           this.warningCount = warningCount;
           this.informationCount = informationCount;
    }


    /**
     * Gets the severeMessageList value for this ServiceResponse.
     * 
     * @return severeMessageList
     */
    public com.vsp.bl.service.helper.v001.ServiceMessage[] getSevereMessageList() {
        return severeMessageList;
    }


    /**
     * Sets the severeMessageList value for this ServiceResponse.
     * 
     * @param severeMessageList
     */
    public void setSevereMessageList(com.vsp.bl.service.helper.v001.ServiceMessage[] severeMessageList) {
        this.severeMessageList = severeMessageList;
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


    /**
     * Gets the messagesEmpty value for this ServiceResponse.
     * 
     * @return messagesEmpty
     */
    public boolean isMessagesEmpty() {
        return messagesEmpty;
    }


    /**
     * Sets the messagesEmpty value for this ServiceResponse.
     * 
     * @param messagesEmpty
     */
    public void setMessagesEmpty(boolean messagesEmpty) {
        this.messagesEmpty = messagesEmpty;
    }


    /**
     * Gets the severe value for this ServiceResponse.
     * 
     * @return severe
     */
    public boolean isSevere() {
        return severe;
    }


    /**
     * Sets the severe value for this ServiceResponse.
     * 
     * @param severe
     */
    public void setSevere(boolean severe) {
        this.severe = severe;
    }


    /**
     * Gets the error value for this ServiceResponse.
     * 
     * @return error
     */
    public boolean isError() {
        return error;
    }


    /**
     * Sets the error value for this ServiceResponse.
     * 
     * @param error
     */
    public void setError(boolean error) {
        this.error = error;
    }


    /**
     * Gets the warning value for this ServiceResponse.
     * 
     * @return warning
     */
    public boolean isWarning() {
        return warning;
    }


    /**
     * Sets the warning value for this ServiceResponse.
     * 
     * @param warning
     */
    public void setWarning(boolean warning) {
        this.warning = warning;
    }


    /**
     * Gets the information value for this ServiceResponse.
     * 
     * @return information
     */
    public boolean isInformation() {
        return information;
    }


    /**
     * Sets the information value for this ServiceResponse.
     * 
     * @param information
     */
    public void setInformation(boolean information) {
        this.information = information;
    }


    /**
     * Gets the severeCount value for this ServiceResponse.
     * 
     * @return severeCount
     */
    public int getSevereCount() {
        return severeCount;
    }


    /**
     * Sets the severeCount value for this ServiceResponse.
     * 
     * @param severeCount
     */
    public void setSevereCount(int severeCount) {
        this.severeCount = severeCount;
    }


    /**
     * Gets the errorCount value for this ServiceResponse.
     * 
     * @return errorCount
     */
    public int getErrorCount() {
        return errorCount;
    }


    /**
     * Sets the errorCount value for this ServiceResponse.
     * 
     * @param errorCount
     */
    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }


    /**
     * Gets the warningCount value for this ServiceResponse.
     * 
     * @return warningCount
     */
    public int getWarningCount() {
        return warningCount;
    }


    /**
     * Sets the warningCount value for this ServiceResponse.
     * 
     * @param warningCount
     */
    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }


    /**
     * Gets the informationCount value for this ServiceResponse.
     * 
     * @return informationCount
     */
    public int getInformationCount() {
        return informationCount;
    }


    /**
     * Sets the informationCount value for this ServiceResponse.
     * 
     * @param informationCount
     */
    public void setInformationCount(int informationCount) {
        this.informationCount = informationCount;
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
            ((this.severeMessageList==null && other.getSevereMessageList()==null) || 
             (this.severeMessageList!=null &&
              java.util.Arrays.equals(this.severeMessageList, other.getSevereMessageList()))) &&
            ((this.errorMessageList==null && other.getErrorMessageList()==null) || 
             (this.errorMessageList!=null &&
              java.util.Arrays.equals(this.errorMessageList, other.getErrorMessageList()))) &&
            ((this.warningMessageList==null && other.getWarningMessageList()==null) || 
             (this.warningMessageList!=null &&
              java.util.Arrays.equals(this.warningMessageList, other.getWarningMessageList()))) &&
            ((this.informationMessageList==null && other.getInformationMessageList()==null) || 
             (this.informationMessageList!=null &&
              java.util.Arrays.equals(this.informationMessageList, other.getInformationMessageList()))) &&
            this.messagesEmpty == other.isMessagesEmpty() &&
            this.severe == other.isSevere() &&
            this.error == other.isError() &&
            this.warning == other.isWarning() &&
            this.information == other.isInformation() &&
            this.severeCount == other.getSevereCount() &&
            this.errorCount == other.getErrorCount() &&
            this.warningCount == other.getWarningCount() &&
            this.informationCount == other.getInformationCount();
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
        if (getSevereMessageList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSevereMessageList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSevereMessageList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        _hashCode += (isMessagesEmpty() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSevere() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isError() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isWarning() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isInformation() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getSevereCount();
        _hashCode += getErrorCount();
        _hashCode += getWarningCount();
        _hashCode += getInformationCount();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.service.bl.vsp.com", "ServiceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("severeMessageList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "severeMessageList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.helper.service.bl.vsp.com", "ServiceMessage"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messagesEmpty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "messagesEmpty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("severe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "severe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("", "error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warning");
        elemField.setXmlName(new javax.xml.namespace.QName("", "warning"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("information");
        elemField.setXmlName(new javax.xml.namespace.QName("", "information"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("severeCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "severeCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warningCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "warningCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informationCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "informationCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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

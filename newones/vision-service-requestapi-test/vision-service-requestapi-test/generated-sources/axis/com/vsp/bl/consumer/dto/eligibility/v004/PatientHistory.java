/**
 * PatientHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.eligibility.v004;

public class PatientHistory  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.String authorization;

    private java.lang.String authorizationExt;

    private java.lang.String state;

    private com.vsp.xl.dto.v002.SimpleCode status;

    private com.vsp.xl.dto.v002.Date serviceDate;

    private com.vsp.bl.consumer.dto.eligibility.v004.ProvidedItem[] providedItems;

    public PatientHistory() {
    }

    public PatientHistory(
           java.lang.String authorization,
           java.lang.String authorizationExt,
           java.lang.String state,
           com.vsp.xl.dto.v002.SimpleCode status,
           com.vsp.xl.dto.v002.Date serviceDate,
           com.vsp.bl.consumer.dto.eligibility.v004.ProvidedItem[] providedItems) {
        this.authorization = authorization;
        this.authorizationExt = authorizationExt;
        this.state = state;
        this.status = status;
        this.serviceDate = serviceDate;
        this.providedItems = providedItems;
    }


    /**
     * Gets the authorization value for this PatientHistory.
     * 
     * @return authorization
     */
    public java.lang.String getAuthorization() {
        return authorization;
    }


    /**
     * Sets the authorization value for this PatientHistory.
     * 
     * @param authorization
     */
    public void setAuthorization(java.lang.String authorization) {
        this.authorization = authorization;
    }


    /**
     * Gets the authorizationExt value for this PatientHistory.
     * 
     * @return authorizationExt
     */
    public java.lang.String getAuthorizationExt() {
        return authorizationExt;
    }


    /**
     * Sets the authorizationExt value for this PatientHistory.
     * 
     * @param authorizationExt
     */
    public void setAuthorizationExt(java.lang.String authorizationExt) {
        this.authorizationExt = authorizationExt;
    }


    /**
     * Gets the state value for this PatientHistory.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this PatientHistory.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the status value for this PatientHistory.
     * 
     * @return status
     */
    public com.vsp.xl.dto.v002.SimpleCode getStatus() {
        return status;
    }


    /**
     * Sets the status value for this PatientHistory.
     * 
     * @param status
     */
    public void setStatus(com.vsp.xl.dto.v002.SimpleCode status) {
        this.status = status;
    }


    /**
     * Gets the serviceDate value for this PatientHistory.
     * 
     * @return serviceDate
     */
    public com.vsp.xl.dto.v002.Date getServiceDate() {
        return serviceDate;
    }


    /**
     * Sets the serviceDate value for this PatientHistory.
     * 
     * @param serviceDate
     */
    public void setServiceDate(com.vsp.xl.dto.v002.Date serviceDate) {
        this.serviceDate = serviceDate;
    }


    /**
     * Gets the providedItems value for this PatientHistory.
     * 
     * @return providedItems
     */
    public com.vsp.bl.consumer.dto.eligibility.v004.ProvidedItem[] getProvidedItems() {
        return providedItems;
    }


    /**
     * Sets the providedItems value for this PatientHistory.
     * 
     * @param providedItems
     */
    public void setProvidedItems(com.vsp.bl.consumer.dto.eligibility.v004.ProvidedItem[] providedItems) {
        this.providedItems = providedItems;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PatientHistory)) return false;
        PatientHistory other = (PatientHistory) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.authorization==null && other.getAuthorization()==null) || 
             (this.authorization!=null &&
              this.authorization.equals(other.getAuthorization()))) &&
            ((this.authorizationExt==null && other.getAuthorizationExt()==null) || 
             (this.authorizationExt!=null &&
              this.authorizationExt.equals(other.getAuthorizationExt()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.serviceDate==null && other.getServiceDate()==null) || 
             (this.serviceDate!=null &&
              this.serviceDate.equals(other.getServiceDate()))) &&
            ((this.providedItems==null && other.getProvidedItems()==null) || 
             (this.providedItems!=null &&
              java.util.Arrays.equals(this.providedItems, other.getProvidedItems())));
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
        if (getAuthorization() != null) {
            _hashCode += getAuthorization().hashCode();
        }
        if (getAuthorizationExt() != null) {
            _hashCode += getAuthorizationExt().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getServiceDate() != null) {
            _hashCode += getServiceDate().hashCode();
        }
        if (getProvidedItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProvidedItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProvidedItems(), i);
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
        new org.apache.axis.description.TypeDesc(PatientHistory.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "PatientHistory"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorization");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorization"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizationExt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authorizationExt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("providedItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "providedItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ProvidedItem"));
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

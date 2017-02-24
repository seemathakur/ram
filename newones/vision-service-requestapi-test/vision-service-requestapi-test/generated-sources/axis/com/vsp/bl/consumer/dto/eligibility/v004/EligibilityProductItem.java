/**
 * EligibilityProductItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.eligibility.v004;

public class EligibilityProductItem  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.Date nextAvailableDate;

    private com.vsp.bl.product.dto.coverage.v002.ProductItem productItem;

    private java.lang.Boolean isAvailable;

    private java.lang.String label;

    private java.lang.String state;

    private com.vsp.xl.dto.v002.SimpleCode status;

    private java.lang.String serviceReportName;

    public EligibilityProductItem() {
    }

    public EligibilityProductItem(
           com.vsp.xl.dto.v002.Date nextAvailableDate,
           com.vsp.bl.product.dto.coverage.v002.ProductItem productItem,
           java.lang.Boolean isAvailable,
           java.lang.String label,
           java.lang.String state,
           com.vsp.xl.dto.v002.SimpleCode status,
           java.lang.String serviceReportName) {
        this.nextAvailableDate = nextAvailableDate;
        this.productItem = productItem;
        this.isAvailable = isAvailable;
        this.label = label;
        this.state = state;
        this.status = status;
        this.serviceReportName = serviceReportName;
    }


    /**
     * Gets the nextAvailableDate value for this EligibilityProductItem.
     * 
     * @return nextAvailableDate
     */
    public com.vsp.xl.dto.v002.Date getNextAvailableDate() {
        return nextAvailableDate;
    }


    /**
     * Sets the nextAvailableDate value for this EligibilityProductItem.
     * 
     * @param nextAvailableDate
     */
    public void setNextAvailableDate(com.vsp.xl.dto.v002.Date nextAvailableDate) {
        this.nextAvailableDate = nextAvailableDate;
    }


    /**
     * Gets the productItem value for this EligibilityProductItem.
     * 
     * @return productItem
     */
    public com.vsp.bl.product.dto.coverage.v002.ProductItem getProductItem() {
        return productItem;
    }


    /**
     * Sets the productItem value for this EligibilityProductItem.
     * 
     * @param productItem
     */
    public void setProductItem(com.vsp.bl.product.dto.coverage.v002.ProductItem productItem) {
        this.productItem = productItem;
    }


    /**
     * Gets the isAvailable value for this EligibilityProductItem.
     * 
     * @return isAvailable
     */
    public java.lang.Boolean getIsAvailable() {
        return isAvailable;
    }


    /**
     * Sets the isAvailable value for this EligibilityProductItem.
     * 
     * @param isAvailable
     */
    public void setIsAvailable(java.lang.Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    /**
     * Gets the label value for this EligibilityProductItem.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this EligibilityProductItem.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the state value for this EligibilityProductItem.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this EligibilityProductItem.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the status value for this EligibilityProductItem.
     * 
     * @return status
     */
    public com.vsp.xl.dto.v002.SimpleCode getStatus() {
        return status;
    }


    /**
     * Sets the status value for this EligibilityProductItem.
     * 
     * @param status
     */
    public void setStatus(com.vsp.xl.dto.v002.SimpleCode status) {
        this.status = status;
    }


    /**
     * Gets the serviceReportName value for this EligibilityProductItem.
     * 
     * @return serviceReportName
     */
    public java.lang.String getServiceReportName() {
        return serviceReportName;
    }


    /**
     * Sets the serviceReportName value for this EligibilityProductItem.
     * 
     * @param serviceReportName
     */
    public void setServiceReportName(java.lang.String serviceReportName) {
        this.serviceReportName = serviceReportName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EligibilityProductItem)) return false;
        EligibilityProductItem other = (EligibilityProductItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.nextAvailableDate==null && other.getNextAvailableDate()==null) || 
             (this.nextAvailableDate!=null &&
              this.nextAvailableDate.equals(other.getNextAvailableDate()))) &&
            ((this.productItem==null && other.getProductItem()==null) || 
             (this.productItem!=null &&
              this.productItem.equals(other.getProductItem()))) &&
            ((this.isAvailable==null && other.getIsAvailable()==null) || 
             (this.isAvailable!=null &&
              this.isAvailable.equals(other.getIsAvailable()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.serviceReportName==null && other.getServiceReportName()==null) || 
             (this.serviceReportName!=null &&
              this.serviceReportName.equals(other.getServiceReportName())));
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
        if (getNextAvailableDate() != null) {
            _hashCode += getNextAvailableDate().hashCode();
        }
        if (getProductItem() != null) {
            _hashCode += getProductItem().hashCode();
        }
        if (getIsAvailable() != null) {
            _hashCode += getIsAvailable().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getServiceReportName() != null) {
            _hashCode += getServiceReportName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EligibilityProductItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "EligibilityProductItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nextAvailableDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nextAvailableDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItem"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAvailable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAvailable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("", "label"));
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
        elemField.setFieldName("serviceReportName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceReportName"));
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

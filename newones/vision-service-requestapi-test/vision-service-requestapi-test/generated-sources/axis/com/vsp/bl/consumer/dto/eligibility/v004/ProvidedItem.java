/**
 * ProvidedItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.eligibility.v004;

public class ProvidedItem  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.Date availableDate;

    private com.vsp.bl.product.dto.coverage.v002.ProductItem productItem;

    public ProvidedItem() {
    }

    public ProvidedItem(
           com.vsp.xl.dto.v002.Date availableDate,
           com.vsp.bl.product.dto.coverage.v002.ProductItem productItem) {
        this.availableDate = availableDate;
        this.productItem = productItem;
    }


    /**
     * Gets the availableDate value for this ProvidedItem.
     * 
     * @return availableDate
     */
    public com.vsp.xl.dto.v002.Date getAvailableDate() {
        return availableDate;
    }


    /**
     * Sets the availableDate value for this ProvidedItem.
     * 
     * @param availableDate
     */
    public void setAvailableDate(com.vsp.xl.dto.v002.Date availableDate) {
        this.availableDate = availableDate;
    }


    /**
     * Gets the productItem value for this ProvidedItem.
     * 
     * @return productItem
     */
    public com.vsp.bl.product.dto.coverage.v002.ProductItem getProductItem() {
        return productItem;
    }


    /**
     * Sets the productItem value for this ProvidedItem.
     * 
     * @param productItem
     */
    public void setProductItem(com.vsp.bl.product.dto.coverage.v002.ProductItem productItem) {
        this.productItem = productItem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProvidedItem)) return false;
        ProvidedItem other = (ProvidedItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.availableDate==null && other.getAvailableDate()==null) || 
             (this.availableDate!=null &&
              this.availableDate.equals(other.getAvailableDate()))) &&
            ((this.productItem==null && other.getProductItem()==null) || 
             (this.productItem!=null &&
              this.productItem.equals(other.getProductItem())));
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
        if (getAvailableDate() != null) {
            _hashCode += getAvailableDate().hashCode();
        }
        if (getProductItem() != null) {
            _hashCode += getProductItem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProvidedItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ProvidedItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("availableDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "availableDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItem"));
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

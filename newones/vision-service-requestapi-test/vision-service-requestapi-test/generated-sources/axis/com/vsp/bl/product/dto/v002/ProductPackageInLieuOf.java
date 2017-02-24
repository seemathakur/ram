/**
 * ProductPackageInLieuOf.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.v002;

public class ProductPackageInLieuOf  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.product.dto.v002.ProductPackage productPackage;

    public ProductPackageInLieuOf() {
    }

    public ProductPackageInLieuOf(
           com.vsp.bl.product.dto.v002.ProductPackage productPackage) {
        this.productPackage = productPackage;
    }


    /**
     * Gets the productPackage value for this ProductPackageInLieuOf.
     * 
     * @return productPackage
     */
    public com.vsp.bl.product.dto.v002.ProductPackage getProductPackage() {
        return productPackage;
    }


    /**
     * Sets the productPackage value for this ProductPackageInLieuOf.
     * 
     * @param productPackage
     */
    public void setProductPackage(com.vsp.bl.product.dto.v002.ProductPackage productPackage) {
        this.productPackage = productPackage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductPackageInLieuOf)) return false;
        ProductPackageInLieuOf other = (ProductPackageInLieuOf) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.productPackage==null && other.getProductPackage()==null) || 
             (this.productPackage!=null &&
              this.productPackage.equals(other.getProductPackage())));
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
        if (getProductPackage() != null) {
            _hashCode += getProductPackage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductPackageInLieuOf.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductPackageInLieuOf"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productPackage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productPackage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductPackage"));
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

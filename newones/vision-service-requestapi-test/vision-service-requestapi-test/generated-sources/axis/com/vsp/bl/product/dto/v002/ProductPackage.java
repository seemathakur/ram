/**
 * ProductPackage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.v002;

public class ProductPackage  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private java.lang.String name;

    private com.vsp.bl.product.dto.coverage.v002.PatientRelationship[] patientRelationships;

    private com.vsp.bl.product.dto.cob.v002.COBExceptionRule[] cobExceptionRules;

    private com.vsp.bl.product.dto.coverage.v002.CombinedProductItem[] combinedProductItems;

    private com.vsp.bl.product.dto.relationshipservice.v002.Commission commission;

    private com.vsp.bl.product.dto.rate.v002.CompositeRate compositeRate;

    private com.vsp.xl.dto.v002.SimpleCode pooledRatingConfiguration;

    private java.lang.Boolean primaryProduct;

    private com.vsp.bl.product.dto.coverage.v002.ProductItem[] productItems;

    private com.vsp.bl.product.dto.coverage.v001.ExternalRule externalRule;

    private com.vsp.bl.product.dto.v002.ProductPackageInLieuOf[] productPackageInLieuOfs;

    public ProductPackage() {
    }

    public ProductPackage(
           java.lang.String name,
           com.vsp.bl.product.dto.coverage.v002.PatientRelationship[] patientRelationships,
           com.vsp.bl.product.dto.cob.v002.COBExceptionRule[] cobExceptionRules,
           com.vsp.bl.product.dto.coverage.v002.CombinedProductItem[] combinedProductItems,
           com.vsp.bl.product.dto.relationshipservice.v002.Commission commission,
           com.vsp.bl.product.dto.rate.v002.CompositeRate compositeRate,
           com.vsp.xl.dto.v002.SimpleCode pooledRatingConfiguration,
           java.lang.Boolean primaryProduct,
           com.vsp.bl.product.dto.coverage.v002.ProductItem[] productItems,
           com.vsp.bl.product.dto.coverage.v001.ExternalRule externalRule,
           com.vsp.bl.product.dto.v002.ProductPackageInLieuOf[] productPackageInLieuOfs) {
        this.name = name;
        this.patientRelationships = patientRelationships;
        this.cobExceptionRules = cobExceptionRules;
        this.combinedProductItems = combinedProductItems;
        this.commission = commission;
        this.compositeRate = compositeRate;
        this.pooledRatingConfiguration = pooledRatingConfiguration;
        this.primaryProduct = primaryProduct;
        this.productItems = productItems;
        this.externalRule = externalRule;
        this.productPackageInLieuOfs = productPackageInLieuOfs;
    }


    /**
     * Gets the name value for this ProductPackage.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ProductPackage.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the patientRelationships value for this ProductPackage.
     * 
     * @return patientRelationships
     */
    public com.vsp.bl.product.dto.coverage.v002.PatientRelationship[] getPatientRelationships() {
        return patientRelationships;
    }


    /**
     * Sets the patientRelationships value for this ProductPackage.
     * 
     * @param patientRelationships
     */
    public void setPatientRelationships(com.vsp.bl.product.dto.coverage.v002.PatientRelationship[] patientRelationships) {
        this.patientRelationships = patientRelationships;
    }


    /**
     * Gets the cobExceptionRules value for this ProductPackage.
     * 
     * @return cobExceptionRules
     */
    public com.vsp.bl.product.dto.cob.v002.COBExceptionRule[] getCobExceptionRules() {
        return cobExceptionRules;
    }


    /**
     * Sets the cobExceptionRules value for this ProductPackage.
     * 
     * @param cobExceptionRules
     */
    public void setCobExceptionRules(com.vsp.bl.product.dto.cob.v002.COBExceptionRule[] cobExceptionRules) {
        this.cobExceptionRules = cobExceptionRules;
    }


    /**
     * Gets the combinedProductItems value for this ProductPackage.
     * 
     * @return combinedProductItems
     */
    public com.vsp.bl.product.dto.coverage.v002.CombinedProductItem[] getCombinedProductItems() {
        return combinedProductItems;
    }


    /**
     * Sets the combinedProductItems value for this ProductPackage.
     * 
     * @param combinedProductItems
     */
    public void setCombinedProductItems(com.vsp.bl.product.dto.coverage.v002.CombinedProductItem[] combinedProductItems) {
        this.combinedProductItems = combinedProductItems;
    }


    /**
     * Gets the commission value for this ProductPackage.
     * 
     * @return commission
     */
    public com.vsp.bl.product.dto.relationshipservice.v002.Commission getCommission() {
        return commission;
    }


    /**
     * Sets the commission value for this ProductPackage.
     * 
     * @param commission
     */
    public void setCommission(com.vsp.bl.product.dto.relationshipservice.v002.Commission commission) {
        this.commission = commission;
    }


    /**
     * Gets the compositeRate value for this ProductPackage.
     * 
     * @return compositeRate
     */
    public com.vsp.bl.product.dto.rate.v002.CompositeRate getCompositeRate() {
        return compositeRate;
    }


    /**
     * Sets the compositeRate value for this ProductPackage.
     * 
     * @param compositeRate
     */
    public void setCompositeRate(com.vsp.bl.product.dto.rate.v002.CompositeRate compositeRate) {
        this.compositeRate = compositeRate;
    }


    /**
     * Gets the pooledRatingConfiguration value for this ProductPackage.
     * 
     * @return pooledRatingConfiguration
     */
    public com.vsp.xl.dto.v002.SimpleCode getPooledRatingConfiguration() {
        return pooledRatingConfiguration;
    }


    /**
     * Sets the pooledRatingConfiguration value for this ProductPackage.
     * 
     * @param pooledRatingConfiguration
     */
    public void setPooledRatingConfiguration(com.vsp.xl.dto.v002.SimpleCode pooledRatingConfiguration) {
        this.pooledRatingConfiguration = pooledRatingConfiguration;
    }


    /**
     * Gets the primaryProduct value for this ProductPackage.
     * 
     * @return primaryProduct
     */
    public java.lang.Boolean getPrimaryProduct() {
        return primaryProduct;
    }


    /**
     * Sets the primaryProduct value for this ProductPackage.
     * 
     * @param primaryProduct
     */
    public void setPrimaryProduct(java.lang.Boolean primaryProduct) {
        this.primaryProduct = primaryProduct;
    }


    /**
     * Gets the productItems value for this ProductPackage.
     * 
     * @return productItems
     */
    public com.vsp.bl.product.dto.coverage.v002.ProductItem[] getProductItems() {
        return productItems;
    }


    /**
     * Sets the productItems value for this ProductPackage.
     * 
     * @param productItems
     */
    public void setProductItems(com.vsp.bl.product.dto.coverage.v002.ProductItem[] productItems) {
        this.productItems = productItems;
    }


    /**
     * Gets the externalRule value for this ProductPackage.
     * 
     * @return externalRule
     */
    public com.vsp.bl.product.dto.coverage.v001.ExternalRule getExternalRule() {
        return externalRule;
    }


    /**
     * Sets the externalRule value for this ProductPackage.
     * 
     * @param externalRule
     */
    public void setExternalRule(com.vsp.bl.product.dto.coverage.v001.ExternalRule externalRule) {
        this.externalRule = externalRule;
    }


    /**
     * Gets the productPackageInLieuOfs value for this ProductPackage.
     * 
     * @return productPackageInLieuOfs
     */
    public com.vsp.bl.product.dto.v002.ProductPackageInLieuOf[] getProductPackageInLieuOfs() {
        return productPackageInLieuOfs;
    }


    /**
     * Sets the productPackageInLieuOfs value for this ProductPackage.
     * 
     * @param productPackageInLieuOfs
     */
    public void setProductPackageInLieuOfs(com.vsp.bl.product.dto.v002.ProductPackageInLieuOf[] productPackageInLieuOfs) {
        this.productPackageInLieuOfs = productPackageInLieuOfs;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductPackage)) return false;
        ProductPackage other = (ProductPackage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.patientRelationships==null && other.getPatientRelationships()==null) || 
             (this.patientRelationships!=null &&
              java.util.Arrays.equals(this.patientRelationships, other.getPatientRelationships()))) &&
            ((this.cobExceptionRules==null && other.getCobExceptionRules()==null) || 
             (this.cobExceptionRules!=null &&
              java.util.Arrays.equals(this.cobExceptionRules, other.getCobExceptionRules()))) &&
            ((this.combinedProductItems==null && other.getCombinedProductItems()==null) || 
             (this.combinedProductItems!=null &&
              java.util.Arrays.equals(this.combinedProductItems, other.getCombinedProductItems()))) &&
            ((this.commission==null && other.getCommission()==null) || 
             (this.commission!=null &&
              this.commission.equals(other.getCommission()))) &&
            ((this.compositeRate==null && other.getCompositeRate()==null) || 
             (this.compositeRate!=null &&
              this.compositeRate.equals(other.getCompositeRate()))) &&
            ((this.pooledRatingConfiguration==null && other.getPooledRatingConfiguration()==null) || 
             (this.pooledRatingConfiguration!=null &&
              this.pooledRatingConfiguration.equals(other.getPooledRatingConfiguration()))) &&
            ((this.primaryProduct==null && other.getPrimaryProduct()==null) || 
             (this.primaryProduct!=null &&
              this.primaryProduct.equals(other.getPrimaryProduct()))) &&
            ((this.productItems==null && other.getProductItems()==null) || 
             (this.productItems!=null &&
              java.util.Arrays.equals(this.productItems, other.getProductItems()))) &&
            ((this.externalRule==null && other.getExternalRule()==null) || 
             (this.externalRule!=null &&
              this.externalRule.equals(other.getExternalRule()))) &&
            ((this.productPackageInLieuOfs==null && other.getProductPackageInLieuOfs()==null) || 
             (this.productPackageInLieuOfs!=null &&
              java.util.Arrays.equals(this.productPackageInLieuOfs, other.getProductPackageInLieuOfs())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPatientRelationships() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPatientRelationships());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPatientRelationships(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCobExceptionRules() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCobExceptionRules());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCobExceptionRules(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCombinedProductItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCombinedProductItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCombinedProductItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCommission() != null) {
            _hashCode += getCommission().hashCode();
        }
        if (getCompositeRate() != null) {
            _hashCode += getCompositeRate().hashCode();
        }
        if (getPooledRatingConfiguration() != null) {
            _hashCode += getPooledRatingConfiguration().hashCode();
        }
        if (getPrimaryProduct() != null) {
            _hashCode += getPrimaryProduct().hashCode();
        }
        if (getProductItems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductItems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductItems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExternalRule() != null) {
            _hashCode += getExternalRule().hashCode();
        }
        if (getProductPackageInLieuOfs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductPackageInLieuOfs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductPackageInLieuOfs(), i);
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
        new org.apache.axis.description.TypeDesc(ProductPackage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductPackage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientRelationships");
        elemField.setXmlName(new javax.xml.namespace.QName("", "patientRelationships"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PatientRelationship"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cobExceptionRules");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cobExceptionRules"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.cob.dto.product.bl.vsp.com", "COBExceptionRule"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("combinedProductItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "combinedProductItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "CombinedProductItem"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commission");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.relationshipservice.dto.product.bl.vsp.com", "Commission"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compositeRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "compositeRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "CompositeRate"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pooledRatingConfiguration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pooledRatingConfiguration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryProduct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primaryProduct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItem"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("externalRule");
        elemField.setXmlName(new javax.xml.namespace.QName("", "externalRule"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "ExternalRule"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productPackageInLieuOfs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productPackageInLieuOfs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductPackageInLieuOf"));
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

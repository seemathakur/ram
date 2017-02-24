/**
 * CombinedProductItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class CombinedProductItem  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint[] coverageConstraints;

    private com.vsp.bl.product.dto.coverage.v002.ProductItem[] productItems;

    private java.lang.Boolean preCertificationRequired;

    private java.lang.Boolean referralRequired;

    private java.lang.Boolean sharedBenefit;

    public CombinedProductItem() {
    }

    public CombinedProductItem(
           com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint[] coverageConstraints,
           com.vsp.bl.product.dto.coverage.v002.ProductItem[] productItems,
           java.lang.Boolean preCertificationRequired,
           java.lang.Boolean referralRequired,
           java.lang.Boolean sharedBenefit) {
        this.coverageConstraints = coverageConstraints;
        this.productItems = productItems;
        this.preCertificationRequired = preCertificationRequired;
        this.referralRequired = referralRequired;
        this.sharedBenefit = sharedBenefit;
    }


    /**
     * Gets the coverageConstraints value for this CombinedProductItem.
     * 
     * @return coverageConstraints
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint[] getCoverageConstraints() {
        return coverageConstraints;
    }


    /**
     * Sets the coverageConstraints value for this CombinedProductItem.
     * 
     * @param coverageConstraints
     */
    public void setCoverageConstraints(com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint[] coverageConstraints) {
        this.coverageConstraints = coverageConstraints;
    }


    /**
     * Gets the productItems value for this CombinedProductItem.
     * 
     * @return productItems
     */
    public com.vsp.bl.product.dto.coverage.v002.ProductItem[] getProductItems() {
        return productItems;
    }


    /**
     * Sets the productItems value for this CombinedProductItem.
     * 
     * @param productItems
     */
    public void setProductItems(com.vsp.bl.product.dto.coverage.v002.ProductItem[] productItems) {
        this.productItems = productItems;
    }


    /**
     * Gets the preCertificationRequired value for this CombinedProductItem.
     * 
     * @return preCertificationRequired
     */
    public java.lang.Boolean getPreCertificationRequired() {
        return preCertificationRequired;
    }


    /**
     * Sets the preCertificationRequired value for this CombinedProductItem.
     * 
     * @param preCertificationRequired
     */
    public void setPreCertificationRequired(java.lang.Boolean preCertificationRequired) {
        this.preCertificationRequired = preCertificationRequired;
    }


    /**
     * Gets the referralRequired value for this CombinedProductItem.
     * 
     * @return referralRequired
     */
    public java.lang.Boolean getReferralRequired() {
        return referralRequired;
    }


    /**
     * Sets the referralRequired value for this CombinedProductItem.
     * 
     * @param referralRequired
     */
    public void setReferralRequired(java.lang.Boolean referralRequired) {
        this.referralRequired = referralRequired;
    }


    /**
     * Gets the sharedBenefit value for this CombinedProductItem.
     * 
     * @return sharedBenefit
     */
    public java.lang.Boolean getSharedBenefit() {
        return sharedBenefit;
    }


    /**
     * Sets the sharedBenefit value for this CombinedProductItem.
     * 
     * @param sharedBenefit
     */
    public void setSharedBenefit(java.lang.Boolean sharedBenefit) {
        this.sharedBenefit = sharedBenefit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CombinedProductItem)) return false;
        CombinedProductItem other = (CombinedProductItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.coverageConstraints==null && other.getCoverageConstraints()==null) || 
             (this.coverageConstraints!=null &&
              java.util.Arrays.equals(this.coverageConstraints, other.getCoverageConstraints()))) &&
            ((this.productItems==null && other.getProductItems()==null) || 
             (this.productItems!=null &&
              java.util.Arrays.equals(this.productItems, other.getProductItems()))) &&
            ((this.preCertificationRequired==null && other.getPreCertificationRequired()==null) || 
             (this.preCertificationRequired!=null &&
              this.preCertificationRequired.equals(other.getPreCertificationRequired()))) &&
            ((this.referralRequired==null && other.getReferralRequired()==null) || 
             (this.referralRequired!=null &&
              this.referralRequired.equals(other.getReferralRequired()))) &&
            ((this.sharedBenefit==null && other.getSharedBenefit()==null) || 
             (this.sharedBenefit!=null &&
              this.sharedBenefit.equals(other.getSharedBenefit())));
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
        if (getCoverageConstraints() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCoverageConstraints());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCoverageConstraints(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getPreCertificationRequired() != null) {
            _hashCode += getPreCertificationRequired().hashCode();
        }
        if (getReferralRequired() != null) {
            _hashCode += getReferralRequired().hashCode();
        }
        if (getSharedBenefit() != null) {
            _hashCode += getSharedBenefit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CombinedProductItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "CombinedProductItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageConstraints");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageConstraints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoverageConstraint"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItem"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preCertificationRequired");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preCertificationRequired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referralRequired");
        elemField.setXmlName(new javax.xml.namespace.QName("", "referralRequired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sharedBenefit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sharedBenefit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
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

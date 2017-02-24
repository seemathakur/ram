/**
 * ProductItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class ProductItem  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.inventory.dto.v001.InventoryKey inventoryKey;

    private com.vsp.xl.dto.v002.SimpleCode descriptor;

    private com.vsp.bl.product.dto.coverage.v002.ContributionSource[] contributionSources;

    private com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint[] coverageConstraints;

    private com.vsp.bl.product.dto.coverage.v001.DiscountConstraint[] discountConstraints;

    private com.vsp.bl.product.dto.v002.EligibilityRequirement eligibilityRequirement;

    private java.lang.Boolean referralRequired;

    private com.vsp.bl.product.dto.coverage.v001.ProductItemRefinement refinement;

    private com.vsp.bl.product.dto.coverage.v002.ProductItemAuthorization productItemAuthorization;

    private com.vsp.bl.product.dto.coverage.v002.PatientService patientService;

    public ProductItem() {
    }

    public ProductItem(
           com.vsp.bl.inventory.dto.v001.InventoryKey inventoryKey,
           com.vsp.xl.dto.v002.SimpleCode descriptor,
           com.vsp.bl.product.dto.coverage.v002.ContributionSource[] contributionSources,
           com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint[] coverageConstraints,
           com.vsp.bl.product.dto.coverage.v001.DiscountConstraint[] discountConstraints,
           com.vsp.bl.product.dto.v002.EligibilityRequirement eligibilityRequirement,
           java.lang.Boolean referralRequired,
           com.vsp.bl.product.dto.coverage.v001.ProductItemRefinement refinement,
           com.vsp.bl.product.dto.coverage.v002.ProductItemAuthorization productItemAuthorization,
           com.vsp.bl.product.dto.coverage.v002.PatientService patientService) {
        this.inventoryKey = inventoryKey;
        this.descriptor = descriptor;
        this.contributionSources = contributionSources;
        this.coverageConstraints = coverageConstraints;
        this.discountConstraints = discountConstraints;
        this.eligibilityRequirement = eligibilityRequirement;
        this.referralRequired = referralRequired;
        this.refinement = refinement;
        this.productItemAuthorization = productItemAuthorization;
        this.patientService = patientService;
    }


    /**
     * Gets the inventoryKey value for this ProductItem.
     * 
     * @return inventoryKey
     */
    public com.vsp.bl.inventory.dto.v001.InventoryKey getInventoryKey() {
        return inventoryKey;
    }


    /**
     * Sets the inventoryKey value for this ProductItem.
     * 
     * @param inventoryKey
     */
    public void setInventoryKey(com.vsp.bl.inventory.dto.v001.InventoryKey inventoryKey) {
        this.inventoryKey = inventoryKey;
    }


    /**
     * Gets the descriptor value for this ProductItem.
     * 
     * @return descriptor
     */
    public com.vsp.xl.dto.v002.SimpleCode getDescriptor() {
        return descriptor;
    }


    /**
     * Sets the descriptor value for this ProductItem.
     * 
     * @param descriptor
     */
    public void setDescriptor(com.vsp.xl.dto.v002.SimpleCode descriptor) {
        this.descriptor = descriptor;
    }


    /**
     * Gets the contributionSources value for this ProductItem.
     * 
     * @return contributionSources
     */
    public com.vsp.bl.product.dto.coverage.v002.ContributionSource[] getContributionSources() {
        return contributionSources;
    }


    /**
     * Sets the contributionSources value for this ProductItem.
     * 
     * @param contributionSources
     */
    public void setContributionSources(com.vsp.bl.product.dto.coverage.v002.ContributionSource[] contributionSources) {
        this.contributionSources = contributionSources;
    }


    /**
     * Gets the coverageConstraints value for this ProductItem.
     * 
     * @return coverageConstraints
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint[] getCoverageConstraints() {
        return coverageConstraints;
    }


    /**
     * Sets the coverageConstraints value for this ProductItem.
     * 
     * @param coverageConstraints
     */
    public void setCoverageConstraints(com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint[] coverageConstraints) {
        this.coverageConstraints = coverageConstraints;
    }


    /**
     * Gets the discountConstraints value for this ProductItem.
     * 
     * @return discountConstraints
     */
    public com.vsp.bl.product.dto.coverage.v001.DiscountConstraint[] getDiscountConstraints() {
        return discountConstraints;
    }


    /**
     * Sets the discountConstraints value for this ProductItem.
     * 
     * @param discountConstraints
     */
    public void setDiscountConstraints(com.vsp.bl.product.dto.coverage.v001.DiscountConstraint[] discountConstraints) {
        this.discountConstraints = discountConstraints;
    }


    /**
     * Gets the eligibilityRequirement value for this ProductItem.
     * 
     * @return eligibilityRequirement
     */
    public com.vsp.bl.product.dto.v002.EligibilityRequirement getEligibilityRequirement() {
        return eligibilityRequirement;
    }


    /**
     * Sets the eligibilityRequirement value for this ProductItem.
     * 
     * @param eligibilityRequirement
     */
    public void setEligibilityRequirement(com.vsp.bl.product.dto.v002.EligibilityRequirement eligibilityRequirement) {
        this.eligibilityRequirement = eligibilityRequirement;
    }


    /**
     * Gets the referralRequired value for this ProductItem.
     * 
     * @return referralRequired
     */
    public java.lang.Boolean getReferralRequired() {
        return referralRequired;
    }


    /**
     * Sets the referralRequired value for this ProductItem.
     * 
     * @param referralRequired
     */
    public void setReferralRequired(java.lang.Boolean referralRequired) {
        this.referralRequired = referralRequired;
    }


    /**
     * Gets the refinement value for this ProductItem.
     * 
     * @return refinement
     */
    public com.vsp.bl.product.dto.coverage.v001.ProductItemRefinement getRefinement() {
        return refinement;
    }


    /**
     * Sets the refinement value for this ProductItem.
     * 
     * @param refinement
     */
    public void setRefinement(com.vsp.bl.product.dto.coverage.v001.ProductItemRefinement refinement) {
        this.refinement = refinement;
    }


    /**
     * Gets the productItemAuthorization value for this ProductItem.
     * 
     * @return productItemAuthorization
     */
    public com.vsp.bl.product.dto.coverage.v002.ProductItemAuthorization getProductItemAuthorization() {
        return productItemAuthorization;
    }


    /**
     * Sets the productItemAuthorization value for this ProductItem.
     * 
     * @param productItemAuthorization
     */
    public void setProductItemAuthorization(com.vsp.bl.product.dto.coverage.v002.ProductItemAuthorization productItemAuthorization) {
        this.productItemAuthorization = productItemAuthorization;
    }


    /**
     * Gets the patientService value for this ProductItem.
     * 
     * @return patientService
     */
    public com.vsp.bl.product.dto.coverage.v002.PatientService getPatientService() {
        return patientService;
    }


    /**
     * Sets the patientService value for this ProductItem.
     * 
     * @param patientService
     */
    public void setPatientService(com.vsp.bl.product.dto.coverage.v002.PatientService patientService) {
        this.patientService = patientService;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductItem)) return false;
        ProductItem other = (ProductItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.inventoryKey==null && other.getInventoryKey()==null) || 
             (this.inventoryKey!=null &&
              this.inventoryKey.equals(other.getInventoryKey()))) &&
            ((this.descriptor==null && other.getDescriptor()==null) || 
             (this.descriptor!=null &&
              this.descriptor.equals(other.getDescriptor()))) &&
            ((this.contributionSources==null && other.getContributionSources()==null) || 
             (this.contributionSources!=null &&
              java.util.Arrays.equals(this.contributionSources, other.getContributionSources()))) &&
            ((this.coverageConstraints==null && other.getCoverageConstraints()==null) || 
             (this.coverageConstraints!=null &&
              java.util.Arrays.equals(this.coverageConstraints, other.getCoverageConstraints()))) &&
            ((this.discountConstraints==null && other.getDiscountConstraints()==null) || 
             (this.discountConstraints!=null &&
              java.util.Arrays.equals(this.discountConstraints, other.getDiscountConstraints()))) &&
            ((this.eligibilityRequirement==null && other.getEligibilityRequirement()==null) || 
             (this.eligibilityRequirement!=null &&
              this.eligibilityRequirement.equals(other.getEligibilityRequirement()))) &&
            ((this.referralRequired==null && other.getReferralRequired()==null) || 
             (this.referralRequired!=null &&
              this.referralRequired.equals(other.getReferralRequired()))) &&
            ((this.refinement==null && other.getRefinement()==null) || 
             (this.refinement!=null &&
              this.refinement.equals(other.getRefinement()))) &&
            ((this.productItemAuthorization==null && other.getProductItemAuthorization()==null) || 
             (this.productItemAuthorization!=null &&
              this.productItemAuthorization.equals(other.getProductItemAuthorization()))) &&
            ((this.patientService==null && other.getPatientService()==null) || 
             (this.patientService!=null &&
              this.patientService.equals(other.getPatientService())));
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
        if (getInventoryKey() != null) {
            _hashCode += getInventoryKey().hashCode();
        }
        if (getDescriptor() != null) {
            _hashCode += getDescriptor().hashCode();
        }
        if (getContributionSources() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContributionSources());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContributionSources(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        if (getDiscountConstraints() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDiscountConstraints());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDiscountConstraints(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEligibilityRequirement() != null) {
            _hashCode += getEligibilityRequirement().hashCode();
        }
        if (getReferralRequired() != null) {
            _hashCode += getReferralRequired().hashCode();
        }
        if (getRefinement() != null) {
            _hashCode += getRefinement().hashCode();
        }
        if (getProductItemAuthorization() != null) {
            _hashCode += getProductItemAuthorization().hashCode();
        }
        if (getPatientService() != null) {
            _hashCode += getPatientService().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventoryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inventoryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.dto.inventory.bl.vsp.com", "InventoryKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descriptor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descriptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contributionSources");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contributionSources"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ContributionSource"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coverageConstraints");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coverageConstraints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoverageConstraint"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("discountConstraints");
        elemField.setXmlName(new javax.xml.namespace.QName("", "discountConstraints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "DiscountConstraint"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eligibilityRequirement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eligibilityRequirement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "EligibilityRequirement"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referralRequired");
        elemField.setXmlName(new javax.xml.namespace.QName("", "referralRequired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refinement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "refinement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "ProductItemRefinement"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productItemAuthorization");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productItemAuthorization"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItemAuthorization"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientService");
        elemField.setXmlName(new javax.xml.namespace.QName("", "patientService"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PatientService"));
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

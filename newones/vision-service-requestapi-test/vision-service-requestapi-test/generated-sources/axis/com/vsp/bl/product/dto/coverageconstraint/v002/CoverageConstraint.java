/**
 * CoverageConstraint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverageconstraint.v002;

public class CoverageConstraint  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.product.dto.coverageconstraint.v002.CoPay coPay;

    private com.vsp.bl.product.dto.coverageconstraint.v002.CostControlled costControlled;

    private com.vsp.bl.product.dto.coverage.v002.Discount discount;

    private com.vsp.bl.product.dto.coverageconstraint.v001.UnitCoverage unitCoverage;

    private com.vsp.bl.product.dto.coverage.v002.Condition[] conditions;

    private com.vsp.bl.product.dto.coverage.v001.Frequency frequency;

    private com.vsp.bl.product.dto.levelofcoverage.v002.LevelOfCoverage levelOfCoverage;

    private com.vsp.bl.product.dto.coverageconstraint.v002.PatientHistoryConstraint[] patientHistoryConstraints;

    private com.vsp.bl.product.dto.coverageconstraint.v002.ConstraintType[] constraintType;

    private com.vsp.bl.product.dto.coverageconstraint.v002.Deductible deductible;

    private com.vsp.bl.product.dto.v002.ProductItemIncludeExclude[] includeExcludes;

    private com.vsp.xl.dto.v003.CurrencyValue amount;

    private java.lang.Float conversionFactor;

    private com.vsp.xl.dto.v002.SimpleCode locType;

    private com.vsp.bl.product.dto.coverageconstraint.v002.OutOfPocketMax outOfPocketMax;

    private com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint overageDeniesCoverage;

    private java.lang.Float percentCovered;

    private com.vsp.bl.network.dto.v002.NetworkKey labNetwork;

    private com.vsp.bl.network.dto.v002.NetworkKey providerNetwork;

    private com.vsp.bl.product.dto.coverageconstraint.v002.InventoryInLieuOf inventoryInLieuOf;

    private java.lang.Boolean preCertificationRequired;

    public CoverageConstraint() {
    }

    public CoverageConstraint(
           com.vsp.bl.product.dto.coverageconstraint.v002.CoPay coPay,
           com.vsp.bl.product.dto.coverageconstraint.v002.CostControlled costControlled,
           com.vsp.bl.product.dto.coverage.v002.Discount discount,
           com.vsp.bl.product.dto.coverageconstraint.v001.UnitCoverage unitCoverage,
           com.vsp.bl.product.dto.coverage.v002.Condition[] conditions,
           com.vsp.bl.product.dto.coverage.v001.Frequency frequency,
           com.vsp.bl.product.dto.levelofcoverage.v002.LevelOfCoverage levelOfCoverage,
           com.vsp.bl.product.dto.coverageconstraint.v002.PatientHistoryConstraint[] patientHistoryConstraints,
           com.vsp.bl.product.dto.coverageconstraint.v002.ConstraintType[] constraintType,
           com.vsp.bl.product.dto.coverageconstraint.v002.Deductible deductible,
           com.vsp.bl.product.dto.v002.ProductItemIncludeExclude[] includeExcludes,
           com.vsp.xl.dto.v003.CurrencyValue amount,
           java.lang.Float conversionFactor,
           com.vsp.xl.dto.v002.SimpleCode locType,
           com.vsp.bl.product.dto.coverageconstraint.v002.OutOfPocketMax outOfPocketMax,
           com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint overageDeniesCoverage,
           java.lang.Float percentCovered,
           com.vsp.bl.network.dto.v002.NetworkKey labNetwork,
           com.vsp.bl.network.dto.v002.NetworkKey providerNetwork,
           com.vsp.bl.product.dto.coverageconstraint.v002.InventoryInLieuOf inventoryInLieuOf,
           java.lang.Boolean preCertificationRequired) {
        this.coPay = coPay;
        this.costControlled = costControlled;
        this.discount = discount;
        this.unitCoverage = unitCoverage;
        this.conditions = conditions;
        this.frequency = frequency;
        this.levelOfCoverage = levelOfCoverage;
        this.patientHistoryConstraints = patientHistoryConstraints;
        this.constraintType = constraintType;
        this.deductible = deductible;
        this.includeExcludes = includeExcludes;
        this.amount = amount;
        this.conversionFactor = conversionFactor;
        this.locType = locType;
        this.outOfPocketMax = outOfPocketMax;
        this.overageDeniesCoverage = overageDeniesCoverage;
        this.percentCovered = percentCovered;
        this.labNetwork = labNetwork;
        this.providerNetwork = providerNetwork;
        this.inventoryInLieuOf = inventoryInLieuOf;
        this.preCertificationRequired = preCertificationRequired;
    }


    /**
     * Gets the coPay value for this CoverageConstraint.
     * 
     * @return coPay
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.CoPay getCoPay() {
        return coPay;
    }


    /**
     * Sets the coPay value for this CoverageConstraint.
     * 
     * @param coPay
     */
    public void setCoPay(com.vsp.bl.product.dto.coverageconstraint.v002.CoPay coPay) {
        this.coPay = coPay;
    }


    /**
     * Gets the costControlled value for this CoverageConstraint.
     * 
     * @return costControlled
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.CostControlled getCostControlled() {
        return costControlled;
    }


    /**
     * Sets the costControlled value for this CoverageConstraint.
     * 
     * @param costControlled
     */
    public void setCostControlled(com.vsp.bl.product.dto.coverageconstraint.v002.CostControlled costControlled) {
        this.costControlled = costControlled;
    }


    /**
     * Gets the discount value for this CoverageConstraint.
     * 
     * @return discount
     */
    public com.vsp.bl.product.dto.coverage.v002.Discount getDiscount() {
        return discount;
    }


    /**
     * Sets the discount value for this CoverageConstraint.
     * 
     * @param discount
     */
    public void setDiscount(com.vsp.bl.product.dto.coverage.v002.Discount discount) {
        this.discount = discount;
    }


    /**
     * Gets the unitCoverage value for this CoverageConstraint.
     * 
     * @return unitCoverage
     */
    public com.vsp.bl.product.dto.coverageconstraint.v001.UnitCoverage getUnitCoverage() {
        return unitCoverage;
    }


    /**
     * Sets the unitCoverage value for this CoverageConstraint.
     * 
     * @param unitCoverage
     */
    public void setUnitCoverage(com.vsp.bl.product.dto.coverageconstraint.v001.UnitCoverage unitCoverage) {
        this.unitCoverage = unitCoverage;
    }


    /**
     * Gets the conditions value for this CoverageConstraint.
     * 
     * @return conditions
     */
    public com.vsp.bl.product.dto.coverage.v002.Condition[] getConditions() {
        return conditions;
    }


    /**
     * Sets the conditions value for this CoverageConstraint.
     * 
     * @param conditions
     */
    public void setConditions(com.vsp.bl.product.dto.coverage.v002.Condition[] conditions) {
        this.conditions = conditions;
    }


    /**
     * Gets the frequency value for this CoverageConstraint.
     * 
     * @return frequency
     */
    public com.vsp.bl.product.dto.coverage.v001.Frequency getFrequency() {
        return frequency;
    }


    /**
     * Sets the frequency value for this CoverageConstraint.
     * 
     * @param frequency
     */
    public void setFrequency(com.vsp.bl.product.dto.coverage.v001.Frequency frequency) {
        this.frequency = frequency;
    }


    /**
     * Gets the levelOfCoverage value for this CoverageConstraint.
     * 
     * @return levelOfCoverage
     */
    public com.vsp.bl.product.dto.levelofcoverage.v002.LevelOfCoverage getLevelOfCoverage() {
        return levelOfCoverage;
    }


    /**
     * Sets the levelOfCoverage value for this CoverageConstraint.
     * 
     * @param levelOfCoverage
     */
    public void setLevelOfCoverage(com.vsp.bl.product.dto.levelofcoverage.v002.LevelOfCoverage levelOfCoverage) {
        this.levelOfCoverage = levelOfCoverage;
    }


    /**
     * Gets the patientHistoryConstraints value for this CoverageConstraint.
     * 
     * @return patientHistoryConstraints
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.PatientHistoryConstraint[] getPatientHistoryConstraints() {
        return patientHistoryConstraints;
    }


    /**
     * Sets the patientHistoryConstraints value for this CoverageConstraint.
     * 
     * @param patientHistoryConstraints
     */
    public void setPatientHistoryConstraints(com.vsp.bl.product.dto.coverageconstraint.v002.PatientHistoryConstraint[] patientHistoryConstraints) {
        this.patientHistoryConstraints = patientHistoryConstraints;
    }


    /**
     * Gets the constraintType value for this CoverageConstraint.
     * 
     * @return constraintType
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.ConstraintType[] getConstraintType() {
        return constraintType;
    }


    /**
     * Sets the constraintType value for this CoverageConstraint.
     * 
     * @param constraintType
     */
    public void setConstraintType(com.vsp.bl.product.dto.coverageconstraint.v002.ConstraintType[] constraintType) {
        this.constraintType = constraintType;
    }


    /**
     * Gets the deductible value for this CoverageConstraint.
     * 
     * @return deductible
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.Deductible getDeductible() {
        return deductible;
    }


    /**
     * Sets the deductible value for this CoverageConstraint.
     * 
     * @param deductible
     */
    public void setDeductible(com.vsp.bl.product.dto.coverageconstraint.v002.Deductible deductible) {
        this.deductible = deductible;
    }


    /**
     * Gets the includeExcludes value for this CoverageConstraint.
     * 
     * @return includeExcludes
     */
    public com.vsp.bl.product.dto.v002.ProductItemIncludeExclude[] getIncludeExcludes() {
        return includeExcludes;
    }


    /**
     * Sets the includeExcludes value for this CoverageConstraint.
     * 
     * @param includeExcludes
     */
    public void setIncludeExcludes(com.vsp.bl.product.dto.v002.ProductItemIncludeExclude[] includeExcludes) {
        this.includeExcludes = includeExcludes;
    }


    /**
     * Gets the amount value for this CoverageConstraint.
     * 
     * @return amount
     */
    public com.vsp.xl.dto.v003.CurrencyValue getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this CoverageConstraint.
     * 
     * @param amount
     */
    public void setAmount(com.vsp.xl.dto.v003.CurrencyValue amount) {
        this.amount = amount;
    }


    /**
     * Gets the conversionFactor value for this CoverageConstraint.
     * 
     * @return conversionFactor
     */
    public java.lang.Float getConversionFactor() {
        return conversionFactor;
    }


    /**
     * Sets the conversionFactor value for this CoverageConstraint.
     * 
     * @param conversionFactor
     */
    public void setConversionFactor(java.lang.Float conversionFactor) {
        this.conversionFactor = conversionFactor;
    }


    /**
     * Gets the locType value for this CoverageConstraint.
     * 
     * @return locType
     */
    public com.vsp.xl.dto.v002.SimpleCode getLocType() {
        return locType;
    }


    /**
     * Sets the locType value for this CoverageConstraint.
     * 
     * @param locType
     */
    public void setLocType(com.vsp.xl.dto.v002.SimpleCode locType) {
        this.locType = locType;
    }


    /**
     * Gets the outOfPocketMax value for this CoverageConstraint.
     * 
     * @return outOfPocketMax
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.OutOfPocketMax getOutOfPocketMax() {
        return outOfPocketMax;
    }


    /**
     * Sets the outOfPocketMax value for this CoverageConstraint.
     * 
     * @param outOfPocketMax
     */
    public void setOutOfPocketMax(com.vsp.bl.product.dto.coverageconstraint.v002.OutOfPocketMax outOfPocketMax) {
        this.outOfPocketMax = outOfPocketMax;
    }


    /**
     * Gets the overageDeniesCoverage value for this CoverageConstraint.
     * 
     * @return overageDeniesCoverage
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint getOverageDeniesCoverage() {
        return overageDeniesCoverage;
    }


    /**
     * Sets the overageDeniesCoverage value for this CoverageConstraint.
     * 
     * @param overageDeniesCoverage
     */
    public void setOverageDeniesCoverage(com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint overageDeniesCoverage) {
        this.overageDeniesCoverage = overageDeniesCoverage;
    }


    /**
     * Gets the percentCovered value for this CoverageConstraint.
     * 
     * @return percentCovered
     */
    public java.lang.Float getPercentCovered() {
        return percentCovered;
    }


    /**
     * Sets the percentCovered value for this CoverageConstraint.
     * 
     * @param percentCovered
     */
    public void setPercentCovered(java.lang.Float percentCovered) {
        this.percentCovered = percentCovered;
    }


    /**
     * Gets the labNetwork value for this CoverageConstraint.
     * 
     * @return labNetwork
     */
    public com.vsp.bl.network.dto.v002.NetworkKey getLabNetwork() {
        return labNetwork;
    }


    /**
     * Sets the labNetwork value for this CoverageConstraint.
     * 
     * @param labNetwork
     */
    public void setLabNetwork(com.vsp.bl.network.dto.v002.NetworkKey labNetwork) {
        this.labNetwork = labNetwork;
    }


    /**
     * Gets the providerNetwork value for this CoverageConstraint.
     * 
     * @return providerNetwork
     */
    public com.vsp.bl.network.dto.v002.NetworkKey getProviderNetwork() {
        return providerNetwork;
    }


    /**
     * Sets the providerNetwork value for this CoverageConstraint.
     * 
     * @param providerNetwork
     */
    public void setProviderNetwork(com.vsp.bl.network.dto.v002.NetworkKey providerNetwork) {
        this.providerNetwork = providerNetwork;
    }


    /**
     * Gets the inventoryInLieuOf value for this CoverageConstraint.
     * 
     * @return inventoryInLieuOf
     */
    public com.vsp.bl.product.dto.coverageconstraint.v002.InventoryInLieuOf getInventoryInLieuOf() {
        return inventoryInLieuOf;
    }


    /**
     * Sets the inventoryInLieuOf value for this CoverageConstraint.
     * 
     * @param inventoryInLieuOf
     */
    public void setInventoryInLieuOf(com.vsp.bl.product.dto.coverageconstraint.v002.InventoryInLieuOf inventoryInLieuOf) {
        this.inventoryInLieuOf = inventoryInLieuOf;
    }


    /**
     * Gets the preCertificationRequired value for this CoverageConstraint.
     * 
     * @return preCertificationRequired
     */
    public java.lang.Boolean getPreCertificationRequired() {
        return preCertificationRequired;
    }


    /**
     * Sets the preCertificationRequired value for this CoverageConstraint.
     * 
     * @param preCertificationRequired
     */
    public void setPreCertificationRequired(java.lang.Boolean preCertificationRequired) {
        this.preCertificationRequired = preCertificationRequired;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CoverageConstraint)) return false;
        CoverageConstraint other = (CoverageConstraint) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.coPay==null && other.getCoPay()==null) || 
             (this.coPay!=null &&
              this.coPay.equals(other.getCoPay()))) &&
            ((this.costControlled==null && other.getCostControlled()==null) || 
             (this.costControlled!=null &&
              this.costControlled.equals(other.getCostControlled()))) &&
            ((this.discount==null && other.getDiscount()==null) || 
             (this.discount!=null &&
              this.discount.equals(other.getDiscount()))) &&
            ((this.unitCoverage==null && other.getUnitCoverage()==null) || 
             (this.unitCoverage!=null &&
              this.unitCoverage.equals(other.getUnitCoverage()))) &&
            ((this.conditions==null && other.getConditions()==null) || 
             (this.conditions!=null &&
              java.util.Arrays.equals(this.conditions, other.getConditions()))) &&
            ((this.frequency==null && other.getFrequency()==null) || 
             (this.frequency!=null &&
              this.frequency.equals(other.getFrequency()))) &&
            ((this.levelOfCoverage==null && other.getLevelOfCoverage()==null) || 
             (this.levelOfCoverage!=null &&
              this.levelOfCoverage.equals(other.getLevelOfCoverage()))) &&
            ((this.patientHistoryConstraints==null && other.getPatientHistoryConstraints()==null) || 
             (this.patientHistoryConstraints!=null &&
              java.util.Arrays.equals(this.patientHistoryConstraints, other.getPatientHistoryConstraints()))) &&
            ((this.constraintType==null && other.getConstraintType()==null) || 
             (this.constraintType!=null &&
              java.util.Arrays.equals(this.constraintType, other.getConstraintType()))) &&
            ((this.deductible==null && other.getDeductible()==null) || 
             (this.deductible!=null &&
              this.deductible.equals(other.getDeductible()))) &&
            ((this.includeExcludes==null && other.getIncludeExcludes()==null) || 
             (this.includeExcludes!=null &&
              java.util.Arrays.equals(this.includeExcludes, other.getIncludeExcludes()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.conversionFactor==null && other.getConversionFactor()==null) || 
             (this.conversionFactor!=null &&
              this.conversionFactor.equals(other.getConversionFactor()))) &&
            ((this.locType==null && other.getLocType()==null) || 
             (this.locType!=null &&
              this.locType.equals(other.getLocType()))) &&
            ((this.outOfPocketMax==null && other.getOutOfPocketMax()==null) || 
             (this.outOfPocketMax!=null &&
              this.outOfPocketMax.equals(other.getOutOfPocketMax()))) &&
            ((this.overageDeniesCoverage==null && other.getOverageDeniesCoverage()==null) || 
             (this.overageDeniesCoverage!=null &&
              this.overageDeniesCoverage.equals(other.getOverageDeniesCoverage()))) &&
            ((this.percentCovered==null && other.getPercentCovered()==null) || 
             (this.percentCovered!=null &&
              this.percentCovered.equals(other.getPercentCovered()))) &&
            ((this.labNetwork==null && other.getLabNetwork()==null) || 
             (this.labNetwork!=null &&
              this.labNetwork.equals(other.getLabNetwork()))) &&
            ((this.providerNetwork==null && other.getProviderNetwork()==null) || 
             (this.providerNetwork!=null &&
              this.providerNetwork.equals(other.getProviderNetwork()))) &&
            ((this.inventoryInLieuOf==null && other.getInventoryInLieuOf()==null) || 
             (this.inventoryInLieuOf!=null &&
              this.inventoryInLieuOf.equals(other.getInventoryInLieuOf()))) &&
            ((this.preCertificationRequired==null && other.getPreCertificationRequired()==null) || 
             (this.preCertificationRequired!=null &&
              this.preCertificationRequired.equals(other.getPreCertificationRequired())));
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
        if (getCoPay() != null) {
            _hashCode += getCoPay().hashCode();
        }
        if (getCostControlled() != null) {
            _hashCode += getCostControlled().hashCode();
        }
        if (getDiscount() != null) {
            _hashCode += getDiscount().hashCode();
        }
        if (getUnitCoverage() != null) {
            _hashCode += getUnitCoverage().hashCode();
        }
        if (getConditions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConditions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConditions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFrequency() != null) {
            _hashCode += getFrequency().hashCode();
        }
        if (getLevelOfCoverage() != null) {
            _hashCode += getLevelOfCoverage().hashCode();
        }
        if (getPatientHistoryConstraints() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPatientHistoryConstraints());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPatientHistoryConstraints(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConstraintType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConstraintType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConstraintType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeductible() != null) {
            _hashCode += getDeductible().hashCode();
        }
        if (getIncludeExcludes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIncludeExcludes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIncludeExcludes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getConversionFactor() != null) {
            _hashCode += getConversionFactor().hashCode();
        }
        if (getLocType() != null) {
            _hashCode += getLocType().hashCode();
        }
        if (getOutOfPocketMax() != null) {
            _hashCode += getOutOfPocketMax().hashCode();
        }
        if (getOverageDeniesCoverage() != null) {
            _hashCode += getOverageDeniesCoverage().hashCode();
        }
        if (getPercentCovered() != null) {
            _hashCode += getPercentCovered().hashCode();
        }
        if (getLabNetwork() != null) {
            _hashCode += getLabNetwork().hashCode();
        }
        if (getProviderNetwork() != null) {
            _hashCode += getProviderNetwork().hashCode();
        }
        if (getInventoryInLieuOf() != null) {
            _hashCode += getInventoryInLieuOf().hashCode();
        }
        if (getPreCertificationRequired() != null) {
            _hashCode += getPreCertificationRequired().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CoverageConstraint.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoverageConstraint"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coPay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coPay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoPay"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costControlled");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costControlled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CostControlled"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("discount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "discount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "Discount"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitCoverage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unitCoverage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverageconstraint.dto.product.bl.vsp.com", "UnitCoverage"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conditions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conditions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "Condition"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "Frequency"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("levelOfCoverage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "levelOfCoverage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.levelofcoverage.dto.product.bl.vsp.com", "LevelOfCoverage"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patientHistoryConstraints");
        elemField.setXmlName(new javax.xml.namespace.QName("", "patientHistoryConstraints"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "PatientHistoryConstraint"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("constraintType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "constraintType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ConstraintType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deductible");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deductible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "Deductible"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeExcludes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "includeExcludes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductItemIncludeExclude"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conversionFactor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "conversionFactor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "locType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outOfPocketMax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "outOfPocketMax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "OutOfPocketMax"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overageDeniesCoverage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overageDeniesCoverage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoverageConstraint"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percentCovered");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percentCovered"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("labNetwork");
        elemField.setXmlName(new javax.xml.namespace.QName("", "labNetwork"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.network.bl.vsp.com", "NetworkKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("providerNetwork");
        elemField.setXmlName(new javax.xml.namespace.QName("", "providerNetwork"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.network.bl.vsp.com", "NetworkKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventoryInLieuOf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inventoryInLieuOf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "InventoryInLieuOf"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preCertificationRequired");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preCertificationRequired"));
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

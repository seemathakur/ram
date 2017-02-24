/**
 * CompositeRate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.rate.v002;

public class CompositeRate  implements java.io.Serializable {
    private com.vsp.xl.dto.v003.CurrencyValue employeeOnlyRate;

    private com.vsp.xl.dto.v003.CurrencyValue employeePlusChildrenRate;

    private com.vsp.xl.dto.v003.CurrencyValue employeePlusFamilyRate;

    private com.vsp.xl.dto.v003.CurrencyValue employeePlusOneRate;

    private com.vsp.xl.dto.v002.SimpleCode tierType;

    private com.vsp.xl.dto.v003.CurrencyValue compositeRate;

    private com.vsp.xl.dto.v002.SimpleCode contractType;

    private com.vsp.bl.product.dto.rate.v002.RateDiscount[] rateDiscounts;

    private com.vsp.bl.product.dto.rate.v002.ASP asp;

    public CompositeRate() {
    }

    public CompositeRate(
           com.vsp.xl.dto.v003.CurrencyValue employeeOnlyRate,
           com.vsp.xl.dto.v003.CurrencyValue employeePlusChildrenRate,
           com.vsp.xl.dto.v003.CurrencyValue employeePlusFamilyRate,
           com.vsp.xl.dto.v003.CurrencyValue employeePlusOneRate,
           com.vsp.xl.dto.v002.SimpleCode tierType,
           com.vsp.xl.dto.v003.CurrencyValue compositeRate,
           com.vsp.xl.dto.v002.SimpleCode contractType,
           com.vsp.bl.product.dto.rate.v002.RateDiscount[] rateDiscounts,
           com.vsp.bl.product.dto.rate.v002.ASP asp) {
           this.employeeOnlyRate = employeeOnlyRate;
           this.employeePlusChildrenRate = employeePlusChildrenRate;
           this.employeePlusFamilyRate = employeePlusFamilyRate;
           this.employeePlusOneRate = employeePlusOneRate;
           this.tierType = tierType;
           this.compositeRate = compositeRate;
           this.contractType = contractType;
           this.rateDiscounts = rateDiscounts;
           this.asp = asp;
    }


    /**
     * Gets the employeeOnlyRate value for this CompositeRate.
     * 
     * @return employeeOnlyRate
     */
    public com.vsp.xl.dto.v003.CurrencyValue getEmployeeOnlyRate() {
        return employeeOnlyRate;
    }


    /**
     * Sets the employeeOnlyRate value for this CompositeRate.
     * 
     * @param employeeOnlyRate
     */
    public void setEmployeeOnlyRate(com.vsp.xl.dto.v003.CurrencyValue employeeOnlyRate) {
        this.employeeOnlyRate = employeeOnlyRate;
    }


    /**
     * Gets the employeePlusChildrenRate value for this CompositeRate.
     * 
     * @return employeePlusChildrenRate
     */
    public com.vsp.xl.dto.v003.CurrencyValue getEmployeePlusChildrenRate() {
        return employeePlusChildrenRate;
    }


    /**
     * Sets the employeePlusChildrenRate value for this CompositeRate.
     * 
     * @param employeePlusChildrenRate
     */
    public void setEmployeePlusChildrenRate(com.vsp.xl.dto.v003.CurrencyValue employeePlusChildrenRate) {
        this.employeePlusChildrenRate = employeePlusChildrenRate;
    }


    /**
     * Gets the employeePlusFamilyRate value for this CompositeRate.
     * 
     * @return employeePlusFamilyRate
     */
    public com.vsp.xl.dto.v003.CurrencyValue getEmployeePlusFamilyRate() {
        return employeePlusFamilyRate;
    }


    /**
     * Sets the employeePlusFamilyRate value for this CompositeRate.
     * 
     * @param employeePlusFamilyRate
     */
    public void setEmployeePlusFamilyRate(com.vsp.xl.dto.v003.CurrencyValue employeePlusFamilyRate) {
        this.employeePlusFamilyRate = employeePlusFamilyRate;
    }


    /**
     * Gets the employeePlusOneRate value for this CompositeRate.
     * 
     * @return employeePlusOneRate
     */
    public com.vsp.xl.dto.v003.CurrencyValue getEmployeePlusOneRate() {
        return employeePlusOneRate;
    }


    /**
     * Sets the employeePlusOneRate value for this CompositeRate.
     * 
     * @param employeePlusOneRate
     */
    public void setEmployeePlusOneRate(com.vsp.xl.dto.v003.CurrencyValue employeePlusOneRate) {
        this.employeePlusOneRate = employeePlusOneRate;
    }


    /**
     * Gets the tierType value for this CompositeRate.
     * 
     * @return tierType
     */
    public com.vsp.xl.dto.v002.SimpleCode getTierType() {
        return tierType;
    }


    /**
     * Sets the tierType value for this CompositeRate.
     * 
     * @param tierType
     */
    public void setTierType(com.vsp.xl.dto.v002.SimpleCode tierType) {
        this.tierType = tierType;
    }


    /**
     * Gets the compositeRate value for this CompositeRate.
     * 
     * @return compositeRate
     */
    public com.vsp.xl.dto.v003.CurrencyValue getCompositeRate() {
        return compositeRate;
    }


    /**
     * Sets the compositeRate value for this CompositeRate.
     * 
     * @param compositeRate
     */
    public void setCompositeRate(com.vsp.xl.dto.v003.CurrencyValue compositeRate) {
        this.compositeRate = compositeRate;
    }


    /**
     * Gets the contractType value for this CompositeRate.
     * 
     * @return contractType
     */
    public com.vsp.xl.dto.v002.SimpleCode getContractType() {
        return contractType;
    }


    /**
     * Sets the contractType value for this CompositeRate.
     * 
     * @param contractType
     */
    public void setContractType(com.vsp.xl.dto.v002.SimpleCode contractType) {
        this.contractType = contractType;
    }


    /**
     * Gets the rateDiscounts value for this CompositeRate.
     * 
     * @return rateDiscounts
     */
    public com.vsp.bl.product.dto.rate.v002.RateDiscount[] getRateDiscounts() {
        return rateDiscounts;
    }


    /**
     * Sets the rateDiscounts value for this CompositeRate.
     * 
     * @param rateDiscounts
     */
    public void setRateDiscounts(com.vsp.bl.product.dto.rate.v002.RateDiscount[] rateDiscounts) {
        this.rateDiscounts = rateDiscounts;
    }


    /**
     * Gets the asp value for this CompositeRate.
     * 
     * @return asp
     */
    public com.vsp.bl.product.dto.rate.v002.ASP getAsp() {
        return asp;
    }


    /**
     * Sets the asp value for this CompositeRate.
     * 
     * @param asp
     */
    public void setAsp(com.vsp.bl.product.dto.rate.v002.ASP asp) {
        this.asp = asp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CompositeRate)) return false;
        CompositeRate other = (CompositeRate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.employeeOnlyRate==null && other.getEmployeeOnlyRate()==null) || 
             (this.employeeOnlyRate!=null &&
              this.employeeOnlyRate.equals(other.getEmployeeOnlyRate()))) &&
            ((this.employeePlusChildrenRate==null && other.getEmployeePlusChildrenRate()==null) || 
             (this.employeePlusChildrenRate!=null &&
              this.employeePlusChildrenRate.equals(other.getEmployeePlusChildrenRate()))) &&
            ((this.employeePlusFamilyRate==null && other.getEmployeePlusFamilyRate()==null) || 
             (this.employeePlusFamilyRate!=null &&
              this.employeePlusFamilyRate.equals(other.getEmployeePlusFamilyRate()))) &&
            ((this.employeePlusOneRate==null && other.getEmployeePlusOneRate()==null) || 
             (this.employeePlusOneRate!=null &&
              this.employeePlusOneRate.equals(other.getEmployeePlusOneRate()))) &&
            ((this.tierType==null && other.getTierType()==null) || 
             (this.tierType!=null &&
              this.tierType.equals(other.getTierType()))) &&
            ((this.compositeRate==null && other.getCompositeRate()==null) || 
             (this.compositeRate!=null &&
              this.compositeRate.equals(other.getCompositeRate()))) &&
            ((this.contractType==null && other.getContractType()==null) || 
             (this.contractType!=null &&
              this.contractType.equals(other.getContractType()))) &&
            ((this.rateDiscounts==null && other.getRateDiscounts()==null) || 
             (this.rateDiscounts!=null &&
              java.util.Arrays.equals(this.rateDiscounts, other.getRateDiscounts()))) &&
            ((this.asp==null && other.getAsp()==null) || 
             (this.asp!=null &&
              this.asp.equals(other.getAsp())));
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
        if (getEmployeeOnlyRate() != null) {
            _hashCode += getEmployeeOnlyRate().hashCode();
        }
        if (getEmployeePlusChildrenRate() != null) {
            _hashCode += getEmployeePlusChildrenRate().hashCode();
        }
        if (getEmployeePlusFamilyRate() != null) {
            _hashCode += getEmployeePlusFamilyRate().hashCode();
        }
        if (getEmployeePlusOneRate() != null) {
            _hashCode += getEmployeePlusOneRate().hashCode();
        }
        if (getTierType() != null) {
            _hashCode += getTierType().hashCode();
        }
        if (getCompositeRate() != null) {
            _hashCode += getCompositeRate().hashCode();
        }
        if (getContractType() != null) {
            _hashCode += getContractType().hashCode();
        }
        if (getRateDiscounts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRateDiscounts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRateDiscounts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAsp() != null) {
            _hashCode += getAsp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CompositeRate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "CompositeRate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeOnlyRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeeOnlyRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeePlusChildrenRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeePlusChildrenRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeePlusFamilyRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeePlusFamilyRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeePlusOneRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeePlusOneRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tierType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tierType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compositeRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "compositeRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contractType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contractType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rateDiscounts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rateDiscounts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "RateDiscount"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "asp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "ASP"));
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

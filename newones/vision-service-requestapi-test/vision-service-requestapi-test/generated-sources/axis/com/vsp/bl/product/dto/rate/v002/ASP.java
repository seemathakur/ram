/**
 * ASP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.rate.v002;

public class ASP  implements java.io.Serializable {
    private com.vsp.xl.dto.v003.CurrencyValue employeeOnlyClaimCostRate;

    private com.vsp.xl.dto.v003.CurrencyValue employeePlusChildrenClaimCostRate;

    private com.vsp.xl.dto.v003.CurrencyValue employeePlusFamilyClaimCostRate;

    private com.vsp.xl.dto.v003.CurrencyValue employeePlusOneClaimCostRate;

    private com.vsp.xl.dto.v003.CurrencyValue claimCostAmount;

    public ASP() {
    }

    public ASP(
           com.vsp.xl.dto.v003.CurrencyValue employeeOnlyClaimCostRate,
           com.vsp.xl.dto.v003.CurrencyValue employeePlusChildrenClaimCostRate,
           com.vsp.xl.dto.v003.CurrencyValue employeePlusFamilyClaimCostRate,
           com.vsp.xl.dto.v003.CurrencyValue employeePlusOneClaimCostRate,
           com.vsp.xl.dto.v003.CurrencyValue claimCostAmount) {
           this.employeeOnlyClaimCostRate = employeeOnlyClaimCostRate;
           this.employeePlusChildrenClaimCostRate = employeePlusChildrenClaimCostRate;
           this.employeePlusFamilyClaimCostRate = employeePlusFamilyClaimCostRate;
           this.employeePlusOneClaimCostRate = employeePlusOneClaimCostRate;
           this.claimCostAmount = claimCostAmount;
    }


    /**
     * Gets the employeeOnlyClaimCostRate value for this ASP.
     * 
     * @return employeeOnlyClaimCostRate
     */
    public com.vsp.xl.dto.v003.CurrencyValue getEmployeeOnlyClaimCostRate() {
        return employeeOnlyClaimCostRate;
    }


    /**
     * Sets the employeeOnlyClaimCostRate value for this ASP.
     * 
     * @param employeeOnlyClaimCostRate
     */
    public void setEmployeeOnlyClaimCostRate(com.vsp.xl.dto.v003.CurrencyValue employeeOnlyClaimCostRate) {
        this.employeeOnlyClaimCostRate = employeeOnlyClaimCostRate;
    }


    /**
     * Gets the employeePlusChildrenClaimCostRate value for this ASP.
     * 
     * @return employeePlusChildrenClaimCostRate
     */
    public com.vsp.xl.dto.v003.CurrencyValue getEmployeePlusChildrenClaimCostRate() {
        return employeePlusChildrenClaimCostRate;
    }


    /**
     * Sets the employeePlusChildrenClaimCostRate value for this ASP.
     * 
     * @param employeePlusChildrenClaimCostRate
     */
    public void setEmployeePlusChildrenClaimCostRate(com.vsp.xl.dto.v003.CurrencyValue employeePlusChildrenClaimCostRate) {
        this.employeePlusChildrenClaimCostRate = employeePlusChildrenClaimCostRate;
    }


    /**
     * Gets the employeePlusFamilyClaimCostRate value for this ASP.
     * 
     * @return employeePlusFamilyClaimCostRate
     */
    public com.vsp.xl.dto.v003.CurrencyValue getEmployeePlusFamilyClaimCostRate() {
        return employeePlusFamilyClaimCostRate;
    }


    /**
     * Sets the employeePlusFamilyClaimCostRate value for this ASP.
     * 
     * @param employeePlusFamilyClaimCostRate
     */
    public void setEmployeePlusFamilyClaimCostRate(com.vsp.xl.dto.v003.CurrencyValue employeePlusFamilyClaimCostRate) {
        this.employeePlusFamilyClaimCostRate = employeePlusFamilyClaimCostRate;
    }


    /**
     * Gets the employeePlusOneClaimCostRate value for this ASP.
     * 
     * @return employeePlusOneClaimCostRate
     */
    public com.vsp.xl.dto.v003.CurrencyValue getEmployeePlusOneClaimCostRate() {
        return employeePlusOneClaimCostRate;
    }


    /**
     * Sets the employeePlusOneClaimCostRate value for this ASP.
     * 
     * @param employeePlusOneClaimCostRate
     */
    public void setEmployeePlusOneClaimCostRate(com.vsp.xl.dto.v003.CurrencyValue employeePlusOneClaimCostRate) {
        this.employeePlusOneClaimCostRate = employeePlusOneClaimCostRate;
    }


    /**
     * Gets the claimCostAmount value for this ASP.
     * 
     * @return claimCostAmount
     */
    public com.vsp.xl.dto.v003.CurrencyValue getClaimCostAmount() {
        return claimCostAmount;
    }


    /**
     * Sets the claimCostAmount value for this ASP.
     * 
     * @param claimCostAmount
     */
    public void setClaimCostAmount(com.vsp.xl.dto.v003.CurrencyValue claimCostAmount) {
        this.claimCostAmount = claimCostAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ASP)) return false;
        ASP other = (ASP) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.employeeOnlyClaimCostRate==null && other.getEmployeeOnlyClaimCostRate()==null) || 
             (this.employeeOnlyClaimCostRate!=null &&
              this.employeeOnlyClaimCostRate.equals(other.getEmployeeOnlyClaimCostRate()))) &&
            ((this.employeePlusChildrenClaimCostRate==null && other.getEmployeePlusChildrenClaimCostRate()==null) || 
             (this.employeePlusChildrenClaimCostRate!=null &&
              this.employeePlusChildrenClaimCostRate.equals(other.getEmployeePlusChildrenClaimCostRate()))) &&
            ((this.employeePlusFamilyClaimCostRate==null && other.getEmployeePlusFamilyClaimCostRate()==null) || 
             (this.employeePlusFamilyClaimCostRate!=null &&
              this.employeePlusFamilyClaimCostRate.equals(other.getEmployeePlusFamilyClaimCostRate()))) &&
            ((this.employeePlusOneClaimCostRate==null && other.getEmployeePlusOneClaimCostRate()==null) || 
             (this.employeePlusOneClaimCostRate!=null &&
              this.employeePlusOneClaimCostRate.equals(other.getEmployeePlusOneClaimCostRate()))) &&
            ((this.claimCostAmount==null && other.getClaimCostAmount()==null) || 
             (this.claimCostAmount!=null &&
              this.claimCostAmount.equals(other.getClaimCostAmount())));
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
        if (getEmployeeOnlyClaimCostRate() != null) {
            _hashCode += getEmployeeOnlyClaimCostRate().hashCode();
        }
        if (getEmployeePlusChildrenClaimCostRate() != null) {
            _hashCode += getEmployeePlusChildrenClaimCostRate().hashCode();
        }
        if (getEmployeePlusFamilyClaimCostRate() != null) {
            _hashCode += getEmployeePlusFamilyClaimCostRate().hashCode();
        }
        if (getEmployeePlusOneClaimCostRate() != null) {
            _hashCode += getEmployeePlusOneClaimCostRate().hashCode();
        }
        if (getClaimCostAmount() != null) {
            _hashCode += getClaimCostAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ASP.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "ASP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeOnlyClaimCostRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeeOnlyClaimCostRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeePlusChildrenClaimCostRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeePlusChildrenClaimCostRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeePlusFamilyClaimCostRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeePlusFamilyClaimCostRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeePlusOneClaimCostRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "employeePlusOneClaimCostRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimCostAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimCostAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue"));
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

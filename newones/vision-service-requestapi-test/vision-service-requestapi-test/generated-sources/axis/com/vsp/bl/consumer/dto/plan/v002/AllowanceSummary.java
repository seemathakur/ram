/**
 * AllowanceSummary.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.plan.v002;

public class AllowanceSummary  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.consumer.dto.plan.v002.Allowance electiveConactLensAllowance;

    private com.vsp.bl.consumer.dto.plan.v002.Allowance retailFrameAllowance;

    private com.vsp.bl.consumer.dto.plan.v002.Allowance wholesaleFrameAllowance;

    public AllowanceSummary() {
    }

    public AllowanceSummary(
           com.vsp.bl.consumer.dto.plan.v002.Allowance electiveConactLensAllowance,
           com.vsp.bl.consumer.dto.plan.v002.Allowance retailFrameAllowance,
           com.vsp.bl.consumer.dto.plan.v002.Allowance wholesaleFrameAllowance) {
        this.electiveConactLensAllowance = electiveConactLensAllowance;
        this.retailFrameAllowance = retailFrameAllowance;
        this.wholesaleFrameAllowance = wholesaleFrameAllowance;
    }


    /**
     * Gets the electiveConactLensAllowance value for this AllowanceSummary.
     * 
     * @return electiveConactLensAllowance
     */
    public com.vsp.bl.consumer.dto.plan.v002.Allowance getElectiveConactLensAllowance() {
        return electiveConactLensAllowance;
    }


    /**
     * Sets the electiveConactLensAllowance value for this AllowanceSummary.
     * 
     * @param electiveConactLensAllowance
     */
    public void setElectiveConactLensAllowance(com.vsp.bl.consumer.dto.plan.v002.Allowance electiveConactLensAllowance) {
        this.electiveConactLensAllowance = electiveConactLensAllowance;
    }


    /**
     * Gets the retailFrameAllowance value for this AllowanceSummary.
     * 
     * @return retailFrameAllowance
     */
    public com.vsp.bl.consumer.dto.plan.v002.Allowance getRetailFrameAllowance() {
        return retailFrameAllowance;
    }


    /**
     * Sets the retailFrameAllowance value for this AllowanceSummary.
     * 
     * @param retailFrameAllowance
     */
    public void setRetailFrameAllowance(com.vsp.bl.consumer.dto.plan.v002.Allowance retailFrameAllowance) {
        this.retailFrameAllowance = retailFrameAllowance;
    }


    /**
     * Gets the wholesaleFrameAllowance value for this AllowanceSummary.
     * 
     * @return wholesaleFrameAllowance
     */
    public com.vsp.bl.consumer.dto.plan.v002.Allowance getWholesaleFrameAllowance() {
        return wholesaleFrameAllowance;
    }


    /**
     * Sets the wholesaleFrameAllowance value for this AllowanceSummary.
     * 
     * @param wholesaleFrameAllowance
     */
    public void setWholesaleFrameAllowance(com.vsp.bl.consumer.dto.plan.v002.Allowance wholesaleFrameAllowance) {
        this.wholesaleFrameAllowance = wholesaleFrameAllowance;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AllowanceSummary)) return false;
        AllowanceSummary other = (AllowanceSummary) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.electiveConactLensAllowance==null && other.getElectiveConactLensAllowance()==null) || 
             (this.electiveConactLensAllowance!=null &&
              this.electiveConactLensAllowance.equals(other.getElectiveConactLensAllowance()))) &&
            ((this.retailFrameAllowance==null && other.getRetailFrameAllowance()==null) || 
             (this.retailFrameAllowance!=null &&
              this.retailFrameAllowance.equals(other.getRetailFrameAllowance()))) &&
            ((this.wholesaleFrameAllowance==null && other.getWholesaleFrameAllowance()==null) || 
             (this.wholesaleFrameAllowance!=null &&
              this.wholesaleFrameAllowance.equals(other.getWholesaleFrameAllowance())));
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
        if (getElectiveConactLensAllowance() != null) {
            _hashCode += getElectiveConactLensAllowance().hashCode();
        }
        if (getRetailFrameAllowance() != null) {
            _hashCode += getRetailFrameAllowance().hashCode();
        }
        if (getWholesaleFrameAllowance() != null) {
            _hashCode += getWholesaleFrameAllowance().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AllowanceSummary.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "AllowanceSummary"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("electiveConactLensAllowance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "electiveConactLensAllowance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Allowance"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retailFrameAllowance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "retailFrameAllowance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Allowance"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wholesaleFrameAllowance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wholesaleFrameAllowance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Allowance"));
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

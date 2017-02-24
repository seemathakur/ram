/**
 * CopaySummary.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.plan.v004;

public class CopaySummary  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.consumer.dto.plan.v002.Copay examCopayment;

    private com.vsp.bl.consumer.dto.plan.v002.Copay frameCopayment;

    private com.vsp.bl.consumer.dto.plan.v002.Copay lensFrameCopayment;

    private com.vsp.bl.consumer.dto.plan.v002.Copay totalCopayment;

    private com.vsp.bl.consumer.dto.plan.v002.Copay contactLensCopayment;

    private com.vsp.bl.consumer.dto.plan.v002.Copay lensCopayment;

    private com.vsp.bl.consumer.dto.plan.v002.Copay clExamCopayment;

    private java.lang.Boolean isCoveredContactLens;

    public CopaySummary() {
    }

    public CopaySummary(
           com.vsp.bl.consumer.dto.plan.v002.Copay examCopayment,
           com.vsp.bl.consumer.dto.plan.v002.Copay frameCopayment,
           com.vsp.bl.consumer.dto.plan.v002.Copay lensFrameCopayment,
           com.vsp.bl.consumer.dto.plan.v002.Copay totalCopayment,
           com.vsp.bl.consumer.dto.plan.v002.Copay contactLensCopayment,
           com.vsp.bl.consumer.dto.plan.v002.Copay lensCopayment,
           com.vsp.bl.consumer.dto.plan.v002.Copay clExamCopayment,
           java.lang.Boolean isCoveredContactLens) {
        this.examCopayment = examCopayment;
        this.frameCopayment = frameCopayment;
        this.lensFrameCopayment = lensFrameCopayment;
        this.totalCopayment = totalCopayment;
        this.contactLensCopayment = contactLensCopayment;
        this.lensCopayment = lensCopayment;
        this.clExamCopayment = clExamCopayment;
        this.isCoveredContactLens = isCoveredContactLens;
    }


    /**
     * Gets the examCopayment value for this CopaySummary.
     * 
     * @return examCopayment
     */
    public com.vsp.bl.consumer.dto.plan.v002.Copay getExamCopayment() {
        return examCopayment;
    }


    /**
     * Sets the examCopayment value for this CopaySummary.
     * 
     * @param examCopayment
     */
    public void setExamCopayment(com.vsp.bl.consumer.dto.plan.v002.Copay examCopayment) {
        this.examCopayment = examCopayment;
    }


    /**
     * Gets the frameCopayment value for this CopaySummary.
     * 
     * @return frameCopayment
     */
    public com.vsp.bl.consumer.dto.plan.v002.Copay getFrameCopayment() {
        return frameCopayment;
    }


    /**
     * Sets the frameCopayment value for this CopaySummary.
     * 
     * @param frameCopayment
     */
    public void setFrameCopayment(com.vsp.bl.consumer.dto.plan.v002.Copay frameCopayment) {
        this.frameCopayment = frameCopayment;
    }


    /**
     * Gets the lensFrameCopayment value for this CopaySummary.
     * 
     * @return lensFrameCopayment
     */
    public com.vsp.bl.consumer.dto.plan.v002.Copay getLensFrameCopayment() {
        return lensFrameCopayment;
    }


    /**
     * Sets the lensFrameCopayment value for this CopaySummary.
     * 
     * @param lensFrameCopayment
     */
    public void setLensFrameCopayment(com.vsp.bl.consumer.dto.plan.v002.Copay lensFrameCopayment) {
        this.lensFrameCopayment = lensFrameCopayment;
    }


    /**
     * Gets the totalCopayment value for this CopaySummary.
     * 
     * @return totalCopayment
     */
    public com.vsp.bl.consumer.dto.plan.v002.Copay getTotalCopayment() {
        return totalCopayment;
    }


    /**
     * Sets the totalCopayment value for this CopaySummary.
     * 
     * @param totalCopayment
     */
    public void setTotalCopayment(com.vsp.bl.consumer.dto.plan.v002.Copay totalCopayment) {
        this.totalCopayment = totalCopayment;
    }


    /**
     * Gets the contactLensCopayment value for this CopaySummary.
     * 
     * @return contactLensCopayment
     */
    public com.vsp.bl.consumer.dto.plan.v002.Copay getContactLensCopayment() {
        return contactLensCopayment;
    }


    /**
     * Sets the contactLensCopayment value for this CopaySummary.
     * 
     * @param contactLensCopayment
     */
    public void setContactLensCopayment(com.vsp.bl.consumer.dto.plan.v002.Copay contactLensCopayment) {
        this.contactLensCopayment = contactLensCopayment;
    }


    /**
     * Gets the lensCopayment value for this CopaySummary.
     * 
     * @return lensCopayment
     */
    public com.vsp.bl.consumer.dto.plan.v002.Copay getLensCopayment() {
        return lensCopayment;
    }


    /**
     * Sets the lensCopayment value for this CopaySummary.
     * 
     * @param lensCopayment
     */
    public void setLensCopayment(com.vsp.bl.consumer.dto.plan.v002.Copay lensCopayment) {
        this.lensCopayment = lensCopayment;
    }


    /**
     * Gets the clExamCopayment value for this CopaySummary.
     * 
     * @return clExamCopayment
     */
    public com.vsp.bl.consumer.dto.plan.v002.Copay getClExamCopayment() {
        return clExamCopayment;
    }


    /**
     * Sets the clExamCopayment value for this CopaySummary.
     * 
     * @param clExamCopayment
     */
    public void setClExamCopayment(com.vsp.bl.consumer.dto.plan.v002.Copay clExamCopayment) {
        this.clExamCopayment = clExamCopayment;
    }


    /**
     * Gets the isCoveredContactLens value for this CopaySummary.
     * 
     * @return isCoveredContactLens
     */
    public java.lang.Boolean getIsCoveredContactLens() {
        return isCoveredContactLens;
    }


    /**
     * Sets the isCoveredContactLens value for this CopaySummary.
     * 
     * @param isCoveredContactLens
     */
    public void setIsCoveredContactLens(java.lang.Boolean isCoveredContactLens) {
        this.isCoveredContactLens = isCoveredContactLens;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CopaySummary)) return false;
        CopaySummary other = (CopaySummary) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.examCopayment==null && other.getExamCopayment()==null) || 
             (this.examCopayment!=null &&
              this.examCopayment.equals(other.getExamCopayment()))) &&
            ((this.frameCopayment==null && other.getFrameCopayment()==null) || 
             (this.frameCopayment!=null &&
              this.frameCopayment.equals(other.getFrameCopayment()))) &&
            ((this.lensFrameCopayment==null && other.getLensFrameCopayment()==null) || 
             (this.lensFrameCopayment!=null &&
              this.lensFrameCopayment.equals(other.getLensFrameCopayment()))) &&
            ((this.totalCopayment==null && other.getTotalCopayment()==null) || 
             (this.totalCopayment!=null &&
              this.totalCopayment.equals(other.getTotalCopayment()))) &&
            ((this.contactLensCopayment==null && other.getContactLensCopayment()==null) || 
             (this.contactLensCopayment!=null &&
              this.contactLensCopayment.equals(other.getContactLensCopayment()))) &&
            ((this.lensCopayment==null && other.getLensCopayment()==null) || 
             (this.lensCopayment!=null &&
              this.lensCopayment.equals(other.getLensCopayment()))) &&
            ((this.clExamCopayment==null && other.getClExamCopayment()==null) || 
             (this.clExamCopayment!=null &&
              this.clExamCopayment.equals(other.getClExamCopayment()))) &&
            ((this.isCoveredContactLens==null && other.getIsCoveredContactLens()==null) || 
             (this.isCoveredContactLens!=null &&
              this.isCoveredContactLens.equals(other.getIsCoveredContactLens())));
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
        if (getExamCopayment() != null) {
            _hashCode += getExamCopayment().hashCode();
        }
        if (getFrameCopayment() != null) {
            _hashCode += getFrameCopayment().hashCode();
        }
        if (getLensFrameCopayment() != null) {
            _hashCode += getLensFrameCopayment().hashCode();
        }
        if (getTotalCopayment() != null) {
            _hashCode += getTotalCopayment().hashCode();
        }
        if (getContactLensCopayment() != null) {
            _hashCode += getContactLensCopayment().hashCode();
        }
        if (getLensCopayment() != null) {
            _hashCode += getLensCopayment().hashCode();
        }
        if (getClExamCopayment() != null) {
            _hashCode += getClExamCopayment().hashCode();
        }
        if (getIsCoveredContactLens() != null) {
            _hashCode += getIsCoveredContactLens().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CopaySummary.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v004.plan.dto.consumer.bl.vsp.com", "CopaySummary"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("examCopayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "examCopayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Copay"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frameCopayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frameCopayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Copay"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lensFrameCopayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lensFrameCopayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Copay"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCopayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalCopayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Copay"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactLensCopayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contactLensCopayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Copay"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lensCopayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lensCopayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Copay"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clExamCopayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clExamCopayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Copay"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCoveredContactLens");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCoveredContactLens"));
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

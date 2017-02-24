/**
 * PatientRelationship.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.product.dto.coverage.v002;

public class PatientRelationship  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v003.IntegerRange ageRange;

    private com.vsp.xl.dto.v002.SimpleCode expirationType;

    private com.vsp.xl.dto.v002.SimpleCode relationshipType;

    private com.vsp.xl.dto.v002.SimpleCode startType;

    private java.lang.Integer expirationMm;

    private java.lang.Integer startMm;

    public PatientRelationship() {
    }

    public PatientRelationship(
           com.vsp.xl.dto.v003.IntegerRange ageRange,
           com.vsp.xl.dto.v002.SimpleCode expirationType,
           com.vsp.xl.dto.v002.SimpleCode relationshipType,
           com.vsp.xl.dto.v002.SimpleCode startType,
           java.lang.Integer expirationMm,
           java.lang.Integer startMm) {
        this.ageRange = ageRange;
        this.expirationType = expirationType;
        this.relationshipType = relationshipType;
        this.startType = startType;
        this.expirationMm = expirationMm;
        this.startMm = startMm;
    }


    /**
     * Gets the ageRange value for this PatientRelationship.
     * 
     * @return ageRange
     */
    public com.vsp.xl.dto.v003.IntegerRange getAgeRange() {
        return ageRange;
    }


    /**
     * Sets the ageRange value for this PatientRelationship.
     * 
     * @param ageRange
     */
    public void setAgeRange(com.vsp.xl.dto.v003.IntegerRange ageRange) {
        this.ageRange = ageRange;
    }


    /**
     * Gets the expirationType value for this PatientRelationship.
     * 
     * @return expirationType
     */
    public com.vsp.xl.dto.v002.SimpleCode getExpirationType() {
        return expirationType;
    }


    /**
     * Sets the expirationType value for this PatientRelationship.
     * 
     * @param expirationType
     */
    public void setExpirationType(com.vsp.xl.dto.v002.SimpleCode expirationType) {
        this.expirationType = expirationType;
    }


    /**
     * Gets the relationshipType value for this PatientRelationship.
     * 
     * @return relationshipType
     */
    public com.vsp.xl.dto.v002.SimpleCode getRelationshipType() {
        return relationshipType;
    }


    /**
     * Sets the relationshipType value for this PatientRelationship.
     * 
     * @param relationshipType
     */
    public void setRelationshipType(com.vsp.xl.dto.v002.SimpleCode relationshipType) {
        this.relationshipType = relationshipType;
    }


    /**
     * Gets the startType value for this PatientRelationship.
     * 
     * @return startType
     */
    public com.vsp.xl.dto.v002.SimpleCode getStartType() {
        return startType;
    }


    /**
     * Sets the startType value for this PatientRelationship.
     * 
     * @param startType
     */
    public void setStartType(com.vsp.xl.dto.v002.SimpleCode startType) {
        this.startType = startType;
    }


    /**
     * Gets the expirationMm value for this PatientRelationship.
     * 
     * @return expirationMm
     */
    public java.lang.Integer getExpirationMm() {
        return expirationMm;
    }


    /**
     * Sets the expirationMm value for this PatientRelationship.
     * 
     * @param expirationMm
     */
    public void setExpirationMm(java.lang.Integer expirationMm) {
        this.expirationMm = expirationMm;
    }


    /**
     * Gets the startMm value for this PatientRelationship.
     * 
     * @return startMm
     */
    public java.lang.Integer getStartMm() {
        return startMm;
    }


    /**
     * Sets the startMm value for this PatientRelationship.
     * 
     * @param startMm
     */
    public void setStartMm(java.lang.Integer startMm) {
        this.startMm = startMm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PatientRelationship)) return false;
        PatientRelationship other = (PatientRelationship) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.ageRange==null && other.getAgeRange()==null) || 
             (this.ageRange!=null &&
              this.ageRange.equals(other.getAgeRange()))) &&
            ((this.expirationType==null && other.getExpirationType()==null) || 
             (this.expirationType!=null &&
              this.expirationType.equals(other.getExpirationType()))) &&
            ((this.relationshipType==null && other.getRelationshipType()==null) || 
             (this.relationshipType!=null &&
              this.relationshipType.equals(other.getRelationshipType()))) &&
            ((this.startType==null && other.getStartType()==null) || 
             (this.startType!=null &&
              this.startType.equals(other.getStartType()))) &&
            ((this.expirationMm==null && other.getExpirationMm()==null) || 
             (this.expirationMm!=null &&
              this.expirationMm.equals(other.getExpirationMm()))) &&
            ((this.startMm==null && other.getStartMm()==null) || 
             (this.startMm!=null &&
              this.startMm.equals(other.getStartMm())));
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
        if (getAgeRange() != null) {
            _hashCode += getAgeRange().hashCode();
        }
        if (getExpirationType() != null) {
            _hashCode += getExpirationType().hashCode();
        }
        if (getRelationshipType() != null) {
            _hashCode += getRelationshipType().hashCode();
        }
        if (getStartType() != null) {
            _hashCode += getStartType().hashCode();
        }
        if (getExpirationMm() != null) {
            _hashCode += getExpirationMm().hashCode();
        }
        if (getStartMm() != null) {
            _hashCode += getStartMm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PatientRelationship.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PatientRelationship"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ageRange");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ageRange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "IntegerRange"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expirationType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expirationType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relationshipType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relationshipType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expirationMm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expirationMm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startMm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startMm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
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

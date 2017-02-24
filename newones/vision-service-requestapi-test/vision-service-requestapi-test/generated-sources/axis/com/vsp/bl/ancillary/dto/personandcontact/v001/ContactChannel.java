/**
 * ContactChannel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.ancillary.dto.personandcontact.v001;

public abstract class ContactChannel  extends com.vsp.xl.dto.v002.IdentifiableDTO  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.DatePeriod effectivePeriod;

    private java.lang.Boolean noMarketingInd;

    private java.lang.String preferredContactDays;

    private com.vsp.xl.dto.v001.TimePeriod preferredContactHours;

    private java.lang.Integer preferredMethod;

    private java.lang.Boolean preferredMethodInd;

    private java.lang.String usage;

    private java.lang.Boolean preferred;

    public ContactChannel() {
    }

    public ContactChannel(
           java.lang.String id,
           com.vsp.xl.dto.v002.DatePeriod effectivePeriod,
           java.lang.Boolean noMarketingInd,
           java.lang.String preferredContactDays,
           com.vsp.xl.dto.v001.TimePeriod preferredContactHours,
           java.lang.Integer preferredMethod,
           java.lang.Boolean preferredMethodInd,
           java.lang.String usage,
           java.lang.Boolean preferred) {
        super(
            id);
        this.effectivePeriod = effectivePeriod;
        this.noMarketingInd = noMarketingInd;
        this.preferredContactDays = preferredContactDays;
        this.preferredContactHours = preferredContactHours;
        this.preferredMethod = preferredMethod;
        this.preferredMethodInd = preferredMethodInd;
        this.usage = usage;
        this.preferred = preferred;
    }


    /**
     * Gets the effectivePeriod value for this ContactChannel.
     * 
     * @return effectivePeriod
     */
    public com.vsp.xl.dto.v002.DatePeriod getEffectivePeriod() {
        return effectivePeriod;
    }


    /**
     * Sets the effectivePeriod value for this ContactChannel.
     * 
     * @param effectivePeriod
     */
    public void setEffectivePeriod(com.vsp.xl.dto.v002.DatePeriod effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }


    /**
     * Gets the noMarketingInd value for this ContactChannel.
     * 
     * @return noMarketingInd
     */
    public java.lang.Boolean getNoMarketingInd() {
        return noMarketingInd;
    }


    /**
     * Sets the noMarketingInd value for this ContactChannel.
     * 
     * @param noMarketingInd
     */
    public void setNoMarketingInd(java.lang.Boolean noMarketingInd) {
        this.noMarketingInd = noMarketingInd;
    }


    /**
     * Gets the preferredContactDays value for this ContactChannel.
     * 
     * @return preferredContactDays
     */
    public java.lang.String getPreferredContactDays() {
        return preferredContactDays;
    }


    /**
     * Sets the preferredContactDays value for this ContactChannel.
     * 
     * @param preferredContactDays
     */
    public void setPreferredContactDays(java.lang.String preferredContactDays) {
        this.preferredContactDays = preferredContactDays;
    }


    /**
     * Gets the preferredContactHours value for this ContactChannel.
     * 
     * @return preferredContactHours
     */
    public com.vsp.xl.dto.v001.TimePeriod getPreferredContactHours() {
        return preferredContactHours;
    }


    /**
     * Sets the preferredContactHours value for this ContactChannel.
     * 
     * @param preferredContactHours
     */
    public void setPreferredContactHours(com.vsp.xl.dto.v001.TimePeriod preferredContactHours) {
        this.preferredContactHours = preferredContactHours;
    }


    /**
     * Gets the preferredMethod value for this ContactChannel.
     * 
     * @return preferredMethod
     */
    public java.lang.Integer getPreferredMethod() {
        return preferredMethod;
    }


    /**
     * Sets the preferredMethod value for this ContactChannel.
     * 
     * @param preferredMethod
     */
    public void setPreferredMethod(java.lang.Integer preferredMethod) {
        this.preferredMethod = preferredMethod;
    }


    /**
     * Gets the preferredMethodInd value for this ContactChannel.
     * 
     * @return preferredMethodInd
     */
    public java.lang.Boolean getPreferredMethodInd() {
        return preferredMethodInd;
    }


    /**
     * Sets the preferredMethodInd value for this ContactChannel.
     * 
     * @param preferredMethodInd
     */
    public void setPreferredMethodInd(java.lang.Boolean preferredMethodInd) {
        this.preferredMethodInd = preferredMethodInd;
    }


    /**
     * Gets the usage value for this ContactChannel.
     * 
     * @return usage
     */
    public java.lang.String getUsage() {
        return usage;
    }


    /**
     * Sets the usage value for this ContactChannel.
     * 
     * @param usage
     */
    public void setUsage(java.lang.String usage) {
        this.usage = usage;
    }


    /**
     * Gets the preferred value for this ContactChannel.
     * 
     * @return preferred
     */
    public java.lang.Boolean getPreferred() {
        return preferred;
    }


    /**
     * Sets the preferred value for this ContactChannel.
     * 
     * @param preferred
     */
    public void setPreferred(java.lang.Boolean preferred) {
        this.preferred = preferred;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContactChannel)) return false;
        ContactChannel other = (ContactChannel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.effectivePeriod==null && other.getEffectivePeriod()==null) || 
             (this.effectivePeriod!=null &&
              this.effectivePeriod.equals(other.getEffectivePeriod()))) &&
            ((this.noMarketingInd==null && other.getNoMarketingInd()==null) || 
             (this.noMarketingInd!=null &&
              this.noMarketingInd.equals(other.getNoMarketingInd()))) &&
            ((this.preferredContactDays==null && other.getPreferredContactDays()==null) || 
             (this.preferredContactDays!=null &&
              this.preferredContactDays.equals(other.getPreferredContactDays()))) &&
            ((this.preferredContactHours==null && other.getPreferredContactHours()==null) || 
             (this.preferredContactHours!=null &&
              this.preferredContactHours.equals(other.getPreferredContactHours()))) &&
            ((this.preferredMethod==null && other.getPreferredMethod()==null) || 
             (this.preferredMethod!=null &&
              this.preferredMethod.equals(other.getPreferredMethod()))) &&
            ((this.preferredMethodInd==null && other.getPreferredMethodInd()==null) || 
             (this.preferredMethodInd!=null &&
              this.preferredMethodInd.equals(other.getPreferredMethodInd()))) &&
            ((this.usage==null && other.getUsage()==null) || 
             (this.usage!=null &&
              this.usage.equals(other.getUsage()))) &&
            ((this.preferred==null && other.getPreferred()==null) || 
             (this.preferred!=null &&
              this.preferred.equals(other.getPreferred())));
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
        if (getEffectivePeriod() != null) {
            _hashCode += getEffectivePeriod().hashCode();
        }
        if (getNoMarketingInd() != null) {
            _hashCode += getNoMarketingInd().hashCode();
        }
        if (getPreferredContactDays() != null) {
            _hashCode += getPreferredContactDays().hashCode();
        }
        if (getPreferredContactHours() != null) {
            _hashCode += getPreferredContactHours().hashCode();
        }
        if (getPreferredMethod() != null) {
            _hashCode += getPreferredMethod().hashCode();
        }
        if (getPreferredMethodInd() != null) {
            _hashCode += getPreferredMethodInd().hashCode();
        }
        if (getUsage() != null) {
            _hashCode += getUsage().hashCode();
        }
        if (getPreferred() != null) {
            _hashCode += getPreferred().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContactChannel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.personandcontact.dto.ancillary.bl.vsp.com", "ContactChannel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectivePeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectivePeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "DatePeriod"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noMarketingInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "noMarketingInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferredContactDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preferredContactDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferredContactHours");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preferredContactHours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.dto.xl.vsp.com", "TimePeriod"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferredMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preferredMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferredMethodInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preferredMethodInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferred");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preferred"));
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

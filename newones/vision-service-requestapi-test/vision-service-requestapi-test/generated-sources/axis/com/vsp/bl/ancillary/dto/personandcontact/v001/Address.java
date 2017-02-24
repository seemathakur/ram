/**
 * Address.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.ancillary.dto.personandcontact.v001;

public class Address  extends com.vsp.bl.ancillary.dto.personandcontact.v001.ContactChannel  implements java.io.Serializable {
    private java.lang.String city;

    private java.lang.String county;

    private com.vsp.xl.dto.v002.SimpleCode state;

    private java.lang.String streetAddress1;

    private java.lang.String streetAddress2;

    private java.lang.String streetAddress3;

    private java.lang.String zip;

    private java.lang.String zipExtension;

    private java.lang.String type;

    private java.lang.String countryCode;

    public Address() {
    }

    public Address(
           java.lang.String id,
           com.vsp.xl.dto.v002.DatePeriod effectivePeriod,
           java.lang.Boolean noMarketingInd,
           java.lang.String preferredContactDays,
           com.vsp.xl.dto.v001.TimePeriod preferredContactHours,
           java.lang.Integer preferredMethod,
           java.lang.Boolean preferredMethodInd,
           java.lang.String usage,
           java.lang.Boolean preferred,
           java.lang.String city,
           java.lang.String county,
           com.vsp.xl.dto.v002.SimpleCode state,
           java.lang.String streetAddress1,
           java.lang.String streetAddress2,
           java.lang.String streetAddress3,
           java.lang.String zip,
           java.lang.String zipExtension,
           java.lang.String type,
           java.lang.String countryCode) {
        super(
            id,
            effectivePeriod,
            noMarketingInd,
            preferredContactDays,
            preferredContactHours,
            preferredMethod,
            preferredMethodInd,
            usage,
            preferred);
        this.city = city;
        this.county = county;
        this.state = state;
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.streetAddress3 = streetAddress3;
        this.zip = zip;
        this.zipExtension = zipExtension;
        this.type = type;
        this.countryCode = countryCode;
    }


    /**
     * Gets the city value for this Address.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this Address.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the county value for this Address.
     * 
     * @return county
     */
    public java.lang.String getCounty() {
        return county;
    }


    /**
     * Sets the county value for this Address.
     * 
     * @param county
     */
    public void setCounty(java.lang.String county) {
        this.county = county;
    }


    /**
     * Gets the state value for this Address.
     * 
     * @return state
     */
    public com.vsp.xl.dto.v002.SimpleCode getState() {
        return state;
    }


    /**
     * Sets the state value for this Address.
     * 
     * @param state
     */
    public void setState(com.vsp.xl.dto.v002.SimpleCode state) {
        this.state = state;
    }


    /**
     * Gets the streetAddress1 value for this Address.
     * 
     * @return streetAddress1
     */
    public java.lang.String getStreetAddress1() {
        return streetAddress1;
    }


    /**
     * Sets the streetAddress1 value for this Address.
     * 
     * @param streetAddress1
     */
    public void setStreetAddress1(java.lang.String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }


    /**
     * Gets the streetAddress2 value for this Address.
     * 
     * @return streetAddress2
     */
    public java.lang.String getStreetAddress2() {
        return streetAddress2;
    }


    /**
     * Sets the streetAddress2 value for this Address.
     * 
     * @param streetAddress2
     */
    public void setStreetAddress2(java.lang.String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }


    /**
     * Gets the streetAddress3 value for this Address.
     * 
     * @return streetAddress3
     */
    public java.lang.String getStreetAddress3() {
        return streetAddress3;
    }


    /**
     * Sets the streetAddress3 value for this Address.
     * 
     * @param streetAddress3
     */
    public void setStreetAddress3(java.lang.String streetAddress3) {
        this.streetAddress3 = streetAddress3;
    }


    /**
     * Gets the zip value for this Address.
     * 
     * @return zip
     */
    public java.lang.String getZip() {
        return zip;
    }


    /**
     * Sets the zip value for this Address.
     * 
     * @param zip
     */
    public void setZip(java.lang.String zip) {
        this.zip = zip;
    }


    /**
     * Gets the zipExtension value for this Address.
     * 
     * @return zipExtension
     */
    public java.lang.String getZipExtension() {
        return zipExtension;
    }


    /**
     * Sets the zipExtension value for this Address.
     * 
     * @param zipExtension
     */
    public void setZipExtension(java.lang.String zipExtension) {
        this.zipExtension = zipExtension;
    }


    /**
     * Gets the type value for this Address.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this Address.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the countryCode value for this Address.
     * 
     * @return countryCode
     */
    public java.lang.String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this Address.
     * 
     * @param countryCode
     */
    public void setCountryCode(java.lang.String countryCode) {
        this.countryCode = countryCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Address)) return false;
        Address other = (Address) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.county==null && other.getCounty()==null) || 
             (this.county!=null &&
              this.county.equals(other.getCounty()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.streetAddress1==null && other.getStreetAddress1()==null) || 
             (this.streetAddress1!=null &&
              this.streetAddress1.equals(other.getStreetAddress1()))) &&
            ((this.streetAddress2==null && other.getStreetAddress2()==null) || 
             (this.streetAddress2!=null &&
              this.streetAddress2.equals(other.getStreetAddress2()))) &&
            ((this.streetAddress3==null && other.getStreetAddress3()==null) || 
             (this.streetAddress3!=null &&
              this.streetAddress3.equals(other.getStreetAddress3()))) &&
            ((this.zip==null && other.getZip()==null) || 
             (this.zip!=null &&
              this.zip.equals(other.getZip()))) &&
            ((this.zipExtension==null && other.getZipExtension()==null) || 
             (this.zipExtension!=null &&
              this.zipExtension.equals(other.getZipExtension()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.countryCode==null && other.getCountryCode()==null) || 
             (this.countryCode!=null &&
              this.countryCode.equals(other.getCountryCode())));
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
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getCounty() != null) {
            _hashCode += getCounty().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getStreetAddress1() != null) {
            _hashCode += getStreetAddress1().hashCode();
        }
        if (getStreetAddress2() != null) {
            _hashCode += getStreetAddress2().hashCode();
        }
        if (getStreetAddress3() != null) {
            _hashCode += getStreetAddress3().hashCode();
        }
        if (getZip() != null) {
            _hashCode += getZip().hashCode();
        }
        if (getZipExtension() != null) {
            _hashCode += getZipExtension().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getCountryCode() != null) {
            _hashCode += getCountryCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Address.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.personandcontact.dto.ancillary.bl.vsp.com", "Address"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city");
        elemField.setXmlName(new javax.xml.namespace.QName("", "city"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("county");
        elemField.setXmlName(new javax.xml.namespace.QName("", "county"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("streetAddress1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "streetAddress1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("streetAddress2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "streetAddress2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("streetAddress3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "streetAddress3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zipExtension");
        elemField.setXmlName(new javax.xml.namespace.QName("", "zipExtension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "countryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

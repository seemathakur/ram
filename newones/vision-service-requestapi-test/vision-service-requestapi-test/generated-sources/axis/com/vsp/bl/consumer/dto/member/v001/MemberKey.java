/**
 * MemberKey.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.member.v001;

public class MemberKey  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.xl.dto.v002.Date memberDateOfBirth;

    private com.vsp.bl.ancillary.dto.personandcontact.v001.Name memberName;

    private com.vsp.xl.dto.v002.SimpleCode memberRelationship;

    private com.vsp.bl.consumer.dto.member.v001.SubscriberKey subscriberKey;

    public MemberKey() {
    }

    public MemberKey(
           com.vsp.xl.dto.v002.Date memberDateOfBirth,
           com.vsp.bl.ancillary.dto.personandcontact.v001.Name memberName,
           com.vsp.xl.dto.v002.SimpleCode memberRelationship,
           com.vsp.bl.consumer.dto.member.v001.SubscriberKey subscriberKey) {
        this.memberDateOfBirth = memberDateOfBirth;
        this.memberName = memberName;
        this.memberRelationship = memberRelationship;
        this.subscriberKey = subscriberKey;
    }


    /**
     * Gets the memberDateOfBirth value for this MemberKey.
     * 
     * @return memberDateOfBirth
     */
    public com.vsp.xl.dto.v002.Date getMemberDateOfBirth() {
        return memberDateOfBirth;
    }


    /**
     * Sets the memberDateOfBirth value for this MemberKey.
     * 
     * @param memberDateOfBirth
     */
    public void setMemberDateOfBirth(com.vsp.xl.dto.v002.Date memberDateOfBirth) {
        this.memberDateOfBirth = memberDateOfBirth;
    }


    /**
     * Gets the memberName value for this MemberKey.
     * 
     * @return memberName
     */
    public com.vsp.bl.ancillary.dto.personandcontact.v001.Name getMemberName() {
        return memberName;
    }


    /**
     * Sets the memberName value for this MemberKey.
     * 
     * @param memberName
     */
    public void setMemberName(com.vsp.bl.ancillary.dto.personandcontact.v001.Name memberName) {
        this.memberName = memberName;
    }


    /**
     * Gets the memberRelationship value for this MemberKey.
     * 
     * @return memberRelationship
     */
    public com.vsp.xl.dto.v002.SimpleCode getMemberRelationship() {
        return memberRelationship;
    }


    /**
     * Sets the memberRelationship value for this MemberKey.
     * 
     * @param memberRelationship
     */
    public void setMemberRelationship(com.vsp.xl.dto.v002.SimpleCode memberRelationship) {
        this.memberRelationship = memberRelationship;
    }


    /**
     * Gets the subscriberKey value for this MemberKey.
     * 
     * @return subscriberKey
     */
    public com.vsp.bl.consumer.dto.member.v001.SubscriberKey getSubscriberKey() {
        return subscriberKey;
    }


    /**
     * Sets the subscriberKey value for this MemberKey.
     * 
     * @param subscriberKey
     */
    public void setSubscriberKey(com.vsp.bl.consumer.dto.member.v001.SubscriberKey subscriberKey) {
        this.subscriberKey = subscriberKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MemberKey)) return false;
        MemberKey other = (MemberKey) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.memberDateOfBirth==null && other.getMemberDateOfBirth()==null) || 
             (this.memberDateOfBirth!=null &&
              this.memberDateOfBirth.equals(other.getMemberDateOfBirth()))) &&
            ((this.memberName==null && other.getMemberName()==null) || 
             (this.memberName!=null &&
              this.memberName.equals(other.getMemberName()))) &&
            ((this.memberRelationship==null && other.getMemberRelationship()==null) || 
             (this.memberRelationship!=null &&
              this.memberRelationship.equals(other.getMemberRelationship()))) &&
            ((this.subscriberKey==null && other.getSubscriberKey()==null) || 
             (this.subscriberKey!=null &&
              this.subscriberKey.equals(other.getSubscriberKey())));
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
        if (getMemberDateOfBirth() != null) {
            _hashCode += getMemberDateOfBirth().hashCode();
        }
        if (getMemberName() != null) {
            _hashCode += getMemberName().hashCode();
        }
        if (getMemberRelationship() != null) {
            _hashCode += getMemberRelationship().hashCode();
        }
        if (getSubscriberKey() != null) {
            _hashCode += getSubscriberKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MemberKey.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberDateOfBirth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberDateOfBirth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.personandcontact.dto.ancillary.bl.vsp.com", "Name"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberRelationship");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberRelationship"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscriberKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subscriberKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "SubscriberKey"));
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

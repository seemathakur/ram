/**
 * UpdateServicesRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class UpdateServicesRequest  extends com.vsp.bl.service.v001.ServiceRequest  implements java.io.Serializable {
    private com.vsp.bl.consumer.dto.member.v001.MemberKey[] akaMembers;

    private com.vsp.xl.dto.v002.Date asOfDate;

    private com.vsp.bl.consumer.dto.member.v001.MemberKey memberKey;

    private java.lang.String classId;

    private com.vsp.xl.dto.v002.SimpleCode[] serviceTypes;

    private com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey previousAuthorizationKey;

    private java.lang.String comments;

    private java.lang.String memberID9Digit;

    private com.vsp.bl.ancillary.dto.personandcontact.v001.Name memberName;

    private com.vsp.xl.dto.v002.Date memberDOB;

    public UpdateServicesRequest() {
    }

    public UpdateServicesRequest(
           java.lang.String serviceThreadId,
           java.lang.String businessTransactionId,
           java.lang.String requesterProcessName,
           java.lang.String userId,
           com.vsp.bl.consumer.dto.member.v001.MemberKey[] akaMembers,
           com.vsp.xl.dto.v002.Date asOfDate,
           com.vsp.bl.consumer.dto.member.v001.MemberKey memberKey,
           java.lang.String classId,
           com.vsp.xl.dto.v002.SimpleCode[] serviceTypes,
           com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey previousAuthorizationKey,
           java.lang.String comments,
           java.lang.String memberID9Digit,
           com.vsp.bl.ancillary.dto.personandcontact.v001.Name memberName,
           com.vsp.xl.dto.v002.Date memberDOB) {
        super(
            serviceThreadId,
            businessTransactionId,
            requesterProcessName,
            userId);
        this.akaMembers = akaMembers;
        this.asOfDate = asOfDate;
        this.memberKey = memberKey;
        this.classId = classId;
        this.serviceTypes = serviceTypes;
        this.previousAuthorizationKey = previousAuthorizationKey;
        this.comments = comments;
        this.memberID9Digit = memberID9Digit;
        this.memberName = memberName;
        this.memberDOB = memberDOB;
    }


    /**
     * Gets the akaMembers value for this UpdateServicesRequest.
     * 
     * @return akaMembers
     */
    public com.vsp.bl.consumer.dto.member.v001.MemberKey[] getAkaMembers() {
        return akaMembers;
    }


    /**
     * Sets the akaMembers value for this UpdateServicesRequest.
     * 
     * @param akaMembers
     */
    public void setAkaMembers(com.vsp.bl.consumer.dto.member.v001.MemberKey[] akaMembers) {
        this.akaMembers = akaMembers;
    }


    /**
     * Gets the asOfDate value for this UpdateServicesRequest.
     * 
     * @return asOfDate
     */
    public com.vsp.xl.dto.v002.Date getAsOfDate() {
        return asOfDate;
    }


    /**
     * Sets the asOfDate value for this UpdateServicesRequest.
     * 
     * @param asOfDate
     */
    public void setAsOfDate(com.vsp.xl.dto.v002.Date asOfDate) {
        this.asOfDate = asOfDate;
    }


    /**
     * Gets the memberKey value for this UpdateServicesRequest.
     * 
     * @return memberKey
     */
    public com.vsp.bl.consumer.dto.member.v001.MemberKey getMemberKey() {
        return memberKey;
    }


    /**
     * Sets the memberKey value for this UpdateServicesRequest.
     * 
     * @param memberKey
     */
    public void setMemberKey(com.vsp.bl.consumer.dto.member.v001.MemberKey memberKey) {
        this.memberKey = memberKey;
    }


    /**
     * Gets the classId value for this UpdateServicesRequest.
     * 
     * @return classId
     */
    public java.lang.String getClassId() {
        return classId;
    }


    /**
     * Sets the classId value for this UpdateServicesRequest.
     * 
     * @param classId
     */
    public void setClassId(java.lang.String classId) {
        this.classId = classId;
    }


    /**
     * Gets the serviceTypes value for this UpdateServicesRequest.
     * 
     * @return serviceTypes
     */
    public com.vsp.xl.dto.v002.SimpleCode[] getServiceTypes() {
        return serviceTypes;
    }


    /**
     * Sets the serviceTypes value for this UpdateServicesRequest.
     * 
     * @param serviceTypes
     */
    public void setServiceTypes(com.vsp.xl.dto.v002.SimpleCode[] serviceTypes) {
        this.serviceTypes = serviceTypes;
    }


    /**
     * Gets the previousAuthorizationKey value for this UpdateServicesRequest.
     * 
     * @return previousAuthorizationKey
     */
    public com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey getPreviousAuthorizationKey() {
        return previousAuthorizationKey;
    }


    /**
     * Sets the previousAuthorizationKey value for this UpdateServicesRequest.
     * 
     * @param previousAuthorizationKey
     */
    public void setPreviousAuthorizationKey(com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey previousAuthorizationKey) {
        this.previousAuthorizationKey = previousAuthorizationKey;
    }


    /**
     * Gets the comments value for this UpdateServicesRequest.
     * 
     * @return comments
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this UpdateServicesRequest.
     * 
     * @param comments
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }


    /**
     * Gets the memberID9Digit value for this UpdateServicesRequest.
     * 
     * @return memberID9Digit
     */
    public java.lang.String getMemberID9Digit() {
        return memberID9Digit;
    }


    /**
     * Sets the memberID9Digit value for this UpdateServicesRequest.
     * 
     * @param memberID9Digit
     */
    public void setMemberID9Digit(java.lang.String memberID9Digit) {
        this.memberID9Digit = memberID9Digit;
    }


    /**
     * Gets the memberName value for this UpdateServicesRequest.
     * 
     * @return memberName
     */
    public com.vsp.bl.ancillary.dto.personandcontact.v001.Name getMemberName() {
        return memberName;
    }


    /**
     * Sets the memberName value for this UpdateServicesRequest.
     * 
     * @param memberName
     */
    public void setMemberName(com.vsp.bl.ancillary.dto.personandcontact.v001.Name memberName) {
        this.memberName = memberName;
    }


    /**
     * Gets the memberDOB value for this UpdateServicesRequest.
     * 
     * @return memberDOB
     */
    public com.vsp.xl.dto.v002.Date getMemberDOB() {
        return memberDOB;
    }


    /**
     * Sets the memberDOB value for this UpdateServicesRequest.
     * 
     * @param memberDOB
     */
    public void setMemberDOB(com.vsp.xl.dto.v002.Date memberDOB) {
        this.memberDOB = memberDOB;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateServicesRequest)) return false;
        UpdateServicesRequest other = (UpdateServicesRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.akaMembers==null && other.getAkaMembers()==null) || 
             (this.akaMembers!=null &&
              java.util.Arrays.equals(this.akaMembers, other.getAkaMembers()))) &&
            ((this.asOfDate==null && other.getAsOfDate()==null) || 
             (this.asOfDate!=null &&
              this.asOfDate.equals(other.getAsOfDate()))) &&
            ((this.memberKey==null && other.getMemberKey()==null) || 
             (this.memberKey!=null &&
              this.memberKey.equals(other.getMemberKey()))) &&
            ((this.classId==null && other.getClassId()==null) || 
             (this.classId!=null &&
              this.classId.equals(other.getClassId()))) &&
            ((this.serviceTypes==null && other.getServiceTypes()==null) || 
             (this.serviceTypes!=null &&
              java.util.Arrays.equals(this.serviceTypes, other.getServiceTypes()))) &&
            ((this.previousAuthorizationKey==null && other.getPreviousAuthorizationKey()==null) || 
             (this.previousAuthorizationKey!=null &&
              this.previousAuthorizationKey.equals(other.getPreviousAuthorizationKey()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments()))) &&
            ((this.memberID9Digit==null && other.getMemberID9Digit()==null) || 
             (this.memberID9Digit!=null &&
              this.memberID9Digit.equals(other.getMemberID9Digit()))) &&
            ((this.memberName==null && other.getMemberName()==null) || 
             (this.memberName!=null &&
              this.memberName.equals(other.getMemberName()))) &&
            ((this.memberDOB==null && other.getMemberDOB()==null) || 
             (this.memberDOB!=null &&
              this.memberDOB.equals(other.getMemberDOB())));
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
        if (getAkaMembers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAkaMembers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAkaMembers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAsOfDate() != null) {
            _hashCode += getAsOfDate().hashCode();
        }
        if (getMemberKey() != null) {
            _hashCode += getMemberKey().hashCode();
        }
        if (getClassId() != null) {
            _hashCode += getClassId().hashCode();
        }
        if (getServiceTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getServiceTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getServiceTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPreviousAuthorizationKey() != null) {
            _hashCode += getPreviousAuthorizationKey().hashCode();
        }
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        if (getMemberID9Digit() != null) {
            _hashCode += getMemberID9Digit().hashCode();
        }
        if (getMemberName() != null) {
            _hashCode += getMemberName().hashCode();
        }
        if (getMemberDOB() != null) {
            _hashCode += getMemberDOB().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateServicesRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "UpdateServicesRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("akaMembers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "akaMembers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asOfDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "asOfDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previousAuthorizationKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "previousAuthorizationKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.authorization.dto.claim.bl.vsp.com", "AuthorizationKey"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberID9Digit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberID9Digit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v001.personandcontact.dto.ancillary.bl.vsp.com", "Name"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberDOB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memberDOB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
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

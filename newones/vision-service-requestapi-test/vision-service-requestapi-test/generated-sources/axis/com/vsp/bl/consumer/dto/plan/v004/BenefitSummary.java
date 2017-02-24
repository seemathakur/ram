/**
 * BenefitSummary.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.consumer.dto.plan.v004;

public class BenefitSummary  extends com.vsp.il.base.v001.RootDTOObject  implements java.io.Serializable {
    private com.vsp.bl.consumer.dto.plan.v002.COBExclusion[] cobExclusions;

    private com.vsp.xl.dto.v002.Date windDownDate;

    private com.vsp.bl.consumer.dto.plan.v002.CommentCode[] commentCodes;

    private java.lang.Boolean fedCOB;

    private com.vsp.bl.consumer.dto.plan.v002.AllowanceSummary allowances;

    private com.vsp.bl.consumer.dto.plan.v004.CopaySummary copays;

    private com.vsp.bl.consumer.dto.plan.v002.Grid grid;

    private java.lang.String planNumber;

    private java.lang.String name;

    public BenefitSummary() {
    }

    public BenefitSummary(
           com.vsp.bl.consumer.dto.plan.v002.COBExclusion[] cobExclusions,
           com.vsp.xl.dto.v002.Date windDownDate,
           com.vsp.bl.consumer.dto.plan.v002.CommentCode[] commentCodes,
           java.lang.Boolean fedCOB,
           com.vsp.bl.consumer.dto.plan.v002.AllowanceSummary allowances,
           com.vsp.bl.consumer.dto.plan.v004.CopaySummary copays,
           com.vsp.bl.consumer.dto.plan.v002.Grid grid,
           java.lang.String planNumber,
           java.lang.String name) {
        this.cobExclusions = cobExclusions;
        this.windDownDate = windDownDate;
        this.commentCodes = commentCodes;
        this.fedCOB = fedCOB;
        this.allowances = allowances;
        this.copays = copays;
        this.grid = grid;
        this.planNumber = planNumber;
        this.name = name;
    }


    /**
     * Gets the cobExclusions value for this BenefitSummary.
     * 
     * @return cobExclusions
     */
    public com.vsp.bl.consumer.dto.plan.v002.COBExclusion[] getCobExclusions() {
        return cobExclusions;
    }


    /**
     * Sets the cobExclusions value for this BenefitSummary.
     * 
     * @param cobExclusions
     */
    public void setCobExclusions(com.vsp.bl.consumer.dto.plan.v002.COBExclusion[] cobExclusions) {
        this.cobExclusions = cobExclusions;
    }


    /**
     * Gets the windDownDate value for this BenefitSummary.
     * 
     * @return windDownDate
     */
    public com.vsp.xl.dto.v002.Date getWindDownDate() {
        return windDownDate;
    }


    /**
     * Sets the windDownDate value for this BenefitSummary.
     * 
     * @param windDownDate
     */
    public void setWindDownDate(com.vsp.xl.dto.v002.Date windDownDate) {
        this.windDownDate = windDownDate;
    }


    /**
     * Gets the commentCodes value for this BenefitSummary.
     * 
     * @return commentCodes
     */
    public com.vsp.bl.consumer.dto.plan.v002.CommentCode[] getCommentCodes() {
        return commentCodes;
    }


    /**
     * Sets the commentCodes value for this BenefitSummary.
     * 
     * @param commentCodes
     */
    public void setCommentCodes(com.vsp.bl.consumer.dto.plan.v002.CommentCode[] commentCodes) {
        this.commentCodes = commentCodes;
    }


    /**
     * Gets the fedCOB value for this BenefitSummary.
     * 
     * @return fedCOB
     */
    public java.lang.Boolean getFedCOB() {
        return fedCOB;
    }


    /**
     * Sets the fedCOB value for this BenefitSummary.
     * 
     * @param fedCOB
     */
    public void setFedCOB(java.lang.Boolean fedCOB) {
        this.fedCOB = fedCOB;
    }


    /**
     * Gets the allowances value for this BenefitSummary.
     * 
     * @return allowances
     */
    public com.vsp.bl.consumer.dto.plan.v002.AllowanceSummary getAllowances() {
        return allowances;
    }


    /**
     * Sets the allowances value for this BenefitSummary.
     * 
     * @param allowances
     */
    public void setAllowances(com.vsp.bl.consumer.dto.plan.v002.AllowanceSummary allowances) {
        this.allowances = allowances;
    }


    /**
     * Gets the copays value for this BenefitSummary.
     * 
     * @return copays
     */
    public com.vsp.bl.consumer.dto.plan.v004.CopaySummary getCopays() {
        return copays;
    }


    /**
     * Sets the copays value for this BenefitSummary.
     * 
     * @param copays
     */
    public void setCopays(com.vsp.bl.consumer.dto.plan.v004.CopaySummary copays) {
        this.copays = copays;
    }


    /**
     * Gets the grid value for this BenefitSummary.
     * 
     * @return grid
     */
    public com.vsp.bl.consumer.dto.plan.v002.Grid getGrid() {
        return grid;
    }


    /**
     * Sets the grid value for this BenefitSummary.
     * 
     * @param grid
     */
    public void setGrid(com.vsp.bl.consumer.dto.plan.v002.Grid grid) {
        this.grid = grid;
    }


    /**
     * Gets the planNumber value for this BenefitSummary.
     * 
     * @return planNumber
     */
    public java.lang.String getPlanNumber() {
        return planNumber;
    }


    /**
     * Sets the planNumber value for this BenefitSummary.
     * 
     * @param planNumber
     */
    public void setPlanNumber(java.lang.String planNumber) {
        this.planNumber = planNumber;
    }


    /**
     * Gets the name value for this BenefitSummary.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this BenefitSummary.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BenefitSummary)) return false;
        BenefitSummary other = (BenefitSummary) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cobExclusions==null && other.getCobExclusions()==null) || 
             (this.cobExclusions!=null &&
              java.util.Arrays.equals(this.cobExclusions, other.getCobExclusions()))) &&
            ((this.windDownDate==null && other.getWindDownDate()==null) || 
             (this.windDownDate!=null &&
              this.windDownDate.equals(other.getWindDownDate()))) &&
            ((this.commentCodes==null && other.getCommentCodes()==null) || 
             (this.commentCodes!=null &&
              java.util.Arrays.equals(this.commentCodes, other.getCommentCodes()))) &&
            ((this.fedCOB==null && other.getFedCOB()==null) || 
             (this.fedCOB!=null &&
              this.fedCOB.equals(other.getFedCOB()))) &&
            ((this.allowances==null && other.getAllowances()==null) || 
             (this.allowances!=null &&
              this.allowances.equals(other.getAllowances()))) &&
            ((this.copays==null && other.getCopays()==null) || 
             (this.copays!=null &&
              this.copays.equals(other.getCopays()))) &&
            ((this.grid==null && other.getGrid()==null) || 
             (this.grid!=null &&
              this.grid.equals(other.getGrid()))) &&
            ((this.planNumber==null && other.getPlanNumber()==null) || 
             (this.planNumber!=null &&
              this.planNumber.equals(other.getPlanNumber()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
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
        if (getCobExclusions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCobExclusions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCobExclusions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWindDownDate() != null) {
            _hashCode += getWindDownDate().hashCode();
        }
        if (getCommentCodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCommentCodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCommentCodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFedCOB() != null) {
            _hashCode += getFedCOB().hashCode();
        }
        if (getAllowances() != null) {
            _hashCode += getAllowances().hashCode();
        }
        if (getCopays() != null) {
            _hashCode += getCopays().hashCode();
        }
        if (getGrid() != null) {
            _hashCode += getGrid().hashCode();
        }
        if (getPlanNumber() != null) {
            _hashCode += getPlanNumber().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BenefitSummary.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v004.plan.dto.consumer.bl.vsp.com", "BenefitSummary"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cobExclusions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cobExclusions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "COBExclusion"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("windDownDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "windDownDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentCodes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commentCodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "CommentCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fedCOB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fedCOB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allowances");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allowances"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "AllowanceSummary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("copays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "copays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v004.plan.dto.consumer.bl.vsp.com", "CopaySummary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "grid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Grid"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("planNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "planNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
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

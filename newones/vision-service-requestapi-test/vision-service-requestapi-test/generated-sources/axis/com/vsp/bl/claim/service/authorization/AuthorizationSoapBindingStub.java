/**
 * AuthorizationSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public class AuthorizationSoapBindingStub extends org.apache.axis.client.Stub implements com.vsp.bl.claim.service.authorization.Authorization {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[9];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteAuthorizationForDoctor");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationForDoctorRequest"), com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationForDoctorResponse"));
        oper.setReturnClass(com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteAuthorizationForDoctorReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("holdAuthorization");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HoldAuthorizationRequest"), com.vsp.bl.claim.service.authorization.HoldAuthorizationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HoldAuthorizationResponse"));
        oper.setReturnClass(com.vsp.bl.claim.service.authorization.HoldAuthorizationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "holdAuthorizationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("denyAuthorization");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DenyAuthorizationRequest"), com.vsp.bl.claim.service.authorization.DenyAuthorizationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DenyAuthorizationResponse"));
        oper.setReturnClass(com.vsp.bl.claim.service.authorization.DenyAuthorizationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "denyAuthorizationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("hasAccess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HasAccessRequest"), com.vsp.bl.claim.service.authorization.HasAccessRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HasAccessResponse"));
        oper.setReturnClass(com.vsp.bl.claim.service.authorization.HasAccessResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "hasAccessReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteAuthorization");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationRequest"), com.vsp.bl.claim.service.authorization.DeleteAuthorizationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationResponse"));
        oper.setReturnClass(com.vsp.bl.claim.service.authorization.DeleteAuthorizationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteAuthorizationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("faxAuthorization");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "FaxAuthorizationRequest"), com.vsp.bl.claim.service.authorization.FaxAuthorizationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "FaxAuthorizationResponse"));
        oper.setReturnClass(com.vsp.bl.claim.service.authorization.FaxAuthorizationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "faxAuthorizationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("issueAuthorization");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "IssueAuthorizationRequest"), com.vsp.bl.claim.service.authorization.IssueAuthorizationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "IssueAuthorizationResponse"));
        oper.setReturnClass(com.vsp.bl.claim.service.authorization.IssueAuthorizationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "issueAuthorizationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("releaseAuthorization");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "ReleaseAuthorizationRequest"), com.vsp.bl.claim.service.authorization.ReleaseAuthorizationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "ReleaseAuthorizationResponse"));
        oper.setReturnClass(com.vsp.bl.claim.service.authorization.ReleaseAuthorizationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "releaseAuthorizationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateServices");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "UpdateServicesRequest"), com.vsp.bl.claim.service.authorization.UpdateServicesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "UpdateServicesResponse"));
        oper.setReturnClass(com.vsp.bl.claim.service.authorization.UpdateServicesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateServicesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

    }

    public AuthorizationSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AuthorizationSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AuthorizationSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "ArrayOf_459425844_1853898024_nillable_MemberKey");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.member.v001.MemberKey[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "ArrayOf_459425844_455905349_nillable_SimpleCode");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.SimpleCode[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationForDoctorRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationForDoctorResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.DeleteAuthorizationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DeleteAuthorizationResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.DeleteAuthorizationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DenyAuthorizationRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.DenyAuthorizationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "DenyAuthorizationResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.DenyAuthorizationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "FaxAuthorizationRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.FaxAuthorizationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "FaxAuthorizationResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.FaxAuthorizationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HasAccessRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.HasAccessRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HasAccessResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.HasAccessResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HoldAuthorizationRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.HoldAuthorizationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "HoldAuthorizationResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.HoldAuthorizationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "IssueAuthorizationRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.IssueAuthorizationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "IssueAuthorizationResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.IssueAuthorizationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "ReleaseAuthorizationRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.ReleaseAuthorizationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "ReleaseAuthorizationResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.ReleaseAuthorizationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "UpdateServicesRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.UpdateServicesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "UpdateServicesResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.service.authorization.UpdateServicesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.authorization.dto.claim.bl.vsp.com", "AuthorizationKey");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.claim.dto.authorization.v001.AuthorizationKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.base.il.vsp.com", "RootDTOObject");
            cachedSerQNames.add(qName);
            cls = com.vsp.il.base.v001.RootDTOObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "DiscountConstraint");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v001.DiscountConstraint.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "EarlyEligibility");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v001.EarlyEligibility.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "ExternalRule");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v001.ExternalRule.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "Frequency");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v001.Frequency.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "InterimBenefit");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v001.InterimBenefit.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "ProductItemRefinement");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v001.ProductItemRefinement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.coverageconstraint.dto.product.bl.vsp.com", "UnitCoverage");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v001.UnitCoverage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.dto.inventory.bl.vsp.com", "InventoryKey");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.inventory.dto.v001.InventoryKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.dto.xl.vsp.com", "TimePeriod");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v001.TimePeriod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.dto.xl.vsp.com", "TimeString");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v001.TimeString.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.helper.service.bl.vsp.com", "ArrayOf_889808838_1440052060_nillable_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v001.helper.service.bl.vsp.com", "ServiceMessage");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.service.helper.v001.ServiceMessage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.industry.dto.xl.vsp.com", "DiagnosticConditionKey");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.industry.v001.DiagnosticConditionKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.industry.dto.xl.vsp.com", "Prescription");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.industry.v001.Prescription.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.lenscharacteristic.dto.inventory.bl.vsp.com", "ContactLensCharacteristic");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.inventory.dto.lenscharacteristic.v001.ContactLensCharacteristic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "MemberKey");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.member.v001.MemberKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.member.dto.consumer.bl.vsp.com", "SubscriberKey");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.member.v001.SubscriberKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.personandcontact.dto.ancillary.bl.vsp.com", "Address");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.ancillary.dto.personandcontact.v001.Address.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.personandcontact.dto.ancillary.bl.vsp.com", "ContactChannel");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.ancillary.dto.personandcontact.v001.ContactChannel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.personandcontact.dto.ancillary.bl.vsp.com", "Name");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.ancillary.dto.personandcontact.v001.Name.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.service.bl.vsp.com", "ArrayOf_911774180_889808838_nillable_ServiceMessage");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.service.helper.v001.ServiceMessage[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v001.helper.service.bl.vsp.com", "ServiceMessage");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v001.service.bl.vsp.com", "ServiceRequest");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.service.v001.ServiceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v001.service.bl.vsp.com", "ServiceResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.service.v001.ServiceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.cob.dto.product.bl.vsp.com", "ArrayOf_725974552_1692648310_nillable_PatientRelationship");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.PatientRelationship[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PatientRelationship");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.cob.dto.product.bl.vsp.com", "ArrayOf_725974552_455905349_nillable_SimpleCode");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.SimpleCode[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.cob.dto.product.bl.vsp.com", "COBExceptionRule");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.cob.v002.COBExceptionRule.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ArrayOf_1692648310_132185849_nillable_CoverageConstraint");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoverageConstraint");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ArrayOf_1692648310_418642059_nillable_DiscountConstraint");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v001.DiscountConstraint[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v001.coverage.dto.product.bl.vsp.com", "DiscountConstraint");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ArrayOfContributionSource");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.ContributionSource[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ContributionSource");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ArrayOfPrescriptionConstraint");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.PrescriptionConstraint[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PrescriptionConstraint");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ArrayOfProductItem");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.ProductItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItem");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "CombinedProductItem");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.CombinedProductItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "Condition");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.Condition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ContributionSource");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.ContributionSource.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "Discount");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.Discount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "FrequencyChange");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.FrequencyChange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PatientRelationship");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.PatientRelationship.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PatientService");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.PatientService.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PrescriptionConstraint");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.PrescriptionConstraint.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItem");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.ProductItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItemAuthorization");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.ProductItemAuthorization.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "Replace");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.Replace.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "AbsorptionLevel");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.AbsorptionLevel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ArrayOf_132185849_1692648310_nillable_Condition");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.Condition[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "Condition");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ArrayOf_132185849_39001852_nillable_InventoryKey");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.inventory.dto.v001.InventoryKey[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v001.dto.inventory.bl.vsp.com", "InventoryKey");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ArrayOf_132185849_455905349_nillable_SimpleCode");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.SimpleCode[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ArrayOf_132185849_648270224_nillable_ProductItemIncludeExclude");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.v002.ProductItemIncludeExclude[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductItemIncludeExclude");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ArrayOfConstraintType");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.ConstraintType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ConstraintType");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ArrayOfPatientHistoryConstraint");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.PatientHistoryConstraint[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "PatientHistoryConstraint");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "Color");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.Color.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "ConstraintType");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.ConstraintType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoPay");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.CoPay.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CostControlled");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.CostControlled.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "CoverageConstraint");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.CoverageConstraint.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "Deductible");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.Deductible.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "InventoryInLieuOf");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.InventoryInLieuOf.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "OutOfPocketMax");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.OutOfPocketMax.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.coverageconstraint.dto.product.bl.vsp.com", "PatientHistoryConstraint");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverageconstraint.v002.PatientHistoryConstraint.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.network.bl.vsp.com", "NetworkKey");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.network.dto.v002.NetworkKey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ArrayOf_648270224_1692648310_nillable_CombinedProductItem");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.CombinedProductItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "CombinedProductItem");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ArrayOf_648270224_1692648310_nillable_PatientRelationship");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.PatientRelationship[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "PatientRelationship");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ArrayOf_648270224_1692648310_nillable_ProductItem");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.coverage.v002.ProductItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.coverage.dto.product.bl.vsp.com", "ProductItem");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ArrayOf_648270224_39001852_nillable_InventoryKey");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.inventory.dto.v001.InventoryKey[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v001.dto.inventory.bl.vsp.com", "InventoryKey");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ArrayOf_648270224_725974552_nillable_COBExceptionRule");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.cob.v002.COBExceptionRule[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.cob.dto.product.bl.vsp.com", "COBExceptionRule");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ArrayOfProductPackageInLieuOf");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.v002.ProductPackageInLieuOf[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductPackageInLieuOf");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "EligibilityRequirement");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.v002.EligibilityRequirement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductItemIncludeExclude");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.v002.ProductItemIncludeExclude.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductPackage");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.v002.ProductPackage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.product.bl.vsp.com", "ProductPackageInLieuOf");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.v002.ProductPackageInLieuOf.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "Date");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.Date.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "DatePeriod");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.DatePeriod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "DayInYear");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.DayInYear.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "EntityDTO");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.EntityDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "IdentifiableDTO");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.IdentifiableDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "RequirementChoice");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.RequirementChoice.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.dto.xl.vsp.com", "SimpleCode");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v002.SimpleCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.lenscharacteristic.dto.inventory.bl.vsp.com", "LensCharacteristic");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.inventory.dto.lenscharacteristic.v002.LensCharacteristic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.lenscharacteristic.dto.inventory.bl.vsp.com", "SegmentedMultifocalDTO");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.inventory.dto.lenscharacteristic.v002.SegmentedMultifocalDTO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://v002.levelofcoverage.dto.product.bl.vsp.com", "AllowanceScheduleEntry");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.levelofcoverage.v002.AllowanceScheduleEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.levelofcoverage.dto.product.bl.vsp.com", "ArrayOfAllowanceScheduleEntry");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.levelofcoverage.v002.AllowanceScheduleEntry[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.levelofcoverage.dto.product.bl.vsp.com", "AllowanceScheduleEntry");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.levelofcoverage.dto.product.bl.vsp.com", "LevelOfCoverage");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.levelofcoverage.v002.LevelOfCoverage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Allowance");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v002.Allowance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "AllowanceSummary");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v002.AllowanceSummary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "COBExclusion");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v002.COBExclusion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "CommentCode");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v002.CommentCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Copay");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v002.Copay.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "Grid");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v002.Grid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "GridValue");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v002.GridValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "ArrayOfRateDiscount");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.rate.v002.RateDiscount[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "RateDiscount");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "ASP");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.rate.v002.ASP.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "CompositeRate");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.rate.v002.CompositeRate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.rate.dto.product.bl.vsp.com", "RateDiscount");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.rate.v002.RateDiscount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.relationshipservice.dto.product.bl.vsp.com", "Commission");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.product.dto.relationshipservice.v002.Commission.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v002.service.bl.vsp.com", "ArrayOf_1320598405_889808838_nillable_ServiceMessage");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.service.helper.v001.ServiceMessage[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v001.helper.service.bl.vsp.com", "ServiceMessage");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v002.service.bl.vsp.com", "ServiceResponse");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.service.v002.ServiceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "CurrencyValue");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v003.CurrencyValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v003.dto.xl.vsp.com", "IntegerRange");
            cachedSerQNames.add(qName);
            cls = com.vsp.xl.dto.v003.IntegerRange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ArrayOfProvidedItem");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.ProvidedItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ProvidedItem");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ArrayOfServiceCategory");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.ServiceCategory[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceCategory");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ArrayOfServiceILOInfo");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.ServiceILOInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceILOInfo");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ArrayOfServiceRuleConstant");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.ServiceRuleConstant[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceRuleConstant");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "EligibilityProductItem");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.EligibilityProductItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "PatientHistory");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.PatientHistory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "PlanServiceDetail");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.PlanServiceDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ProvidedItem");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.ProvidedItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceCategory");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.ServiceCategory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceILOInfo");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.ServiceILOInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "ServiceRuleConstant");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.ServiceRuleConstant.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v004.plan.dto.consumer.bl.vsp.com", "ArrayOf_666080644_643448390_nillable_COBExclusion");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v002.COBExclusion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "COBExclusion");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v004.plan.dto.consumer.bl.vsp.com", "ArrayOf_666080644_643448390_nillable_CommentCode");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v002.CommentCode[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v002.plan.dto.consumer.bl.vsp.com", "CommentCode");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v004.plan.dto.consumer.bl.vsp.com", "BenefitSummary");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v004.BenefitSummary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v004.plan.dto.consumer.bl.vsp.com", "CopaySummary");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.plan.v004.CopaySummary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "ArrayOf_1151966355_1440052060_nillable_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "ArrayOf_1151966355_1481732116_nillable_PlanServiceDetail");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.PlanServiceDetail[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "PlanServiceDetail");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "ArrayOfPlanServiceBenefit");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v005.PlanServiceBenefit[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "PlanServiceBenefit");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "EligibilityPlanServiceDetail");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v005.EligibilityPlanServiceDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v005.eligibility.dto.consumer.bl.vsp.com", "PlanServiceBenefit");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v005.PlanServiceBenefit.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v006.eligibility.dto.consumer.bl.vsp.com", "ArrayOf_822200594_1481732116_nillable_EligibilityProductItem");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.EligibilityProductItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "EligibilityProductItem");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v006.eligibility.dto.consumer.bl.vsp.com", "ArrayOf_822200594_1481732116_nillable_PatientHistory");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v004.PatientHistory[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v004.eligibility.dto.consumer.bl.vsp.com", "PatientHistory");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v006.eligibility.dto.consumer.bl.vsp.com", "EligibilityProductPackage");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v006.EligibilityProductPackage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v007.eligibility.dto.consumer.bl.vsp.com", "ArrayOf_492434833_822200594_nillable_EligibilityProductPackage");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v006.EligibilityProductPackage[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v006.eligibility.dto.consumer.bl.vsp.com", "EligibilityProductPackage");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v007.eligibility.dto.consumer.bl.vsp.com", "MemberEligibility");
            cachedSerQNames.add(qName);
            cls = com.vsp.bl.consumer.dto.eligibility.v007.MemberEligibility.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorResponse deleteAuthorizationForDoctor(com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("deleteAuthorizationForDoctor");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "deleteAuthorizationForDoctor"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.vsp.bl.claim.service.authorization.HoldAuthorizationResponse holdAuthorization(com.vsp.bl.claim.service.authorization.HoldAuthorizationRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("holdAuthorization");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "holdAuthorization"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.vsp.bl.claim.service.authorization.HoldAuthorizationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.vsp.bl.claim.service.authorization.HoldAuthorizationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.vsp.bl.claim.service.authorization.HoldAuthorizationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.vsp.bl.claim.service.authorization.DenyAuthorizationResponse denyAuthorization(com.vsp.bl.claim.service.authorization.DenyAuthorizationRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("denyAuthorization");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "denyAuthorization"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.vsp.bl.claim.service.authorization.DenyAuthorizationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.vsp.bl.claim.service.authorization.DenyAuthorizationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.vsp.bl.claim.service.authorization.DenyAuthorizationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.vsp.bl.claim.service.authorization.HasAccessResponse hasAccess(com.vsp.bl.claim.service.authorization.HasAccessRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("hasAccess");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "hasAccess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.vsp.bl.claim.service.authorization.HasAccessResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.vsp.bl.claim.service.authorization.HasAccessResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.vsp.bl.claim.service.authorization.HasAccessResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.vsp.bl.claim.service.authorization.DeleteAuthorizationResponse deleteAuthorization(com.vsp.bl.claim.service.authorization.DeleteAuthorizationRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("deleteAuthorization");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "deleteAuthorization"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.vsp.bl.claim.service.authorization.DeleteAuthorizationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.vsp.bl.claim.service.authorization.DeleteAuthorizationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.vsp.bl.claim.service.authorization.DeleteAuthorizationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.vsp.bl.claim.service.authorization.FaxAuthorizationResponse faxAuthorization(com.vsp.bl.claim.service.authorization.FaxAuthorizationRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("faxAuthorization");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "faxAuthorization"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.vsp.bl.claim.service.authorization.FaxAuthorizationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.vsp.bl.claim.service.authorization.FaxAuthorizationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.vsp.bl.claim.service.authorization.FaxAuthorizationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.vsp.bl.claim.service.authorization.IssueAuthorizationResponse issueAuthorization(com.vsp.bl.claim.service.authorization.IssueAuthorizationRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("issueAuthorization");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "issueAuthorization"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.vsp.bl.claim.service.authorization.IssueAuthorizationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.vsp.bl.claim.service.authorization.IssueAuthorizationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.vsp.bl.claim.service.authorization.IssueAuthorizationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.vsp.bl.claim.service.authorization.ReleaseAuthorizationResponse releaseAuthorization(com.vsp.bl.claim.service.authorization.ReleaseAuthorizationRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("releaseAuthorization");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "releaseAuthorization"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.vsp.bl.claim.service.authorization.ReleaseAuthorizationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.vsp.bl.claim.service.authorization.ReleaseAuthorizationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.vsp.bl.claim.service.authorization.ReleaseAuthorizationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.vsp.bl.claim.service.authorization.UpdateServicesResponse updateServices(com.vsp.bl.claim.service.authorization.UpdateServicesRequest request) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("updateServices");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://authorization.service.claim.bl.vsp.com", "updateServices"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.vsp.bl.claim.service.authorization.UpdateServicesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.vsp.bl.claim.service.authorization.UpdateServicesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.vsp.bl.claim.service.authorization.UpdateServicesResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}

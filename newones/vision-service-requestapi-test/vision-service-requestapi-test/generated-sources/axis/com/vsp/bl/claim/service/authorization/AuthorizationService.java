/**
 * AuthorizationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public interface AuthorizationService extends javax.xml.rpc.Service {
    public java.lang.String getAuthorizationAddress();

    public com.vsp.bl.claim.service.authorization.Authorization getAuthorization() throws javax.xml.rpc.ServiceException;

    public com.vsp.bl.claim.service.authorization.Authorization getAuthorization(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

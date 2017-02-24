/**
 * Authorization.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.vsp.bl.claim.service.authorization;

public interface Authorization extends java.rmi.Remote {
    public com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorResponse deleteAuthorizationForDoctor(com.vsp.bl.claim.service.authorization.DeleteAuthorizationForDoctorRequest request) throws java.rmi.RemoteException;
    public com.vsp.bl.claim.service.authorization.HoldAuthorizationResponse holdAuthorization(com.vsp.bl.claim.service.authorization.HoldAuthorizationRequest request) throws java.rmi.RemoteException;
    public com.vsp.bl.claim.service.authorization.DenyAuthorizationResponse denyAuthorization(com.vsp.bl.claim.service.authorization.DenyAuthorizationRequest request) throws java.rmi.RemoteException;
    public com.vsp.bl.claim.service.authorization.HasAccessResponse hasAccess(com.vsp.bl.claim.service.authorization.HasAccessRequest request) throws java.rmi.RemoteException;
    public com.vsp.bl.claim.service.authorization.DeleteAuthorizationResponse deleteAuthorization(com.vsp.bl.claim.service.authorization.DeleteAuthorizationRequest request) throws java.rmi.RemoteException;
    public com.vsp.bl.claim.service.authorization.FaxAuthorizationResponse faxAuthorization(com.vsp.bl.claim.service.authorization.FaxAuthorizationRequest request) throws java.rmi.RemoteException;
    public com.vsp.bl.claim.service.authorization.IssueAuthorizationResponse issueAuthorization(com.vsp.bl.claim.service.authorization.IssueAuthorizationRequest request) throws java.rmi.RemoteException;
    public com.vsp.bl.claim.service.authorization.ReleaseAuthorizationResponse releaseAuthorization(com.vsp.bl.claim.service.authorization.ReleaseAuthorizationRequest request) throws java.rmi.RemoteException;
    public com.vsp.bl.claim.service.authorization.UpdateServicesResponse updateServices(com.vsp.bl.claim.service.authorization.UpdateServicesRequest request) throws java.rmi.RemoteException;
}

/**
 * IService1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public interface IService1 extends java.rmi.Remote {
    public ru.gbuac.jaxws.basereg.DocumentResponse getData(ru.gbuac.jaxws.basereg.DocumentRequest request) throws java.rmi.RemoteException;
    public ru.gbuac.jaxws.basereg.DocumentResponse getDocument(ru.gbuac.jaxws.basereg.DocumentRequest request) throws java.rmi.RemoteException;
    public ru.gbuac.jaxws.basereg.GetChangesResponse getChanges(ru.gbuac.jaxws.basereg.BaseRequest request) throws java.rmi.RemoteException;
    public ru.gbuac.jaxws.basereg.BaseResponse documentReceived(ru.gbuac.jaxws.basereg.DocumentReceivedRequest request) throws java.rmi.RemoteException;
    public ru.gbuac.jaxws.basereg.GetFileResponse getFile(ru.gbuac.jaxws.basereg.GetFileRequest request) throws java.rmi.RemoteException;
    public ru.gbuac.jaxws.basereg.CreateDocumentResponse createDocument(ru.gbuac.jaxws.basereg.CreateDocumentRequest req) throws java.rmi.RemoteException;
}

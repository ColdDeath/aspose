/**
 * Service1TestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

import java.util.Calendar;

public class Service1TestCase extends junit.framework.TestCase {
    private String serviceUri;

    public Service1TestCase(java.lang.String name) {
        super(name);
        this.serviceUri = "http://10.159.18.21:8021/BRRemoteService/Service1.svc";
    }

    public void testBasicHttpBinding_IService1WSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new ru.gbuac.jaxws.basereg.Service1Locator(serviceUri).getBasicHttpBinding_IService1Address() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new ru.gbuac.jaxws.basereg.Service1Locator(serviceUri).getServiceName());
        assertTrue(service != null);
    }

    public void test1BasicHttpBinding_IService1GetData() throws Exception {
        ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub binding;
        try {
            binding = (ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub)
                          new ru.gbuac.jaxws.basereg.Service1Locator(serviceUri).getBasicHttpBinding_IService1();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        ru.gbuac.jaxws.basereg.DocumentResponse value = null;
        value = binding.getData(new ru.gbuac.jaxws.basereg.DocumentRequest());
        // TBD - validate results
    }

    public void test2BasicHttpBinding_IService1GetDocument() throws Exception {
        ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub binding;
        try {
            binding = (ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub)
                          new ru.gbuac.jaxws.basereg.Service1Locator(serviceUri).getBasicHttpBinding_IService1();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        ru.gbuac.jaxws.basereg.DocumentResponse value = null;
        value = binding.getDocument(new ru.gbuac.jaxws.basereg.DocumentRequest());
        // TBD - validate results
    }

    public void test3BasicHttpBinding_IService1GetChanges() throws Exception {
        ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub binding;
        try {
            binding = (ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub)
                          new ru.gbuac.jaxws.basereg.Service1Locator(serviceUri).getBasicHttpBinding_IService1();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        ru.gbuac.jaxws.basereg.GetChangesResponse value = null;
        value = binding.getChanges(new ru.gbuac.jaxws.basereg.BaseRequest());
        // TBD - validate results
    }

    public void test4BasicHttpBinding_IService1DocumentReceived() throws Exception {
        ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub binding;
        try {
            binding = (ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub)
                          new ru.gbuac.jaxws.basereg.Service1Locator(serviceUri).getBasicHttpBinding_IService1();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        ru.gbuac.jaxws.basereg.BaseResponse value = null;
        value = binding.documentReceived(new ru.gbuac.jaxws.basereg.DocumentReceivedRequest());
        // TBD - validate results
    }

    public void test5BasicHttpBinding_IService1GetFile() throws Exception {
        ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub binding;
        try {
            binding = (ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub)
                          new ru.gbuac.jaxws.basereg.Service1Locator(serviceUri).getBasicHttpBinding_IService1();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        ru.gbuac.jaxws.basereg.GetFileResponse value = null;
        value = binding.getFile(new ru.gbuac.jaxws.basereg.GetFileRequest());
        // TBD - validate results
    }

    public void test6BasicHttpBinding_IService1CreateDocument() throws Exception {
        ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub binding;
        try {
            binding = (ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub)
                          new ru.gbuac.jaxws.basereg.Service1Locator(serviceUri).getBasicHttpBinding_IService1();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        ru.gbuac.jaxws.basereg.CreateDocumentResponse value = null;
        CreateDocumentFile[] files = {
                new CreateDocumentFile("Тестовая повестка № от ...", new byte[1], "test.pdf", null)
        };
        value = binding.createDocument(new ru.gbuac.jaxws.basereg.
                CreateDocumentRequest(Calendar.getInstance(), null, files, null, null,
                null, "Заместитель руководителя", "Федоров П.Д.",
                "Департамент экономической политики и развития города Москвы", "135d2a0b-dd6c-4d56-be6d-dc9e399c9621",
                null, null, null, "Test", 2881));
        System.out.println(value.getStatus());
        for (Integer fileId : value.getFilesId()) {
            System.out.println(fileId);
        }
        // TBD - validate results
    }

}

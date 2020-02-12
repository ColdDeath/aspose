/**
 * GetFileResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class GetFileResponse  extends ru.gbuac.jaxws.basereg.BaseResponse  implements java.io.Serializable {
    private java.lang.Integer ID_DOC;

    private java.lang.Integer ID_FILE;

    private byte[] fileBytes;

    private java.lang.String fileName;

    private byte[] fileSig;

    public GetFileResponse() {
    }

    public GetFileResponse(
           java.lang.Boolean error,
           java.lang.String message,
           java.lang.Integer ID_DOC,
           java.lang.Integer ID_FILE,
           byte[] fileBytes,
           java.lang.String fileName,
           byte[] fileSig) {
        super(
            error,
            message);
        this.ID_DOC = ID_DOC;
        this.ID_FILE = ID_FILE;
        this.fileBytes = fileBytes;
        this.fileName = fileName;
        this.fileSig = fileSig;
    }


    /**
     * Gets the ID_DOC value for this GetFileResponse.
     * 
     * @return ID_DOC
     */
    public java.lang.Integer getID_DOC() {
        return ID_DOC;
    }


    /**
     * Sets the ID_DOC value for this GetFileResponse.
     * 
     * @param ID_DOC
     */
    public void setID_DOC(java.lang.Integer ID_DOC) {
        this.ID_DOC = ID_DOC;
    }


    /**
     * Gets the ID_FILE value for this GetFileResponse.
     * 
     * @return ID_FILE
     */
    public java.lang.Integer getID_FILE() {
        return ID_FILE;
    }


    /**
     * Sets the ID_FILE value for this GetFileResponse.
     * 
     * @param ID_FILE
     */
    public void setID_FILE(java.lang.Integer ID_FILE) {
        this.ID_FILE = ID_FILE;
    }


    /**
     * Gets the fileBytes value for this GetFileResponse.
     * 
     * @return fileBytes
     */
    public byte[] getFileBytes() {
        return fileBytes;
    }


    /**
     * Sets the fileBytes value for this GetFileResponse.
     * 
     * @param fileBytes
     */
    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }


    /**
     * Gets the fileName value for this GetFileResponse.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this GetFileResponse.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the fileSig value for this GetFileResponse.
     * 
     * @return fileSig
     */
    public byte[] getFileSig() {
        return fileSig;
    }


    /**
     * Sets the fileSig value for this GetFileResponse.
     * 
     * @param fileSig
     */
    public void setFileSig(byte[] fileSig) {
        this.fileSig = fileSig;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetFileResponse)) return false;
        GetFileResponse other = (GetFileResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.ID_DOC==null && other.getID_DOC()==null) || 
             (this.ID_DOC!=null &&
              this.ID_DOC.equals(other.getID_DOC()))) &&
            ((this.ID_FILE==null && other.getID_FILE()==null) || 
             (this.ID_FILE!=null &&
              this.ID_FILE.equals(other.getID_FILE()))) &&
            ((this.fileBytes==null && other.getFileBytes()==null) || 
             (this.fileBytes!=null &&
              java.util.Arrays.equals(this.fileBytes, other.getFileBytes()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.fileSig==null && other.getFileSig()==null) || 
             (this.fileSig!=null &&
              java.util.Arrays.equals(this.fileSig, other.getFileSig())));
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
        if (getID_DOC() != null) {
            _hashCode += getID_DOC().hashCode();
        }
        if (getID_FILE() != null) {
            _hashCode += getID_FILE().hashCode();
        }
        if (getFileBytes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileBytes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFileBytes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getFileSig() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFileSig());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFileSig(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetFileResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "GetFileResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_DOC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ID_DOC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_FILE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ID_FILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileBytes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "fileBytes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "fileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileSig");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "fileSig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
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

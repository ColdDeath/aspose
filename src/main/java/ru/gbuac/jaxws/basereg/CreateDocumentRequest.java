/**
 * CreateDocumentRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class CreateDocumentRequest  implements java.io.Serializable {
    private java.util.Calendar DATA_REGIS;

    private ru.gbuac.jaxws.basereg.CreateDocumentCID[] DOCUMENT_CID;

    private ru.gbuac.jaxws.basereg.CreateDocumentFile[] DOCUMENT_FILES;

    private ru.gbuac.jaxws.basereg.CreateDocumentObject[] DOCUMENT_OBJECT;

    private ru.gbuac.jaxws.basereg.CreateDocumentSubject[] DOCUMENT_SUBJECTS;

    private ru.gbuac.jaxws.basereg.DocStatus DOC_STATUS;

    private java.lang.String DOLG_PODPISANT;

    private java.lang.String FIO_PODPISANT;

    private java.lang.String ISSUER;

    private java.lang.String ORG_GUID;

    private java.util.Calendar p_DATA_REGIS;

    private java.lang.String p_REGISTR_N;

    private java.lang.Integer p_TYPE_DOCUMENT;

    private java.lang.String REGISTR_N;

    private java.lang.Integer TYPE_DOCUMENT;

    public CreateDocumentRequest() {
    }

    public CreateDocumentRequest(
            java.util.Calendar DATA_REGIS,
            java.lang.String ORG_GUID,
            java.lang.String REGISTR_N,
            java.lang.Integer TYPE_DOCUMENT,
            ru.gbuac.jaxws.basereg.CreateDocumentFile[] DOCUMENT_FILES) {
        this.DATA_REGIS = DATA_REGIS;
        this.ORG_GUID = ORG_GUID;
        this.REGISTR_N = REGISTR_N;
        this.TYPE_DOCUMENT = TYPE_DOCUMENT;
        this.DOCUMENT_FILES = DOCUMENT_FILES;
    }

    public CreateDocumentRequest(
           java.util.Calendar DATA_REGIS,
           ru.gbuac.jaxws.basereg.CreateDocumentCID[] DOCUMENT_CID,
           ru.gbuac.jaxws.basereg.CreateDocumentFile[] DOCUMENT_FILES,
           ru.gbuac.jaxws.basereg.CreateDocumentObject[] DOCUMENT_OBJECT,
           ru.gbuac.jaxws.basereg.CreateDocumentSubject[] DOCUMENT_SUBJECTS,
           ru.gbuac.jaxws.basereg.DocStatus DOC_STATUS,
           java.lang.String DOLG_PODPISANT,
           java.lang.String FIO_PODPISANT,
           java.lang.String ISSUER,
           java.lang.String ORG_GUID,
           java.util.Calendar p_DATA_REGIS,
           java.lang.String p_REGISTR_N,
           java.lang.Integer p_TYPE_DOCUMENT,
           java.lang.String REGISTR_N,
           java.lang.Integer TYPE_DOCUMENT) {
           this.DATA_REGIS = DATA_REGIS;
           this.DOCUMENT_CID = DOCUMENT_CID;
           this.DOCUMENT_FILES = DOCUMENT_FILES;
           this.DOCUMENT_OBJECT = DOCUMENT_OBJECT;
           this.DOCUMENT_SUBJECTS = DOCUMENT_SUBJECTS;
           this.DOC_STATUS = DOC_STATUS;
           this.DOLG_PODPISANT = DOLG_PODPISANT;
           this.FIO_PODPISANT = FIO_PODPISANT;
           this.ISSUER = ISSUER;
           this.ORG_GUID = ORG_GUID;
           this.p_DATA_REGIS = p_DATA_REGIS;
           this.p_REGISTR_N = p_REGISTR_N;
           this.p_TYPE_DOCUMENT = p_TYPE_DOCUMENT;
           this.REGISTR_N = REGISTR_N;
           this.TYPE_DOCUMENT = TYPE_DOCUMENT;
    }


    /**
     * Gets the DATA_REGIS value for this CreateDocumentRequest.
     * 
     * @return DATA_REGIS
     */
    public java.util.Calendar getDATA_REGIS() {
        return DATA_REGIS;
    }


    /**
     * Sets the DATA_REGIS value for this CreateDocumentRequest.
     * 
     * @param DATA_REGIS
     */
    public void setDATA_REGIS(java.util.Calendar DATA_REGIS) {
        this.DATA_REGIS = DATA_REGIS;
    }


    /**
     * Gets the DOCUMENT_CID value for this CreateDocumentRequest.
     * 
     * @return DOCUMENT_CID
     */
    public ru.gbuac.jaxws.basereg.CreateDocumentCID[] getDOCUMENT_CID() {
        return DOCUMENT_CID;
    }


    /**
     * Sets the DOCUMENT_CID value for this CreateDocumentRequest.
     * 
     * @param DOCUMENT_CID
     */
    public void setDOCUMENT_CID(ru.gbuac.jaxws.basereg.CreateDocumentCID[] DOCUMENT_CID) {
        this.DOCUMENT_CID = DOCUMENT_CID;
    }


    /**
     * Gets the DOCUMENT_FILES value for this CreateDocumentRequest.
     * 
     * @return DOCUMENT_FILES
     */
    public ru.gbuac.jaxws.basereg.CreateDocumentFile[] getDOCUMENT_FILES() {
        return DOCUMENT_FILES;
    }


    /**
     * Sets the DOCUMENT_FILES value for this CreateDocumentRequest.
     * 
     * @param DOCUMENT_FILES
     */
    public void setDOCUMENT_FILES(ru.gbuac.jaxws.basereg.CreateDocumentFile[] DOCUMENT_FILES) {
        this.DOCUMENT_FILES = DOCUMENT_FILES;
    }


    /**
     * Gets the DOCUMENT_OBJECT value for this CreateDocumentRequest.
     * 
     * @return DOCUMENT_OBJECT
     */
    public ru.gbuac.jaxws.basereg.CreateDocumentObject[] getDOCUMENT_OBJECT() {
        return DOCUMENT_OBJECT;
    }


    /**
     * Sets the DOCUMENT_OBJECT value for this CreateDocumentRequest.
     * 
     * @param DOCUMENT_OBJECT
     */
    public void setDOCUMENT_OBJECT(ru.gbuac.jaxws.basereg.CreateDocumentObject[] DOCUMENT_OBJECT) {
        this.DOCUMENT_OBJECT = DOCUMENT_OBJECT;
    }


    /**
     * Gets the DOCUMENT_SUBJECTS value for this CreateDocumentRequest.
     * 
     * @return DOCUMENT_SUBJECTS
     */
    public ru.gbuac.jaxws.basereg.CreateDocumentSubject[] getDOCUMENT_SUBJECTS() {
        return DOCUMENT_SUBJECTS;
    }


    /**
     * Sets the DOCUMENT_SUBJECTS value for this CreateDocumentRequest.
     * 
     * @param DOCUMENT_SUBJECTS
     */
    public void setDOCUMENT_SUBJECTS(ru.gbuac.jaxws.basereg.CreateDocumentSubject[] DOCUMENT_SUBJECTS) {
        this.DOCUMENT_SUBJECTS = DOCUMENT_SUBJECTS;
    }


    /**
     * Gets the DOC_STATUS value for this CreateDocumentRequest.
     * 
     * @return DOC_STATUS
     */
    public ru.gbuac.jaxws.basereg.DocStatus getDOC_STATUS() {
        return DOC_STATUS;
    }


    /**
     * Sets the DOC_STATUS value for this CreateDocumentRequest.
     * 
     * @param DOC_STATUS
     */
    public void setDOC_STATUS(ru.gbuac.jaxws.basereg.DocStatus DOC_STATUS) {
        this.DOC_STATUS = DOC_STATUS;
    }


    /**
     * Gets the DOLG_PODPISANT value for this CreateDocumentRequest.
     * 
     * @return DOLG_PODPISANT
     */
    public java.lang.String getDOLG_PODPISANT() {
        return DOLG_PODPISANT;
    }


    /**
     * Sets the DOLG_PODPISANT value for this CreateDocumentRequest.
     * 
     * @param DOLG_PODPISANT
     */
    public void setDOLG_PODPISANT(java.lang.String DOLG_PODPISANT) {
        this.DOLG_PODPISANT = DOLG_PODPISANT;
    }


    /**
     * Gets the FIO_PODPISANT value for this CreateDocumentRequest.
     * 
     * @return FIO_PODPISANT
     */
    public java.lang.String getFIO_PODPISANT() {
        return FIO_PODPISANT;
    }


    /**
     * Sets the FIO_PODPISANT value for this CreateDocumentRequest.
     * 
     * @param FIO_PODPISANT
     */
    public void setFIO_PODPISANT(java.lang.String FIO_PODPISANT) {
        this.FIO_PODPISANT = FIO_PODPISANT;
    }


    /**
     * Gets the ISSUER value for this CreateDocumentRequest.
     * 
     * @return ISSUER
     */
    public java.lang.String getISSUER() {
        return ISSUER;
    }


    /**
     * Sets the ISSUER value for this CreateDocumentRequest.
     * 
     * @param ISSUER
     */
    public void setISSUER(java.lang.String ISSUER) {
        this.ISSUER = ISSUER;
    }


    /**
     * Gets the ORG_GUID value for this CreateDocumentRequest.
     * 
     * @return ORG_GUID
     */
    public java.lang.String getORG_GUID() {
        return ORG_GUID;
    }


    /**
     * Sets the ORG_GUID value for this CreateDocumentRequest.
     * 
     * @param ORG_GUID
     */
    public void setORG_GUID(java.lang.String ORG_GUID) {
        this.ORG_GUID = ORG_GUID;
    }


    /**
     * Gets the p_DATA_REGIS value for this CreateDocumentRequest.
     * 
     * @return p_DATA_REGIS
     */
    public java.util.Calendar getP_DATA_REGIS() {
        return p_DATA_REGIS;
    }


    /**
     * Sets the p_DATA_REGIS value for this CreateDocumentRequest.
     * 
     * @param p_DATA_REGIS
     */
    public void setP_DATA_REGIS(java.util.Calendar p_DATA_REGIS) {
        this.p_DATA_REGIS = p_DATA_REGIS;
    }


    /**
     * Gets the p_REGISTR_N value for this CreateDocumentRequest.
     * 
     * @return p_REGISTR_N
     */
    public java.lang.String getP_REGISTR_N() {
        return p_REGISTR_N;
    }


    /**
     * Sets the p_REGISTR_N value for this CreateDocumentRequest.
     * 
     * @param p_REGISTR_N
     */
    public void setP_REGISTR_N(java.lang.String p_REGISTR_N) {
        this.p_REGISTR_N = p_REGISTR_N;
    }


    /**
     * Gets the p_TYPE_DOCUMENT value for this CreateDocumentRequest.
     * 
     * @return p_TYPE_DOCUMENT
     */
    public java.lang.Integer getP_TYPE_DOCUMENT() {
        return p_TYPE_DOCUMENT;
    }


    /**
     * Sets the p_TYPE_DOCUMENT value for this CreateDocumentRequest.
     * 
     * @param p_TYPE_DOCUMENT
     */
    public void setP_TYPE_DOCUMENT(java.lang.Integer p_TYPE_DOCUMENT) {
        this.p_TYPE_DOCUMENT = p_TYPE_DOCUMENT;
    }


    /**
     * Gets the REGISTR_N value for this CreateDocumentRequest.
     * 
     * @return REGISTR_N
     */
    public java.lang.String getREGISTR_N() {
        return REGISTR_N;
    }


    /**
     * Sets the REGISTR_N value for this CreateDocumentRequest.
     * 
     * @param REGISTR_N
     */
    public void setREGISTR_N(java.lang.String REGISTR_N) {
        this.REGISTR_N = REGISTR_N;
    }


    /**
     * Gets the TYPE_DOCUMENT value for this CreateDocumentRequest.
     * 
     * @return TYPE_DOCUMENT
     */
    public java.lang.Integer getTYPE_DOCUMENT() {
        return TYPE_DOCUMENT;
    }


    /**
     * Sets the TYPE_DOCUMENT value for this CreateDocumentRequest.
     * 
     * @param TYPE_DOCUMENT
     */
    public void setTYPE_DOCUMENT(java.lang.Integer TYPE_DOCUMENT) {
        this.TYPE_DOCUMENT = TYPE_DOCUMENT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateDocumentRequest)) return false;
        CreateDocumentRequest other = (CreateDocumentRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATA_REGIS==null && other.getDATA_REGIS()==null) || 
             (this.DATA_REGIS!=null &&
              this.DATA_REGIS.equals(other.getDATA_REGIS()))) &&
            ((this.DOCUMENT_CID==null && other.getDOCUMENT_CID()==null) || 
             (this.DOCUMENT_CID!=null &&
              java.util.Arrays.equals(this.DOCUMENT_CID, other.getDOCUMENT_CID()))) &&
            ((this.DOCUMENT_FILES==null && other.getDOCUMENT_FILES()==null) || 
             (this.DOCUMENT_FILES!=null &&
              java.util.Arrays.equals(this.DOCUMENT_FILES, other.getDOCUMENT_FILES()))) &&
            ((this.DOCUMENT_OBJECT==null && other.getDOCUMENT_OBJECT()==null) || 
             (this.DOCUMENT_OBJECT!=null &&
              java.util.Arrays.equals(this.DOCUMENT_OBJECT, other.getDOCUMENT_OBJECT()))) &&
            ((this.DOCUMENT_SUBJECTS==null && other.getDOCUMENT_SUBJECTS()==null) || 
             (this.DOCUMENT_SUBJECTS!=null &&
              java.util.Arrays.equals(this.DOCUMENT_SUBJECTS, other.getDOCUMENT_SUBJECTS()))) &&
            ((this.DOC_STATUS==null && other.getDOC_STATUS()==null) || 
             (this.DOC_STATUS!=null &&
              this.DOC_STATUS.equals(other.getDOC_STATUS()))) &&
            ((this.DOLG_PODPISANT==null && other.getDOLG_PODPISANT()==null) || 
             (this.DOLG_PODPISANT!=null &&
              this.DOLG_PODPISANT.equals(other.getDOLG_PODPISANT()))) &&
            ((this.FIO_PODPISANT==null && other.getFIO_PODPISANT()==null) || 
             (this.FIO_PODPISANT!=null &&
              this.FIO_PODPISANT.equals(other.getFIO_PODPISANT()))) &&
            ((this.ISSUER==null && other.getISSUER()==null) || 
             (this.ISSUER!=null &&
              this.ISSUER.equals(other.getISSUER()))) &&
            ((this.ORG_GUID==null && other.getORG_GUID()==null) || 
             (this.ORG_GUID!=null &&
              this.ORG_GUID.equals(other.getORG_GUID()))) &&
            ((this.p_DATA_REGIS==null && other.getP_DATA_REGIS()==null) || 
             (this.p_DATA_REGIS!=null &&
              this.p_DATA_REGIS.equals(other.getP_DATA_REGIS()))) &&
            ((this.p_REGISTR_N==null && other.getP_REGISTR_N()==null) || 
             (this.p_REGISTR_N!=null &&
              this.p_REGISTR_N.equals(other.getP_REGISTR_N()))) &&
            ((this.p_TYPE_DOCUMENT==null && other.getP_TYPE_DOCUMENT()==null) || 
             (this.p_TYPE_DOCUMENT!=null &&
              this.p_TYPE_DOCUMENT.equals(other.getP_TYPE_DOCUMENT()))) &&
            ((this.REGISTR_N==null && other.getREGISTR_N()==null) || 
             (this.REGISTR_N!=null &&
              this.REGISTR_N.equals(other.getREGISTR_N()))) &&
            ((this.TYPE_DOCUMENT==null && other.getTYPE_DOCUMENT()==null) || 
             (this.TYPE_DOCUMENT!=null &&
              this.TYPE_DOCUMENT.equals(other.getTYPE_DOCUMENT())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDATA_REGIS() != null) {
            _hashCode += getDATA_REGIS().hashCode();
        }
        if (getDOCUMENT_CID() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDOCUMENT_CID());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDOCUMENT_CID(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDOCUMENT_FILES() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDOCUMENT_FILES());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDOCUMENT_FILES(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDOCUMENT_OBJECT() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDOCUMENT_OBJECT());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDOCUMENT_OBJECT(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDOCUMENT_SUBJECTS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDOCUMENT_SUBJECTS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDOCUMENT_SUBJECTS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDOC_STATUS() != null) {
            _hashCode += getDOC_STATUS().hashCode();
        }
        if (getDOLG_PODPISANT() != null) {
            _hashCode += getDOLG_PODPISANT().hashCode();
        }
        if (getFIO_PODPISANT() != null) {
            _hashCode += getFIO_PODPISANT().hashCode();
        }
        if (getISSUER() != null) {
            _hashCode += getISSUER().hashCode();
        }
        if (getORG_GUID() != null) {
            _hashCode += getORG_GUID().hashCode();
        }
        if (getP_DATA_REGIS() != null) {
            _hashCode += getP_DATA_REGIS().hashCode();
        }
        if (getP_REGISTR_N() != null) {
            _hashCode += getP_REGISTR_N().hashCode();
        }
        if (getP_TYPE_DOCUMENT() != null) {
            _hashCode += getP_TYPE_DOCUMENT().hashCode();
        }
        if (getREGISTR_N() != null) {
            _hashCode += getREGISTR_N().hashCode();
        }
        if (getTYPE_DOCUMENT() != null) {
            _hashCode += getTYPE_DOCUMENT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateDocumentRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_REGIS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "DATA_REGIS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCUMENT_CID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "DOCUMENT_CID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentCID"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentCID"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCUMENT_FILES");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "DOCUMENT_FILES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentFile"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentFile"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCUMENT_OBJECT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "DOCUMENT_OBJECT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentObject"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentObject"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCUMENT_SUBJECTS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "DOCUMENT_SUBJECTS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentSubject"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentSubject"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOC_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "DOC_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "DocStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOLG_PODPISANT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "DOLG_PODPISANT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FIO_PODPISANT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "FIO_PODPISANT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ISSUER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "ISSUER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ORG_GUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "ORG_GUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_DATA_REGIS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "P_DATA_REGIS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_REGISTR_N");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "P_REGISTR_N"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_TYPE_DOCUMENT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "P_TYPE_DOCUMENT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REGISTR_N");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "REGISTR_N"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TYPE_DOCUMENT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "TYPE_DOCUMENT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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

/**
 * GetChangesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class GetChangesResponse  extends ru.gbuac.jaxws.basereg.BaseResponse  implements java.io.Serializable {
    private java.lang.String CREATEDATE;

    private java.lang.String DATA_REGIS;

    private ru.gbuac.jaxws.basereg.ResponseCID[] DOCUMENT_CID;

    private ru.gbuac.jaxws.basereg.ResponseFiles[] DOCUMENT_FILES;

    private ru.gbuac.jaxws.basereg.ResponseObject[] DOCUMENT_OBJECT;

    private ru.gbuac.jaxws.basereg.ResponseSubject[] DOCUMENT_SUBJECTS;

    private java.lang.String DOLG_PODPISANT;

    private java.lang.String FIO_PODPISANT;

    private java.math.BigDecimal ID_DOCUMENTRES;

    private java.math.BigDecimal ID_PARENT;

    private java.lang.String ISSUER;

    private java.lang.String ORG_GUID;

    private java.lang.String REGISTR_N;

    private java.lang.String SIGNDATE;

    private java.math.BigDecimal STATUS;

    private java.lang.String TYPE_DOCUMENT;

    private java.lang.String TYPE_DOCUMENT2;

    private java.lang.String TYPE_DOCUMENT3;

    public GetChangesResponse() {
    }

    public GetChangesResponse(
           java.lang.Boolean error,
           java.lang.String message,
           java.lang.String CREATEDATE,
           java.lang.String DATA_REGIS,
           ru.gbuac.jaxws.basereg.ResponseCID[] DOCUMENT_CID,
           ru.gbuac.jaxws.basereg.ResponseFiles[] DOCUMENT_FILES,
           ru.gbuac.jaxws.basereg.ResponseObject[] DOCUMENT_OBJECT,
           ru.gbuac.jaxws.basereg.ResponseSubject[] DOCUMENT_SUBJECTS,
           java.lang.String DOLG_PODPISANT,
           java.lang.String FIO_PODPISANT,
           java.math.BigDecimal ID_DOCUMENTRES,
           java.math.BigDecimal ID_PARENT,
           java.lang.String ISSUER,
           java.lang.String ORG_GUID,
           java.lang.String REGISTR_N,
           java.lang.String SIGNDATE,
           java.math.BigDecimal STATUS,
           java.lang.String TYPE_DOCUMENT,
           java.lang.String TYPE_DOCUMENT2,
           java.lang.String TYPE_DOCUMENT3) {
        super(
            error,
            message);
        this.CREATEDATE = CREATEDATE;
        this.DATA_REGIS = DATA_REGIS;
        this.DOCUMENT_CID = DOCUMENT_CID;
        this.DOCUMENT_FILES = DOCUMENT_FILES;
        this.DOCUMENT_OBJECT = DOCUMENT_OBJECT;
        this.DOCUMENT_SUBJECTS = DOCUMENT_SUBJECTS;
        this.DOLG_PODPISANT = DOLG_PODPISANT;
        this.FIO_PODPISANT = FIO_PODPISANT;
        this.ID_DOCUMENTRES = ID_DOCUMENTRES;
        this.ID_PARENT = ID_PARENT;
        this.ISSUER = ISSUER;
        this.ORG_GUID = ORG_GUID;
        this.REGISTR_N = REGISTR_N;
        this.SIGNDATE = SIGNDATE;
        this.STATUS = STATUS;
        this.TYPE_DOCUMENT = TYPE_DOCUMENT;
        this.TYPE_DOCUMENT2 = TYPE_DOCUMENT2;
        this.TYPE_DOCUMENT3 = TYPE_DOCUMENT3;
    }


    /**
     * Gets the CREATEDATE value for this GetChangesResponse.
     * 
     * @return CREATEDATE
     */
    public java.lang.String getCREATEDATE() {
        return CREATEDATE;
    }


    /**
     * Sets the CREATEDATE value for this GetChangesResponse.
     * 
     * @param CREATEDATE
     */
    public void setCREATEDATE(java.lang.String CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }


    /**
     * Gets the DATA_REGIS value for this GetChangesResponse.
     * 
     * @return DATA_REGIS
     */
    public java.lang.String getDATA_REGIS() {
        return DATA_REGIS;
    }


    /**
     * Sets the DATA_REGIS value for this GetChangesResponse.
     * 
     * @param DATA_REGIS
     */
    public void setDATA_REGIS(java.lang.String DATA_REGIS) {
        this.DATA_REGIS = DATA_REGIS;
    }


    /**
     * Gets the DOCUMENT_CID value for this GetChangesResponse.
     * 
     * @return DOCUMENT_CID
     */
    public ru.gbuac.jaxws.basereg.ResponseCID[] getDOCUMENT_CID() {
        return DOCUMENT_CID;
    }


    /**
     * Sets the DOCUMENT_CID value for this GetChangesResponse.
     * 
     * @param DOCUMENT_CID
     */
    public void setDOCUMENT_CID(ru.gbuac.jaxws.basereg.ResponseCID[] DOCUMENT_CID) {
        this.DOCUMENT_CID = DOCUMENT_CID;
    }


    /**
     * Gets the DOCUMENT_FILES value for this GetChangesResponse.
     * 
     * @return DOCUMENT_FILES
     */
    public ru.gbuac.jaxws.basereg.ResponseFiles[] getDOCUMENT_FILES() {
        return DOCUMENT_FILES;
    }


    /**
     * Sets the DOCUMENT_FILES value for this GetChangesResponse.
     * 
     * @param DOCUMENT_FILES
     */
    public void setDOCUMENT_FILES(ru.gbuac.jaxws.basereg.ResponseFiles[] DOCUMENT_FILES) {
        this.DOCUMENT_FILES = DOCUMENT_FILES;
    }


    /**
     * Gets the DOCUMENT_OBJECT value for this GetChangesResponse.
     * 
     * @return DOCUMENT_OBJECT
     */
    public ru.gbuac.jaxws.basereg.ResponseObject[] getDOCUMENT_OBJECT() {
        return DOCUMENT_OBJECT;
    }


    /**
     * Sets the DOCUMENT_OBJECT value for this GetChangesResponse.
     * 
     * @param DOCUMENT_OBJECT
     */
    public void setDOCUMENT_OBJECT(ru.gbuac.jaxws.basereg.ResponseObject[] DOCUMENT_OBJECT) {
        this.DOCUMENT_OBJECT = DOCUMENT_OBJECT;
    }


    /**
     * Gets the DOCUMENT_SUBJECTS value for this GetChangesResponse.
     * 
     * @return DOCUMENT_SUBJECTS
     */
    public ru.gbuac.jaxws.basereg.ResponseSubject[] getDOCUMENT_SUBJECTS() {
        return DOCUMENT_SUBJECTS;
    }


    /**
     * Sets the DOCUMENT_SUBJECTS value for this GetChangesResponse.
     * 
     * @param DOCUMENT_SUBJECTS
     */
    public void setDOCUMENT_SUBJECTS(ru.gbuac.jaxws.basereg.ResponseSubject[] DOCUMENT_SUBJECTS) {
        this.DOCUMENT_SUBJECTS = DOCUMENT_SUBJECTS;
    }


    /**
     * Gets the DOLG_PODPISANT value for this GetChangesResponse.
     * 
     * @return DOLG_PODPISANT
     */
    public java.lang.String getDOLG_PODPISANT() {
        return DOLG_PODPISANT;
    }


    /**
     * Sets the DOLG_PODPISANT value for this GetChangesResponse.
     * 
     * @param DOLG_PODPISANT
     */
    public void setDOLG_PODPISANT(java.lang.String DOLG_PODPISANT) {
        this.DOLG_PODPISANT = DOLG_PODPISANT;
    }


    /**
     * Gets the FIO_PODPISANT value for this GetChangesResponse.
     * 
     * @return FIO_PODPISANT
     */
    public java.lang.String getFIO_PODPISANT() {
        return FIO_PODPISANT;
    }


    /**
     * Sets the FIO_PODPISANT value for this GetChangesResponse.
     * 
     * @param FIO_PODPISANT
     */
    public void setFIO_PODPISANT(java.lang.String FIO_PODPISANT) {
        this.FIO_PODPISANT = FIO_PODPISANT;
    }


    /**
     * Gets the ID_DOCUMENTRES value for this GetChangesResponse.
     * 
     * @return ID_DOCUMENTRES
     */
    public java.math.BigDecimal getID_DOCUMENTRES() {
        return ID_DOCUMENTRES;
    }


    /**
     * Sets the ID_DOCUMENTRES value for this GetChangesResponse.
     * 
     * @param ID_DOCUMENTRES
     */
    public void setID_DOCUMENTRES(java.math.BigDecimal ID_DOCUMENTRES) {
        this.ID_DOCUMENTRES = ID_DOCUMENTRES;
    }


    /**
     * Gets the ID_PARENT value for this GetChangesResponse.
     * 
     * @return ID_PARENT
     */
    public java.math.BigDecimal getID_PARENT() {
        return ID_PARENT;
    }


    /**
     * Sets the ID_PARENT value for this GetChangesResponse.
     * 
     * @param ID_PARENT
     */
    public void setID_PARENT(java.math.BigDecimal ID_PARENT) {
        this.ID_PARENT = ID_PARENT;
    }


    /**
     * Gets the ISSUER value for this GetChangesResponse.
     * 
     * @return ISSUER
     */
    public java.lang.String getISSUER() {
        return ISSUER;
    }


    /**
     * Sets the ISSUER value for this GetChangesResponse.
     * 
     * @param ISSUER
     */
    public void setISSUER(java.lang.String ISSUER) {
        this.ISSUER = ISSUER;
    }


    /**
     * Gets the ORG_GUID value for this GetChangesResponse.
     * 
     * @return ORG_GUID
     */
    public java.lang.String getORG_GUID() {
        return ORG_GUID;
    }


    /**
     * Sets the ORG_GUID value for this GetChangesResponse.
     * 
     * @param ORG_GUID
     */
    public void setORG_GUID(java.lang.String ORG_GUID) {
        this.ORG_GUID = ORG_GUID;
    }


    /**
     * Gets the REGISTR_N value for this GetChangesResponse.
     * 
     * @return REGISTR_N
     */
    public java.lang.String getREGISTR_N() {
        return REGISTR_N;
    }


    /**
     * Sets the REGISTR_N value for this GetChangesResponse.
     * 
     * @param REGISTR_N
     */
    public void setREGISTR_N(java.lang.String REGISTR_N) {
        this.REGISTR_N = REGISTR_N;
    }


    /**
     * Gets the SIGNDATE value for this GetChangesResponse.
     * 
     * @return SIGNDATE
     */
    public java.lang.String getSIGNDATE() {
        return SIGNDATE;
    }


    /**
     * Sets the SIGNDATE value for this GetChangesResponse.
     * 
     * @param SIGNDATE
     */
    public void setSIGNDATE(java.lang.String SIGNDATE) {
        this.SIGNDATE = SIGNDATE;
    }


    /**
     * Gets the STATUS value for this GetChangesResponse.
     * 
     * @return STATUS
     */
    public java.math.BigDecimal getSTATUS() {
        return STATUS;
    }


    /**
     * Sets the STATUS value for this GetChangesResponse.
     * 
     * @param STATUS
     */
    public void setSTATUS(java.math.BigDecimal STATUS) {
        this.STATUS = STATUS;
    }


    /**
     * Gets the TYPE_DOCUMENT value for this GetChangesResponse.
     * 
     * @return TYPE_DOCUMENT
     */
    public java.lang.String getTYPE_DOCUMENT() {
        return TYPE_DOCUMENT;
    }


    /**
     * Sets the TYPE_DOCUMENT value for this GetChangesResponse.
     * 
     * @param TYPE_DOCUMENT
     */
    public void setTYPE_DOCUMENT(java.lang.String TYPE_DOCUMENT) {
        this.TYPE_DOCUMENT = TYPE_DOCUMENT;
    }


    /**
     * Gets the TYPE_DOCUMENT2 value for this GetChangesResponse.
     * 
     * @return TYPE_DOCUMENT2
     */
    public java.lang.String getTYPE_DOCUMENT2() {
        return TYPE_DOCUMENT2;
    }


    /**
     * Sets the TYPE_DOCUMENT2 value for this GetChangesResponse.
     * 
     * @param TYPE_DOCUMENT2
     */
    public void setTYPE_DOCUMENT2(java.lang.String TYPE_DOCUMENT2) {
        this.TYPE_DOCUMENT2 = TYPE_DOCUMENT2;
    }


    /**
     * Gets the TYPE_DOCUMENT3 value for this GetChangesResponse.
     * 
     * @return TYPE_DOCUMENT3
     */
    public java.lang.String getTYPE_DOCUMENT3() {
        return TYPE_DOCUMENT3;
    }


    /**
     * Sets the TYPE_DOCUMENT3 value for this GetChangesResponse.
     * 
     * @param TYPE_DOCUMENT3
     */
    public void setTYPE_DOCUMENT3(java.lang.String TYPE_DOCUMENT3) {
        this.TYPE_DOCUMENT3 = TYPE_DOCUMENT3;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetChangesResponse)) return false;
        GetChangesResponse other = (GetChangesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.CREATEDATE==null && other.getCREATEDATE()==null) || 
             (this.CREATEDATE!=null &&
              this.CREATEDATE.equals(other.getCREATEDATE()))) &&
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
            ((this.DOLG_PODPISANT==null && other.getDOLG_PODPISANT()==null) || 
             (this.DOLG_PODPISANT!=null &&
              this.DOLG_PODPISANT.equals(other.getDOLG_PODPISANT()))) &&
            ((this.FIO_PODPISANT==null && other.getFIO_PODPISANT()==null) || 
             (this.FIO_PODPISANT!=null &&
              this.FIO_PODPISANT.equals(other.getFIO_PODPISANT()))) &&
            ((this.ID_DOCUMENTRES==null && other.getID_DOCUMENTRES()==null) || 
             (this.ID_DOCUMENTRES!=null &&
              this.ID_DOCUMENTRES.equals(other.getID_DOCUMENTRES()))) &&
            ((this.ID_PARENT==null && other.getID_PARENT()==null) || 
             (this.ID_PARENT!=null &&
              this.ID_PARENT.equals(other.getID_PARENT()))) &&
            ((this.ISSUER==null && other.getISSUER()==null) || 
             (this.ISSUER!=null &&
              this.ISSUER.equals(other.getISSUER()))) &&
            ((this.ORG_GUID==null && other.getORG_GUID()==null) || 
             (this.ORG_GUID!=null &&
              this.ORG_GUID.equals(other.getORG_GUID()))) &&
            ((this.REGISTR_N==null && other.getREGISTR_N()==null) || 
             (this.REGISTR_N!=null &&
              this.REGISTR_N.equals(other.getREGISTR_N()))) &&
            ((this.SIGNDATE==null && other.getSIGNDATE()==null) || 
             (this.SIGNDATE!=null &&
              this.SIGNDATE.equals(other.getSIGNDATE()))) &&
            ((this.STATUS==null && other.getSTATUS()==null) || 
             (this.STATUS!=null &&
              this.STATUS.equals(other.getSTATUS()))) &&
            ((this.TYPE_DOCUMENT==null && other.getTYPE_DOCUMENT()==null) || 
             (this.TYPE_DOCUMENT!=null &&
              this.TYPE_DOCUMENT.equals(other.getTYPE_DOCUMENT()))) &&
            ((this.TYPE_DOCUMENT2==null && other.getTYPE_DOCUMENT2()==null) || 
             (this.TYPE_DOCUMENT2!=null &&
              this.TYPE_DOCUMENT2.equals(other.getTYPE_DOCUMENT2()))) &&
            ((this.TYPE_DOCUMENT3==null && other.getTYPE_DOCUMENT3()==null) || 
             (this.TYPE_DOCUMENT3!=null &&
              this.TYPE_DOCUMENT3.equals(other.getTYPE_DOCUMENT3())));
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
        if (getCREATEDATE() != null) {
            _hashCode += getCREATEDATE().hashCode();
        }
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
        if (getDOLG_PODPISANT() != null) {
            _hashCode += getDOLG_PODPISANT().hashCode();
        }
        if (getFIO_PODPISANT() != null) {
            _hashCode += getFIO_PODPISANT().hashCode();
        }
        if (getID_DOCUMENTRES() != null) {
            _hashCode += getID_DOCUMENTRES().hashCode();
        }
        if (getID_PARENT() != null) {
            _hashCode += getID_PARENT().hashCode();
        }
        if (getISSUER() != null) {
            _hashCode += getISSUER().hashCode();
        }
        if (getORG_GUID() != null) {
            _hashCode += getORG_GUID().hashCode();
        }
        if (getREGISTR_N() != null) {
            _hashCode += getREGISTR_N().hashCode();
        }
        if (getSIGNDATE() != null) {
            _hashCode += getSIGNDATE().hashCode();
        }
        if (getSTATUS() != null) {
            _hashCode += getSTATUS().hashCode();
        }
        if (getTYPE_DOCUMENT() != null) {
            _hashCode += getTYPE_DOCUMENT().hashCode();
        }
        if (getTYPE_DOCUMENT2() != null) {
            _hashCode += getTYPE_DOCUMENT2().hashCode();
        }
        if (getTYPE_DOCUMENT3() != null) {
            _hashCode += getTYPE_DOCUMENT3().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetChangesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "GetChangesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CREATEDATE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "CREATEDATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_REGIS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DATA_REGIS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCUMENT_CID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DOCUMENT_CID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseCID"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseCID"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCUMENT_FILES");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DOCUMENT_FILES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseFiles"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseFiles"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCUMENT_OBJECT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DOCUMENT_OBJECT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseObject"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseObject"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCUMENT_SUBJECTS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DOCUMENT_SUBJECTS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseSubject"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseSubject"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOLG_PODPISANT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "DOLG_PODPISANT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FIO_PODPISANT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "FIO_PODPISANT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_DOCUMENTRES");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ID_DOCUMENTRES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_PARENT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ID_PARENT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ISSUER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ISSUER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ORG_GUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ORG_GUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REGISTR_N");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "REGISTR_N"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIGNDATE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "SIGNDATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TYPE_DOCUMENT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "TYPE_DOCUMENT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TYPE_DOCUMENT2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "TYPE_DOCUMENT2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TYPE_DOCUMENT3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "TYPE_DOCUMENT3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

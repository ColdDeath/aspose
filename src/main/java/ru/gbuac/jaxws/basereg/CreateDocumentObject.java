/**
 * CreateDocumentObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class CreateDocumentObject  implements java.io.Serializable {
    private java.lang.String ADDR_BUILD;

    private java.lang.String ADDR_FIAS;

    private java.lang.String ADDR_TEXT;

    private java.lang.String CADNUM;

    private java.lang.String FLAT;

    private ru.gbuac.jaxws.basereg.ObjectTypes ID_ENT;

    private java.lang.String NPP;

    private java.lang.String UNKV;

    private java.lang.String UNOM;

    private java.lang.String USLNUM;

    public CreateDocumentObject() {
    }

    public CreateDocumentObject(
           java.lang.String ADDR_BUILD,
           java.lang.String ADDR_FIAS,
           java.lang.String ADDR_TEXT,
           java.lang.String CADNUM,
           java.lang.String FLAT,
           ru.gbuac.jaxws.basereg.ObjectTypes ID_ENT,
           java.lang.String NPP,
           java.lang.String UNKV,
           java.lang.String UNOM,
           java.lang.String USLNUM) {
           this.ADDR_BUILD = ADDR_BUILD;
           this.ADDR_FIAS = ADDR_FIAS;
           this.ADDR_TEXT = ADDR_TEXT;
           this.CADNUM = CADNUM;
           this.FLAT = FLAT;
           this.ID_ENT = ID_ENT;
           this.NPP = NPP;
           this.UNKV = UNKV;
           this.UNOM = UNOM;
           this.USLNUM = USLNUM;
    }


    /**
     * Gets the ADDR_BUILD value for this CreateDocumentObject.
     * 
     * @return ADDR_BUILD
     */
    public java.lang.String getADDR_BUILD() {
        return ADDR_BUILD;
    }


    /**
     * Sets the ADDR_BUILD value for this CreateDocumentObject.
     * 
     * @param ADDR_BUILD
     */
    public void setADDR_BUILD(java.lang.String ADDR_BUILD) {
        this.ADDR_BUILD = ADDR_BUILD;
    }


    /**
     * Gets the ADDR_FIAS value for this CreateDocumentObject.
     * 
     * @return ADDR_FIAS
     */
    public java.lang.String getADDR_FIAS() {
        return ADDR_FIAS;
    }


    /**
     * Sets the ADDR_FIAS value for this CreateDocumentObject.
     * 
     * @param ADDR_FIAS
     */
    public void setADDR_FIAS(java.lang.String ADDR_FIAS) {
        this.ADDR_FIAS = ADDR_FIAS;
    }


    /**
     * Gets the ADDR_TEXT value for this CreateDocumentObject.
     * 
     * @return ADDR_TEXT
     */
    public java.lang.String getADDR_TEXT() {
        return ADDR_TEXT;
    }


    /**
     * Sets the ADDR_TEXT value for this CreateDocumentObject.
     * 
     * @param ADDR_TEXT
     */
    public void setADDR_TEXT(java.lang.String ADDR_TEXT) {
        this.ADDR_TEXT = ADDR_TEXT;
    }


    /**
     * Gets the CADNUM value for this CreateDocumentObject.
     * 
     * @return CADNUM
     */
    public java.lang.String getCADNUM() {
        return CADNUM;
    }


    /**
     * Sets the CADNUM value for this CreateDocumentObject.
     * 
     * @param CADNUM
     */
    public void setCADNUM(java.lang.String CADNUM) {
        this.CADNUM = CADNUM;
    }


    /**
     * Gets the FLAT value for this CreateDocumentObject.
     * 
     * @return FLAT
     */
    public java.lang.String getFLAT() {
        return FLAT;
    }


    /**
     * Sets the FLAT value for this CreateDocumentObject.
     * 
     * @param FLAT
     */
    public void setFLAT(java.lang.String FLAT) {
        this.FLAT = FLAT;
    }


    /**
     * Gets the ID_ENT value for this CreateDocumentObject.
     * 
     * @return ID_ENT
     */
    public ru.gbuac.jaxws.basereg.ObjectTypes getID_ENT() {
        return ID_ENT;
    }


    /**
     * Sets the ID_ENT value for this CreateDocumentObject.
     * 
     * @param ID_ENT
     */
    public void setID_ENT(ru.gbuac.jaxws.basereg.ObjectTypes ID_ENT) {
        this.ID_ENT = ID_ENT;
    }


    /**
     * Gets the NPP value for this CreateDocumentObject.
     * 
     * @return NPP
     */
    public java.lang.String getNPP() {
        return NPP;
    }


    /**
     * Sets the NPP value for this CreateDocumentObject.
     * 
     * @param NPP
     */
    public void setNPP(java.lang.String NPP) {
        this.NPP = NPP;
    }


    /**
     * Gets the UNKV value for this CreateDocumentObject.
     * 
     * @return UNKV
     */
    public java.lang.String getUNKV() {
        return UNKV;
    }


    /**
     * Sets the UNKV value for this CreateDocumentObject.
     * 
     * @param UNKV
     */
    public void setUNKV(java.lang.String UNKV) {
        this.UNKV = UNKV;
    }


    /**
     * Gets the UNOM value for this CreateDocumentObject.
     * 
     * @return UNOM
     */
    public java.lang.String getUNOM() {
        return UNOM;
    }


    /**
     * Sets the UNOM value for this CreateDocumentObject.
     * 
     * @param UNOM
     */
    public void setUNOM(java.lang.String UNOM) {
        this.UNOM = UNOM;
    }


    /**
     * Gets the USLNUM value for this CreateDocumentObject.
     * 
     * @return USLNUM
     */
    public java.lang.String getUSLNUM() {
        return USLNUM;
    }


    /**
     * Sets the USLNUM value for this CreateDocumentObject.
     * 
     * @param USLNUM
     */
    public void setUSLNUM(java.lang.String USLNUM) {
        this.USLNUM = USLNUM;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateDocumentObject)) return false;
        CreateDocumentObject other = (CreateDocumentObject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ADDR_BUILD==null && other.getADDR_BUILD()==null) || 
             (this.ADDR_BUILD!=null &&
              this.ADDR_BUILD.equals(other.getADDR_BUILD()))) &&
            ((this.ADDR_FIAS==null && other.getADDR_FIAS()==null) || 
             (this.ADDR_FIAS!=null &&
              this.ADDR_FIAS.equals(other.getADDR_FIAS()))) &&
            ((this.ADDR_TEXT==null && other.getADDR_TEXT()==null) || 
             (this.ADDR_TEXT!=null &&
              this.ADDR_TEXT.equals(other.getADDR_TEXT()))) &&
            ((this.CADNUM==null && other.getCADNUM()==null) || 
             (this.CADNUM!=null &&
              this.CADNUM.equals(other.getCADNUM()))) &&
            ((this.FLAT==null && other.getFLAT()==null) || 
             (this.FLAT!=null &&
              this.FLAT.equals(other.getFLAT()))) &&
            ((this.ID_ENT==null && other.getID_ENT()==null) || 
             (this.ID_ENT!=null &&
              this.ID_ENT.equals(other.getID_ENT()))) &&
            ((this.NPP==null && other.getNPP()==null) || 
             (this.NPP!=null &&
              this.NPP.equals(other.getNPP()))) &&
            ((this.UNKV==null && other.getUNKV()==null) || 
             (this.UNKV!=null &&
              this.UNKV.equals(other.getUNKV()))) &&
            ((this.UNOM==null && other.getUNOM()==null) || 
             (this.UNOM!=null &&
              this.UNOM.equals(other.getUNOM()))) &&
            ((this.USLNUM==null && other.getUSLNUM()==null) || 
             (this.USLNUM!=null &&
              this.USLNUM.equals(other.getUSLNUM())));
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
        if (getADDR_BUILD() != null) {
            _hashCode += getADDR_BUILD().hashCode();
        }
        if (getADDR_FIAS() != null) {
            _hashCode += getADDR_FIAS().hashCode();
        }
        if (getADDR_TEXT() != null) {
            _hashCode += getADDR_TEXT().hashCode();
        }
        if (getCADNUM() != null) {
            _hashCode += getCADNUM().hashCode();
        }
        if (getFLAT() != null) {
            _hashCode += getFLAT().hashCode();
        }
        if (getID_ENT() != null) {
            _hashCode += getID_ENT().hashCode();
        }
        if (getNPP() != null) {
            _hashCode += getNPP().hashCode();
        }
        if (getUNKV() != null) {
            _hashCode += getUNKV().hashCode();
        }
        if (getUNOM() != null) {
            _hashCode += getUNOM().hashCode();
        }
        if (getUSLNUM() != null) {
            _hashCode += getUSLNUM().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateDocumentObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentObject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ADDR_BUILD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "ADDR_BUILD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ADDR_FIAS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "ADDR_FIAS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ADDR_TEXT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "ADDR_TEXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CADNUM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CADNUM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "FLAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_ENT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "ID_ENT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "ObjectTypes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NPP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "NPP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UNKV");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "UNKV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UNOM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "UNOM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("USLNUM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "USLNUM"));
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

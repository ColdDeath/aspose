/**
 * ResponseSubject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class ResponseSubject  implements java.io.Serializable {
    private java.util.Calendar BIRTHDATE;

    private java.lang.String FNAME;

    private java.lang.Boolean GENDER;

    private java.math.BigDecimal ID_SUBJECT;

    private java.lang.String INN;

    private java.lang.String LNAME;

    private java.lang.String NAME;

    private java.lang.String OGRN;

    private java.lang.String SNAME;

    private java.lang.String SNILS;

    private java.math.BigDecimal STYPE;

    private java.math.BigDecimal TICKET;

    public ResponseSubject() {
    }

    public ResponseSubject(
           java.util.Calendar BIRTHDATE,
           java.lang.String FNAME,
           java.lang.Boolean GENDER,
           java.math.BigDecimal ID_SUBJECT,
           java.lang.String INN,
           java.lang.String LNAME,
           java.lang.String NAME,
           java.lang.String OGRN,
           java.lang.String SNAME,
           java.lang.String SNILS,
           java.math.BigDecimal STYPE,
           java.math.BigDecimal TICKET) {
           this.BIRTHDATE = BIRTHDATE;
           this.FNAME = FNAME;
           this.GENDER = GENDER;
           this.ID_SUBJECT = ID_SUBJECT;
           this.INN = INN;
           this.LNAME = LNAME;
           this.NAME = NAME;
           this.OGRN = OGRN;
           this.SNAME = SNAME;
           this.SNILS = SNILS;
           this.STYPE = STYPE;
           this.TICKET = TICKET;
    }


    /**
     * Gets the BIRTHDATE value for this ResponseSubject.
     * 
     * @return BIRTHDATE
     */
    public java.util.Calendar getBIRTHDATE() {
        return BIRTHDATE;
    }


    /**
     * Sets the BIRTHDATE value for this ResponseSubject.
     * 
     * @param BIRTHDATE
     */
    public void setBIRTHDATE(java.util.Calendar BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
    }


    /**
     * Gets the FNAME value for this ResponseSubject.
     * 
     * @return FNAME
     */
    public java.lang.String getFNAME() {
        return FNAME;
    }


    /**
     * Sets the FNAME value for this ResponseSubject.
     * 
     * @param FNAME
     */
    public void setFNAME(java.lang.String FNAME) {
        this.FNAME = FNAME;
    }


    /**
     * Gets the GENDER value for this ResponseSubject.
     * 
     * @return GENDER
     */
    public java.lang.Boolean getGENDER() {
        return GENDER;
    }


    /**
     * Sets the GENDER value for this ResponseSubject.
     * 
     * @param GENDER
     */
    public void setGENDER(java.lang.Boolean GENDER) {
        this.GENDER = GENDER;
    }


    /**
     * Gets the ID_SUBJECT value for this ResponseSubject.
     * 
     * @return ID_SUBJECT
     */
    public java.math.BigDecimal getID_SUBJECT() {
        return ID_SUBJECT;
    }


    /**
     * Sets the ID_SUBJECT value for this ResponseSubject.
     * 
     * @param ID_SUBJECT
     */
    public void setID_SUBJECT(java.math.BigDecimal ID_SUBJECT) {
        this.ID_SUBJECT = ID_SUBJECT;
    }


    /**
     * Gets the INN value for this ResponseSubject.
     * 
     * @return INN
     */
    public java.lang.String getINN() {
        return INN;
    }


    /**
     * Sets the INN value for this ResponseSubject.
     * 
     * @param INN
     */
    public void setINN(java.lang.String INN) {
        this.INN = INN;
    }


    /**
     * Gets the LNAME value for this ResponseSubject.
     * 
     * @return LNAME
     */
    public java.lang.String getLNAME() {
        return LNAME;
    }


    /**
     * Sets the LNAME value for this ResponseSubject.
     * 
     * @param LNAME
     */
    public void setLNAME(java.lang.String LNAME) {
        this.LNAME = LNAME;
    }


    /**
     * Gets the NAME value for this ResponseSubject.
     * 
     * @return NAME
     */
    public java.lang.String getNAME() {
        return NAME;
    }


    /**
     * Sets the NAME value for this ResponseSubject.
     * 
     * @param NAME
     */
    public void setNAME(java.lang.String NAME) {
        this.NAME = NAME;
    }


    /**
     * Gets the OGRN value for this ResponseSubject.
     * 
     * @return OGRN
     */
    public java.lang.String getOGRN() {
        return OGRN;
    }


    /**
     * Sets the OGRN value for this ResponseSubject.
     * 
     * @param OGRN
     */
    public void setOGRN(java.lang.String OGRN) {
        this.OGRN = OGRN;
    }


    /**
     * Gets the SNAME value for this ResponseSubject.
     * 
     * @return SNAME
     */
    public java.lang.String getSNAME() {
        return SNAME;
    }


    /**
     * Sets the SNAME value for this ResponseSubject.
     * 
     * @param SNAME
     */
    public void setSNAME(java.lang.String SNAME) {
        this.SNAME = SNAME;
    }


    /**
     * Gets the SNILS value for this ResponseSubject.
     * 
     * @return SNILS
     */
    public java.lang.String getSNILS() {
        return SNILS;
    }


    /**
     * Sets the SNILS value for this ResponseSubject.
     * 
     * @param SNILS
     */
    public void setSNILS(java.lang.String SNILS) {
        this.SNILS = SNILS;
    }


    /**
     * Gets the STYPE value for this ResponseSubject.
     * 
     * @return STYPE
     */
    public java.math.BigDecimal getSTYPE() {
        return STYPE;
    }


    /**
     * Sets the STYPE value for this ResponseSubject.
     * 
     * @param STYPE
     */
    public void setSTYPE(java.math.BigDecimal STYPE) {
        this.STYPE = STYPE;
    }


    /**
     * Gets the TICKET value for this ResponseSubject.
     * 
     * @return TICKET
     */
    public java.math.BigDecimal getTICKET() {
        return TICKET;
    }


    /**
     * Sets the TICKET value for this ResponseSubject.
     * 
     * @param TICKET
     */
    public void setTICKET(java.math.BigDecimal TICKET) {
        this.TICKET = TICKET;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseSubject)) return false;
        ResponseSubject other = (ResponseSubject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.BIRTHDATE==null && other.getBIRTHDATE()==null) || 
             (this.BIRTHDATE!=null &&
              this.BIRTHDATE.equals(other.getBIRTHDATE()))) &&
            ((this.FNAME==null && other.getFNAME()==null) || 
             (this.FNAME!=null &&
              this.FNAME.equals(other.getFNAME()))) &&
            ((this.GENDER==null && other.getGENDER()==null) || 
             (this.GENDER!=null &&
              this.GENDER.equals(other.getGENDER()))) &&
            ((this.ID_SUBJECT==null && other.getID_SUBJECT()==null) || 
             (this.ID_SUBJECT!=null &&
              this.ID_SUBJECT.equals(other.getID_SUBJECT()))) &&
            ((this.INN==null && other.getINN()==null) || 
             (this.INN!=null &&
              this.INN.equals(other.getINN()))) &&
            ((this.LNAME==null && other.getLNAME()==null) || 
             (this.LNAME!=null &&
              this.LNAME.equals(other.getLNAME()))) &&
            ((this.NAME==null && other.getNAME()==null) || 
             (this.NAME!=null &&
              this.NAME.equals(other.getNAME()))) &&
            ((this.OGRN==null && other.getOGRN()==null) || 
             (this.OGRN!=null &&
              this.OGRN.equals(other.getOGRN()))) &&
            ((this.SNAME==null && other.getSNAME()==null) || 
             (this.SNAME!=null &&
              this.SNAME.equals(other.getSNAME()))) &&
            ((this.SNILS==null && other.getSNILS()==null) || 
             (this.SNILS!=null &&
              this.SNILS.equals(other.getSNILS()))) &&
            ((this.STYPE==null && other.getSTYPE()==null) || 
             (this.STYPE!=null &&
              this.STYPE.equals(other.getSTYPE()))) &&
            ((this.TICKET==null && other.getTICKET()==null) || 
             (this.TICKET!=null &&
              this.TICKET.equals(other.getTICKET())));
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
        if (getBIRTHDATE() != null) {
            _hashCode += getBIRTHDATE().hashCode();
        }
        if (getFNAME() != null) {
            _hashCode += getFNAME().hashCode();
        }
        if (getGENDER() != null) {
            _hashCode += getGENDER().hashCode();
        }
        if (getID_SUBJECT() != null) {
            _hashCode += getID_SUBJECT().hashCode();
        }
        if (getINN() != null) {
            _hashCode += getINN().hashCode();
        }
        if (getLNAME() != null) {
            _hashCode += getLNAME().hashCode();
        }
        if (getNAME() != null) {
            _hashCode += getNAME().hashCode();
        }
        if (getOGRN() != null) {
            _hashCode += getOGRN().hashCode();
        }
        if (getSNAME() != null) {
            _hashCode += getSNAME().hashCode();
        }
        if (getSNILS() != null) {
            _hashCode += getSNILS().hashCode();
        }
        if (getSTYPE() != null) {
            _hashCode += getSTYPE().hashCode();
        }
        if (getTICKET() != null) {
            _hashCode += getTICKET().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseSubject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ResponseSubject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIRTHDATE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "BIRTHDATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "FNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GENDER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "GENDER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_SUBJECT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "ID_SUBJECT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "INN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "LNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OGRN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "OGRN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "SNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SNILS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "SNILS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "STYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TICKET");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BusinessLogicLayer.BRRemoteService", "TICKET"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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

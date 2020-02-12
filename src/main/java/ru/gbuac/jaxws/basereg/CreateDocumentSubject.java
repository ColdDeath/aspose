/**
 * CreateDocumentSubject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.gbuac.jaxws.basereg;

public class CreateDocumentSubject  implements java.io.Serializable {
    private java.util.Calendar BIRTHDATE;

    private java.lang.String FNAME;

    private ru.gbuac.jaxws.basereg.GENDER GENDER;

    private java.lang.String INN;

    private java.lang.String LNAME;

    private java.lang.String NAME;

    private java.lang.String OGRN;

    private java.lang.String SNAME;

    private java.lang.String SNILS;

    private ru.gbuac.jaxws.basereg.SUBJECTTYPE STYPE;

    public CreateDocumentSubject() {
    }

    public CreateDocumentSubject(
           java.util.Calendar BIRTHDATE,
           java.lang.String FNAME,
           ru.gbuac.jaxws.basereg.GENDER GENDER,
           java.lang.String INN,
           java.lang.String LNAME,
           java.lang.String NAME,
           java.lang.String OGRN,
           java.lang.String SNAME,
           java.lang.String SNILS,
           ru.gbuac.jaxws.basereg.SUBJECTTYPE STYPE) {
           this.BIRTHDATE = BIRTHDATE;
           this.FNAME = FNAME;
           this.GENDER = GENDER;
           this.INN = INN;
           this.LNAME = LNAME;
           this.NAME = NAME;
           this.OGRN = OGRN;
           this.SNAME = SNAME;
           this.SNILS = SNILS;
           this.STYPE = STYPE;
    }


    /**
     * Gets the BIRTHDATE value for this CreateDocumentSubject.
     * 
     * @return BIRTHDATE
     */
    public java.util.Calendar getBIRTHDATE() {
        return BIRTHDATE;
    }


    /**
     * Sets the BIRTHDATE value for this CreateDocumentSubject.
     * 
     * @param BIRTHDATE
     */
    public void setBIRTHDATE(java.util.Calendar BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
    }


    /**
     * Gets the FNAME value for this CreateDocumentSubject.
     * 
     * @return FNAME
     */
    public java.lang.String getFNAME() {
        return FNAME;
    }


    /**
     * Sets the FNAME value for this CreateDocumentSubject.
     * 
     * @param FNAME
     */
    public void setFNAME(java.lang.String FNAME) {
        this.FNAME = FNAME;
    }


    /**
     * Gets the GENDER value for this CreateDocumentSubject.
     * 
     * @return GENDER
     */
    public ru.gbuac.jaxws.basereg.GENDER getGENDER() {
        return GENDER;
    }


    /**
     * Sets the GENDER value for this CreateDocumentSubject.
     * 
     * @param GENDER
     */
    public void setGENDER(ru.gbuac.jaxws.basereg.GENDER GENDER) {
        this.GENDER = GENDER;
    }


    /**
     * Gets the INN value for this CreateDocumentSubject.
     * 
     * @return INN
     */
    public java.lang.String getINN() {
        return INN;
    }


    /**
     * Sets the INN value for this CreateDocumentSubject.
     * 
     * @param INN
     */
    public void setINN(java.lang.String INN) {
        this.INN = INN;
    }


    /**
     * Gets the LNAME value for this CreateDocumentSubject.
     * 
     * @return LNAME
     */
    public java.lang.String getLNAME() {
        return LNAME;
    }


    /**
     * Sets the LNAME value for this CreateDocumentSubject.
     * 
     * @param LNAME
     */
    public void setLNAME(java.lang.String LNAME) {
        this.LNAME = LNAME;
    }


    /**
     * Gets the NAME value for this CreateDocumentSubject.
     * 
     * @return NAME
     */
    public java.lang.String getNAME() {
        return NAME;
    }


    /**
     * Sets the NAME value for this CreateDocumentSubject.
     * 
     * @param NAME
     */
    public void setNAME(java.lang.String NAME) {
        this.NAME = NAME;
    }


    /**
     * Gets the OGRN value for this CreateDocumentSubject.
     * 
     * @return OGRN
     */
    public java.lang.String getOGRN() {
        return OGRN;
    }


    /**
     * Sets the OGRN value for this CreateDocumentSubject.
     * 
     * @param OGRN
     */
    public void setOGRN(java.lang.String OGRN) {
        this.OGRN = OGRN;
    }


    /**
     * Gets the SNAME value for this CreateDocumentSubject.
     * 
     * @return SNAME
     */
    public java.lang.String getSNAME() {
        return SNAME;
    }


    /**
     * Sets the SNAME value for this CreateDocumentSubject.
     * 
     * @param SNAME
     */
    public void setSNAME(java.lang.String SNAME) {
        this.SNAME = SNAME;
    }


    /**
     * Gets the SNILS value for this CreateDocumentSubject.
     * 
     * @return SNILS
     */
    public java.lang.String getSNILS() {
        return SNILS;
    }


    /**
     * Sets the SNILS value for this CreateDocumentSubject.
     * 
     * @param SNILS
     */
    public void setSNILS(java.lang.String SNILS) {
        this.SNILS = SNILS;
    }


    /**
     * Gets the STYPE value for this CreateDocumentSubject.
     * 
     * @return STYPE
     */
    public ru.gbuac.jaxws.basereg.SUBJECTTYPE getSTYPE() {
        return STYPE;
    }


    /**
     * Sets the STYPE value for this CreateDocumentSubject.
     * 
     * @param STYPE
     */
    public void setSTYPE(ru.gbuac.jaxws.basereg.SUBJECTTYPE STYPE) {
        this.STYPE = STYPE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateDocumentSubject)) return false;
        CreateDocumentSubject other = (CreateDocumentSubject) obj;
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
              this.STYPE.equals(other.getSTYPE())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateDocumentSubject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "CreateDocumentSubject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BIRTHDATE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "BIRTHDATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "FNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GENDER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "GENDER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "GENDER"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "INN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "LNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OGRN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "OGRN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "SNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SNILS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "SNILS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "STYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Common", "SUBJECTTYPE"));
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

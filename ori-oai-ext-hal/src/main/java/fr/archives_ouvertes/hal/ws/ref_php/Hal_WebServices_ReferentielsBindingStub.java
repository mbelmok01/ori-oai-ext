/**
 * Hal_WebServices_ReferentielsBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.ref_php;

public class Hal_WebServices_ReferentielsBindingStub extends org.apache.axis.client.Stub implements fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsPort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    /**
     * ORI-OAI patch !
     */
    private String operationsNameSpaceURL = "http://paol.ccsd.cnrs.fr/ws/ref.php";
    
    /**
     * ORI-OAI patch !
     */
    public void setOperationNameSpaceURL(String ns) {
    	operationsNameSpaceURL = ns;
    }
    
    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[37];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefInstance");
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfStrings"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefInstanceResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefTypePubli");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "instance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfTypePubliStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.TypePubliStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefTypePubliResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefMetaData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "instance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "typePubli"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfMetaDataStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefMetaDataResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefMetaData_forTypePubli");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "instance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "typePubli"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfMetaDataStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefMetaData_forTypePubliResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefLab_byId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "knownLabid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "LabStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.LabStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefLab_byIdResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefLab_search");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "search"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfLabStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.LabStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefLab_searchResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefLab");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "from"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefLabResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefLab_byName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "from"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefLab_byNameResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefLab_byShortName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "shortName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "from"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefLab_byShortNameResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefLab_byAffi");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "affi"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "from"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefLab_byAffiResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefLab_byAuthor");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lastname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "firstname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefLab_byAuthorResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addRefLab");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "UserStruct"), fr.archives_ouvertes.hal.ws.ref_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lab"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "AddLabStruct"), fr.archives_ouvertes.hal.ws.ref_php.AddLabStruct.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addRefLabResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefAffi");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "from"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfStrings"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefAffiResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefAffi_byName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "search"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "from"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfStrings"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefAffi_byNameResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefReview_byId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ReviewStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.ReviewStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefReview_byIdResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefReview");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "from"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefReviewResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefReview_byName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefReview_byNameResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefReview_byEditor");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "editor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefReview_byEditorResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefReview_byISSN");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "issn"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefReview_byISSNResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchReview");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "value"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "by"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "from"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchReviewResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefSubject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "instance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfStrings"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefSubjectResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefSubject_byCodeParent");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "instance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "code"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfStrings"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefSubject_byCodeParentResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefSubject_byCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "instance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "code"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "SubjectStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.SubjectStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefSubject_byCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefFormat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "instance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfFormatStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.FormatStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefFormatResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefCollection");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "instance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "uid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfCollectionStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.CollectionStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefCollectionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefDateVisible");
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfDateVisibleStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.DateVisibleStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefDateVisibleResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefAudience");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfAudienceStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.AudienceStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefAudienceResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefCodeANR");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "search"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefCodeANRResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefANR_byCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "code"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ANRStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.ANRStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefANR_byCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefCodeProjEurope");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "search"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefCodeProjEuropeResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "int"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefProjEurope_byCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "code"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ProjEuropeStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.ProjEuropeStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefProjEurope_byCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefRightFulltext");
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfRightFulltextStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.RightFulltextStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefRightFulltextResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefOrgThe");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pays"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfOrgtheStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefOrgTheResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefOrgThe_byName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pays"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfOrgtheStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefOrgThe_byNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefSchool");
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfSchoolStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefSchoolResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefSchool_byName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfSchoolStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefSchool_byNameResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRefSchool_byOrgThe");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "searchType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfSchoolStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRefSchool_byOrgTheResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[36] = oper;

    }

    public Hal_WebServices_ReferentielsBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Hal_WebServices_ReferentielsBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Hal_WebServices_ReferentielsBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.1");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "AddLabStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.AddLabStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ANRStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.ANRStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfAudienceStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.AudienceStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "AudienceStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfCollectionStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.CollectionStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "CollectionStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfDateVisibleStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.DateVisibleStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "DateVisibleStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfFormatStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.FormatStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "FormatStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfInts");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("", "int");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfLabStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.LabStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "LabStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfMetaDataStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "MetaDataStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfOrgtheStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "OrgtheStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfRightFulltextStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.RightFulltextStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "RightFulltextStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfSchoolStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "SchoolStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfStrings");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ArrayOfTypePubliStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.TypePubliStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "TypePubliStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "AudienceStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.AudienceStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "CollectionStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.CollectionStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "DateVisibleStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.DateVisibleStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "FormatStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.FormatStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "LabStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.LabStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "MetaDataStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "OrgtheStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ProjEuropeStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.ProjEuropeStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "ReviewStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.ReviewStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "RightFulltextStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.RightFulltextStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "SchoolStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "SubjectStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.SubjectStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "TypePubliStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.TypePubliStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/ref.php", "UserStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.ref_php.UserStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public java.lang.String[] getRefInstance() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefInstance");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefInstance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.TypePubliStruct[] getRefTypePubli(java.lang.String instance, java.lang.String lang) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefTypePubli");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefTypePubli"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instance, lang});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.TypePubliStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.TypePubliStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.TypePubliStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[] getRefMetaData(java.lang.String instance, java.lang.String typePubli, java.lang.String lang) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefMetaData");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefMetaData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instance, typePubli, lang});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[] getRefMetaData_forTypePubli(java.lang.String instance, java.lang.String typePubli, java.lang.String lang) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefMetaData_forTypePubli");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefMetaData_forTypePubli"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instance, typePubli, lang});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.LabStruct getRefLab_byId(int knownLabid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefLab_byId");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefLab_byId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(knownLabid)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.LabStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.LabStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.LabStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.LabStruct[] getRefLab_search(java.lang.String search) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefLab_search");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefLab_search"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {search});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.LabStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.LabStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.LabStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefLab(java.lang.String from) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefLab");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefLab"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {from});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefLab_byName(java.lang.String name, java.lang.String searchType, java.lang.String from) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefLab_byName");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefLab_byName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {name, searchType, from});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefLab_byShortName(java.lang.String shortName, java.lang.String searchType, java.lang.String from) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefLab_byShortName");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefLab_byShortName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {shortName, searchType, from});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefLab_byAffi(java.lang.String affi, java.lang.String searchType, java.lang.String from) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefLab_byAffi");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefLab_byAffi"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {affi, searchType, from});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefLab_byAuthor(java.lang.String lastname, java.lang.String firstname, java.lang.String email) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefLab_byAuthor");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefLab_byAuthor"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {lastname, firstname, email});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int addRefLab(fr.archives_ouvertes.hal.ws.ref_php.UserStruct identification, fr.archives_ouvertes.hal.ws.ref_php.AddLabStruct lab) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#addRefLab");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "addRefLab"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {identification, lab});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getRefAffi(java.lang.String from) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefAffi");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefAffi"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {from});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getRefAffi_byName(java.lang.String search, java.lang.String searchType, java.lang.String from) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefAffi_byName");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefAffi_byName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {search, searchType, from});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.ReviewStruct getRefReview_byId(int id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefReview_byId");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefReview_byId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(id)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.ReviewStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.ReviewStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.ReviewStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefReview(java.lang.String from) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefReview");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefReview"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {from});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefReview_byName(java.lang.String name, java.lang.String searchType) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefReview_byName");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefReview_byName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {name, searchType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefReview_byEditor(java.lang.String editor, java.lang.String searchType) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefReview_byEditor");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefReview_byEditor"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {editor, searchType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefReview_byISSN(java.lang.String issn, java.lang.String searchType) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefReview_byISSN");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefReview_byISSN"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {issn, searchType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] searchReview(java.lang.String value, java.lang.String searchType, java.lang.String by, java.lang.String from) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#searchReview");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "searchReview"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {value, searchType, by, from});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getRefSubject(java.lang.String instance) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefSubject");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefSubject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instance});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getRefSubject_byCodeParent(java.lang.String instance, java.lang.String code) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefSubject_byCodeParent");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefSubject_byCodeParent"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instance, code});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.SubjectStruct getRefSubject_byCode(java.lang.String instance, java.lang.String code, java.lang.String lang) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefSubject_byCode");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefSubject_byCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instance, code, lang});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.SubjectStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.SubjectStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.SubjectStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.FormatStruct[] getRefFormat(java.lang.String instance, java.lang.String lang) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefFormat");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefFormat"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instance, lang});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.FormatStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.FormatStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.FormatStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.CollectionStruct[] getRefCollection(java.lang.String instance, java.lang.String uid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefCollection");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefCollection"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instance, uid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.CollectionStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.CollectionStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.CollectionStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.DateVisibleStruct[] getRefDateVisible() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefDateVisible");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefDateVisible"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.DateVisibleStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.DateVisibleStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.DateVisibleStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.AudienceStruct[] getRefAudience(java.lang.String lang) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefAudience");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefAudience"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {lang});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.AudienceStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.AudienceStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.AudienceStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefCodeANR(java.lang.String search) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefCodeANR");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefCodeANR"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {search});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.ANRStruct getRefANR_byCode(java.lang.String code) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefANR_byCode");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefANR_byCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {code});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.ANRStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.ANRStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.ANRStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getRefCodeProjEurope(java.lang.String search) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefCodeProjEurope");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefCodeProjEurope"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {search});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.ProjEuropeStruct getRefProjEurope_byCode(java.lang.String code) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefProjEurope_byCode");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefProjEurope_byCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {code});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.ProjEuropeStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.ProjEuropeStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.ProjEuropeStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.RightFulltextStruct[] getRefRightFulltext() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefRightFulltext");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefRightFulltext"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.RightFulltextStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.RightFulltextStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.RightFulltextStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[] getRefOrgThe(java.lang.String pays) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefOrgThe");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefOrgThe"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pays});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[] getRefOrgThe_byName(java.lang.String name, java.lang.String searchType, java.lang.String pays) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefOrgThe_byName");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefOrgThe_byName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {name, searchType, pays});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[] getRefSchool() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefSchool");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefSchool"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[] getRefSchool_byName(java.lang.String name, java.lang.String searchType) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefSchool_byName");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefSchool_byName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {name, searchType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[] getRefSchool_byOrgThe(java.lang.String name, java.lang.String searchType) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/ref.php#getRefSchool_byOrgThe");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getRefSchool_byOrgThe"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {name, searchType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}

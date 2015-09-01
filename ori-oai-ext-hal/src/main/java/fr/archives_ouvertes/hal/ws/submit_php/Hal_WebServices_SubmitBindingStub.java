/**
 * Hal_WebServices_SubmitBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.submit_php;

public class Hal_WebServices_SubmitBindingStub extends org.apache.axis.client.Stub implements fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitPort {
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
        _operations = new org.apache.axis.description.OperationDesc[11];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("upload");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "instance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "contributor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ContributorStruct"), fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "metadatas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "MetasStruct"), fr.archives_ouvertes.hal.ws.submit_php.MetasStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fullText"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FullTextStruct"), fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "PendingArticleStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "uploadResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("modify");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "contributor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ContributorStruct"), fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "metadatas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "MetasStruct"), fr.archives_ouvertes.hal.ws.submit_php.MetasStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fullText"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FullTextStruct"), fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "PendingArticleStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "modifyResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("replace");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "contributor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ContributorStruct"), fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "metadatas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "MetasStruct"), fr.archives_ouvertes.hal.ws.submit_php.MetasStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fullText"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FullTextStruct"), fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "PendingArticleStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "replaceResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("update");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "metadatas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "MetasStruct"), fr.archives_ouvertes.hal.ws.submit_php.MetasStruct.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("jref");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "typePubli"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "metas"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArrayOfMetaStruct"), fr.archives_ouvertes.hal.ws.submit_php.MetaStruct[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "jrefResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cross");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "domain"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "crossResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addFile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fullText"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FullTextStruct"), fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "PendingArticleStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addFileResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addSupplementaryData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "files"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArrayOfFileStruct"), fr.archives_ouvertes.hal.ws.submit_php.FileStruct[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addSupplementaryDataResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addCollection");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "collection"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addCollectionResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("putOnLine");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "putOnLineResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("status");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct"), fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleStatusStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.submit_php.ArticleStatusStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "statusResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

    }

    public Hal_WebServices_SubmitBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Hal_WebServices_SubmitBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Hal_WebServices_SubmitBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArrayOfAuthorStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.AuthorStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "AuthorStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArrayOfFileStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.FileStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FileStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArrayOfInts");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("", "int");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArrayOfLaboratoryStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.LaboratoryStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "LaboratoryStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArrayOfMetaStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.MetaStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "MetaStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArrayOfStrings");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleIdentStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ArticleStatusStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.ArticleStatusStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "AuthorStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.AuthorStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "AutLabStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.AutLabStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "ContributorStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FileStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.FileStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "FullTextStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "LaboratoryStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.LaboratoryStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "MetasStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.MetasStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "MetaStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.MetaStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "PendingArticleStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/submit.php", "UserStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.submit_php.UserStruct.class;
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

    public fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct upload(java.lang.String instance, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct contributor, fr.archives_ouvertes.hal.ws.submit_php.MetasStruct metadatas, fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct fullText) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#upload");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "upload"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instance, identification, contributor, metadatas, fullText});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct modify(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct contributor, fr.archives_ouvertes.hal.ws.submit_php.MetasStruct metadatas, fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct fullText) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#modify");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "modify"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification, contributor, metadatas, fullText});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct replace(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct contributor, fr.archives_ouvertes.hal.ws.submit_php.MetasStruct metadatas, fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct fullText) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#replace");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "replace"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification, contributor, metadatas, fullText});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct update(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.MetasStruct metadatas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#update");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "update"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification, metadatas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct jref(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, java.lang.String typePubli, fr.archives_ouvertes.hal.ws.submit_php.MetaStruct[] metas) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#jref");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "jref"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification, typePubli, metas});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct cross(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, java.lang.String domain) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#cross");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "cross"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification, domain});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct addFile(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct fullText) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#addFile");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "addFile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification, fullText});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean addSupplementaryData(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.FileStruct[] files) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#addSupplementaryData");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "addSupplementaryData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification, files});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct addCollection(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, java.lang.String collection) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#addCollection");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "addCollection"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification, collection});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean putOnLine(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#putOnLine");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "putOnLine"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.submit_php.ArticleStatusStruct status(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/submit.php#status");
        _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "status"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {article, identification});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleStatusStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.submit_php.ArticleStatusStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.submit_php.ArticleStatusStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}

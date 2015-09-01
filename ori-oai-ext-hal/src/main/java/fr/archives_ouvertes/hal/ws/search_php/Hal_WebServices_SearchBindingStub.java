/**
 * Hal_WebServices_SearchBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.search_php;

public class Hal_WebServices_SearchBindingStub extends org.apache.axis.client.Stub implements fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchPort {
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
        _operations = new org.apache.axis.description.OperationDesc[7];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("existOnHAL");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "title"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "status"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfArticleStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "existOnHALResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getArticleCounter");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "UserStruct"), fr.archives_ouvertes.hal.ws.search_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "article"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArticleIdentStruct"), fr.archives_ouvertes.hal.ws.search_php.ArticleIdentStruct.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "CounterStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.search_php.CounterStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getArticleCounterResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSetCounter");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "set"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "SetCounterStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.search_php.SetCounterStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getSetCounterResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getArticleMetadata");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identifiant"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "version"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "DatasStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.search_php.DatasStruct.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getArticleMetadataResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getArticleFile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identifiant"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "version"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfStrings"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getArticleFileResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("search");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "search"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfSearchStruct"), fr.archives_ouvertes.hal.ws.search_php.SearchStruct[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "typePubli"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfStrings"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "string"));
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "onlyFullText"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orderBy"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfArticleStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("search_thesis");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identification"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "UserStruct"), fr.archives_ouvertes.hal.ws.search_php.UserStruct.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "title"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "author"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "defencedate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfThesisStruct"));
        oper.setReturnClass(fr.archives_ouvertes.hal.ws.search_php.ThesisStruct[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "search_thesisResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

    }

    public Hal_WebServices_SearchBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Hal_WebServices_SearchBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Hal_WebServices_SearchBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfArticleStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArticleStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfAuthorStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.AuthorStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "AuthorStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfDataStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.DataStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "DataStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfInts");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("", "int");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfLaboratoryStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.LaboratoryStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "LaboratoryStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfSearchStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.SearchStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "SearchStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfStrings");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArrayOfThesisStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.ThesisStruct[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ThesisStruct");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArticleIdentStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.ArticleIdentStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ArticleStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.ArticleStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "AuthorStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.AuthorStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "AutLabStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.AutLabStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "CounterStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.CounterStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "DatasStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.DatasStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "DataStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.DataStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "LaboratoryStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.LaboratoryStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "SearchStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.SearchStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "SetCounterStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.SetCounterStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "ThesisStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.ThesisStruct.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://paol.ccsd.cnrs.fr/ws/search.php", "UserStruct");
            cachedSerQNames.add(qName);
            cls = fr.archives_ouvertes.hal.ws.search_php.UserStruct.class;
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
                    _call.setEncodingStyle(null);
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

    public fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[] existOnHAL(java.lang.String title, java.lang.String status) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/search.php#existOnHAL");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "existOnHAL"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {title, status});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.search_php.CounterStruct getArticleCounter(fr.archives_ouvertes.hal.ws.search_php.UserStruct identification, fr.archives_ouvertes.hal.ws.search_php.ArticleIdentStruct article) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/search.php#getArticleCounter");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getArticleCounter"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {identification, article});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.search_php.CounterStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.search_php.CounterStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.search_php.CounterStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.search_php.SetCounterStruct getSetCounter(java.lang.String set) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/search.php#getSetCounter");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getSetCounter"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {set});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.search_php.SetCounterStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.search_php.SetCounterStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.search_php.SetCounterStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.search_php.DatasStruct getArticleMetadata(java.lang.String identifiant, int version) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/search.php#getArticleMetadata");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getArticleMetadata"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {identifiant, new java.lang.Integer(version)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.search_php.DatasStruct) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.search_php.DatasStruct) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.search_php.DatasStruct.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getArticleFile(java.lang.String identifiant, int version) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/search.php#getArticleFile");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "getArticleFile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {identifiant, new java.lang.Integer(version)});

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

    public fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[] search(fr.archives_ouvertes.hal.ws.search_php.SearchStruct[] search, java.lang.String[] typePubli, boolean onlyFullText, java.lang.String orderBy) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/search.php#search");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "search"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {search, typePubli, new java.lang.Boolean(onlyFullText), orderBy});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public fr.archives_ouvertes.hal.ws.search_php.ThesisStruct[] search_thesis(fr.archives_ouvertes.hal.ws.search_php.UserStruct identification, java.lang.String title, java.lang.String author, java.lang.String defencedate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://paol.ccsd.cnrs.fr/ws/search.php#search_thesis");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(operationsNameSpaceURL, "search_thesis"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {identification, title, author, defencedate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (fr.archives_ouvertes.hal.ws.search_php.ThesisStruct[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (fr.archives_ouvertes.hal.ws.search_php.ThesisStruct[]) org.apache.axis.utils.JavaUtils.convert(_resp, fr.archives_ouvertes.hal.ws.search_php.ThesisStruct[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}

#!/bin/bash

##  useful to set up the mapping.xml castor file and to be sure of the marshall/unmarshall process
#### NOTE : I would have preferred to use the castor-maven-plugin, but it seems considerably buggy.
#### (I've tried probably all combinations of castor and castor-maven-plugin versions without any success...)
M2_REPOS="/home/neuville/.m2/repository"
CASTOR_JAR="$M2_REPOS/org/codehaus/castor/com.springsource.org.castor/1.2.0/com.springsource.org.castor-1.2.0.jar"
COMMONS_LOGGING_JAR="$M2_REPOS/commons-logging/commons-logging/1.0.4/commons-logging-1.0.4.jar"
AXIS_JAR="$M2_REPOS/axis/axis/1.4/axis-1.4.jar"
JAX_RPC_JAR="$M2_REPOS/javax/xml/rpc/com.springsource.javax.xml.rpc/1.1.0/com.springsource.javax.xml.rpc-1.1.0.jar"
XERCES_JAR="$M2_REPOS/org/apache/xerces/com.springsource.org.apache.xerces/2.9.1/com.springsource.org.apache.xerces-2.9.1.jar"
PROJECT_CLASSPATH="./target/classes"

CLASSPATH="$PROJECT_CLASSPATH:$CASTOR_JAR:$JAX_RPC_JAR:$XERCES_JAR:$COMMONS_LOGGING_JAR:$AXIS_JAR"
java -cp $CLASSPATH org.exolab.castor.tools.MappingTool -i org.orioai.ext.hal.beans.HalDTO -o src/main/resources/META-INF/castor-mapping/halDTO-mapping.xml
# java -cp $CLASSPATH org.exolab.castor.tools.MappingTool -help


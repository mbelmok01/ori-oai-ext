<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:dcfr="http://www.archives-ouvertes.fr/OAI/2.0/dc_plus_fr/" 
		xmlns:dc="http://purl.org/dc/elements/1.1/" 
		xmlns:dcterms="http://purl.org/dc/terms/"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">

  <xsl:output method="xml" indent="yes" encoding="utf-8"/>
  

  <xsl:template match="@*|node()" priority="-1">
  </xsl:template>

  <xsl:template match="/dcfr:dc">
    <hal-dTO> 
      
      <ns12:hal-portal-name xmlns:ns12="http://castor.exolab.org/">hal</ns12:hal-portal-name>

      <ns14:user-struct xmlns:ns14="http://castor.exolab.org/">
	<ns14:passwd>test</ns14:passwd>
	<ns14:uid>test_ws</ns14:uid>
      </ns14:user-struct>

      <xsl:apply-templates select="@*|node()"/>

    </hal-dTO>
    
  </xsl:template>
  

  <xsl:template match="dc:creator[@xsi:type='dcfr:people']">
    <ns3:authors xmlns:ns3="http://castor.exolab.org/"
		 ns3:corresponding="false">
      <ns3:other-name>admin</ns3:other-name>
      <ns3:url>url</ns3:url>
      <ns3:email>Raymond.Bourges@univ-rennes1.fr</ns3:email>
      <ns3:last-name><xsl:value-of select="."/></ns3:last-name>
      <ns3:first-name><xsl:value-of select="."/></ns3:first-name>
      <xsl:for-each select="@dcfr:appid">
	<ns3:lab-ids><xsl:value-of select="."/></ns3:lab-ids>
      </xsl:for-each>
      <ns3:organism>CRI</ns3:organism>
    </ns3:authors>
  </xsl:template>

  <xsl:template match="dc:contributor[@xsi:type='dcfr:appartenance']">
    <ns1:laboratories xmlns:ns1="http://castor.exolab.org/"
		      ns1:known-labid="23" ns1:lab-id="1">
      <xsl:attribute name="ns1:lab-id"><xsl:value-of select="@dcfr:id"/></xsl:attribute>
      <ns1:short-name></ns1:short-name>
      <ns1:address></ns1:address>
      <ns1:name><xsl:value-of select="."/></ns1:name>
      <ns1:url></ns1:url>
      <ns1:affiliation>INRA</ns1:affiliation>
      <ns1:affiliation>EDF</ns1:affiliation>
      <ns1:pays></ns1:pays>
    </ns1:laboratories>
  </xsl:template>


  <xsl:template match="dc:title">
    <ns7:simples-metadatas xmlns:ns7="http://castor.exolab.org/">
      <ns7:meta-name>title</ns7:meta-name>
      <ns7:meta-value><xsl:value-of select="."/></ns7:meta-value>
    </ns7:simples-metadatas>
  </xsl:template>


  <xsl:template match="dcterms:abstract">
    <ns8:simples-metadatas xmlns:ns8="http://castor.exolab.org/">
      <ns8:meta-name>abstract</ns8:meta-name>
      <ns8:meta-value><xsl:value-of select="."/></ns8:meta-value>
    </ns8:simples-metadatas>
  </xsl:template>

  <xsl:template match="dc:language">
    <ns9:simples-metadatas xmlns:ns9="http://castor.exolab.org/">
      <ns9:meta-name>langue</ns9:meta-name>
      <ns9:meta-value><xsl:value-of select="."/></ns9:meta-value>
    </ns9:simples-metadatas>
  </xsl:template>


  <xsl:template match="dc:subject[@xsi:type='dcfr:HALkeyword']">
    <ns10:simples-metadatas xmlns:ns10="http://castor.exolab.org/">
      <ns10:meta-name>domain</ns10:meta-name>
      <ns10:meta-value><xsl:value-of select="."/></ns10:meta-value>
    </ns10:simples-metadatas>
  </xsl:template>

  <xsl:template match="dc:subject[not(@xsi:type)]">
    <ns11:simples-metadatas xmlns:ns11="http://castor.exolab.org/">
      <ns11:meta-name>keyword</ns11:meta-name>
      <ns11:meta-value><xsl:value-of select="."/></ns11:meta-value>
    </ns11:simples-metadatas>
  </xsl:template>


</xsl:stylesheet>
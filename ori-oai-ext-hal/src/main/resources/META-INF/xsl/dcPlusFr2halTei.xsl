<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:xs="http://www.w3.org/2001/XMLSchema"
		xmlns:dcfr="http://www.archives-ouvertes.fr/OAI/2.0/dc_plus_fr/" 
		xmlns:dc="http://purl.org/dc/elements/1.1/" 
		xmlns:dcterms="http://purl.org/dc/terms/"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:oai_dc="http://www.openarchives.org/OAI/2.0/oai_dc/"
                exclude-result-prefixes="dcfr dcterms" version="1.0">

    <xsl:output method="xml" indent="yes" encoding="utf-8" />

    <!--+
	| Disable xsl default rules
	+-->
    <xsl:template match="@*|node()" priority="-1">
    </xsl:template>

    <!--+
	| Document Root
	+-->
    <xsl:template match="dcfr:dc">
        <oai_dc:dc xsi:schemaLocation="http://www.openarchives.org/OAI/2.0/oai_dc/ http://www.openarchives.org/OAI/2.0/oai_dc.xsd">
            <xsl:apply-templates />
        </oai_dc:dc>
    </xsl:template>

    <!--+
        | We temporarily just copy the elements authorized in oai_dc
        | but still keep the authors 
        +-->
    <xsl:template match="*[starts-with(name(), 'dc:') and
                         (not(@xsi:type) or @xsi:type = 'dcfr:people')]">
        <xsl:element name="{name()}">
            <xsl:copy-of select="@xml:lang" />
            <xsl:value-of select="text()" />
        </xsl:element>
    </xsl:template>

</xsl:stylesheet>
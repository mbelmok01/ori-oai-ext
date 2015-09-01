<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:functx="http://www.functx.com"
		xmlns:xs="http://www.w3.org/2001/XMLSchema"
		xmlns:dcfr="http://www.archives-ouvertes.fr/OAI/2.0/dc_plus_fr/" 
		xmlns:dc="http://purl.org/dc/elements/1.1/" 
		xmlns:dcterms="http://purl.org/dc/terms/"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="2.0">

    <xsl:output method="xml" indent="yes" encoding="utf-8" />

    <!-- Global variables -->
    <xsl:variable name="not_direct_transfo" select="for $el in
						    (//dc:creator[@xsi:type = 'dcfr:people'],
						    //dc:contributor[@xsi:type = 'dcfr:appartenance'],
						    //dc:contributor[@xsi:type = 'dcfr:affiliation'])
						    return $el[normalize-space()]" />

    <xsl:variable name="not_simplemeta_seq" select="for $el in 
						    (//dc:identifier[@xsi:type = 'dcfr:hal_id' and node()],
						    //dc:creator[@xsi:type='dcfr:people'][1])
						    return $el[normalize-space()]" />

    <xsl:variable name="simplemeta_seq" select="for $el in /dcfr:dc/* return 
						if (empty(index-of($not_simplemeta_seq, $el)) 
						and empty(index-of($not_direct_transfo, $el))) 
						then $el[normalize-space()] else null" />


    <xsl:variable name="hal_type_doc_seq" select="('ART_ACL', 'ART_SCL', 'CONF_INV', 
						  'COMM_ACT', 'OUVS', 'COVS', 'DOUV', 
						  'OTHER', 'COMM_SACT', 'PATENT')" />

    <xsl:variable name="hal_type_doc" select="//dc:type[@xsi:type='dcfr:publicationType']" />

    <!--+
	| Disable xsl default rules
	+-->
    <xsl:template match="@*|node()" priority="-1">
    </xsl:template>

    <!--+
	| Document Root
	+-->
    <xsl:template match="dcfr:dc">
	<hal-dTO> 
	    <xsl:apply-templates select="$not_simplemeta_seq">
		<xsl:with-param name="lab_element_name" select="'laboratories'" tunnel="yes" />
	    </xsl:apply-templates>
	    <xsl:apply-templates select="$simplemeta_seq">
	    	<xsl:with-param name="simples_elements_name" select="'simples-metadatas'" tunnel="yes" />
	    </xsl:apply-templates>
	    <xsl:call-template name="metadatas" />
	</hal-dTO>
    </xsl:template>

    <!--+
	| ArticleIdentStruct
	+-->
    <xsl:template match="dc:identifier[@xsi:type = 'dcfr:hal_id' and node()]">
	<!-- elements names variables -->
	<xsl:variable name="prefix" select="concat('ns', count(preceding-sibling::*) + 1)" />      
	<xsl:variable name="qname_artidentstruct" select="concat($prefix, ':', 'art-ident-struct')" />
	<xsl:variable name="qname_version" select="concat($prefix, ':', 'version')" />
	<xsl:variable name="qname_password" select="concat($prefix, ':', 'passwd')" />
	<xsl:variable name="qname_identifiant" select="concat($prefix, ':', 'identifiant')" />
	<!-- miscellaneous variables -->
	<xsl:variable name="content_sequence" select="tokenize(., ',')" />
	<xsl:element name="{$qname_artidentstruct}" namespace="http://castor.exolab.org/">
	    <xsl:attribute name="{$qname_version}"
			   namespace="http://castor.exolab.org/">
		<xsl:value-of select="normalize-space($content_sequence[2])" />
	    </xsl:attribute>
	    <xsl:element name="{$qname_password}" 
			 namespace="http://castor.exolab.org/">
		<xsl:value-of select="normalize-space($content_sequence[3])" />
	    </xsl:element>
	    <xsl:element name="{$qname_identifiant}" 
			 namespace="http://castor.exolab.org/">
		<xsl:value-of select="normalize-space($content_sequence[1])" />
	    </xsl:element>
	</xsl:element>
    </xsl:template>
    
    <!--+
	| AuthorStruct
	+-->
    <xsl:template match="dc:creator[@xsi:type='dcfr:people']">
	<xsl:param name="transformed_labs_ids" as="xs:string*" select="()" />
	<xsl:param name="force_position" as="xs:integer" select="0" />
	<xsl:variable name="position" select="if ($force_position = 0) 
					      then count(preceding-sibling::*) + 1 
					      else $force_position" />
	<!-- elements names variables -->
	<xsl:variable name="prefix" select="concat('ns', $position)" />      
	<xsl:variable name="qname_author" select="concat($prefix, ':', 'authors')" />
	<xsl:variable name="qname_lastname" select="concat($prefix, ':', 'last-name')" />
	<xsl:variable name="qname_firstname" select="concat($prefix, ':', 'first-name')" />
	<xsl:variable name="qname_othername" select="concat($prefix, ':', 'other-name')" />
	<xsl:variable name="qname_email" select="concat($prefix, ':', 'email')" />
	<xsl:variable name="qname_url" select="concat($prefix, ':', 'url')" />
	<xsl:variable name="qname_organism" select="concat($prefix, ':', 'organism')" />
	<xsl:variable name="qname_rteam" select="concat($prefix, ':', 'research-team')" />
	<xsl:variable name="qname_labids" select="concat($prefix, ':', 'lab-ids')" />
	<!-- data variables -->
	<xsl:variable name="app_ids_sequence" select="tokenize(@dcfr:appid, '\|')" />
	<xsl:element name="{$qname_author}" 
		     namespace="http://castor.exolab.org/">
	    <xsl:element name="{$qname_lastname}" 
			 namespace="http://castor.exolab.org/">
		<xsl:value-of select="normalize-space(substring-before(., ','))" />
	    </xsl:element>
	    <xsl:element name="{$qname_firstname}" 
			 namespace="http://castor.exolab.org/">
		<xsl:value-of select="normalize-space(substring-after(., ', '))" />
	    </xsl:element>
	    <!-- Cannot be null (otherwise HAL (SOAP) error) -->
	    <xsl:element name="{$qname_othername}" 
			 namespace="http://castor.exolab.org/" />
	    <!-- Cannot be null (otherwise HAL (SOAP) error) -->
	    <xsl:element name="{$qname_email}" 
			 namespace="http://castor.exolab.org/" />
	    <!-- Cannot be null (otherwise HAL (SOAP) error) -->
	    <xsl:element name="{$qname_url}" 
			 namespace="http://castor.exolab.org/" />
	    <!-- Cannot be null (otherwise HAL (SOAP) error) -->
	    <xsl:element name="{$qname_rteam}" 
			 namespace="http://castor.exolab.org/" />
	    <!-- Cannot be null (otherwise HAL (SOAP) error) -->
	    <xsl:element name="{$qname_organism}" 
			 namespace="http://castor.exolab.org/">
		<xsl:variable name="affid" select="@dcfr:affid" />
		<xsl:value-of select="normalize-space(//dc:contributor[@xsi:type='dcfr:affiliation' 
				      and @dcfr:id = $affid])" />
	    </xsl:element>
	    <xsl:for-each select="$app_ids_sequence">
		<xsl:element name="{$qname_labids}"
			     namespace="http://castor.exolab.org/">
		    <xsl:choose>
			<xsl:when test="starts-with(., 'hal-')">
			    <xsl:value-of select="substring-after(., 'hal-')" />
			</xsl:when>
			<xsl:otherwise>
			    <xsl:value-of select="." />
			</xsl:otherwise>
		    </xsl:choose>
		</xsl:element>
	    </xsl:for-each>
	</xsl:element>
	<!-- laboratories the author is bound to -->
	<xsl:apply-templates select="//dc:contributor[@xsi:type = 'dcfr:appartenance' 
				     and index-of($app_ids_sequence, @dcfr:id)
				     and empty(index-of($transformed_labs_ids, @dcfr:id))][normalize-space()]">
	    <xsl:with-param name="force_position" select="$force_position" />
	</xsl:apply-templates>
	<!-- next author -->
	<xsl:apply-templates select="following-sibling::dc:creator[@xsi:type = 'dcfr:people'][1]">
	    <xsl:with-param name="transformed_labs_ids" 
			    select="for $item in $app_ids_sequence return 
				    insert-before($transformed_labs_ids, 0, $item)" />
	    <xsl:with-param name="force_position" select="$force_position" />
	</xsl:apply-templates>
    </xsl:template>

    <!--+
	| Laboratories
	+-->
    <xsl:template match="dc:contributor[@xsi:type='dcfr:appartenance']">
	<xsl:param name="lab_element_name" tunnel="yes" />
	<xsl:param name="force_position" as="xs:integer" select="0" />
	<xsl:variable name="position" select="if ($force_position = 0) 
					      then count(preceding-sibling::*) + 1 
					      else $force_position" />
	<!-- elements names variables -->
	<xsl:variable name="prefix" select="concat('ns', $position)" />
	<xsl:variable name="qname_labos" select="concat($prefix, ':', $lab_element_name)" />
	<xsl:variable name="qname_knownlabid" select="concat($prefix, ':', 'known-labid')" />
	<xsl:variable name="qname_labid" select="concat($prefix, ':', 'lab-id')" />
	<xsl:variable name="qname_shortname" select="concat($prefix, ':', 'short-name')" />
	<xsl:variable name="qname_name" select="concat($prefix, ':', 'name')" />
	<xsl:variable name="qname_url" select="concat($prefix, ':', 'url')" />
	<xsl:variable name="qname_address" select="concat($prefix, ':', 'address')" />
	<xsl:variable name="qname_pays" select="concat($prefix, ':', 'pays')" />
	<!-- miscellaneous variables -->
	<xsl:variable name="content_sequence" select="tokenize(., ',')" />
	<xsl:variable name="aff_ids_sequence" select="tokenize(@dcfr:affid, '\|')" />
	<xsl:variable name="is_hal_lab" select="starts-with(@dcfr:id, 'hal-')" />
	<xsl:element name="{$qname_labos}" namespace="http://castor.exolab.org/">
	    <xsl:if test="$is_hal_lab">
		<xsl:attribute name="{$qname_knownlabid}"
			       namespace="http://castor.exolab.org/">
		    <xsl:value-of select="substring-after(@dcfr:id, 'hal-')" />
		</xsl:attribute>
	    </xsl:if>
	    <xsl:attribute name="{$qname_labid}"
			   namespace="http://castor.exolab.org/">
		<xsl:choose>
		    <xsl:when test="$is_hal_lab">
			<xsl:value-of select="substring-after(@dcfr:id, 'hal-')" />
		    </xsl:when>
		    <xsl:otherwise>
			<xsl:value-of select="@dcfr:id" />
		    </xsl:otherwise>
		</xsl:choose>
	    </xsl:attribute>
	    <xsl:element name="{$qname_shortname}"
			 namespace="http://castor.exolab.org/">
		<xsl:if test="not($is_hal_lab)">
		    <xsl:value-of select="normalize-space($content_sequence[1])" />
		</xsl:if>
	    </xsl:element>
	    <xsl:element name="{$qname_name}"
			 namespace="http://castor.exolab.org/">
		<xsl:if test="not($is_hal_lab)">
		    <xsl:value-of select="normalize-space($content_sequence[2])" />
		</xsl:if>
	    </xsl:element>
	    <xsl:element name="{$qname_url}"
			 namespace="http://castor.exolab.org/" />
	    <xsl:element name="{$qname_address}"
			 namespace="http://castor.exolab.org/">
		<xsl:if test="not($is_hal_lab)">
		    <xsl:value-of select="@dcfr:adresse_labo" />
		</xsl:if>
	    </xsl:element>
	    <xsl:element name="{$qname_pays}"
			 namespace="http://castor.exolab.org/">
		<xsl:if test="not($is_hal_lab)">
		    <xsl:value-of select="@dcfr:pays_labo" />
		</xsl:if>
	    </xsl:element>
	    <!-- affiliations -->
	    <xsl:apply-templates select="//dc:contributor[@xsi:type = 'dcfr:affiliation' 
					 and index-of($aff_ids_sequence, @dcfr:id)][normalize-space()]">
		<xsl:with-param name="prefix" select="$prefix" />
	    </xsl:apply-templates>
	</xsl:element>
    </xsl:template>

    <!--+
	| Affiliations
	+-->
    <xsl:template match="dc:contributor[@xsi:type = 'dcfr:affiliation']">
	<xsl:param name="prefix" />
	<xsl:variable name="qname_affiliation" select="concat($prefix, ':', 'affiliation')" />
	<xsl:element name="{$qname_affiliation}"
		     namespace="http://castor.exolab.org/">
	    <xsl:value-of select="normalize-space(.)" />
	</xsl:element>
    </xsl:template>


    <!-- ### SimpleMetaDatas ### -->

    <!--+
	| Title
	+--> 
    <xsl:template match="dc:title[not(@xsi:type)]">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'title'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Abstract
	+--> 
    <xsl:template match="dcterms:abstract">
	<xsl:variable name="metadata_name">
	    <xsl:choose>
		<xsl:when test="@xml:lang = 'fr'">
		    <xsl:text>abstract</xsl:text>
		</xsl:when>
		<xsl:when test="@xml:lang = 'en'">
		    <xsl:text>abstract_second</xsl:text>
		</xsl:when>
		<xsl:otherwise>
		    <xsl:text>abstract_ml</xsl:text>
		</xsl:otherwise>
	    </xsl:choose>
	</xsl:variable>
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="$metadata_name" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Language
	+--> 
    <xsl:template match="dc:language">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'langue'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	    <xsl:with-param name="force_value"  select="upper-case(text())" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| DOI
	+-->
    <xsl:template match="dc:identifier[@xsi:type = 'dcfr:DOI']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'doi'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	    <xsl:with-param name="prefix_to_remove" select="'doi:'" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| dcterms:URI
	+-->
    <xsl:template match="dc:identifier[@xsi:type = 'dcterms:URI']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'meta_url'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| PMID
	+-->
    <xsl:template match="dc:identifier[@xsi:type = 'dcfr:PMID']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'pmid'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| arXiv ID
	+-->
    <xsl:template match="dc:identifier[@xsi:type = 'dcfr:arXiv']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'arxivid'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Numéro Brevet
	+-->
    <xsl:template match="dc:identifier[@xsi:type = 'dcfr:num_brevet']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'numbrevet'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| ISSN
	+-->
    <xsl:template match="dc:identifier[@xsi:type = 'dcfr:ISSN']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'issn'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Equipes de recherche
	+-->
    <xsl:template match="dc:contributor[@xsi:type = 'dcfr:equipe'][1]">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'researchteam'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	    <xsl:with-param name="concatenate" select="true()" />
	    <xsl:with-param name="nodeset_to_iterate_on" select="//dc:contributor[@xsi:type='dcfr:equipe']" />
	    <xsl:with-param name="concatenation_token" select="';'" />
	</xsl:call-template>
    </xsl:template>


    <!--+
	| Subject (Hal domains)
	+--> 
    <xsl:template match="dc:subject[@xsi:type='dcfr:HALkeyword'][1]">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'domain'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	    <xsl:with-param name="concatenate" select="true()" />
	    <xsl:with-param name="nodeset_to_iterate_on" select="//dc:subject[@xsi:type='dcfr:HALkeyword']" />
	    <xsl:with-param name="concatenation_token" select="';'" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Subject (Free keywords)
	+--> 
    <xsl:template match="dc:subject[not(@xsi:type)][1]">
	<xsl:param name="cpt_lang_seq" select="1" />
	<xsl:variable name="lang_seq" select="distinct-values(for $lang in //dc:subject[not(@xsi:type)]/@xml:lang return $lang)" />
	<xsl:variable name="language" select="$lang_seq[$cpt_lang_seq]" />
	<xsl:variable name="metadata_name">
	    <xsl:choose>
	    	<xsl:when test="$language = 'fr'">
	    	    <xsl:text>keyword</xsl:text>
	    	</xsl:when>
	    	<xsl:when test="$language = 'en'">
	    	    <xsl:text>keyword_second</xsl:text>
	    	</xsl:when>
	    	<xsl:otherwise>
	    	    <xsl:text>keyword_ml</xsl:text>
	    	</xsl:otherwise>
	    </xsl:choose>
	</xsl:variable>
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="$metadata_name" />
	    <xsl:with-param name="position" select="count(preceding-sibling::*) + $cpt_lang_seq" />
	    <xsl:with-param name="concatenate" select="true()" />
	    <xsl:with-param name="nodeset_to_iterate_on" select="//dc:subject[not(@xsi:type)][@xml:lang = $language]" />
	    <xsl:with-param name="concatenation_token" select="';'" />
	</xsl:call-template>
	<xsl:if test="$cpt_lang_seq lt count($lang_seq)">
	    <xsl:apply-templates select="//dc:subject[not(@xsi:type)]">
		<xsl:with-param name="cpt_lang_seq" select="$cpt_lang_seq + 1" />
	    </xsl:apply-templates>
	</xsl:if>
    </xsl:template>

    <!--+
	| Subject (MESH keywords)
	+--> 
    <xsl:template match="dc:subject[@xsi:type='dcterms:MESH'][1]">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'keyword_mesh'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	    <xsl:with-param name="concatenate" select="true()" />
	    <xsl:with-param name="nodeset_to_iterate_on" select="//dc:subject[@xsi:type='dcterms:MESH']" />
	    <xsl:with-param name="concatenation_token" select="';'" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Date de production, écriture
	+--> 
    <xsl:template match="dcterms:created">
	<xsl:variable name="modified" select="//dcterms:modified[normalize-space()]" />
	<xsl:choose>
	    <xsl:when test="$modified">
		<xsl:call-template name="created_or_modified">
		    <xsl:with-param name="current_node" select="$modified" />
		    <xsl:with-param name="position" select="count(preceding-sibling::*) + 1" />
		</xsl:call-template>
	    </xsl:when>
	    <xsl:otherwise>
		<xsl:call-template name="created_or_modified">
		    <xsl:with-param name="current_node" select="." />
		    <xsl:with-param name="position" select="count(preceding-sibling::*) + 1" />
		</xsl:call-template>
	    </xsl:otherwise>
	</xsl:choose>
    </xsl:template>

    <!--+
	| Durée d'embargo HAL
	+-->
    <xsl:template match="dcterms:available[@xsi:type = 'dcfr:distantServiceEmbargo']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'datevisible'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>
    

    <!--+
	| PublicationType
	+-->
    <xsl:template match="dc:type[@xsi:type = 'dcfr:publicationType']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'typepubli'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
        | Projet européen
        +-->
    <xsl:template match="dc:contributor[@xsi:type = 'dcfr:funder']">
        <xsl:call-template name="simple_metadatas">
            <xsl:with-param name="current_node" select="." />
            <xsl:with-param name="metadata_name" select="'financement'" />
            <xsl:with-param name="position" select="count(preceding-sibling::*) + 1" />
        </xsl:call-template>
    </xsl:template>

    <!-- Références Bibliographique -->

    <!--+
	| Title dcfr:referenceTitle
	+--> 
    <xsl:template match="dc:title[@xsi:type = 'dcfr:referenceTitle']">
	<!-- ART_ACL or ART_SCL => journal -->
	<xsl:if test="exists(index-of(('ART_ACL', 'ART_SCL'), $hal_type_doc))">
	    <xsl:call-template name="simple_metadatas">
		<xsl:with-param name="current_node" select="." />
		<xsl:with-param name="metadata_name" select="'journal'" />
		<xsl:with-param name="position"  select="count(preceding-sibling::*) + 1 + count(//*)" />
	    </xsl:call-template>
	</xsl:if>
	<!-- COMM_SACT or DOUV => titconf only -->
	<xsl:if test="exists(index-of(('COMM_SACT', 'DOUV'), $hal_type_doc))">
	    <xsl:call-template name="simple_metadatas">
		<xsl:with-param name="current_node" select="." />
		<xsl:with-param name="metadata_name" select="'titconf'" />
		<xsl:with-param name="position"  select="count(preceding-sibling::*) + 1 + count(//*)" />
	    </xsl:call-template>
	</xsl:if>
	<!-- COVS => titouv only -->
	<xsl:if test="exists(index-of(('COVS'), $hal_type_doc))">
	    <xsl:call-template name="simple_metadatas">
		<xsl:with-param name="current_node" select="." />
		<xsl:with-param name="metadata_name" select="'titouv'" />
		<xsl:with-param name="position"  select="count(preceding-sibling::*) + 1 + count(//*)" />
	    </xsl:call-template>
	</xsl:if>
	<!-- COMM_ACT or CONF_INV => titconf AND titouv -->
	<xsl:if test="exists(index-of(('COMM_ACT', 'CONF_INV'), $hal_type_doc))">
	    <xsl:if test=".[following-sibling::*[1]/@xsi:type != 'dcfr:referenceDate']">
		<xsl:call-template name="simple_metadatas">
		    <xsl:with-param name="current_node" select="." />
		    <xsl:with-param name="metadata_name" select="'titouv'" />
		    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1 + count(//*)" />
		</xsl:call-template>
	    </xsl:if>
	    <xsl:if test=".[following-sibling::*[1][@xsi:type = 'dcfr:referenceDate'][normalize-space()]]">
		<xsl:call-template name="simple_metadatas">
		    <xsl:with-param name="current_node" select="." />
		    <xsl:with-param name="metadata_name" select="'titconf'" />
		    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1 + count(//*)" />
	    </xsl:call-template>
	    </xsl:if>
	</xsl:if>
        <!-- OTHER => description -->
        <xsl:if test="exists(index-of(('OTHER'), $hal_type_doc))">
	    <xsl:call-template name="simple_metadatas">
		<xsl:with-param name="current_node" select="." />
		<xsl:with-param name="metadata_name" select="'description'" />
		<xsl:with-param name="position"  select="count(preceding-sibling::*) + 1 + count(//*)" />
	    </xsl:call-template>            
        </xsl:if>
    </xsl:template>

    <!--+
	| Audience
	+--> 
    <xsl:template match="dcterms:audience[@xsi:type = 'dcfr:referenceAudience']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'audience'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>
    
    <!--+
	| Page, identifiant
	+--> 
    <xsl:template match="dcterms:extent[@xsi:type = 'dcfr:referenceExtent']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'page'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Date de publication
	+--> 
    <xsl:template match="dcterms:issued[@xsi:type = 'dcfr:referenceIssued']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'datepub'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Date de la conférence
	+--> 
    <xsl:template match="dc:date[@xsi:type = 'dcfr:referenceDate'][1]">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'dateconf'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
        <xsl:if test="following-sibling::dc:date[@xsi:type = 'dcfr:referenceDate'
                      and normalize-space(.)]">
            <xsl:call-template name="simple_metadatas">
                <xsl:with-param name="current_node" select="." />
                <xsl:with-param name="metadata_name" select="'date_debut_conf'" />
                <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
            </xsl:call-template>
        </xsl:if>
    </xsl:template>

    <!--+
	| Date de fin de la conférence
	+--> 
    <xsl:template match="dc:date[@xsi:type = 'dcfr:referenceDate'][2]">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'date_fin_conf'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Ville, Pays de la conf
	+--> 
    <xsl:template match="dcterms:spatial[@xsi:type = 'dcfr:referenceSpatial']">
	<xsl:variable name="value_seq" select="tokenize(., ',')" />
        <xsl:if test="normalize-space($value_seq[2])">
            <xsl:call-template name="simple_metadatas">
                <xsl:with-param name="current_node" select="." />
                <xsl:with-param name="metadata_name" select="'ville'" />
                <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
                <xsl:with-param name="force_value"  select="$value_seq[1]" />
            </xsl:call-template>
        </xsl:if>
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'pays'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1 + count(//*)" />
	    <xsl:with-param name="force_value"  select="if(normalize-space($value_seq[2]))
                                                        then $value_seq[2]
                                                        else $value_seq[1]" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Éditeur commercial
	+--> 
    <xsl:template match="dc:publisher[@xsi:type = 'dcfr:referencePublisher']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'edcom'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Éditeur Scientifique
	+--> 
    <xsl:template match="dc:contributor[@xsi:type = 'dcfr:referenceEdsci']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'edsci'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| URL de l'Éditeur (accès à la revue)
	+--> 
    <xsl:template match="dc:relation[@xsi:type = 'dcfr:referenceRelation']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'url_editeur'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Directeur de Collection
	+--> 
    <xsl:template match="dc:contributor[@xsi:type = 'dcfr:referenceDircoll']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'dircoll'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Série
	+--> 
    <xsl:template match="dcterms:bibliographicCitation[@xsi:type = 'dcfr:referenceSerie']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'serie'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Volume
	+--> 
    <xsl:template match="dcterms:bibliographicCitation[@xsi:type = 'dcfr:referenceVolume']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'volume'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>

    <!--+
	| Numéro
	+--> 
    <xsl:template match="dcterms:bibliographicCitation[@xsi:type = 'dcfr:referenceIssue']">
	<xsl:call-template name="simple_metadatas">
	    <xsl:with-param name="current_node" select="." />
	    <xsl:with-param name="metadata_name" select="'issue'" />
	    <xsl:with-param name="position"  select="count(preceding-sibling::*) + 1" />
	</xsl:call-template>
    </xsl:template>


    <!-- ######### Règles nommées ######### -->

    <!--+
	| SimpleMetaDatas
	+--> 
    <xsl:template name="simple_metadatas">
	<xsl:param name="current_node" as="element()" select="." />
	<xsl:param name="metadata_name" as="xs:string" select="''" />
	<xsl:param name="prefix_to_remove" as="xs:string" select="''" />
	<xsl:param name="force_value" as="xs:string" select="''" />
	<xsl:param name="position" as="xs:integer" />
	<xsl:param name="force_position" as="xs:integer" select="0" tunnel="yes" />
	<xsl:param name="simples_elements_name" as="xs:string" tunnel="yes" />
	<xsl:param name="concatenate" as="xs:boolean" select="false()" />
	<xsl:param name="nodeset_to_iterate_on" as="element()*" select="." />
	<xsl:param name="concatenation_token" as="xs:string" select="';'" />
	<xsl:variable name="position_var" select="if ($force_position = 0)
						  then $position
						  else $force_position" />
	<xsl:for-each select="$current_node">
	    <!-- elements names variables -->
	    <xsl:variable name="prefix" select="concat('ns', $position_var)" />
	    <xsl:variable name="qname_simplemeta" select="concat($prefix, ':', $simples_elements_name)" />
	    <xsl:variable name="qname_metaname" select="concat($prefix, ':', 'meta-name')" />
	    <xsl:variable name="qname_metavalue" select="concat($prefix, ':', 'meta-value')" />
	    <xsl:element name="{$qname_simplemeta}"
			 namespace="http://castor.exolab.org/">
		<xsl:element name="{$qname_metaname}"
			     namespace="http://castor.exolab.org/">
		    <xsl:value-of select="$metadata_name" />
		</xsl:element>
		<xsl:element name="{$qname_metavalue}"
			     namespace="http://castor.exolab.org/">
		    <xsl:call-template name="simple_metadatas_value">
		    	<xsl:with-param name="concatenate" select="$concatenate" />
		    	<xsl:with-param name="nodeset_to_iterate_on" select="$nodeset_to_iterate_on" />
		    	<xsl:with-param name="concatenation_token" select="$concatenation_token" />
		    	<xsl:with-param name="prefix_to_remove" select="$prefix_to_remove" />
			<xsl:with-param name="force_value" select="$force_value" />
		    </xsl:call-template>
		</xsl:element>
	    </xsl:element>
	</xsl:for-each>
    </xsl:template>

    <xsl:template name="simple_metadatas_value">
	<xsl:param name="concatenate" as="xs:boolean" select="false()" />
	<xsl:param name="nodeset_to_iterate_on" as="element()*" select="." />
	<xsl:param name="concatenation_token" as="xs:string" select="';'" />
	<xsl:param name="prefix_to_remove" as="xs:string" select="''" />
	<xsl:param name="force_value" as="xs:string" select="''" />
	<xsl:choose>
	    <xsl:when test="$concatenate">
		<xsl:variable name="keywords_seq">
		    <xsl:for-each select="$nodeset_to_iterate_on">
			<xsl:call-template name="treat_value_prefix">
			    <xsl:with-param name="prefix_to_remove" select="$prefix_to_remove" />
			    <xsl:with-param name="force_value" select="$force_value" />
			</xsl:call-template>
			<xsl:value-of select="$concatenation_token" />
		    </xsl:for-each>
		</xsl:variable>
		<!-- remove the last concatenation character -->
		<xsl:value-of select="substring($keywords_seq, 0, string-length($keywords_seq))" />
	    </xsl:when>
	    <xsl:otherwise>
		<xsl:call-template name="treat_value_prefix">
		    <xsl:with-param name="prefix_to_remove" select="$prefix_to_remove" />
		    <xsl:with-param name="force_value" select="$force_value" />
		</xsl:call-template>
	    </xsl:otherwise>
	</xsl:choose>
    </xsl:template>

    <xsl:template name="treat_value_prefix">
	<xsl:param name="prefix_to_remove" as="xs:string" />
	<xsl:param name="force_value" as="xs:string" select="''" />
	<xsl:choose>
	    <xsl:when test="$force_value">
		<xsl:value-of select="normalize-space($force_value)" />
	    </xsl:when>
	    <xsl:otherwise>
		<xsl:choose>
		    <xsl:when test="$prefix_to_remove">
			<xsl:value-of select="normalize-space(substring-after(., $prefix_to_remove))" />
		    </xsl:when>
		    <xsl:otherwise>
			<xsl:value-of select="normalize-space(.)" />
		    </xsl:otherwise>
		</xsl:choose>
	    </xsl:otherwise>
	</xsl:choose>
    </xsl:template>

    <!--+
	| hal:writing_date : dcterms:created or dcterms:modified
	+--> 
    <xsl:template name="created_or_modified">
	<xsl:param name="current_node" />
	<xsl:param name="position" />
	<xsl:for-each select="$current_node">
	    <xsl:call-template name="simple_metadatas">
		<xsl:with-param name="current_node" select="." />
		<xsl:with-param name="metadata_name" select="'writing_date'" />
		<xsl:with-param name="position"  select="$position" />
	    </xsl:call-template>
	</xsl:for-each>
    </xsl:template>

    <!--+
	| metadatas
	+-->
    <xsl:template name="metadatas">
	<!-- elements names variables -->
	<xsl:variable name="prefix" select="concat('ns', count(//*) + count(//*))" />
	<xsl:variable name="qname_metadatasstruct" select="concat($prefix, ':', 'metadatas')" />
	<xsl:variable name="qname_autlabstruct" select="concat($prefix, ':', 'meta-aut-lab')" />
	<xsl:element name="{$qname_metadatasstruct}" namespace="http://castor.exolab.org/">
	    <xsl:element name="{$qname_autlabstruct}" namespace="http://castor.exolab.org/">
		<xsl:apply-templates select="dc:creator[@xsi:type='dcfr:people'][1]">
		    <xsl:with-param name="lab_element_name" select="'labs'" tunnel="yes" />
		    <xsl:with-param name="force_position" select="count(//*) + count(//*)" />
		</xsl:apply-templates>
	    </xsl:element>
	    <xsl:apply-templates select="$simplemeta_seq">
		<xsl:with-param name="simples_elements_name" select="'meta-simple'" tunnel="yes" />
		<xsl:with-param name="force_position" select="count(//*) + count(//*)" tunnel="yes" />
	    </xsl:apply-templates>
	</xsl:element>
    </xsl:template>

    <!-- Really usefull ? index-of() does that already, doesn't it ? -->
    <xsl:template name="find_item_index_in_seq">
	<xsl:param name="seq" />
	<xsl:param name="cpt_seq" />
	<xsl:param name="target_item" />
	<xsl:choose>
	    <xsl:when test="$cpt_seq = count($seq)">
		<xsl:value-of select="$target_item" />
	    </xsl:when>
	    <xsl:when test="$seq[$cpt_seq] = $target_item">
		<xsl:value-of select="$cpt_seq" />
	    </xsl:when>
	    <xsl:otherwise>
		<xsl:call-template name="find_item_index_in_seq">
		    <xsl:with-param name="seq" select="$seq" />
		    <xsl:with-param name="cpt_seq" select="$cpt_seq + 1" />
		    <xsl:with-param name="target_item" select="$target_item" />
		</xsl:call-template>
	    </xsl:otherwise>
	</xsl:choose>
    </xsl:template>

</xsl:stylesheet>


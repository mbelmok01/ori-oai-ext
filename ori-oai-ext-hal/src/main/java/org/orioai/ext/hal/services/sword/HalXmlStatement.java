package org.orioai.ext.hal.services.sword;
/*
 * Copyright (c) 2011, Richard Jones, Cottage Labs
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */



import org.apache.abdera.i18n.iri.IRI;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Element;
import org.apache.abdera.parser.stax.FOMExtensibleElement;
import org.apache.abdera.protocol.client.ClientResponse;
import org.swordapp.client.ResourceState;
import org.swordapp.client.SWORDClientException;
import org.swordapp.client.ServerResource;
import org.swordapp.client.Statement;
import org.swordapp.client.StatementParseException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * An implementation of the Statement interface for representing a SWORD Statement
 * document serialised as an Atom Feed.
 */
public class HalXmlStatement implements Statement
{
	private FOMExtensibleElement fomExtensibleElement;
    private String contentMD5;
    private Date lastModified;
    private String location;

    /**
     * Parse the Abdera ClientResponse object and populate this object with the
     * data found therein
     *
     * @param resp
     * @throws SWORDClientException
     * @throws StatementParseException
     */
	public void parse(ClientResponse resp)
			throws SWORDClientException, StatementParseException
	{
        this.contentMD5 = resp.getHeader("Content-MD5");
        String rfc822date = resp.getHeader("Last-Modified");
        this.location = resp.getUri();
        
        if (rfc822date != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
            try
            {
                this.lastModified = sdf.parse(rfc822date);
            }
            catch (ParseException e)
            {
                // doesn't matter, we just ignore the date
            }
        }

        // now parse the feed itself
        Document<FOMExtensibleElement> doc = resp.getDocument();
		this.fomExtensibleElement = doc.getRoot();
	}

    /**
     * The mimetype of an Atom formatted Statement
     *
     * @return
     */
	public String getMimeType()
	{
		return "application/xml";
	}

    /**
     * List all the parts of the item as described in the Statement
     *
     * @return
     * @throws SWORDClientException
     */
    public List<ServerResource> getParts()
            throws SWORDClientException
    {
        // NOT IMPLEMENTED
    	return null;
    }

    /**
     * List all the parts of the item as represented by the statement which have been
     * marked as Original Deposits
     * 
     * @return
     * @throws SWORDClientException
     */
    public List<ServerResource> getOriginalDeposits() throws SWORDClientException
    {
    	// NOT IMPLEMENTED
    	return null;
    }

    /**
     * Get a list of state objects which represent the item
     *
     * @return
     * @throws SWORDClientException
     */
    public List<ResourceState> getState()
			throws SWORDClientException

    {
		try
		{
			List<ResourceState> states = new ArrayList<ResourceState>();
			
			String status = null;
			
			List<Element> elements = this.fomExtensibleElement.getElements();
			for (Element element : elements) {
				if (element.getQName().getLocalPart().equals("status")) {
					status = element.getText();
				}
			}
			
			if (status!=null) {
				ResourceState state = new ResourceState();
				state.setIri(new IRI(location));
				state.setDescription(status);
				states.add(state);
			}
			
			return states;
		}
		catch (Exception e)
		{
			throw new SWORDClientException(e);
		}
	}
    
    
    
    
    /**
	 * @return the id
	 */
	public String getId() throws SWORDClientException {
		try {
			return this.fomExtensibleElement.getAttributeValue("id");
		}
		catch (Exception e) {
			throw new SWORDClientException(e);
		}
	}

	/**
	 * @return the version
	 */
	public String getVersion() throws SWORDClientException {
		try {
			return this.fomExtensibleElement.getAttributeValue("version");
		}
		catch (Exception e) {
			throw new SWORDClientException(e);
		}
	}

	/**
	 * @return the password
	 */
	public String getPassword() throws SWORDClientException {
		try {
			return this.fomExtensibleElement.getAttributeValue("password");
		}
		catch (Exception e) {
			throw new SWORDClientException(e);
		}
	}

	/**
	 * @return the comment
	 */
	public String getComment() throws SWORDClientException {
		try
		{
			String comment = null;
			
			List<Element> elements = this.fomExtensibleElement.getElements();
			for (Element element : elements) {
				if (element.getQName().getLocalPart().equals("comment")) {
					comment = element.getText();
				}
			}
			
			return comment;
		}
		catch (Exception e)
		{
			throw new SWORDClientException(e);
		}
	}

	

    public String getContentMD5()
            throws SWORDClientException
    {
        return this.contentMD5;
    }

    public Date getLastModified() throws SWORDClientException
    {
        return this.lastModified;
    }

    /**
     * Nice string representation of the feed - a fully pretty printed
     * XML dump
     * 
     * @return
     */
    public String toString()
	{
		try
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			this.fomExtensibleElement.writeTo(baos);
			return baos.toString();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}

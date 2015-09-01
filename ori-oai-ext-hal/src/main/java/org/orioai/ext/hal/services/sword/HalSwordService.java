package org.orioai.ext.hal.services.sword;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.springframework.beans.factory.annotation.Value;
import org.swordapp.client.AuthCredentials;
import org.swordapp.client.Deposit;
import org.swordapp.client.DepositFactory;
import org.swordapp.client.DepositReceipt;
import org.swordapp.client.ResourceState;
import org.swordapp.client.SWORDClient;
import org.swordapp.client.SWORDError;
import org.swordapp.client.Statement;
import org.swordapp.client.UriRegistry;

/*
 * Created on 9 janv. 2015
 */
/**
 * ORI-OAI-search - Copyright (c) 2012 ORI-OAI
 * For any information please refer to http://www.ori-oai.org
 * You may obtain a copy of the licence at http://www.ori-oai.org/Licence
 */

/**
 * Id: SwordTest.java,v 1.0 9 janv. 2015 Copyright (c) 2012 ORI-OAI
 * (www.ori-oai.org) Classes: SwordTest Original Author: Yohan Colmant
 * 
 */
public class HalSwordService {

	private @Value("${hal.sword.url}") String swordUrl;
	private @Value("${hal.sword.login}") String swordLogin;
	private @Value("${hal.sword.password}") String swordPassword;
	
	private @Value("${hal.sword.idPrefix}") String swordIdPrefix;
	private @Value("${hal.sword.packaging}") String swordPackaging;
	
	private static final String SWORD_NAMESPACE = "http://purl.org/net/sword/";
	
	private SWORDClient client;
	
	/**
	 * 
	 */
	public HalSwordService() {
	}
	
	
	private SWORDClient getSWORDClient() {
		if (client==null) {
			client = new SWORDClient();
			UriRegistry.SWORD_TERMS_NAMESPACE = SWORD_NAMESPACE;
		}
		return client;
	}
	

	
	
	private void trustCertificate(String url) {

		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { 
			new X509TrustManager() {
				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}

				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}
			} 
		};
		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		}
		catch (Exception e) {
			System.err.println("Error when opening https site : "+url+" ("+e.getMessage()+")");
		}
		// Set at true the HostnameVerifier
		HostnameVerifier hv = new HostnameVerifier() {
			@Override
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}
	
	
	
	
	public String HalUploadXml(String xmlFileContent, String xmlFileName) throws MethodExecutionException {
		return HalUpload(null, xmlFileContent, xmlFileName, "text/xml");
	}
	
	public String HalUploadZip(File zipFile, String xmlFileName) throws MethodExecutionException {
		return HalUpload(zipFile, null, xmlFileName, "application/zip");
	}
	
	
	private String HalUpload(File file, String fileContent, String xmlFileName, String mimeType) throws MethodExecutionException {
		System.out.println("HalUpload :: 1");
		
		try {
			AuthCredentials auth = new AuthCredentials(swordLogin, swordPassword);
			System.out.println("HalUpload :: 2 :: auth="+auth);
					
			DepositFactory factory = new DepositFactory();
			Deposit deposit = null;
			System.out.println("HalUpload :: 3");
			
			InputStream is = null;
			if (file!=null) {
				is = new FileInputStream(file);
			}
			else {
				is = new ByteArrayInputStream(fileContent.getBytes("utf-8"));
			}
			deposit = factory.newBinaryOnly(is, xmlFileName, mimeType, swordPackaging);
			System.out.println("HalUpload :: 4");
			
			DepositReceipt receipt = getSWORDClient().deposit(swordUrl, deposit, auth);
			System.out.println("HalUpload :: 5");
			
			try {
				is.close();
			}
			catch(IOException ioe) {
				System.err.println("HalUpload :: error while closing is "+ioe);
			}
			
			System.out.println("HalUpload :: 6");
			
			int statusCode = receipt.getStatusCode();
			String depositLocation = receipt.getLocation();
			String swordId = receipt.getEntry().getId().toString();
			String id = swordId.replaceAll(swordIdPrefix, "");
			
			System.out.println("HalUpload :: END :: statusCode=" + statusCode);
			System.out.println("HalUpload :: END :: depositLocation=" + depositLocation);
			System.out.println("HalUpload :: END :: id=" + id);
			System.out.println("HalUpload :: END :: receipt.getEntry().getAlternateLink().getHref()=" + receipt.getEntry().getAlternateLink().getHref());
			System.out.println("HalUpload :: END :: receipt.getEntry().getId()=" + swordId);
			System.out.println("HalUpload :: END :: receipt.getEntry()="+receipt.getEntry());
			
			if (statusCode==201 && id!=null) {
				return id;
			}
			else {
				throw new MethodExecutionException("upload", "ERROR :: statusCode="+statusCode+" , id="+id+", receipt="+receipt);
			}
		}
		catch(Exception e) {
			String faultString = "";
			String faultMessage = "";
			
			System.err.println("HalUpload :: error 1 :: xmlFileName="+xmlFileName);
			if (e instanceof SWORDError) {
				if (((SWORDError)e).getErrorDoc()!=null) {
					faultMessage = faultMessage+((SWORDError)e).getSummary();
					faultMessage = faultMessage+" :: ";
					faultMessage = faultMessage+((SWORDError)e).getVerboseDescription();
					
					faultString = ((SWORDError)e).getVerboseDescription();
					
					System.err.println("HalUpload :: error 2a :: "+((SWORDError)e).getSummary());
					System.err.println("HalUpload :: error 2b :: "+((SWORDError)e).getVerboseDescription());
					System.err.println("HalUpload :: error 2c :: "+((SWORDError)e).getErrorDoc().toXML());
				}
				else {
					faultMessage = e.getMessage();
					faultString = e.getMessage();
					
					System.err.println("HalUpload :: error 2");
				}
			}
			else {
				faultMessage = e.getMessage();
				faultString = e.getMessage();
				
				e.printStackTrace();
				System.err.println("HalUpload :: error 2");
			}
			
			MethodExecutionException methodExecutionException = new MethodExecutionException("upload", faultMessage, e, true);
			methodExecutionException.setFaultString(faultString);
			throw methodExecutionException;
		}
	}
	
	
	
	
	
	

	public String[] HalStatus(String id) throws MethodExecutionException {
		
		String[] statusElements = new String[4];
		
		System.out.println("HalStatus :: 1");
		
		String location = swordUrl + id;
		try {
			URL urlLocation = new URL(location);
			if (urlLocation.getProtocol().equals("https")) {
				trustCertificate(location);
			}
		
			// first we need to put some content in
			AuthCredentials auth = new AuthCredentials(swordLogin, swordPassword);
			Statement statement = getSWORDClient().getStatement(location, new HalXmlStatement(), auth);
			
			System.out.println("HalStatus :: 2");
			System.out.println("HalStatus :: 2 :: statement="+statement);
			System.out.println("HalStatus :: 2 :: statement.getState()="+statement.getState());
			
			System.out.println("HalStatus :: 3");
			String stringState = null;
			String version = null;
			String password = null;
			String comment = "abcComment";
			if (statement!=null) {
				List<ResourceState> states = statement.getState();
				if (!states.isEmpty()) {
					ResourceState state = states.get(0);
					
					stringState = state.getDescription();
					System.out.println("HalStatus :: END :: stringState="+stringState);
				}
				
				if (statement instanceof HalXmlStatement) {
					version = ((HalXmlStatement)statement).getVersion();
					password = ((HalXmlStatement)statement).getPassword();
					comment = ((HalXmlStatement)statement).getComment();
				}
			}
			
			if (stringState!=null) {
				statusElements[0] = stringState;
				statusElements[1] = version;
				statusElements[2] = password;
				statusElements[3] = comment;
				
				return statusElements;
			}
			else {
				throw new MethodExecutionException("status", "ERROR :: id="+id+" , statement="+statement);
			}
		}
		catch(Exception e) {
			String faultString = "";
			String faultMessage = "";
			
			System.err.println("HalStatus :: error 1 :: location="+location);
			if (e instanceof SWORDError) {
				if (((SWORDError)e).getErrorDoc()!=null) {
					faultMessage = faultMessage+((SWORDError)e).getSummary();
					faultMessage = faultMessage+" :: ";
					faultMessage = faultMessage+((SWORDError)e).getVerboseDescription();
					
					faultString = ((SWORDError)e).getVerboseDescription();
					
					System.err.println("HalStatus :: error 2a :: "+((SWORDError)e).getSummary());
					System.err.println("HalStatus :: error 2b :: "+((SWORDError)e).getVerboseDescription());
					System.err.println("HalStatus :: error 2c :: "+((SWORDError)e).getErrorDoc().toXML());
				}
				else {
					faultMessage = e.getMessage();
					faultString = e.getMessage();
					
					System.err.println("HalStatus :: error 2");
				}
			}
			else {
				faultMessage = e.getMessage();
				faultString = e.getMessage();
				
				e.printStackTrace();
				System.err.println("HalStatus :: error 2");
			}
			
			MethodExecutionException methodExecutionException = new MethodExecutionException("status", faultMessage, e, true);
			methodExecutionException.setFaultString(faultString);
			throw methodExecutionException;
		}
	}
	
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		HalSwordService test = new HalSwordService();
		
		//test.HalUploadXml("D:\\Travail\\Developpement\\Workspaces\\ORI-OAI\\Sword\\data\\halv3_sword_art-url-pdf.xml", "halv3_sword_art-url-pdf.xml");
		//test.HalUploadZip("D:\\Travail\\Developpement\\Workspaces\\ORI-OAI\\Sword\\data\\zip\\halv3_sword_art-include-pdf.zip", "halv3_sword_art-include-pdf.xml");
		
		test.HalStatus("hal-01022735");
	}

}

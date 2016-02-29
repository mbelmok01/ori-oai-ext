package org.orioai.ext;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class DummyTest {

	private OriExtService testedClient;
	
	public DummyTest(String extLocation) {
		this.testedClient = new OriExtService() {
		};
		this.testedClient.setExtLocation(extLocation);
	}


	
	
	/**
	 * read xmlModelResource.xml file 
	 */
	protected String readFile(String path) {
		try {
			InputStream fstream = new FileInputStream(path);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			StringBuffer sb = new StringBuffer();
			
			String strLine;
			while ((strLine = br.readLine()) != null) {
				sb.append(strLine);
			}
			
			in.close();
			return sb.toString();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return null;
	}
	
	
	
	/**
	 * Classe de test aux appels du sous-module ori-oai-ext-physalis
	 */
	public void callClientPhysalis(String opId) {
		System.out.println("Entrée dans la classe DummyTest.java");
		
		WSOperationBean req = new WSOperationBean();
		WSOperationBean result = new WSOperationBean();

		XStream xstream = new XStream(new StaxDriver());
		xstream.processAnnotations(WSOperationBean.class);

		/*
		 * Envoie au module les paramètres nécessaires
		 */
		
		req.put("physalisTefCreator","Universit&#233; de La Rochelle");
		req.put("physalisTefSudocEtabId","026404079");
		
		req.put("database_url","jdbc:oracle:thin:@janetest:1521:gestest");
		req.put("database_user","grhum");
		req.put("database_password","*********");
		
		req.put("nom_doctorant","BELMOKHTAR");
		req.put("prenom_doctorant","MOHAMED");
		req.put("numero_etudiant","170051");
		/*
		 * La fiche TEF à remplir
		 */
		
		req.put("xmlContent",readFile("/orioai/src/ori-oai-ext-svn/ori-oai-ext-physalis/src/test/resources/tef-simple-EXT-blank.xml"));

		System.out.println("Lecture du fichier depuis la classe Dummy-test");
		

		/*
		 * Le mail pro dans le cas où on ne le récupère pas dans physalis
		 */
		req.put("userAttribute_MAIL_PRO","mbelmo01@univ-lr.fr");
		
		
		try {
			// appelle le module "physalis"
			result = (WSOperationBean) testedClient.invokeWSOperation("physalis", opId, req);
			String stringRes = xstream.toXML(result);


			System.out.println("Here is the response : "+ stringRes);
			
			// le xmlContent complété par ORI-OAI-ext
			String newXmlContent = result.get("xmlContent");
			System.out.println("newXmlContent="+ newXmlContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String oriOaiExtUrl = "http://localhost:8185/ori-oai-ext";
		System.out.println("Going to call "+oriOaiExtUrl);

		DummyTest dt = new DummyTest(oriOaiExtUrl);
		
		dt.callClientPhysalis("getTefFromUserId");
	}

}


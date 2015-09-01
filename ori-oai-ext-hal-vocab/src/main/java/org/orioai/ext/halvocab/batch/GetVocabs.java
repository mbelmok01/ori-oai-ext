package org.orioai.ext.halvocab.batch;

import java.util.HashMap;
import java.util.Map;

import org.orioai.ext.core.services.IWebService;
import org.orioai.ext.halvocab.services.remote.HalVocabService;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetVocabs {

	private static IWebService vocService;
	private static Map<String, String[]> vocs =	new HashMap<String, String[]>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		vocs.put("dcfr_types_publi", new String[] {"Types de publications HAL", "getTypesPubli"});
		vocs.put("dcfr_audiences", new String[] {"Audiences HAL", "getAudiences"});
		vocs.put("dcfr_distant_embargos", new String[] {"Durées d'embargos HAL", "getEmbargos"});
		vocs.put("dcfr_files_formats", new String[] {"Formats de fichiers HAL", "getFilesFormats"});		
		vocs.put("dcfr_affiliations", new String[] {"Affiliations des laboratoires HAL", "getAffiliations"});
		vocs.put("dcfr_labs_names", new String[] {"Noms des laboratoires HAL", "getLabsNames"});
		vocs.put("dcfr_labs_short_names", new String[] {"Sigles des laboratoires HAL", "getLabsShortNames"});
		vocs.put("dcfr_labs_addresses", new String[] {"Adresses des laboratoires HAL", "getLabsAddresses"});
		vocs.put("dcfr_labs_countries", new String[] {"Pays des laboratoires HAL", "getLabsCountries"});
		vocs.put("dcfr_reviews", new String[] {"Revues HAL", "getReviews"});
		vocs.put("dcfr_subjects", new String[] {"Domaines HAL", "getSubjects"});

		final String directory =
				(args.length > 0 && !args[0].equals("")) ? args[0] : "/tmp";

		System.out.println("**************** Directory is " + directory);
				
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext(
						new String[] {"META-INF/spring/CoreApplicationContext.xml",
								"META-INF/spring/HalApplicationContext.xml",
						"META-INF/spring/HalVocabApplicationContext.xml"});
		vocService = ctx.getBean(HalVocabService.class);

		for (final Map.Entry<String, String[]> entry : vocs.entrySet()) {
			WSOperationBean toSend = new WSOperationBean();
			toSend.put("vocabId", entry.getKey());
			toSend.put("vocabName", entry.getValue()[0]);
			toSend.put("writeToFile", "");
			toSend.put("vocabFilePath", directory);
			try {
				vocService.execute(entry.getValue()[1], toSend);
			} catch (OriOaiExtException e) {
				e.printStackTrace();
			}
		}
	}
}

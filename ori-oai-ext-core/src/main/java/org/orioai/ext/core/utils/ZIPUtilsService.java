/**
 * 
 */
package org.orioai.ext.core.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.stereotype.Service;

import com.google.common.base.Charsets;

/**
 * Util class to manage ZIP files
 * 
 * @author ycolmant
 *
 */
@Service
public class ZIPUtilsService {

	protected Log4jLoggerAdapter log = 
			(Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
	
	
	private static final int BUFFER = 2048;
	
	
	public void createZipFileFromFileBytesContent(File zipFileDest, List<String> fileNames, List<byte[]> fileContents) throws FileNotFoundException, IOException {
		List<InputStream> inputStreams = new LinkedList<InputStream>();
		for (byte[] fileContent : fileContents) {
			InputStream stream = new ByteArrayInputStream(fileContent);
			inputStreams.add(stream);
		}
		createZipFileFromFileInputStream(zipFileDest, fileNames, inputStreams);
	}
	
	public void createZipFileFromFileContent(File zipFileDest, List<String> fileNames, List<String> fileContents) throws FileNotFoundException, IOException {
		List<InputStream> inputStreams = new LinkedList<InputStream>();
		for (String fileContent : fileContents) {
			InputStream stream = new ByteArrayInputStream(fileContent.getBytes(Charsets.UTF_8));
			inputStreams.add(stream);
		}
		createZipFileFromFileInputStream(zipFileDest, fileNames, inputStreams);
	}	
	
	public void createZipFileFromFileInputStream(File zipFileDest, List<String> fileNames, List<InputStream> inputStreams) throws FileNotFoundException, IOException {
		byte data[] = new byte[BUFFER];
		
		FileOutputStream dest= new FileOutputStream(zipFileDest);
		BufferedOutputStream buff = new BufferedOutputStream(dest);
		ZipOutputStream out = new ZipOutputStream(buff);
		
		out.setMethod(ZipOutputStream.DEFLATED);
		out.setLevel(9);
		
		for(int i=0; i<fileNames.size(); i++) {
			BufferedInputStream buffi = new BufferedInputStream(inputStreams.get(i), BUFFER);
			ZipEntry entry= new ZipEntry(fileNames.get(i));
			out.putNextEntry(entry);
			
			int count;
		    while((count = buffi.read(data, 0, BUFFER)) != -1) {
		    	out.write(data, 0, count);
		    }
		    
		    out.closeEntry();
		    buffi.close();
		}
		out.close();
	}
	
}

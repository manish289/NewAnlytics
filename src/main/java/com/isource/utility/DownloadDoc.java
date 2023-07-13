package com.isource.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DownloadDoc {

	// is for single file
	public ResponseEntity<Resource> downloadFile(String fileName) {
		String Newfilename = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
		File file = new File(fileName);
		HttpHeaders headers = new HttpHeaders();
		
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + Newfilename);
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  //to ensure that the servet's response is never cached by the broswer.
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		
		Path path = Paths.get(fileName);
		ByteArrayResource resource = null;
		
		try {
			resource = new ByteArrayResource(Files.readAllBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}

	// is for AllFile download    // this method is not used anywhere and for alldownload down method is given.
	public boolean downloadAllDocs(String directoryPath, HttpServletResponse response) {
		boolean result=false;
		try {
			String zipfilename = directoryPath.substring(directoryPath.lastIndexOf("/") + 1, directoryPath.length());
			                                                
			response.setContentType("application/zip");
			response.setHeader("Content-Disposition", "attachment; filename=Tender_" + zipfilename + ".ZIP");
			ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
			
			
			GenerateZip.generateZipFromFolder(zos, directoryPath);
			result=true;
			
			zos.close();
		} catch (Exception ex) {
			result=false;
			ex.printStackTrace();
		}
		
		return result;
	}

	public void downloadAllResultDocs(String directoryPath, HttpServletResponse response) {
		try {
  			String zipfilename = directoryPath.substring(directoryPath.lastIndexOf("/") + 1, directoryPath.length());
			response.setContentType("application/zip");
			response.setHeader("Content-Disposition", "attachment; filename=TenderResult_" + zipfilename + ".ZIP");
			ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
			GenerateZip.generateZipFromFolder(zos, directoryPath);
			zos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
		
	//practise method
//		public void downloadalldoc(String directorypath, HttpServletResponse response)
//		{
//		  try {
//			
//			  String zipfilename= directorypath.substring(directorypath.lastIndexOf("/")+1, directorypath.length());
//			  response.setContentType("application/zip");
//			  response.setHeader("Content-Disposition", "attachment; filname=TenderResult_"+ zipfilename + ".zip");
//			  
//			  ZipOutputStream zos= new ZipOutputStream(response.getOutputStream());
//			  GenerateZip.generateZipFromFolder(zos, directorypath);
//			  
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		  
//	}
	
		
	
	
	
}

















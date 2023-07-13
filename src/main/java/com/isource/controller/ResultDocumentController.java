package com.isource.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isource.model.dashboard.AllCompetitorsModel;
import com.isource.utility.DownloadDoc;
import com.isource.utility.EncryptionDecryption;
import com.isource.utility.PropertiesReader;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name="page - 2,3 result-controller")
@Lazy
public class ResultDocumentController {

	@Lazy
	private DownloadDoc downloadDoc;
	private Logger logger = null;

	@Lazy
	public ResultDocumentController(DownloadDoc downloadDoc) {
		this.downloadDoc = downloadDoc;
		logger = Logger.getLogger(ResultDocumentController.class);
	}

	/**
	 * for Downloading Single File
	 * 
	 * @author Jayesh
	 * @date 30/01/23
	 * @param result resultDocumentModel
	 * @return DownloadDocument
	 */
	@GetMapping("/result/tender-result-download-document/{download_document_path}")
	@Operation(summary = "download document")
	public ResponseEntity<?> resultDocument(@PathVariable String download_document_path) {
		if (download_document_path == null || download_document_path.isEmpty() || download_document_path.isBlank()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(PropertiesReader.getProperty("constant", "ERROR_MESSAGE_PATH_NULL"));
		}
		                                           
		String dcryptPath = EncryptionDecryption.decrypt(download_document_path);
		if (dcryptPath == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(PropertiesReader.getProperty("constant", "ERROR_MESSAGE_DCRYPTPATH_NOT_FOUND"));
		}
		
		String dcryptPath1 = dcryptPath.substring(0, dcryptPath.lastIndexOf("/"));
		String path_result = PropertiesReader.getProperty("constant", "PATH_RESULT");
		
		String document_path = path_result + dcryptPath1; // the result is stored in document_path.
		String encryptPath = download_document_path;

		File file = new File(document_path);
		if (!file.exists()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(PropertiesReader.getProperty("constant", "ERROR_MESSAGE_FILE_NOT_FOUND"));
		}
		logger.info("3 EncryptPath For Result document : " + encryptPath + " DcryptPath For Result : " + dcryptPath);
		
		return downloadDoc.downloadFile(document_path);
	}

	/**
	 * for Downloading Multiple File In a Zip
	 * 
	 * @author Jayesh
	 * @date 30/01/23
	 * @param result resultDocumentModel
	 * @return DownloadDocumentZipFile
	 */
	@GetMapping("/result/tender-result-download-document-All/{download_document_all_path}")
	@Operation(summary = "download all document")
	public ResponseEntity<?> resultAllDocument(@PathVariable String download_document_all_path,
			HttpServletResponse response) {

		if (download_document_all_path == null || download_document_all_path.isEmpty()
				|| download_document_all_path.isBlank()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(PropertiesReader.getProperty("constant", "ERROR_MESSAGE_PATH_NULL"));
		}

		String dcryptPath = EncryptionDecryption.decrypt(download_document_all_path);
		if (dcryptPath == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(PropertiesReader.getProperty("constant", "ERROR_MESSAGE_DCRYPTPATH_NOT_FOUND"));
		}

		String dcrypt_Path = dcryptPath.substring(0, dcryptPath.lastIndexOf("/"));
		String path_result = PropertiesReader.getProperty("constant", "PATH_RESULT");
		String document_path = path_result + dcrypt_Path;
		String encryptPath = download_document_all_path;
		File file = new File(document_path);
		if (!file.exists()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(PropertiesReader.getProperty("constant", "ERROR_MESSAGE_DIRECTORY_NOT_FOUND"));
		}
		logger.info(
				"4 EncryptPath For Result all document : " + encryptPath + " DcryptPath For Result : " + dcryptPath);
		
		
		downloadDoc.downloadAllResultDocs(document_path, response);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}
	
	
/*	@GetMapping("/result-tender-result-download-document-All/{download-document-all-path}")
	@Operation(summary = "download all documents")
	public ResponseEntity<?> resultAllDoc(@PathVariable String download_document_all_path, HttpServletResponse response)
	{
		
		if(download_document_all_path== null || download_document_all_path.isEmpty() || download_document_all_path.isBlank())
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(PropertiesReader.getProperty("constant", "ERROR_MESSAGE_PATH_NULL"));
		}
	
		String decryptpath= EncryptionDecryption.decrypt(download_document_all_path);
		if(decryptpath== null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(PropertiesReader.getProperty("constant", "ERROR_MESSAGE_DECRYPTPATH_NOT_FOUND"));
		}
		
		String decrypt_path=decryptpath.substring(0, decryptpath.lastIndexOf("/"));
		String path_result= PropertiesReader.getProperty("constant", "PATH_RESULT");
		String document_path=path_result+ decrypt_path;
		
		String Encryptpath= download_document_all_path;
		
		File file= new File(document_path);
		  if(!file.exists())
		  {
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(PropertiesReader.getProperty("constant", "Error_MESSAGE_DIRECTOR_NOT_FOUND"));
		  }
		  
		  logger.info("4 EncryptPath for Result all document :" + Encryptpath + "Decryptpath For all result"+ decrypt_path);
		
	   downloadDoc.downloadAllResultDocs(document_path, response);	
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}
	
	// practise method.
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.isource.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GenerateZip {
                                     // this method is also not used down method is used
	public static void generateZip(ZipOutputStream zos, String[] files) throws IOException {
		byte bytes[] = new byte[2048];
		FileInputStream fis = null;   // FileInputStream class obtains input bytes from a file. It is used for reading byte-oriented data 
		File file = null;
		for (String fileName : files) {
			fis = new FileInputStream(fileName);
			file = new File(fileName);
			zos.putNextEntry(new ZipEntry(file.getName()));
			int bytesRead;
			while ((bytesRead = fis.read(bytes)) != -1) {
				zos.write(bytes, 0, bytesRead);
			}                                                                                                                                                                                                                                         
			zos.closeEntry();
			fis.close();
			file = null;
		}
	}
                                              //This class implements an output stream filter for writing files in the ZIP file format
	public static void generateZipFromFolder(ZipOutputStream zos, String directory) {
		byte bytes[] = new byte[2048];
		File dir = new File(directory);
		
		if (!dir.isDirectory()) {
			System.out.println(directory + " is not a directory");
		}
		
		else {              // we have listed all the listFiles hrer in files array.
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				                                                   // passed files array here.
				try(FileInputStream fin = new FileInputStream(files[i]);){
					zos.putNextEntry(new ZipEntry(files[i].getName()));
					
					int length;
		 			while ((length = fin.read(bytes)) > 0) {
						zos.write(bytes, 0, length);
		 			}
		 			
				}catch(Exception e) {
					e.printStackTrace();
					
				}
				
			}
		}
	
	}

	
}





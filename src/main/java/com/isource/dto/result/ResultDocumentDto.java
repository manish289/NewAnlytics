package com.isource.dto.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.isource.utility.EncryptionDecryption;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultDocumentDto {

	@JsonProperty("result_id")
	private long result_id;

	@JsonProperty("result_document_id")
	private long result_document_id;

	@JsonProperty("document_type_id")
	private int document_type_id;// bigint

	@JsonProperty("document_type_name")
	private String document_type_name;// character varying

	@JsonProperty("document_path")
	private String document_path;// character varying

	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("created_date")
	private String created_date;// character varying

	@JsonProperty("file_extension")
	private String file_extension;// character varying

	public long getResult_id() {
		return result_id;
	}

	public void setResult_id(long result_id) {
		this.result_id = result_id;
	}

	public long getResult_document_id() {
		return result_document_id;
	}

	public void setResult_document_id(long result_document_id) {
		this.result_document_id = result_document_id;
	}

	public int getDocument_type_id() {
		return document_type_id;
	}

	public void setDocument_type_id(int document_type_id) {
		this.document_type_id = document_type_id;
	}

	public String getDocument_path() {
		String returnpath="";
		if(getCreated_date().equalsIgnoreCase("-infinity")) {
			returnpath="";
		}else {
			String date[] = getCreated_date().split("-");
			String path = date[0] + "/" + date[1] + "/" + date[2] + "/" + getResult_id() + "/" + getResult_document_id()
					+ "" + (document_path.substring(document_path.lastIndexOf("."), document_path.length())) + "/" + "1";
			returnpath = EncryptionDecryption.encrypt(path);
			setFile_extension(document_path.substring(document_path.lastIndexOf(".")));
		}
		return returnpath;
	}

	public void setDocument_path(String document_path) {
		this.document_path = document_path;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getFile_extension() {
		return file_extension;
	}

	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}

	public String getDocument_type_name() {
		return document_type_name;
	}

	public void setDocument_type_name(String document_type_name) {
		this.document_type_name = document_type_name;
	}
}
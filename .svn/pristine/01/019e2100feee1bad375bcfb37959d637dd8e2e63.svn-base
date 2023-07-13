package com.isource.dto.result;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.isource.utility.EncryptionDecryption;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultDetailDto {

	@JsonProperty("result_id")
	private int result_id;// bigint,

	@JsonProperty("result_brief")
	private String result_brief;// text,

	@JsonProperty("tender_number")
	private String tender_number; // character varying,

	@JsonProperty("organization_id")
	private int organization_id; // integer,

	@JsonProperty("organization_name")
	private String organization_name; // character varying,

	@JsonProperty("organization_type_name")
	private String organization_type_name; // character varying,

	@JsonProperty("stage")
	private String stage; // character varying,

	@JsonProperty("contract_value")
	private BigDecimal contract_value;// numeric,

	@JsonProperty("tender_value")
	private BigDecimal tender_value;// numeric,

	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("created_date")
	private String created_date; // date,

	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("contract_date")
	private Date contract_date;// date,

	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("submission_date")
	private Date submission_date; // date,

	@JsonProperty("winner_bidder_name")
	private String winner_bidder_name;

	@JsonProperty("document_path")
	private String document_path;

	public int getResult_id() {
		return result_id;
	}

	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}

	public String getDocument_path() {
		String returnpath = "";
		if (getCreated_date().equalsIgnoreCase("-infinity")) {
			returnpath = "";
		} else {
			String date[] = getCreated_date().split("-");
			String path = document_path = date[0] + "/" + date[1] + "/" + date[2] + "/" + getResult_id() + "/" + 0;
			returnpath = EncryptionDecryption.encrypt(path);
		}
		return returnpath;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public void setDocument_path(String document_path) {
		this.document_path = document_path;
	}

	public String getResult_brief() {
		return result_brief;
	}

	public void setResult_brief(String result_brief) {
		this.result_brief = result_brief;
	}

	public String getTender_number() {
		return tender_number;
	}

	public void setTender_number(String tender_number) {
		this.tender_number = tender_number;
	}

	public int getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getOrganization_type_name() {
		return organization_type_name;
	}

	public void setOrganization_type_name(String organization_type_name) {
		this.organization_type_name = organization_type_name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public BigDecimal getContract_value() {
		return contract_value == null ? new BigDecimal(0) : contract_value;
	}

	public void setContract_value(BigDecimal contract_value) {
		this.contract_value = contract_value;
	}

	public BigDecimal getTender_value() {
		return tender_value == null ? new BigDecimal(0) : tender_value;
	}

	public void setTender_value(BigDecimal tender_value) {
		this.tender_value = tender_value;
	}

	public Date getContract_date() {
		return contract_date;
	}

	public void setContract_date(Date contract_date) {
		this.contract_date = contract_date;
	}

	public Date getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(Date submission_date) {
		this.submission_date = submission_date;
	}

	public String getWinner_bidder_name() {
		return winner_bidder_name;
	}

	public void setWinner_bidder_name(String winner_bidder_name) {
		this.winner_bidder_name = winner_bidder_name;
	}
}
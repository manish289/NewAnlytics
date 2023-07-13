package com.isource.dto.result;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SimilarResultDto {

	@JsonProperty("result_id")
	private BigInteger result_id;// bigint

	@JsonProperty("result_brief")
	private String result_brief;// text

	@JsonProperty("stage")
	private String stage;// character varying

	@JsonProperty("location")
	private String location;// character varying

	@JsonProperty("organization_name")
	private String organization_name;// character varying

	@JsonProperty("organization_type_name")
	private String organization_type_name;// character varying

	@JsonProperty("tender_value")
	private BigDecimal tender_value;// numeric

	@JsonFormat(pattern = "MM-dd-yyyy")
	@JsonProperty("contract_date")
	private Date contract_date;// date

	@JsonProperty("winner_bidder_name")
	private String winner_bidder_name;// character varying

	@JsonProperty("is_favorite")
	private boolean is_favorite;// boolean

	public BigInteger getResult_id() {
		return result_id;
	}

	public void setResult_id(BigInteger result_id) {
		this.result_id = result_id;
	}

	public String getResult_brief() {
		return result_brief;
	}

	public void setResult_brief(String result_brief) {
		this.result_brief = result_brief;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getWinner_bidder_name() {
		return winner_bidder_name;
	}

	public void setWinner_bidder_name(String winner_bidder_name) {
		this.winner_bidder_name = winner_bidder_name;
	}

	public boolean isIs_favorite() {
		return is_favorite;
	}

	public void setIs_favorite(boolean is_favorite) {
		this.is_favorite = is_favorite;
	}

}

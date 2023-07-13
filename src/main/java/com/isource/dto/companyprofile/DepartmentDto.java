package com.isource.dto.companyprofile;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDto {

	@JsonProperty("organization_id")
	private int organization_id ;//integer
	
	@JsonProperty("organization_name")
	private String organization_name; // character varying-string

	@JsonProperty("participate_result")
	private int participate_result;// bigint-int

	@JsonProperty("participated_result_value")
	private BigDecimal participated_result_value;// numeric-BigDecimal

	@JsonProperty("awarded_result")
	private int awarded_result; // bigint-int

	@JsonProperty("awarded_result_value")
	private BigDecimal awarded_result_value;// numeric-BigDecimal

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public int getParticipate_result() {
		return participate_result;
	}

	public void setParticipate_result(int participate_result) {
		this.participate_result = participate_result;
	}

	public BigDecimal getParticipated_result_value() {
		return participated_result_value==null?new BigDecimal(0):participated_result_value;
	}

	public void setParticipated_result_value(BigDecimal participated_result_value) {
		this.participated_result_value = participated_result_value;
	}

	public int getAwarded_result() {
		return awarded_result;
	}

	public void setAwarded_result(int awarded_result) {
		this.awarded_result = awarded_result;
	}

	public BigDecimal getAwarded_result_value() {
		return awarded_result_value==null?new BigDecimal(0):awarded_result_value;
	}

	public void setAwarded_result_value(BigDecimal awarded_result_value) {
		this.awarded_result_value = awarded_result_value;
	}

	public int getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}
	
}

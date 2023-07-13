package com.isource.dto.comparecompetitors;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompareTenderOwnershipDto {
	
	@JsonProperty("organization_type_id ")
	private int organization_type_id ;//Integer

	@JsonProperty("organization_type_name")
	private String organization_type_name;// Character varying
	
	@JsonProperty("participate_result_count")
	private BigDecimal participate_result_count; // bigint
	
	@JsonProperty("participated_result_value")
	private BigDecimal participated_result_value; // numeric

	public String getOrganization_type_name() {
		return organization_type_name;
	}

	public void setOrganization_type_name(String organization_type_name) {
		this.organization_type_name = organization_type_name;
	}

	public BigDecimal getParticipate_result_count() {
		return participate_result_count==null?new BigDecimal(0):participate_result_count;
	}

	public void setParticipate_result_count(BigDecimal participate_result_count) {
		this.participate_result_count = participate_result_count;
	}

	public BigDecimal getParticipated_result_value() {
		return participated_result_value==null?new BigDecimal(0):participated_result_value;
	}

	public void setParticipated_result_value(BigDecimal participated_result_value) {
		this.participated_result_value = participated_result_value;
	}

	public int getOrganization_type_id() {
		return organization_type_id;
	}

	public void setOrganization_type_id(int organization_type_id) {
		this.organization_type_id = organization_type_id;
	}
	
}

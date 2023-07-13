package com.isource.dto.comparecompetitors;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StrongPointsOwnershipwiseDto {

	@JsonProperty("organization_type_id")
	private int organization_type_id;

	@JsonProperty("organization_type_name")
	private String organization_type_name;

	@JsonProperty("participated_tender_count")
	private int participated_tender_count;

	@JsonProperty("participated_tender_value")
	private BigDecimal participated_tender_value;

	@JsonProperty("award_result_count")
	private int award_result_count;

	@JsonProperty("award_result_value")
	private BigDecimal award_result_value;

	public int getOrganization_type_id() {
		return organization_type_id;
	}

	public void setOrganization_type_id(int organization_type_id) {
		this.organization_type_id = organization_type_id;
	}

	public String getOrganization_type_name() {
		return organization_type_name=(organization_type_name==null)?"":organization_type_name;
	}

	public void setOrganization_type_name(String organization_type_name) {
		this.organization_type_name = organization_type_name;
	}

	public int getParticipated_tender_count() {
		return participated_tender_count;
	}

	public void setParticipated_tender_count(int participated_tender_count) {
		this.participated_tender_count = participated_tender_count;
	}

	public BigDecimal getParticipated_tender_value() {
		return participated_tender_value==null?new BigDecimal(0):participated_tender_value;
	}

	public void setParticipated_tender_value(BigDecimal participated_tender_value) {
		this.participated_tender_value = participated_tender_value;
	}

	public int getAward_result_count() {
		return award_result_count;
	}

	public void setAward_result_count(int award_result_count) {
		this.award_result_count = award_result_count;
	}

	public BigDecimal getAward_result_value() {
		return award_result_value==null?new BigDecimal(0):award_result_value;
	}

	public void setAward_result_value(BigDecimal award_result_value) {
		this.award_result_value = award_result_value;
	}

}

package com.isource.dto.comparecompetitors;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StrongPointStateDto {

	@JsonProperty("state_id")
	private int state_id;

	@JsonProperty("state_name")
	private String state_name;

	@JsonProperty("participated_tender_count")
	private int participated_tender_count;

	@JsonProperty("participated_tender_value")
	private BigDecimal participated_tender_value;

	@JsonProperty("award_result_count")
	private int award_result_count;

	@JsonProperty("award_result_value")
	private BigDecimal award_result_value;

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name=(state_name==null)?"":state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
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

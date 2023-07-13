	package com.isource.dto.comparecompetitors;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SameBidResponseDto {

	@JsonProperty("search_company")
	private String search_company;
	
	@JsonProperty("participated_count")
	private BigDecimal participated_count;
	
	@JsonProperty("participated_value")
	private BigDecimal participated_value;
	
	@JsonProperty("result_to_be_announced_count")
	private BigDecimal result_to_be_announced_count;
	
	@JsonProperty("result_to_be_announced_value")
	private BigDecimal result_to_be_announced_value;
	
	@JsonProperty("awarded_count_company1")
	private BigDecimal awarded_count_company1;	
	
	@JsonProperty("awarded_value_company1")
	private BigDecimal awarded_value_company1;	
	
	@JsonProperty("awarded_count_company2")
	private BigDecimal awarded_count_company2;	
	
	@JsonProperty("awarded_value_company2")
	private BigDecimal 	awarded_value_company2;	
	
	@JsonProperty("awarded_count_company3")
	private BigDecimal awarded_count_company3;	
	
	@JsonProperty("awarded_value_company3")
	private BigDecimal awarded_value_company3;	
	
	@JsonProperty("others_count")
	private BigDecimal others_count;	
	
	@JsonProperty("others_value")
	private BigDecimal others_value;

	public String getSearch_company() {
		return search_company;
	}

	public void setSearch_company(String search_company) {
		this.search_company = search_company;
	}

	public BigDecimal getParticipated_count() {
		return participated_count==null?new BigDecimal(0):participated_count;
	}

	public void setParticipated_count(BigDecimal participated_count) {
		this.participated_count = participated_count;
	}

	public BigDecimal getParticipated_value() {
		return participated_value==null?new BigDecimal(0):participated_value;
	}

	public void setParticipated_value(BigDecimal participated_value) {
		this.participated_value = participated_value;
	}

	public BigDecimal getResult_to_be_announced_count() {
		return result_to_be_announced_count==null?new BigDecimal(0):result_to_be_announced_count;
	}

	public void setResult_to_be_announced_count(BigDecimal result_to_be_announced_count) {
		this.result_to_be_announced_count = result_to_be_announced_count;
	}

	public BigDecimal getResult_to_be_announced_value() {
		return result_to_be_announced_value==null?new BigDecimal(0):result_to_be_announced_value;
	}

	public void setResult_to_be_announced_value(BigDecimal result_to_be_announced_value) {
		this.result_to_be_announced_value = result_to_be_announced_value;
	}

	public BigDecimal getAwarded_count_company1() {
		return awarded_count_company1==null?new BigDecimal(0):awarded_count_company1;
	}

	public void setAwarded_count_company1(BigDecimal awarded_count_company1) {
		this.awarded_count_company1 = awarded_count_company1;
	}

	public BigDecimal getAwarded_value_company1() {
		return awarded_value_company1==null?new BigDecimal(0):awarded_value_company1;
	}

	public void setAwarded_value_company1(BigDecimal awarded_value_company1) {
		this.awarded_value_company1 = awarded_value_company1;
	}

	public BigDecimal getAwarded_count_company2() {
		return awarded_count_company2==null?new BigDecimal(0):awarded_count_company2;
	}

	public void setAwarded_count_company2(BigDecimal awarded_count_company2) {
		this.awarded_count_company2 = awarded_count_company2;
	}

	public BigDecimal getAwarded_value_company2() {
		return awarded_value_company2==null?new BigDecimal(0):awarded_value_company2;
	}

	public void setAwarded_value_company2(BigDecimal awarded_value_company2) {
		this.awarded_value_company2 = awarded_value_company2;
	}

	public BigDecimal getAwarded_count_company3() {
		return awarded_count_company3==null?new BigDecimal(0):awarded_count_company3;
	}

	public void setAwarded_count_company3(BigDecimal awarded_count_company3) {
		this.awarded_count_company3 = awarded_count_company3;
	}

	public BigDecimal getAwarded_value_company3() {
		return awarded_value_company3==null?new BigDecimal(0):awarded_value_company3;
	}

	public void setAwarded_value_company3(BigDecimal awarded_value_company3) {
		this.awarded_value_company3 = awarded_value_company3;
	}

	public BigDecimal getOthers_count() {
		return others_count==null?new BigDecimal(0):others_count;
	}

	public void setOthers_count(BigDecimal others_count) {
		this.others_count = others_count;
	}

	public BigDecimal getOthers_value() {
		return others_value==null?new BigDecimal(0):others_value;
	}

	public void setOthers_value(BigDecimal others_value) {
		this.others_value = others_value;
	}
	
}

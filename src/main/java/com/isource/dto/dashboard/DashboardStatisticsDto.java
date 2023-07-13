package com.isource.dto.dashboard;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DashboardStatisticsDto {

	@JsonProperty("result_count")
	private int result_count;// integer,

	@JsonProperty("participated_bidder_count")
	private int participated_bidder_count;// integer,

	@JsonProperty("total_competitor")
	private int total_competitor; // integer,

	@JsonProperty("total_contract_value")
	private BigDecimal total_contract_value;// numeric,

	@JsonProperty("participated_contract_value")
	private BigDecimal participated_contract_value;// numeric

	@JsonProperty("to_be_awarded")
	private int to_be_awarded;// integer

	public int getResult_count() {
		return result_count;
	}

	public void setResult_count(int result_count) {
		this.result_count = result_count;
	}

	public int getParticipated_bidder_count() {
		return participated_bidder_count;
	}

	public void setParticipated_bidder_count(int participated_bidder_count) {
		this.participated_bidder_count = participated_bidder_count;
	}

	public int getTotal_competitor() {
		return total_competitor;
	}

	public void setTotal_competitor(int total_competitor) {
		this.total_competitor = total_competitor;
	}

	public BigDecimal getTotal_contract_value() {
		return total_contract_value==null?new BigDecimal(0):total_contract_value;
	}

	public void setTotal_contract_value(BigDecimal total_contract_value) {
		this.total_contract_value = total_contract_value;
	}

	public BigDecimal getParticipated_contract_value() {
		return participated_contract_value==null?new BigDecimal(0):participated_contract_value;
	}

	public void setParticipated_contract_value(BigDecimal participated_contract_value) {
		this.participated_contract_value = participated_contract_value;
	}

	public int getTo_be_awarded() {
		return to_be_awarded;
	}

	public void setTo_be_awarded(int to_be_awarded) {
		this.to_be_awarded = to_be_awarded;
	}
	
}

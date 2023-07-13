package com.isource.dto.result;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BidderParticipatedResultDto {

	@JsonProperty("bidder_name")
	private String bidder_name;// Character varying

	@JsonProperty("participated_tender_value")
	private BigDecimal participated_tender_value;// numeric

	@JsonProperty("participated_tender_count")
	private int participated_tender_count;// bigint

	@JsonProperty("award_result_value")
	private BigDecimal award_result_value;// numeric

	@JsonProperty("award_result_count")
	private int award_result_count;// bigint

	@JsonProperty("lost_value")
	private BigDecimal lost_value;// numeric

	@JsonProperty("lost_tender")
	private int lost_tender;// bigint

	public String getBidder_name() {
		return bidder_name;
	}

	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
	}

	public BigDecimal getParticipated_tender_value() {
		return participated_tender_value==null?new BigDecimal(0):participated_tender_value;
	}

	public void setParticipated_tender_value(BigDecimal participated_tender_value) {
		this.participated_tender_value = participated_tender_value;
	}

	public int getParticipated_tender_count() {
		return participated_tender_count;
	}

	public void setParticipated_tender_count(int participated_tender_count) {
		this.participated_tender_count = participated_tender_count;
	}

	public BigDecimal getAward_result_value() {
		return award_result_value==null?new BigDecimal(0):award_result_value;
	}

	public void setAward_result_value(BigDecimal award_result_value) {
		this.award_result_value = award_result_value;
	}

	public int getAward_result_count() {
		return award_result_count;
	}

	public void setAward_result_count(int award_result_count) {
		this.award_result_count = award_result_count;
	}

	public BigDecimal getLost_value() {
		return lost_value==null?new BigDecimal(0):lost_value;
	}

	public void setLost_value(BigDecimal lost_value) {
		this.lost_value = lost_value;
	}

	public int getLost_tender() {
		return lost_tender;
	}

	public void setLost_tender(int lost_tender) {
		this.lost_tender = lost_tender;
	}
	
}

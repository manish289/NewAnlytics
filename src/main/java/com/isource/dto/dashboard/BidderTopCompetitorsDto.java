package com.isource.dto.dashboard;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BidderTopCompetitorsDto {

	@JsonProperty("bidder_name")
	private String bidder_name;// character varying

	@JsonProperty("participate_count")
	private int participate_count; // bigint

	@JsonProperty("participated_tenders")
	private BigDecimal participated_tenders; // numeric
	
	@JsonProperty("award_result_value")
	private BigDecimal award_result_value; // numeric

	public String getBidder_name() {
		return bidder_name;
	}

	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
	}

	public int getParticipate_count() {
		return participate_count;
	}

	public void setParticipate_count(int participate_count) {
		this.participate_count = participate_count;
	}

	public BigDecimal getParticipated_tenders() {
		return participated_tenders==null?new BigDecimal(0):participated_tenders;
	}

	public void setParticipated_tenders(BigDecimal participated_tenders) {
		this.participated_tenders = participated_tenders;
	}

	public BigDecimal getAward_result_value() {
		return award_result_value==null?new BigDecimal(0):award_result_value;
	}

	public void setAward_result_value(BigDecimal award_result_value) {
		this.award_result_value = award_result_value;
	}
}

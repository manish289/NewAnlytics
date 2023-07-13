package com.isource.dto.comparecompetitors;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComapniesCompareDto {
	
	@JsonProperty("bidder_name")
	private String bidder_name;// Character varying

	@JsonProperty("participated_tender_count")
	private int participated_tender_count;// bigint

	@JsonProperty("participated_tender_value")
	private BigDecimal participated_tender_value;// numeric

	@JsonProperty("award_result_count")
	private String award_result_count;// bigint 
	
	@JsonProperty("award_result_value")
	private String award_result_value;// numeric 
	
	@JsonProperty("lost_tender")
	private String lost_tender;// bigint 
	
	@JsonProperty("lost_value")
	private BigDecimal lost_value;//  numeric
	
	@JsonProperty("to_be_announced_tender")
	private String to_be_announced_tender;//  bigint
	
	@JsonProperty("to_be_announced_value")
	private String to_be_announced_value;//  numeric
	
	@JsonProperty("state_id")
	private int state_id;//  integer

	public String getBidder_name() {
		return bidder_name=(bidder_name==null)?"":bidder_name;
	}

	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
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

	public String getAward_result_count() {
		return award_result_count=(award_result_count==null)?"":award_result_count;
	}

	public void setAward_result_count(String award_result_count) {
		this.award_result_count = award_result_count;
	}

	public String getAward_result_value() {
		return award_result_value=(award_result_value==null)?"":award_result_value;
	}

	public void setAward_result_value(String award_result_value) {
		this.award_result_value = award_result_value;
	}

	public String getLost_tender() {
		return lost_tender=(lost_tender==null)?"":lost_tender;
	}

	public void setLost_tender(String lost_tender) {
		this.lost_tender = lost_tender;
	}

	public BigDecimal getLost_value() {
		return lost_value==null?new BigDecimal(0):lost_value;
	}

	public void setLost_value(BigDecimal lost_value) {
		this.lost_value = lost_value;
	}

	public String getTo_be_announced_tender() {
		return to_be_announced_tender=(to_be_announced_tender==null)?"":to_be_announced_tender;
	}

	public void setTo_be_announced_tender(String to_be_announced_tender) {
		this.to_be_announced_tender = to_be_announced_tender;
	}

	public String getTo_be_announced_value() {
		return to_be_announced_value=(to_be_announced_value==null)?"":to_be_announced_value;
	}

	public void setTo_be_announced_value(String to_be_announced_value) {
		this.to_be_announced_value = to_be_announced_value;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	
}

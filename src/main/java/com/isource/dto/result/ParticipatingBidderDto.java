package com.isource.dto.result;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParticipatingBidderDto {

	@JsonProperty("bidder_name")
	private String bidder_name;// Character varying

	@JsonProperty("technical_status")
	private Boolean technical_status;// boolean

	@JsonProperty("financial_status")
	private Boolean financial_status;// boolean

	@JsonProperty("aoc_status")
	private Boolean aoc_status;// boolean

	@JsonProperty("bid_value")
	private BigDecimal bid_value;// numeric

	@JsonProperty("bidder_rank")
	private String bidder_rank;// Character varying

	public String getBidder_name() {
		return bidder_name;
	}

	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
	}

	public Boolean getTechnical_status() {
		return technical_status;
	}

	public void setTechnical_status(Boolean technical_status) {
		this.technical_status = technical_status;
	}

	public Boolean getFinancial_status() {
		return financial_status;
	}

	public void setFinancial_status(Boolean financial_status) {
		this.financial_status = financial_status;
	}

	public Boolean getAoc_status() {
		return aoc_status;
	}

	public void setAoc_status(Boolean aoc_status) {
		this.aoc_status = aoc_status;
	}

	public BigDecimal getBid_value() {
		return bid_value==null?new BigDecimal(0):bid_value;
	}

	public void setBid_value(BigDecimal bid_value) {
		this.bid_value = bid_value;
	}

	public String getBidder_rank() {
		return bidder_rank;
	}

	public void setBidder_rank(String bidder_rank) {
		this.bidder_rank = bidder_rank;
	}

}
package com.isource.dto.dashboard;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BidderTopCompetitorsMonthWiseDto {

	@JsonProperty("bidder_name")
	private String bidder_name;// Character varying

	@JsonProperty("no_of_tender_participate")
	private int no_of_tender_participate;// integer

	@JsonProperty("won_value_awarded")
	private BigDecimal won_value_awarded;// numeric

	@JsonProperty("month")
	private String month;// character varying

	public String getBidder_name() {
		return bidder_name;
	}

	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
	}

	public int getNo_of_tender_participate() {
		return no_of_tender_participate;
	}

	public void setNo_of_tender_participate(int no_of_tender_participate) {
		this.no_of_tender_participate = no_of_tender_participate;
	}

	public BigDecimal getWon_value_awarded() {
		return won_value_awarded==null?new BigDecimal(0):won_value_awarded;
	}

	public void setWon_value_awarded(BigDecimal won_value_awarded) {
		this.won_value_awarded = won_value_awarded;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
}

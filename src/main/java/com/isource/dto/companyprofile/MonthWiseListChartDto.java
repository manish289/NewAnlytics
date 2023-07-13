package com.isource.dto.companyprofile;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MonthWiseListChartDto {
	
	@JsonProperty("bidder_name")
	private String bidder_name; // character varying

	@JsonProperty("participated")
	private int participated;// bigint

	@JsonProperty("participated_tender_value")
	private BigDecimal participated_tender_value;// numeric

	@JsonProperty("awarded")
	private int awarded; // bigint-int

	@JsonProperty("awarded_tender_value")
	private BigDecimal awarded_tender_value;// numeric
	
	@JsonProperty("month")
	private String month;// numeric-BigDecimal

	public String getBidder_name() {
		return bidder_name;
	}

	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
	}

	public int getParticipated() {
		return participated;
	}

	public void setParticipated(int participated) {
		this.participated = participated;
	}

	public BigDecimal getParticipated_tender_value() {
		return participated_tender_value==null?new BigDecimal(0):participated_tender_value;
	}

	public void setParticipated_tender_value(BigDecimal participated_tender_value) {
		this.participated_tender_value = participated_tender_value;
	}

	public int getAwarded() {
		return awarded;
	}

	public void setAwarded(int awarded) {
		this.awarded = awarded;
	}

	public BigDecimal getAwarded_tender_value() {
		return awarded_tender_value;
	}

	public void setAwarded_tender_value(BigDecimal awarded_tender_value) {
		this.awarded_tender_value = awarded_tender_value;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
}
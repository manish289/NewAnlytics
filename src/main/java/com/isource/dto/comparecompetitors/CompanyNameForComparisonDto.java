package com.isource.dto.comparecompetitors;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyNameForComparisonDto {

	@JsonProperty("bidder_id")
	private int bidder_id; // integer
	
	@JsonProperty("bidder_name")
	private String bidder_name; //character varying
	
}

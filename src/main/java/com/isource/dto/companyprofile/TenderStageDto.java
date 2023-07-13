package com.isource.dto.companyprofile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TenderStageDto {
	
	@JsonProperty("technical")
	private int technical;// bigint,
	
	@JsonProperty("financial")
	private int financial;// bigint,
	
	@JsonProperty("aoc")
	private int aoc; // bigint
	
	@JsonProperty("cancelled")
	private int cancelled;// integer,

	@JsonProperty("retender")
	private int retender; // integer
	
}

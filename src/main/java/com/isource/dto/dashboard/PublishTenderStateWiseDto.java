package com.isource.dto.dashboard;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PublishTenderStateWiseDto {

	@JsonProperty("state_id")
	private int state_id;// Integer
	
	@JsonProperty("state_name")
	private String state_name;// character varying,

	@JsonProperty("published")
	private BigInteger published; // bigint,

	@JsonProperty("participate")
	private BigInteger participate; // bigint,

	@JsonProperty("tender_won")
	private BigInteger tender_won; // bigint

}

package com.isource.dto.comparecompetitors;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SameBidComparisionStateWiseDto {

	@JsonProperty("state_name")
	private String state_name; //character varying

	@JsonProperty("won_result_count")
	private int won_result_count; //bigint

	@JsonProperty("won_result_value")
	private BigDecimal won_result_value; //numeric

}
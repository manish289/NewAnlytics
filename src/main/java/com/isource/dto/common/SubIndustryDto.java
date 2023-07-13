package com.isource.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubIndustryDto {

	@JsonProperty("sub_industry_id")
	private int sub_industry_id;// integer

	@JsonProperty("sub_industry_name")
	private String sub_industry_name; // text

	@JsonProperty("industry_id")
	private int industry_id;// integer
	
}

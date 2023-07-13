package com.isource.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ResultAnalyticsSiteLocationDetailDto {
	
	@JsonProperty("state_id")
	private int state_id;// integer,
	
	@JsonProperty("state_name")
	private String state_name;// character varying,
	
	@JsonProperty("city_name")
	private String city_name;// character varying
}

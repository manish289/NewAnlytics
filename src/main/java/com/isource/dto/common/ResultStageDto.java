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
public class ResultStageDto {

	@JsonProperty("stage_id")
	private short stage_id;// small int

	@JsonProperty("stage")
	private String stage;// character varying
	
}

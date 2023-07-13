package com.isource.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RelatedKeywordDto {

	@JsonProperty("keyword_id")
	private int  keyword_id;// Integer
	
	@JsonProperty("keyword_name")
	private String keyword_name;// Charcter varying
	
}

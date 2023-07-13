package com.isource.dto.dashboard;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AllCompetitorsDto {

	@JsonProperty("bidder_id")  //BY USING this annotations we can mark non standard setter/getter to use with respect  to json property.
	private int bidder_id;// integer

	@JsonProperty("bidder_name")
	private String bidder_name;// character varying
	
}

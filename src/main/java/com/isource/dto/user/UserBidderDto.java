package com.isource.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBidderDto {

	@JsonProperty("user_id")
	private int user_id; // integer,
	
	@JsonProperty("bidder_id")
	private int bidder_id; // integer,
	
	@JsonProperty("bidder_name")
	private String bidder_name; //  character varying
	
}

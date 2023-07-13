package com.isource.dto.watchlist;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WatchListDeleteDto {

	@JsonProperty("watchlist_id")
	private String watchlist_id;// integer

}

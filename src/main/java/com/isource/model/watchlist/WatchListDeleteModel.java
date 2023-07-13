package com.isource.model.watchlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WatchListDeleteModel {

	private int bidder_id;
	private String bidder_name;
	
}

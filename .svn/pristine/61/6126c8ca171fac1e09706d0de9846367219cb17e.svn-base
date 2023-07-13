package com.isource.dto.watchlist;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WatchListInsertDto {

	@JsonProperty("watchlist_id")
	private String watchlist_id;// integer

	@JsonProperty("user_id")
	private String user_id;// integer

	@JsonProperty("bidder_id")
	private String bidder_id;// integer

	@JsonProperty("bidder_name")
	private String bidder_name;// character varying

	@JsonFormat(pattern = "MM-dd-yyyy")
	@JsonProperty("created_date")
	private Date created_date;// date

	@JsonProperty("is_delete")
	private String is_delete;// boolean

	@JsonFormat(pattern = "MM-dd-yyyy")
	@JsonProperty("modify_datetime")
	private Date modify_datetime;// timestamp without time zone

}

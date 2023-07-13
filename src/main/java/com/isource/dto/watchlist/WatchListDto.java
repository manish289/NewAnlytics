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
public class WatchListDto {

	@JsonProperty("watchlist_id")
	private String watchlist_id;// integer

	@JsonProperty("user_id")
	private int user_id;// integer

	@JsonProperty("bidder_id")
	private int bidder_id;// integer

	@JsonProperty("bidder_name")
	private String bidder_name;// character varying

	@JsonFormat(pattern = "MM-dd-yyyy")
	@JsonProperty("created_date")
	private Date created_date;// date

	@JsonProperty("is_delete")
	private Boolean is_delete;// boolean

	@JsonFormat(pattern = "MM-dd-yyyy")
	@JsonProperty("modify_datetime")
	private Date modify_datetime;// timestamp without time zone
	
	@JsonFormat(pattern = "MM-dd-yyyy")
	@JsonProperty("last_count_update_date")
	private Date last_count_update_date;// timestamp without time zone
	
	@JsonProperty("is_read_notification")
	private Boolean is_read_notification;// boolean
	
	@JsonProperty("is_check")
	private Boolean is_check;// boolean
	
}

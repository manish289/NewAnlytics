package com.isource.model.comparecompetitors;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StrongPointsModel {

	private Date from_date;// date,
	private Date to_date; // date,
	private String bidder_name; // character varying
	private int keyword_id;// integer,
	private int state_id;// integer)
}

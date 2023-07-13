package com.isource.model.competitors;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShortListCompetitorsMonthWiseModel {
	private Date from_date;// date,
	private Date to_date; // date,
	private String bidderName;
}

package com.isource.utility;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isource.dto.competitors.TopCompetitorListChartDto;
import com.isource.dto.dashboard.BidderTopCompetitorsMonthWiseDto;

/*
 * @author Harsh
 * */
public class CommonUtility {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static <T> T toObject(String json, TypeReference<T> typeRef) {
		T t = null;
		
		try {
			t = mapper.readValue(json, typeRef);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * From this : Fri Jan 01 05:30:00 IST 2021 To this : 2021-01-01
	 */
	public static String getProperDateFormate(Date date1) {

		final String OLD_FORMAT = "yyyy-MM-dd";
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		Date date = null;
		;
		try {
			date = newDateFormat.parse(newDateFormat.format(date1));
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		newDateFormat.applyPattern(OLD_FORMAT);  
		return newDateFormat.format(date);      //here we will get the formatted date 
	}

	/**
	 * Preparing JSON for Response From
	 * ArrayList<List<BidderTopCompetitorsMonthWiseDto>>
	 */
	@SuppressWarnings({ "unchecked", "null" })  //JSONObject will support Hashmap and also we do not have used this method in our project 
	public static JSONObject getDataInJsonFormate(ArrayList<List<BidderTopCompetitorsMonthWiseDto>> al,
			String new_date1, String new_date2) {

		JSONObject jsonBidderDetail = null;
		JSONObject jsonDtos = null;
		JSONObject jsonBidderInfo = null;
		JSONArray jsonBidderDetailArray = new JSONArray();
		JSONArray jsonDtoArray = null;
		
		String month[] = CommonUtility.getMonthArray(new_date1, new_date2); // we have passed the dates to month array.

		for (List<BidderTopCompetitorsMonthWiseDto> list : al) {
			jsonDtoArray = new JSONArray();
			
			for (BidderTopCompetitorsMonthWiseDto dto : list) {
				jsonBidderDetail = new JSONObject();
				jsonDtos = new JSONObject();
				jsonBidderInfo = new JSONObject();

				jsonDtos.put("bidderName", dto.getBidder_name());   //all values are there in TopCompMonthWiseDto. 
				jsonDtos.put("month", dto.getMonth());
				jsonDtos.put("noOfTenderParticipate", dto.getNo_of_tender_participate());
				jsonDtos.put("wonValueAwarded", dto.getWon_value_awarded());

				jsonDtoArray.add(jsonDtos);
				jsonBidderDetail.put("bidderName", dto.getBidder_name());
			}
			
			
			jsonBidderDetail.put("biddertDetail", jsonDtoArray);  //all jsonDto Vlaues are there in JsOnDtoArray
			jsonBidderDetailArray.add(jsonBidderDetail);
			
			jsonBidderInfo.put("month", Arrays.toString(month));   // above we have created month array
			jsonBidderInfo.put("bidderInfo", jsonBidderDetailArray);
		}
		return jsonBidderInfo;
	}

	/**
	 * Preparing JSON for Response From
	 * ArrayList<List<BidderTopCompetitorsMonthWiseDto>>
	 */ 
	@SuppressWarnings({ "unchecked", "null" })      //  we have not used this method in our project.
	public static JSONObject getDataInJsonFormateForCompititor(ArrayList<List<TopCompetitorListChartDto>> al,
			String new_date1, String new_date2) {

		JSONObject jsonBidderDetail = null;
		JSONObject jsonDtos = null;
		JSONObject jsonBidderInfo = null;
		JSONArray jsonBidderDetailArray = new JSONArray();
		JSONArray jsonDtoArray = null;
		String month[] = CommonUtility.getMonthArray(new_date1, new_date2);

		for (List<TopCompetitorListChartDto> list : al) {
			jsonDtoArray = new JSONArray();
			for (TopCompetitorListChartDto dto : list) {
				jsonBidderDetail = new JSONObject();
				jsonDtos = new JSONObject();
				jsonBidderInfo = new JSONObject();

				jsonDtos.put("bidderName", dto.getBidder_name());
				jsonDtos.put("month", dto.getMonth()); 
				jsonDtos.put("noOfTenderParticipate", dto.getNo_of_tender_participate());
				jsonDtos.put("wonValueAwarded", dto.getWon_value_awarded());

				jsonDtoArray.add(jsonDtos);
				jsonBidderDetail.put("bidderName", dto.getBidder_name());
			}
			jsonBidderDetail.put("biddertDetail", jsonDtoArray);
			jsonBidderDetailArray.add(jsonBidderDetail);
			jsonBidderInfo.put("month", Arrays.toString(month));
			jsonBidderInfo.put("bidderInfo", jsonBidderDetailArray);
		}
		return jsonBidderInfo;
	}

	
	public static String[] getMonthArray(String date1, String date2) {

		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		Calendar beginCalendar = Calendar.getInstance();
		Calendar finishCalendar = Calendar.getInstance();
		String date = null;
	
			LocalDate first_date = LocalDate.of(Integer.parseInt(date1.split("-")[0]),
				Integer.parseInt(date1.split("-")[1]), Integer.parseInt(date1.split("-")[2]));
		
			LocalDate second_date = LocalDate.of(Integer.parseInt(date2.split("-")[0]),
				Integer.parseInt(date2.split("-")[1]), Integer.parseInt(date2.split("-")[2]));
			
		Period difference = Period.between(first_date, second_date);

		int monthDiff = Math.abs(difference.getMonths()); 
		if (monthDiff == 0)
			monthDiff = monthDiff + 1;
		else
			monthDiff = Math.abs(difference.getMonths());

		String result[] = new String[monthDiff + 1];

		try {
			beginCalendar.setTime(formater.parse(date1));
			finishCalendar.setTime(formater.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		DateFormat formaterYd = new SimpleDateFormat("MMM-yy");
		 
		int i = 0;
		String dateStrArray[] = null;
		
		while (beginCalendar.before(finishCalendar)) {
			date = formaterYd.format(beginCalendar.getTime()).toUpperCase();
			beginCalendar.add(Calendar.MONTH, 1);
			dateStrArray = date.substring(1).toLowerCase().split("-");
			
			result[i] = date.substring(0, 1) + dateStrArray[0] + "-'" + dateStrArray[1];
			i++;
		}
		for (int i1 = 0; i1 < result.length; i1++) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
			result[i1] = " ";
				if (result[i1] == null) {
			}
			if (result[i1].contains("Sept")) {
				result[i1] = result[i1].replace("Sept", "Sep");
			}
		}
		return result;
	}
}

























package com.isource.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isource.dto.competitors.CompetitorChartResponseDto;
import com.isource.dto.competitors.CompetitorsBiddertDetailDto;
import com.isource.dto.competitors.CompetitorsDto;
import com.isource.dto.competitors.ShortListChartMonthwiseDto;
import com.isource.dto.competitors.ShortListCompetitorsChartResponseDto;
import com.isource.dto.competitors.ShortListCompetitorsListDto;
import com.isource.dto.competitors.ShortlistChartDetailDto;
import com.isource.dto.competitors.TopCompetitorListChartDto;
import com.isource.model.competitors.CompetitorsModel;
import com.isource.model.competitors.ShortListCompetitorsModel;
import com.isource.model.competitors.ShortListCompetitorsMonthWiseModel;
import com.isource.model.competitors.TopCompetitorsMonthWiseModel;
import com.isource.service.CompetitorService;
import com.isource.utility.ApiResponse;
import com.isource.utility.CommonUtility;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name = "page - 4 competitor-controller")
@Lazy
public class CompetitorController {

	@Lazy
	private CompetitorService competitorService;
	private Logger logger = null;

	@Lazy
	public CompetitorController(CompetitorService competitorService) {
		this.competitorService = competitorService;
		logger = Logger.getLogger(CompetitorController.class);
	}

	/**
	 * To get General Competitor list .
	 * 
	 * @author Harsh
	 * @date 01/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-general-competitor-list")
	@Operation(summary = "general-competitor-list")
	public ApiResponse<List<CompetitorsDto>> getGeneralCompetitorList(@RequestBody CompetitorsModel competitorsModel) {
		logger.info("/api/general-competitor-list");
		return competitorService.getGeneralCompetitorList(competitorsModel);
	}

	/**
	 * To get Top Competitor list .
	 * 
	 * @author Harsh
	 * @date 01/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-top-competitors-list")
	@Operation(summary = "get-top-competitors-list")
	public ApiResponse<List<CompetitorsDto>> getTopCompetitorList(@RequestBody CompetitorsModel competitorsModel) {
		logger.info("/api/get-top-competitors-list");
		return competitorService.getTopCompetitorList(competitorsModel);
	}

	/******* START top-competitors-list-chart *******/
	/**
	 * to get Top Competitors List Chart Monthwise .
	 * 
	 * @author Parth + Harsh
	 * @date 01/02/23
	 * @return List of appropriate Model / DTO class @apiNote@ Participated_name is
	 *         fetched from getTopCompetitorList API prepare dtos for response
	 *         CompetitorChartResponseDto [main] CompetitorsBiddertDetailDto
	 *         List<CompetitorsBiddertDetailDto>
	 */
	@PostMapping("/get-top-competitors-list-chart-month-wise")
	@Operation(summary = "get-top-competitors-list-chart-month-wise")
	public ApiResponse<CompetitorChartResponseDto> getTopCompetitorsMonthWiseList(
			@RequestBody CompetitorsModel competitorsModel) throws Exception {
		
//		logger.info("START /api/get-top-competitors-list-chart-month-wise");
//		CompetitorChartResponseDto competitorChartResponseDto = new CompetitorChartResponseDto();
//		competitorChartResponseDto.setBidderInfo(getCompetitorInfoList(competitorsModel));
//		competitorChartResponseDto.setMonth(getMonth(competitorsModel));
//		logger.info("END /api/get-top-competitors-list-chart-month-wise");
//		return new ApiResponse<CompetitorChartResponseDto>(true, "Total 1 Record ", true, competitorChartResponseDto,
//				1);
		
		try {
			logger.info("START /api/get-top-competitors-list-chart-month-wise");
			CompetitorChartResponseDto competitorChartResponseDto = new CompetitorChartResponseDto();
			
			competitorChartResponseDto.setBidderInfo(getCompetitorInfoList(competitorsModel));
			competitorChartResponseDto.setMonth(getMonth(competitorsModel));
			
			logger.info("END /api/get-top-competitors-list-chart-month-wise");
			
			System.out.println("competitorChartResponseDto : "+competitorChartResponseDto);
			
			return new ApiResponse<CompetitorChartResponseDto>(true, "Total 1 Record ", true,
					competitorChartResponseDto, 1);
		} catch (Exception ex) {
			return new ApiResponse<CompetitorChartResponseDto>(true, ex.toString(), true, null, 1);
		}
	}

	public String[] getMonth(CompetitorsModel competitorsModel) {
		return CommonUtility.getMonthArray(CommonUtility.getProperDateFormate(competitorsModel.getFrom_date()),
				CommonUtility.getProperDateFormate(competitorsModel.getTo_date()));
	}

	public List<CompetitorsBiddertDetailDto> getCompetitorInfoList(CompetitorsModel competitorsModel) {
		
		CompetitorsBiddertDetailDto competitorsBiddertDetailDto = null;
		List<CompetitorsBiddertDetailDto> competitorInfoList = new ArrayList<>();
		
		TopCompetitorsMonthWiseModel topCompetitorsMonthWiseModel = new TopCompetitorsMonthWiseModel();
		int count = 0;		
		for (CompetitorsDto competitorDto : getTopCompetitorList(competitorsModel).Data) {
			if (count == 5) {
				break;
			}
			topCompetitorsMonthWiseModel.setFrom_date(competitorsModel.getFrom_date());
			topCompetitorsMonthWiseModel.setTo_date(competitorsModel.getTo_date());
			topCompetitorsMonthWiseModel.setBidder_name(competitorsModel.getBidder_name());
			topCompetitorsMonthWiseModel.setState_ids(competitorsModel.getState_ids());
			topCompetitorsMonthWiseModel.setKeyword_ids(competitorsModel.getKeyword_ids());
			topCompetitorsMonthWiseModel.setOrganization_name(competitorsModel.getOrganization_name());
			topCompetitorsMonthWiseModel.setOrganization_type_name(competitorsModel.getOrganization_type_name());
			topCompetitorsMonthWiseModel.setParticipated_name(competitorDto.getBidder_name());
			count++;
			List<TopCompetitorListChartDto> bidderDetail = competitorService
					.getTopCompetitorListChart(topCompetitorsMonthWiseModel).Data;

			for (TopCompetitorListChartDto topCompetitorListChartDto : bidderDetail) {
				
				competitorsBiddertDetailDto = new CompetitorsBiddertDetailDto();
				
				competitorsBiddertDetailDto.setBidderDetail(bidderDetail);
				competitorsBiddertDetailDto.setBidderName(topCompetitorListChartDto.getBidder_name());
			}
			competitorInfoList.add(competitorsBiddertDetailDto);
		}
		return competitorInfoList;
	}

	/******* END top-competitors-list-chart *******/

	/**
	 * To get Shortlist Competitor List .
	 * 
	 * @author jayesh
	 * @date 06/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("get-shortlist-competitors")
	@Operation(summary = "to get the shortlist competitors")
	public ApiResponse<List<ShortListCompetitorsListDto>> getShortListCompetiotrs(
			@RequestBody ShortListCompetitorsModel shortListCompetitorsModel) {
		logger.info("/api/get-top-competitors-list");
		return competitorService.getShortListCompetitors(shortListCompetitorsModel);
	}

	/**
	 * Controller:- To get Shortlist Competitor List Cache Update .
	 * 
	 * @author jayesh
	 * @date 06/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("get-shortlist-competitors-update")
	@Operation(summary = "to get the shortlist competitors")
	public ApiResponse<List<ShortListCompetitorsListDto>> getShortListCompetiotrsUpdate(
			@RequestBody ShortListCompetitorsModel shortListCompetitorsModel) {
		logger.info("/api/get-top-competitors-list");
		return competitorService.getShortListCompetitorsUpdate(shortListCompetitorsModel);
	}

	/********** Start Shortlist Competitor *******************/
	/**
	 * To get Shortlist Competitor List Monthwise.
	 * 
	 * @author jayesh + Harsh
	 * @date 06/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("get-shortlist-competitors-list-chart-month-wise")
	@Operation(summary = "get the shortlist competitors list chart month wise")
	public ApiResponse<ShortListCompetitorsChartResponseDto> getShortListCompetiotrsMonthwiseChart(
			@RequestBody ShortListCompetitorsModel shortListCompetitorsModel) {
//		logger.info("START /api/get-shortlist-competitors-list-chart-month-wise");
//		ShortListCompetitorsChartResponseDto shortListCompetitorsChartResponseDto = new ShortListCompetitorsChartResponseDto();
//		shortListCompetitorsChartResponseDto.setBidderInfo(getShortlistinfolist(shortListCompetitorsModel));
//		shortListCompetitorsChartResponseDto.setMonth(getMonth(shortListCompetitorsModel));
//		logger.info("END /api/get-shortlist-competitors-list-chart-month-wise");
//		return new ApiResponse<ShortListCompetitorsChartResponseDto>(true, "Total 1 Record ", true,
//				shortListCompetitorsChartResponseDto, 1);
		
		try {
			logger.info("START /api/get-shortlist-competitors-list-chart-month-wise");
			ShortListCompetitorsChartResponseDto shortListCompetitorsChartResponseDto = new ShortListCompetitorsChartResponseDto();
			shortListCompetitorsChartResponseDto.setBidderInfo(getShortlistinfolist(shortListCompetitorsModel));
			shortListCompetitorsChartResponseDto.setMonth(getMonth(shortListCompetitorsModel));
			logger.info("END /api/get-shortlist-competitors-list-chart-month-wise");
			return new ApiResponse<ShortListCompetitorsChartResponseDto>(true, "Total 1 Record ", true,
					shortListCompetitorsChartResponseDto, 1);
		} catch (Exception ex) {
			return new ApiResponse<ShortListCompetitorsChartResponseDto>(true, ex.toString(), true, null, 1);
		}
	}

	                // this is get from CommonUtility and used in above post method.
	public String[] getMonth(ShortListCompetitorsModel shortListCompetitorsModel) {
		return CommonUtility.getMonthArray(CommonUtility.getProperDateFormate(shortListCompetitorsModel.getFrom_date()),
				CommonUtility.getProperDateFormate(shortListCompetitorsModel.getTo_date()));
	}

                       //this method is also used in above post mapping and it has flow upto repository.	
	public List<ShortlistChartDetailDto> getShortlistinfolist(ShortListCompetitorsModel shortListCompetitorsModel) {
		List<ShortlistChartDetailDto> shortlistinfolist = new ArrayList<>();
		ShortlistChartDetailDto shortlistChartDetailDto = null;
		ShortListCompetitorsMonthWiseModel shortListCompetitorsMonthWiseModel = new ShortListCompetitorsMonthWiseModel();
		int count = 0;		
		for (ShortListCompetitorsListDto shortListCompetitorsListDto : getShortListCompetiotrsUpdate(shortListCompetitorsModel).Data) {
			if (count == 5) {
				break;
			}
			shortListCompetitorsMonthWiseModel.setBidderName(shortListCompetitorsListDto.getBidder_name());
			shortListCompetitorsMonthWiseModel.setFrom_date(shortListCompetitorsModel.getFrom_date());
			shortListCompetitorsMonthWiseModel.setTo_date(shortListCompetitorsModel.getTo_date());
			count++;
			List<ShortListChartMonthwiseDto> biddertDetail = competitorService
					.getShortListCompetitorsChartMonthwise(shortListCompetitorsMonthWiseModel).Data;
			for (ShortListChartMonthwiseDto shortlist : biddertDetail) {
				shortlistChartDetailDto = new ShortlistChartDetailDto();
				shortlistChartDetailDto.setBiddertDetail(biddertDetail);
				shortlistChartDetailDto.setBidderName(shortlist.getBidder_name());
			}
			shortlistinfolist.add(shortlistChartDetailDto);
		}
		return shortlistinfolist;
	}
	/********** End Shortlist Competitor *******************/
}

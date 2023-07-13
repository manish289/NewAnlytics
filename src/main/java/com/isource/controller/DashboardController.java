package com.isource.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isource.dto.common.ProductDto;
import com.isource.dto.companyprofile.CompanyProfileTenderingOwnershipDto;
import com.isource.dto.competitors.BiddertDetailDto;
import com.isource.dto.competitors.TopCompetitorListChartDto;
import com.isource.dto.dashboard.AllCompetitorsDto;
import com.isource.dto.dashboard.BidderTopCompetitorsDto;
import com.isource.dto.dashboard.BidderTopCompetitorsListChartDto;
import com.isource.dto.dashboard.DashBoardChartResponseDto;
import com.isource.dto.dashboard.DashboardStatisticsDto;
import com.isource.dto.dashboard.PublishTenderStateWiseDto;
import com.isource.dto.dashboard.TenderingOwnershipDto;
import com.isource.dto.result.BidderParticipatedResultDto;
import com.isource.dto.result.ResultDetailDto;
import com.isource.model.companyprofile.CompanyProfileModel;
import com.isource.model.comparecompetitors.BidderResultModel;
import com.isource.model.competitors.BidderTopCompetitorsModel;
import com.isource.model.competitors.BidderTopCompitorsMonthWiseModel;
import com.isource.model.competitors.TopCompetitorsChartModel;
import com.isource.model.dashboard.AllCompetitorsModel;
import com.isource.model.dashboard.BidderParticipatedResultModel;
import com.isource.model.dashboard.DashboardStatisticsModel;
import com.isource.model.dashboard.PublishTenderStateWiseModel;
import com.isource.model.dashboard.TenderingOwnershipModel;
import com.isource.service.CompareCompetitorsService;
import com.isource.service.DashboardService;
import com.isource.utility.ApiResponse;
import com.isource.utility.CommonUtility;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.bytebuddy.build.Plugin.Engine.Summary;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name="page - 1 dashboard-controller")
@Lazy
public class DashboardController {

	@Lazy
	private DashboardService dashboardService;
	private Logger logger = null;

	@Lazy
	public DashboardController(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
		logger = Logger.getLogger(DashboardController.class);
	}
	
	/**
	 * To get Dashboard Statistics.
	 * 
	 * @author Harsh
	 * @date 23/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-dashboard-statistics")
	@Operation(summary = "get-dashboard-statistics")    //that operation(summery) is giving name in swagger besides the api-name
	public ApiResponse<List<DashboardStatisticsDto>> getDashboardStatistics(
			@RequestBody DashboardStatisticsModel dashboardStatistics) {
		
		logger.info("/api/get_dashboard_statistics-->>");
		
		return dashboardService.getDashboardStatistics(dashboardStatistics);
	}
	

	/**
	 * To get Bidder Top Competitors List.
	 * 
	 * @author Harsh
	 * @date 23/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-bidder-top-competitors-list")
	@Operation(summary = "get-bidder-top-competitors-list")
	public ApiResponse<List<BidderTopCompetitorsDto>> getBidderTopCompetitorsList(
			@RequestBody BidderTopCompetitorsModel bidderTopCompetitorsModel) {
		
		logger.info("/api/get-bidder-top-competitors-list-->>");
		return dashboardService.getBidderTopCompetitorsList(bidderTopCompetitorsModel);
	}

	/*Manish Practise Method*/
	@PostMapping("/DashboardBidderData")
	@Operation(summary = "get-all-details-about-Bidder")
	public ApiResponse<List<BiddertDetailDto>> giveBidderData(@RequestBody BidderResultModel bidderresultmodel)
	{
		logger.info("/api/DashboardBidderData-Started to post data");
		
		return dashboardService.postALLBidderDetailDto(bidderresultmodel);
	}
	
	
	/*Manish Practise Method*/
	@GetMapping("/getAllCompanyProfileData")
	@Operation(summary="Get-All-Company-Profile-Data")
	public ApiResponse<List<CompanyProfileTenderingOwnershipDto>> getCompanyProfileData(@RequestBody CompanyProfileModel companyProfileModel)
	{
		logger.info("Strat to get the company Profile data");
		 return dashboardService.getAllCompanyProfileData(companyProfileModel);
	}
	
	
	
	/**
	 * To get Publish Tender Statewise .
	 * 
	 * @author Harsh
	 * @date 23/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-publish-tender-state-wise")
	@Operation(summary = "get-publish-tender-state-wise")
	public ApiResponse<List<PublishTenderStateWiseDto>> getPublishTenderStateWise(
			@RequestBody PublishTenderStateWiseModel publishTenderStateWiseModel) {
		
		logger.info("/api/get-publish-tender-state-wise-->>");
		
		return dashboardService.getPublishTenderStateWise(publishTenderStateWiseModel);
	}
	

	/******* Start - Bidder Top Competitors Chart ********/
	/**
	 * To get Bidder Top Competitors List Monthwise. 21/01/23
	 * 
	 * @author Harsh + Jayesh 
	 * @date 23/01/23
	 * @return List of appropriate Model / DTO class @apiNote@ Participated_name is
	 *         fetched from getBidderTopCompetitorsList API prepare dtos for
	 *         response DashBoardChartResponseDto [main] BiddertDetailDto
	 *         List<BiddertDetailDto>
	 */
	@PostMapping("/get-bidder-top-competitors-list-chart-month-wise")
	@Operation(summary = "get-bidder-top-competitors-list-chart-month-wise")
	public ApiResponse<DashBoardChartResponseDto> getBidderTopCompetitorsMonthWiseList(
			@RequestBody BidderTopCompetitorsModel bidderTopCompetitorsModel) throws Exception {
//		logger.info("START : /api/get-bidder-top-competitors-list-chart-month-wise-->>");
//		DashBoardChartResponseDto dashBoardResponse = new DashBoardChartResponseDto();
//		dashBoardResponse.setBidderInfo(getBidderInfoList(bidderTopCompetitorsModel));
//		dashBoardResponse.setMonth(getMonth(bidderTopCompetitorsModel));
//		logger.info("END");
//		return new ApiResponse<DashBoardChartResponseDto>(true, "Total 1 Record ", true, dashBoardResponse, 1);
		
		logger.info("START : get-bidder-top-competitors-list-chart-month-wise-->>");
		
		
		try {
			DashBoardChartResponseDto dashBoardResponse = new DashBoardChartResponseDto();
			
			dashBoardResponse.setBidderInfo(getBidderInfoList(bidderTopCompetitorsModel));
			dashBoardResponse.setMonth(getMonth(bidderTopCompetitorsModel));
			
			logger.info("End : get-bidder-top-competitors-list-chart-month-wise-->>");
			
			return new ApiResponse<DashBoardChartResponseDto>(true, "Total 1 Record ", true, dashBoardResponse, 1);
		} catch (Exception ex) {
			return new ApiResponse<DashBoardChartResponseDto>(false, ex.toString(), true, null, 0);
		}
		
	}
	                                //getmonthArray method is used from CommonnUtility and this getMonth method is used in above post mapping method
	public String[] getMonth(BidderTopCompetitorsModel bidderTopCompetitorsModel) {
		return CommonUtility.getMonthArray(
				CommonUtility.getProperDateFormate(bidderTopCompetitorsModel.getFrom_date()),
				CommonUtility.getProperDateFormate(bidderTopCompetitorsModel.getTo_date()));
	}
	
	                            // this method is used in above post mapping method      
	public List<BiddertDetailDto> getBidderInfoList(BidderTopCompetitorsModel bidderTopCompetitorsModel) {
		BiddertDetailDto biddertDetailDto = null;
		List<BiddertDetailDto> bidderInfoList = new ArrayList<>();
		
		BidderTopCompitorsMonthWiseModel bidderTopCompitorsMonthWise = new BidderTopCompitorsMonthWiseModel();
		
		for (BidderTopCompetitorsDto bidderDto : getBidderTopCompetitorsList(bidderTopCompetitorsModel).Data) {
			
			bidderTopCompitorsMonthWise.setFrom_date(bidderTopCompetitorsModel.getFrom_date());
			bidderTopCompitorsMonthWise.setTo_date(bidderTopCompetitorsModel.getTo_date());
			bidderTopCompitorsMonthWise.setBidder_name(bidderDto.getBidder_name());
		//	bidderTopCompitorsMonthWise.setParticipate_bidder(bidderDto.getBidder_name());
			
			List<BidderTopCompetitorsListChartDto > bidderDetail = dashboardService
					.getBidderTopCompetitorsListMonthWise(bidderTopCompitorsMonthWise).Data;
			
			for (BidderTopCompetitorsListChartDto  bidderMonthWiseDto : bidderDetail) {
			
				biddertDetailDto = new BiddertDetailDto();
				biddertDetailDto.setBidderDetail(bidderDetail);
				biddertDetailDto.setBidderName(bidderMonthWiseDto.getBidder_name());  // all bidderDetailDto valued is passed to the is to down we have created list.
			}
			
			bidderInfoList.add(biddertDetailDto);  //ABOVE List is set null there.
		}
		return bidderInfoList;
	}
	/******* End - Bidder Top Competitors Chart ********/
	
	
	
	
	
	
	/**
	 * To get tendering-ownership.
	 * 
	 * @author jayesh 
	 * @date 23/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-tendering-ownership")
	@Operation(summary = "get-tendering-ownership")
	public ApiResponse<List<TenderingOwnershipDto>> getTenderingOwnership(
			@RequestBody TenderingOwnershipModel tenderingOwnershipModel) {
		logger.info("/api/get-bidder-top-competitors-list-->>");
		return dashboardService.getTenderingOwnership(tenderingOwnershipModel);
	}

	/**
	 * To get dashboard list of top competitors list
	 * 
	 * @author jayesh 
	 * @date 15/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-dashboard-all-competitors-list")
	@Operation(summary = "get-dashboard-all-competitors-list")
	public ApiResponse<List<AllCompetitorsDto>> getAllTopCompetitorsList(
			@RequestBody AllCompetitorsModel allCompetitorsModel) {
		logger.info("/api/get-dashboard-all-competitors-list-->>");
		return dashboardService.getAllTopCompetitorsList(allCompetitorsModel);
	}
	
	
	
	//manish practise Method
	@Operation(summary = "Get_All_Result_Participants")
	@GetMapping("/get_all_Participated_Result")
	public ApiResponse<List<BidderParticipatedResultDto>> getParticipatedResultData(@RequestBody BidderParticipatedResultModel bidderparticipatedResultModel)
	{
		logger.info("Start to get ParticipatedData in DashControl");
		return dashboardService.getAllParticipatedData(bidderparticipatedResultModel);
		
	}
	
	
	
	

}

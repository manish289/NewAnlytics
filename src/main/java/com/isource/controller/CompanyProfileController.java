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

import com.isource.dto.companyprofile.CompanyProfileTenderingOwnershipDto;
import com.isource.dto.companyprofile.DepartmentDto;
import com.isource.dto.companyprofile.MonthWiseListChartDto;
import com.isource.dto.companyprofile.MonthwiseBidderDetailDto;
import com.isource.dto.companyprofile.MonthwiseResponseDto;
import com.isource.dto.companyprofile.StatewiseDto;
import com.isource.dto.companyprofile.StatisticsDto;
import com.isource.dto.companyprofile.TenderStageDto;
import com.isource.model.companyprofile.CompanyProfileModel;
import com.isource.service.CompanyProfileService;
import com.isource.utility.ApiResponse;
import com.isource.utility.CommonUtility;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name="page - 5 company-profile-controller")
@Lazy
public class CompanyProfileController {

	@Lazy
	private CompanyProfileService companyProfileService;
	private Logger logger = null;

	@Lazy
	public CompanyProfileController(CompanyProfileService companyProfileService) {
		this.companyProfileService = companyProfileService;
		logger = Logger.getLogger(CompanyProfileController.class);
	}

	/**
	 * To get get Company profile Statistics
	 * 
	 * @author jayesh
	 * @date 08/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-company-profile-statistics")
	@Operation(summary = "get-company-profile-statistics")
	public ApiResponse<List<StatisticsDto>> getCompanyProfileStatistics(
			@RequestBody CompanyProfileModel companyProfileModel) {
		logger.info("/api/get-company-profile-statistics-->>");
		return companyProfileService.getCompanyProfileStatistics(companyProfileModel);
	}

	/**
	 * To get Company Profile Statewise Tender .
	 * 
	 * @author jayesh
	 * @date 08/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-company-profile-publish-tender-state-wise")
	@Operation(summary = "get-company-profile-publish-tender-state-wise")
	public ApiResponse<List<StatewiseDto>> getCompanyProfileStatewise(
			@RequestBody CompanyProfileModel companyProfileModel) {
		logger.info("/api/get-company-profile-publish-tender-state-wise-->>");
		return companyProfileService.getCompanyProfileStatewise(companyProfileModel);
	}

	/**
	 * To get Company Profile Tendering Ownership.
	 * 
	 * @author jayesh
	 * @date 08/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-company-profile-tendering-ownership")
	@Operation(summary = "get-company-profile--tendering-ownership")
	public ApiResponse<List<CompanyProfileTenderingOwnershipDto>> getCompanyProfileTenderingOwnership(
			@RequestBody CompanyProfileModel companyProfileModel) {
		logger.info("/api/get-company-profile--tendering-ownership-->>");
		return companyProfileService.getCompanyProfileTenderingOwnership(companyProfileModel);
	}

	/**
	 * To get Company Profile Department.
	 * 
	 * @author jayesh
	 * @date 08/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-company-profile-department")
	@Operation(summary = "get-company-profile-department ")
	public ApiResponse<List<DepartmentDto>> getCompanyProfileDepartment(
			@RequestBody CompanyProfileModel companyProfileModel) {
		logger.info("/api/get-company-profile-department-->>");
		return companyProfileService.getCompanyProfileDepartment(companyProfileModel);
	}

//	/**
//	 * to get Top Competitors List Chart Monthwise .
//	 * 
//	 * @author Parth + Jayesh
//	 * @date 01/02/23
//	 * @return List of appropriate Model / DTO class @apiNote@ Participated_name is
//	 *         fetched from getTopCompetitorList API prepare dtos for response
//	 *         CompetitorChartResponseDto [main] CompetitorsBiddertDetailDto
//	 *         List<CompetitorsBiddertDetailDto>
//	 */
//	@PostMapping("/get-company-month-wise-tender-chart")
//	@Operation(summary = "get-company-month-wise-tender-chart")
//	public ApiResponse<MonthwiseResponseDto> getMonthWiseChart(@RequestBody CompanyProfileModel companyProfileModel)
//			throws Exception {
//		logger.info("/api/get-month-wise-tender-chart");
//
//		MonthwiseResponseDto monthwiseResponseDto = new MonthwiseResponseDto();
//		MonthwiseBidderDetailDto monthwiseBidderDetailDto = null;// change name MonthwiseBidderDetailDto
//		List<MonthwiseBidderDetailDto> tenderInfoList = new ArrayList<>();
//
//		for (MonthWiseListChartDto monthWiseListChartDto : companyProfileService
//				.getMonthWiseChart(companyProfileModel).Data) {
//			monthwiseBidderDetailDto = new MonthwiseBidderDetailDto();
//			monthwiseBidderDetailDto.setBiddertDetail(companyProfileService.getMonthWiseChart(companyProfileModel).Data);
//			monthwiseBidderDetailDto.setBidderName(monthWiseListChartDto.getBidder_name());
//		}
//		tenderInfoList.add(monthwiseBidderDetailDto);
//
//		String month[] = CommonUtility.getMonthArray(CommonUtility.getProperDateFormate(companyProfileModel.getFrom_date()),
//				CommonUtility.getProperDateFormate(companyProfileModel.getTo_date()));
//
//		monthwiseResponseDto.setBidderInfo(tenderInfoList);
//		monthwiseResponseDto.setMonth(month);
//	
//		return new ApiResponse<MonthwiseResponseDto>(true, "Total 1 Record ", true, monthwiseResponseDto, 1);
//	}
	
	/**
	 * to get Top Competitors List Chart Monthwise .
	 * 
	 * @author Parth + Jayesh
	 * @date 01/02/23
	 * @return List of appropriate Model / DTO class @apiNote@ Participated_name is
	 *         fetched from getTopCompetitorList API prepare dtos for response
	 *         CompetitorChartResponseDto [main] CompetitorsBiddertDetailDto
	 *         List<CompetitorsBiddertDetailDto>
	 */
	@PostMapping("/get-company-month-wise-tender-chart")
	@Operation(summary = "get-company-month-wise-tender-chart")
	public ApiResponse<MonthwiseResponseDto> getMonthWiseChart(@RequestBody CompanyProfileModel companyProfileModel) {
		try {
			logger.info("/api/get-month-wise-tender-chart");
			
			MonthwiseResponseDto monthwiseResponseDto = new MonthwiseResponseDto();
			monthwiseResponseDto.setBidderInfo(getTenderInfo(companyProfileModel));
			monthwiseResponseDto.setMonth(getMonthArray(companyProfileModel));
			
			return new ApiResponse<MonthwiseResponseDto>(true, "Total 1 Record ", true, monthwiseResponseDto, 1);
		} catch (Exception ex) {
			return new ApiResponse<MonthwiseResponseDto>(true, ex.toString(), true, null, 1);
		}
	}
	
	  // this is get from CommonUtility and used in above post method.
	public String[] getMonthArray(CompanyProfileModel companyProfileModel) {
		return CommonUtility.getMonthArray(CommonUtility.getProperDateFormate(companyProfileModel.getFrom_date()),
				CommonUtility.getProperDateFormate(companyProfileModel.getTo_date()));
	}
	 
	       //this method is also used in above post mapping and it has flow upto repository.	
	public List<MonthwiseBidderDetailDto> getTenderInfo(CompanyProfileModel companyProfileModel){
		
		MonthwiseBidderDetailDto monthwiseBidderDetailDto = null;
		List<MonthwiseBidderDetailDto> tenderInfoList = new ArrayList<>();
		
		for (MonthWiseListChartDto monthWiseListChartDto : companyProfileService
				.getMonthWiseChart(companyProfileModel).Data) {
			monthwiseBidderDetailDto = new MonthwiseBidderDetailDto();
			monthwiseBidderDetailDto
					.setBiddertDetail(companyProfileService.getMonthWiseChart(companyProfileModel).Data);
			monthwiseBidderDetailDto.setBidderName(monthWiseListChartDto.getBidder_name());
		}
		tenderInfoList.add(monthwiseBidderDetailDto);
		return tenderInfoList;
	}
	
	/**
	 * To get Company Profile Stage.
	 * 
	 * @author jayesh
	 * @date 09/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-company-profile-stage")
	@Operation(summary = "get-company-profile-stage")
	public ApiResponse<List<TenderStageDto>> getCompanyProfileTenderStage(
			@RequestBody CompanyProfileModel companyProfileModel) {
		logger.info("/api/get-company-profile-monthwise-tender");
		return companyProfileService.getCompanyProfileTenderStage(companyProfileModel);
	}
	
}

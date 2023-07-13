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

import com.isource.dto.comparecompetitors.CompanyNameForComparisonDto;
import com.isource.dto.comparecompetitors.ComparisonResponseDto;
import com.isource.dto.comparecompetitors.IndividualComparisonResponseDto;
import com.isource.dto.comparecompetitors.IndividualStrongPointsResponseDto;
import com.isource.dto.comparecompetitors.SameBidComparisionStateWiseDto;
import com.isource.dto.comparecompetitors.SameBidResponseDto;
import com.isource.dto.comparecompetitors.StrongPointsResponseDto;
import com.isource.model.comparecompetitors.CompanyCompareModel;
import com.isource.model.comparecompetitors.CompanyNameModel;
import com.isource.model.comparecompetitors.SameBidComparisionStateWiseModel;
import com.isource.model.comparecompetitors.SameBidModel;
import com.isource.model.comparecompetitors.StrongPointsModel;
import com.isource.service.CompareCompetitorsService;
import com.isource.utility.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name = "page - 8 compare-competitors-controller")
@Lazy
public class CompareCompetitorsController {

	@Lazy
	private CompareCompetitorsService compareCompetitorsService;
	private Logger logger = null;

	@Lazy
	public CompareCompetitorsController(CompareCompetitorsService compareCompetitorsService) {
		this.compareCompetitorsService = compareCompetitorsService;
		logger = Logger.getLogger(CompanyProfileController.class);
	}

	/**
	 * To get Company Compare .
	 * 
	 * @author Parth + Harsh
	 * @date 24/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-compare-competitor-companies")
	@Operation(summary = "get-compare-competitor-companies")
	public ApiResponse<IndividualComparisonResponseDto> getCompareIndividualComparision(
			@RequestBody CompanyCompareModel companyCompareModel) {
		
		logger.info("/api/get-compare-competitor-companies");
		try {
			IndividualComparisonResponseDto individualComparisonResponseDto = new IndividualComparisonResponseDto();
			ComparisonResponseDto comparisonResponseDto = null;
			List<ComparisonResponseDto> comparisonResponseList = new ArrayList<>();
			;
			for (String biddername : companyCompareModel.getBidder_name().split(",")) {
			comparisonResponseDto = new ComparisonResponseDto();
				companyCompareModel.setBidder_name(biddername);
				
				comparisonResponseDto.setTenderOwnerShip(
						compareCompetitorsService.getCompareIndividualTenderOwnership(companyCompareModel).Data);
				comparisonResponseDto.setTenderInfo(
						compareCompetitorsService.getCompareIndividualComparision(companyCompareModel).Data);
				comparisonResponseDto.setTenderState(
						compareCompetitorsService.getCompareIndividualComparisionState(companyCompareModel).Data);
				
				comparisonResponseList.add(comparisonResponseDto);
				
			}
			individualComparisonResponseDto.setCompanyInfo(comparisonResponseList);
			
			return new ApiResponse<IndividualComparisonResponseDto>(true, "Total 1 Record", false,
					individualComparisonResponseDto, 1);
		} catch (Exception ex) {
			return new ApiResponse<IndividualComparisonResponseDto>(false, ex.toString(), true, null, 0);
		}
	}
	
	/**
	 * To get Company Compare.   
	 * 
	 * @author Jayesh + Parth + Harsh
	 * @date 24/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-strong-points-of-competitor-companies")
	@Operation(summary = "get-strong-points-of-competitor-companies")
	public ApiResponse<IndividualStrongPointsResponseDto> getStrongPoints(
			@RequestBody StrongPointsModel strongPointsModel) {
		logger.info("/api/get-strong-points-of-competitor-companies");

		IndividualStrongPointsResponseDto individualStrongPointsResponseDto = new IndividualStrongPointsResponseDto();
		StrongPointsResponseDto strongPointsResponseDto = null;
		
		List<StrongPointsResponseDto> strongPointsResponseList = new ArrayList<>();
		;

		for (String biddername : strongPointsModel.getBidder_name().split(",")) {

			strongPointsResponseDto = new StrongPointsResponseDto();
			strongPointsModel.setBidder_name(biddername);

			strongPointsResponseDto
					.setOwnershipInfo(compareCompetitorsService.getStrongPointsOwnershipwise(strongPointsModel).Data);

			strongPointsResponseDto
					.setDepartmentInfo(compareCompetitorsService.getStrongPointsDepartmentwise(strongPointsModel).Data);

			strongPointsResponseDto
					.setStateInfo(compareCompetitorsService.getStrongPointsStatetwise(strongPointsModel).Data);

			strongPointsResponseList.add(strongPointsResponseDto);
		}
		individualStrongPointsResponseDto.setStrongPointInfo(strongPointsResponseList);
		return new ApiResponse<IndividualStrongPointsResponseDto>(true, "Total 1 Record", false,
				individualStrongPointsResponseDto, 1);
	}

	/**
	 * To get Same bid
	 * 
	 * @author Harsh
	 * @date 02/03/2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-same-bid-of-competitor-companies")
	@Operation(summary = "get-same-bid-of-competitor-companies")
	public ApiResponse<SameBidResponseDto> getSameBid(@RequestBody SameBidModel sameBidModel) {
		logger.info("/api/get-same-bid-of-competitor-companies");
		
		SameBidResponseDto sameBidResponseDto = new SameBidResponseDto();
		sameBidResponseDto = compareCompetitorsService.getSameBid(sameBidModel).Data;
		return new ApiResponse<SameBidResponseDto>(true, "Total 1 Record", false, sameBidResponseDto, 1);
	}

	/**
	 * To get Same bid
	 * 
	 * @author Parth
	 * @date 09/03/2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-compare-same-bid-comparision-state-wise")
	@Operation(summary = "/get-compare-same-bid-comparision-state-wise")
	public ApiResponse<List<SameBidComparisionStateWiseDto>> getCompareSameBidComparisionStateWise(
			@RequestBody SameBidComparisionStateWiseModel sameBidComparisionStateWiseModel) {
		logger.info("/api/get-compare-same-bid-comparision-state-wise");
		return compareCompetitorsService.getCompareSameBidComparisionStateWise(sameBidComparisionStateWiseModel);
	}

	/**
	 * To get list of company name for comparison
	 * 
	 * @author Harsh
	 * @date 21/03/2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-company-name-for-comparison")
	@Operation(summary = "/get-company-name-for-comparison")
	public ApiResponse<List<CompanyNameForComparisonDto>> getCompanyNameForComparison(
			@RequestBody CompanyNameModel companyNameModel) {
		logger.info("/api/get-get-company-name-for-comparison");
		return compareCompetitorsService.getCompanyNameForComparison(companyNameModel);
	}
}

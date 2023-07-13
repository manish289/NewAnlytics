package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.comparecompetitors.ComapniesCompareDto;
import com.isource.dto.comparecompetitors.CompanyNameForComparisonDto;
import com.isource.dto.comparecompetitors.CompareTenderOwnershipDto;
import com.isource.dto.comparecompetitors.CompareTenderStateDto;
import com.isource.dto.comparecompetitors.SameBidComparisionStateWiseDto;
import com.isource.dto.comparecompetitors.SameBidResponseDto;
import com.isource.dto.comparecompetitors.StrongPointDepartmentDto;
import com.isource.dto.comparecompetitors.StrongPointStateDto;
import com.isource.dto.comparecompetitors.StrongPointsOwnershipwiseDto;
import com.isource.model.comparecompetitors.CompanyCompareModel;
import com.isource.model.comparecompetitors.CompanyNameModel;
import com.isource.model.comparecompetitors.SameBidComparisionStateWiseModel;
import com.isource.model.comparecompetitors.SameBidModel;
import com.isource.model.comparecompetitors.StrongPointsModel;
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface CompareCompetitorsService {

	ApiResponse<ComapniesCompareDto> getCompareIndividualComparision(CompanyCompareModel companyCompareModel);
	ApiResponse<List<CompareTenderOwnershipDto>> getCompareIndividualTenderOwnership(CompanyCompareModel companyCompareModel);
	ApiResponse<List<CompareTenderStateDto>> getCompareIndividualComparisionState(CompanyCompareModel companyCompareModel);

	ApiResponse<StrongPointDepartmentDto> getStrongPointsDepartmentwise(StrongPointsModel strongPointsModel);
	ApiResponse<StrongPointStateDto> getStrongPointsStatetwise(StrongPointsModel strongPointsModel);
	ApiResponse<StrongPointsOwnershipwiseDto> getStrongPointsOwnershipwise(StrongPointsModel strongPointsModel);

	ApiResponse<SameBidResponseDto> getSameBid(SameBidModel sameBidModel);
	ApiResponse<List<SameBidComparisionStateWiseDto>>getCompareSameBidComparisionStateWise(SameBidComparisionStateWiseModel sameBidComparisionStateWiseModel);

	ApiResponse<List<CompanyNameForComparisonDto>> getCompanyNameForComparison(CompanyNameModel companyNameModel);
	
}


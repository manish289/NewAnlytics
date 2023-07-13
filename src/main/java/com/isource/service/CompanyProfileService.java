package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.companyprofile.CompanyProfileTenderingOwnershipDto;
import com.isource.dto.companyprofile.DepartmentDto;
import com.isource.dto.companyprofile.MonthWiseListChartDto;
import com.isource.dto.companyprofile.StatewiseDto;
import com.isource.dto.companyprofile.StatisticsDto;
import com.isource.dto.companyprofile.TenderStageDto;
import com.isource.model.companyprofile.CompanyProfileModel;
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface CompanyProfileService {

	ApiResponse<List<StatisticsDto>> getCompanyProfileStatistics(CompanyProfileModel companyProfileModel);
	ApiResponse<List<StatewiseDto>> getCompanyProfileStatewise(CompanyProfileModel companyProfileModel);
	ApiResponse<List<CompanyProfileTenderingOwnershipDto>> getCompanyProfileTenderingOwnership(CompanyProfileModel companyProfileModel);
	ApiResponse<List<DepartmentDto>> getCompanyProfileDepartment(CompanyProfileModel companyProfileModel);
	ApiResponse<List<TenderStageDto>> getCompanyProfileTenderStage(CompanyProfileModel companyProfileModel);
	ApiResponse<List<MonthWiseListChartDto>> getMonthWiseChart(CompanyProfileModel companyProfileModel);
}

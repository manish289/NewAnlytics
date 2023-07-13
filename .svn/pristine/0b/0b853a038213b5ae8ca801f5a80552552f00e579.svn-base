package com.isource.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.connection.web.DbContextServiceWeb;
import com.isource.dto.companyprofile.CompanyProfileTenderingOwnershipDto;
import com.isource.dto.companyprofile.DepartmentDto;
import com.isource.dto.companyprofile.MonthWiseListChartDto;
import com.isource.dto.companyprofile.StatewiseDto;
import com.isource.dto.companyprofile.StatisticsDto;
import com.isource.dto.companyprofile.TenderStageDto;
import com.isource.model.companyprofile.CompanyProfileModel;
import com.isource.service.CacheManagerService;
import com.isource.service.CompanyProfileService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class CompanyProfileRepository implements CompanyProfileService {

	private Logger logger = null;
	@Lazy
	private DbContextServiceWeb _DbContextserviceWeb;

	@Lazy
	private CacheManagerService cacheManagerService;

	@Lazy
	public CompanyProfileRepository(DbContextServiceWeb _DbContextserviceWeb, CacheManagerService cacheManagerService) {
		this._DbContextserviceWeb = _DbContextserviceWeb;
		this.cacheManagerService = cacheManagerService;
		logger = Logger.getLogger(CompanyProfileRepository.class);
	}

	@Override
	public ApiResponse<List<StatisticsDto>> getCompanyProfileStatistics(CompanyProfileModel companyProfileModel) {

		List<StatisticsDto> companyProfileStatistics = null;
		try {
			logger.info("Start CompanyProfileStatistics ");
			companyProfileStatistics = cacheManagerService.getCompanyProfileStatistics(companyProfileModel);
			logger.info("End CompanyProfileStatistics ");
			return new ApiResponse<List<StatisticsDto>>(true, "Total " + companyProfileStatistics.size() + " Records",
					true, companyProfileStatistics, companyProfileStatistics.size());
		} catch (Exception ex) {
			return new ApiResponse<List<StatisticsDto>>(false, ex.toString(), false, companyProfileStatistics, 0);
		}
	}

	@Override
	public ApiResponse<List<StatewiseDto>> getCompanyProfileStatewise(CompanyProfileModel companyProfileModel) {

		List<StatewiseDto> companyProfileStatewiseDto = null;
		try {
			logger.info("Start CompanyProfilePublishTenderStateWise ");
			companyProfileStatewiseDto = cacheManagerService.getCompanyProfileStatewise(companyProfileModel);
			logger.info("End CompanyProfilePublishTenderStateWise ");
			return new ApiResponse<List<StatewiseDto>>(true, "Total " + companyProfileStatewiseDto.size() + " Records",
					true, companyProfileStatewiseDto, companyProfileStatewiseDto.size());
		} catch (Exception ex) {
			return new ApiResponse<List<StatewiseDto>>(false, ex.toString(), true, companyProfileStatewiseDto, 0);
		}
	}

	@Override
	public ApiResponse<List<CompanyProfileTenderingOwnershipDto>> getCompanyProfileTenderingOwnership(
			CompanyProfileModel companyProfileModel) {

		List<CompanyProfileTenderingOwnershipDto> companyProfileTenderingOwnershipDto = null;
		try {
			logger.info("Start tenderingOwnership");
			companyProfileTenderingOwnershipDto = cacheManagerService
					.getCompanyProfileTenderingOwnership(companyProfileModel);
			logger.info("End tenderingOwnership");
			return new ApiResponse<List<CompanyProfileTenderingOwnershipDto>>(true,
					"Total " + companyProfileTenderingOwnershipDto.size() + " Records", true,
					companyProfileTenderingOwnershipDto, companyProfileTenderingOwnershipDto.size());
		} catch (Exception ex) {
			return new ApiResponse<List<CompanyProfileTenderingOwnershipDto>>(false, ex.toString(), true,
					companyProfileTenderingOwnershipDto, 0);
		}
	}

	@Override
	public ApiResponse<List<DepartmentDto>> getCompanyProfileDepartment(CompanyProfileModel companyProfileModel) {

		List<DepartmentDto> companyProfileDepartmentDto = null;
		try {
			logger.info("Start companyProfileDepartment");
			companyProfileDepartmentDto = cacheManagerService.getCompanyProfileDepartment(companyProfileModel);
			logger.info("End companyProfileDepartment");
			return new ApiResponse<List<DepartmentDto>>(true,
					"Total " + companyProfileDepartmentDto.size() + " Records", true, companyProfileDepartmentDto,
					companyProfileDepartmentDto.size());
		} catch (Exception ex) {
			return new ApiResponse<List<DepartmentDto>>(false, ex.toString(), true, companyProfileDepartmentDto, 0);
		}
	}

	@Override
	public ApiResponse<List<TenderStageDto>> getCompanyProfileTenderStage(CompanyProfileModel companyProfileModel) {
		
		List<TenderStageDto> tenderStageDto = null;
		try {
			logger.info("Start TenderStageDto");
			tenderStageDto = cacheManagerService.getCompanyProfileTenderStage(companyProfileModel);
			logger.info("End TenderStageDto");
			return new ApiResponse<List<TenderStageDto>>(true, "Total " + tenderStageDto.size() + " Records", true,
					tenderStageDto, tenderStageDto.size());
		} catch (Exception ex) {
			return new ApiResponse<List<TenderStageDto>>(false, ex.toString(), true, tenderStageDto, 0);
		}
	}

	@Override
	public ApiResponse<List<MonthWiseListChartDto>> getMonthWiseChart(CompanyProfileModel companyProfileModel) {
		
		List<MonthWiseListChartDto> monthWiseListChartDto = null;
		try {
			logger.info("Start MonthWiseChart");
			monthWiseListChartDto = cacheManagerService.getMonthWiseChart(companyProfileModel);
			logger.info("End MonthWiseChart");
			return new ApiResponse<List<MonthWiseListChartDto>>(true,
					"Total " + monthWiseListChartDto.size() + " Records", true, monthWiseListChartDto,
					monthWiseListChartDto.size());
		} catch (Exception ex) {
			return new ApiResponse<List<MonthWiseListChartDto>>(false, ex.toString(), false, monthWiseListChartDto, 0);
		}
	}
}

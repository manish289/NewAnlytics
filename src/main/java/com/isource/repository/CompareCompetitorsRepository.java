package com.isource.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.connection.web.DbContextServiceWeb;
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
import com.isource.query.QueryMasters;
import com.isource.service.CacheManagerService;
import com.isource.service.CompareCompetitorsService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class CompareCompetitorsRepository implements CompareCompetitorsService {

	private Logger logger = null;
	@Lazy
	private DbContextServiceWeb _DbContextserviceWeb;
	@Lazy
	private CacheManagerService CacheManagerService;

	@Lazy
	public CompareCompetitorsRepository(DbContextServiceWeb _DbContextserviceWeb,
			CacheManagerService CacheManagerService) {
		this._DbContextserviceWeb = _DbContextserviceWeb;
		this.CacheManagerService = CacheManagerService;
		logger = Logger.getLogger(CompareCompetitorsRepository.class);
	}

	@Override
	public ApiResponse<ComapniesCompareDto> getCompareIndividualComparision(CompanyCompareModel companyCompareModel) {

		ComapniesCompareDto comapniesCompareDto = new ComapniesCompareDto();
		try {

			Object param[] = { companyCompareModel.getFrom_date(), companyCompareModel.getTo_date(),
					companyCompareModel.getKeyword_id(), companyCompareModel.getState_id(),
					companyCompareModel.getBidder_name() };
			logger.info("Start CompareIndividualComparision");
			
			comapniesCompareDto = _DbContextserviceWeb
					.QueryToListWithParam(QueryMasters.compare_individual_comparision, param, ComapniesCompareDto.class)
					.get(0);
			logger.info("End CompareIndividualComparision");
			
			return new ApiResponse<ComapniesCompareDto>(true, "Total 1 Records", true, comapniesCompareDto, 1);
		} catch (Exception ex) {
			return new ApiResponse<ComapniesCompareDto>(false, ex.toString(), false, comapniesCompareDto, 0);
		}
	}

	@Override
	public ApiResponse<List<CompareTenderOwnershipDto>> getCompareIndividualTenderOwnership(
			CompanyCompareModel companyCompareModel) {

		List<CompareTenderOwnershipDto> ownershipDto = null;
		try {

			Object param[] = { 
					companyCompareModel.getFrom_date(), 
					companyCompareModel.getTo_date(),
					companyCompareModel.getBidder_name(), 
					companyCompareModel.getKeyword_id(),
					companyCompareModel.getState_id() };
			logger.info("Start CompareIndividualTenderOwnership");
			
			ownershipDto = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.compare_tender_ownership, param,
					CompareTenderOwnershipDto.class);
			
			logger.info("End CompareIndividualTenderOwnership");
			
			return new ApiResponse<List<CompareTenderOwnershipDto>>(true, "Total " + ownershipDto.size() + " Records",
					true, ownershipDto, ownershipDto.size());
		} catch (Exception ex) {
			return new ApiResponse<List<CompareTenderOwnershipDto>>(false, ex.toString(), false, ownershipDto, 0);
		}
	}

	@Override
	public ApiResponse<List<CompareTenderStateDto>> getCompareIndividualComparisionState(
			CompanyCompareModel companyCompareModel) {
		List<CompareTenderStateDto> compareTenderStateDto = null;
		try {

			Object param[] = { companyCompareModel.getFrom_date(), companyCompareModel.getTo_date(),
					companyCompareModel.getBidder_name(), companyCompareModel.getKeyword_id(),
					companyCompareModel.getState_id() };
			logger.info("Start CompareIndividualComparision");
			compareTenderStateDto = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.compare_tender_statewise,
					param, CompareTenderStateDto.class);
			logger.info("End CompareIndividualComparision");
			return new ApiResponse<List<CompareTenderStateDto>>(true,
					"Total " + compareTenderStateDto.size() + " Records", true, compareTenderStateDto,
					compareTenderStateDto.size());
		} catch (Exception ex) {
			return new ApiResponse<List<CompareTenderStateDto>>(false, ex.toString(), false, compareTenderStateDto, 0);
		}
	}

	@Override
	public ApiResponse<StrongPointDepartmentDto> getStrongPointsDepartmentwise(StrongPointsModel strongPointsModel) {
		StrongPointDepartmentDto strongPointDepartmentDto = new StrongPointDepartmentDto();
		try {
			Object param[] = { 
					strongPointsModel.getFrom_date(), 
					strongPointsModel.getTo_date(),
					strongPointsModel.getBidder_name(), 
					strongPointsModel.getKeyword_id(),
					strongPointsModel.getState_id() };
			logger.info("Start CompareStrongPointsDepartmentWise");
			strongPointDepartmentDto = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.compare_strong_points_department_wise, param, StrongPointDepartmentDto.class).get(0);
			logger.info("End CompareStrongPointsDepartmentWise");
			return new ApiResponse<StrongPointDepartmentDto>(true, "Total 1 Records", true, strongPointDepartmentDto,
					1);
		} catch (Exception ex) {
			return new ApiResponse<StrongPointDepartmentDto>(true, ex.toString(), false, strongPointDepartmentDto, 0);
		}
	}

	@Override
	public ApiResponse<StrongPointsOwnershipwiseDto> getStrongPointsOwnershipwise(
			StrongPointsModel strongPointsModel) {
		StrongPointsOwnershipwiseDto strongPointsOwnershipwiseDto = new StrongPointsOwnershipwiseDto();
		try {

			Object param[] = { strongPointsModel.getFrom_date(), strongPointsModel.getTo_date(),
					strongPointsModel.getBidder_name(), strongPointsModel.getKeyword_id(),
					strongPointsModel.getState_id() };
			logger.info("Start CompareIndividualTenderOwnership");
			
			strongPointsOwnershipwiseDto = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.compare_strong_points_ownership_wise, param, StrongPointsOwnershipwiseDto.class).get(0);
			
			logger.info("End CompareIndividualTenderOwnership");
			return new ApiResponse<StrongPointsOwnershipwiseDto>(true,
					"Total 1 Records", true, strongPointsOwnershipwiseDto,
					1);
		} catch (Exception ex) {
			return new ApiResponse<StrongPointsOwnershipwiseDto>(false, ex.toString(), false,
					strongPointsOwnershipwiseDto, 0);
		}
	}

	@Override
	public ApiResponse<StrongPointStateDto> getStrongPointsStatetwise(StrongPointsModel strongPointsModel) {
		StrongPointStateDto strongPointStateDto = new StrongPointStateDto();
		try {

			Object param[] = { strongPointsModel.getFrom_date(), strongPointsModel.getTo_date(),
					strongPointsModel.getBidder_name(), strongPointsModel.getKeyword_id(),
					strongPointsModel.getState_id() };
			logger.info("Start StrongPointsStatetwise");
			strongPointStateDto = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.compare_strong_points_state_wise, param, StrongPointStateDto.class).get(0);
			logger.info("End StrongPointsStatetwise");
			return new ApiResponse<StrongPointStateDto>(true, "Total 1 Records",
					true, strongPointStateDto, 1);
		} catch (Exception ex) {
			return new ApiResponse<StrongPointStateDto>(false, ex.toString(), false, strongPointStateDto, 0);
		}
	}

	@Override
	public ApiResponse<SameBidResponseDto> getSameBid(SameBidModel sameBidModel) {

		SameBidResponseDto sameBidResponseDto = new SameBidResponseDto();
		try {
			Object param[] = { sameBidModel.getBidder1(), sameBidModel.getBidder2(), sameBidModel.getBidder3() };
			logger.info("Start SameBid");
			
			sameBidResponseDto = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.compare_same_bid, param,
					SameBidResponseDto.class).get(0);
			
			logger.info("End SameBid");
			return new ApiResponse<SameBidResponseDto>(true, "Total 1 Records",
					true, sameBidResponseDto, 1);
		} catch (Exception ex) {
			return new ApiResponse<SameBidResponseDto>(false, ex.toString(), false, sameBidResponseDto, 0);
		}
	}

	@Override
	public ApiResponse<List<SameBidComparisionStateWiseDto>> getCompareSameBidComparisionStateWise(
			SameBidComparisionStateWiseModel sameBidComparisionStateWiseModel) {

		List<SameBidComparisionStateWiseDto> sameBidComparisionStateWiseDto = null;
		try {

			Object param[] = { sameBidComparisionStateWiseModel.getFrom_date(),
					sameBidComparisionStateWiseModel.getTo_date(), sameBidComparisionStateWiseModel.getBidder1(),
					sameBidComparisionStateWiseModel.getBidder2(), sameBidComparisionStateWiseModel.getBidder3() };
			
			logger.info("Start CompareSameBidComparisionStateWise");
			sameBidComparisionStateWiseDto = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.compare_same_bid_comparision_state_wise, param, SameBidComparisionStateWiseDto.class);
			
			logger.info("End CompareSameBidComparisionStateWise");
			return new ApiResponse<List<SameBidComparisionStateWiseDto>>(true,
					"Total " + sameBidComparisionStateWiseDto.size() + " Records", true, sameBidComparisionStateWiseDto,
					sameBidComparisionStateWiseDto.size());
		} catch (Exception ex) {
			return new ApiResponse<List<SameBidComparisionStateWiseDto>>(false, ex.toString(), false,
					sameBidComparisionStateWiseDto, 0);
		}
	}

	@Override
	public ApiResponse<List<CompanyNameForComparisonDto>> getCompanyNameForComparison(
			CompanyNameModel companyNameModel) {
		List<CompanyNameForComparisonDto> companyNameDto = null;
		try {
			Object param[] = {companyNameModel.getCompany_name()};
			logger.info("Start CompanyNameForComparison");
			companyNameDto = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.compare_company_name, param, CompanyNameForComparisonDto.class);
			logger.info("End CompanyNameForComparison");
			return new ApiResponse<List<CompanyNameForComparisonDto>>(true,
					"Total " + companyNameDto.size() + " Records", true, companyNameDto, companyNameDto.size());
		} catch (Exception ex) {
			return new ApiResponse<List<CompanyNameForComparisonDto>>(false, ex.toString(), false, companyNameDto, 0);
		}
	}
}

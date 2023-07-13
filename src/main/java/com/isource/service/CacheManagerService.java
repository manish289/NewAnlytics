package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.authority.OrganizationDto;
import com.isource.dto.authority.OrganizationTypeDto;
import com.isource.dto.common.IndustryDto;
import com.isource.dto.common.KeywordDto;
import com.isource.dto.common.ProductDto;
import com.isource.dto.common.ResultStageDto;
import com.isource.dto.common.SubIndustryDto;
import com.isource.dto.companyprofile.CompanyProfileTenderingOwnershipDto;
import com.isource.dto.companyprofile.DepartmentDto;
import com.isource.dto.companyprofile.MonthWiseListChartDto;
import com.isource.dto.companyprofile.StatewiseDto;
import com.isource.dto.companyprofile.StatisticsDto;
import com.isource.dto.companyprofile.TenderStageDto;
import com.isource.dto.competitors.BiddertDetailDto;
import com.isource.dto.competitors.CompetitorsDto;
import com.isource.dto.competitors.ShortListChartMonthwiseDto;
import com.isource.dto.competitors.ShortListCompetitorsListDto;
import com.isource.dto.competitors.TopCompetitorListChartDto;
import com.isource.dto.dashboard.BidderTopCompetitorsDto;
import com.isource.dto.dashboard.BidderTopCompetitorsListChartDto;
import com.isource.dto.dashboard.DashboardStatisticsDto;
import com.isource.dto.dashboard.PublishTenderStateWiseDto;
import com.isource.dto.dashboard.TenderingOwnershipDto;
import com.isource.dto.location.CityDto;
import com.isource.dto.location.RegionDto;
import com.isource.dto.location.StateDto;
import com.isource.dto.result.BidderParticipatedResultDto;
import com.isource.dto.watchlist.WatchListDeleteDto;
import com.isource.dto.watchlist.WatchListDto;
import com.isource.model.companyprofile.CompanyProfileModel;
import com.isource.model.comparecompetitors.BidderResultModel;
import com.isource.model.competitors.BidderTopCompetitorsModel;
import com.isource.model.competitors.BidderTopCompitorsMonthWiseModel;
import com.isource.model.competitors.CompetitorsModel;
import com.isource.model.competitors.ShortListCompetitorsModel;
import com.isource.model.competitors.ShortListCompetitorsMonthWiseModel;
import com.isource.model.competitors.TopCompetitorsMonthWiseModel;
import com.isource.model.dashboard.BidderParticipatedResultModel;
import com.isource.model.dashboard.DashboardStatisticsModel;
import com.isource.model.dashboard.PublishTenderStateWiseModel;
import com.isource.model.dashboard.TenderingOwnershipModel;

@Service
@Lazy
public interface CacheManagerService {
	
	List<CityDto> getCity();
	List<RegionDto> getRegion();
	List<StateDto> getState();
	List<IndustryDto> getIndustry();
	List<IndustryDto> getIndustryUpdate();
	List<KeywordDto> getKeyword();	
	List<ProductDto> getProduct();
	List<SubIndustryDto> getSubIndustry();
	List<ResultStageDto> getResultStage();
	List<OrganizationDto> getOrganization();
	List<OrganizationTypeDto> getOrganizationType();
	List<WatchListDto> getWatchList();
	List<WatchListDeleteDto> getWatchListDelete();
	
	List<DashboardStatisticsDto> getDashboardStatistics(DashboardStatisticsModel dashboardStatisticsModel);
	
	List<BidderTopCompetitorsDto> getBidderTopCompetitorsList(BidderTopCompetitorsModel bidderTopCompetitorsModel);
	List<PublishTenderStateWiseDto> getPublishTenderStateWise(PublishTenderStateWiseModel publishTenderStateWiseModel);
	List<TenderingOwnershipDto> getTenderingOwnership(TenderingOwnershipModel tenderingOwnershipModel);
	List<BidderTopCompetitorsListChartDto > getBidderTopCompetitorsListMonthWise(BidderTopCompitorsMonthWiseModel bidderTopCompitorsMonthWise);
	List<ShortListChartMonthwiseDto> getShortListCompetitorsChartMonthwise(ShortListCompetitorsMonthWiseModel shortListCompetitorsMonthWiseModel);
	List<TopCompetitorListChartDto> getTopCompetitorListChart(TopCompetitorsMonthWiseModel topCompetitorsMonthWiseModel);
	List<StatewiseDto> getCompanyProfileStatewise(CompanyProfileModel companyProfileModel);
	List<CompanyProfileTenderingOwnershipDto> getCompanyProfileTenderingOwnership(CompanyProfileModel companyProfileModel);
	List<DepartmentDto> getCompanyProfileDepartment(CompanyProfileModel companyProfileModel);
	List<TenderStageDto> getCompanyProfileTenderStage(CompanyProfileModel companyProfileModel);
	List<MonthWiseListChartDto> getMonthWiseChart(CompanyProfileModel companyProfileModel);
	List<StatisticsDto> getCompanyProfileStatistics(CompanyProfileModel companyProfileModel);
	List<CompetitorsDto> getTopCompetitorList(CompetitorsModel competitorsModel);
	List<ShortListCompetitorsListDto> getShortListCompetitors(ShortListCompetitorsModel shortListCompetitorsModel);
	List<ShortListCompetitorsListDto> getShortListCompetitorsUpdate(
			ShortListCompetitorsModel shortListCompetitorsModel);
//	List<CompanyNameForComparisonDto> getCompanyNameForComparison(
//			CompanyNameModel companyNameModel);
	// this is manish practise method
	List<BiddertDetailDto> getDashBoardBidderDetails(BidderResultModel bidderresultmodel);
	List<CompanyProfileTenderingOwnershipDto> getAllCompanyProfile(CompanyProfileModel companyProfileModel);
	//manish Pracise Method
	List<BidderParticipatedResultDto> getTheAllParticipatedData(
			BidderParticipatedResultModel bidderparticipatedResultModel);
	
	List<ProductDto> getAllProductData();
	
}
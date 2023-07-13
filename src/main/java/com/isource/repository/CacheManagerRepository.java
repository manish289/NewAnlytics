package com.isource.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.connection.web.DbContextServiceWeb;
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
import com.isource.query.QueryMasters;
import com.isource.service.CacheManagerService;

@Repository
@Lazy
public class CacheManagerRepository implements CacheManagerService {

	private Logger logger = null;

	@Lazy
	private DbContextServiceWeb _DbContextserviceWeb;

	@Lazy
	public CacheManagerRepository(DbContextServiceWeb DbContextserviceWeb) {
		this._DbContextserviceWeb = DbContextserviceWeb;
		logger = Logger.getLogger(CacheManagerRepository.class);
	}

	// Location Service
	@Override
	@Cacheable("cache_city")
	public List<CityDto> getCity() {
		logger.info("From DataBase GetCity Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.city_getall, CityDto.class);
	}

	@Override
	@Cacheable("cache_getregion")
	public List<RegionDto> getRegion() {
		logger.info("From DataBase GetRegion Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.region_getall, RegionDto.class);
	}

	@Override
	@Cacheable("cache_state")
	public List<StateDto> getState() {
		logger.info("From DataBase GetState Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.state_getall, StateDto.class);
	}

	// Common Service
	@Override
	@Cacheable("cache_getIndustry")
	public List<IndustryDto> getIndustry() {
		logger.info("From DataBase GetIndustry Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.industry_getall, IndustryDto.class);
	}

	@CachePut("cache_getIndustry")
	public List<IndustryDto> getIndustryUpdate() {
		logger.info("From Update DataBase GetIndustry Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.industry_getall, IndustryDto.class);
	}

	@Override
	@Cacheable("cache_getKeyword")
	public List<KeywordDto> getKeyword() {
		logger.info("From DataBase GetKeyword Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.keyword_getall, KeywordDto.class);
	}

	@Override
	@Cacheable("cache_getProduct")
	public List<ProductDto> getProduct() {
		logger.info("From DataBase GetProduct Repository");
		
		return _DbContextserviceWeb.QueryToList(QueryMasters.product_getall, ProductDto.class);
	}

	@Override
	@Cacheable("cache_getSubIndustry")
	public List<SubIndustryDto> getSubIndustry() {
		logger.info("From DataBase GetSubIndustry Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.sub_industry_getall, SubIndustryDto.class);
	}

	@Override
	@Cacheable("cache_result_stage_getall")
	public List<ResultStageDto> getResultStage() {
		logger.info("From DataBase GetResultStage Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.result_stage_master_getall, ResultStageDto.class);
	}

	// WatchList Service
	@Override
	@Cacheable("watchlist_getall")
	public List<WatchListDto> getWatchList() {
		logger.info("From DataBase WatchList Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.watchlist_getall, WatchListDto.class);
	}

	@Override
	@Cacheable("watchlistDelete")
	public List<WatchListDeleteDto> getWatchListDelete() {
		logger.info("From DataBase WatchList Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.watch_list_delete, WatchListDeleteDto.class);
	}

	// Authority Service
	@Override
	@Cacheable("cache_getOrganization")
	public List<OrganizationDto> getOrganization() {
		logger.info("From DataBase GetOrganization Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.organization_getall, OrganizationDto.class);
	}

	@Override
	@Cacheable("cache_getOrganizationType")
	public List<OrganizationTypeDto> getOrganizationType() {
		logger.info("From DataBase GetOrganizationType Repository");
		return _DbContextserviceWeb.QueryToList(QueryMasters.organization_type_getall, OrganizationTypeDto.class);
	}

	@Override
	@Cacheable("cache_getDashboardStatistics")
	public List<DashboardStatisticsDto> getDashboardStatistics(DashboardStatisticsModel dashboardStatisticsModel) {
		logger.info("From DataBase DashboardStatistics Repository");
		
		Object param[] = { dashboardStatisticsModel.getFrom_date(), dashboardStatisticsModel.getTo_date(),
				dashboardStatisticsModel.getBidder_name() };
		
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.dashboard_statistics_getall, param,
				DashboardStatisticsDto.class);       // all the parameters are there in QueryToListParam method  like  query, paramArray, aand class RefType
	}

	@Override
	@Cacheable("cache_getBidderTopCompetitors")
	public List<BidderTopCompetitorsDto> getBidderTopCompetitorsList(BidderTopCompetitorsModel bidderTopCompetitors) {
		logger.info("From DataBase BidderTopCompetitors Repository");
		Object param[] = { bidderTopCompetitors.getFrom_date(), bidderTopCompetitors.getTo_date(),
				bidderTopCompetitors.getBidder_name() };
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.dashboard_bidder_top_competitors_list, param,
				BidderTopCompetitorsDto.class);
	}

	@Override
	@Cacheable("cache_getPublishTenderStateWise")
	public List<PublishTenderStateWiseDto> getPublishTenderStateWise(
			PublishTenderStateWiseModel publishTenderStateWiseModel) {
		logger.info("From DataBase PublishTenderStateWise Repository");
		Object param[] = { publishTenderStateWiseModel.getFrom_date(), publishTenderStateWiseModel.getTo_date(),
				publishTenderStateWiseModel.getBidder_name() };
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.dashboard_publish_tender_state_wise, param,
				PublishTenderStateWiseDto.class);
	}

	@Override
	@Cacheable("cache_getBidderTopCompetitorsMonthWise")  // just to use @Cacheable annotations we have taken this new Repository.
	public List<BidderTopCompetitorsListChartDto> getBidderTopCompetitorsListMonthWise(
			BidderTopCompitorsMonthWiseModel bidderTopCompitorsMonthWise) {
		
		logger.info("From DataBase BidderTopCompetitorsMonthWise Repository");
		Object param[] = { bidderTopCompitorsMonthWise.getFrom_date(), bidderTopCompitorsMonthWise.getTo_date(),
				bidderTopCompitorsMonthWise.getBidder_name() };
		
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.dashboard_bidder_top_competitors_monthwise_list,
				param, BidderTopCompetitorsListChartDto.class);
	}

	@Override
	@Cacheable("cache_getTenderingOwnership")
	public List<TenderingOwnershipDto> getTenderingOwnership(TenderingOwnershipModel tenderingOwnershipModel) {
		logger.info("From DataBase TenderingOwnership Repository");
		Object param[] = { tenderingOwnershipModel.getFrom_date(), tenderingOwnershipModel.getTo_date(),
				tenderingOwnershipModel.getBidder_name() };
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.dashboard_tendering_ownership, param,
				TenderingOwnershipDto.class);
	}

	@Override
	@Cacheable("cache_getShortListCompetitorsChartMonthwise")
	public List<ShortListChartMonthwiseDto> getShortListCompetitorsChartMonthwise(
			ShortListCompetitorsMonthWiseModel shortListCompetitorsMonthWiseModel) {
		logger.info("From DataBase getShortListCompetitorsChartMonthwise Repository");
		
		Object param[] = { shortListCompetitorsMonthWiseModel.getFrom_date(),
				shortListCompetitorsMonthWiseModel.getTo_date(), shortListCompetitorsMonthWiseModel.getBidderName() };
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.shorlist_competitors_list_monthwise, param,
				ShortListChartMonthwiseDto.class);

	}

	@Override
	@Cacheable("cache_getTopCompetitorListChart")
	public List<TopCompetitorListChartDto> getTopCompetitorListChart(
			TopCompetitorsMonthWiseModel topCompetitorsMonthWiseModel) {
		logger.info("From DataBase getTopCompetitorListChart Repository");
		Object param[] = { topCompetitorsMonthWiseModel.getFrom_date(), 
				topCompetitorsMonthWiseModel.getTo_date(),
				topCompetitorsMonthWiseModel.getBidder_name(), 
				topCompetitorsMonthWiseModel.getState_ids(),
				topCompetitorsMonthWiseModel.getKeyword_ids(),
				topCompetitorsMonthWiseModel.getOrganization_name(),
				topCompetitorsMonthWiseModel.getOrganization_type_name(),
				topCompetitorsMonthWiseModel.getParticipated_name() };
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.competitor_get_top_competitors_list_chart, param,
				TopCompetitorListChartDto.class);

	}

	@Override
	@Cacheable("cache_getCompanyProfileStatewise")
	public List<StatewiseDto> getCompanyProfileStatewise(CompanyProfileModel companyProfileModel) {
		logger.info("From Database getCompanyProfileStatewise Repository ");
		Object param[] = { companyProfileModel.getFrom_date(), companyProfileModel.getTo_date(),
				companyProfileModel.getBidder_name() };
		logger.info("From Database CompanyProfilePublishTenderStateWise ");
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.company_profile_tender_state_wise, param,
				StatewiseDto.class);

	}

	@Override
	@Cacheable("cache_getCompanyProfileTenderingOwnership")
	public List<CompanyProfileTenderingOwnershipDto> getCompanyProfileTenderingOwnership(
			CompanyProfileModel companyProfileModel) {
		logger.info("From Database getCompanyProfileTenderingOwnership Repository ");
		Object param[] = { companyProfileModel.getFrom_date(), companyProfileModel.getTo_date(),
				companyProfileModel.getBidder_name() };
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.company_profile_tendering_ownership, param,
				CompanyProfileTenderingOwnershipDto.class);

	}

	@Override
	@Cacheable("cache_getTopCompetitorListChart")
	public List<DepartmentDto> getCompanyProfileDepartment(CompanyProfileModel companyProfileModel) {
		logger.info("From Database getCompanyProfileDepartment Repository ");
		Object param[] = { companyProfileModel.getFrom_date(), companyProfileModel.getTo_date(),
				companyProfileModel.getBidder_name() };
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.company_profile_department, param,
				DepartmentDto.class);

	}

	@Override
	@Cacheable("cache_getCompanyProfileTenderStage")
	public List<TenderStageDto> getCompanyProfileTenderStage(CompanyProfileModel companyProfileModel) {
		logger.info("From Database getCompanyProfileTenderStage Repository ");
		Object param[] = { companyProfileModel.getFrom_date(), companyProfileModel.getTo_date(),
				companyProfileModel.getBidder_name() };
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.company_profile_tender_stages, param,
				TenderStageDto.class);

	}

	@Override
	@Cacheable("cache_getMonthWiseChart")
	public List<MonthWiseListChartDto> getMonthWiseChart(CompanyProfileModel companyProfileModel) {
		logger.info("From Database getMonthWiseChart Repository ");
		Object param[] = { companyProfileModel.getFrom_date(), companyProfileModel.getTo_date(),
				companyProfileModel.getBidder_name() };
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.company_profile_monthwise_tenders, param,
				MonthWiseListChartDto.class);

	}

	@Override
	@Cacheable("cache_getCompanyProfileStatistics")
	public List<StatisticsDto> getCompanyProfileStatistics(CompanyProfileModel companyProfileModel) {
		Object param[] = { companyProfileModel.getFrom_date(), companyProfileModel.getTo_date(),
				companyProfileModel.getBidder_name() };
		logger.info("From Database CompanyProfileStatistics Repository ");
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.company_profile_dashboard_statistics, param,
				StatisticsDto.class);
	}
	

	@Override
	@Cacheable("cache_competitor_getTopCompetitorList")
	public List<CompetitorsDto> getTopCompetitorList(CompetitorsModel competitorsModel) {
		Object param[] = { 
				competitorsModel.getFrom_date(), 
				competitorsModel.getTo_date(),
				competitorsModel.getBidder_name(), 
				competitorsModel.getState_ids(),
				competitorsModel.getKeyword_ids(),
				competitorsModel.getOrganization_name(),
				competitorsModel.getOrganization_type_name() };
		logger.info("From Database getTopCompetitorList Repository ");
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.competitor_get_top_competitors_list, param,
				CompetitorsDto.class);
	}

	@Override
	@Cacheable("cache_competitor_getShortListCompetitors")
	public List<ShortListCompetitorsListDto> getShortListCompetitors(ShortListCompetitorsModel shortListCompetitorsModel) {
		Object param[] = { shortListCompetitorsModel.getFrom_date(), shortListCompetitorsModel.getTo_date() };
		logger.info("From Database getTopCompetitorList Repository ");
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.shorlisted_competitors_list,param, 
				ShortListCompetitorsListDto.class);
	}

	@CachePut("cache_competitor_getShortListCompetitors")
	public List<ShortListCompetitorsListDto> getShortListCompetitorsUpdate(
			ShortListCompetitorsModel shortListCompetitorsModel) {
		Object param[] = { shortListCompetitorsModel.getFrom_date(), shortListCompetitorsModel.getTo_date() };
		logger.info("From Cache Update ShortList Competitors Update ");
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.shorlisted_competitors_list, param,
				ShortListCompetitorsListDto.class);

	}


	
	//this is manish practise method
	@Override
	@Cacheable("cache_BidderDetailsDto")
	public List<BiddertDetailDto> getDashBoardBidderDetails(BidderResultModel bidderresultmodel) {
		
		logger.info("strat to get the data from Dashboard Databases CacheRepo");
		
		Object param[]= {bidderresultmodel.getBidder_name(), bidderresultmodel.getFrom_date(), bidderresultmodel.getTo_date()};
		
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.bidder_getall, param, BiddertDetailDto.class);
		
	}

	
	//this is manish practise method
	@Override
	@Cacheable
	public List<CompanyProfileTenderingOwnershipDto> getAllCompanyProfile(CompanyProfileModel companyProfileModel) {
		
		logger.info("Strat to get Data in DataBases");
		
		Object param[]= {companyProfileModel.getBidder_name(), companyProfileModel.getFrom_date(), companyProfileModel.getTo_date()};
		
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.company_profile_tendering_ownership, param, CompanyProfileTenderingOwnershipDto.class);
	}

	//	//this is manish practise method
	@Override
	public List<BidderParticipatedResultDto> getTheAllParticipatedData(
			BidderParticipatedResultModel bidderparticipatedResultModel) {
		
	 Object param[]= {bidderparticipatedResultModel.getBidder_name(), bidderparticipatedResultModel.getFrom_date(), bidderparticipatedResultModel.getTo_date()};
	 	
		return _DbContextserviceWeb.QueryToListWithParam(QueryMasters.bidder_getall, param, BidderParticipatedResultDto.class);
	}

	
	
	
	
	// manish Practise Method
	@Override
	public List<ProductDto> getAllProductData() {
		
		logger.info("Start to get the Data from Db in CacheRepo");
		
		return (List<ProductDto>) _DbContextserviceWeb.QueryToList(QueryMasters.product_getall, ProductDto.class);
	}
	
	
	
	
//	@Override
//	@Cacheable("cache_compare_CompanyNameForComparison")
//	public List<CompanyNameForComparisonDto> getCompanyNameForComparison(CompanyNameModel companyNameModel) {
//		Object param[] = {companyNameModel.getCompany_name()};
//		logger.info("From database CompanyNameForComparison");
//		return _DbContextserviceWeb.QueryToListWithParam(
//				QueryMasters.compare_company_name, param, CompanyNameForComparisonDto.class);
//	}
}

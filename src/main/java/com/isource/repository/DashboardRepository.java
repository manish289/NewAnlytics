package com.isource.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.connection.web.DbContextServiceWeb;
import com.isource.dto.companyprofile.CompanyProfileTenderingOwnershipDto;
import com.isource.dto.competitors.BiddertDetailDto;
import com.isource.dto.competitors.TopCompetitorListChartDto;
import com.isource.dto.dashboard.AllCompetitorsDto;
import com.isource.dto.dashboard.BidderTopCompetitorsDto;
import com.isource.dto.dashboard.BidderTopCompetitorsListChartDto;
import com.isource.dto.dashboard.DashboardStatisticsDto;
import com.isource.dto.dashboard.PublishTenderStateWiseDto;
import com.isource.dto.dashboard.TenderingOwnershipDto;
import com.isource.dto.result.BidderParticipatedResultDto;
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
import com.isource.query.QueryMasters;
import com.isource.service.CacheManagerService;
import com.isource.service.DashboardService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class DashboardRepository implements DashboardService {

	private Logger logger = null;
	@Lazy
	private CacheManagerService cacheManagerService;
	@Lazy
	private DbContextServiceWeb _DbContextserviceWeb;

	@Lazy
	public DashboardRepository(CacheManagerService cacheManagerService, DbContextServiceWeb _DbContextserviceWeb) {

		logger = Logger.getLogger(DashboardRepository.class);
		this.cacheManagerService = cacheManagerService;
		this._DbContextserviceWeb = _DbContextserviceWeb;
	}  

	@Override
	public ApiResponse<List<DashboardStatisticsDto>> getDashboardStatistics(
			DashboardStatisticsModel dashboardStatisticsModel) {

		List<DashboardStatisticsDto> dashboardStatistics = null;
		try {
			logger.info("Start DashboardStatistics ");
			
			dashboardStatistics = cacheManagerService.getDashboardStatistics(dashboardStatisticsModel);
			;
			logger.info("End DashboardStatistics ");  //it will give alert message if there will be certain problem occur in UI side 
			
			return new ApiResponse<List<DashboardStatisticsDto>>(true,
					"Total " + dashboardStatistics.size() + " Records", true, dashboardStatistics,
					dashboardStatistics.size());
			
	//	return new ApiResponse<List<DashboardStatisticsDto>>(true, "Total"+ dashboardStatistics.size()+"Records", true, dashboardStatistics, dashboardStatistics.size());
			
		} catch (Exception ex) {
			logger.info("getOrganization Exception : " + ex.toString());
			return new ApiResponse<List<DashboardStatisticsDto>>(false, ex.toString(), false, dashboardStatistics, 0);
		}
	}

	@Override
	public ApiResponse<List<BidderTopCompetitorsDto>> getBidderTopCompetitorsList(
			BidderTopCompetitorsModel bidderTopCompetitorsModel) {

		List<BidderTopCompetitorsDto> bidderTopCompetitors = null;
		try {
			logger.info("Start BidderTopCompetitors ");
			
			bidderTopCompetitors = cacheManagerService.getBidderTopCompetitorsList(bidderTopCompetitorsModel);
			
			logger.info("End BidderTopCompetitors ");
			
			return new ApiResponse<List<BidderTopCompetitorsDto>>(true,
					"Total " + bidderTopCompetitors.size() + " Records", true, bidderTopCompetitors,
					bidderTopCompetitors.size());
			
		} catch (Exception ex) {
			logger.info("getOrganization Exception : " + ex.toString());
			return new ApiResponse<List<BidderTopCompetitorsDto>>(false, ex.toString(), true, bidderTopCompetitors, 0);
		}
	}

	@Override
	public ApiResponse<List<PublishTenderStateWiseDto>> getPublishTenderStateWise(
			PublishTenderStateWiseModel publishTenderStateWiseModel) {

		List<PublishTenderStateWiseDto> publishTenderStateWise = null;
		try {
			logger.info("Start PublishTenderStateWise ");
			
			publishTenderStateWise = cacheManagerService.getPublishTenderStateWise(publishTenderStateWiseModel);
			
			logger.info("End PublishTenderStateWise ");
			return new ApiResponse<List<PublishTenderStateWiseDto>>(true,
					"Total " + publishTenderStateWise.size() + " Records", true, publishTenderStateWise,
					publishTenderStateWise.size());
		} catch (Exception ex) {
			logger.info("getOrganization Exception : " + ex.toString());
			return new ApiResponse<List<PublishTenderStateWiseDto>>(false, ex.toString(), true, publishTenderStateWise,
					0);
		}
	}

	@Override
	public ApiResponse<List<BidderTopCompetitorsListChartDto >> getBidderTopCompetitorsListMonthWise(
			BidderTopCompitorsMonthWiseModel bidderTopCompitorsMonthWise) {

		List<BidderTopCompetitorsListChartDto > bidderTopCompetitors = null;
		try {
			logger.info("Start BidderTopCompetitors ");
			
			bidderTopCompetitors = cacheManagerService
					.getBidderTopCompetitorsListMonthWise(bidderTopCompitorsMonthWise);
			
			logger.info("End BidderTopCompetitors ");
			
			return new ApiResponse<List<BidderTopCompetitorsListChartDto >>(true,
					"Total " + bidderTopCompetitors.size() + " Records", true, bidderTopCompetitors,
					bidderTopCompetitors.size());
			
		} catch (Exception ex) {
			logger.info("getOrganization Exception : " + ex.toString());
			return new ApiResponse<List<BidderTopCompetitorsListChartDto >>(false, ex.toString(), true,
					bidderTopCompetitors, 0);
		}
	}

	@Override
	public ApiResponse<List<TenderingOwnershipDto>> getTenderingOwnership(
			TenderingOwnershipModel tenderingOwnershipModel) {

		List<TenderingOwnershipDto> tenderingOwnership = null;
		try {
			logger.info("Start tenderingOwnership");
			tenderingOwnership = cacheManagerService.getTenderingOwnership(tenderingOwnershipModel);
			logger.info("End tenderingOwnership ");
			return new ApiResponse<List<TenderingOwnershipDto>>(true, "Total " + tenderingOwnership.size() + " Records",
					true, tenderingOwnership, tenderingOwnership.size());
		} catch (Exception ex) {
			logger.info("getOrganization Exception : " + ex.toString());
			return new ApiResponse<List<TenderingOwnershipDto>>(false, ex.toString(), true, tenderingOwnership, 0);
		}
	}

	@Override
	public ApiResponse<List<AllCompetitorsDto>> getAllTopCompetitorsList(
			AllCompetitorsModel listOfTopCompetitorsListModel) {

		List<AllCompetitorsDto> allCompetitorsDto = null;
		try {
			logger.info("Start AllCompetitors ");
			Object param[] = { listOfTopCompetitorsListModel.getBidder_name() };
			allCompetitorsDto = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.dashboard_list_of_top_competitors_list, param, AllCompetitorsDto.class);
			logger.info("End AllCompetitors ");
			return new ApiResponse<List<AllCompetitorsDto>>(true, "Total " + allCompetitorsDto.size() + " Records",
					true, allCompetitorsDto, allCompetitorsDto.size());
		} catch (Exception ex) {
			logger.info("getAllTopCompetitorsList Exception : " + ex.toString());
			return new ApiResponse<List<AllCompetitorsDto>>(false, ex.toString(), true, allCompetitorsDto, 0);
		}
	}

	
	// this is manish practise method 
	@Override
	public ApiResponse<List<BiddertDetailDto>> postALLBidderDetailDto(BidderResultModel bidderresultmodel) {
		
		List<BiddertDetailDto> listofbidderDetailDto=null;	
		try {
		    logger.info("Strat Bidder All Details in DashRepo");
		    
		      listofbidderDetailDto = cacheManagerService.getDashBoardBidderDetails(bidderresultmodel);
		    
		    logger.info("End Bidder All Details In DashRepo");
		    
		 return new ApiResponse<List<BiddertDetailDto>>(true, "Total"+ listofbidderDetailDto.size()+ "Records", true, listofbidderDetailDto, listofbidderDetailDto.size());
		}
          catch (Exception e) {
        	  logger.info("Get AllBidder Details Exception"+ e);
        	  return new ApiResponse<List<BiddertDetailDto>>(false, e.toString(), true, listofbidderDetailDto, 0);
		}		
		
	}

	// this is manish practise method 
	@Override
	public ApiResponse<List<CompanyProfileTenderingOwnershipDto>> getAllCompanyProfileData(
			CompanyProfileModel companyProfileModel) {
	
		List<CompanyProfileTenderingOwnershipDto> listOfComapnyProfile= null;
		
		try {
			logger.info("Strat to get data in DashRepo");
			
			listOfComapnyProfile= cacheManagerService.getAllCompanyProfile(companyProfileModel);
			
			logger.info("End To Get data in DashRepo");
			
			return new ApiResponse<List<CompanyProfileTenderingOwnershipDto>>(true, "Total"+ listOfComapnyProfile.size()+ "Records", true, listOfComapnyProfile, listOfComapnyProfile.size());
		
		}
		catch (Exception e) {
			return new ApiResponse<List<CompanyProfileTenderingOwnershipDto>>(false, e.toString(),true, listOfComapnyProfile,0);
		}
		
	}


	//This is practise Method
		@Override
		public ApiResponse<List<BidderParticipatedResultDto>> getAllParticipatedData(
				BidderParticipatedResultModel bidderparticipatedResultModel) {
			
			List<BidderParticipatedResultDto> bidderdata=null;
			
			try {
			
			logger.info("Start to get ParticipatedAllData into DashRepo ");
			
			List<BidderParticipatedResultDto> bidderdata1= cacheManagerService.getTheAllParticipatedData(bidderparticipatedResultModel);
			
			logger.info("Data End to get ParticipatedAllData from DashRepo ");
			
			return new ApiResponse<List<BidderParticipatedResultDto>>(true, "Total"+ bidderdata1.size()+ "Records", true, bidderdata1, bidderdata1.size());
			
			}
			catch (Exception e) {
				
				return new ApiResponse<List<BidderParticipatedResultDto>>(false, e.toString(), true, bidderdata, 0);
			
			}
		
		}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	

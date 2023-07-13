package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface DashboardService {

	ApiResponse<List<DashboardStatisticsDto>> getDashboardStatistics(DashboardStatisticsModel dashboardStatistics);
	ApiResponse<List<BidderTopCompetitorsDto>> getBidderTopCompetitorsList(BidderTopCompetitorsModel bidderTopCompetitorsModel);
	ApiResponse<List<PublishTenderStateWiseDto>> getPublishTenderStateWise(PublishTenderStateWiseModel publishTenderStateWiseModel);
	ApiResponse<List<TenderingOwnershipDto>> getTenderingOwnership(TenderingOwnershipModel tenderingOwnershipModel);
	ApiResponse<List<BidderTopCompetitorsListChartDto >> getBidderTopCompetitorsListMonthWise(BidderTopCompitorsMonthWiseModel bidderTopCompitorsMonthWise);
	ApiResponse<List<AllCompetitorsDto>> getAllTopCompetitorsList(AllCompetitorsModel listOfTopCompetitorsListModel);

	//manish Practise method
	ApiResponse<List<BiddertDetailDto>> postALLBidderDetailDto(BidderResultModel bidderresultmodel);
	ApiResponse<List<CompanyProfileTenderingOwnershipDto>> getAllCompanyProfileData(
			CompanyProfileModel companyProfileModel);
	//manish practise Method
	ApiResponse<List<BidderParticipatedResultDto>> getAllParticipatedData(
			BidderParticipatedResultModel bidderparticipatedResultModel);
	
	
	

}

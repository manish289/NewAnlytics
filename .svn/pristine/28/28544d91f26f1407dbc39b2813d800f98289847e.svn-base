package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.competitors.CompetitorsDto;
import com.isource.dto.competitors.ShortListChartMonthwiseDto;
import com.isource.dto.competitors.ShortListCompetitorsListDto;
import com.isource.dto.competitors.TopCompetitorListChartDto;
import com.isource.model.competitors.CompetitorsModel;
import com.isource.model.competitors.ShortListCompetitorsModel;
import com.isource.model.competitors.ShortListCompetitorsMonthWiseModel;
import com.isource.model.competitors.TopCompetitorsMonthWiseModel;
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface CompetitorService {

	ApiResponse<List<CompetitorsDto>> getGeneralCompetitorList(CompetitorsModel competitorsModel);
	ApiResponse<List<CompetitorsDto>> getTopCompetitorList(CompetitorsModel competitorsModel);
	ApiResponse<List<TopCompetitorListChartDto>> getTopCompetitorListChart(TopCompetitorsMonthWiseModel topCompetitorsMonthWiseModel);
	ApiResponse<List<ShortListCompetitorsListDto>> getShortListCompetitors(ShortListCompetitorsModel shortListCompetitorsModel);
	ApiResponse<List<ShortListChartMonthwiseDto>> getShortListCompetitorsChartMonthwise(ShortListCompetitorsMonthWiseModel shortListCompetitorsMonthWiseModel);
	ApiResponse<List<ShortListCompetitorsListDto>> getShortListCompetitorsUpdate(
			ShortListCompetitorsModel shortListCompetitorsModel);
	
	
}
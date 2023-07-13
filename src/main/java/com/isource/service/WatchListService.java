package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.watchlist.WatchListDto;
import com.isource.model.watchlist.WatchListDeleteModel;
import com.isource.model.watchlist.WatchListInsertModel;
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface WatchListService {

	ApiResponse<List<WatchListDto>> getAllWatchList();
	ApiResponse<Integer> getWatchListDelete(WatchListDeleteModel watchListDelete);
	ApiResponse<Integer> getWatchListInsert(WatchListInsertModel watchListInsert);

}

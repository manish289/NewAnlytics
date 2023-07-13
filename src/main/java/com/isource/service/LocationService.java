package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.location.CityDto;
import com.isource.dto.location.RegionDto;
import com.isource.dto.location.StateDto;
import com.isource.model.location.LocationFilterModel;
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface LocationService {

	ApiResponse<List<CityDto>> getAllCity(LocationFilterModel locationFilter);
	ApiResponse<List<StateDto>> getAllState(LocationFilterModel locationFilter);
	ApiResponse<List<RegionDto>> getAllRegion();
}
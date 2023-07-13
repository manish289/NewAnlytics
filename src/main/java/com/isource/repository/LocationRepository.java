package com.isource.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.dto.location.CityDto;
import com.isource.dto.location.RegionDto;
import com.isource.dto.location.StateDto;
import com.isource.model.location.LocationFilterModel;
import com.isource.service.CacheManagerService;
import com.isource.service.LocationService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class LocationRepository implements LocationService {

	private Logger logger = null;
	@Lazy
	private CacheManagerService cacheManagerService;
	@Lazy
	public LocationRepository(CacheManagerService cacheManagerService) {
		this.cacheManagerService = cacheManagerService;
		logger = Logger.getLogger(LocationRepository.class);
	}

	public ApiResponse<List<CityDto>> getAllCity(LocationFilterModel locationFilter) {
		logger.info("Start City ");
		// Cache Filter Logic
		List<CityDto> cities = cacheManagerService.getCity();
		List<CityDto> cityDto = new ArrayList<CityDto>();
		try {
			if (locationFilter.getParentids() != "" && locationFilter.getParentids() != null) {
				for (String i : locationFilter.getParentids().split(",")) {
					cityDto.addAll(cities.stream().filter(city -> city.getState_id().equalsIgnoreCase(i))
							.collect(Collectors.toList()));
				}
				cities = cityDto;
			}
			if (locationFilter.getId() > 0) {
				cities = cities.stream().filter(city -> city.getCity_id() == locationFilter.getId()).toList();
			}
			if (locationFilter.getName() != "" && locationFilter.getName() != null) {
				cities = cities.stream().filter(
						city -> city.getCity_name().toLowerCase().startsWith(locationFilter.getName().toLowerCase()))
						.toList();
			}
			if (locationFilter.getNoofrecords() > 0) {
				cities = cities.stream().sorted(Comparator.comparing(CityDto::getCity_name))
						.skip((locationFilter.getPageNo() - 1) * locationFilter.getNoofrecords())
						.limit(locationFilter.getNoofrecords()).toList();
			} else {
				cities = cities.stream().sorted(Comparator.comparing(CityDto::getCity_name)).toList();
			}
			logger.info("End City ");
			return new ApiResponse<List<CityDto>>(true, "Total " + cities.size() + " Records", true, cities,
					cities.size());
		} catch (Exception ex) {
			logger.info("getCity Exception : " + ex.toString());
			return new ApiResponse<List<CityDto>>(true, ex.toString(), true, cities, 0);
		}
	}

	public ApiResponse<List<StateDto>> getAllState(LocationFilterModel locationFilter) {
		logger.info("Start State ");
		// Cache Filter Logic
		List<StateDto> states = cacheManagerService.getState();
		List<StateDto> stateDto = new ArrayList<StateDto>();
		try {
			//this code filters the states list based on the country_id matching the parent IDs obtained from locationFilter.getParentids(). 
		    //The filtered states are then stored in the states list.
			if (locationFilter.getParentids() != "" && locationFilter.getParentids() != null) {
				for (String i : locationFilter.getParentids().split(",")) {       //it will check parentId and  CountryId Is same or not
					stateDto.addAll(states.stream().filter(state -> state.getCountry_id().equalsIgnoreCase(i))
							.collect(Collectors.toList()));
				}
				states = stateDto;
			}
			   
			//is used to determine which elements should be included in the filtered result.
			if (locationFilter.getId() > 0) {
				states = states.stream().filter(state -> state.getState_id() == locationFilter.getId()).toList();
			}
			
			//After the filtering operation, the states list will contain only the states whose names start
			// with the same characters as the name of the location filter, regardless of the case.
			if (locationFilter.getName() != "" && locationFilter.getName() != null) {
				states = states.stream().filter(
						state -> state.getState_name().toLowerCase().startsWith(locationFilter.getName().toLowerCase()))
						.toList();
			}
			
		//it skips the appropriate number of elements based on the page number and the number of records per page,
		// and then limits the result to the specified number of records per page
			if (locationFilter.getNoofrecords() > 0) {
				states = states.stream().sorted(Comparator.comparing(StateDto::getState_name))
						.skip((locationFilter.getPageNo() - 1) * locationFilter.getNoofrecords())
						.limit(locationFilter.getNoofrecords()).toList();
			} else {
				states = states.stream().sorted(Comparator.comparing(StateDto::getState_name)).toList();
			}
			
			logger.info("End State ");
			return new ApiResponse<List<StateDto>>(true, "Total " + states.size() + " Records", true, states,
					states.size());
		} catch (Exception ex) {
			logger.info("getState Exception : " + ex.toString());
			return new ApiResponse<List<StateDto>>(true, ex.toString(), true, states, 0);
		}
	}

	public ApiResponse<List<RegionDto>> getAllRegion() {
		List<RegionDto> region = null;
		try {
			logger.info("Start Region ");
			region = cacheManagerService.getRegion();
			logger.info("End Region ");
			return new ApiResponse<List<RegionDto>>(true, "Total " + region.size() + " Records", true, region,
					region.size());
		} catch (Exception ex) {
			logger.info("getRegion Exception : " + ex.toString());
			return new ApiResponse<List<RegionDto>>(true, ex.toString(), true, region, 0);
		}
	}
}
package com.isource.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.dto.authority.OrganizationDto;
import com.isource.dto.authority.OrganizationTypeDto;
import com.isource.model.authority.AuthorityFilterModel;
import com.isource.service.AuthorityService;
import com.isource.service.CacheManagerService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class AuthorityRepository implements AuthorityService {

	private Logger logger = null;
	@Lazy
	private CacheManagerService cacheManagerService;

	@Lazy
	public AuthorityRepository(CacheManagerService cacheManagerService) {
		this.cacheManagerService = cacheManagerService;
		logger = Logger.getLogger(AuthorityRepository.class);
	}

	public ApiResponse<List<OrganizationDto>> getOrganization(AuthorityFilterModel authorityFilter) {
		logger.info(" Start Organization ");
		// Cache Filter Logic
		List<OrganizationDto> org = cacheManagerService.getOrganization();
		List<OrganizationDto> orgDto = new ArrayList<OrganizationDto>();
		try {
			if (authorityFilter.getParentids() != "" && authorityFilter.getParentids() != null) {
				for (String i : authorityFilter.getParentids().split(",")) {
					orgDto.addAll(org.stream().filter(orges -> orges.getOrganization_type_id().equalsIgnoreCase(i))
							.collect(Collectors.toList()));
				}
				org = orgDto;
			}
			if (authorityFilter.getId() > 0) {
				org = org.stream().filter(orges -> orges.getOrganization_id() == authorityFilter.getId()).toList();
			}
			if (authorityFilter.getName() != "" && authorityFilter.getName() != null) {

				org = org.stream().filter(orges -> orges.getOrganization_name().toLowerCase()
						.startsWith(authorityFilter.getName().toLowerCase())).toList();
			}
			org = org.stream().sorted(Comparator.comparing(OrganizationDto::getOrganization_name))
					.skip((authorityFilter.getPageNo() - 1) * authorityFilter.getNoOfRecords())
					.limit(authorityFilter.getNoOfRecords()).toList();
			logger.info("End Organization ");
			return new ApiResponse<List<OrganizationDto>>(true, "Total " + org.size() + " Records", true, org,
					org.size());
		} catch (Exception ex) {
			logger.info("getOrganization Exception : " + ex.toString());
			return new ApiResponse<List<OrganizationDto>>(false, ex.toString(), true, org, 0);
		}
	}

	public ApiResponse<List<OrganizationTypeDto>> getOrganizationType() {
		List<OrganizationTypeDto> orgType = null;
		try {
			logger.info("Start OrganizationType ");
			orgType = cacheManagerService.getOrganizationType();
			logger.info("End OrganizationType ");
			return new ApiResponse<List<OrganizationTypeDto>>(true, "Total " + orgType.size() + " Records", true,
					orgType, orgType.size());
		} catch (Exception ex) {
			logger.info("getOrganizationType Exception : " + ex.toString());
			return new ApiResponse<List<OrganizationTypeDto>>(false, ex.toString(), true, orgType, 0);
		}
	}
}



















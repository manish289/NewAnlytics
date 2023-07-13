package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.authority.OrganizationDto;
import com.isource.dto.authority.OrganizationTypeDto;
import com.isource.model.authority.AuthorityFilterModel;
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface AuthorityService {
	
	ApiResponse<List<OrganizationDto>> getOrganization(AuthorityFilterModel authorityFilter);
	ApiResponse<List<OrganizationTypeDto>> getOrganizationType();
}

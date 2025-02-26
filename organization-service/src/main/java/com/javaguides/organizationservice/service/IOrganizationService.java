package com.javaguides.organizationservice.service;

import com.javaguides.organizationservice.dto.OrganizationDto;

public interface IOrganizationService {

    OrganizationDto createOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByOrganizationCode(String organizationCode);
}

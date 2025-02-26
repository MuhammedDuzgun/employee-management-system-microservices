package com.javaguides.organizationservice.mapper;

import com.javaguides.organizationservice.dto.OrganizationDto;
import com.javaguides.organizationservice.entity.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {

    public Organization mapToOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization();
        organization.setId(organizationDto.getId());
        organization.setOrganizationName(organizationDto.getOrganizationName());
        organization.setOrganizationDescription(organizationDto.getOrganizationDescription());
        organization.setOrganizationCode(organizationDto.getOrganizationCode());
        organization.setCreationTime(organizationDto.getCreationTime());
        return organization;
    }

    public OrganizationDto mapToOrganizationDto(Organization organization) {
        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setId(organization.getId());
        organizationDto.setOrganizationName(organization.getOrganizationName());
        organizationDto.setOrganizationDescription(organization.getOrganizationDescription());
        organizationDto.setOrganizationCode(organization.getOrganizationCode());
        organizationDto.setCreationTime(organization.getCreationTime());
        return organizationDto;
    }

}

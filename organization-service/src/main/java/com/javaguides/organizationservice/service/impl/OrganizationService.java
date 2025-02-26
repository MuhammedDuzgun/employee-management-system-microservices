package com.javaguides.organizationservice.service.impl;

import com.javaguides.organizationservice.dto.OrganizationDto;
import com.javaguides.organizationservice.entity.Organization;
import com.javaguides.organizationservice.mapper.OrganizationMapper;
import com.javaguides.organizationservice.repository.IOrganizationRepository;
import com.javaguides.organizationservice.service.IOrganizationService;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService implements IOrganizationService {

    private final IOrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public OrganizationService(IOrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organizationToCreate = organizationMapper.mapToOrganization(organizationDto);
        Organization createdOrganization = organizationRepository.save(organizationToCreate);
        return organizationMapper.mapToOrganizationDto(createdOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByOrganizationCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return organizationMapper.mapToOrganizationDto(organization);
    }

}

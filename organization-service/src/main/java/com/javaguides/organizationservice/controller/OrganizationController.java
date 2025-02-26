package com.javaguides.organizationservice.controller;

import com.javaguides.organizationservice.dto.OrganizationDto;
import com.javaguides.organizationservice.service.IOrganizationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final IOrganizationService organizationService;

    public OrganizationController(IOrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/create-organization")
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto createdOrganizationDto = organizationService.createOrganization(organizationDto);
        return ResponseEntity.ok(createdOrganizationDto);
    }

    @GetMapping("/{organization-code}")
    public ResponseEntity<OrganizationDto> getOrganizationByOrganizationCode(
            @PathVariable("organization-code") String organizationCode) {
        OrganizationDto organizationDto = organizationService.getOrganizationByOrganizationCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }

}

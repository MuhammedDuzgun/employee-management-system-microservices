package com.javaguides.organizationservice.repository;

import com.javaguides.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}

package com.javaguides.organizationservice.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)

    private String organizationName;

    private String organizationDescription;

    @Column(nullable = false, unique = true)
    private String organizationCode;

    @CreationTimestamp
    private LocalDateTime creationTime;

    public Organization() {
    }

    public Organization(Long id, String organizationName, String organizationDescription, String organizationCode, LocalDateTime creationTime) {
        this.id = id;
        this.organizationName = organizationName;
        this.organizationDescription = organizationDescription;
        this.organizationCode = organizationCode;
        this.creationTime = creationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", organizationName='" + organizationName + '\'' +
                ", organizationDescription='" + organizationDescription + '\'' +
                ", organizationCode='" + organizationCode + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}

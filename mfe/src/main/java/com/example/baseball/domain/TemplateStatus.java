package com.example.baseball.domain;

import com.example.baseball.enumeration.EnvironmentEnum;
import com.example.baseball.enumeration.MfeStatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TemplateStatus {

    @Id
    @Column(name = "ID_TEMPALTE_STATUS")
    private Long id;

    @Column(name = "MFE_STATUS")
    @Enumerated(EnumType.STRING)
    private MfeStatusEnum mfeStatus;

    @Column(name = "ENVIROMENT")
    @Enumerated(EnumType.STRING)
    private EnvironmentEnum environment;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "CREATED_BY")
    private
    String createdBy;

    @Column(name = "UPDATED_BY")
    private
    String updatedBy;

    @OneToOne
    @JoinColumn(name = "ID_TEMPLATE", referencedColumnName = "ID_TEMPLATE")
    private Template idTemplate;

    @PrePersist
    private void initialize() {
        if (this.getId() == null) {
            this.setCreatedAt(LocalDateTime.now());
        } else {
            this.setUpdatedAt(LocalDateTime.now());
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MfeStatusEnum getMfeStatus() {
        return mfeStatus;
    }

    public void setMfeStatus(MfeStatusEnum mfeStatus) {
        this.mfeStatus = mfeStatus;
    }

    public EnvironmentEnum getEnvironment() {
        return environment;
    }

    public void setEnvironment(EnvironmentEnum environment) {
        this.environment = environment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Template getIdTemplate() {
        return idTemplate;
    }

    public void setIdTemplate(Template idTemplate) {
        this.idTemplate = idTemplate;
    }
}

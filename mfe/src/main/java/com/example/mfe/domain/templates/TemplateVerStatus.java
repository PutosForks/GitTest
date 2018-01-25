package com.example.mfe.domain.templates;

import com.example.mfe.enumeration.EnvironmentEnum;
import com.example.mfe.enumeration.MfeStatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CON_TEMPLATE_VER_STATUS", schema = "HIBERNATE", catalog = "")
@IdClass(TemplateVerStatusPK.class)

public class TemplateVerStatus {
    @Id
    @Column(name = "ID", nullable = false, updatable = false, precision = 0)
    private Long id;

    @Id
    @Column(name = "ENVIROMENT", nullable = false, length = 15)
    private EnvironmentEnum enviroment;


    @Id
    @Column(name = "STATUS", nullable = true)
    @Enumerated(EnumType.STRING)
    private MfeStatusEnum status;

    @Basic
    @Column(name = "CREATED_AT", nullable = true)
    private LocalDateTime createdAt;


    @Basic
    @Column(name = "CREATED_BY", nullable = true, length = 10)
    private String createdBy;

    @Basic
    @Column(name = "UPDATED_AT", nullable = true)
    private LocalDateTime updatedAt;

    @Basic
    @Column(name = "UPDATED_BY", nullable = true, length = 10)
    private String updatedBy;


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

    public EnvironmentEnum getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(EnvironmentEnum enviroment) {
        this.enviroment = enviroment;
    }


    public MfeStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MfeStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateVerStatus that = (TemplateVerStatus) o;
        return id == that.id &&
                Objects.equals(enviroment, that.enviroment) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, enviroment, status, createdAt, createdBy, updatedAt, updatedBy);
    }
}

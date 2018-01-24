package com.example.mfe.domain.templates;

import com.example.mfe.enumeration.EnvironmentEnum;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CON_TEMPLATE_VER_STATUS", schema = "HIBERNATE", catalog = "")
@IdClass(ConTemplateVerStatusPK.class)

public class ConTemplateVerStatus {
    @Id
    @Column(name = "ID_TEMPLATE_VER", nullable = false, precision = 0)
    private long idTemplateVer;

    @Id
    @Column(name = "ENVIROMENT", nullable = false, length = 15)
    private String enviroment;

    @Id
    @Column(name = "STATUS", nullable = false, length = 15)
    private String status;

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


    public long getIdTemplateVer() {
        return idTemplateVer;
    }

    public void setIdTemplateVer(long idTemplateVer) {
        this.idTemplateVer = idTemplateVer;
    }

    public EnvironmentEnum getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public Time getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Time updatedAt) {
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
        ConTemplateVerStatus that = (ConTemplateVerStatus) o;
        return idTemplateVer == that.idTemplateVer &&
                Objects.equals(enviroment, that.enviroment) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTemplateVer, enviroment, status, createdAt, createdBy, updatedAt, updatedBy);
    }
}

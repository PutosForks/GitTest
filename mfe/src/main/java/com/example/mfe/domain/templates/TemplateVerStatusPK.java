package com.example.mfe.domain.templates;

import com.example.mfe.enumeration.EnvironmentEnum;
import com.example.mfe.enumeration.MfeStatusEnum;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TemplateVerStatusPK implements Serializable {
    private long idTemplateVer;
    private EnvironmentEnum enviroment;
    private MfeStatusEnum status;

    @Column(name = "ID_TEMPLATE_VER", nullable = false, precision = 0)
    @Id
    public long getIdTemplateVer() {
        return idTemplateVer;
    }

    public void setIdTemplateVer(long idTemplateVer) {
        this.idTemplateVer = idTemplateVer;
    }

    @Column(name = "ENVIROMENT", nullable = false, length = 15)
    @Id
    public EnvironmentEnum getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(EnvironmentEnum enviroment) {
        this.enviroment = enviroment;
    }

    @Column(name = "STATUS", nullable = false, length = 15)
    @Id
    public MfeStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MfeStatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateVerStatusPK that = (TemplateVerStatusPK) o;
        return idTemplateVer == that.idTemplateVer &&
                Objects.equals(enviroment, that.enviroment) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTemplateVer, enviroment, status);
    }
}

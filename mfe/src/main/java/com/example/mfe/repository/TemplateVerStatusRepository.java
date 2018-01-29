package com.example.mfe.repository;

import com.example.mfe.domain.templates.TemplateVerStatus;
import com.example.mfe.pojo.template.templateVerStatusList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TemplateVerStatusRepository extends JpaRepository <TemplateVerStatus, Long> {

    @Query("SELECT  new com.example.mfe.pojo.template.templateVerStatusList(tv.idTemplateVer, s1.status, s2.status, s3.status) " +
            "FROM TemplateVer tv " +
            "LEFT JOIN tv.templateVerStatus s1 ON s1.enviroment = 'MFE'" +
            "LEFT JOIN tv.templateVerStatus s2 ON s2.enviroment = 'TST'" +
            "LEFT JOIN tv.templateVerStatus s3 ON s3.enviroment = 'LIVE'" +
            "WHERE tv.idTemplate = :idTemplate"
    )
    List<templateVerStatusList> getTemplateVerStatusList(@Param("idTemplate")  Long idTemplate);

}

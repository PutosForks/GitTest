package com.example.mfe.domain.templates;

import com.example.mfe.enumeration.EnvironmentEnum;
import com.example.mfe.enumeration.MfeStatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@Table(name = "CON_TEMPLATE_VER_STATUS", schema = "HIBERNATE", catalog = "")
@IdClass(TemplateVerStatusPK.class)

public class TemplateVerStatus {
    @Id
    @Column(nullable = false, updatable = false, precision = 0)
    private Long id;

    @Id
    @Column(nullable = false, length = 15)
    private EnvironmentEnum enviroment;


    @Id
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private MfeStatusEnum status;

    @Column(nullable = true)
    private LocalDateTime createdAt;



    @Column(nullable = true, length = 10)
    private String createdBy;


    @Column(nullable = true)
    private LocalDateTime updatedAt;


    @Column(nullable = true, length = 10)
    private String updatedBy;


    @PrePersist
    private void initialize() {
        if (this.getId() == null) {
            this.setCreatedAt(LocalDateTime.now());
        } else {
            this.setUpdatedAt(LocalDateTime.now());
        }
    }



}

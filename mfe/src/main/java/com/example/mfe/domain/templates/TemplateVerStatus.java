package com.example.mfe.domain.templates;

import com.example.mfe.enumeration.EnvironmentEnum;
import com.example.mfe.enumeration.MfeStatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@Table(name = "CON_TEMPLATE_VER_STATUS",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID", "ENVIROMENT", "STATUS"})}
)

public class TemplateVerStatus {
    @Id
    @Column(name = "ID", nullable = false, updatable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ENVIROMENT")
    @Enumerated(EnumType.STRING)
    private EnvironmentEnum enviroment;

    @Column(name = "STATUS")
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

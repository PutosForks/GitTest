package com.example.mfe.domain.templates;

import com.example.mfe.enumeration.EnvironmentEnum;
import com.example.mfe.enumeration.MfeStatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "CON_TEMPLATE_STATUS")
public class TemplateStatus {

    @Id
    @Column(name = "ID_TEMPALTE_STATUS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private MfeStatusEnum mfeStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private EnvironmentEnum environment;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private String createdBy;

    @Column
    private String updatedBy;

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

}

package com.example.mfe.domain.templates;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "CON_TEMPLATE",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"SHORT_NAME"})}
)
public class Template {

    @Id
    @Column(name = "ID_TEMPLATE", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Size(max = 250, min = 1)
    @NotNull
    private String name;

    @Size(max = 250, min = 1)
    @Column(name = "SHORT_NAME", nullable = false)
    private String shortName;

    @Column(nullable = false)
    @Size(max = 2000, min = 1)
    private String description;

    @NotNull
    private boolean defaultTemplate;

    @NotNull
    private boolean valid;

    @OneToOne(mappedBy = "idTemplate")
    private TemplateStatus templateStatus;

    @OneToOne
    @JoinColumn(name = "ID_CURRENT_VER", referencedColumnName = "ID_TEMPLATE_VER")
    private TemplateVer idCurrentVer;

}

package com.example.baseball.domain;


import com.example.baseball.enumeration.EnvironmentEnum;
import com.example.baseball.enumeration.MfeStatusEnum;
import org.omg.CORBA.Environment;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Template {

    @Id
    @Column(name = "ID_TEMPLATE", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 250, min = 1)
    @NotNull
    private String name;

    @Column(name = "SHORT_NAME")
    @Size(max = 250, min = 1)
    @NotNull
    private String shortName;

    @Column
    @Size(max = 2000, min = 1)
    @NotNull
    private String description;

    @Column(name = "DEFAULT_TEMPLATE", unique = false)
    private String defaultTemplate;

    @Column
    // @Size(max = 1)
    private Integer valid;

    @OneToOne(mappedBy = "idTemplate")
    private TemplateStatus templateStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefaultTemplate() {
        return defaultTemplate;
    }

    public void setDefaultTemplate(String defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public TemplateStatus getTemplateStatus() {
        return templateStatus;
    }

    public void setTemplateStatus(TemplateStatus templateStatus) {
        this.templateStatus = templateStatus;
    }
}

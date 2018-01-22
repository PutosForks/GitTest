package com.example.mfe.domain.templates;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CON_TEMPLATE", schema = "HIBERNATE",
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
    @NotNull
    @Column(name = "SHORT_NAME")
    private String shortName;

    @Column
    @Size(max = 2000, min = 1)
    @NotNull
    private String description;

    @NotNull
    private boolean defaultTemplate;

    @NotNull
    private boolean valid;

    @OneToOne(mappedBy = "idTemplate")
    private TemplateStatus templateStatus;
//
//    @OneToOne
//    @JoinColumn(name = "ID_CURRENT_VER", referencedColumnName = "ID_TEMPLATE_VER")
//    private TemplateVer idCurrentVer;


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

    public boolean getDefaultTemplate() {
        return defaultTemplate;
    }

    public void setDefaultTemplate(boolean defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }

    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public TemplateStatus getTemplateStatus() {
        return templateStatus;
    }

    public void setTemplateStatus(TemplateStatus templateStatus) {
        this.templateStatus = templateStatus;
    }
//
//    public TemplateVer getIdCurrentVer() {
//        return idCurrentVer;
//    }
//
//    public void setIdCurrentVer(TemplateVer idCurrentVer) {
//        this.idCurrentVer = idCurrentVer;
//    }
}

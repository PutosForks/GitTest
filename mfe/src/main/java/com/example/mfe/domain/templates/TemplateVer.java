package com.example.mfe.domain.templates;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CON_TEMPLATE_VER", schema = "HIBERNATE", catalog = "")
public class TemplateVer {

    @Id
    @Column(name = "ID_TEMPLATE_VER", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idTemplateVer;

    @Column(name = "ID_TEMPLATE", nullable = false, precision = 0)
    private long idTemplate;

    @OneToOne(mappedBy = "idCurrentVer")
    Template template;

    @OneToMany
    @JoinColumn(name = "ID_TEMPLATE_VER", referencedColumnName = "ID_TEMPLATE_VER")
    List<TemplateVerStatus> templateVerStatus;


    public long getIdTemplate() {
        return idTemplate;
    }

    public void setIdTemplate(long idTemplate) {
        this.idTemplate = idTemplate;
    }

    public long getIdTemplateVer() {
        return idTemplateVer;
    }

    public void setIdTemplateVer(long idTemplateVer) {
        this.idTemplateVer = idTemplateVer;
    }


    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public List<TemplateVerStatus> getTemplateVerStatus() {
        return templateVerStatus;
    }

    public void setTemplateVerStatus(List<TemplateVerStatus> templateVerStatus) {
        this.templateVerStatus = templateVerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateVer that = (TemplateVer) o;
        return idTemplateVer == that.idTemplateVer &&
                idTemplate == that.idTemplate;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTemplateVer, idTemplate);
    }
}

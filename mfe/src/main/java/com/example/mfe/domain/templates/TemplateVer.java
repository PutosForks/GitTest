package com.example.mfe.domain.templates;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "CON_TEMPLATE_VER")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateVer that = (TemplateVer) o;
        return idTemplateVer == that.idTemplateVer &&
                idTemplate == that.idTemplate;
    }


}

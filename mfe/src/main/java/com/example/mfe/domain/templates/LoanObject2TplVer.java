package com.example.mfe.domain.templates;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "CON_LOAN_OBJECT2TPL_VER")
public class LoanObject2TplVer {

    @Id
    @Column(name = "ID_LOAN_OBJECT2TEMPLATE", nullable = false, precision = 0)
    private long idLoanObject2Template;

    @Column(name = "LOAN_OBJECT", nullable = false, length = 50)
    private String loanObject;

    @Column(name = "LOAN_TYPE", nullable = true, length = 50)
    private String loanType;

    @Column(name = "LOAN_PURPOSE", nullable = true, length = 50)
    private String loanPurpose;

    @Column(name = "PROP_TYPE", nullable = true, length = 50)
    private String propType;


    public String getLoanObject() {
        return loanObject;
    }

    public void setLoanObject(String loanObject) {
        this.loanObject = loanObject;
    }


}

package hibernate.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CON_LOAN_OBJECT2TPL_VER", schema = "CMD_MFE", catalog = "")
public class LoanObject2TplVer {
    private String loanObject;
    private String loanType;
    private long idLoanObject2Template;
    private String loanPurpose;
    private String propType;

    @Basic
    @Column(name = "LOAN_OBJECT")
    public String getLoanObject() {
        return loanObject;
    }

    public void setLoanObject(String loanObject) {
        this.loanObject = loanObject;
    }

    @Basic
    @Column(name = "LOAN_TYPE")
    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    @Id
    @Column(name = "ID_LOAN_OBJECT2TEMPLATE")
    public long getIdLoanObject2Template() {
        return idLoanObject2Template;
    }

    public void setIdLoanObject2Template(long idLoanObject2Template) {
        this.idLoanObject2Template = idLoanObject2Template;
    }

    @Basic
    @Column(name = "LOAN_PURPOSE")
    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    @Basic
    @Column(name = "PROP_TYPE")
    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanObject2TplVer that = (LoanObject2TplVer) o;
        return idLoanObject2Template == that.idLoanObject2Template &&
                Objects.equals(loanObject, that.loanObject) &&
                Objects.equals(loanType, that.loanType) &&
                Objects.equals(loanPurpose, that.loanPurpose) &&
                Objects.equals(propType, that.propType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(loanObject, loanType, idLoanObject2Template, loanPurpose, propType);
    }
}

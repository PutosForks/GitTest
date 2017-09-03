package hibernate.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="JS_TRANSACTION")
public class JsTransaction {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="txn_id")
    private long id;

    @Column(name="txn_date")
    private Date date;

    @Column(name="txn_total")
    private double total;

    @OneToOne(mappedBy="txn", fetch = FetchType.LAZY, optional = false)
    @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="TXN_ID")
    private JsCustomer customer;

    @Override
    public String toString(){
        return getId() +", "+ getTotal() +", "+ getCustomer().getName()+", "+ getCustomer().getEmail()+", "+ getCustomer().getAddress();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public JsCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(JsCustomer customer) {
        this.customer = customer;
    }
}
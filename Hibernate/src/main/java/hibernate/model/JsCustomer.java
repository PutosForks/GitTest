package hibernate.model;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name="JS_CUSTOMER")
public class JsCustomer {

    @Id
    @Column(name="txn_id", unique=true, nullable=false)
    @GeneratedValue(generator="foreign")
    @GenericGenerator(name="foreign", strategy="foreign", parameters={@Parameter(name="property", value="txn")})
    private long id;

    @Column(name="cust_name")
    private String name;

    @Column(name="cust_email")
    private String email;

    @Column(name="cust_address")
    private String address;

    @OneToOne  (fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="TXN_ID", referencedColumnName="TXN_ID")
    private JsTransaction txn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public JsTransaction getTxn() {
        return txn;
    }

    public void setTxn(JsTransaction txn) {
        this.txn = txn;
    }

    //Getter-Setter




}

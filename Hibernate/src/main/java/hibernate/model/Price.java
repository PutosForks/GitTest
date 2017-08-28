package hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PRICES")
public class Price implements java.io.Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String item;
    private Double price;
    private Double vat;


    public Price() {
    }

    public Price(String item, Double price, Double vat) {
        this.item = item;
        this.price = price;
        this.vat = vat;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVat() {
        return this.vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }


}



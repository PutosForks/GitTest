package hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "USER_NAME", nullable = false)
    public String userName;

    @Column(name = "PASSWORD", nullable = false)
    public String password;

    @Column(name = "VERIFIED")
    public Boolean verified;

    @ManyToMany(mappedBy = "clients")
    public Set<Skill> skills = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DETAIL_ID")
    public ClientDetail clientDetail;

    @OneToMany(mappedBy = "client",
            targetEntity = Address.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    public Set<Address> address = new HashSet<>();

    /**
     * @return the Id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the Id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the verified
     */
    public Boolean getVerified() {
        return verified;
    }

    /**
     * @param verified the verified to set
     */
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    /**
     * @return the clientDetail
     */
    public ClientDetail getClientDetail() {
        return clientDetail;
    }

    /**
     * @param clientDetail the clientDetail to set
     */
    public void setClientDetail(ClientDetail clientDetail) {
        this.clientDetail = clientDetail;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

}

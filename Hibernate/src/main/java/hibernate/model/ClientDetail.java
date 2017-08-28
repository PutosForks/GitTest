package hibernate.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CLIENT_DETAIL")
public class ClientDetail {

    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(
            name = "gen",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "client")
    )
    private Long Id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "PASSWORD_HINT")
    private String passwordHint;

    @Column(name = "VERIFICATION_DATE")
    private Date vefificationDate;

    @Column(name = "REGISTRATION_DATE")
    private Date registrationDate;

    @OneToOne(mappedBy = "clientDetail", cascade = CascadeType.ALL)
    private Client client;

    /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the passwordHint
     */
    public String getPasswordHint() {
        return passwordHint;
    }

    /**
     * @param passwordHint the passwordHint to set
     */
    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    /**
     * @return the vefificationDate
     */
    public Date getVefificationDate() {
        return vefificationDate;
    }

    /**
     * @param vefificationDate the vefificationDate to set
     */
    public void setVefificationDate(Date vefificationDate) {
        this.vefificationDate = vefificationDate;
    }

    /**
     * @return the registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

}

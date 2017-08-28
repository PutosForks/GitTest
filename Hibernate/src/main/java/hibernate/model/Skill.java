package hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SKILLS")
public class Skill {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(name = "CLIENT_SKILLS",
            joinColumns = {
                @JoinColumn(name = "SKILL_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "CLIENT_ID")})
    public Set<Client> clients = new HashSet<>();

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the clients
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

}

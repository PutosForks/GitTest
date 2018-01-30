package com.example.mfe.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "MFE_ROLE")
public class Role {

    @Id
    @Column(name = "NAME")
    private String name;
    private String title;

    @ManyToMany
    @JoinTable(name = "mfe_user2role",
            joinColumns = {@JoinColumn(name = "role")},
            inverseJoinColumns = {@JoinColumn(name = "user_")})
    private List<User> users;

}

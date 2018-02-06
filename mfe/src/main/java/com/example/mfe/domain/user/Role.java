package com.example.mfe.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "MFE_ROLE")
public class Role {

    @Id
    @Column(name = "NAME")
    private String name;
    private String title;

    @OneToMany(mappedBy = "role")
    Set<UserRole> users = new HashSet<>();

}

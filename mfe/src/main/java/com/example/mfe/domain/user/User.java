package com.example.mfe.domain.user;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "MFE_USER")
public class User {

    @Id
    @Column(name = "USR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 10)
    @NotNull
    private String usrSso;

    @Size(max = 20)
    @NotNull
    private String usrFirstname;

    @Size(max = 20)
    @NotNull
    private String usrSurname;

    @NotNull
    private boolean active;



}

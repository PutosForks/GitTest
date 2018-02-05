package com.example.mfe.domain.user;

import com.example.mfe.enumeration.AccessType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "MFE_USER2ROLE")
@Data
public class UserRole {

    @EmbeddedId
    private UserRoleId userRoleId;

    @Enumerated(EnumType.STRING)
    @Column(name="ACCESS_TYPE")
    private AccessType accessType;

    @ManyToOne
    @JoinColumn(name = "USER_")
    @MapsId("userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ROLE")
    @MapsId("roleId")
    private Role role;



}

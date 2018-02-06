package com.example.mfe.domain.user;

import com.example.mfe.enumeration.AccessType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name= "MFE_USER2ROLE")
@Data
public class UserRole {


    @Embeddable
    public static class UserRoleId implements Serializable {

        private static final long serialVersionUID = -3287715633608041039L;

        @Column(name = "USER_")
        private Long userId;

        @Column(name = "ROLE")
        private String roleId;

        public Long getUserId() {
            return userId;
        }

        public String getRoleId() {
            return roleId;
        }


        public UserRoleId() {
        }


        public UserRoleId(Long userId, String roleId) {
            this.userId = userId;
            this.roleId = roleId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserRoleId that = (UserRoleId) o;
            return Objects.equals(getUserId(), that.getUserId()) &&
                    Objects.equals(getRoleId(), that.getRoleId());
        }

        @Override
        public int hashCode() {

            return Objects.hash(getUserId(), getRoleId());
        }


        @Override
        public String toString() {
            return "erRoleId{" +
                    "userId=" + userId +
                    ", roleId=" + roleId +
                    '}';
        }
    }


    @EmbeddedId
    private UserRoleId userRoleId;

    @Enumerated(EnumType.STRING)
    @Column(name="ACCESS_TYPE")
    private AccessType accessType;

    @ManyToOne
    @JoinColumn(name = "USER_", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ROLE", insertable = false, updatable = false)
    private Role role;



}

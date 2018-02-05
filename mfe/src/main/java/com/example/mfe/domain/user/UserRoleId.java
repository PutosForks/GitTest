package com.example.mfe.domain.user;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserRoleId implements Serializable{

    private static final long serialVersionUID = -3287715633608041039L;

    private Long userId;
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
        return "UserRoleId{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}

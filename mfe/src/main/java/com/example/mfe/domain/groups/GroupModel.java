package com.example.mfe.domain.groups;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CON_GROUP_MODEL", schema = "CMD_MFE", catalog = "")
public class GroupModel {
    private long idGroupModel;
    private long idCurrentVer;
    private String title;
    private Long userOrder;
    private Long oldGroupId;

    @Id
    @Column(name = "ID_GROUP_MODEL", nullable = false, precision = 0)
    public long getIdGroupModel() {
        return idGroupModel;
    }

    public void setIdGroupModel(long idGroupModel) {
        this.idGroupModel = idGroupModel;
    }

    @Basic
    @Column(name = "ID_CURRENT_VER", nullable = false, precision = 0)
    public long getIdCurrentVer() {
        return idCurrentVer;
    }

    public void setIdCurrentVer(long idCurrentVer) {
        this.idCurrentVer = idCurrentVer;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 256)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "USER_ORDER", nullable = true, precision = 0)
    public Long getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(Long userOrder) {
        this.userOrder = userOrder;
    }

    @Basic
    @Column(name = "OLD_GROUP_ID", nullable = true, precision = 0)
    public Long getOldGroupId() {
        return oldGroupId;
    }

    public void setOldGroupId(Long oldGroupId) {
        this.oldGroupId = oldGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupModel that = (GroupModel) o;
        return idGroupModel == that.idGroupModel &&
                idCurrentVer == that.idCurrentVer &&
                Objects.equals(title, that.title) &&
                Objects.equals(userOrder, that.userOrder) &&
                Objects.equals(oldGroupId, that.oldGroupId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idGroupModel, idCurrentVer, title, userOrder, oldGroupId);
    }
}

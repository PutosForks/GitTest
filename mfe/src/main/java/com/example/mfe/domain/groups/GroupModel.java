package com.example.mfe.domain.groups;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "CON_GROUP_MODEL")
public class GroupModel {

    @Id
    @Column(nullable = false, precision = 0)
    private long idGroupModel;

    @Column(nullable = false, precision = 0)
    private long idCurrentVer;

    @Column(nullable = false, length = 256)
    private String title;

    @Column(nullable = true, precision = 0)
    private Long userOrder;

    @Column(nullable = true, precision = 0)
    private Long oldGroupId;


}

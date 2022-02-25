package com.usta.cafesua.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "status")
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idStatus;

    @NotNull
    @Column(name = "name")
    private String statusName;

    @NotNull
    @Column(name = "description")
    private String statusDescription;

}

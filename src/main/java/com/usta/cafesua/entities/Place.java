package com.usta.cafesua.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "places")

public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idPlace;

    @NotNull
    @Column(name = "description")
    private String descriptionPlace;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type")
    private KindOfPlace kindofPlace;

    @NotNull
    @Column(name = "bag_capacity")
    private Integer bagCapacity;
}

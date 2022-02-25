package com.usta.cafesua.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "bags")
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idBag;

    @NotNull
    @Column(name = "actual_weight")
    private double actualWeight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    private Place place;


}

package com.usta.cafesua.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "bags")
public class Bag {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idBag;

    @NotNull
    @Column(name = "actual_weight")
    private double actualWeight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id",referencedColumnName = "id")
    private Place place;


}

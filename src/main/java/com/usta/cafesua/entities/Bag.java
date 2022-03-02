package com.usta.cafesua.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bags")
public class Bag implements Serializable {
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

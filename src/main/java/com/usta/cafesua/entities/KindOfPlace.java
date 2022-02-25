package com.usta.cafesua.entities;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "kind_of_places")

public class KindOfPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idKindOfPlace;

    @NotNull
    @Column(name = "name")
    private String nameKindOfPlace;

    @Column(name ="description")
    private String descriptionKindOfPlace;

}

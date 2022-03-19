package com.usta.cafesua.entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.nio.MappedByteBuffer;

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

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne()
    @OnDelete(action =  OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    public Long getIdBag() {
        return idBag;
    }

    public void setIdBag(Long idBag) {
        this.idBag = idBag;
    }

    public double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(double actualWeight) {
        this.actualWeight = actualWeight;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}

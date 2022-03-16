package com.usta.cafesua.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "places")

public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idPlace;

    @NotNull
    @Column(name = "description")
    private String placeDescription;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private KindOfPlace kindofPlace;

    @NotNull
    @Column(name = "bag_capacity")
    private Integer bagCapacity;

    public Long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Long idPlace) {
        this.idPlace = idPlace;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String descriptionPlace) {
        this.placeDescription = descriptionPlace;
    }

    public KindOfPlace getKindofPlace() {
        return kindofPlace;
    }

    public void setKindofPlace(KindOfPlace kindofPlace) {
        this.kindofPlace = kindofPlace;
    }

    public Integer getBagCapacity() {
        return bagCapacity;
    }

    public void setBagCapacity(Integer bagCapacity) {
        this.bagCapacity = bagCapacity;
    }

    @Override
    public String toString() {
        return placeDescription;
    }
}

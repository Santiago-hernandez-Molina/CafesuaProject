package com.usta.cafesua.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sun.istack.NotNull;

@Entity
@Table(name = "places")

public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "description")
    private String description;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "type_id", referencedColumnName="id")
    private KindOfPlace kindOfPlace;

    @NotNull
    @Column(name = "bag_capacity")
    private Integer bagCapacity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public KindOfPlace getKindOfPlace() {
		return kindOfPlace;
	}

	public void setKindOfPlace(KindOfPlace kindofPlace) {
		this.kindOfPlace = kindofPlace;
	}

	public Integer getBagCapacity() {
		return bagCapacity;
	}

	public void setBagCapacity(Integer bagCapacity) {
		this.bagCapacity = bagCapacity;
	}

	@Override
	public String toString() {
		return description;
	}
}

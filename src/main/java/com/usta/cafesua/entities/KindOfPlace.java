package com.usta.cafesua.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name= "kind_of_places")

public class KindOfPlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idKindOfPlace;

    @NotNull
    @Column(name = "name")
    private String nameKindOfPlace;

    @Column(name ="description")
    private String descriptionKindOfPlace;

	public Long getIdKindOfPlace() {
		return idKindOfPlace;
	}

	public void setIdKindOfPlace(Long idKindOfPlace) {
		this.idKindOfPlace = idKindOfPlace;
	}

	public String getNameKindOfPlace() {
		return nameKindOfPlace;
	}

	public void setNameKindOfPlace(String nameKindOfPlace) {
		this.nameKindOfPlace = nameKindOfPlace;
	}

	public String getDescriptionKindOfPlace() {
		return descriptionKindOfPlace;
	}

	public void setDescriptionKindOfPlace(String descriptionKindOfPlace) {
		this.descriptionKindOfPlace = descriptionKindOfPlace;
	}
}

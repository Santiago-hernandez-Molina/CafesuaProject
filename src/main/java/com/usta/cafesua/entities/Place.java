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

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sun.istack.NotNull;

@Entity
@Table(name = "places")
@Setter
@Getter
@ToString(includeFieldNames = false,onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@ToString.Include
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

}

package com.usta.cafesua.entities;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true, includeFieldNames = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bags")
public class Bag implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "weight")
  private double weight;

  @ToString.Include
  @ManyToOne()
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  @JoinColumn(name = "status_id", referencedColumnName = "id")
  private Status status;

  @ToString.Include
  @ManyToOne()
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  @JoinColumn(name = "place_id", referencedColumnName = "id")
  private Place place;
}

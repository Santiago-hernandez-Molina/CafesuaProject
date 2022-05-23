package com.usta.cafesua.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "users")
@NoArgsConstructor
@ToString
public class UserCafesua {
    private static final long serialVersionUID = 1L;

    public UserCafesua(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID",
                    referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",
                    referencedColumnName = "ID")})
    private List<Role> roles;

}

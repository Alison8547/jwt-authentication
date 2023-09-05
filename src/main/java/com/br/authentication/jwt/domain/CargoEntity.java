package com.br.authentication.jwt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cargo")
public class CargoEntity implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private int idCargo;

    @Column(name = "nome")
    private String nome;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_cargo",
            joinColumns = @JoinColumn(name = "id_cargo"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private Set<UserEntity> userEntities;

    @Override
    public String getAuthority() {
        return nome;
    }
}
package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlayerTeam implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Team team;
    @Id
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Player player;
    @Column
    private int playerNumber;
}

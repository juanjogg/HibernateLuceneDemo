package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.EAGER;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "tournamentFK")
    private Tournament tournament;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime date;
    @Column
    private int scoreHome;
    @Column
    private int scoreGuest;
    @Column
    private boolean isFriendly;

}

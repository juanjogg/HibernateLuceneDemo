package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Indexed
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Field(termVector = TermVector.YES)
    @Column
    private String name;
    @Field(termVector = TermVector.YES)
    @Column
    private String lastName;
    @Field(termVector = TermVector.YES)
    @Column
    private String email;
    @Field(termVector = TermVector.YES)
    @Column
    private String username;
}

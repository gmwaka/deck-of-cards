package com.logmein.game.deckofcards.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="DECK")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Deck{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", nullable=false) 
    private String name;

    @OneToMany
    @Column(name="PLAYERS")    
    private List<Player> players;

}
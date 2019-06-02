package com.logmein.game.deckofcards.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="GAME")
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", nullable=false, unique = true)
    private String name;

    @OneToMany
    @Column(name="PLAYERS")    
    private List<Player> players;

    @OneToMany
    @Column(name="DECKS")    
    private List<Deck> decks;
}
package com.logmein.game.deckofcards.models;

import java.util.List;
import java.util.Random;

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
    @Column(name="GAME_DECK")    
    private List<Card> game_deck;

    public void shuffleGameDeck(){
        Random random = new Random();
        List<Card> temporary_game_deck = this.getGame_deck();
        for (int i = temporary_game_deck.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temporaryCard = temporary_game_deck.get(j);
            temporary_game_deck.set(j, temporary_game_deck.get(i));
            temporary_game_deck.set(i, temporaryCard);
        }
        this.setGame_deck(temporary_game_deck);
    }
}

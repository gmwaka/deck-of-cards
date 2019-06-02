package com.logmein.game.deckofcards.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Suit {
    private String suitName;
    private List<Card> suitCards;

    public Suit(){

    }
    public Suit(String suitName){
        super();
        this.suitName = suitName;
        this.suitCards = new ArrayList<Card>();
        this.suitCards.add(new Card(1, "Ace", suitName));
        IntStream.range(2, 11).forEach(value -> this.suitCards.add(new Card(value, String.valueOf(value), suitName)));
        this.suitCards.add(new Card(11, "Jack", suitName));
        this.suitCards.add(new Card(11, "Queen", suitName));
        this.suitCards.add(new Card(11, "King", suitName));
    }
}

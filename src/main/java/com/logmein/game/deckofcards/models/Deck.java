package com.logmein.game.deckofcards.models;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Column(name="DECK_NAME", nullable=false) 
    private String name;

    @OneToMany
    @Column(name = "DECK_CARDS")
    private List<Card> cards;

    public Deck() {
	}
	
	public Deck(String deckName) {
		super();
		this.name = deckName;
		this.cards = new ArrayList<Card>();

		Suit Clubs = new Suit("Clubs");
		Suit Diamonds = new Suit("Diamonds");
		Suit Hearts = new Suit("Hearts");
		Suit Spades = new Suit("Spades");
		
        Arrays.asList(Clubs, Diamonds, Hearts, Spades).forEach(suit -> this.cards.addAll(suit.getSuitCards()));
    }
}

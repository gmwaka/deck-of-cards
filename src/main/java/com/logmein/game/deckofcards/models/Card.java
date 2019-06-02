package com.logmein.game.deckofcards.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CARD")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CARD_NUMBER", nullable=false)
    private Integer cardNumber;
    
    @Column(name = "CARD_SUIT", nullable=false)
    private String cardSuit;

    @Column(name = "CARD_NAME", nullable = false)
    private String cardName;

    public Card() {
	}
	
	public Card(int cardNumber, String cardName, String cardSuit) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cardSuit = cardSuit;
	}
}

package com.logmein.game.deckofcards.models;

import java.util.Iterator;
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
@Table(name="PLAYER")
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", nullable=false)
    private String name;

    @OneToMany
    @Column(name = "CARDS")
    private List<Card> cards;

    private Integer totalCard;

    public int totalCardsValue(){
        int totalValue = 0;
        Iterator<Card> cardsIterator = this.getCards().iterator();
        while (cardsIterator.hasNext()) {
            Card card = cardsIterator.next();
            totalValue = totalValue + card.getCardNumber();
        }
        return totalValue;
    }
}

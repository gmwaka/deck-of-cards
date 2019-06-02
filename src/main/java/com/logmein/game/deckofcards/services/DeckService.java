
package com.logmein.game.deckofcards.services;

import java.util.Iterator;

import com.logmein.game.deckofcards.models.Card;
import com.logmein.game.deckofcards.models.Deck;
import com.logmein.game.deckofcards.repositories.CardRepository;
import com.logmein.game.deckofcards.repositories.DeckRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckService{

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private CardRepository cardRepository;

    public Deck saveDeck(Deck deck){
        for(Iterator<Card> iterator = deck.getCards().iterator(); iterator.hasNext();){
            Card card = iterator.next();
            cardRepository.save(card);
        }
        return deckRepository.save(deck);
    }

}
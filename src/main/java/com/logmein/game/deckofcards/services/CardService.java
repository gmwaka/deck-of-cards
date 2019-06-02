package com.logmein.game.deckofcards.services;

import com.logmein.game.deckofcards.models.Card;
import com.logmein.game.deckofcards.repositories.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired    
    private CardRepository cardRepository;

    public Card saveCard(Card card){
        return cardRepository.save(card);
    }
    
}
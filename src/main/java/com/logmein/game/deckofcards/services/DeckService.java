
package com.logmein.game.deckofcards.services;

import java.util.Iterator;

import com.logmein.game.deckofcards.models.Card;
import com.logmein.game.deckofcards.models.Deck;
import com.logmein.game.deckofcards.models.Game;
import com.logmein.game.deckofcards.repositories.CardRepository;
import com.logmein.game.deckofcards.repositories.DeckRepository;
import com.logmein.game.deckofcards.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckService{

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private GameRepository gameRepository;

    public Deck saveDeck(Deck deck){
        for(Iterator<Card> iterator = deck.getCards().iterator(); iterator.hasNext();){
            Card card = iterator.next();
            cardRepository.save(card);
        }
        return deckRepository.save(deck);
    }
    
    public Deck updateDeckGame(Long deck_id, Long game_id){
        Game game = gameRepository.findById(game_id).orElse(null);
        Deck deck = deckRepository.findById(deck_id).orElse(null);
        if(deck != null && game !=null){
            deck.setGame(game);
        }
        final Deck theDeck = deckRepository.save(deck);
        return theDeck;
    }

}
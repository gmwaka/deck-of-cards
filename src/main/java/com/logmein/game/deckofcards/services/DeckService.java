
package com.logmein.game.deckofcards.services;

//import com.logmein.game.deckofcards.dtos.DeckDTO;
//import com.logmein.game.deckofcards.models.Deck;
//import com.logmein.game.deckofcards.repositories.DeckRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeckService{

    // private final DeckRepository deckRepository;

    /*
    public void createDeck(DeckDTO deckDTO){
        Deck deckModel = mapFromDeckDTOToDeck(deckDTO);
        deckRepository.save(deckModel);
    }

    private Deck mapFromDeckDTOToDeck(DeckDTO deckDTO){
        Deck deckModel = new Deck();
        deckModel.setName(deckDTO.getName());
        //deckModel.setPlayers(deck);
        return deckModel;
    }
    */

}
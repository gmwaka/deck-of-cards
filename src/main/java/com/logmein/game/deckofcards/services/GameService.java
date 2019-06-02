package com.logmein.game.deckofcards.services;

import java.util.List;

import com.logmein.game.deckofcards.models.Deck;
import com.logmein.game.deckofcards.models.Game;
import com.logmein.game.deckofcards.repositories.DeckRepository;
import com.logmein.game.deckofcards.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private DeckRepository deckRepository;

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    public Boolean deleteGame(Long gameId){
        Game gameToDelete = gameRepository.findById(gameId).orElse(null);
        if(gameToDelete != null){
            gameRepository.delete(gameToDelete);
            return true;
        }
        return false;
    }

    public Game addDeck(Long gameId, Long deckId){
        Game gameToUpdate = gameRepository.findById(gameId).orElse(null);
        Deck deckToInclude = deckRepository.findById(deckId).orElse(null);
        if(gameToUpdate != null && deckToInclude != null){
            List<Deck> gameDecks = gameToUpdate.getDecks();
            gameDecks.add(deckToInclude);
            gameToUpdate.setDecks(gameDecks);
        }
        final Game theGame = gameRepository.save(gameToUpdate);
        return theGame;
    }
}
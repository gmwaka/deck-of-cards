package com.logmein.game.deckofcards.services;

import com.logmein.game.deckofcards.models.Game;
import com.logmein.game.deckofcards.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    public Boolean deleteGame(Long id){
        Game gameToDelete = gameRepository.findById(id).orElse(null);
        if(gameToDelete != null){
            gameRepository.delete(gameToDelete);
            return true;
        }
        return false;
    }
}
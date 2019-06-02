package com.logmein.game.deckofcards.services;

import java.util.ArrayList;
import java.util.List;

import com.logmein.game.deckofcards.models.Card;
import com.logmein.game.deckofcards.models.Player;
import com.logmein.game.deckofcards.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }

    public List<Card> listPlayerCards(Long playerId){
        List<Card> cards = new ArrayList<Card>();
        Player player = playerRepository.findById(playerId).orElse(null);
        if(player != null){
            cards = player.getCards();
        }
        return cards;
    }
}

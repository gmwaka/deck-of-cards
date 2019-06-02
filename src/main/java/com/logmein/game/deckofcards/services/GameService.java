package com.logmein.game.deckofcards.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.logmein.game.deckofcards.models.Card;
import com.logmein.game.deckofcards.models.Deck;
import com.logmein.game.deckofcards.models.Game;
import com.logmein.game.deckofcards.models.Player;
import com.logmein.game.deckofcards.repositories.DeckRepository;
import com.logmein.game.deckofcards.repositories.GameRepository;
import com.logmein.game.deckofcards.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private PlayerRepository playerRepository;

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
            List<Card> gameDeck = gameToUpdate.getGame_deck();
            List<Card> newGameDeck = new ArrayList<Card>();
            newGameDeck.addAll(gameDeck);
            newGameDeck.addAll(deckToInclude.getCards());
            gameToUpdate.setGame_deck(newGameDeck);
        }
        final Game theGame = gameRepository.save(gameToUpdate);
        return theGame;
    }

    public Game addPlayer(Long gameId, Long playerId){
        Game gameToUpdate = gameRepository.findById(gameId).orElse(null);
        Player playerToInclude = playerRepository.findById(playerId).orElse(null);
        if(gameToUpdate != null && playerToInclude != null){
            List<Player> gamePlayers = gameToUpdate.getPlayers();
            gamePlayers.add(playerToInclude);
            gameToUpdate.setPlayers(gamePlayers);
        }
        final Game theGame = gameRepository.save(gameToUpdate);
        return theGame;
    }

    public Game removePlayer(Long gameId, Long playerId){
        Game gameToUpdate = gameRepository.findById(gameId).orElse(null);
        Player playerToRemove = playerRepository.findById(playerId).orElse(null);
        if(gameToUpdate != null && playerToRemove != null){
            List<Player> gamePlayers = gameToUpdate.getPlayers();
            gamePlayers.remove(playerToRemove);
            gameToUpdate.setPlayers(gamePlayers);
        }
        final Game theGame = gameRepository.save(gameToUpdate);
        return theGame;
    }

    public Player dealCards(int numer_of_cards, Long playerId, Long gameId){
        Game game = gameRepository.findById(gameId).orElse(null);
        Player player = playerRepository.findById(playerId).orElse(null);
        if(game != null && player != null){
            List<Player> gamePlayers = game.getPlayers();
            if(gamePlayers.contains(player)){
                List<Card> gameDeck = game.getGame_deck();
                for (int i = gameDeck.size() - 1; i >= 0 && numer_of_cards >0; i--){
                    Card cardToDeal = gameDeck.get(gameDeck.size()-1);
                    List<Card> playerCards = player.getCards();

                    playerCards.add(cardToDeal);
                    player.setCards(playerCards);
                    playerRepository.save(player);

                    gameDeck.remove(cardToDeal);
                    numer_of_cards--;
                }
                game.setGame_deck(gameDeck);
            }
        }
        gameRepository.save(game);
        final Player thePlayer = playerRepository.save(player);
        return thePlayer;
    }

    public Game shuffleGameDeck(Long gameId){
        Game gameToUpdate = gameRepository.findById(gameId).orElse(null);
        if(gameToUpdate != null){
            gameToUpdate.shuffleGameDeck();
        }
        final Game theGame = gameRepository.save(gameToUpdate);
        return theGame;
    }

    public List<Player> listPlayers(Long gameId){
        List<Player> players = new ArrayList<Player>();
        Game game = gameRepository.findById(gameId).orElse(null);

        List<Player> playerResult = new ArrayList<Player>();
        if(game != null){
            players = game.getPlayers();
            Iterator<Player> playerIterator = players.iterator();
            while (playerIterator.hasNext()) {
                Player player = playerIterator.next();
                player.setTotalCard(player.totalCardsValue());
                playerResult.add(player);                
            }
            
            playerResult.sort(Comparator.comparing(Player::totalCardsValue).reversed());
        }
        return playerResult;
    }
}
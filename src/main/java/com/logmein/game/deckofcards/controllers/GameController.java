package com.logmein.game.deckofcards.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.logmein.game.deckofcards.models.Game;
//import com.logmein.game.deckofcards.dtos.*;
import com.logmein.game.deckofcards.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class GameController {

    @Autowired
    private GameService gameService;

    // private final DeckService deckService;

    /*
    @PostMapping(value="/")
    public ResponseEntity postMethodName(@Valid @RequestBody DeckDTO deckDTO) {
        deckService.createDeck(deckDTO);
        return ResponseEntity.ok().body("Worked!");
    }
    */
    @PostMapping("/game")
    public ResponseEntity<Game> createGame(@Valid @RequestBody Game game){
        return ResponseEntity.ok(gameService.saveGame(game));
    }

    @DeleteMapping("game/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Long id){
        Map<String, String> response = new HashMap<String, String>();
        if(gameService.deleteGame(id)){
            response.put("status", "succes");
            response.put("message", "game deleted successfully!");
            return ResponseEntity.ok(response);
        }else{
            response.put("status", "error");
            response.put("message", "something went wrong when delete the game!");
            return ResponseEntity.status(500).body(response);
        }
    }


    

}
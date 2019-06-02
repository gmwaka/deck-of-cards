package com.logmein.game.deckofcards.controllers;

import java.util.List;

import javax.validation.Valid;

import com.logmein.game.deckofcards.models.Card;
import com.logmein.game.deckofcards.models.Player;
import com.logmein.game.deckofcards.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player")
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player){
        return ResponseEntity.ok(playerService.savePlayer(player));
    }
    
    @GetMapping("/player/{player_id}/cards")
    public ResponseEntity<List<Card>> ListOfPlayerCards(@PathVariable(value = "player_id") Long player_id){
        return new ResponseEntity<List<Card>>(playerService.listPlayerCards(player_id), HttpStatus.OK);
    }
}

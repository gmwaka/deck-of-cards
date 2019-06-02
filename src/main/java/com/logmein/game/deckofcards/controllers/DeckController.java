package com.logmein.game.deckofcards.controllers;

import java.util.Map;

import com.logmein.game.deckofcards.models.Deck;
import com.logmein.game.deckofcards.services.DeckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @PostMapping("/deck")
    public ResponseEntity<Deck> createDeck(@RequestBody Map<String, String> body){
        String name = body.get("name");
        Deck deck = new Deck(name);
        return ResponseEntity.ok(deckService.saveDeck(deck));
    }

    @PutMapping("/deck/{deck_id}/game")
    public ResponseEntity<Deck> updateDeck(@PathVariable(value = "deck_id") Long deck_id, @RequestBody Map<String, String> body){
        Long game_id = Long.parseLong(body.get("game_id"));
        return ResponseEntity.ok(deckService.updateDeckGame(deck_id, game_id));
    }
}
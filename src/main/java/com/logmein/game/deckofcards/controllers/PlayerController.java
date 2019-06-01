package com.logmein.game.deckofcards.controllers;

import java.util.ArrayList;
import java.util.List;

import com.logmein.game.deckofcards.models.Player;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @GetMapping("/players/{id}/cards")
    public List<Player> all() {
        List<Player> players = new ArrayList<Player>();
        return players;
    }
}
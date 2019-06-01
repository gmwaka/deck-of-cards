package com.logmein.game.deckofcards.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @RequestMapping("/")
    public String index(){
        return "Congratulations from Card Controller";
    }
}
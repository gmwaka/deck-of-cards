package com.logmein.game.deckofcards.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DeckDTO{

    @NotBlank
    private String name;

    private List<PlayerDTO> players;
}
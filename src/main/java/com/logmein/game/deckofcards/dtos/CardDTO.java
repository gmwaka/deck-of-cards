package com.logmein.game.deckofcards.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CardDTO{
    
    @NotBlank
    private String suitValue;

    @NotBlank
    private String faceValue;

}
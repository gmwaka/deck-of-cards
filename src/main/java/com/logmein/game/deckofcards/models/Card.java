package com.logmein.game.deckofcards.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CARD")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SUIT_VALUE", nullable=false)
    private String suitValue;

    @Column(name = "FACE_VALUE", nullable = false)
    private String faceValue;

}
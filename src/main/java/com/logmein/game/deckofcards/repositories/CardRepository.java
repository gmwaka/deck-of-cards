package com.logmein.game.deckofcards.repositories;

import com.logmein.game.deckofcards.models.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
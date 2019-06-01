package com.logmein.game.deckofcards.repositories;

import com.logmein.game.deckofcards.models.Deck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long>{

}
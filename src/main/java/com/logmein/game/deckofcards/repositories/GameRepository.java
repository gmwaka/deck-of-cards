package com.logmein.game.deckofcards.repositories;

import com.logmein.game.deckofcards.models.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
    
}
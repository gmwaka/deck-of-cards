package com.logmein.game.deckofcards.repositories;

import com.logmein.game.deckofcards.models.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
    
}
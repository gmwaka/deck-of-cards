# deck-of-cards

- Create a game

POST /game
Content-Type: application/json

{

    "name": "Deck of Cards"

}


- Delete a game

DELETE game/{game_id}

- Add a deck to the game

PUT ("game/{game_id}/deck")

- Add a player to the game

PUT ("game/{game_id}/player")

- Remove a player to the game

- Deal cards to a player in a game

PUT (value="game/{game_id}/player/{player_id}")

- Get the list of cards for a player

GET ("/player/{player_id}/cards")

- Get the count of how many card

GET ("game/{game_id}/players")

- Get the count of each card

- Shuffle a game deck

GET ("game/{game_id}")

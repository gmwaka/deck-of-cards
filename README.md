# deck-of-cards

- Create a game

POST ("/game")

E.g.

POST /game

Content-Type: application/json

{

    "name": "Deck of Cards"

}

------------------------------------

- Delete a game

DELETE ("game/{game_id}")

E.g.

DELETE game/1

Content-Type: application/json



------------------------------------

- Add a deck to the game

PUT ("game/{game_id}/deck")


E.g.

PUT ("game/1/deck")

Content-Type: application/json

{

    "deck_id": "55"

}

------------------------------------

- Add a player to the game

PUT ("game/{game_id}/player")

E.g.

PUT game/1/player

Content-Type: application/json

{

    "player_id": "45"

}

------------------------------------

- Remove a player to the game


------------------------------------

- Deal cards to a player in a game from the game deck

PUT ("game/{game_id}/player/{player_id}")


PUT game/1/player/1

Content-Type: application/json

{

    "number_of_card_to_deal": "5"

}


------------------------------------

- Get the list of cards for a player

GET ("/player/{player_id}/cards")

E.g

GET /player/55/cards

Content-Type: application/json



------------------------------------


- Get the list of players in a game along with the total added value of all the cards each player holds

GET ("game/{game_id}/players")

E.g

GET game/1/players

Content-Type: application/json


------------------------------------


- Get the count of each card


------------------------------------


- Shuffle a game deck

GET ("game/{game_id}")

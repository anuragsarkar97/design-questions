

# BATTLESHIP DESIGN

## Game Design

Game consist 2 matrix namely ship placement map and attack map 
Currently it is a 2 player game. 

Game flow is as follow

1. Start Game or Resume Game
2. Select New game
3. Set ships GOTO Step util all ships are set then step 4
4. attack GOTO Step 4 till all ships of either player is wrecked GOTO Step 5
5.  GOTO Step 1


## Assumption 

1. There can be at max only one type of ship on the board.
2. We can have only 2 players and no CPU user. 
3. All inputs are Case sensitise.
4. Game ends as soon as someone wins.
5. Attack is always alternative move.
6. Player 1 always starts as an attacker and Player 2 as defender.
7. Attack cannot be done position once done before
8. Ships cannot overlap with ach other.
9. Ships are either vertical or horizontal alignment.
10. Player Name is Currently Fixed. 


## Areas of Design Improvement 

1. Better logs and error handling response.
2. Interactive selectors.

## Command

NewGame ```GAME_NAME```

ResumeGame ```GAME_NAME```

SaveAndExit

Attack ```X_pos``` ```Y_pos```

PlaceShip ```PLAYER_TYPE``` ```SHIP_TYPE``` ```X_POS``` ```Y_POS``` ```ALIGNMENT```
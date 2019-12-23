# edu-poker
Poker hands comparison application

## Overview
After "mvn clean install" start the server with command "java -jar target\edu-poker-0.0.1-SNAPSHOT.jar"

You can view working application by pointing browser at http://localhost:8080/ 

Try posting Cards to see who wins

{
  "player1": {
    "cards": [
      {
        "rank": "Jack",
        "suite": "Hearts"
      },
      {
        "rank": "3",
        "suite": "Hearts"
      },
      {
        "rank": "Jack",
        "suite": "Spades"
      },
      {
        "rank": "Jack",
        "suite": "Diamonds"
      },
      {
        "rank": "Jack",
        "suite": "Clubs"
      }
    ],
    "name": "Vardenis"
  },
  "player2": {
    "cards": [
      {
        "rank": "Ace",
        "suite": "Hearts"
      },
      {
        "rank": "3",
        "suite": "Hearts"
      },
      {
        "rank": "Ace",
        "suite": "Spades"
      },
      {
        "rank": "3",
        "suite": "Diamonds"
      },
      {
        "rank": "3",
        "suite": "Clubs"
      }
    ],
    "name": "Pavardenis"
  }
}


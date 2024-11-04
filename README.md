# Siete y Media Card Game

This Java project simulates the classic Spanish card game "Siete y Media" (Seven and a Half), where a player competes against the dealer (banca). The goal is for each player to draw cards to reach a total score as close to 7.5 as possible without exceeding it. The game features a simplified console-based interface and handles basic game mechanics such as card drawing, score calculation, and win conditions.

## Table of Contents

- [Overview](#overview)
- [Purpose](#purpose)
- [Features](#features)
- [Class Structure](#class-structure)
- [Gameplay](#gameplay)
- [Example Interaction](#example-interaction)

---

## Overview

The project consists of three primary components: a **console interface** for player interaction, the **game logic** that manages player and dealer actions, and the **card deck** structure, specifically configured for "Siete y Media." The deck contains 40 cards across four suits, with each suit omitting the 8 and 9 cards and assigning a value of 0.5 to face cards (10, 11, 12).

## Purpose

This project serves as a **learning exercise** in:
- Structuring a **console-based game** in Java.
- Applying **object-oriented principles** to model a deck of cards and gameplay mechanics.
- Utilizing **arrays** to manage hands of cards for both player and dealer.
- Demonstrating basic **game loops** and **condition checks** for win/loss outcomes.

## Features

- **Card Deck**: A Spanish deck of 40 cards without 8s or 9s, with special values for face cards.
- **Player and Dealer Hands**: Separate hands for each player, with actions to draw and calculate values.
- **Score Calculation**: Calculates hand values according to "Siete y Media" rules (face cards worth 0.5, others their numeric value).
- **Win/Loss Conditions**: Determines the outcome based on player and dealer scores, handling cases where either "busts" (goes over 7.5).

## Class Structure

- **`InterfaceConsola`**: Provides a console-based interface to interact with the game, guiding the player through their turn and displaying results.
- **`SieteYMedia`**: Core game logic, managing the deck, drawing cards, calculating scores, and checking turn conditions for both the player and the dealer.
- **`Baraja`**: Represents the Spanish deck, with methods to shuffle and deal cards.
- **`Carta`**: Represents an individual card with a suit and a number, and calculates its value.
- **`Palo`**: Enum representing the four suits in a Spanish deck: BASTOS, COPAS, ESPADAS, and OROS.

## Gameplay

1. **Player Turn**: The player begins by drawing cards to approach a score of 7.5. They can stop drawing at any time or until their score reaches or exceeds 7.5.
2. **Dealer Turn**: The dealer (banca) then draws cards, aiming to match or exceed the player's score without going over 7.5.
3. **Outcome**:
   - If the player exceeds 7.5, they lose immediately.
   - If the dealer matches or exceeds the player's score without going over 7.5, the dealer wins.
   - If the dealer exceeds 7.5, the player wins.

## Example Interaction

```plaintext
- El usuario es el jugador y el ordenador la banca.
- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.
- Las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.
- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.
- El jugador va pidiendo cartas a la banca de una en una.
- El jugador puede plantarse en cualquier momento.
- Si la suma de los valores de las cartas sacadas es superior a 7 y medio, el jugador 'se pasa de siete y medio' y pierde.
- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta está obligada a sacar cartas hasta empatar o superar al jugador.
- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.
- La banca no se puede plantar y tiene que empatar o superar la puntuación del jugador sin pasarse.
- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.

Empecemos!!!

Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte
Éstas son tus cartas jugador:
	(COPAS, 4)

	Valor de cartas: 4.0

¿Pides [C]arta o te [P]lantas?
C

Éstas son tus cartas jugador:
	(COPAS, 4)	(OROS, 5)

	Valor de cartas: 9.0
Jugador, te has pasado en tu jugada anterior, gana la banca
Adios
```

## Explanation

The game flows naturally with prompts and decisions presented to the player. Players can choose to draw additional cards or stop when they feel close enough to 7.5. The dealer plays according to fixed rules, drawing until they match or exceed the player's score without going over. The game handles all outcomes, displaying a clear message for each scenario.
```

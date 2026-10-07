# Craps Game

A command-line implementation of the casino dice game Craps, written in Java. Built as a Unit 5 assignment for CSCI 2001-52 Object Oriented Programming. Focused on functional decomposition, static vs. instance methods, enums and user input with 'Scanner'.

---
## Overview

Refactor and extend the Craps game implementation from Figure 5.4 of Deitel and Deitel's *Java: How to Program*. The goal was to practice **functional decomposition**
- breaking game logic into modular static methods - while using the provided 'Die' class, which has only instance methods. This allowed a direct contrast between calls on instance methods and calls on static methods.

### Learning Objective

- Deconstruct procedural logic into reusable, modular static methods
- Work with return values and parameters to coordinate program flow
- Instantiate and use existing classes
- Use Java enums to track game states
- Use the 'Scanner' class to get user input from the keyboard


## About the Game

Craps is a dice game played with two six-sided dice. Despite the casino jargon, the rules are simple:

**Come-Out Roll (first roll of a round):**
- Roll a **7 or 11** - You win immediately
- Roll a **2, 3 or 12** - You lose immediately
- Roll anything else (**4, 5, 6, 8, 9, 10**) - That number becomes your **point**

**Point Phase (after a point is established):**
- Roll your **point** again - You win
- Roll a **7** - You lose (this is called "sevening out")
- Roll anything else - Keep rolling

  The player starts with a bankroll, place a wager each round, and plays until they run out of money or choose to cash out.

---

## Sample of the Session

<div align="left">
	<img src="Screenshot 2026-10-07 143619.png" width="300">
</div>

---
Attribution

Based on Figure 5.4 from Java: How to Program: An Object Neutral Approach (12th edition) by Paul Deitel and Harvey Deitel. The Die class and the Craps class skeleton were provided as starter code for the assignment; the game logic, betting system, and user interface were implemented as part of the coursework.

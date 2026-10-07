# Craps Game

A command-line implementation of the casino dice game Craps, written in Java. Built as a Unit 5 assignment for CSCI 2001-52 Object Oriented Programming. Focused on functional decomposition, static vs. instance methods, enums and user input with 'Scanner'.

---

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

=== Welcome to Craps! ===
Enter your starting bankroll (e.g. 100): $100
Your starting bankroll is $100

Enter your wager (1-100): $25
Player rolled 3 + 4 = 7
*** You WON! Bankroll: $125 ***

Play another round? (y/n): y
Enter your wager (1-125): $50
Player rolled 5 + 3 = 8
Point is 8
Player rolled 2 + 1 = 3
Player rolled 6 + 2 = 8
*** You WON! Bankroll: $175 ***

Play another round? (y/n): y
Enter your wager (1-175): $175
Player rolled 1 + 1 = 2
*** You LOST. Bankroll: $0 ***
You're out of money! Game over.

Thanks for playing! You cashed out with $0.

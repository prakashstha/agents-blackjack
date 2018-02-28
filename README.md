# Assignment: Agents: Blackjack

The goal of this assignment is to introduce an intelligent agents.

`src/main/java/edu/uab/cis/agents/blackjack/DealerAgent.java/DealerAgent.java` implement the following rules.
   * If the total points represented by the cards are 17 or more, `act` should return `Action.STAND`. Otherwise, it should return `Action.HIT`.
   * Even if the total points represents 22 or more (which traditionally would be a "bust") you should return `Action.STAND`.
   * In calculating the total points, the order of the cards does not matter, only the point values.
   * The numeric cards always count for the equivalent number of points (TWO=2, THREE=3, ..., TEN=10).
   * JACK, QUEEN and KING always count for 10 points.
   * Each ACE may count for either 11 points or 1 point. You should pick between these by aiming for the highest possible points without exceeding 21. That is, if counting an ACE as 11 points would cause your total points to be 22 or more, you should count that ACE as 1 point.
package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

public enum Suit {
  //var suits = List.of("♠", "♦", "♥", "♣");
  SPADE("♠"),
  HEART("♥"),
  DIAMOND("♦"),
  CLUB("♣");

  private final String displayString;

  Suit(String displayString) {
    this.displayString = displayString;
  }

  public String displayString() {
    return displayString;
  }

  public Ansi.Color cardColor() {
    return "♥♦".contains(displayString) ? Ansi.Color.RED : Ansi.Color.BLACK;
  }
}

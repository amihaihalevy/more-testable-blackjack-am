package com.jitterted.ebp.blackjack;

public class Wallet {
  private int balance;

  public boolean isEmpty() {
    return balance == 0;
  }

  public void addMoney(int amount) {
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void bet(int amount) {
    checkNotEmpty();
    checkSufficientBalance(amount);
    balance -= amount;
  }

  private void checkSufficientBalance(int amount) {
    if (amount > balance) {
      throw new IllegalStateException();
    }
  }

  private void checkNotEmpty() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }
  }
}

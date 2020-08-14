package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void add10BucksNewToWalletIsEmptyIsFalse() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(10);

    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void add5BucksToNewWalletThenBalanceIs5() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(5);

    assertThat(wallet.balance())
        .isEqualTo(5);
  }

  @Test
  public void add7BucksToWalletWith5BucksThenBalanceIs12() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(5);

    wallet.addMoney(7);

    assertThat(wallet.balance())
        .isEqualTo(5 + 7);
  }

  @Test
  public void bettingAnyAmountWhenWalletIsEmptyThrowsException() throws Exception {
    Wallet wallet = new Wallet();

    assertThatThrownBy(() -> {
      wallet.bet(5);
    })
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void walletWith7BucksBetting5BucksResultsIn2BuckBalance() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(7);

    wallet.bet(5);

    assertThat(wallet.balance())
        .isEqualTo(7 - 5);
  }

  @Test
  public void walletWith23BucksBetting23BucksResultsInEmptyWallet() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(23);

    wallet.bet(23);

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void walletWith37BucksBetting45BucksThrowsException() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(37);

    assertThatThrownBy(() -> {
      wallet.bet(45);
    })
        .isInstanceOf(IllegalStateException.class);
  }

}

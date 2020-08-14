package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandBustedTest {

  private static final Suit DONT_CARE_SUIT = Suit.DIAMOND;

  @Test
  public void givenHandValueOf20ThenItIsNotBusted() throws Exception {
    Hand hand = createHand("10", "J");

    assertThat(hand.isBusted())
        .isFalse();
  }

  @Test
  public void givenHandValueOf21ThenItIsNotBusted() throws Exception {
    Hand hand = createHand("Q", "5", "6");

    assertThat(hand.isBusted())
        .isFalse();
  }

  @Test
  public void givenHandValueOf22ThenItIsBusted() throws Exception {
    Hand hand = createHand("Q", "J", "2");

    assertThat(hand.isBusted())
        .isTrue();
  }

  private Hand createHand(String... ranks) {
    List<Card> cards = new ArrayList<>();
    for (String rank : ranks) {
      cards.add(new Card(DONT_CARE_SUIT, rank));
    }
    return new Hand(cards);
  }

}
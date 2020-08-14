package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  /*
   *
   * ADD MORE TESTS FOR ACE BOUNDARY
   *
   *
   **/
  private static final Suit DONT_CARE_SUIT = Suit.DIAMOND;


  @Test
  public void hasAceWithValueCountingAcesAs1Of11ThenValuedAt21() throws Exception {
    Hand hand = createHand("A", "A", "A", "8");

    assertThat(hand.value())
        .isEqualTo(21);
  }

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11TotalOf20() throws Exception {
    Hand hand = createHand("A", "9");

    assertThat(hand.value())
        .isEqualTo(11 + 9);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Hand hand = createHand("A", "8", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 8 + 3);
  }

  private Hand createHand(String... ranks) {
    List<Card> cards = new ArrayList<>();
    for (String rank : ranks) {
      cards.add(new Card(DONT_CARE_SUIT, rank));
    }
    return new Hand(cards);
  }


}

package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingTest {

  @Test
  public void newGameThenPlayerHas100BuckBalance() throws Exception {
    Game game = new Game();

    assertThat(game.playerBalance())
        .isEqualTo(100);
  }

  @Test
  public void newGamePlayerBets30BucksHas70BuckBalance() throws Exception {
    Game game = new Game();

    game.playerBets(30);

    assertThat(game.playerBalance())
        .isEqualTo(70);
  }

  @Test
  public void playerBets40BucksAndWinsResultsIn140BuckBalance() throws Exception {
    Game game = new Game();
    game.playerBets(40);

    game.playerWins();

    assertThat(game.playerBalance())
        .isEqualTo(140);
  }
}

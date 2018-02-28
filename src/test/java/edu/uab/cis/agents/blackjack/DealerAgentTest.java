package edu.uab.cis.agents.blackjack;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.uab.cis.agents.blackjack.Action;
import edu.uab.cis.agents.blackjack.Card;
import edu.uab.cis.agents.blackjack.DealerAgent;
import edu.uab.cis.agents.blackjack.Card.Rank;
import edu.uab.cis.agents.blackjack.Card.Suit;

public class DealerAgentTest {

  @Test
  public void testTenKing() {
    DealerAgent agent = new DealerAgent();
    Card s10 = new Card(Rank.TEN, Suit.SPADES);
    Card hK = new Card(Rank.KING, Suit.HEARTS);
    Action action = agent.act(Arrays.asList(s10, hK));
    Assert.assertEquals(Action.STAND, action);
  }

  @Test
  public void testSixJack() {
    DealerAgent agent = new DealerAgent();
    Card d6 = new Card(Rank.SIX, Suit.DIAMONDS);
    Card cJ = new Card(Rank.JACK, Suit.CLUBS);
    Action action = agent.act(Arrays.asList(d6, cJ));
    Assert.assertEquals(Action.HIT, action);
  }
}

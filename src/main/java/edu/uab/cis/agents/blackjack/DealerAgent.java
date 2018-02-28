package edu.uab.cis.agents.blackjack;

import java.util.List;

/**
 * A dealer takes the {@link Action#HIT} action until their cards total 17 or
 * more points. Then the dealer takes the {@link Action#STAND} action.
 */
public class DealerAgent implements Agent {

  @Override
  public Action act(List<Card> cards) {
      int noOfCards = cards.size();
      int totalPoints = 0;
      int point;
      boolean isAce = false;
      
      for(int i = 0;i<noOfCards;i++)
      {
          Card cd = cards.get(i);
          point = cd.getRank().ordinal()+1;
          if(point>10)
              point = 10;
          totalPoints+=point;
          if(point==1)
              isAce = true;
      }
      if(isAce && totalPoints<12)
              totalPoints+=10;
      
      if(totalPoints>=17)
          return Action.STAND;
      else
          return Action.HIT;
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

import java.util.ArrayList;

// TODO: TEXTFILE AND/OR HTML FILE

/**
 *
 * @author macbookretina2015
 */
public class PlayGame {
    
    final static int CARDSPERDECK = 108; 
    private ArrayList<Card.Ranks> actionCardsNotToUse = new ArrayList<Card.Ranks>();
    private int numberOfDecks;
    
    private int[] tempsReps1 = {0,0,0,0};
    
    private int[] totalExerciseReps = {0,0,0,0};
    
    private int rankToInt(Card.Ranks rank) {
        
        switch (rank) {
            case ZERO:
                return 0;
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            
            default:
                return 0;
        }
        
    }
    
    public void wildCheck(Hand hand) {
        for (int i = 0; i < hand.handLL.size(); i++) {
            
            if (hand.handLL.get(i) instanceof WildCard && hand.handLL.get(i).getRank() == Card.Ranks.WILD) {
                ((WildCard) hand.handLL.get(i)).displayWild(hand);
                break;
            }
	}
    }
    
    public Pile reverseCheck(Hand hand, Pile pile) {
        for (int i = 0; i < hand.handLL.size(); i++) {
            
            if (hand.handLL.get(i) instanceof ActionCard) {
                pile = hand.handReverse(pile);
            }
	}
        return pile;
    }
    
    public Hand skipCheck(Hand hand) {
         // All the cards of this color that are in the hand are discarded for this round
        // returns new hand object
        for (int i = 0; i < hand.handLL.size(); i++) {
            if (hand.handLL.get(i) instanceof ActionCard) {
                hand = ((ActionCard) hand.handLL.get(i)).skip(hand);
            }
	}
        return hand;
    }
    
    public int[] calculateExercises(Hand hand) {
        
        int[] repsList = {0,0,0,0};
        int curNum;
        /* calculate exercises */
        for (Card card: hand.handLL) {
            curNum = rankToInt(card.getRank());
            
            switch (card.getColor()) {
                case RED:
                    repsList[0] += curNum;
                    break;
                case GREEN:
                    repsList[1] += curNum;
                    break;
                case YELLOW:
                    repsList[2] += curNum;
                    break;
                case BLUE:
                    repsList[3] += curNum;
                    break;
            }
            
            
        }
            

        return repsList;
    }
    
    public static void main(String[] args) {
        
        PlayGame game = new PlayGame();
        //game.actionCardsNotToUse.add(Card.Ranks.DRAWTWO);
        
        /* prompt for number of decks, prompt for action cards not to use, 
        shuffle together or not */
        
        
        /* create pile object */
        Pile pile = new Pile(1, game.actionCardsNotToUse, false);
        
        /* create and shuffle */
        pile.createDeck();
        //pile.printDeck();
        pile.shuffle();
        //pile.printDeck();
        //System.out.println(pile.cardPileAmount());

        Hand hand = new Hand();
        hand.handLL.add(new Card(Card.Colors.RED, Card.Ranks.NINE));
        hand.handLL.add(new Card(Card.Colors.BLUE, Card.Ranks.TWO));
        hand.handLL.add(new Card(Card.Colors.YELLOW, Card.Ranks.NINE));
        hand.handLL.add(new Card(Card.Colors.GREEN, Card.Ranks.FIVE));
        hand.handLL.add(new ActionCard(Card.Colors.RED, Card.Ranks.SKIP));
        hand.handLL.add(new ActionCard(Card.Colors.BLUE, Card.Ranks.REVERSE));
        hand.handLL.add(new ActionCard(Card.Colors.YELLOW, Card.Ranks.REVERSE));
        hand.handLL.add(new WildCard(Card.Colors.GREEN, Card.Ranks.WILDFOUR));
        hand.handLL.add(new ActionCard(Card.Colors.GREEN, Card.Ranks.DRAWTWO));
        hand.handLL.add(new Card(Card.Colors.BLUE, Card.Ranks.THREE));
        hand.handLL.add(new WildCard(Card.Colors.GREEN, Card.Ranks.WILD));
        hand.handLL.add(new WildCard(Card.Colors.GREEN, Card.Ranks.WILD));
        hand.handLL.add(new WildCard(Card.Colors.RED, Card.Ranks.WILD));
        
        System.out.print("Before sorting hand: ");
        hand.displaySortedHand();
        hand.sortHand();
        
        System.out.print("After sorting hand: ");
        hand.displaySortedHand();
        
        /*
        for (int i = 0; i < hand.handLL.size(); i++) {
    
            if (hand.handLL.get(i) instanceof ActionCard) {
                hand = ((ActionCard) hand.handLL.get(i)).skip(hand);
            }
	}*/
        
        
        /* check in order of priorities */
        
        // skip check
        hand = game.skipCheck(hand);
        /* reverse will change our hand and return new pile */
        game.reverseCheck(hand, pile);

        // reverse check
        game.reverseCheck(hand, pile);
        
        // wild check
        game.wildCheck(hand);
        
        //pile.printDeck();
        System.out.print("After applying action cards: ");
        hand.displaySortedHand();

        // calculate exercises
        //for (int i: game.calculateExercises(hand)) { System.out.println(i);}
        game.calculateExercises(hand);
        
        
        // draw two check
            
            
        // wild draw four check
        
        //while (pile.cardPileAmount() != 0) {
            
            /* draw hand from pile */
            //Hand hand = new Hand(Pile);
            //hand.draw(); // draws 7, but if less will just draw rest of deck
        
            /* sort the Hand by colors then by rank */
            //hand.sortHand();
            
            /* display hand and any breaks associated */
            //hand.displaySortedHand();
            
            // NOTE: May be helpful to use example hands here 
            
            /* 
            display break if there is zero card 
            // NOTE: if multiple breaks, multiple minutes of break??
             if (hand.countItemByRank(Card.Ranks.ZERO) > 0) {
                 cSystem.out.println("One Minute Break..."); 
             }
            */
        
        //}
        
        
    }
    
}

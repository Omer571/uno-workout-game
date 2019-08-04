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
    
    private int tempsReps1 = 0;
    private int tempsReps2 = 0;
    private int tempsReps3 = 0;
    private int tempsReps4 = 0;
    
    private int totalExercise1 = 0;
    private int totalExercise2 = 0;
    private int totalExercise3 = 0;
    private int totalExercise4 = 0;
    
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
                System.out.println("Error - Number not 0 - 9, assuming number 1");
                return 1;
        }
        
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
        pile.shuffle();
        pile.printDeck();
        System.out.println(pile.cardPileAmount());
        
        
        //while (pile.cardPileAmount() != 0) {
            
            /* draw hand from pile */
            //Hand hand = new Hand(Pile);
            //hand.draw(); // draws 7, but if less will just draw rest of deck
        
            /* sort the Hand by colors then by rank */
            //hand.sortHand();
            
            /* display hand and any breaks associated */
            //hand.displaySortedHand();
            
            // NOTE: May be helpful to use example hands here 
            
            
            /* check in order of priorities */
            
            // skip check
            // All the cards of this color that are in the hand are discarded for this round
            // returns new hand object
            
            // draw two check
            // The Total number of the matching color is multiplied by 2
            // What is the total number of matching cards???? (like matching sets)
            
            // reverse check
            // All the matching color cards are to return to the bottom of the draw pile except “Reverse” (disard) card.
            
            // wild check
            // The presence of this card will add 4 Burpees to the round of exercises. 
            
            // wild draw four check
            // Adds4 the Burpeesand multipliesby 4 the total ofeachcolorin the hand.
            
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

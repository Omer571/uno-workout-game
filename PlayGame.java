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
    
    
    public static void main(String[] args) {
        
        PlayGame game = new PlayGame();
        game.actionCardsNotToUse.add(Card.Ranks.DRAWTWO);
        
        /* prompt for number of decks, prompt for action cards not to use, 
        shuffle together or not */
        
        
        /* create pile object */
        Pile pile = new Pile(1, game.actionCardsNotToUse, true);
        
        /* create and shuffle */
        pile.createDeck();
        pile.shuffle();
        pile.printDeck();
        
        while (pile.cardPileAmount() != 0) {
            /* draw hand from pile */
            //Hand hand = new Hand(Pile);
            //hand.draw();
        
            /* sort the Hand by colors then by rank */
            //hand.sortHand();

            /* display hand and any breaks associated */
            //hand.displaySortedHand();
        
        }
        
        
    }
    
}

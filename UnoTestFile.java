/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;


import java.util.ArrayList;

/**
 *
 * @author macbookretina2015
 */
public class UnoTestFile {
    
    public static void SystemTest() {
        
        System.out.println("\n*** System and Integration Testing On Small Test Deck ***");
        
        PlayGame game = new PlayGame();
        
        /* create pile object */
        Pile pile = new Pile(1, game.getActionNotToUseCards(), true);
        
        /* create pile and shuffle */
        pile.createTestDeck();
        
        /* create hand */
        Hand hand = new Hand();
        
        /* while the deck is not empty continue playing game */
        while (pile.deckQueue.getNumberOfElements() > 0) {
            
            /* draw, sort and display hand */
            hand.drawHand(pile);
            hand.sortHand();
           
            System.out.println();
            game.html_list.add("\n");
            hand.displaySortedHand(game.html_list);
            
            /* process the hand and check for action and wild cards */
            game.processHand(hand, pile);

            /* update the total reps with temporary reps from this hand */
            game.updateFinalReps();
            
            /* display hand one last time without action cards (FOR TESTING) */
            //hand.displaySortedHand();
            
            System.out.println();
            game.html_list.add("\n");
            
            /* display temporary reps from this hand */
            game.displayTempBurpeesCount();

            System.out.println();
            game.html_list.add("\n");
            
            game.displayTempReps();

            /* check for zero and display break */
            hand.isBreak();
            
            /* empty hand */
            hand.handLL.clear();
            
            /* tell the user the number of cards left */
            System.out.println("Number of cards left: " + pile.deckQueue.getNumberOfElements() + " \n");
            game.html_list.add("\nNumber of cards left: " + pile.deckQueue.getNumberOfElements() + " \n\n");
        }
        /* give total reps report */
        game.displayFinalReps();
        
        /* give hand calculated report */
        System.out.println("\n***Hand Calculated Report: ***");
        System.out.println("(RED) Push ups: 47");
        System.out.println("(GREEN) Squats: 86");
        System.out.println("(YELLOW) Sit ups: 12");
        System.out.println("(BLUE) Curls 4 da girlz: 0");
        System.out.println("There are 5 wild cards: 5 * 4 = 24 Burpees");
        System.out.println("Total Skipped Reps: 2");
        
        System.out.println("\nSYSTEM TEST PASSED. ALL OUTPUTS MATCHED HAND "
                + "CALCULATED EXAMPLE OUTPUT");
    }
        
    public static void main() {
        
        /* file to contain info */
        
        ArrayList<Card.Ranks> actionCardsNotToUse = new ArrayList<Card.Ranks>();
        actionCardsNotToUse.add(Card.Ranks.DRAWTWO);
        
        System.out.println("***** Class testing by performing Unit Tests *****\n");
        
        /* QUEUE TESTS */
        System.out.println("*** Testing Queue **\n");
        Queue q = new Queue();
        q.enqueue(new Card(Card.Colors.BLUE, Card.Ranks.EIGHT));
        System.out.println("Added Blue Eight");
        
        System.out.println("Current Queue: ");
        q.printQueue();
        
        q.enqueue(new Card(Card.Colors.RED, Card.Ranks.EIGHT));
        q.enqueue(new Card(Card.Colors.YELLOW, Card.Ranks.EIGHT));
        q.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.EIGHT));
        q.enqueue(new Card(Card.Colors.BLUE, Card.Ranks.EIGHT));
        System.out.println("\nAdded 4 new cards\n");
        
        System.out.println("Current Queue: ");
        q.printQueue();
        
        
        System.out.println("\nDequeue: " + q.dequeue().getColor() + " " + q.dequeue().getRank());
        
        System.out.println("Current Queue: ");

        q.printQueue();
        
        q.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.ONE));
        
        System.out.println("Current Queue: ");
        q.printQueue();
        
        System.out.println("\nDequeue: " + q.dequeue().getColor() + " " + q.dequeue().getRank());
        System.out.println("Dequeue: " + q.dequeue().getColor() + " " + q.dequeue().getRank() + "\n");
        //System.out.println("Dequeue: " + q.dequeue().getColor() + " " + q.dequeue().getRank());
        //System.out.println("Dequeue: " + q.dequeue().getColor() + " " + q.dequeue().getRank() + "\n");
       
        System.out.println("Current Queue: ");
        q.printQueue();
        
        System.out.print("Dequeue: ");
        q.dequeue();
        
        /* PILE TESTS */
        System.out.println("*** Testing Pile ***\n");
        
        System.out.println("** Testing Single Pile Shuffle **\n");
        Pile pile = new Pile();
        pile.createDeck();
        
        System.out.println("Pile Pre-Shuffle Together");
        pile.printDeck();
        System.out.println();
        
        System.out.println("Pile Post Shuffle\n");
        pile.printDeck();
        System.out.println();
        
        System.out.println("** Testing Multiple piles (shuffleTogether = false) **\n");
        
        Pile pile2 = new Pile(2, actionCardsNotToUse, false);
        pile2.createDeck();
        System.out.println("CardPile Amount should be 200 (drawtwo were removed): " + pile2.deckQueue.getNumberOfElements() + " cards in deck \n");
        pile2.shuffle();
        
        System.out.println("Tests Passed. First 108 Card were shuffled " +
                ", then Second 108 cards shuffled");
       
        /* HAND TESTS */
        System.out.println("\n*** Testing Hand and Action Card Functions ***\n");
       
        Hand hand = new Hand();
        
        hand.handLL.add(new Card(Card.Colors.BLUE, Card.Ranks.TWO));
        hand.handLL.add(new Card(Card.Colors.BLUE, Card.Ranks.ONE));
        hand.handLL.add(new ActionCard(Card.Colors.RED, Card.Ranks.SKIP));
        hand.handLL.add(new ActionCard(Card.Colors.BLUE, Card.Ranks.REVERSE));
        hand.handLL.add(new Card(Card.Colors.RED, Card.Ranks.EIGHT));
        hand.handLL.add(new Card(Card.Colors.RED, Card.Ranks.TWO));
        hand.handLL.add(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
        
        ArrayList<String> html_list = new ArrayList<String>();
        System.out.print("Before Sorting: ");
        hand.displaySortedHand(html_list);
        
        hand.sortHand();
        
        System.out.print("After Sorting: ");
        hand.displaySortedHand(html_list);
        System.out.println();
        
        System.out.println("Hand After Removing Skip Cards");
        PlayGame game = new PlayGame();
        hand = game.skipCheck(hand, pile);
        hand.displaySortedHand(html_list);
        System.out.println();
        
        System.out.println("Deck Amount Before Reverse: " + pile.cardPileAmount() + "\n");
         
        System.out.println("Hand After Reverse Function");
       
        game.reverseCheck(hand, pile);
        hand.displaySortedHand(html_list);
        System.out.println("\nDeck Amount After Reverse: " + pile.cardPileAmount() + "\n");
        
        System.out.println("Tests Passed, all red cards removed and reverse "
                + "color cards successfully returned to deck");
        
        
        SystemTest();
    }


}

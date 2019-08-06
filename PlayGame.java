/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;


import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.util.ArrayList;


// TODO BASIC:
//CLEAN THE CODE INTO FUNCTIONS AND ADD CLASS
//DO DOCUMENTATION

// TODO TESTING:
// WRITE MULTIPLE TEST CASES FOR EACH CLASS (MAIN METHOD) AND PRINT TO TEXT FILE 
// HTML OF FULL SYSTEM TEST 

// TODO EXTRA CREDIT:
//GUI
//TEXTFILE AND/OR HTML FILE (CHECK)

// TODO UML:
//UML DIAGRAM

// break into functions: initilize game, playgame, final report
// write one more class to startgame

/**
 *
 * @author macbookretina2015
 */
public class PlayGame {
    
    /* max cards per deck constant */
    final static int CARDSPERDECK = 108; 
    
    /* number of decks to use */
    private int numberOfDecks;
    
    /* array list of action cards not to use */
    private ArrayList<Card.Ranks> actionCardsNotToUse = new ArrayList<Card.Ranks>();
    
    /* burpees counters */
    private int tempBurpeesCount;
    private int totalBurpeesCount = 0;
    
    /* reps counters */
    private int[] tempsReps = {0,0,0,0};
    private int[] totalExerciseReps = {0,0,0,0};
    
    /* html string list for writing */
    ArrayList<String> html_list = new ArrayList<String>();
    
    /* reps that are avoided due to skip action cards */
    private int tempSkipCount;
    private int totalSkipCount = 0;
    
    /* exercises for each color */
    private String[] exercises = {"(RED) Push ups: ","(GREEN) Squats: ","(YELLOW) Sit ups: ","(BLUE) Curls 4 da girlz: "};
    
    /**
     * This method converts type Card.Ranks into type integers
     * @param rank The rank to convert
     * @return The converted rank as integer
     */
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

    
    public void drawTwoCheck(Hand hand) {
        
        ActionCard drawTwoCard = new ActionCard();
        boolean drawTwoFound = false;
        
        for (Card curCard: hand.handLL) {
            if (curCard.getRank() == Card.Ranks.DRAWTWO) {

                drawTwoCard.drawTwo(hand, this.tempsReps);
                drawTwoFound = true;
                break;
            }
        }
        
        if (drawTwoFound) {
            drawTwoCard.displayDrawTwo();
        }
    }
      
    // All the cards of this color that are in the hand are discarded for this round
    // returns new hand object with the cards left after using skip
    public Hand skipCheck(Hand hand, Pile pile) {
        
        /* hand array to capture skipHand output */
        Hand[] handArray = new Hand[2];
        
        /* hand to hold hand with skipped exercises */
        Hand handWithSkippedExercises = new Hand();
        
        boolean skipFound = false;
        ActionCard skipCard = new ActionCard();
        
        for (int i = 0; i < hand.handLL.size(); i++) {
            if (hand.handLL.get(i).getRank() == Card.Ranks.SKIP) {
                
                skipFound = true;
                
                /* new updated hand */
                handArray = ((ActionCard) hand.handLL.get(i)).skip(hand);
                
                /* hand with skipped exercises returned and counted */
                hand = handArray[0];
                
                for (Card curCard: handArray[1].handLL) {               
                    handWithSkippedExercises.handLL.add(curCard);
                }
                
                /* hand is changed so start at beginning to not miss elements */
                i = -1;
            }

	}
      
            
        if (skipFound == true) {
            skipCard.displaySkip();
            
            /* calculate skipped hand cards */
            //System.out.print("Skipped Hand: ");
            //handWithSkippedExercises.displaySortedHand();
            /* call function to runHandFunctions */
            this.processSkippedHand(handWithSkippedExercises, pile);
        }
        return hand;
    }
    
    /**
     * Checks for reverse card in hand, and if present calls reverse function 
     * in hand class to return cards to pile 
     * @param hand
     * @param pile
     * @return 
     */
    public Pile reverseCheck(Hand hand, Pile pile) {
        
        boolean reverseFound = false;
        ActionCard reverseCard = new ActionCard();
        
        for (int i = 0; i < hand.handLL.size(); i++) {
            
            if (hand.handLL.get(i).getRank() == Card.Ranks.REVERSE) {
                
                reverseCard.setCard(hand.handLL.get(i));
                reverseFound = true;
                
                //System.out.println("Reverse Found: " + hand.handLL.get(i).getColor()+ " " + hand.handLL.get(i).getRank());
                pile = hand.handReverse(pile);
                
                // hand.handReverse changes hand, so we must go back through 
                // entire new hand and check for reverses
                // Solution: i = 0 restart loop, but be careful with this
                
                /* since hand is changed, restart from beginning to find reverses */
                
                i = -1;
                
            } //else { System.out.println("Not Reverse Found: " + hand.handLL.get(i).getColor()+ " " + hand.handLL.get(i).getRank());}
            
	}
        
        if (reverseFound == true) {
            reverseCard.displayReverse();
        }
                    
        return pile;
    }
    
    /**
     * This method checks for wild cards and if found it will call the wild card
     * function in class wild card and also print effect of wild card
     * @param hand The hand that may contain wild cards
     */
    public void wildCheck(Hand hand) {
        
        boolean wildCardFound = false;
        WildCard wildCard = new WildCard();
        this.tempBurpeesCount = 0;
        
        for (int i = 0; i < hand.handLL.size(); i++) {
            
            if (hand.handLL.get(i) instanceof WildCard) {
                
                wildCardFound = true;
                this.tempBurpeesCount += 4;
                
            }
	}
        
        this.totalBurpeesCount += this.tempBurpeesCount;
        
        if (wildCardFound == true) {
            //this.tempBurpeesCount = wildCard.displayWildEffects(hand);
            wildCard.displayWild();
        }
    }
   

    
    public void wild4Check(Hand hand) {
        
        WildCard wildCard = new WildCard();
        boolean wild4Found = false;
        
        for (Card curCard: hand.handLL) {
            
            if (curCard.getRank() == Card.Ranks.WILDFOUR) {
                wildCard.Wild4(hand, this.tempsReps);
                wild4Found = true;
            }
        }
        
        if (wild4Found) {
            wildCard.displayWildFour();
        }
    }

    /**
     * After sorting the hand by color and rank we calculate exercises
     * @param hand
     * @return int[] This returns an integer list of the reps
     */
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
    
    public void updateFinalReps() {
        for (int i = 0; i < 4; i++) {
            this.totalExerciseReps[i] += this.tempsReps[i];
        }
    }
    
    public void displayFinalReps() {
        
        System.out.println("\n*** FINAL EXERCISE REPORT ***");    
        this.html_list.add("\n*** FINAL EXERCISE REPORT ***\n");
        
        for (int i = 0; i < 4; i++) {
            System.out.println(this.exercises[i] + this.totalExerciseReps[i]);
            this.html_list.add(this.exercises[i] + this.totalExerciseReps[i] + "\n");
        }
        
        System.out.println("Burpees: " + this.totalBurpeesCount);
        this.html_list.add("Burpees: " + this.totalBurpeesCount + "\n");
        
        System.out.println("Total Skipped Reps: "+ this.totalSkipCount);
        this.html_list.add("Total Skipped Reps: "+ this.totalSkipCount + "\n");
    }
    
    public void displayTempReps() {
        for (int i = 0; i < 4; i++) {
            System.out.println(this.exercises[i] + this.tempsReps[i]);
            this.html_list.add(this.exercises[i] + this.tempsReps[i] + "\n");
        }
        
    }
    
    public void displayTempBurpeesCount() {
        System.out.println("Burpees: " + this.tempBurpeesCount);
        this.html_list.add("Burpees: " + this.tempBurpeesCount + "\n");
    }
    
    public void processHand(Hand hand, Pile pile) {
            /* check in order of priorities */
            // skip check
            hand = this.skipCheck(hand, pile);
            
            // reverse check
            this.reverseCheck(hand, pile);

            // wild check
            this.wildCheck(hand);
            
            // calculate exercises
            this.tempsReps = this.calculateExercises(hand);
            
            // draw two check
            this.drawTwoCheck(hand);

            // wild draw four check
            this.wild4Check(hand);
    }
    
    public void processSkippedHand(Hand hand, Pile pile) {
            /* check in order of priorities */
            // skip check
            
            this.tempSkipCount = 0;

            // calculate exercises
            int[] skippedReps = this.calculateExercises(hand);
            
            /* add skippedReps and store in tempSkippedReps */
            for (int i = 0; i < 4; i++) {
                //System.out.println(skippedReps[i]);
                this.tempSkipCount += skippedReps[i];
            }
            
            // draw two check
            this.drawTwoCheck(hand);
            
            /* update total skip count */
            
            this.totalSkipCount += this.tempSkipCount;
            //System.out.println(this.totalSkipCount);
    }
    
    public void writeHTML() {
        
        /* write html list to html */
        File file = new File("UNO HTML");
        
        try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                
                for (String line: this.html_list) {
                    bw.write(line);
                }
                bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    //main function for testing
    public /*static*/ void main(String[] args) {
        
        /* make a game */
        PlayGame game = new PlayGame();
        
        /* prompt for number of decks, action cards not to use, and shuffle together */
        //TODO
        
        //game.actionCardsNotToUse.add(Card.Ranks.DRAWTWO);
        
        /* create pile object */
        Pile pile = new Pile(1, game.actionCardsNotToUse, true);
        
        /* create pile and shuffle */
        pile.createDeck();
        pile.shuffle();
        
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
            
            game.processHand(hand, pile);

            /* update the total reps with final temporary reps */
            game.updateFinalReps();
            
            /* display hand one last time without action cards (FOR TESTING) */
            //hand.displaySortedHand();
            
            /* display final (temp) reps for this hand */
            System.out.println();
            game.html_list.add("\n");
            
            game.displayTempBurpeesCount();
            
            System.out.println();
            game.html_list.add("\n");
            
            game.displayTempReps();

            /* check for zero and display break */
            hand.isBreak();
            
            /* empty hand */
            hand.handLL.clear();
            
            System.out.println("Number of cards left: " + pile.deckQueue.getNumberOfElements() + " \n");
            game.html_list.add("\nNumber of cards left: " + pile.deckQueue.getNumberOfElements() + " \n\n");
        }

        /* give total reps report */
        game.displayFinalReps();
        
        /* write html */
        game.writeHTML();
        
    }
    
    
    
}

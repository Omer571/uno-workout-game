/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;


import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Character.toUpperCase;


import java.util.ArrayList;
import java.util.Scanner;


// TODO BASIC:
//CLEAN THE CODE INTO FUNCTIONS AND ADD CLASS
//DO DOCUMENTATION

// TODO TESTING:
/*Internal and External documentation, including. The header on each file, Class, Method and
Parameter descriptions.
• Test cases for each of the classes and their methods, these test cases need to be included in
your code, for example, a main method in the class file. 
// WRITE MULTIPLE TEST CASES FOR EACH CLASS (MAIN METHOD) AND PRINT TO TEXT FILE 
// HTML OF FULL SYSTEM TEST 

// TODO EXTRA CREDIT:
//GUI

// TODO UML:
//UML DIAGRAM
• UML Class Diagrams for every class you modeled in the project (Updated version).

// break into functions: initilize game, playgame, final report
// write one more class to startgame

/**
 * 
 * @author sundeep
 */
public class PlayGame {
    
    /* max cards per deck constant */
    final static int CARDSPERDECK = 108; 
    
    /* number of decks to use */
    private int numberOfDecks;
   
    /* burpees counters */
    private int tempBurpeesCount;
    private int totalBurpeesCount = 0;
    
    /* reps counters */
    private int[] tempsReps = {0,0,0,0};
    private int[] totalExerciseReps = {0,0,0,0};
     
    /* reps that are avoided due to skip action cards */
    private int tempSkipCount;
    private int totalSkipCount = 0;
    
    /* array list of action cards not to use */
    private ArrayList<Card.Ranks> actionCardsNotToUse = new ArrayList<Card.Ranks>();
    
    /* html string list for writing */
    ArrayList<String> html_list = new ArrayList<String>();
    
    /* exercises for each color */
    private String[] exercises = {"(RED) Push ups: ","(GREEN) Squats: ","(YELLOW) Sit ups: ","(BLUE) Curls 4 da girlz: "};
    
    public ArrayList<Card.Ranks> getActionNotToUseCards() {
        return this.actionCardsNotToUse;
    }
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
    
    /**
     * 
     * Checks for skip card and runs skip function and displays skip action if 
     * skip found
     * @param hand
     * @param pile
     * @return new hand object with the cards left after using skip
     */
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
     * 
     * this method checks for presence draw two card in the hand
     * if found it displays the function of draw two
     * @param hand that may contain draw two cards
     */
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
      
    /**
     * Checks for reverse card in hand, and if present calls reverse function 
     * in hand class to return cards to pile 
     * @param hand that may contain reverse cards
     * @param pile
     * @return if found returns the cards of that color back to pile
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
   

    /**
     This method checks for wildFour cards and if found it will call the wildFour card
     * function in class wildFour card and also print effect of wildFour card
     * @param hand The hand that may contain wildFour cards 
     */
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
    //upates total reps done in every hand for  final re[ort
    public void updateFinalReps() {
        for (int i = 0; i < 4; i++) {
            this.totalExerciseReps[i] += this.tempsReps[i];
        }
    }
    
    /**
     *Displays final report of the reps finished
     */
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
    
    /**
     * Displays reps to be done in each hand by kind
     */
    public void displayTempReps() {
        for (int i = 0; i < 4; i++) {
            System.out.println(this.exercises[i] + this.tempsReps[i]);
            this.html_list.add(this.exercises[i] + this.tempsReps[i] + "\n");
        }
        
    }
    
    /**
     * Displays the burpees done for this hand
     */
    public void displayTempBurpeesCount() {
        System.out.println("Burpees: " + this.tempBurpeesCount);
        this.html_list.add("Burpees: " + this.tempBurpeesCount + "\n");
    }
    
    /**
     * processes the hand for calculating the exercises
     * @param hand
     * @param pile 
     */
    public void processHand(Hand hand, Pile pile) {
            
            // skip check
            hand = this.skipCheck(hand, pile);
            
            this.reverseCheck(hand, pile);

            this.wildCheck(hand);
            
            // calculate exercises
            this.tempsReps = this.calculateExercises(hand);
           
            this.drawTwoCheck(hand);

            this.wild4Check(hand);
    }
    
    /**
     * 
     * this gets the total reps skipped in the game
     * @param hand
     * @param pile 
     */
    public void processSkippedHand(Hand hand, Pile pile) {
            
            this.tempSkipCount = 0;

            /* calculate exercises */
            int[] skippedReps = this.calculateExercises(hand);
            
            /* add skippedReps and store in tempSkippedReps */
            for (int i = 0; i < 4; i++) {
                //System.out.println(skippedReps[i]);
                this.tempSkipCount += skippedReps[i];
            }
            
            /* check for draw twos */
            this.drawTwoCheck(hand);
            
            /* update total skip count */
            this.totalSkipCount += this.tempSkipCount;

    }
    
    /**
     * This method writes the output from consol to HTML in this project
     */
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
    public static void main(String[] args) {
        /* question answers */
        char shuffledTogetherChar = 'Y';
        boolean shuffledTogetherBoolean;
        int numberOfDecks = 1;
        String actionCardsNotToUseString;
        
        /* scanner object */
        Scanner input = new Scanner(System.in);
        
        /* make a game */
        PlayGame game = new PlayGame();
        
        /* prompt for shuffle together */
        System.out.print("Would you like decks shuffled together? (Y/N): ");
        shuffledTogetherChar = input.next().charAt(0);
        if (toUpperCase(shuffledTogetherChar) == 'Y') {
            shuffledTogetherBoolean = true;
        } else { shuffledTogetherBoolean = false; }
        
        /* prompt for number of decks */ 
        System.out.print("Enter Number of Decks (1-3): ");
        numberOfDecks = input.nextInt();
        
        /* prompt for action cards to not use */
        System.out.print("What actions do you NOT want to use? (Options: "
                + "SKIP, DRAWTWO, REVERSE): ");
        actionCardsNotToUseString = input.next();
        
        switch (actionCardsNotToUseString) {
            case "SKIP":
                game.actionCardsNotToUse.add(Card.Ranks.SKIP);
                break;
            case "DRAWTWO":
                game.actionCardsNotToUse.add(Card.Ranks.DRAWTWO);
                break;
            case "REVERSE":
                game.actionCardsNotToUse.add(Card.Ranks.REVERSE);
                break;
        }
        
        //game.actionCardsNotToUse.add(Card.Ranks.DRAWTWO);
        
        /* create pile object */
        Pile pile = new Pile(numberOfDecks, game.actionCardsNotToUse, shuffledTogetherBoolean);
        
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
        
        /* write html */
        game.writeHTML();
        System.out.println("\nHTML File is created in local directory: UNO HTML");
        
    }
    
    
    
}

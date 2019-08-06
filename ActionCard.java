/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

/**
 *
 * @author macbookretina2015
 */
public class ActionCard extends Card {
    
    protected ActionCard.Ranks rank;

    public ActionCard(Colors color, Card.Ranks rank) {
        super(color, rank);
    }
    
    public ActionCard() {
        super();
    }
    
    @Override
    public ActionCard getCard() {
        ActionCard copy = this;
        return copy;
    }
    
    /**
     * All the cards of this color that are in the hand are discarded 
     * for this round
     * @param hand The hand object we are working with 
     * @return Hand This returns new hand after skip performed
     */
    public Hand[] skip(Hand hand) {
        
        /* new hand array to return hand with and without skip colors */
        Hand[] handArray = new Hand[2];
        
        /* hand after skip applied */
        Hand handWithSkip = new Hand();
        
        /* hand with cards that are the same color as skip color */
        /* these are needed to calculate the reps that were skipped */
        Hand handWithSkippedExercises = new Hand();
        
        /* initialize color for compiler */
        Card.Colors color = Card.Colors.RED;
        
        boolean skipCardFound = false;
        
        /* iterate through and find skip card's color */
        for (Card curCard: hand.handLL) {
            if (curCard.getRank() == Card.Ranks.SKIP) {
                color = curCard.getColor();
                skipCardFound = true;
                break;
            }
        }
        
        if (skipCardFound == true) {
            
            for (Card curCard: hand.handLL) {
                /* only add cards of different color of skip */
                if (curCard.getColor() != color) {
                    handWithSkip.handLL.add(curCard);
                }
                /* else add only cards of same color as skipp not including skip */
                else if (curCard.getRank() != Card.Ranks.SKIP){
                    handWithSkippedExercises.handLL.add(curCard);
                }
                
            }
            
            /* if skip card was found then return new hands */
            handArray[0] = handWithSkip;
            handArray[1] = handWithSkippedExercises;
            return handArray;
        } 
        
        /* if skip card not found then return original hand and empty hand */
        handArray[0] = hand;
        handArray[1] = handWithSkippedExercises;
        return handArray;

        
    }
    
    /**
     * The Total number of the matching color is multiplied by 2
     * @param hand The hand object we are working with 
     * @return Hand
     */
    public void drawTwo(Hand hand, int[] repsList) {
        
        Card.Colors color;
        for (Card curCard: hand.handLL) {
            if (curCard.getRank() == Card.Ranks.DRAWTWO) {
                color = curCard.getColor();
                
                switch (color) {
                    case RED:
                        repsList[0] *= 2;
                        break;
                    case GREEN:
                        repsList[1] *= 2;
                        break;
                    case YELLOW:
                        repsList[2] *= 2;
                        break;
                    case BLUE:
                        repsList[3] *= 2;
                        break;
                        
                }
            }
        }
    }
    
    /**
     * All the matching color cards are a return to the bottom of the draw 
     * pile except “Reverse”card. 
     * @param hand The hand object we are working with 
     * @param pile The pile object we are working with
     * @return Pile This returns the pile, BUT WE NEED TO ALSO EDIT HAND
     */
    public Pile reverse(Hand hand, Pile pile) {
        pile = hand.handReverse(pile);
        return pile;
    }
    
    /**
     * Displays the effect of the skip card
     */
    public void displaySkip() {
        System.out.println("Skip Card - All the cards of this skip's color that "
                + "are in the hand are discarded for this round");
    }
    
    /**
     * Displays the effect of the draw two
     */
    public void displayDrawTwo() {
        System.out.println("DrawTwo Card - The Total number of the matching "
                + "color is multiplied by 2");
    }
    
    /**
     * Displays the effect of the display reverse
     */
    public void displayReverse() {
        System.out.println("Reverse Card - All the matching color cards are a " 
                + " return to the bottom of the draw pile except"
                + " “Reverse\" card");
    }
    
    
    public /*static*/ void main(String[] args) {
        
        Pile deck = new Pile();
        ActionCard actionCard = new ActionCard();
        
        deck.deckQueue.enqueue(new ActionCard(Card.Colors.YELLOW, Card.Ranks.SKIP));
        deck.deckQueue.enqueue(new ActionCard(Card.Colors.YELLOW, Card.Ranks.ONE));
        deck.deckQueue.enqueue(new ActionCard(Card.Colors.YELLOW, Card.Ranks.TWO));
        deck.deckQueue.enqueue(new ActionCard(Card.Colors.RED, Card.Ranks.TWO));
        
        System.out.println("*** ActionCard Class - Testing Display Function ***");
        
        actionCard.displayDrawTwo();
        actionCard.displayReverse();
        actionCard.displaySkip();
        
        
    }

}

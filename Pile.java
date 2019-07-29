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
class Pile {
    
    final static int CARDSPERDECK = 108;
    private Card[] deck;
    private boolean shuffleTogether;
    private int amount = 0;
    int numberOfDecks;
    

    Pile(int numberOfDecks, String[] actionCardsToUses, boolean shuffleTogether) {
        this.numberOfDecks = numberOfDecks;
        this.deck = new Card[CARDSPERDECK * numberOfDecks];
        this.amount = CARDSPERDECK * numberOfDecks;
        this.shuffleTogether = shuffleTogether;
    }
    
    Pile() {
        this.numberOfDecks = 1;
        this.amount = CARDSPERDECK;
        this.deck = new Card[CARDSPERDECK];
        this.shuffleTogether = true;
        
        /* make an initialize function with this body */
        Card card = new Card();
        card.setColor(" no color");
        card.setRank(-1);
        for (int i = 0; i < this.amount; i++) {
            this.deck[i] = card;
        }
    }
    
    public void createDeck() {
        // There are 76 Number cards, 24 Action cards and 8 Wild cards.
        
        // for number of decks
        for (int i = 0; i < this.numberOfDecks; i++) {
            //System.out.println("In first loop");
            int cardNum = 0;
            int colorCounter = 0;
            String[] colors = {"red", "green", "blue", "yellow"};
            for (int j = 0; j < 76; j++) {
                //System.out.println("In second loop");
                cardNum %= 10;
                colorCounter %= 4;
                this.deck[j].setRank(cardNum++);
                //System.out.println("set rank");
                this.deck[j].setColor(colors[colorCounter++]);
                //System.out.println("set color");
                System.out.println(this.deck[j].getRank() + " " + this.deck[j].getColor());
            }
            
            colorCounter = 0;
            for (int j = 0; j < 24; j++) {
                
            }
        
        }
    }
    
    public void printDeck() {
        for (int j = 0; j < CARDSPERDECK * this.numberOfDecks; j++) {
            System.out.println(this.deck[j].getRank() + " " + this.deck[j].getColor());
        }
    }
            
    public int cardPileAmount() {
        return amount;
    }
    
    
    public static void main(String[] args) {
        Pile pile = new Pile();
        pile.createDeck();
        pile.printDeck();
    }
    
    
    
}

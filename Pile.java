/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: 
// Split createDeck into seperate functions (maybe)
// Documentation

/**
 * 
 * @author sundeep
 */
 
class Pile {
    private boolean shuffleTogether;
    private Random random;  // random object for shuffeTogether
    private int amount = 0;
    int numberOfDecks;
    final static int CARDSPERDECK = 108;
    
    
    private ThreadLocalRandom random2;  // random object for shuffle seperate
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<Card.Ranks> actionCardsNotToUse;
    
    public Queue deckQueue = new Queue();
    
    /**
     * constructor for deck
     */

      
    Pile(int numberOfDecks, ArrayList<Card.Ranks> actionCardsNotToUse, boolean shuffleTogether) {
        
        /* make sure number of decks is right */
        if (numberOfDecks > 3 || numberOfDecks < 1) {
            this.numberOfDecks = 1;
        }
        
        this.actionCardsNotToUse = actionCardsNotToUse;
        this.numberOfDecks = numberOfDecks;
        this.shuffleTogether = shuffleTogether;
    }
    
    Pile() {
        this.numberOfDecks = 1;
        this.shuffleTogether = true;
        actionCardsNotToUse = new ArrayList<Card.Ranks>();
    }
    /**
     * 
     * 
     * @param num
     * @return  returns ranks for the numbers in the card
     */
    private Card.Ranks intToRank(int num) {
        
        switch (num) {
            case 0:
                return Card.Ranks.ZERO;
            case 1:
                return Card.Ranks.ONE;
            case 2:
                return Card.Ranks.TWO;
            case 3:
                return Card.Ranks.THREE;
            case 4:
                return Card.Ranks.FOUR;
            case 5:
                return Card.Ranks.FIVE;
            case 6:
                return Card.Ranks.SIX;
            case 7:
                return Card.Ranks.SEVEN;
            case 8:
                return Card.Ranks.EIGHT;
            case 9:
                return Card.Ranks.NINE;
            
            default:
                return Card.Ranks.NINE;
        }
        
    }
    
    public void createTestDeck() {
        
        this.deckQueue.enqueue(new Card(Card.Colors.RED, Card.Ranks.ZERO));
        this.deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
        this.deckQueue.enqueue(new Card(Card.Colors.YELLOW, Card.Ranks.ONE));
        this.deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.DRAWTWO));
        this.deckQueue.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.THREE));
        this.deckQueue.enqueue(new Card(Card.Colors.BLUE, Card.Ranks.REVERSE));
        this.deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
        
        this.deckQueue.enqueue(new Card(Card.Colors.YELLOW, Card.Ranks.TWO));
        this.deckQueue.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.FIVE));
        this.deckQueue.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.SIX));
        this.deckQueue.enqueue(new Card(Card.Colors.RED, Card.Ranks.NINE));
        this.deckQueue.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.FIVE));
        this.deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILDFOUR));
        this.deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.DRAWTWO));
        this.deckQueue.enqueue(new Card(Card.Colors.RED, Card.Ranks.TWO));
        this.deckQueue.enqueue(new ActionCard(Card.Colors.RED, Card.Ranks.SKIP));
        
        this.deckQueue.enqueue(new Card(Card.Colors.RED, Card.Ranks.ZERO));
        this.deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
        this.deckQueue.enqueue(new Card(Card.Colors.YELLOW, Card.Ranks.ONE));
        this.deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.DRAWTWO));
        this.deckQueue.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.THREE));
        this.deckQueue.enqueue(new Card(Card.Colors.BLUE, Card.Ranks.REVERSE));
        this.deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
        
        this.deckQueue.enqueue(new Card(Card.Colors.YELLOW, Card.Ranks.TWO));
        this.deckQueue.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.FIVE));
        this.deckQueue.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.SIX));
        this.deckQueue.enqueue(new Card(Card.Colors.RED, Card.Ranks.NINE));
        this.deckQueue.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.FIVE));
        this.deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
        this.deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.DRAWTWO));
        this.deckQueue.enqueue(new Card(Card.Colors.RED, Card.Ranks.TWO));
        this.deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.SKIP));
        
    }
    
    /**
     * There are 76 Number cards, 24 Action cards and 8 Wild cards
     * Each color contains 19 cards, one number 0 card and two sets of cards numbered 1 - 9
     * There are two of each action card in each color: Draw 2, Reverse and Skip
     * There are 4 of each kind of Wild Cards
     * creating decks and queuing the cards
     * 
     */
    public void createDeck() {
        
        
        
        for (int j = 0; j < this.numberOfDecks; j++) {
            
            // wild and wild draw 4 cards 
                deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
                deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILDFOUR));

                deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
                deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILDFOUR));

                deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
                deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILDFOUR));

                deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILD));
                deckQueue.enqueue(new WildCard(Card.Colors.NONE, Card.Ranks.WILDFOUR));
                
                this.amount += 8;
            
            // draw two cards
            if (!this.actionCardsNotToUse.contains(Card.Ranks.DRAWTWO)) {

                deckQueue.enqueue(new ActionCard(Card.Colors.RED, Card.Ranks.DRAWTWO));
                deckQueue.enqueue(new ActionCard(Card.Colors.RED, Card.Ranks.DRAWTWO));

                deckQueue.enqueue(new ActionCard(Card.Colors.YELLOW, Card.Ranks.DRAWTWO));
                deckQueue.enqueue(new ActionCard(Card.Colors.YELLOW, Card.Ranks.DRAWTWO));

                deckQueue.enqueue(new ActionCard(Card.Colors.GREEN, Card.Ranks.DRAWTWO));
                deckQueue.enqueue(new ActionCard(Card.Colors.GREEN, Card.Ranks.DRAWTWO));

                deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.DRAWTWO));
                deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.DRAWTWO));

                this.amount += 8;
            }


            // reverse cards
            if (!this.actionCardsNotToUse.contains(Card.Ranks.REVERSE)) {

                deckQueue.enqueue(new ActionCard(Card.Colors.RED, Card.Ranks.REVERSE));
                deckQueue.enqueue(new ActionCard(Card.Colors.RED, Card.Ranks.REVERSE));

                deckQueue.enqueue(new ActionCard(Card.Colors.YELLOW, Card.Ranks.REVERSE));
                deckQueue.enqueue(new ActionCard(Card.Colors.YELLOW, Card.Ranks.REVERSE));

                deckQueue.enqueue(new ActionCard(Card.Colors.GREEN, Card.Ranks.REVERSE));
                deckQueue.enqueue(new ActionCard(Card.Colors.GREEN, Card.Ranks.REVERSE));

                deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.REVERSE));
                deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.REVERSE));

                this.amount += 8;
            }

            // skip cards
            if (!this.actionCardsNotToUse.contains(Card.Ranks.SKIP)) {

                deckQueue.enqueue(new ActionCard(Card.Colors.RED, Card.Ranks.SKIP));
                deckQueue.enqueue(new ActionCard(Card.Colors.RED, Card.Ranks.SKIP));

                deckQueue.enqueue(new ActionCard(Card.Colors.YELLOW, Card.Ranks.SKIP));
                deckQueue.enqueue(new ActionCard(Card.Colors.YELLOW, Card.Ranks.SKIP));

                deckQueue.enqueue(new ActionCard(Card.Colors.GREEN, Card.Ranks.SKIP));
                deckQueue.enqueue(new ActionCard(Card.Colors.GREEN, Card.Ranks.SKIP));

                deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.SKIP));
                deckQueue.enqueue(new ActionCard(Card.Colors.BLUE, Card.Ranks.SKIP));

                this.amount += 8;
            }

            // zero cards
            deckQueue.enqueue(new Card(Card.Colors.RED, Card.Ranks.ZERO));
            deckQueue.enqueue(new Card(Card.Colors.YELLOW, Card.Ranks.ZERO));
            deckQueue.enqueue(new Card(Card.Colors.GREEN, Card.Ranks.ZERO));
            deckQueue.enqueue(new Card(Card.Colors.BLUE, Card.Ranks.ZERO));

            // reds 1-9
            for (int i = 1; i < 10; i++) {
                // TODO working on converting rank int to type ranks
                deckQueue.enqueue(new Card(Card.Colors.RED, intToRank(i)));
                deckQueue.enqueue(new Card(Card.Colors.RED, intToRank(i)));
            }

            // yellows 1-9
            for (int i = 1; i < 10; i++) {
                deckQueue.enqueue(new Card(Card.Colors.YELLOW, intToRank(i)));
                deckQueue.enqueue(new Card(Card.Colors.YELLOW, intToRank(i)));
            }

            // greens 1-9
            for (int i = 1; i < 10; i++) {
                deckQueue.enqueue(new Card(Card.Colors.GREEN, intToRank(i)));
                deckQueue.enqueue(new Card(Card.Colors.GREEN, intToRank(i)));
            }

            // blues 1-9
            for (int i = 1; i < 10; i++) {
                deckQueue.enqueue(new Card(Card.Colors.BLUE, intToRank(i)));
                deckQueue.enqueue(new Card(Card.Colors.BLUE, intToRank(i)));
            }

            // update amount
            this.amount += 76;  // change to constant later
        }
    }
    /**
     * 
     * creating a shuffle function for multiple decks
     */
    public void shuffle() {
        
        random = new Random();
        Card tempCard = new Card();
        
        /* if user wants to shuffle together, shuffle whole deck */
        if (this.shuffleTogether == true) {
            for (int i = deckQueue.getHead(); i < (this.cardPileAmount() + deckQueue.getHead()); i++) {
            
                /* get two random positions in deck */
                int pos1 = random.nextInt(this.cardPileAmount());
                int pos2 = random.nextInt(this.cardPileAmount());

                /* swap positions one and two */
                tempCard = deckQueue.get(pos1);
                deckQueue.set(pos1, deckQueue.get(pos2));
                deckQueue.set(pos2, tempCard); 
            }
        /* else shuffle one deck at a time */
        } else { 
            
            int i = deckQueue.getHead();
            int numberOfDecksToShuffle = this.numberOfDecks;
            
            while (numberOfDecksToShuffle != 0) {
                /* the starting position of the deck being shuffled this iteration */
                // example: first iteration: 0, second iteration: 108 ....
                int deckIndex = i;
                for (; i < (deckQueue.getHead() + this.cardPileAmount()) / numberOfDecksToShuffle; i++) {
            
                    /* get two random positions in deck */
                    int pos1 = random2.current().nextInt(deckIndex, (deckQueue.getHead() + this.cardPileAmount()) / numberOfDecksToShuffle);
                    int pos2 = random2.current().nextInt(deckIndex, (deckQueue.getHead() + this.cardPileAmount()) / numberOfDecksToShuffle);

                    /* swap positions one and two */
                    tempCard = deckQueue.get(pos1);
                    deckQueue.set(pos1, deckQueue.get(pos2));
                    deckQueue.set(pos2, tempCard); 
                }
                this.printDeck();
                System.out.println("\n");
                numberOfDecksToShuffle--;
                
                /* 
                
                just to check print and check decks are being shuffled seperate 
                
                System.out.println("Deck: ");
                printDeck();
                System.out.println("\n\n"); 
                
                */
            }
   
        }
    
    }

    
    public void printDeck() {
        deckQueue.printQueue();
    }
        /**
         * 
         * @return number of cards present for the game,
         * based on user choices
         */    
    public int cardPileAmount() {
        return this.deckQueue.getNumberOfElements();
}
    
    
    
    
   
    
}

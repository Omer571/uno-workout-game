/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Card;
import static java.util.Comparator.comparing;

import java.util.Objects;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author sundeep
 */

 public class Hand implements Comparable<Hand>{
    
     private String color;
     private String rank;
     private Pile pile;
    
    public LinkedList<Card> handLL = new LinkedList<Card>();
    
       
 /* puts cards in hand */
    public void drawHand(Pile pile) {
        /*Card[] hand = new Card[7];
    for (int j = 0; j < 7; j += 1)
    {
        int index = rand.nextInt(52-j);
        hand[j] = deck[index];
    }
    return hand;*/
       //dequeue for seven times a for loop
        //call  card pile amount
    }
 
    public void sortByRank() {
        
        Hand sortedHand = new Hand();
        Card.Colors[] colors = {Card.Colors.RED,Card.Colors.GREEN, Card.Colors.YELLOW, Card.Colors.BLUE};
        
        for (Card.Colors color: colors) {
            /* Skip first */
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.SKIP && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }

            /* Draw Two second */
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.DRAWTWO && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }

            /* Reverse third */
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.REVERSE && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }

            /* Wild fourth */
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.WILD && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }

            /* Wild4 fifth */
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.WILDFOUR && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }

            /* 9 - 0 */
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.NINE && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.EIGHT && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.SEVEN && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.SIX && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.FIVE && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.FOUR && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.THREE && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.TWO && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.ONE && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
        }
        this.handLL = sortedHand.handLL;
        sortedHand = new Hand();
    }
    
    public void sortByColor() {
        
    }
    
    public void sortHand() {
      
        Hand sortedHand = new Hand();
        Card[] cards = new Card[2];
        /* set iterator(s) to keep track of position in hand linked list */
        ListIterator<Card> colorListIterator = handLL.listIterator();
        ListIterator<Card> iterator = handLL.listIterator();
        
        /* sort hand by color */
        
        /* start with reds */
        for (Card curCard: this.handLL) {
            if (curCard.getColor() == Card.Colors.RED) {
                sortedHand.handLL.add(curCard);
                
            } 
        }
        for (Card curCard: this.handLL) {
            if (curCard.getColor() == Card.Colors.GREEN) {
                sortedHand.handLL.add(curCard);
                
            } 
        }
        for (Card curCard: this.handLL) {
            if (curCard.getColor() == Card.Colors.YELLOW) {
                sortedHand.handLL.add(curCard);
                
            } 
        }
        for (Card curCard: this.handLL) {
            if (curCard.getColor() == Card.Colors.BLUE) {
                sortedHand.handLL.add(curCard);
                
            } 
        }
        this.handLL = sortedHand.handLL;
        sortedHand = new Hand();
        
        
        sortByRank();
        //sortByRank(Card.Colors.GREEN);
        //sortByRank(Card.Colors.YELLOW);
        //sortByRank(Card.Colors.BLUE);
        
    }
    
    /**
     * This method swaps to cards
     * @param card1 First card to swap
     * @param card2 Second card to swap
     */
    
    /* swap methods if card1 is of cards class */
    public Card[] swap(Card card1, Card card2) {
        
        Card[] cards = new Card[2];
        System.out.print("\nStarting Hand: ");
        displaySortedHand();
        
        System.out.println("START: Card 1: " + card1.getColor() + " " + card1.getRank() + " Card 2: " + card2.getColor() + " " + card2.getRank());
        
        /* shallow copy card2 to temp */
        Card temp = new Card();
        temp.setColor(card2.getColor());
        temp.setRank(card2.getRank());
        
        /* change card 2 to card 1 instance */
        if (card1 instanceof WildCard) {
            card2 = new WildCard(card1.getColor(), card1.getRank());
        }
        else if (card1 instanceof ActionCard){
            card2 = new ActionCard(card1.getColor(), card2.getRank());
        }
        else if (card1 instanceof Card) {
            card2 = new Card(card1.getColor(), card2.getRank());
        }
        
        /* change card 1 to card 2 instance */
        if (card2 instanceof WildCard) {
            card1 = new WildCard(temp.getColor(), temp.getRank());
        }
        else if (card2 instanceof ActionCard){
            card1 = new ActionCard(temp.getColor(), temp.getRank());
        }
        else if (card2 instanceof Card) {
            card1 = new Card(temp.getColor(), temp.getRank());
        } 
        
        
        
        /* shallow copy card2 to temp 
        Card temp = new Card();
        temp.setColor(card2.getColor());
        temp.setRank(card2.getRank());
 
        
        /* set card 1 to card 2 attributes 
        card1.setColor(card2.getColor());
        card1.setRank(card2.getRank());
        
        /* set card 2 to card 1 (temp's) attributes 
        card2.setColor(temp.getColor());
        card2.setRank(temp.getRank());
        */
        
        cards[0] = card1;
        cards[1] = card2;
        
        System.out.println("END: Card 1: " + cards[0].getColor() + " " + cards[0].getRank() + " Card 2: " + cards[1].getColor() + " " + cards[1].getRank());
        
        return cards;
        
    }
    

   
    
    public void displaySortedHand() {
        for (Card card: this.handLL) {
            System.out.print(card.getColor() + " " + card.getRank()+ ", ");
        }
        
        System.out.println("");
    }
    
    /* All the matching color cards are a return to the bottom of the draw pile except “Reverse” card */
    public Pile handReverse(Pile pile) {
        
        LinkedList<Card> newHandLL = new LinkedList<Card>();
        ArrayList<Card> cardsForPile = new ArrayList<Card>();
        
        boolean reverseCardFound = false;
        
        /* initialize color for compiler */
        Card.Colors reverseColor = Card.Colors.RED;
        
        /* search for reverse */
        for (Card curCard: this.handLL) {
            if (curCard.getRank() == Card.Ranks.REVERSE) {
                //System.out.println(curCard.getColor())
                reverseColor = curCard.getColor();
                reverseCardFound = true;
                break;
            }
        }
        
        if (reverseCardFound) {
            for (Card curCard: this.handLL) {
                /* if card is same color as reverse, add to pile */
                if (curCard.getColor() == reverseColor && curCard.getRank() != Card.Ranks.REVERSE) {
                    pile.deckQueue.enqueue(curCard);
                }
                else if (curCard.getRank() != Card.Ranks.REVERSE || curCard.getColor() != reverseColor) {
                    newHandLL.add(curCard);
                }
            /* assign new hand to this hand */
            this.handLL = newHandLL;
            }       
        }

        
        return pile;
    }
    
    public int handLength() {
        return this.handLL.size();
    }
    
    public int countItemByRank(Card.Ranks rank) {
        int count = 0;
        for (int i = 0; i < this.handLL.size(); i++) {
            if (this.handLL.get(i).getRank() == rank) {
                count++;
            }
        }
        
        return count;
    }
    
    @Override
    public int compareTo(Hand o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void main(String[] args) {

        
        
    }
}
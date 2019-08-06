/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Card;
import java.io.IOException;
import static java.util.Comparator.comparing;
import java.util.Objects;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sundeep
 * created a linked list for sorting the elements
 */

 public class Hand implements Comparable<Hand>{
    
     private String color;
     private String rank;
     private Pile pile;
    
    public LinkedList<Card> handLL = new LinkedList<Card>();
 
    /**
     * 
     * sorting the cards by colors first in the order: Red,Green,Yellow,Blue
     */
    public void sortHand() {
      
        Hand sortedHand = new Hand();
        
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
        for (Card curCard: this.handLL) {
            if (curCard.getColor() == Card.Colors.NONE) {
                sortedHand.handLL.add(curCard);
                
            } 
        }
        
        this.handLL = sortedHand.handLL;
        sortedHand = new Hand();
        
        
        sortByRank();
        
        
    }
    /**
     * sorting the cards by ranks as given in the project
    */
   
     public void sortByRank() {
        
        Hand sortedHand = new Hand();
        Card.Colors[] colors = {Card.Colors.RED,Card.Colors.GREEN, Card.Colors.YELLOW, Card.Colors.BLUE};
        
        for (Card.Colors color: colors) {
            
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.SKIP && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.DRAWTWO && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.REVERSE && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }

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
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.ZERO && curCard.getColor() == color) {
                    sortedHand.handLL.add(curCard);
                }
            }
            
        }
        /* Wild second to last */
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.WILD) {
                sortedHand.handLL.add(curCard);
            }
        }
            for (Card curCard: this.handLL) {
                if (curCard.getRank() == Card.Ranks.WILDFOUR) {
                sortedHand.handLL.add(curCard);
            }
        }
        this.handLL = sortedHand.handLL;
        sortedHand = new Hand();
    }
 
     
    public void displaySortedHand(ArrayList<String> html_list) {
 
        for (Card card: this.handLL) {
            if (card.getColor() == Card.Colors.NONE) {
                System.out.print(card.getRank()+ ", ");
                html_list.add(card.getRank()+ ", ");
            }
            else {
               System.out.print(card.getColor() + " " + card.getRank()+ ", "); 
               html_list.add(card.getColor() + " " + card.getRank()+ ", ");
            }
            
        }
        System.out.println();
        html_list.add("\n");
    }
    
    
    /**
     * 
     * method for counting the cards by rank
     * @param rank
     * @return the count to calculate number of reps
     */
    public int countItemByRank(Card.Ranks rank) {
        int count = 0;
        for (int i = 0; i < this.handLL.size(); i++) {
            if (this.handLL.get(i).getRank() == rank) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * 
     * All the matching color cards are a returned to the bottom 
     * of the draw pile except “Reverse” card and creates a new hand without 
     * returned cards
     * @param pile
     * @return a pile with added cards from reverse
     */
   
    public Pile handReverse(Pile pile) {
        
        LinkedList<Card> newHandLL = new LinkedList<Card>();
        
        boolean reverseCardFound = false;
        /* initialize color for compiler */
        Card.Colors reverseColor = Card.Colors.RED;
        
        /* search for reverse card */
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
                // here we have a bug, it adds reverses back to hand
                else if (curCard.getRank() != Card.Ranks.REVERSE || curCard.getColor() != reverseColor) {
                    newHandLL.add(curCard);
                }
            /* assign new hand to this hand */
            this.handLL = newHandLL;
            }       
        }  
        return pile;
    }
    
    
    /**
     * displays take break action from card class
     * when zero card found in hand
     */
    public void isBreak() {
        for (Card curCard: this.handLL) {
            if (curCard.getRank() == Card.Ranks.ZERO) {
                curCard.displayBreak();
                break;
            }
            
        }
    }
    
    /**
     * Takes cards from pile into hand
     * @param pile 
     */
    public void drawHand(Pile pile) {
        int count = 0;
        for (int i = 0; i < 7 && !pile.deckQueue.isEmpty(); i++) {
            count++;
            this.handLL.add(pile.deckQueue.dequeue());


        }
       
    }
    
 @Override
    public int compareTo(Hand o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
 }
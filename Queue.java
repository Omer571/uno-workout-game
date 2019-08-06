/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Card;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


/**
 * queue which adds at tail and pops from head
 * @author macbookretina2015
 */
public class Queue  {
    
    private int head, tail;
    private int numberOfNodes = 0;
    final private int MAX;
    private Card[] array;

    
    /**
     * this method creates an array of 2000 
     * @param maxElements 
     */
    Queue(int maxElements) {
        this.array = new Card[maxElements];
        this.MAX = maxElements;
    }
    
    Queue() {
        this.array = new Card[2000];
        this.MAX = 2000;
    }
    

    
    /**
     * This method returns true if queue has reached max capacity
     * @return boolean This returns true if queue full
     */
    public boolean isFull() {return this.numberOfNodes >= MAX;}
    
    /**
     * This method dequeues card from tail
     * @return Card This returns popped card from queue, null if empty queue
     */
    public Card dequeue(){
        
        if (isEmpty()) {
            System.out.println("Can't pop from empty Queue - returning null");
            return null;
        }
        this.numberOfNodes--;
        return array[head++];   
    }
    
    /**
     * This method returns true is queue is empty
     * @return boolean This returns true if queue is empty
     */
    public boolean isEmpty() { return numberOfNodes == 0; }
    
    /**
     * Returns the position head of this queue
     * @return Integer This returns the head position of queue
     */
    public int getHead() {
        return this.head;
    }
    /**
     * Returns the position of tail of this queue
     * @return Integer This returns the position of tail of this queue
     */
    public int getTail() {
        return this.tail;
    }
    
    /**
     * This method sets a queue position with new Card
     * @param pos This is the position to replace
     * @param card This is what to replace current position with
     */
    public void set(int pos, Card card) {
        this.array[pos] = card;
    }
    
    /**
     * This method gets a card copy in queue given the position
     * @param pos
     * @return Card This returns copy of card at given position
     */
    public Card get(int pos) {
        Card copy = this.array[pos];
        return copy;
    }
    
    /** 
     * This method pushes card onto queue
     * @param node The card to push
     */
    public void enqueue(Card node) {
        
        /* if queue not full */
        if (isFull() == false) {
            /* if empty */
            if (isEmpty()) {
                this.head = 0;
                this.tail = 0;
                this.array[tail] = node;
            }
            /* if only one element */
            else if (numberOfNodes == 1) {
                this.array[++tail] = node;
            }
            /* else more than one element */
            else {
                this.array[++tail] = node;
                
            }
            this.numberOfNodes++;
        }
    }
    
    /**
     * 
     *This method prints the queue
     */
     
    public void printQueue() {
        for (int cur = this.head; cur < this.tail + 1 ;cur++) {
            System.out.println(this.array[cur].getColor() + " " + this.array[cur].getRank() + " " + cur);
 
        }
        System.out.println();
    }
    
    /**
     * This returns the number of elements in queue
     * @return int This returns number of elements in queue 
     */
    public int getNumberOfElements() {
        return this.numberOfNodes;
    }
    
    /*
    public static void TEST(String[] args) {
        Queue q = new Queue();
        q.push(new Card(Card.Colors.BLUE, Card.Ranks.EIGHT));
        q.printQueue();
        q.push(new Card(Card.Colors.RED, Card.Ranks.EIGHT));
        q.push(new Card(Card.Colors.YELLOW, Card.Ranks.EIGHT));
        q.push(new Card(Card.Colors.GREEN, Card.Ranks.EIGHT));
        q.push(new Card(Card.Colors.BLUE, Card.Ranks.EIGHT));
        q.printQueue();
        q.pop();
        q.printQueue();
        q.push(new Card(Card.Colors.GREEN, Card.Ranks.ONE));
        q.printQueue();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.printQueue();
        q.pop();
        q.pop();
        
    }
*/
}

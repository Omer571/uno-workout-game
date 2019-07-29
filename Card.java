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
public class Card {
    
    protected String color;
    private int rank;
    
    public String getColor() {
        return this.color;
    }
    
    /* checks if break (0 card) and if so print 1 minute break */
    public void isBreak() {
        if (rank == 0) {
            System.out.println("One Minute Break...");
        }
    }
    
    public int getRank() {
        return this.rank;
    }
    
    public void setRank(int cardNum) {
        this.rank = cardNum;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
}


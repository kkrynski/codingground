package DeckOfCards;

import java.util.*;

public enum SuitColor {
    /*-------------CONSTANT ENUM CLASS VALUES-------------*/
    BLACK,
    RED;
    
    /*-------------------CONSTANTS FOR CLASS--------------*/
    public static final int DEFAULT_RANK = 0;
    public static final int DEFAULT_VALUE = 0;
    
    /*---------------------PROPERTIES---------------------*/
    private int rank;                   //Represents a colors rank to other colors
    private int value;
    
    /*--------------------CONSTRUCTOR---------------------*/
    private SuitColor() {
        this.rank = DEFAULT_RANK;
        this.value = DEFAULT_VALUE;
    }
    
    /*------------------------METHODS---------------------*/
    public int getValue() {                     //Gets the value
        return this.value;
    }
    
    public void setValue(int v) {                //Sets the value
        this.value = v;
    }
    
    private int getRank() {                     //Gets the rank
        return this.rank;
    }
    
    private void setRank(int r) {               //Sets the rank
        this.rank = r;
    }
    
    public void makeTopRank() {                 //Makes the color the top rank
        this.rank = 1;
        if (this == BLACK) {
            RED.setRank(0);
        } else {
            BLACK.setRank(0);
        }
    }
    
    public void makeBottomRank() {              //Makes the color the bottom rank
        this.rank = 0;
        if (this == BLACK) {
            RED.setRank(1);
        } else {
            BLACK.setRank(1);
        }
    }
    
    /*-------------------STATIC CLASS METHODS----------------------*/
    public static void resetRanks() {           //Resets the color ranks to equal
        RED.setRank(0);
        BLACK.setRank(0);
    }
    
    /*------------------COMPARATOR FOR SUIT RANK-----------------*/
    public static Comparator<SuitColor> suitColorRankComparator = new Comparator<SuitColor>() {              //Defining a Class object for comparing during list sorts
        public int compare(SuitColor s1, SuitColor s2) {
            return s1.getRank() - s2.getRank();
        }
    };
    
}

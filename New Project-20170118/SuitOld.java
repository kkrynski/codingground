package DeckOfCards;

import java.util.*;

public enum Suit {
    /*-------------CONSTANT ENUM CLASS VALUES-------------*/
    CLUBS, 
    SPADES, 
    DIAMONDS, 
    HEARTS;
    
    /*-------------------CONSTANTS FOR CLASS--------------*/
    public static final int DEFAULT_RANK = 0;
    public static final int DEFAULT_VALUE = 0;
    public static final int SIZE = Suit.values().length;
    
    /*---------------------PROPERTIES---------------------*/
    private int rank;                   //Represents a suits rank to other suits
    private int value;
    
    /*--------------------CONSTRUCTOR---------------------*/
    private Suit() {
        this.rank = DEFAULT_RANK;
        this.value = DEFAULT_VALUE;
    }
    
    /*------------------------METHODS---------------------*/
    public int getValue() {                 //Returns the value of a suit
        return this.value;
    }
    
    public void setValue(int v) {           //Sets the value of a suit
        this.value = v;
    }
    
    private int getRank(){               //Returns the rank of a suit
        return this.rank;   
    }
    
    private void setRank(int r) {        //Sets the rank of a suit
        this.rank = r;
    }
    
    public boolean isHigherRank(Suit s){        //Checks if a suit is higher rank
        return (this.rank > s.getRank());
    }
    
    public boolean isLowerRank(Suit s) {          //Checks if a suit is lower rank
        return (this.rank < s.getRank());
    }
    
    public boolean isSameRank(Suit s){             //Checks if a suit is same rank
        return (this.rank == s.getRank());
    }
    
    public boolean isTopRank() {                    //Checks if a suit is the top rank
        return (this.rank == Suit.getTopRank());
    }
    
    public boolean isBottomRank() {                 //Checks if a suit is the bottom rank
        return (this.rank == Suit.getBottomRank());
    }
    
    public void swapRank(Suit s) {                  //Swaps rank with a suit
        int oldRank = this.rank;
        this.rank = s.getRank();
        s.setRank(oldRank);
    }
    
    public void makeEqualTopRank() {                //Makes the suit equal to the top rank
        this.rank = Suit.getTopRank();
    }
    
    public void makeEqualBottomRank() {             //Makes the suit equal to the bottom rank
        this.rank = Suit.getBottomRank();
    }
    
    public void makeTopRank() {                //Makes the suit the new top rank
        ArrayList<Suit> topSuits = Suit.getTopSuits();
        if (topSuits.contains(this) && topSuits.size() == 1) {return;}   //if the suit is alone at the top, do nothing
        int topRank = topSuits.get(0).getRank();            //get the top rank
        if (topRank == SIZE-1) {                            //if the top rank is max
            int bottomRank = Suit.getBottomRank();              //get the bottom rank
            int originalRank = this.rank;
            for (Suit s : Suit.values()) {                  //then decrease rank of other suits to make room at top
                if (bottomRank != 0 || s.getRank() > 1 || s.getRank() > originalRank) {
                    s.decreaseRank();
                }
            }
            this.rank = topRank;
        } else {                                            //otherwise just make the suit rank greater than the top rank
            this.rank = topRank + 1;
        }
    }
    
    public void makeBottomRank() {                //Makes the suit the new bottom rank
        ArrayList<Suit> bottomSuits = Suit.getBottomSuits();
        if (bottomSuits.contains(this) && bottomSuits.size() == 1) {return;}   //if the suit is alone at the bottom, do nothing
        int bottomRank = bottomSuits.get(0).getRank();            //get the bottom rank
        if (bottomRank == 0) {                            //if the bottom rank is min
            int topRank = Suit.getTopRank();              //get the top rank
            int originalRank = this.rank;
            for (Suit s : Suit.values()) {                  //then increase rank of other suits to make room at bottom
                if (topRank != SIZE-1 || s.getRank() < SIZE-2 || s.getRank() < originalRank) {
                    s.increaseRank();
                }
            }
            this.rank = bottomRank;
        } else {                                            //otherwise just make the suit rank less than the bottom rank
            this.rank = bottomRank - 1;
        }
    }
    
    public void increaseRank() {                    //Increases the rank of a suit
        if (this.rank < SIZE-1) {
            this.rank++;
        }
    }
    
    public void decreaseRank() {                    //Decreases the rank of a suit
        if (this.rank > 0) {
            this.rank--;
        }
    }
    
    /*-------------------STATIC CLASS METHODS----------------------*/
    public static ArrayList<Suit> getTopSuits() {               //Returns the top ranked suits
        ArrayList<Suit> topSuits = new ArrayList<Suit>();
        int topRank = Suit.getTopRank();
        for (Suit s: Suit.values()) {
            if (s.getRank() == topRank) {
                topSuits.add(s);
            }
        }
        return topSuits;
    }
    
    public static ArrayList<Suit> getBottomSuits() {            //Returns the bottom ranked suits
        ArrayList<Suit> bottomSuits = new ArrayList<Suit>();
        int bottomRank = Suit.getBottomRank();
        for (Suit s: Suit.values()) {
            if (s.getRank() == bottomRank) {
                bottomSuits.add(s);
            }
        }
        return bottomSuits;
    }
    
    private static int getTopRank() {                   //Returns the top rank
        int topRank = 0;                //gets reset on first loop iteration
        int c = 0;
        for (Suit s : Suit.values()) {
            if (c == 0 || s.getRank() > topRank) {
                topRank = s.getRank();
                c = 1;
            }
        }
        return topRank;
    }
    
    private static int getBottomRank() {                //Returns the bottom rank
        int bottomRank = 0;                //gets reset on first loop iteration
        int c = 0;
        for (Suit s : Suit.values()) {
            if (c == 0 || s.getRank() < bottomRank) {
                bottomRank = s.getRank();
                c = 1;
            }
        }
        return bottomRank;
    }
    
    public static ArrayList<Suit> getGreaterSuits(Suit s) {         //Returns all suits greater rank than a suit
        ArrayList<Suit> aboveSuits = new ArrayList<Suit>();
        for (Suit c : Suit.values()) {
            if (c.getRank() > s.getRank()) {
                aboveSuits.add(c);
            }
        }
        return aboveSuits;
    }
    
    public static ArrayList<Suit> getLesserSuits(Suit s) {          //Returns all suits lesser rank than a suit
        ArrayList<Suit> belowSuits = new ArrayList<Suit>();
        for (Suit c : Suit.values()) {
            if (c.getRank() < s.getRank()) {
                belowSuits.add(c);
            }
        }
        return belowSuits;
    }
    
    public static ArrayList<Suit> getEqualSuits(Suit s) {           //Returns all suits equal rank to a suit
        ArrayList<Suit> equalSuits = new ArrayList<Suit>();
        for (Suit c : Suit.values()) {
            if (c.getRank() == s.getRank()) {
                equalSuits.add(c);
            }
        }
        return equalSuits;
    }
    
    /*------------------COMPARATOR FOR SUIT RANK-----------------*/
    public static Comparator<Suit> suitRankComparator = new Comparator<Suit>() {              //Defining a Class object for comparing during list sorts
        public int compare(Suit s1, Suit s2) {
            return s1.getRank() - s2.getRank();
        }
    };
    
}

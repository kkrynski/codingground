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
    public static final int SIZE = Suit.values().length;
    
    /*---------------------PROPERTIES---------------------*/
    private int rank;                   //Represents a suits rank to other suits
    
    /*--------------------CONSTRUCTOR---------------------*/
    private Suit() {
        this.rank = DEFAULT_RANK;
    }
    
    /*------------------------METHODS---------------------*/
    public int getRank(){               //Returns the rank of a suit
        return this.rank;   
    }
    
    public void setRank(int r) {        //Sets the rank of a suit
        if (r >= 0 && r < SIZE) {
            this.rank = r;
        }
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

    /*-------------------STATIC CLASS METHODS----------------------*/
    public static void setRanks(int[] ranks, Suit... suits) {
        if (ranks.length != suits.length) {
            return;
        }
        for (int i = 0; i < suits.length; i++) {
            if (i < ranks.length && ranks[i] >=0 && ranks[i] < SIZE) {
                suits[i].setRank(ranks[i]);
            }
        }
    }
    
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

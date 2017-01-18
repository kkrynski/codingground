package DeckOfCards;

import java.util.*;

public enum Suit {
    /*-------------CONSTANT ENUM CLASS VALUES-------------*/
    CLUBS (0), 
    SPADES (0), 
    DIAMONDS (0), 
    HEARTS (0);
    
    /*---------------------PROPERTIES---------------------*/
    private int rank;                   //Represents a suits rank to other suits
    
    /*--------------------CONSTRUCTOR---------------------*/
    private Suit(int rank) {
        this.rank = rank;
    }
    
    /*------------------------METHODS---------------------*/
    public int getRank(){               //Returns the rank of a suit
        return this.rank;   
    }
    
    public void setRank(int r) {        //Sets the rank of a suit
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
    
    public void swapRank(Suit s) {                  //Swaps rank with a suit
        int oldRank = this.rank;
        this.setRank(s.getRank());
        s.setRank(oldRank);
    }
    
    public void makeTopRank() {
        
    }
    
    public void makeBottomRank() {
        
    }
    
    /*------------------COMPARATOR FOR SUIT RANK-----------------*/
    public static Comparator<Suit> suitRankComparator = new Comparator<Suit>() {              //Defining a Class object for comparing during list sorts
        public int compare(Suit s1, Suit s2) {
            return s1.getRank() - s2.getRank();
        }
    };
    
}
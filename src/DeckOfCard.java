//************************************************************
//  DeckInterface.java               Authors: Rabia Riaz
//  Provides a graphical user interface for a card deck
//  using the DeckOfCard class to provide the functionality
//************************************************************

import java.util.Random;
import java.util.Scanner;

public class DeckOfCard{
    /*Cards*/
    private Card cards[];

    private int currentCount;

    private int size;

    private Suit suits[];

    private Value values[];

    public DeckOfCard(){
        size = 52;
        currentCount=0;
        cards = new Card[size];
        suits=Suit.values();
        values=Value.values();

        for(int i =0 ; i<suits.length;i++){
            for(int j =0 ; j<values.length;j++){
                cards[currentCount++] = new Card(suits[i],values[j]);
            }

        }
    }


    public static void main(String[] args) {


        DeckOfCard deckOfCard = new DeckOfCard();


        System.out.println("dealt card=");
        //deckOfCard.deal();


        System.out.println("sort card=");
        deckOfCard.sort();

        deckOfCard.shuffling();
    }

    public static void shuffling() {
        DeckOfCard deckOfCard = new DeckOfCard();
        System.out.println("shuffledcards=");
        deckOfCard.shuffle(52);
        System.out.println(deckOfCard);
    }

  /*This is to shuffle the cards in the deck with the remaining cards.
  Variable numberOftime represents the number of time need to shuffle the cards in deck*/

    public void shuffle(int numberOftime){

        Random rand= new Random();


        for(int i=0;i<numberOftime;i++){
            int m=rand.nextInt(currentCount);
            int n=rand.nextInt(currentCount);

            Card temp=cards[m];
            cards[m]=cards[n];
            cards[n]=temp;
        }

    }

    /*This function is to deal the cards whatever is on top of the deck.*/
    public void deal(int amount){

        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt(); // Scans the next token of the input as an int.
        //once finished
        // reader.close(int n);
        System.out.println("Enter a number of cards to draw: ");
        DeckOfCard newdeck = new DeckOfCard();

    }

    /*This is to represents the String representation of the current cards inthe deck.*/
    public String toString(){

        StringBuilder sb=new StringBuilder();

        for(int i=0;i < currentCount;i++){
            sb.append(cards[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    /*  Sorting the cards based on the suit and then numbers.
        This sorting is using Bucket Sort to sort the cards runtime= O(n) space=O(n);*/
    public void sort(){

        Card bucketCards[][]= new Card[suits.length][values.length];

        for(int i=0;i<currentCount;i++){
            bucketCards[cards[i].getSuit().ordinal()][cards[i].getValue().ordinal()]=cards[i];
        }

        int pointer=0;

        for(int i=0;i<suits.length;i++){
            for(int j=0;j<values.length;j++){
                if(bucketCards[i][j]!=null)
                    cards[pointer++]=bucketCards[i][j];
            }
        }


    }


    /*Printing the stack of cards in format*/
    public void printStack(){
        int cardPointer=0;
        for(int i=0;i<suits.length;i++){

            for(int j=0;j<values.length;j++){
                System.out.print(cards[cardPointer++]+" ");
            }

            System.out.println("\n");
        }

    }

    /*Get size of the deck*/ //-------------fix it
    public int getDeckSize() {
        return 1; // DeckOfCard.length();
    }

    /*This represents the suit of the card*/
    private enum Suit{
        CLUB,DIAMOND,SPADE,HEART
    }

    /* This represents the number of the card*/
    private enum Value{
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }

    /* This class represents the card with specific suit and value.
     * Cannot change the value once instansiated */
    private class Card{

        private final Suit suit;

        private final Value value;

        public Card(Suit suit, Value value){
            this.suit=suit;
            this.value=value;
        }


        public Suit getSuit() {
            return suit;
        }

        public Value getValue() {
            return value;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return suit+"-"+value;
        }
    }
}
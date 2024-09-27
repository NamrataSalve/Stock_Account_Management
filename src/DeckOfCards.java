import java.util.Random;
// Class representing a deck of cards
class DeckOfCard {
    // Arrays to store the suits and ranks of the cards
    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    // 2D array to store the deck of cards
    private String[][] deck;
    // 2D array to store the cards distributed to players
    private String[][] players;
    // Constructor to initialize the deck and distribute cards
    public DeckOfCard() {
        deck = new String[52][2]; // 52 cards in a deck
        players = new String[4][9]; // 4 players and 9 cards each
        initializeDeck(); // Initialize the deck with suits and ranks
        shuffleDeck(); // Shuffle the deck
        distributeCards(); // Distribute the cards to players
    }
    // Method to initialize the deck with suits and ranks
    private void initializeDeck() {
        int k = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[k][0] = suit;
                deck[k][1] = rank;
                k++;
            }
        }
    }
    // Method to shuffle the deck using Random
    private void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int index = random.nextInt(52); // Generate a random index
            String[] temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp; // Swap the cards
        }
    }
    // Method to distribute the cards to players
    private void distributeCards() {
        int cardIndex = 0;
        for (int i = 0; i < 4; i++) { // Loop through players
            for (int j = 0; j < 9; j++) { // Each player gets 9 cards
                players[i][j] = deck[cardIndex][0] + " " + deck[cardIndex][1];
                cardIndex++;
            }
        }
    }
    // Method to print the cards each player has received
    public void printPlayers() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < 9; j++) {
                System.out.println(players[i][j]); // Print each card
            }
            System.out.println();
        }
    }
}
// Main class to test the DeckOfCard class
public class DeckOfCards {
    public static void main(String[] args) {
        DeckOfCard deckOfCards = new DeckOfCard(); // Create a DeckOfCard object
        deckOfCards.printPlayers(); // Print the cards each player received
    }
}

package com.pluralsight;
import java.util.Scanner;

public class BlackJackApp {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter name for player 1: ");
    Player player1 = new Player(scanner.nextLine());

    System.out.print("Enter name for player 2: ");
    Player player2 = new Player(scanner.nextLine());

        //create a new deck and shuffle it
        Deck deck = new Deck();
        deck.shuffle();

        //Deal 2 cards to each player
        player1.getHand().deal(deck.deal());
        player1.getHand().deal(deck.deal());
        player2.getHand().deal(deck.deal());
        player2.getHand().deal(deck.deal());

        // Show each player's hand
        System.out.println("\n--- Player Hands ---");
        System.out.println(player1.getName() + ": " + player1.getHand());
        System.out.println(player2.getName() + ": " + player2.getHand());

        // Get scores and determine the winner
        int score1 = player1.getHand().getValue();
        int score2 = player2.getHand().getValue();

        System.out.println("\n-Result-");

        if (score1 > 21 && score2 > 21) {
            System.out.println("No winner, better luck next time!");
        } else if (score1 <= 21 && (score2 > 21 || score1 > score2)) {
            System.out.println(player1.getName() + " wins with " + score1 + " points!");
        } else if (score2 <= 21 && (score1 > 21 || score2 > score1)) {
            System.out.println(player2.getName() + " wins with " + score2 + " points!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}
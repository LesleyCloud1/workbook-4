package com.pluralsight;

public class Player {
    private String name; //Name of the player
    private Hand hand; //Hand of cards for each player

    //Create a new player, we set their name and give them new hand
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }
    //Players hand
    public Hand getHand() {
        return hand;
    }
    //Players name
    public String getName() {
        return name;
    }

}

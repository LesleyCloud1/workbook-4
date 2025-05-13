package com.pluralsight;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class SuperPerson {
    /*Attributes of the SuperPerson class.
    "protected" means these variables can be accessed within the same package and by subclasses.
     */
    protected String name;
    protected int health;
    protected int experiencePoints;

    //Log or track how many times this character hits others
    private HashMap<String, Integer> battleLog = new HashMap<>();
    protected HashMap<String, Integer> inventory = new HashMap<>();

    /*Constructor of the class, allows us to create a new SuperPerson object with a specific
    name and health value.*/
    public SuperPerson(String name, int health) {
        this.name = name; //Assigned the passed 'name' to the class 'name' field.
        this.health = health; //Assigned the passed 'health' to the class 'health' field.
        this.experiencePoints = 0; //Set initial experience points to ) when a new SuperPerson is created.
    }

    /*This is a method named isAlive that returns a boolean value (true or false).
    It checks whether the SuperPerson's health is greater than 0.*/
    public boolean isAlive() {
        return (this.health > 0);
    }

    //Track how many times this character hits the opponent
    public void logHit(SuperPerson opponent) {
        String opponentName = opponent.name;
        int currentCount = battleLog.getOrDefault(opponentName, 0);
        battleLog.put(opponentName, currentCount + 1); //updates hit count
    }

    //Show summary of all hits this character made
    public void printBattleLog() {
        System.out.println("Battle Log for " + name + ":");
        for (Map.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    //add a power up item to inventory
    public void addPowerUp(String item, int bonusValue) {
        inventory.put(item, bonusValue);
    }

    //Get bonus for specific item, 0 if not found
    public int getPowerBonus(String item) {
        return inventory.getOrDefault(item, 0);
    }

    public void takeDamage(int damageAmount) {
        this.health -= damageAmount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public String getStatus() {
        return this.name + " has " + this.health + " health left!";
    }

    /*method that allows SuperPerson to fight another SuperPerson, right now only prints who is
    fighting who.*/
    public void fight(SuperPerson opponent) {
        //Print who are we fighting
        int damageAmount = new Random().nextInt(21);
        //displays the opponent we are fighting against
        System.out.println(this.name + " is fighting " + opponent.name + "!");
        opponent.takeDamage(damageAmount + this.experiencePoints);
    }
}
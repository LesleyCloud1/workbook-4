package com.pluralsight;
import java.util.Random;

public class SuperPerson {
    /*Attributes of the SuperPerson class.
    "protected" means these variables can be accessed within the same package and by subclasses.
     */
    protected String name;
    protected int health;
    protected int experiencePoints;

    /*Constructor of the class, allows us to create a new SuperPerson object with a specific
    name and health value.*/
    public SuperPerson(String name, int health) {
        this.name = name; //Assigned the passed 'name' to the class 'name' field.
        this.health = health; //Assigned the passed 'health' to the class 'health' field.

        this.experiencePoints = 0; //Set initial experience points to ) when a new SuperPerson is created.
    }
    /*This is a method named isAlive that returns a boolean value (true or false).
    It checks whether the SuperPerson's health is greater than 0.*/
    public boolean isAlive(){
        return (this.health > 0);
    }
    /*method that allows SuperPerson to fight another SuperPerson, right now only prints who is
    fighting who.*/
    public void fight(SuperPerson opponent) {
        //Print who are we fighting
        int damageAmount = new Random().nextInt(21);
// displays the opponent we are fighting against
        System.out.println(this.name + " is fighting " + opponent.name + "!");
        opponent.takeDamage(damageAmount + this.experiencePoints);
    }

    public void takeDamage(int damageAmount) {

        // subtract damage amount from health but don't want to set health below 0
        this.health -= damageAmount;

        if(this.health < 0){
            this.health = 0;
        }
    }

    // method for displaying health
    public String getStatus() {

        // returns how much health a SuperPerson has left
        return this.name + " has " + this.health + " health left!";
    }
}
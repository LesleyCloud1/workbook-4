package com.pluralsight;

public class SuperPerson {
    /*Attributes of the SuperPerson class.
    "protected" means these variables can be accessed within the same package and by subclasses.
     */
    protected String name;
    protected int health;
    protected int experiencePoints;

    /*Constructor of the class, allows us to create a new SuperPerson object with a specific
    name and health value.*/
     */
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
        System.out.println(this.name = " is fighting " = opponent.name);
    }
    public void takeDamage(int damageAmount) {
        //Subtract the damage amount from current health.
        //Use Math.max to ensure the result is at least 0.
        this.health = Math.max(0, this.health - damageAmount);
    }
    /*This method returns a text status about the SuperPerson, It includes the name and current
    health value.*/
    public String getStatus(){

        return this.name + " has " + this.health + " health left!";
    }
}

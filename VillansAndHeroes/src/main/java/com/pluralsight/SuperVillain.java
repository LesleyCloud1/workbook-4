package com.pluralsight;
import java.util.Random;
public class SuperVillain extends SuperPerson {

 /* This is the constructor for SuperVillain.It takes three parameters: name, health, and evilLevel.
 The constructor sets up the initial values for a new SuperVillain object.*/

    public SuperVillain(String name, int health, int evilLevel) {
        //Call the parent (SuperPerson) constructor to set name and health
        super(name, health);

        //Set the villain's experience points using the evil level
        this.experiencePoints = evilLevel;

        //Print a message to show the villain has been created
        System.out.println(this.name + " has slithered onto the scene with an evil level of " + evilLevel);
    }

    /*
     * This method overrides the fight() method from the SuperPerson class.
     * It defines how a SuperVillain attacks another SuperPerson.
     * The attack does a random amount of damage based on a base number (0–3)
     * plus the villain's experiencePoints (evilLevel).
     */
    @Override
    public void fight(SuperPerson opponent) {
        //Create a Random object so we can generate random numbers
        Random rand = new Random();

        //Generate a base damage amount from 0 to 3
        int baseDamage = rand.nextInt(4); // rand.nextInt(4) gives a number between 0 (inclusive) and 4 (exclusive)

        //If the base damage is 0, the attack misses
        if (baseDamage == 0) {
            // Print a message showing the attack missed
            System.out.println(this.name + " tried to hack the mainframe, but forgot their password! Missed!");
        } else {
            //If base damage is greater than 0, calculate total damage
            int totalDamage = baseDamage + this.experiencePoints;

            //Deal the damage to the opponent using their takeDamage method
            opponent.takeDamage(totalDamage);

            // Unique messages for each villain
            switch (this.name) {
                case "Techy Eric":
                    System.out.println(this.name + " opened 100 browser tabs on " + opponent.name +
                            "'s system, causing it to lag and take " + totalDamage + " damage! 🐌💻");
                    break;

                case "Glitchy Griffin":
                    System.out.println(this.name + " summoned a glitch storm and soft-locked " +
                            opponent.name + "'s controls for " + totalDamage + " damage! 🌀🕹️");
                    break;
                default:
                    //Fallback for any unnamed villains
                    System.out.println(this.name + " unleashed a logic bomb on " + opponent.name +
                            " for " + totalDamage + " damage! 💣🧠");
            }
        }
    }
}
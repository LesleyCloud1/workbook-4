package com.pluralsight;
import java.util.Random;
public class SuperHero extends SuperPerson {

    //constructor that callas the parent class constructor
    public SuperHero(String name, int health, int powerLevel) {
        super(name, health);

        /*in the parent we default power level (XP) to 0, for our superhero we want to have them
        pass in power level but just use that as xp */
        this.experiencePoints = powerLevel;

        System.out.println((this.name + " has arrved with a power level " + powerLevel));
    }

    @Override
    public void fight(SuperPerson opponent) {

        /*make the hero do a random amount of damage to the oppponent the damage should be a random number plus the
        experiencePoints(powerlevel) if the base damage (without the xp) was 0, dont do any damage and just say you
        missed otherwise deal the damage and say something about you kicking butt against your opponent.*/

        Random rand = new Random(); //Create a Random object
        int baseDamage = rand.nextInt(6); //Generate a random damage number between 0 and 5

        if (baseDamage == 0) {
            //If base damage is 0, the attack missed
            System.out.println(this.name + " tripped over semicolons and missed the attack!");
        } else {
            int bonus = getPowerBonus("glove"); //bonus from inventory
            int totalDamage = baseDamage + this.experiencePoints + bonus; //Add experiencePoints (powerLevel) to baseDamage to calculate total damage

            opponent.takeDamage(totalDamage);  //Apply damage to oponent
            logHit(opponent);  //Track this hit in battle log

            //Personalized attack messages for each hero
            switch (this.name) {
                case "Captain Lesley":
                    System.out.println(this.name + " debugged " + opponent.name +
                            " into submission for " + totalDamage + " damage! 🛠️🔥");
                    break;
                case "Java Jack":
                    System.out.println(this.name + " overloaded " + opponent.name +
                            " with Java streams for " + totalDamage + " damage! ☕💥");
                    break;
                default:
                    System.out.println(this.name + " delivers a powerful blow to " +
                            opponent.name + " for " + totalDamage + " damage!");
            }
        }
    }
}

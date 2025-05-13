package com.pluralsight;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; //Needed to read user input
public class SupperApp {
    //The main method is the starting point of Java application
    public static void main(String[] args) {

        /*Initial Exercise: Create our two characters
         Create a SuperHero with a name, a starting health value, and a power level (used as experience points)
         Create a SuperVillain with a name, a starting health value, and an evil level (also used as experience points)

        SuperHero hero = new SuperHero("Captain Lesley", 40, 5);
        SuperVillain villain = new SuperVillain("Techy Eric", 35, 3);
        /*Introduce the battle
         Print an introduction message to the player
         Show the initial health status of both the hero and the villain
         */
        Scanner scanner = new Scanner(System.in); //Read user input
        Random random = new Random();             //Generate random values
        String playAgain;                         //Track if user wants to play again

        //Start the outer loop for replaying battles
        do {

        /* We are now creating a hashmap to store all our characters, the key is a string(Characters name), the value
        is a SuperPerson object(hero/villlian), this will let us look up characters by name.*/
        HashMap<String, SuperPerson> characters = new LinkedHashMap<>();
        /*Create several hero and villian objects, each one has a name, health, and either a power level for heroes
        and evil level for villains. Will determine how strong they are.*/

        SuperHero hero1 = new SuperHero("Captain Lesley", 100, 20);
        SuperHero hero2 = new SuperHero("Java Jack", 100, 15);
        SuperVillain villain1 = new SuperVillain("Techy Eric", 100, 20);
        SuperVillain villain2 = new SuperVillain("Glitch Griffin ", 100, 15);

        //Add characters to the HashMap
        characters.put(hero1.name, hero1);
        characters.put(hero2.name, hero2);
        characters.put(villain1.name, villain1);
        characters.put(villain2.name, villain2);

        //Separate names into hero and villain lists
        ArrayList<String> heroNames = new ArrayList<>();
        ArrayList<String> villainNames = new ArrayList<>();

        for (String name : characters.keySet()) {
            SuperPerson character = characters.get(name);
            //Check if it's a hero or villain and sort accordingly
            if (character instanceof SuperHero) {
                heroNames.add(name);
            } else if (character instanceof SuperVillain) {
                villainNames.add(name);
            }
        }
        //Pick a random hero and villain
        String randomHeroName = heroNames.get(random.nextInt(heroNames.size()));
        String randomVillainName = villainNames.get(random.nextInt(villainNames.size()));

        //Get the character objects
        SuperHero hero = (SuperHero) characters.get(randomHeroName);
        SuperVillain villain = (SuperVillain) characters.get(randomVillainName);

        //Show the intro
        System.out.println("\n🔥 RANDOM BATTLE 🔥");
        System.out.println(hero.name + " VS " + villain.name);
        System.out.println(hero.getStatus());
        System.out.println(villain.getStatus());
        System.out.println();

        //Battle loop until one is defeated
        while (hero.isAlive() && villain.isAlive()) {
            System.out.println("➡️ " + hero.name + " attacks!");
            hero.fight(villain);
            System.out.println(villain.getStatus());

            if (!villain.isAlive()) break;

            System.out.println("⚠️ " + villain.name + " counterattacks!");
            villain.fight(hero);
            System.out.println(hero.getStatus());
            System.out.println();
        }
            hero.printBattleLog();
            villain.printBattleLog();


            //Show the winner
        System.out.println("--- Battle Over ---");
        if (hero.isAlive()) {
            System.out.println("🎉 " + hero.name + " wins the battle!");
        } else {
            System.out.println("💀 " + villain.name + " wins the battle!");
        }

            //Ask if player wants to go again
            System.out.print("\nWould you like to play again? (y/n): ");
            playAgain = scanner.nextLine().toLowerCase();

        } while (playAgain.equals("y")); // Repeat the game if the user says yes

        //Goodbye message
        System.out.println("👋 Thanks for playing!");
        scanner.close(); // Always close scanner
    }
}
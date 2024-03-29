package com.swf;

import com.swf.characterClasses.Mage;
import com.swf.characterClasses.Warrior;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public void initializeGame(){
        System.out.println(new StringBuilder().append("Character selection: \n").append("1. Warrior \n").append("2. Mage \n").append("3. Rogue \n").append("4. Paladin \n").append("5. Hunter \n"));
        Scanner scanner = new Scanner(System.in);
        int userInput;
        do {
            System.out.print("Enter your choice (1-5): ");
            userInput = scanner.nextInt();

            if (userInput < 1 || userInput > 5) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (userInput < 1 || userInput > 5);

        System.out.println("Starting Game");

        //Tight coupling between Game with Warrior and Mage
        //If I want to have multiple classes of differing types what needs to be done?
        //Let's assume these objects have parameters that are configured at runtime, what then?
        Warrior warrior = new Warrior(1, 140, 40, 0, 0.4f, 0.1f, 5f, 5f);
        Mage mage = new Mage(1, 70, 0, 30, 0.0f, 0.4f, 7.5f, 2.5f);
        runGame(warrior, mage);
    }

    public void runGame(Warrior warrior, Mage mage){
        Random random = new Random();
        while (warrior.getHealth() > 0 && mage.getHealth() > 0) {
            String character1 = Mage.class.getSimpleName();
            String character2 = Warrior.class.getSimpleName();
            System.out.println(character2 + "'s attacks!");
            int physicalDamage = warrior.calculatePhysicalDamage(random);
            int magicDamage = warrior.calculateMagicDamage(random);
            int physicalDamageTaken = mage.calculatePhysicalDamageTaken(random, physicalDamage);
            int magicDamageTaken = mage.calculateMagicDamageTaken(random, magicDamage);
            System.out.println(character2 + " deals " + physicalDamageTaken + " physical damage and "+ magicDamageTaken + " magic damage");
            mage.calculateHealth(physicalDamageTaken + magicDamageTaken);
            if(mage.getHealth() == 0) break;
            System.out.println(character1 + "'s attacks!");
            physicalDamage = mage.calculatePhysicalDamage(random);
            magicDamage = mage.calculateMagicDamage(random);
            physicalDamageTaken = warrior.calculatePhysicalDamageTaken(random, physicalDamage);
            magicDamageTaken = warrior.calculateMagicDamageTaken(random, magicDamage);
            System.out.println(character1 + " deals " + physicalDamageTaken + " physical damage and "+ magicDamageTaken + " magic damage");
            warrior.calculateHealth(physicalDamageTaken + magicDamageTaken);
        }

        if (warrior.getHealth() > 0) {
            System.out.println("You win!");
            warrior.levelUp();
        } else {
            System.out.println("You lose!");
            mage.levelUp();
        }
    }
}

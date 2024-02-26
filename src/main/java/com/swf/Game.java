package com.swf;

import com.swf.classes.Mage;
import com.swf.classes.Warrior;

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
        CharacterFactory characterFactory = new CharacterFactory();
        Character player1 = characterFactory.characterCreation(userInput);
        Character mage = characterFactory.createMage();
        runGame(player1, mage);
    }

    public void runGame(Character player1, Character opponent){

        Random random = new Random();
        while (player1.getHealth() > 0 && opponent.getHealth() > 0) {
            String character1 = Mage.class.getSimpleName();
            String character2 = Warrior.class.getSimpleName();
            System.out.println(character2 + "'s attacks!");
            int physicalDamage = player1.calculatePhysicalDamage(random);
            int magicDamage = player1.calculateMagicDamage(random);
            int physicalDamageTaken = opponent.calculatePhysicalDamageTaken(random, physicalDamage);
            int magicDamageTaken = opponent.calculateMagicDamageTaken(random, magicDamage);
            System.out.println(character2 + " deals " + physicalDamageTaken + " physical damage and "+ magicDamageTaken + " magic damage");
            opponent.calculateHealth(physicalDamageTaken + magicDamageTaken);
            if(opponent.getHealth() == 0) break;
            System.out.println(character1 + "'s attacks!");
            physicalDamage = opponent.calculatePhysicalDamage(random);
            magicDamage = opponent.calculateMagicDamage(random);
            physicalDamageTaken = player1.calculatePhysicalDamageTaken(random, physicalDamage);
            magicDamageTaken = player1.calculateMagicDamageTaken(random, magicDamage);
            System.out.println(character1 + " deals " + physicalDamageTaken + " physical damage and "+ magicDamageTaken + " magic damage");
            player1.calculateHealth(physicalDamageTaken + magicDamageTaken);
        }

        if (player1.getHealth() > 0) {
            System.out.println("You win!");
            player1.levelUp();
        } else {
            System.out.println("You lose!");
            opponent.levelUp();
        }
    }
}

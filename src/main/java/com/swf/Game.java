package com.swf;

import com.swf.characterClasses.Character;
import com.swf.characterClasses.Mage;

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

        runGame(userInput);
    }

    public void runGame(int characterType){
        System.out.println("Starting Game");
        CharacterFactory characterFactory = new CharacterFactory();
        Character player1 = characterFactory.characterCreation(characterType);
        Mage mage = characterFactory.createMage();

        Random random = new Random();
        while (player1.getHealth() > 0 && mage.getHealth() > 0) {
            String character1 = player1.className();
            String character2 = mage.className();
            System.out.println(character1 + "'s attacks!");
            int physicalDamage = player1.calculatePhysicalDamage(random);
            int magicDamage = player1.calculateMagicDamage(random);
            int physicalDamageTaken = mage.calculatePhysicalDamageTaken(random, physicalDamage);
            int magicDamageTaken = mage.calculateMagicDamageTaken(random, magicDamage);
            System.out.println(character1 + " deals " + physicalDamageTaken + " physical damage and "+ magicDamageTaken + " magic damage");
            mage.calculateHealth(physicalDamageTaken + magicDamageTaken);
            if(mage.getHealth() == 0) break;
            System.out.println(character2 + "'s attacks!");
            physicalDamage = mage.calculatePhysicalDamage(random);
            magicDamage = mage.calculateMagicDamage(random);
            physicalDamageTaken = player1.calculatePhysicalDamageTaken(random, physicalDamage);
            magicDamageTaken = player1.calculateMagicDamageTaken(random, magicDamage);
            System.out.println(character2 + " deals " + physicalDamageTaken + " physical damage and "+ magicDamageTaken + " magic damage");
            player1.calculateHealth(physicalDamageTaken + magicDamageTaken);
        }

        if (player1.getHealth() > 0) {
            System.out.println("You win!");
            player1.levelUp();
        } else {
            System.out.println("You lose!");
            mage.levelUp();
        }
    }
}

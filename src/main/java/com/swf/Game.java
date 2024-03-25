package com.swf;

import com.swf.characterClasses.Character;
import com.swf.characterClasses.CharacterType;
import com.swf.characterClasses.Mage;
import lombok.Builder;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public void initializeGame(){

        System.out.println(new StringBuilder().append("Character selection: \n").append("1. Warrior \n").append("2. Mage \n").append("3. Rogue \n").append("4. Paladin \n").append("5. Hunter \n").append("6. Custom class \n"));
        Scanner scanner = new Scanner(System.in);
        int userInput;
        do {
            System.out.print("Enter your choice (1-5): ");
            userInput = scanner.nextInt();

            if (userInput < 1 || userInput > 6) {
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (userInput < 1 || userInput > 6);

        CharacterFactory characterFactory = new CharacterFactory();
        Mage mage = characterFactory.createMage();

        if(userInput == 6){
            System.out.println("Creating custom class");
            System.out.println("Class name:");
            String className = scanner.nextLine().trim();
            System.out.println("Starting Level:");
            int lvl = scanner.nextInt();
            System.out.println("Starting health:");
            int health = scanner.nextInt();
            CharacterType customCharacter = CharacterType.builder()
                    .className(className)
                    .level(lvl)
                    .health(health)
                    .armor(0.3f)
                    .critChance(13f)
                    .magicDamage(health/3)
                    .physicalDamage(health/3)
                    .magicResistance(0.2f)
                    .dodgeChance(0.3f)
                    .build();
            runGame(customCharacter, mage);
        } else {
            Character player1 = characterFactory.characterCreation(userInput);
            runGame(player1, mage);
        }
    }

    public void runGame(Character player1, Character player2){
        System.out.println("Starting Game");

        Random random = new Random();
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            String character1 = player1.className();
            String character2 = player2.className();
            System.out.println(character1 + "'s attacks!");
            int physicalDamage = player1.calculatePhysicalDamage(random);
            int magicDamage = player1.calculateMagicDamage(random);
            int physicalDamageTaken = player2.calculatePhysicalDamageTaken(random, physicalDamage);
            int magicDamageTaken = player2.calculateMagicDamageTaken(random, magicDamage);
            System.out.println(character1 + " deals " + physicalDamageTaken + " physical damage and "+ magicDamageTaken + " magic damage");
            player2.calculateHealth(physicalDamageTaken + magicDamageTaken);
            if(player2.getHealth() == 0) break;
            System.out.println(character2 + "'s attacks!");
            physicalDamage = player2.calculatePhysicalDamage(random);
            magicDamage = player2.calculateMagicDamage(random);
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
            player2.levelUp();
        }
    }
}

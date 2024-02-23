package com.swf;

import com.swf.classes.Mage;
import com.swf.classes.Warrior;

import java.util.Random;

public class Game {

    public void initializeGame(){
        System.out.println("Starting Game");
        Warrior warrior = new Warrior();
        Mage mage = new Mage();

        Random random = new Random();
        while (warrior.getHealth() > 0 && mage.getHealth() > 0) {
            System.out.println("Warrior's attacks!");
            int physicalDamage = warrior.calculatePhysicalDamage(random);
            int magicDamage = warrior.calculateMagicDamage(random);
            int physicalDamageTaken = mage.calculatePhysicalDamageTaken(random, physicalDamage);
            int magicDamageTaken = mage.calculateMagicDamageTaken(random, magicDamage);
            System.out.println("Warrior deals " + physicalDamageTaken + " physical damage and "+ magicDamageTaken + " magic damage");
            mage.calculateHealth(physicalDamageTaken + magicDamageTaken);
            if(mage.getHealth() == 0) break;
            System.out.println("Mage's attacks!");
            physicalDamage = mage.calculatePhysicalDamage(random);
            magicDamage = mage.calculateMagicDamage(random);
            physicalDamageTaken = warrior.calculatePhysicalDamageTaken(random, physicalDamage);
            magicDamageTaken = warrior.calculateMagicDamageTaken(random, magicDamage);
            System.out.println("Mage deals " + physicalDamageTaken + " physical damage and "+ magicDamageTaken + " magic damage");
            warrior.calculateHealth(physicalDamageTaken + magicDamageTaken);
        }

        if (warrior.getHealth() <= 0) {
            System.out.println("Mage wins!");
            mage.levelUp();
        } else {
            System.out.println("Warrior wins!");
            warrior.levelUp();
        }
    }
}

package com.swf;

import com.swf.classes.*;
import com.swf.classes.Character;

public class CharacterFactory {

    public Character characterCreation(int userChoice){
        return switch (userChoice) {
            case 1 -> createWarrior();
            case 2 -> createMage();
            case 3 -> createRogue();
            case 4 -> createPaladin();
            case 5 -> createHunter();
            default -> null;
        };
    }

    public Warrior createWarrior() {
        return new Warrior(1, 140, 40, 0, 0.4f, 0.1f, 5f, 5f);
    }

    public Paladin createPaladin() {
        return new Paladin(1, 120, 20, 20, 0.3f, 0.3f, 5f, 5f);
    }

    public Hunter createHunter() {
        return new Hunter(1, 100, 30, 30, 0.2f, 0.2f, 10f, 5f);
    }

    public Rogue createRogue() {
        return new Rogue(1, 90, 40, 20, 0.1f, 0.1f, 15f, 10f);
    }

    public Mage createMage() {
        return new Mage(1, 70, 0, 30, 0.0f, 0.4f, 7.5f, 2.5f);
    }
}

package com.swf;

import com.swf.characterClasses.*;
import com.swf.characterClasses.Character;

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

        return (Warrior) Warrior.builder().build();
    }

    public Paladin createPaladin() {
        return (Paladin) Paladin.builder().build();
    }

    public Hunter createHunter() {
        return (Hunter) Hunter.builder().build();
    }

    public Rogue createRogue() {
        return (Rogue) Rogue.builder().build();
    }

    public Mage createMage() {
        return (Mage) Mage.builder().build();
    }
}

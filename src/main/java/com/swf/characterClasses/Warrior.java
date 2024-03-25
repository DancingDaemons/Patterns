package com.swf.characterClasses;

public class Warrior extends CharacterType {

    public Warrior(){
        super(1, 140, 40, 0, 0.4f, 0.1f, 5f, 5f,  Warrior.class.getSimpleName());
    }

    @Override
    public String className(){
        return Warrior.class.getSimpleName();
    }

    @Override
    public void levelUp(){
        this.level++;
        this.health += 8;
        this.physicalDamage += 5;
        this.armor += 0.02f;
        this.magicResistance += 0.01f;
        this.critChance += 0.5f;
        this.dodgeChance += 0.5f;
    }
}

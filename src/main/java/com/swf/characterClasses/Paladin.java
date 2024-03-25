package com.swf.characterClasses;

public class Paladin extends CharacterType {

    public Paladin(int level, int health, int physicalDamage, int magicDamage, float armor, float magicResistance, float critChance, float dodgeChance) {
        super(level, health, physicalDamage, magicDamage, armor, magicResistance, critChance, dodgeChance, Rogue.class.getSimpleName());
    }
    @Override
    public String className(){
        return Paladin.class.getSimpleName();
    }
    @Override
    public void levelUp(){
        this.level++;
        this.health += 5;
        this.physicalDamage += 2;
        this.magicDamage += 2;
        this.armor += 0.01f;
        this.magicResistance += 0.01f;
        this.critChance += 0.5f;
        this.dodgeChance += 0.5f;
    }
}

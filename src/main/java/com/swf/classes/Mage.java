package com.swf.classes;


public class Mage extends CharacterType {

    public Mage(int level, int health, int physicalDamage, int magicDamage, float armor, float magicResistance, float critChance, float dodgeChance) {
        super(level, health, physicalDamage, magicDamage, armor, magicResistance, critChance, dodgeChance);
    }

    public void levelUp(){
        this.level++;
        this.health += 4;
        this.magicDamage += 7;
        this.magicResistance += 0.01f;
        this.critChance += 1f;
        this.dodgeChance += 0.5f;
    }

}

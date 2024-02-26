package com.swf.classes;

public class Warrior extends CharacterType {
    public Warrior(int level, int health, int physicalDamage, int magicDamage, float armor, float magicResistance, float critChance, float dodgeChance) {
        super(level, health, physicalDamage, magicDamage, armor, magicResistance, critChance, dodgeChance);
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

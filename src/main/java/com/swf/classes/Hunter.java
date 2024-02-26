package com.swf.classes;


public class Hunter extends Character{
    public Hunter(int level, int health, int physicalDamage, int magicDamage, float armor, float magicResistance, float critChance, float dodgeChance) {
        super(level, health, physicalDamage, magicDamage, armor, magicResistance, critChance, dodgeChance);
    }

    public void levelUp(){
        this.level++;
        this.health += 5;
        this.physicalDamage += 2;
        this.magicDamage += 2;
        this.armor += 0.02f;
        this.magicResistance += 0.01f;
        this.critChance += 0.5f;
        this.dodgeChance += 0.5f;
    }
}

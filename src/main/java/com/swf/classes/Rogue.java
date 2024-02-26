package com.swf.classes;

public class Rogue extends CharacterType {

    public Rogue(int level, int health, int physicalDamage, int magicDamage, float armor, float magicResistance, float critChance, float dodgeChance) {
        super(level, health, physicalDamage, magicDamage, armor, magicResistance, critChance, dodgeChance);
    }
    @Override
    public String className(){
        return Rogue.class.getSimpleName();
    }
    @Override
    public void levelUp(){
        this.level++;
        this.health += 4;
        this.physicalDamage += 6;
        this.armor += 0.01f;
        this.magicResistance += 0.01f;
        this.critChance += 0.5f;
        this.dodgeChance += 0.5f;
    }


}

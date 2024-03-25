package com.swf.characterClasses;

public class Rogue extends CharacterType {

    public Rogue() {
        super(1, 90, 40, 20, 0.1f, 0.1f, 15f, 10f, Rogue.class.getSimpleName());
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

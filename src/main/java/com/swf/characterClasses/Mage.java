package com.swf.characterClasses;


public class Mage extends CharacterType {

    public Mage() {
        super(1, 70, 0, 30, 0.0f, 0.4f, 7.5f, 2.5f, Rogue.class.getSimpleName());
    }
    @Override
    public String className(){
        return Mage.class.getSimpleName();
    }
    @Override
    public void levelUp(){
        this.level++;
        this.health += 4;
        this.magicDamage += 7;
        this.magicResistance += 0.01f;
        this.critChance += 1f;
        this.dodgeChance += 0.5f;
    }

}

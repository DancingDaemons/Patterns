package com.swf.characterClasses;

public class Paladin extends CharacterType {

    public Paladin() {
        super(1, 120, 20, 20, 0.3f, 0.3f, 5f, 5f, Paladin.class.getSimpleName());
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

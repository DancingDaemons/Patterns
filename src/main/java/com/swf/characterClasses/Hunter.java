package com.swf.characterClasses;


public class Hunter extends CharacterType {
    public Hunter() {
        super(1, 100, 30, 30, 0.2f, 0.2f, 10f, 5f, Hunter.class.getSimpleName());
    }
    @Override
    public String className(){
        return Hunter.class.getSimpleName();
    }
    @Override
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

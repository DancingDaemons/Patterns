package com.swf.characterClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Rogue {
    private int level = 1;
    private int health = 90;
    private int physicalDamage = 40;
    private int magicDamage = 20;
    private float armor = 0.1f;
    private float magicResistance = 0.1f;
    private float critChance = 15f;
    private float dodgeChance = 10f;

    public void levelUp(){
        this.level++;
        this.health += 4;
        this.physicalDamage += 6;
        this.armor += 0.01f;
        this.magicResistance += 0.01f;
        this.critChance += 0.5f;
        this.dodgeChance += 0.5f;
    }

    public int calculatePhysicalDamage(Random rand){
        int damage = physicalDamage;
        if (rand.nextFloat()*100 <= critChance){
            System.out.println("Critical hit!");
            damage *= 2;
        }
        return damage;
    }

    public int calculateMagicDamage(Random rand){
        int damage = magicDamage;
        if (rand.nextFloat()*100 <= critChance){
            System.out.println("Critical hit!");
            damage *= 2;
        }
        return damage;
    }

    public int calculatePhysicalDamageTaken(Random rand, int physicalDamage){
        int damageTaken = 0;
        if (rand.nextFloat()*100 <= dodgeChance){
            System.out.println("Dodge!");
            return damageTaken;
        }
        return (int) (physicalDamage - physicalDamage*armor);
    }
    public int calculateMagicDamageTaken(Random rand, int magicDamage){
        int damageTaken = 0;
        if (rand.nextFloat()*100 <= dodgeChance){
            System.out.println("Dodge!");
            return damageTaken;
        }
        return (int) (magicDamage - magicDamage*magicResistance);
    }
    public void calculateHealth(int damage){
        health -= damage;
        if (health < 0){
            health = 0;
        }
        System.out.println("Health: " + health);
    }
}

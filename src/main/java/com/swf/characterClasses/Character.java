package com.swf.characterClasses;

import java.util.Random;

public interface Character {
    int calculatePhysicalDamage(Random rand);
    int calculateMagicDamage(Random rand);
    int calculatePhysicalDamageTaken(Random rand, int physicalDamage);
    int calculateMagicDamageTaken(Random rand, int magicDamage);
    void calculateHealth(int damage);
    void levelUp();
    int getHealth();
    String className();
}

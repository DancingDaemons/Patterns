package com.swf.characterClasses;

import java.util.Random;

public interface Character {
    void levelUp();
    int calculatePhysicalDamage(Random rand);
    int calculateMagicDamage(Random rand);
    int calculatePhysicalDamageTaken(Random rand, int physicalDamage);
    int calculateMagicDamageTaken(Random rand, int magicDamage);
    void calculateHealth(int damage);
    int getHealth();
    String className();
}

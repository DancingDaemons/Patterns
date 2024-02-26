package com.swf.classes;

import java.util.Random;

public interface Character {
    int calculatePhysicalDamage(Random rand);
    int calculateMagicDamage(Random rand);
    int calculatePhysicalDamageTaken(Random rand, int physicalDamage);
    int calculateMagicDamageTaken(Random rand, int magicDamage);
    public void calculateHealth(int damage);
    void levelUp();
}

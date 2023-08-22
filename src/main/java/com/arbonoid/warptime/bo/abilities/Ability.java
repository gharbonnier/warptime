package com.arbonoid.warptime.bo.abilities;

import com.arbonoid.warptime.bo.roll.Jet;
import com.arbonoid.warptime.bo.Weapon;

public interface Ability {

    void process(Weapon weapon, Jet jet);

}

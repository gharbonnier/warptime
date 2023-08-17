package com.arbonoid.warptime.bo.abilities;

import com.arbonoid.warptime.bo.roll.Dice;
import com.arbonoid.warptime.bo.roll.Jet;
import com.arbonoid.warptime.bo.Weapon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SustainedHits implements Ability{

    private int x;

    public SustainedHits(int x)
    {
        this.x = x;
    }

    @Override
    public void process(Weapon weapon, Jet jet) {
        List<Dice> criticalDices = new ArrayList<Dice>();
        for(Dice dice : jet.getJet())
            if(dice.isCritical()) {
                criticalDices.add(dice);
            }
        for(Dice dice : criticalDices)
            jet.add(dice.getDiceType(), this.x, dice.getValue());
    }
}
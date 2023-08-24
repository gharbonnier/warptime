package com.arbonoid.warptime.bo.roll;

import com.arbonoid.warptime.bo.Target;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@SuperBuilder
public class WoundJet extends Jet{

    public static WoundJet build(DiceType diceType, int numberOfDice, int criticalThreshold)
    {
        WoundJet jet = WoundJet.builder().dices(new ArrayList<Dice>()).build();
        jet.add(diceType, numberOfDice,0, criticalThreshold);
        return jet;
    }

    @Override
    public void add(DiceType type, int numberOfDice, int diceValue, int criticalThreshold) {
        for(int i=0;i<numberOfDice;i++)
            dices.add(WoundDice.build(type,diceValue, criticalThreshold));
    }

    public long getNbSucceedWound(int force, int endurance, int damage)
    {
        return dices.stream().filter(dice -> ((WoundDice)dice).checkWound(force, endurance, damage) ).count();
    }
}

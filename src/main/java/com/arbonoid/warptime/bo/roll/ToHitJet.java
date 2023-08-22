package com.arbonoid.warptime.bo.roll;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@SuperBuilder
public class ToHitJet extends Jet{

    public static ToHitJet build(DiceType diceType, int numberOfDice, int criticalThreshold)
    {
        ToHitJet jet = ToHitJet.builder().dices(new ArrayList<Dice>()).build();
        jet.add(diceType, numberOfDice,0, criticalThreshold);
        return jet;
    }

    @Override
    public void add(DiceType type, int numberOfDice, int diceValue, int criticalThreshold) {
        for(int i=0;i<numberOfDice;i++)
            dices.add(ToHitDice.build(type,diceValue, criticalThreshold));
    }

    public long getNbSucceedHit(int threshold)
    {
        return dices.stream().filter(dice -> ((ToHitDice)dice).checkHit(threshold) ).count();
    }
}

package com.arbonoid.warptime.bo.roll;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@SuperBuilder
public class ToHitJet extends Jet{

    public static ToHitJet build(DiceType diceType, int numberOfDice)
    {
        ToHitJet jet = ToHitJet.builder().dices(new ArrayList<Dice>()).build();
        jet.add(diceType, numberOfDice,0);
        return jet;
    }

    @Override
    public void add(DiceType type, int numberOfDice, int diceValue) {
        for(int i=0;i<numberOfDice;i++)
            dices.add(ToHitDice.build(type,diceValue));
    }

    public long getNbHit(int threshold)
    {
        return dices.stream().filter(dice -> ((ToHitDice)dice).checkHit(threshold) ).count();
    }
}

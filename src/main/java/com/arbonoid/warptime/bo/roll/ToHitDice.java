package com.arbonoid.warptime.bo.roll;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ToHitDice extends Dice{

    public static ToHitDice build(DiceType diceType, int value)
    {
        return ToHitDice.builder().max(diceType.getMax()).value(value).diceType(diceType).build();
    }

    public boolean hit(int threshold)
    {
        return value >= threshold;
    }
}

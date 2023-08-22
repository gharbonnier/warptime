package com.arbonoid.warptime.bo.roll;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper=true)
@Getter
@SuperBuilder
public class ToHitDice extends Dice{

    private boolean hit;

    public static ToHitDice build(DiceType diceType, int value, int criticalThreshold)
    {
        return ToHitDice.builder().max(diceType.getMax()).value(value).criticalThreshold(criticalThreshold).diceType(diceType).hit(false).build();
    }

    public boolean checkHit(int threshold)
    {
        this.hit = (value >= threshold);
        return this.hit;
    }

}

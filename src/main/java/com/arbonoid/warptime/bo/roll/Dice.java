package com.arbonoid.warptime.bo.roll;

import lombok.*;
import lombok.experimental.SuperBuilder;


@ToString
@Getter
@SuperBuilder
public abstract class Dice {

    protected Integer max;

    protected Integer value;

    protected DiceType diceType;

    public Integer roll()
    {
        this.value = (int)(Math.random()*max + 1);
        return this.value;
    }

    public boolean isCritical()
    {
        return value >= 6;
    }

}

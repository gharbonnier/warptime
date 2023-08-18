package com.arbonoid.warptime.bo.roll;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@ToString
@SuperBuilder
@FieldDefaults(level = PRIVATE)
public abstract class Jet {

    protected List<Dice> dices;

    public abstract void add(DiceType type, int numberOfDice, int diceValue);

    public Jet roll()
    {
        for(Dice dice : dices)
            dice.roll();
        return this;
    }

}

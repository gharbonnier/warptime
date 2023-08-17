package com.arbonoid.warptime.bo.roll;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@ToString
@FieldDefaults(level = PRIVATE)
public class Jet {

    List<Dice> jet;

    public static Jet build(DiceType type, int numberOfDice)
    {
        Jet jet = new Jet();
        jet.addNewDice(type, numberOfDice);
        return jet;
    }

    private Jet()
    {
        jet = new ArrayList<Dice>();
    }

    private void addNewDice(DiceType type, int numberOfDice)
    {
        for(int i=0;i<numberOfDice;i++)
            jet.add(ToHitDice.build(type,0));
    }

    public void add(DiceType type, int numberOfDice, int diceValue)
    {
        for(int i=0;i<numberOfDice;i++)
            jet.add(ToHitDice.build(type,diceValue));
    }

    public Jet roll()
    {
        for(Dice dice : jet)
            dice.roll();
        return this;
    }

}

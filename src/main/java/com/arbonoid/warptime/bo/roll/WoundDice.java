package com.arbonoid.warptime.bo.roll;

import com.arbonoid.warptime.tools.ToWoundTable;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper=true)
@Getter
@SuperBuilder
public class WoundDice extends Dice{

    private boolean wound;

    private int damage;

    public static WoundDice build(DiceType diceType, int value, int criticalThreshold)
    {
        return WoundDice.builder().max(diceType.getMax()).value(value).criticalThreshold(criticalThreshold).diceType(diceType).damage(0).wound(false).build();
    }

    public boolean checkWound(int force, int endurance, int damage)
    {
        this.wound = (value >= ToWoundTable.minDiceValueToWound(force,endurance));
        if(this.wound)
            this.damage = damage;
        return this.wound;
    }

}

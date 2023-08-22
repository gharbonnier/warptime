package com.arbonoid.warptime.bo;

import com.arbonoid.warptime.bo.abilities.EAbility;
import com.arbonoid.warptime.bo.roll.Dice;
import com.arbonoid.warptime.bo.roll.DiceType;
import com.arbonoid.warptime.bo.roll.Jet;
import com.arbonoid.warptime.bo.roll.ToHitJet;
import com.arbonoid.warptime.tools.ToWoundTable;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@ToString
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = PROTECTED)
public abstract class Weapon {

    Integer attack;

    Integer armourPenetration;

    Integer force;

    Integer damage;

    EAbility[] abilities;

    protected abstract long evalHit(Jet jet);

    public boolean evalWound(Integer endurance, Jet jet) {
        for(EAbility ability : abilities)
            ability.getAbility().process(this, jet);
       // return dice.getValue() >= ToWoundTable.minDiseValueToWound(force, endurance);
        return true;
    }

    /**
     *
     * @param target
     * @return
     */
    public long fire(Target target)
    {
        ToHitJet toHitJet = ToHitJet.build(DiceType.D6, this.attack, 6);
        toHitJet.roll();
        return evalHit(toHitJet);
    }

}

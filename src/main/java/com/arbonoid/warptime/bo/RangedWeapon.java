package com.arbonoid.warptime.bo;

import com.arbonoid.warptime.bo.abilities.EAbility;
import com.arbonoid.warptime.bo.roll.Dice;
import com.arbonoid.warptime.bo.roll.Jet;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

@ToString(callSuper = true)
@SuperBuilder
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class RangedWeapon extends Weapon{

    private Integer ballisticSkill;

    @Override
    public boolean evalHit(Jet jet) {
        for(EAbility ability : abilities)
            ability.getAbility().process(this, jet);
        //return dice.getValue() > ballisticSkill;
        return true;
    }

}

package com.arbonoid.warptime.bo;

import com.arbonoid.warptime.bo.abilities.EAbility;
import com.arbonoid.warptime.bo.roll.DiceType;
import com.arbonoid.warptime.bo.roll.Jet;
import com.arbonoid.warptime.bo.roll.HitJet;
import com.arbonoid.warptime.bo.roll.WoundJet;
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
    public long evalHit(Jet jet) {
        for(EAbility ability : abilities)
            ability.getAbility().process(this, jet);
        return ((HitJet)jet).getNbSucceedHit(ballisticSkill);
    }

    @Override
    public long fire(Target target)
    {
        HitJet hitJet = HitJet.build(DiceType.D6, this.attack, 6);
        hitJet.roll();

        WoundJet woundJet = WoundJet.build(DiceType.D6,(int)evalHit(hitJet),6);
        woundJet.roll();
        long result = evalWound(target,woundJet);

        System.out.println(hitJet);
        System.out.println(woundJet);

        return result;
    }

}

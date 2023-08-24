package com.arbonoid.warptime.bo;

import com.arbonoid.warptime.bo.roll.DiceType;
import com.arbonoid.warptime.bo.roll.HitJet;
import com.arbonoid.warptime.bo.roll.Jet;
import com.arbonoid.warptime.bo.roll.WoundJet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

@ToString(callSuper = true)
@SuperBuilder
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class MeleeWeapon extends Weapon{

    private Integer weaponSkill;

    @Override
    public long evalHit(Jet jet) {
        //return dice.getValue() > weaponSkill;
        return 1;
    }

    @Override
    public long fire(Target target)
    {
        HitJet hitJet = HitJet.build(DiceType.D6, this.attack, 6);
        hitJet.roll();
        WoundJet woundJet = WoundJet.build(DiceType.D6,(int)hitJet.getNbSucceedHit(this.weaponSkill),6);
        woundJet.roll();
        return evalWound(target,woundJet);
    }

}

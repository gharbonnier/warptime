package com.arbonoid.warptime.bo;

import com.arbonoid.warptime.bo.abilities.EAbility;
import com.arbonoid.warptime.bo.roll.DiceType;
import com.arbonoid.warptime.bo.roll.Jet;
import com.arbonoid.warptime.bo.roll.HitJet;
import com.arbonoid.warptime.bo.roll.WoundJet;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

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

    protected long evalWound(Target target, WoundJet jet) {
        for(EAbility ability : abilities)
            ability.getAbility().process(this, jet);
        return jet.getNbSucceedWound(this.force, target.getEndurance(), this.damage);
    }

    /**
     *
     * @param target
     * @return
     */
    public abstract long fire(Target target);

}

package com.arbonoid.warptime.bo;

import com.arbonoid.warptime.bo.roll.Jet;
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

}

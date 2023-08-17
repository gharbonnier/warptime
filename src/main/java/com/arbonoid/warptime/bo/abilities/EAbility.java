package com.arbonoid.warptime.bo.abilities;

import lombok.Getter;

@Getter
public enum EAbility {

    SUSTAINED_HITS_2(new SustainedHits(2));

    private Ability ability;

    private EAbility(Ability ability)
    {
        this.ability = ability;
    }
}

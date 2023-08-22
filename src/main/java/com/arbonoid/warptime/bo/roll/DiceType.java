package com.arbonoid.warptime.bo.roll;

import lombok.Getter;

@Getter
public enum DiceType {

    D3(3), D6(6);

    private final int max;

    DiceType(int max) {
        this.max = max;
    }
}

package com.arbonoid.warptime.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@ToString
@Getter
@Setter
@Builder
@FieldDefaults(level = PRIVATE)
public class Target {

    Integer endurance;

}

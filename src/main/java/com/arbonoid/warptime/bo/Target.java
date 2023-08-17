package com.arbonoid.warptime.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@ToString
@Getter
@Setter
@Builder
@FieldDefaults(level = PRIVATE)
public class Target {

    Integer endurance;

}

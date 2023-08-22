package com.arbonoid.warptime.tools;

public class ToWoundTable {

    public static Integer minDiceValueToWound(Integer force, Integer endurance)
    {
        int compareToResult = endurance.compareTo(force);
        if(  compareToResult == 0)
            return 4;
        else
            if( compareToResult > 0 )
                return ( force * 2 <= endurance)?6:5;
            else
                return ( endurance * 2 <= force)?2:3;
    }

}

package com.HishaTech.android.rearrange;

/**
 * Created by smithkev on 2/9/2015.
 */
public class Conversions {

    public static boolean TrueFalseIntToBoolean(int intValue) {
        boolean boolValue = false;
        if (intValue == 1) {
            boolValue = true;
        }
        return boolValue;
    }

    public static int BooleanToTrueFalseInt(boolean boolValue) {
        int intValue = 0;
        if (boolValue == true) {
            intValue = 1;
        }
        return intValue;
    }

}

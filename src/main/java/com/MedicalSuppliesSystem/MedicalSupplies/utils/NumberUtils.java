package com.MedicalSuppliesSystem.MedicalSupplies.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberUtils {

    private static final DecimalFormat decFormat = new DecimalFormat("#.###");

    public static Double roundDecimal(double value) {
        decFormat.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(decFormat.format(value));
    }

}

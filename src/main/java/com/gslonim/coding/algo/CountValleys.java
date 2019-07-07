package com.gslonim.coding.algo;

public class CountValleys {
    public static int countingValleys(int numSteps, String steps) {
        String[] stepArray = steps.split("");
        if (stepArray.length == 0) {
            return 0;
        }

        int valleyCounter = 0, mountCounter = 0, valleyLevel = 0, mountLevel = 0;
        boolean valley = false, mountain = false;

        for (int i = 0; i < numSteps; i++) {
            if ("D".equals(stepArray[i])) {
                if (mountLevel != 0) {
                    mountLevel--;
                } else {
                    valleyLevel--;
                    valley = true;
                    mountain = false;
                }
            } else {
                if (valleyLevel != 0) {
                    valleyLevel++;
                } else {
                    mountLevel++;
                    mountain = true;
                    valley = false;
                }
            }

            if (valley && valleyLevel == 0) {
                valleyCounter++;
            }
            if (mountain && mountLevel == 0) {
                mountCounter++;
            }
        }
        return valleyCounter;
    }
}

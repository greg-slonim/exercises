package com.gslonim.coding.systems;

import java.util.List;

public class Sample_Load_and_Auto_Scale_Instances {
        public static int finalInstances(int instances, List<Integer> averageUtil) {
            // Write your code here
            int currentInstances = instances;
            int index = 0;
            boolean actionTaken = false;

            while(index < averageUtil.size()) {
                if (actionTaken) {
                    index = forwardIndex(index, averageUtil.size());
                    if (index == averageUtil.size()) {
                        break;
                    }
                    actionTaken = false;
                }
                int utilisation = averageUtil.get(index);

                if (utilisation > 60) {
                    currentInstances = doubleIfWithinLimits(currentInstances);
                    actionTaken = true;
                }
                if (utilisation < 25) {
                    currentInstances = halfIfWithinLimits(currentInstances);
                    actionTaken = true;
                }
                index++;
            }
            return currentInstances;
        }

    private static int forwardIndex(int currIndex, int size) {
        return Math.min(currIndex + 10, size);
    }

    private static int doubleIfWithinLimits(int currentInstances) {
            if (currentInstances <= 10_000_000) {
                return currentInstances * 2;
            }
            return currentInstances;
        }

        private static int halfIfWithinLimits(int currentInstances) {
            if (currentInstances > 1) {
                return currentInstances / 2;
            }
            return currentInstances;
        }
}

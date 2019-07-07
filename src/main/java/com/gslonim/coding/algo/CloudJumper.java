package com.gslonim.coding.algo;

public class CloudJumper {

    static int jumpingOnClouds(int[] clouds) {
        int position = 0, steps = 0;

        if (clouds.length == 0) {
            return 0;
        }
        if (clouds.length == 1 && clouds[0] == 0) {
            return 1;
        }

        while(inBounds(position, clouds.length)) {
            if (inBounds(position + 2, clouds.length) && clouds[position + 2] == 0) {
                position = position + 2;
            } else if (inBounds(position + 1, clouds.length)){
                position++;
            } else {
                break;
            }
            steps++;
        }
        return steps;
    }

    private static boolean inBounds(int position, int size) {
        return position < size;
    }
}

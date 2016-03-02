package com.collaroid.test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by MacBookAir on 2/10/15.
 */
public class PdfAndCdf {

    private static float[] probability = {0.4f, 0.6f};

    /**
     * pdf 2 cdf
     * @param pdf
     * @return
     */
    private static float[] pdf2cdf(float[] pdf) {

        float[] cdf = pdf.clone();
        for (int i = 1; i < cdf.length - 1; i++) {
            cdf[i] += cdf[i - 1];
        }
        // Force set last cdf to 1, preventing floating-point summing error in the loop.
        cdf[cdf.length - 1] = 1;
        return cdf;
    }

    /**
     * according to cdf, to choose which one is target.
     * @param cdf
     * @return
     */
    private static int chooseTarget(float[] cdf){
        double random = Math.random();
        for (int i = 0; i < cdf.length; i++){
            if (random < cdf[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        float[] cdf = pdf2cdf(probability);
        int count = 0;
        float[] target = cdf.clone();
        // init
        for (int i = 0; i < target.length; i++){
            target[i] = 0;
        }

        for (int i = 0; i < 100000; i++){
            int index  = chooseTarget(cdf);
            target[index]++;
            count++;
        }

        for (int i = 0; i < target.length; i++){
            target[i] /= count;
        }

        System.out.println(Arrays.toString(target));
    }


}

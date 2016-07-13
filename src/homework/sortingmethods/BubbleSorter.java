package homework.sortingmethods;

import java.util.Random;

/**
 * @author ParseJava on 19.06.2016.
 */
public class BubbleSorter {

    public static void main(String[] args) {
        int[] data = new int[100*1000];

        Random numberGenerator = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = numberGenerator.nextInt(1000);
        }

//      System.out.println(Arrays.toString(data));

        long startTime = System.currentTimeMillis();

        for (int i = data.length - 1; i > 0; i--) {
            for (int j = data.length - 1 - i; j >= 0; j--) {
                getSwapConditional(data, j, j + 1);
            }
        }

        long testTime = System.currentTimeMillis() - startTime;

        System.out.println("testTime = " + testTime);
//        System.out.println(Arrays.toString(data));
    }

    private static void getSwapConditional(int[] data, int first, int second) {
        if (data[first] > data[second]) {
            int swap = data[second];
            data[second] = data[first];
            data[first] = swap;
        }
    }
}

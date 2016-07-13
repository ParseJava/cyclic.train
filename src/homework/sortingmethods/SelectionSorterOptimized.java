package homework.sortingmethods;

import java.util.Random;

/**
 * @author ParseJava on 19.06.2016.
 */
public class SelectionSorterOptimized {

    public static void main(String[] args) {
        int[] data = new int[100*1000];

        fillRandomNumber(data, 1000);

        long startTime = System.currentTimeMillis();

        sortSelectionMethodOptimized(data);

        long testTime = System.currentTimeMillis() - startTime;

        System.out.println("testTime = " + testTime);

//        System.out.println(Arrays.toString(data));

//        System.out.println(Arrays.toString(sortSelectionMethodOptimized(data)));
    }

    private static void fillRandomNumber(int[] data, int maxNumber) {
        Random number = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = number.nextInt(maxNumber);
        }
    }

    private static int[] sortSelectionMethodOptimized(int[] data) {
        int swapIndex = 0;

        for (int barrier = 0; barrier < data.length; barrier++) {
            int minNumber = data[barrier];

            boolean swapBoolean = false;

            for (int index = barrier + 1; index < data.length - 1; index++) {
                if (minNumber > data[index + 1]) {
                    minNumber = data[index + 1];
                    swapIndex = index + 1;
                    swapBoolean = true;
                }
            }

            if (swapBoolean) {
                int swap = data[barrier];
                data[barrier] = data[swapIndex];
                data[swapIndex] = swap;
            }
        }

        return data;
    }
}

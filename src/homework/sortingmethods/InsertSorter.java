package homework.sortingmethods;

import java.util.Random;

/**
 * @author ParseJava on 20.06.2016.
 */
public class InsertSorter {

    public static void main(String[] args) {
        int[] data = new int[100 * 1000];

        arrayFillRandomNumber(data, 1000);

//        System.out.println(Arrays.toString(data));

        long startTime = System.currentTimeMillis();

        sortInsertMethod(data);

        long testTime = System.currentTimeMillis() - startTime;

        System.out.println("testTime = " + testTime);

//        System.out.println(Arrays.toString(data));
    }

    private static void sortInsertMethod(int[] data) {
        for (int barrier = 1; barrier < data.length; barrier++) {
            for (int index = barrier; index > 0; index--) {
                while (data[index - 1] > data[index]) {
                    int swap = data[index];
                    data[index] = data[index - 1];
                    data[index - 1] = swap;
                }
            }
        }
    }

    private static void arrayFillRandomNumber(int[] data, int maxRandomNumber) {
        Random number = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = number.nextInt(maxRandomNumber);
        }
    }
}

package homework.sortingmethods;

import java.util.Random;

/**
 * @author ParseJava on 20.06.2016.
 */
public class SelectionSorter {

    public static void main(String[] args) {
        int[] data = new int[100 * 1000];

        fillRandomNumber(data, 1000);

//        System.out.println(Arrays.toString(data));

        long startTime = System.currentTimeMillis();

        sortSelectionMethod(data);

        long testTime = System.currentTimeMillis() - startTime;

        System.out.println("testTime = " + testTime);

//        System.out.println(Arrays.toString(data));

//        System.out.println(Arrays.toString(sortSelectionMethod(data)));
    }



    private static void fillRandomNumber(int[] data, int maxNumber) {
        Random number = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = number.nextInt(maxNumber);
        }
    }



    private static int[] sortSelectionMethod(int[] data) {
        for (int barrier = 0; barrier < data.length; barrier++) {
            for (int index = barrier + 1; index < data.length; index++) {
                if (data[barrier] > data[index]) {
                    int swap = data[barrier];
                    data[barrier] = data[index];
                    data[index] = swap;
                }
            }
        }

        return data;
    }
}
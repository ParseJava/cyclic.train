package homework.sortingmethods;

import java.util.Random;

/**
 * @author ParseJava on 20.06.2016.
 */
public class InsertSorterOptimized {

    public static void main(String[] args) {
        int[] data = new int[100 * 1000];

        fillRandomNumber(data, 1000);

//        System.out.println(Arrays.toString(data));
        long startTime = System.currentTimeMillis();

        sortInsertMethodOptimized(data);

        long testTime = System.currentTimeMillis() - startTime;

        System.out.println("testTime = " + testTime);

//        System.out.println(Arrays.toString(data));
    }


    private static void sortInsertMethodOptimized(int[] data) {
        for (int barrier = 1; barrier < data.length; barrier++) {
            for (int index = barrier; index == barrier; index--) {

                if (data[barrier - 1] > data[barrier]) {
                    int swap = data[barrier];

                    int indexBinarySearch = binarySearch(data, 0, index, data[barrier]);

                    if (indexBinarySearch >= 0) {
                        int srcPosition = indexBinarySearch;

                        System.arraycopy(data, srcPosition, data, srcPosition + 1, barrier - srcPosition);

                        data[srcPosition] = swap;
                    } else {
                        int srcPosition = (indexBinarySearch * -1) - 1;

                        System.arraycopy(data, srcPosition, data, srcPosition + 1, barrier - srcPosition);

                        data[srcPosition] = swap;
                    }

//                    if (indexBinarySearch < 0) {
//                        int srcPosition = (indexBinarySearch * -1) - 1;
//
//                        System.arraycopy(data, srcPosition, data, srcPosition + 1, barrier - srcPosition);
//
//                        data[srcPosition] = swap;
//                    } else {
//                        int srcPosition = indexBinarySearch;
//
//                        System.arraycopy(data, srcPosition, data, srcPosition + 1, barrier - srcPosition);
//
//                        data[srcPosition] = swap;
//                    }
                }
            }
        }
    }

    private static void fillRandomNumber(int[] data, int maxRandomNumber) {
        Random number = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = number.nextInt(maxRandomNumber);
        }
    }


    private static int binarySearch(int[] data, int fromIndex, int toIndex, int key) {
        toIndex = toIndex - 1;

        while (fromIndex <= toIndex) {
            int indexMiddle = (fromIndex + toIndex) >>> 1;
            int valueMiddle = data[indexMiddle];

            if (valueMiddle < key) {
                fromIndex = indexMiddle + 1;
            } else if (valueMiddle > key) {
                toIndex = indexMiddle - 1;
            } else {
                return indexMiddle;
            }
        }

        return -(fromIndex + 1);
    }
}
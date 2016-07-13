package homework.recursion;

/**
 * @author ParseJava on 22.06.2016.
 */
public class Fibonacci {

    public static void main(String[] args) {
        int value = 0;

        while (value < 40) {
            System.out.println("fibonacci (" + value + ") = " + calculateFibonacci(value));
            value++;
        }
    }

    private static int calculateFibonacci(int value) {
        checkFibonacci(value);

        return (value < 2) ? 1 : calculateFibonacci(value - 1) + calculateFibonacci(value - 2);
    }

    private static void checkFibonacci(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("fibonacci value must be > 0, but fibonacci = " + value);
        }
    }
}

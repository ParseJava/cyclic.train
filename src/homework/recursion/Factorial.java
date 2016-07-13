package homework.recursion;

/**
 * @author ParseJava on 22.06.2016.
 */
public class Factorial {

    public static void main(String[] args) {
        int factorial = 0;

        while (factorial < 6) {
            System.out.println("factorial(" + factorial + ") = " + calculateFactorial(factorial));
            factorial++;
        }
    }


    private static int calculateFactorial(int factorial) {
        checkFactorial(factorial);

        return (factorial < 2) ? 1 : factorial * calculateFactorial(factorial - 1);
    }


    private static void checkFactorial(int factorial) {
        if (factorial < 0) {
            throw new IllegalArgumentException("factorial must be > 0, but factorial = " + factorial);
        }
    }
}

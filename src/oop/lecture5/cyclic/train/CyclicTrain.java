package oop.lecture5.cyclic.train;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ParseJava on 16.07.2016.
 */
public class CyclicTrain implements Train {

    private Random random = new Random();
    private int trainLength = random.nextInt(10) + 1; // +1 do not allow make zero length train
    private int currentPosition = random.nextInt(trainLength);

    private List<Train> train = new ArrayList<>(trainLength);


    public CyclicTrain() {
        for (int i = 0; i < trainLength; i++) {
            train.add(new Carriage());
        }
    }

    public List<Train> getTrain() {
        return train;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void turnLeft() {
        currentPosition--;
        if (currentPosition < 0) {
            currentPosition = trainLength - 1;
        }
    }

    @Override
    public void turnRight() {
        currentPosition++;
        if (currentPosition > trainLength - 1) {
            currentPosition = 0;
        }
    }

    @Override
    public void lightOn() {
        train.get(currentPosition).lightOn();
    }

    @Override
    public void lightOff() {
        train.get(currentPosition).lightOff();
    }

    public boolean isLight() {
        return train.get(currentPosition).isLight();
    }

    @Override
    public boolean isLength(int expectedLength) {
        return (expectedLength == trainLength - 1);
    }

    public static int findLength(Train train) {
        int stepLeft = 0;
        boolean matchSameCarriage = train.isLength(0);

        if (matchSameCarriage) {
            stepLeft++;
            return stepLeft;
        } else {
            if (train.isLight()) {

                train.lightOff();
                do {
                    stepLeft++;
                    train.turnLeft();
                } while (train.isLight());

            } else {
                do {
                    stepLeft++;
                    train.turnLeft();
                } while (train.isLight());
            }
        }

        train.lightOn();

        doStepRight(train, stepLeft);

        if (train.isLight()) {
            return stepLeft;
        } else {
            return findLength(train); // return the same method (recursion)
        }
    }

    private static void doStepRight(Train train, int stepBack) {
        int stepRight = stepBack;

        while (stepRight > 0) {
            stepRight--;
            train.turnRight();
        }
    }

    @Override
    public String toString() {
        return "CyclicTrain{" +
                train + '}';
    }
}

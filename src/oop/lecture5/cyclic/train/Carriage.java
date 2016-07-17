package oop.lecture5.cyclic.train;

/**
 * @author ParseJava on 16.07.2016.
 */
public class Carriage implements Train {

    private boolean light = false;

    public Carriage() {
        if (Math.random() > 0.4) {
            lightOn();
        } else {
            lightOff();
        }
    }

    @Override
    public void turnLeft() {
    }

    @Override
    public void turnRight() {
    }

    @Override
    public void lightOn() {
        light = true;
    }

    @Override
    public void lightOff() {
        light = false;
    }

    @Override
    public boolean isLight() {
        return (light);
    }

    @Override
    public boolean isLength(int expectedLength) {
        return false;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "light=" + isLight() +
                '}';
    }
}

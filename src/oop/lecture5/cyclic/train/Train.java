package oop.lecture5.cyclic.train;

/**
 * @author ParseJava on 16.07.2016.
 */
public interface Train {
    void turnLeft();
    void turnRight();
    void lightOn();
    void lightOff();
    boolean isLight();

    boolean isLength(int expectedLength);
}

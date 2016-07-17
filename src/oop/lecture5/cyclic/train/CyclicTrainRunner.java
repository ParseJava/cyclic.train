package oop.lecture5.cyclic.train;

/**
 * @author ParseJava on 16.07.2016.
 */
public class CyclicTrainRunner {

    public static void main(String[] args) {
        Train train = new CyclicTrain();

        System.out.println(train.toString());

        int lengthTrain = CyclicTrain.findLength(train);

        System.out.println("Train length = " + lengthTrain);

        System.out.println(train.toString());
    }
}

//        CyclicTrain{[Carriage{light=true}, Carriage{light=true}, Carriage{light=false}]}
//        Train length = 3
//        CyclicTrain{[Carriage{light=true}, Carriage{light=true}, Carriage{light=true}]}

//        CyclicTrain{[Carriage{light=false}, Carriage{light=false}, Carriage{light=false}, Carriage{light=true}]}
//        Train length = 4
//        CyclicTrain{[Carriage{light=true}, Carriage{light=true}, Carriage{light=true}, Carriage{light=true}]}


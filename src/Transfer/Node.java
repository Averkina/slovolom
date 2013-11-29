package Transfer;

import java.util.Observer;


public class Node {

    //    boolean receive = false;
    public static void main(String[] args) {

        Transport transport = new Transport();
        Observer outputForm = new OutputForm();
        transport.addObserver(outputForm);
    }
}

package TransportModel;

import java.util.ArrayList;
import java.util.List;

class Node implements AbstractNode {

    private AbstractTransport transport;
    private List<Integer> messageQueue;

    public Node() {
        messageQueue = new ArrayList<Integer>();

        Thread thread = new MyThread();
        thread.start();
    }

    @Override
    public void receiveMessage(int message) {
        System.out.printf("receiveMessage: %d\n", message);

        messageQueue.add(message);
        System.out.println("Message Queue" + messageQueue);
    }

    @Override
    public void setTransport(AbstractTransport newTransport) {
        transport = newTransport;
    }

    private class MyThread extends Thread {

        public void run() {

            for (int i = 0; i < 10; i++) {

                int numberForTransport = (int)(Math.random() * 100);

                transport.sendMessage(numberForTransport);

                try {
                    sleep(500);
                } 
                catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
    }

}
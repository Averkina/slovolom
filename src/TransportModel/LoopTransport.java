package TransportModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class LoopTransport implements AbstractTransport {

    private List<AbstractNode> abstractNodes;

    private List<Integer> messageQueue;
    
    public LoopTransport() {
        messageQueue = new ArrayList<Integer>();
        abstractNodes = new ArrayList<AbstractNode>();
        

        Thread thread = new MyThread();
        thread.start();
    }
    
    public void sendMessage(int message) {
        System.out.println("Send messege: " + message);
        messageQueue.add(message);
    }

    @Override
    public void setNode(AbstractNode node) {
        abstractNodes.add(node);
    }

    private class MyThread extends Thread {

        public void run() {

            for(int i = 0; i < 10; i++) {
                System.out.println("Checking queue in transport...");
                
                if (!messageQueue.isEmpty()) {
                    int numberForNode = messageQueue.get(0);
                    messageQueue.remove(0);

                    for (AbstractNode abstractNode : abstractNodes) {
                        abstractNode.receiveMessage(numberForNode);
                    }
                }
                

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

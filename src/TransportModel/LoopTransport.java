package TransportModel;
import java.util.ArrayList;
import java.util.List;

class LoopTransport implements AbstractTransport {

    private List<AbstractNode> abstractNodes;
    private int temperature;

    public LoopTransport() {
        temperature = 1;
        abstractNodes = new ArrayList<AbstractNode>();

        Thread thread = new MyThread();
        thread.start();
    }

    public void resetTemparature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void setNode(AbstractNode node) {
        abstractNodes.add(node);
    }

    private void notifyObservers() {
        for (AbstractNode abstractNode : abstractNodes) {
            abstractNode.update(temperature);
        }
    }

    private class MyThread extends Thread {

        public void run() {

            for(int i = 0; i < 10; i++) {
                System.out.println("Update of sensors");
                temperature = (int)(Math.random() * 100);
                resetTemparature(temperature);
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

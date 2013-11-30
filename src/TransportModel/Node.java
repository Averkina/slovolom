package TransportModel;

class Node implements AbstractNode {
    private int temperature;
    //        private AbstractTransport abstractTransport;

    public Node() {
        //        abstractTransport = newTransport;
    }

    @Override
    public void update(int temperature) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.printf("Values: %d temperature\n", temperature);
    }

    @Override
    public void setTransport(AbstractTransport transport) {
        // TODO Auto-generated method stub
        
    }
}
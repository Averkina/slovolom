package TransportModel;

interface AbstractNode {

    void receiveMessage(int message);
    void setTransport(AbstractTransport transport);

}
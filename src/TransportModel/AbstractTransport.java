package TransportModel;

interface AbstractTransport {

    void sendMessage(int message);
    void setNode(AbstractNode node);
    
}
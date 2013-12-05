package TransportModel;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        LoopTransport loopTransport = new LoopTransport();
        Node node = new Node();
        loopTransport.setNode(node);
        node.setTransport(loopTransport);

     }
}

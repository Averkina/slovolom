package Messages;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class StopGameMessage implements Message {

    Map<String, List<String>> map = new HashMap<String, List<String>>();

    int result;

}

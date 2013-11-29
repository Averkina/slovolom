package Messages;

//import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

public abstract class StartGameMessage implements Message {

    String word;

//    SimpleDateFormat format = new SimpleDateFormat("hh:mm");
//
//    DateTimeDV time;

    int seconds;
}

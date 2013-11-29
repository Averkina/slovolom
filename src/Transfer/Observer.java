package Transfer;

import java.util.Observable;

public interface Observer {

    void update(Observable node, Object arg);
    
}

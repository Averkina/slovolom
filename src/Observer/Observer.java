package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Observer {

    List list = new ArrayList();
    void addObserver(Observable player) {
        list.add(player);
    }
    void removeObserver(Observer player) {
        list.remove(player);
    }

    void notifyObservers() {
        for (Observer player:list) {
            player.update();
        }
    }

    void actionClient(String action) {
        System.out.println("Action");
        notifyObservers();
    }


    public static void main(String []s){
        Client player = new Client();

        player.actionClient("Action");
        player.addObserver((Observable) new Action());
    }
}

interface Observer {
    void update();
}

abstract class BaseObserver implements Observer {
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}
class Action extends BaseObserver {
    public void update() {
        System.out.println("Action 1");
    }
}

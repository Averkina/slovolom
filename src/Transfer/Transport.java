package Transfer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextField;

class Transport extends JFrame {

    JTextField input = new JTextField(10);
    
    private Observable myObservable = new Observable() {
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
        }
    };
    
    public void addObserver(Observer hub) {
        myObservable.addObserver(hub);
    }

    Transport() {
        input.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myObservable.notifyObservers(input.getText());
            }
        });
        setSize(500, 500);
        setTitle("Наблюдаемая форма");
        add(input);
        setVisible(true);
    }
}


package Transfer;

import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class OutputForm extends JFrame implements Observer, java.util.Observer {
    OutputForm() {
        setSize(500, 500);
        setTitle("Наблюдатель");
        setVisible(true);
    }
    @Override
    public void update(Observable node, Object arg) {
        JOptionPane.showMessageDialog(null, arg);
        setTitle("Наблюдатель: " + arg.toString());
    }
}

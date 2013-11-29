
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {

    private static final String[] buttonNames = {
        "H", "U", "M", "O", "R"
    };

    private JFrame frame;
    JTextArea display = new JTextArea();
    
    private Interface() {
        frame = new JFrame("Slovolom");
    }

    public void init() {
        frame.setTitle("Slovolom");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new GridBagLayout());

        Insets insets = new Insets(0, 0, 0, 0);
        final JTextField display = new JTextField("", 20);

        frame.getContentPane().add(display, new GridBagConstraints(0, 0, 5, 1, 1, 0.8,
                GridBagConstraints.CENTER, 1, insets, 0, 0));

        int gridx = 0;
        int gridy = 1;
        
        for (int i = 0; i < buttonNames.length; ++i) {
            final JButton newButton = new JButton(buttonNames[i]);
            int gridwidth = 1;
            int gridheight = 1;
            
            frame.getContentPane().add(newButton, new GridBagConstraints(gridx, gridy,
                    gridwidth, gridheight, 1, 1, GridBagConstraints.CENTER, 1,
                    insets, 0, 0));

            gridx += gridwidth;
            if (gridx >= 5) {
                gridx = 0;
                ++gridy;
            }
            
            class Y implements ActionListener{
                public void actionPerformed(ActionEvent event) {
                    String input = event.getActionCommand();
                    display.setText(display.getText() + input);
                    System.out.print(input);
                }
            }
            
            newButton.addActionListener(new Y());
            
        }

        frame.pack();
        frame.setVisible(true);
    }

    public static void Main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Interface main = new Interface();
                main.init();
            }
        });
    }
}

package proba;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class WindowWithWord {

    private static final String[] BUTTON_NAMES = {
        "H", "U", "M", "O", "R"
    };



    private JFrame frame;

    private WindowWithWord() {
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

        for (int i = 0; i < BUTTON_NAMES.length; ++i) {
            final JButton newButton = new JButton(BUTTON_NAMES[i]);
            int gridwidth = 1;
            int gridheight = 1;

            frame.getContentPane().add(newButton, new GridBagConstraints(gridx, gridy,
                    gridwidth, gridheight, 1, 1, GridBagConstraints.CENTER, 1,
                    insets, 0, 0));

            gridx += gridwidth;

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


    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WindowWithWord main = new WindowWithWord();
                main.init();
            }
        });
    }
}
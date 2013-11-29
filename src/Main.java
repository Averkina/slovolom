import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Main extends JFrame {

    public Main() {
        
        initUI();
    }

    static public JButton quitButton2;
    static public JTextArea area;
    private void initUI() {

       JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(null);

       JButton quitButton = new JButton("Quit");
       quitButton.setBounds(50, 60, 80, 30);

       /*JButton*/ quitButton2 = new JButton("Quit2");
       quitButton2.setBounds(150, 60, 80, 30);

//       quitButton.addActionListener(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent event) {
//               System.exit(0);
//          }
//       });
       
       class X implements ActionListener{
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       }
       
       
//       quitButton.addActionListener(new X());
//       
//       class Y implements ActionListener{
//           public void actionPerformed(ActionEvent event) {
//               //quitButton2.setText("pressed");
//               //System.out.println("qui2 " + event.toString());
//               
//               System.out.println(area.getText());
//           }
//       }
       
//       quitButton2.addActionListener(new Y());
       

       quitButton2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent event) {
               //quitButton.setLabel("pizda");
               quitButton2.setText("pressed");
               System.out.println("qui2 " + event.toString());
          }
       });

       area = new JTextArea();
       area.setBounds(0, 0, 60, 25);

       area.setLineWrap(true);
       area.setWrapStyleWord(true);
//\       area.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
//
//       pane.getViewport().add(area);
//       panel.add(pane);

       panel.add(area);
       
       
       JLabel labelx = new JLabel("dick");
       //labelx.setFont(new Font("Serif", Font.BOLD, 14));
       labelx.setBounds(10, 10, 60, 25);
       
       panel.add(labelx);
       
       panel.add(quitButton);
       panel.add(quitButton2);

       setTitle("Quit button aaaa");
       setSize(500, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        class MyThread extends Thread {
            public void run()
            {
                int i = 0;
                for(;;)
                {
                    try {
                        sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    ++i;
                    quitButton2.setText("n = " + i);
                    System.out.println("n = " + i);
                }
                
            }
        }
        
        new MyThread().start();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }
}
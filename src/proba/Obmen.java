package proba;


import java.applet.*;
import java.awt.*;


public class Obmen extends Applet implements Runnable {
    int x = 0;
    int y = 0;
    int start_x = 0;
    int start_y = 0;
    Thread new_thread = null;
    String message = "Hellobody!!!";
    public void init()
    {
        y = size().height;
        x = size().width;
        start_x = x;
        start_y = y;
    }
    public void start()
    {
        new_thread = new Thread (this);
        new_thread.start ();
    }
    public void run()
    {
        while (true)
        {
            repaint ();
            x -= 10;
            if (x<0)
            {
                x=start_x;
            }
            try
            {
                Thread.sleep (100);
            }
 catch (InterruptedException e) {
                
            }
        }
    }
    public void paint (Graphics g)
    {
        Font new_font = new Font ("TimesRoman",1,48);
        g.setFont (new_font);
        g.drawString ("Hello, Java.",x,y/2);
    }
}
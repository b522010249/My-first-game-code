package tdf;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Frame {
    public static void main(String[] args) {
        JFrame f =new Mainmenu();
        f.addMouseListener(new keyhandle());
        f.addMouseMotionListener(new keyhandle());
        f.setTitle("TDF Game");
        f.setVisible(true);
        f.setSize(805, 629);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
 
    }
}

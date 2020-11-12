package tdf;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Select_Map extends JPanel implements MouseListener{
    
    ImageIcon Back = new ImageIcon(this.getClass().getResource("Button\\Back.png"));
    ImageIcon o_Back = new ImageIcon(this.getClass().getResource("Button\\o_Back.png"));    
    
    JButton m1=new JButton(Back);
    JButton m2=new JButton(Back);
    JButton b=new JButton(Back);
    public Select_Map() {
        setLayout(null);
        setBackground(Color.black);
        
        add(m1);
        m1.addMouseListener(this);
        m1.setBorderPainted(false);
        m1.setFocusPainted(false);
        m1.setContentAreaFilled(false);
        m1.setBounds(240, 100, 320, 90);        
        
        add(m2);
        m2.addMouseListener(this);
        m2.setBorderPainted(false);
        m2.setFocusPainted(false);
        m2.setContentAreaFilled(false);
        m2.setBounds(240, 200, 320, 90);
        
        add(b);
        b.addMouseListener(this);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setBounds(400, 470, 500, 110);          
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getSource()==b){
            b.setIcon(Back);
        }
        else if (me.getSource()==m1){
            m1.setIcon(Back);
        }
        else if (me.getSource()==m2){
            m2.setIcon(Back);
        }        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
         if(me.getSource()==b){
            b.setIcon(o_Back);
        }
         else if (me.getSource()==m1){
            m1.setIcon(o_Back);
        }
        else if (me.getSource()==m2){
            m2.setIcon(o_Back);
        }         
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource()==b){
            b.setIcon(Back);
        }
        else if (me.getSource()==m1){
            m1.setIcon(Back);
        }
        else if (me.getSource()==m2){
            m2.setIcon(Back);
        }        
    }
    
    
}

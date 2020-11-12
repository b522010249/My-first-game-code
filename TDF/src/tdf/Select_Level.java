package tdf;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Select_Level extends JPanel implements MouseListener{
    ImageIcon Normal = new ImageIcon(this.getClass().getResource("Button\\Normal.png"));
    ImageIcon o_Normal = new ImageIcon(this.getClass().getResource("Button\\over_Normal.png"));
    ImageIcon Hard = new ImageIcon(this.getClass().getResource("Button\\Hard.png"));
    ImageIcon o_Hard = new ImageIcon(this.getClass().getResource("Button\\over_Hard.png"));
    ImageIcon Lunatic = new ImageIcon(this.getClass().getResource("Button\\Lunatic.png"));
    ImageIcon o_Lunatic = new ImageIcon(this.getClass().getResource("Button\\over_Lunatic.png"));
    ImageIcon Back = new ImageIcon(this.getClass().getResource("Button\\Back.png"));
    ImageIcon o_Back = new ImageIcon(this.getClass().getResource("Button\\o_Back.png"));
    
    JButton n = new JButton(Normal);
    JButton h = new JButton(Hard);
    JButton l = new JButton(Lunatic);
    JButton b = new JButton(Back);

    
    
    Select_Level(){
        setLayout(null);
        setBackground(Color.black);
        
        add(n);
        n.addMouseListener(this);
        n.setBorderPainted(false);
        n.setFocusPainted(false);
        n.setContentAreaFilled(false);
        n.setBounds(240, 100, 320, 90);

        add(h);
        h.addMouseListener(this);
        h.setBorderPainted(false);
        h.setFocusPainted(false);
        h.setContentAreaFilled(false);
        h.setBounds(240, 200, 320, 90);  
        
        add(l);
        l.addMouseListener(this);
        l.setBorderPainted(false);
        l.setFocusPainted(false);
        l.setContentAreaFilled(false);
        l.setBounds(150, 300, 500, 110);
        
        add(b);
        b.addMouseListener(this);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setBounds(400, 470, 500, 110);  
                
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //g.drawImage(Title.getImage(),0,0, 630, 360, this);
        //g.drawImage(Start.getImage(),575,390, 200, 70, this);
        //g.drawImage(Exit.getImage(),600,465, 140, 50, this);
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getSource()==n){
            n.setIcon(Normal);
        }
        else if(me.getSource()==h){
            h.setIcon(Hard);
        }
        else if(me.getSource()==l){
            l.setIcon(Lunatic);
        }
        else if(me.getSource()==b){
            b.setIcon(Back);
        }            
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource()==n){
            n.setIcon(o_Normal);
        }
        else if(me.getSource()==h){
            h.setIcon(o_Hard);
        }
        else if(me.getSource()==l){
            l.setIcon(o_Lunatic);
        }
        else if(me.getSource()==b){
            b.setIcon(o_Back);
        }          
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource()==n){
            n.setIcon(Normal);
        }
        else if(me.getSource()==h){
            h.setIcon(Hard);
        }
        else if(me.getSource()==l){
            l.setIcon(Lunatic);
        }
        else if(me.getSource()==b){
            b.setIcon(Back);
        }          
        
    }


    
}

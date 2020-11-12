package tdf;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Homepage extends JPanel implements ActionListener,MouseListener{
    ImageIcon Title = new ImageIcon(this.getClass().getResource("Button\\Title.gif"));
    ImageIcon Exit = new ImageIcon(this.getClass().getResource("Button\\Exit.png"));
    ImageIcon Start = new ImageIcon(this.getClass().getResource("Button\\Start.png"));
    ImageIcon o_Start = new ImageIcon(this.getClass().getResource("Button\\over_Start.png"));
    ImageIcon o_Exit = new ImageIcon(this.getClass().getResource("Button\\over_Exit.png"));
    ImageIcon bg = new ImageIcon(this.getClass().getResource("Bg\\bg.png"));
    
    JButton start = new JButton(Start);
    JButton exit = new JButton(Exit);

    
    
    Homepage(){
        setLayout(null);
        setBackground(Color.white);
        add(start);
        start.addMouseListener(this);
        start.setBorderPainted(false);
        start.setFocusPainted(false);
        start.setContentAreaFilled(false);
        start.setBounds(575, 390, 200, 70);
        
        add(exit);
        exit.addMouseListener(this);
        exit.setBorderPainted(false);
        exit.setFocusPainted(false);
        exit.setContentAreaFilled(false);
        exit.setBounds(575, 465, 200, 70);        
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0,800,600, this);
        g.drawImage(Title.getImage(),0,0, 680, 390, this);
        //g.drawImage(Start.getImage(),575,390, 200, 70, this);
        //g.drawImage(Exit.getImage(),600,465, 140, 50, this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
       
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getSource()==start){
            start.setIcon(Start);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource()==start){        
            start.setIcon(o_Start);
        }
        else if(me.getSource()==exit){           
            exit.setIcon(o_Exit);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource()==start){           
            start.setIcon(Start);
        }
        else if(me.getSource()==exit){           
            exit.setIcon(Exit);
        }        
    }


    
}

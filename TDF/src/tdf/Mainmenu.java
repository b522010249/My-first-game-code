package tdf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;



public class Mainmenu extends JFrame implements ActionListener{
    public static Homepage hm=new Homepage();
    public static Select_Level sl=new Select_Level();
    public static Select_Map sm=new Select_Map();
    public static Playstate ps=new Playstate();
    
    
    Mainmenu(){
        add(hm);
        hm.start.addActionListener(this);
        hm.exit.addActionListener(this);
        
        sm.m1.addActionListener(this);
        sm.m2.addActionListener(this);
        sm.b.addActionListener(this);
        
        sl.n.addActionListener(this);
        sl.h.addActionListener(this);
        sl.l.addActionListener(this);
        sl.b.addActionListener(this);
        
       
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==hm.start){
            this.remove(hm);
            this.add(sm);
            sm.requestFocusInWindow();
        }
        else if(e.getSource()==hm.exit){
            System.exit(0);
        }
            //select Map//
        else if(e.getSource()==sm.m1){
            ps.id_map=1;
            this.remove(sm);
            this.add(sl);
            sl.requestFocusInWindow();
        }
        else if(e.getSource()==sm.m2){
            ps.id_map=2;
            this.remove(sm);
            this.add(sl);
            sl.requestFocusInWindow();
        }
        else if(e.getSource()==sm.b){
            this.remove(sm);
            this.add(hm);
            hm.requestFocusInWindow();
        }
            //select Level//
        else if(e.getSource()==sl.n){
            ps.lvl_map=1;
            this.remove(sl);
            this.add(ps);
            ps.requestFocusInWindow();
        }
        else if(e.getSource()==sl.h){
            ps.lvl_map=2;
            this.remove(sl);
            this.add(ps);
            ps.requestFocusInWindow();
        }
        else if(e.getSource()==sl.l){
            ps.lvl_map=3;
            this.remove(sl);
            this.add(ps);
            ps.requestFocusInWindow();
        }
        else if(e.getSource()==sl.b){
            this.remove(sl);
            this.add(sm);
            hm.requestFocusInWindow();
        }        
        
        validate();
        repaint();
    }
}

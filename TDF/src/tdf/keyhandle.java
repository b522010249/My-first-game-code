package tdf;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class keyhandle implements MouseListener,MouseMotionListener{

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
         try{Playstate.bar.click(me.getButton());
         
         }catch(Exception e){}
         
    }

    @Override
    public void mouseReleased(MouseEvent me) {
         try{Playstate.bar.released(me.getButton());
         }catch(Exception e){}
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        try{Playstate.mse=new Point(me.getX()-7,me.getY()-30);
                }catch(Exception e){}
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        try{Playstate.mse=new Point(me.getX()-7,me.getY()-30); 
                }catch(Exception e){}
    }
    
}

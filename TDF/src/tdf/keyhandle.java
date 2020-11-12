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
         Playstate.bar.click(me.getButton());
         
    }

    @Override
    public void mouseReleased(MouseEvent me) {
         Playstate.bar.released(me.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        Playstate.mse=new Point(me.getX()-7,me.getY()-30); 
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Playstate.mse=new Point(me.getX()-7,me.getY()-30); 
    }
    
}

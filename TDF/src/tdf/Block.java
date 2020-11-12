package tdf;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import static tdf.Playstate.check;

public class Block extends Rectangle{
    public int g_id,a_id,crit;
    public int towerrange=96,towerrange2=92;
    public Rectangle towerssquare,towerssquare2;
    
    public boolean shooting=false;
    public int shotmob=-1;
    public int frame=0;
    
    public Block(int x,int y,int width,int height,int g_id,int a_id) {
        setBounds(x, y, width, height);
        towerssquare =new Rectangle(x-(towerrange/2),y-(towerrange/2),width+(towerrange),height+(towerrange));
        towerssquare2 =new Rectangle(x-(towerrange2/2),y-(towerrange2/2),width+(towerrange2),height+(towerrange2));
        this.g_id=g_id;
        this.a_id=a_id;
    }
    public void showrange(Graphics g){
        if(Playstate.isdebug){
            if (a_id==0) {
                //g.drawImage(Playstate.air[96].getImage(),towerssquare.x, towerssquare.y, towerssquare.width, towerssquare.height,null);
                //g.drawRect(towerssquare.x, towerssquare.y, towerssquare.width, towerssquare.height);
            }
            if (a_id==1) {
                //g.drawImage(Playstate.air[96].getImage(),towerssquare.x, towerssquare.y, towerssquare.width, towerssquare.height,null);
                //g.drawRect(towerssquare2.x, towerssquare2.y, towerssquare2.width, towerssquare2.height);
            }
            if (a_id==2) {
                //g.drawImage(Playstate.air[96].getImage(),towerssquare.x, towerssquare.y, towerssquare.width, towerssquare.height,null);
                //g.drawRect(towerssquare2.x, towerssquare2.y, towerssquare2.width, towerssquare2.height);
            }              
            if(shooting){
                try{
                g.drawLine(x+(width/2), y+(height/2), Playstate.mobs[shotmob].x+(Playstate.mobs[shotmob].width/2), Playstate.mobs[shotmob].y+(Playstate.mobs[shotmob].height/2));
                }catch(Exception e){}
            }
        }
    }
    public void physic(){
        try{
        if(shotmob!=-1&&towerssquare.intersects(Playstate.mobs[shotmob])){
            shooting=true;
        }else{
            shooting=false;
        }
        if(!shooting){
            if(a_id==0){
                for (int i = 0; i < Playstate.mobs.length; i++) {
                    if(Playstate.mobs[i].ingame){
                        if(towerssquare.intersects(Playstate.mobs[i])){
                            shotmob=i;
                            shooting=true;
                        }
                    }
                }
            }
            if(a_id==1){
                for (int i = 0; i < Playstate.mobs.length; i++) {
                    if(Playstate.mobs[i].ingame){
                        if(towerssquare.intersects(Playstate.mobs[i])){
                            shotmob=i;
                            shooting=true;
                        }
                    }
                }
            }
            if(a_id==2){
                for (int i = 0; i < Playstate.mobs.length; i++) {
                    if(Playstate.mobs[i].ingame){
                        if(towerssquare.intersects(Playstate.mobs[i])){
                            shotmob=i;
                            shooting=true;
                        }
                    }
                }
            }            
        }
        if(shooting&&a_id==0){
            if(Playstate.mobs[shotmob].isdead()){
                shooting=false;
                shotmob=-1;
            }
            if(frame==0){
                for(int i=0;i<Playstate.mobs.length;i++){
                    if(Playstate.mobs[i].ingame){
                        Playstate.mobs[shotmob].losehealth(4);
                        break;
                    }
                }
                frame=500;
            }
            else{
                frame-=1;
            }            
        }
        if(shooting&&a_id==1){
            if(Playstate.mobs[shotmob].isdead()){
                shooting=false;
                shotmob=-1;
            }
            if(frame==0){
                for(int i=0;i<Playstate.mobs.length;i++){
                    if(Playstate.mobs[i].ingame){
                        Playstate.mobs[shotmob].losehealth(1);
                        Playstate.mobs[shotmob].slow(15);
                        break;
                    }
                }
                frame=100;
            }
            else{
                frame-=1;
            }            
        }
        if(shooting&&a_id==2){
            if(Playstate.mobs[shotmob].isdead()){
                shooting=false;
                shotmob=-1;
            }
            if(frame==0){
                for(int i=0;i<Playstate.mobs.length;i++){
                    if(Playstate.mobs[i].ingame){
                        crit+=Math.floor(Math.random()*5);
                        Playstate.mobs[shotmob].losehealth(3+crit);
                        crit=0;
                        break;
                    }
                }
                frame=1000;
            }
            else{
                frame-=2;
            }            
        }
        }catch(Exception e){}
    }
    public void draw(Graphics g){
        if(a_id!=2){
            g.drawImage(Playstate.groundset[g_id].getImage(),x,y,width,height,null);
            g.drawImage(Playstate.air[a_id].getImage(),x,y,width,height,null);        
        }else{
            g.drawImage(Playstate.groundset[g_id].getImage(),x,y,width,height,null);
            g.drawImage(Playstate.air[a_id].getImage(),x-10,y,width+15,height,null);
            
        }
        g.drawRect(x,y,width,height);
    }
}

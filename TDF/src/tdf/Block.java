package tdf;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Block extends Rectangle{
    public int g_id,a_id;
    public int towerrange=96;
    public Rectangle towerssquare;
    
    public boolean shooting=false;
    public int shotmob=-1;


    
    ImageIcon b_1 = new ImageIcon(this.getClass().getResource("Block\\b_1.png"));
    ImageIcon b_2 = new ImageIcon(this.getClass().getResource("Block\\b_2.png"));
    ImageIcon a_1 = new ImageIcon(this.getClass().getResource("Block\\a_air1.png"));
    ImageIcon a_2 = new ImageIcon(this.getClass().getResource("Block\\a_air_red.png"));
    ImageIcon doll1 = new ImageIcon(this.getClass().getResource("Doll\\Doll1_idle_lv1.png"));
    ImageIcon doll2 = new ImageIcon(this.getClass().getResource("Doll\\Doll2_idle_lv1.png"));
    ImageIcon doll3 = new ImageIcon(this.getClass().getResource("Doll\\Doll3_idle_lv3_1.png"));
    
    public Block(int x,int y,int width,int height,int g_id,int a_id) {
        setBounds(x, y, width, height);
        towerssquare =new Rectangle(x-(towerrange/2),y-(towerrange/2),width+(towerrange),height+(towerrange));
        this.g_id=g_id;
        this.a_id=a_id;
    }
    public void showrange(Graphics g){
        if(Playstate.isdebug){
            if (a_id==0) {
                //g.drawImage(a_2.getImage(),towerssquare.x, towerssquare.y, towerssquare.width, towerssquare.height,null);
                g.drawRect(towerssquare.x, towerssquare.y, towerssquare.width, towerssquare.height);
            }
            if(shooting){
                g.drawLine(x+(width/2), y+(height/2), Playstate.mobs[shotmob].x+(Playstate.mobs[shotmob].width/2), Playstate.mobs[shotmob].y+(Playstate.mobs[shotmob].height/2));
            }
        }
    }
    public void physic(){
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
        }
        if(shooting){
            Playstate.mobs[shotmob].losehealth(1);
        }
    }
    public void draw(Graphics g){
        /*if(g_id==0){
            g.drawImage(b_1.getImage(),x,y,width,height,null);
        }
        else if(g_id==1){
            g.drawImage(b_2.getImage(),x,y,width,height,null);
        }
        else if(g_id==2){
            g.drawImage(b_2.getImage(),x,y,width,height,null);
        }*/
            g.drawImage(Playstate.groundset[g_id].getImage(),x,y,width,height,null);
        if(a_id==-1){
            g.drawImage(a_1.getImage(),x,y,width,height,null);
        }
        else if (a_id==0) {
            g.drawImage(doll1.getImage(),x,y,width,height,null);
        }
        else if (a_id==1) {
            g.drawImage(doll2.getImage(),x,y,width,height,null);
        }
        else if (a_id==2) {
            g.drawImage(doll3.getImage(),x-5,y,width+10,height,null);
        }        
        
        g.drawRect(x,y,width,height);
        

    }
}

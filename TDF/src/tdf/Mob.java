package tdf;

import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Mob extends Rectangle{
    
    int mob_id=-1;
    int hp=40,hspace=-5,hheight=6;
    int mob_size=32,mob_walk=0;
    int mx,my;
    public int up=0,down=1,left=3,right=4,direction=down;
    int walkframe=0,walkspeed=10;
    public boolean hasup=false,hasdown=false,hasleft=false,hasright=false;
    public boolean ingame=false;
    
    public Mob() {
    }
    public void delete(){
        ingame=false;        
    }
    public void losehealth(){
        Playstate.hp-=10;
    }
    public void losehealth(double a){
        hp-=a;
        checkded();
    }
    public void checkded(){
        if(hp==0){
            delete();
        }
    }    
    
    public void physic(){
        if(walkframe>=walkspeed){
            if(direction==down){
                y+=1;
            }
            else if(direction==up){
                y-=1;
            }
            else if(direction==right){
                x+=1;
            }
            else if(direction==left){
                x-=1;
            }
            
            mob_walk+=1;
            if(mob_walk==Playstate.map01.blocksize){
                if(direction==right){
                    mx+=1;
                    hasright=true;
                }
                else if(direction==left){
                    mx-=1;
                    hasleft=true;
                }
                else if(direction==up){
                    my-=1;
                    hasup=true;
                }
                else if(direction==down){
                    my+=1;
                    hasdown=true;
                }
                mob_walk+=1;
                if(!hasup){
                    try{
                    if(Playstate.map01.block[my+1][mx].g_id==1){
                        direction=down;
                    }}catch(Exception e){}
                }
                if(!hasdown){
                    try{
                    if(Playstate.map01.block[my-1][mx].g_id==1){
                        direction=up;
                    }}catch(Exception e){}                    
                }  
                if(!hasright){
                    try{
                    if(Playstate.map01.block[my][mx-1].g_id==1){
                        direction=left;
                    }}catch(Exception e){}                  
                }
                if(!hasleft){
                    try{
                    if(Playstate.map01.block[my][mx+1].g_id==1){
                        direction=right;
                    }}catch(Exception e){}                    
                }
                if(Playstate.map01.block[my][mx].a_id==-2){
                    delete();
                    losehealth();
                }
                
                hasright=false;
                hasleft=false;
                hasdown=false;
                hasup=false;
                mob_walk=0;
            }
            
            walkframe=0;
        }
        else{
            walkframe+=1;
        }
    }
    public void spawnmob(int mob_id){
        for(int i=0;i<Playstate.map01.block.length;i++){
            if(Playstate.map01.block[0][i].g_id==1){
                setBounds(Playstate.map01.block[0][i].x, Playstate.map01.block[i][0].y, mob_size,mob_size);
                mx=1;
                my=i;
            }
        }
        this.mob_id=mob_id;
        this.ingame=true;
        //setBounds(100,100,32,32);
        System.out.println(ingame);
        

    }
    public void draw(Graphics g){
                g.drawImage(Playstate.mob[mob_id].getImage(),x,y,width,height,null);
                g.setColor(new Color(50, 180, 50));
                g.fillRect(x, y-(hspace+hheight), hp, hheight);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(x, y-(hspace+hheight), hp-1, hheight-1);
            }
    
    
}

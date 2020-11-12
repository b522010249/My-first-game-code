package tdf;

import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Mob extends Rectangle{
    
    int mob_id=-1;
    public int hp=40,hspace=-5,hheight=6;
    int mob_size=32,mob_walk=0;
    int mx,my;
    public static int s=2,e=10;
    public int up=0,down=1,left=3,right=4,direction=down;
    int walkframe=0,walkspeed=10,moneydrop,powerdrop;
    public boolean hasup=false,hasdown=false,hasleft=false,hasright=false;
    public boolean ingame=false;
    
    public Mob() {
    }
    public void delete(){
        ingame=false;
        direction=down;
        mob_walk=0;
    }
    public boolean isdead(){
        if(ingame){
            return false;
        }
        else{
            return true;
        }
    }
    public void slow(int x){
        this.walkspeed=x;
    }
    public void losehealth(){
        Playstate.hp-=10;
    }
    public void losehealth(int a){
        hp-=a;
        checkded();
    }
    public void checkded(){
        if(hp<=0){
            moneydrop+=Math.floor(Math.random()*((e-s)+1)+s);
            powerdrop+=Math.floor(Math.random()*7);
            System.out.println("Money drop: "+moneydrop);
            System.out.println("Power drop: "+powerdrop);
            Playstate.money+=moneydrop;
            Playstate.power+=powerdrop;
            Playstate.killed+=1;
            System.out.println("Kill count: "+Playstate.killed);            
            delete();
            hp=40;
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
                if(Playstate.map01.block[my][mx].a_id==98){
                    delete();
                    Playstate.killed+=1;
                    losehealth();
                    ingame=false;                    
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
                setBounds(Playstate.map01.block[0][i].x,Playstate.map01.block[i][0].y, mob_size,mob_size);
                mx=1;
                my=i;

            }
        }
        this.mob_id=mob_id;
        ingame=true;        
        //setBounds(100,100,32,32);
    }    
    public void draw(Graphics g){
            g.drawImage(Playstate.air[97].getImage(),x,y,width,height,null);
            g.drawImage(Playstate.mob[mob_id].getImage(),x,y,width,height,null);
            g.setColor(new Color(180, 50, 50));
            g.fillRect(x, y-(hspace+hheight), width, hheight);
            g.setColor(new Color(50, 180, 50));
            g.fillRect(x, y-(hspace+hheight), hp, hheight);
            g.setColor(new Color(0, 0, 0));
            g.drawRect(x, y-(hspace+hheight), hp-1, hheight-1);

    }
    
    
}

package tdf;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;

public class Playstate extends JPanel implements Runnable{
    public static Map01 map01;
    public static Bar bar;
    public static Mob[] mobs =new Mob[1];
    public static Point mse=new Point(0,0);
    Thread thread = new Thread(this);
    
    public static ImageIcon[] groundset=new ImageIcon[100];
    public static ImageIcon[] mob=new ImageIcon[100]; 
    //Thread thread = new Thread();
    
    public static boolean isfirst=true,timestart=true,isdebug=true;
    public static int id_map,lvl_map,screenwidth,screenheigth;
    public static int spawntime=500,spawnFrame=0,wtime=3,money=50,hp=100,power=0;
    
    public Playstate() {
        groundset[0]=new ImageIcon(this.getClass().getResource("Block\\b_1.png"));
        groundset[1]=new ImageIcon(this.getClass().getResource("Block\\b_2.png"));
        groundset[2]=new ImageIcon(this.getClass().getResource("Block\\b_2.png"));
        mob[0]=new ImageIcon(this.getClass().getResource("Mob\\Mob1_walk.gif"));
        setLayout(null);
        setBackground(new Color(25,25,25));
        thread.start(); 
    } 
    public void define(){
        bar=new Bar();
        map01 =new Map01();
        screenheigth=getHeight();
        screenwidth=getWidth();
        for (int x = 0; x < mobs.length; x++) {
            mobs[x]=new Mob();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isfirst){
                define();   
                isfirst=false;
                
        }
        map01.draw(g);     
        for(int i=0;i<mobs.length;i++){
            if(mobs[i].ingame){
                mobs[i].draw(g);
            }
        }
        bar.draw(g); 

        validate();
        repaint();
    }
    public void mobspawn(){
        if(spawnFrame>=spawntime){
            for(int i=0;i<mobs.length;i++){
                if(!mobs[i].ingame){
                    mobs[i].spawnmob(0);
                    break;
                }
            }
            spawnFrame=0;
        }
        else{
            spawnFrame+=1;
        }
    }

    @Override
    public void run() {
        while(true){
            if(!isfirst){
                mobspawn();                
                map01.physic();
                    for(int i=0;i<mobs.length;i++){
                        if(mobs[i].ingame){
                            mobs[i].physic();
                        }
                    }
            }
            validate();
            repaint();
            try{
                Thread.sleep(1);
            }catch(Exception e){}
            
        }
    }

    
}

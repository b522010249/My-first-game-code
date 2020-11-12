package tdf;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;

public class Playstate extends JPanel implements Runnable{
    public static Map01 map01;
    public static Bar bar;
    public static Mob[] mobs;
    public static Point mse=new Point(0,0);
    Thread thread = new Thread(this);
    
    public static ImageIcon[] groundset=new ImageIcon[100];
    public static ImageIcon[] mob=new ImageIcon[100]; 
    public static ImageIcon[] air=new ImageIcon[100];
    public static ImageIcon[] doll=new ImageIcon[100];
    //Thread thread = new Thread();
    public static boolean isfirst=true,timestart=true,isdebug=true,iswin=false;
    public static int id_map,lvl_map,screenwidth,screenheigth;
    public static int spawntime=500,spawnFrame=0,times=10,wframe=0,money,hp,power=0,count,check,size;
    public static int killed=0,killtowin,level=1,mlevel=3;
    
    
    public Playstate() {
        groundset[0]=new ImageIcon(this.getClass().getResource("Block\\b_1.png"));
        groundset[1]=new ImageIcon(this.getClass().getResource("Block\\b_2.png"));
        groundset[2]=new ImageIcon(this.getClass().getResource("Block\\b_2.png"));
        
        mob[0]=new ImageIcon(this.getClass().getResource("Mob\\Mob1_walk.gif"));
        
        air[96]=new ImageIcon(this.getClass().getResource("Block\\a_air_red.png"));
        air[97]=new ImageIcon(this.getClass().getResource("Block\\a_air.png"));
        air[99]=new ImageIcon(this.getClass().getResource("Block\\a_air1.png"));
        air[98]=new ImageIcon(this.getClass().getResource("Block\\a_air1.png"));
        air[0]=new ImageIcon(this.getClass().getResource("Doll\\Doll1_idle_lv1.png"));
        air[1]=new ImageIcon(this.getClass().getResource("Doll\\Doll2_idle_lv1.png"));
        air[2]=new ImageIcon(this.getClass().getResource("Doll\\Doll3_idle_lv3_1.png"));
        thread.start();
        t.start();
        setLayout(null);
        setBackground(new Color(25,25,25));
 
    }
        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1) ;
                            System.out.println(times);
                            }
			
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});    
    public void define(){
        bar=new Bar();
        map01 =new Map01();
        mobs =new Mob[size];
        screenheigth=getHeight();
        screenwidth=getWidth();
        for (int x = 0; x < mobs.length; x++) {
            mobs[x]=new Mob();
        }
    }
    public static void checkwon(){
        if(killed==killtowin){
            System.out.println("WTF");
            killed=0;
            iswin=true;
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isfirst){
                define();
                timestart=false;
                isfirst=false;
        }
        map01.draw(g); 
        bar.draw(g);        
        for(int i=0;i<mobs.length;i++){
            if(mobs[i].ingame){
                mobs[i].draw(g);
            }
        }
        if(hp<=0){
            g.setColor(Color.black);
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.white);
            g.setFont(new Font("Courier New",Font.BOLD,62));                
            g.drawString("GAMEOVER",270,200);     
        }
        if(iswin){
            g.setColor(Color.black);
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.white);
            g.setFont(new Font("Courier New",Font.BOLD,62));                
            g.drawString("Congratulations! ",120,200);
            g.setFont(new Font("Courier New",Font.BOLD,32)); 
            g.drawString("This is just a demo game",170,270);
            g.drawString("Thank for playing",230,320); 
        }

       
        repaint();
    }
    public void mobspawn(){
        if(times==0){
            timestart=true;
            if(spawnFrame>=spawntime){
                for(int i=0;i<mobs.length;i++){
                    if(!mobs[i].ingame&&check!=size){
                        mobs[i].spawnmob(0);
                        check++;
                        break;
                    }

                }
                spawnFrame=0;
            }
            else{
                spawnFrame+=1;
            }
        }
    }

    @Override
    public void run() {
        while(true){
            try{
            if(!isfirst&&hp>0&&!iswin){
                map01.physic();
                mobspawn();
                checkwon();
                for(int i=0;i<mobs.length;i++){
                    if(mobs[i].ingame){
                        mobs[i].physic();
                        }
                    }
            }}catch(Exception e){}
            validate();
            repaint();
            try{
                Thread.sleep(1);
            }catch(Exception e){}
            
        }
    }

    
}

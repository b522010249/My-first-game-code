package tdf;

import java.awt.*;
import javax.swing.ImageIcon;

public class Bar {
    public static int buttonsize=50,shopwidth=8,cellspace=2;
    public static int holdid;
    public boolean holditem=false;
    public Rectangle[] button=new Rectangle[shopwidth];
    public Rectangle buttonpower,buttonhp,buttonmoney;
    public static int[]idbar={0,1,2,-1,-1,-1,-1,1};
    public static int[]pricebar={10,25,50,20,30,40,7,8};
    
    ImageIcon bar50x_o = new ImageIcon(this.getClass().getResource("Button\\Bar50x_o.png"));
    ImageIcon bar50x = new ImageIcon(this.getClass().getResource("Button\\Bar50x.png"));
    ImageIcon doll1 = new ImageIcon(this.getClass().getResource("Doll\\Doll1_idle_lv1.png"));
    ImageIcon doll1g1 = new ImageIcon(this.getClass().getResource("Doll\\Doll1_idle_lv1.gif"));
    ImageIcon doll2 = new ImageIcon(this.getClass().getResource("Doll\\Doll2_idle_lv1.png"));
    ImageIcon doll1g2 = new ImageIcon(this.getClass().getResource("Doll\\Doll2_idle_lv1.gif"));
    ImageIcon doll3 = new ImageIcon(this.getClass().getResource("Doll\\Doll3_idle_lv3_1.png"));
    ImageIcon doll1g3 = new ImageIcon(this.getClass().getResource("Doll\\Doll3_idle_lv3.gif"));
    ImageIcon p_point = new ImageIcon(this.getClass().getResource("Block\\p_point.png"));
    ImageIcon m_point = new ImageIcon(this.getClass().getResource("Block\\m_point.png"));
    ImageIcon heart = new ImageIcon(this.getClass().getResource("Block\\heart.png"));
    
    
    public Image[]doll=new Image[100];
    
    public Bar() {
        define();
    }
    
    public void define (){
            button[0]=new Rectangle(665,250, buttonsize, buttonsize);
            button[1]=new Rectangle(720,250, buttonsize, buttonsize);
            button[2]=new Rectangle(665,305, buttonsize, buttonsize);
            button[3]=new Rectangle(720,305, buttonsize, buttonsize);
            button[4]=new Rectangle(665,360, buttonsize, buttonsize);
            button[5]=new Rectangle(720,360, buttonsize, buttonsize);
            button[6]=new Rectangle(665,415, buttonsize, buttonsize);
            button[7]=new Rectangle(720,415, buttonsize, buttonsize);
            
            buttonpower=new Rectangle(650,10,32,32);
            buttonmoney=new Rectangle(650,50,32,32);
            buttonhp=new Rectangle(650,90,32,32);
            
    }
    public void click(int mouseButton){
      if(mouseButton==1){
          for (int i = 0; i < button.length; i++) {
              if (button[i].contains(Playstate.mse)) {
                  holdid=idbar[i];
                  holditem=true;
              }
          }
      }
      if(holditem){
          if(Playstate.money>=pricebar[holdid]){
              for (int y = 0; y < Playstate.map01.block.length; y++) {
                  for (int x = 0; x < Playstate.map01.block.length; x++) {
                      if (Playstate.map01.block[y][x].contains(Playstate.mse)) {
                          if(Playstate.map01.block[y][x].g_id!=1&&Playstate.map01.block[y][x].a_id==99){
                              Playstate.map01.block[y][x].a_id=holdid;
                              Playstate.money-=pricebar[holdid];
                          }
                      }
                  }
              }
          }
      }
    }
    public void released(int mouseButton){
      if(mouseButton==1){
          for (int i = 0; i < button.length; i++) {
              if (button[i].contains(Playstate.mse)) {
                  holditem=false;
              }
          }
      }
    }
    public void draw(Graphics g){
   
        
        g.drawImage(bar50x.getImage(),button[0].x,button[0].y, buttonsize, buttonsize,null);
        g.drawImage(doll1.getImage(),button[0].x,button[0].y, buttonsize, buttonsize,null);
        g.drawImage(bar50x.getImage(),button[1].x,button[1].y, buttonsize, buttonsize,null);
        g.drawImage(doll2.getImage(),button[1].x,button[1].y, buttonsize, buttonsize,null);
        g.drawImage(bar50x.getImage(),button[2].x,button[2].y, buttonsize, buttonsize,null);
        g.drawImage(doll3.getImage(),button[2].x-15,button[2].y, 75, 50,null);
        g.drawImage(bar50x.getImage(),button[3].x,button[3].y, buttonsize, buttonsize,null);
        g.drawImage(bar50x.getImage(),button[4].x,button[4].y, buttonsize, buttonsize,null);
        g.drawImage(bar50x.getImage(),button[5].x,button[5].y, buttonsize, buttonsize,null);
        g.drawImage(bar50x.getImage(),button[6].x,button[6].y, buttonsize, buttonsize,null);
        g.drawImage(bar50x.getImage(),button[7].x,button[7].y, buttonsize, buttonsize,null);
        
        if(button[0].contains(Playstate.mse)){
                g.drawImage(bar50x_o.getImage(),button[0].x,button[0].y, buttonsize, buttonsize,null);
                g.drawImage(doll1g1.getImage(),button[0].x-15,button[0].y-30, 80, 80,null);
                g.setColor(Color.white); 
                g.setFont(new Font("Courier New",Font.BOLD,14));
                g.drawString("10$",700,150);
                g.setColor(Color.green); 
                g.drawString("low Cost",660,170);
                g.setColor(Color.red);
                g.drawString("Slow Reload",660,190);
                g.setColor(Color.yellow);
                g.drawString("Medium Damge",660,210);
                g.setColor(Color.white); 
            }
        if(button[1].contains(Playstate.mse)){
                g.drawImage(bar50x_o.getImage(),button[1].x,button[1].y, buttonsize, buttonsize,null);
                g.drawImage(doll1g2.getImage(),button[1].x,button[1].y, 50, 50,null);
                g.setColor(Color.white); 
                g.setFont(new Font("Courier New",Font.BOLD,14));                
                g.drawString("25$",700,150);
                g.setColor(Color.yellow); 
                g.drawString("Medium Cost",660,170);
                g.setColor(Color.green);
                g.drawString("Fast Reload",660,190);
                g.setColor(Color.red);
                g.drawString("Very Low Damge",660,210);
                g.setColor(Color.cyan);
                g.drawString("Slow Forever",660,230);                
                g.setColor(Color.white);                 
            }
        if(button[2].contains(Playstate.mse)){
                g.drawImage(bar50x_o.getImage(),button[2].x,button[2].y, buttonsize, buttonsize,null);
                g.drawImage(doll1g3.getImage(),button[2].x-15,button[2].y, 75, 50,null);
                g.setColor(Color.white); 
                g.setFont(new Font("Courier New",Font.BOLD,14));                
                g.drawString("50$",700,150);
                g.setColor(Color.red); 
                g.drawString("High Cost",660,170);
                g.setColor(Color.yellow);
                g.drawString("Medium Reload",660,190);
                g.setColor(Color.green);
                g.drawString("High Damge",660,210);
                g.setColor(Color.orange);
                g.drawString("Low Chance Crit",660,230); 
                g.setColor(Color.white);
            }        
        if(button[3].contains(Playstate.mse)){
                g.drawImage(bar50x_o.getImage(),button[3].x,button[3].y, buttonsize, buttonsize,null);
            }
        if(button[4].contains(Playstate.mse)){
                g.drawImage(bar50x_o.getImage(),button[4].x,button[4].y, buttonsize, buttonsize,null);
            }
        if(button[5].contains(Playstate.mse)){
                g.drawImage(bar50x_o.getImage(),button[5].x,button[5].y, buttonsize, buttonsize,null);
            }
        if(button[6].contains(Playstate.mse)){
                g.drawImage(bar50x_o.getImage(),button[6].x,button[6].y, buttonsize, buttonsize,null);
            }
        if(button[7].contains(Playstate.mse)){
                g.drawImage(bar50x_o.getImage(),button[7].x,button[7].y, buttonsize, buttonsize,null);
             }
        if(holditem){
            if(holdid!=2){
                g.drawImage(Playstate.air[holdid].getImage(),Playstate.mse.x-20,Playstate.mse.y-15, buttonsize, buttonsize,null);
            }
            else{
                g.drawImage(Playstate.air[holdid].getImage(),Playstate.mse.x-35,Playstate.mse.y-15, 75, 50,null);
            }
            
        }
        //g.fillOval(Playstate.mse.x-14,Playstate.mse.y-13, 32, 32);
        //g.drawOval(Playstate.mse.x-14,Playstate.mse.y-13, 32, 32);
        
        g.drawRect(650,130, 130, 110);
        g.drawImage(m_point.getImage(),buttonmoney.x,buttonmoney.y, 32, 32,null);
        g.drawImage(p_point.getImage(),buttonpower.x,buttonpower.y, 32, 32,null);
        g.drawImage(heart.getImage(),buttonhp.x,buttonhp.y, 32, 32,null);
        g.setColor(Color.white); 
        g.setFont(new Font("Courier New",Font.BOLD,14));
        g.drawString(" "+Playstate.power,buttonpower.x+40,buttonpower.y+25);         
        g.drawString(" "+Playstate.money,buttonmoney.x+40,buttonmoney.y+25);
        g.drawString(" "+Playstate.hp,buttonhp.x+40,buttonhp.y+25); 
        
    }
}

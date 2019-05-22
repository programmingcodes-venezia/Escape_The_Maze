/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Shushku
 */
class PlayerObject extends MovableObject{
    
    ArrayList<Image> leftSprites;
    ArrayList<Image> downSprites;
    ArrayList<Image> upSprites;
    ArrayList<Image> rightSprites;
    private Rectangle hitbox;
    private boolean pressed;
    private int increment = 10;
    private int i;
    private  String direction;
    private boolean collide = false;
    private String lastDirection = "niente";
    public PlayerObject(int x, int y ,Dimension boardSize) {
        
        super(x,y,boardSize);
        leftSprites = new ArrayList(2);
        downSprites = new ArrayList(2);
        upSprites = new ArrayList(2);
        rightSprites = new ArrayList(2);
        loadImages();
        setImage(downSprites.get(0));
        
    }

    
    public void moveLeft(){
        direction = "left";
        if(hasChanged(lastDirection)){
            xd(lastDirection);
            setIncrement(10);
        }
        setX(getX() - getIncrement());
        
        if(this.i==0){
            setImage(leftSprites.get(0));
            this.i=1;
        }else
        if(this.i==1){
            setImage(leftSprites.get(1));
            this.i=0;
        }
    }  
    
    public void moveRight(){
        direction = "right";
        if(hasChanged(lastDirection)){
            xd(lastDirection);
            setIncrement(10);
        }
        setX(getX() + getIncrement());
        if(this.i==0){
            setImage(rightSprites.get(this.i));
            this.i=1;
        }else
        if(this.i==1){
            setImage(rightSprites.get(this.i));
            this.i=0;
        }
    } 
    
    public void moveUp(){
        direction = "up";        
        if(hasChanged(lastDirection)){
            xd(lastDirection);
            setIncrement(10);
        }
        setY(getY() - getIncrement());
        if(this.i==0){
            setImage(upSprites.get(this.i));
            this.i=1;
        }else
        if(this.i==1){
            setImage(upSprites.get(this.i));
            this.i=0;
        }
    }  
    
    public void moveDown(){
        direction = "down";
        if(hasChanged(lastDirection)){
            setIncrement(10);
            xd(lastDirection);
        }
        setY(getY() + getIncrement());
        if(this.i==0){
            setImage(downSprites.get(this.i));
            this.i=1;
        }else if(this.i==1){
            setImage(downSprites.get(this.i));
            this.i=0;
        }
    }
    
    public void loadImages(){
        File folder = new File("player");
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i<listOfFiles.length; i++){
            if(listOfFiles[i].isFile() && (listOfFiles[i].getName().equals("spriteDown1.png")|| listOfFiles[i].getName().equals("spriteDown2.png"))){
                Image playerSprite = (new ImageIcon(folder.toString()+ File.separator + listOfFiles[i].getName())).getImage();
                downSprites.add(playerSprite);
            }
            if(listOfFiles[i].isFile() && (listOfFiles[i].getName().equals("spriteUp1.png")|| listOfFiles[i].getName().equals("spriteUp2.png"))){
                Image playerSprite = (new ImageIcon(folder.toString()+ File.separator + listOfFiles[i].getName())).getImage();
                upSprites.add(playerSprite);
            }
            if(listOfFiles[i].isFile() && (listOfFiles[i].getName().equals("spriteLeft1.png")|| listOfFiles[i].getName().equals("spriteLeft2.png"))){
                Image playerSprite = (new ImageIcon(folder.toString()+ File.separator + listOfFiles[i].getName())).getImage();
                leftSprites.add(playerSprite);
            }
            if(listOfFiles[i].isFile() && (listOfFiles[i].getName().equals("spriteRight1.png")|| listOfFiles[i].getName().equals("spriteRight2.png"))){
                Image playerSprite = (new ImageIcon(folder.toString()+ File.separator + listOfFiles[i].getName())).getImage();
                rightSprites.add(playerSprite);
            }
        }
    }

    public void drawPlayer(Graphics g){
        g.drawImage(getImage(), getX() - getImage().getWidth(null)/2, getY() - getImage().getHeight(null)/2, null);
        System.out.println("incremnet   " + increment);
        System.out.println("last direction " + lastDirection);
        hitbox = new Rectangle(getX() - getImage().getWidth(null)/7 ,getY() - getImage().getHeight(null)/9, getImage().getWidth(null)-133 , getImage().getHeight(null)/4);
        //g.drawRect((int)hitbox.getX(), (int)hitbox.getY(), (int)hitbox.getWidth(), (int)hitbox.getHeight());
    }
    
    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getIncrement() {
        return increment;
    }

  
    public void setIncrement(int increment) {
        this.increment = increment;
    }
        
    public Rectangle getHitBox(){
        return this.hitbox;
    }
    
    public boolean hasChanged(String lastDirection){
        if(!direction.equals(lastDirection)){
            return true;
        }
        return false;
    }
    
    public String getDirection(){
        return direction;
    }
    
    public void wereHasCollided(int i){
        if(i == 0){
            this.lastDirection=getDirection();
        }
    }
    
    public void xd(String d){
        if(d.equals("up")){
            setY(getY()+10);
            lastDirection = "niente";
        }
        if(d.equals("right")){
            setX(getX()-10);
            lastDirection = "niente";
        }
        if(d.equals("down")){
            setY(getY()-10);
            lastDirection = "niente";
        }
        if(d.equals("left")){
            setX(getX()+10);
            lastDirection = "niente";
        }
    }
}

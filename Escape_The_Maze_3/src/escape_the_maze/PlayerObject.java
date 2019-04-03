/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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
    private float x;
    private float y;
    int increment;
    private static int direction;
    public PlayerObject(int x, int y ,Dimension boardSize) {
        super(x,y,boardSize);
        increment = 1;
        leftSprites = new ArrayList(2);
        downSprites = new ArrayList(2);
        upSprites = new ArrayList(2);
        rightSprites = new ArrayList(2);
        loadImages();
        setImage(downSprites.get(0));
        direction = 0;
    }

    
    public void moveLeft(){
        setX(getX() - increment);
        int i=0;
        setImage(leftSprites.get(i));
        if(i==0){
            i=1;
        }else if(i==1){
            i=0;
        }
    }  
    
    public void moveRight(){
        setX(getX() + increment);
        int i=0;
        setImage(rightSprites.get(i));
        if(i==0){
            i=1;
        }else if(i==1){
            i=0;
        }
    } 
    
    public void moveUp(){
        setY(getY() - increment);
        int i=0;
        setImage(upSprites.get(i));
        if(i==0){
            i=1;
        }else if(i==1){
            i=0;
        }
    }  
    
    public void moveDown(){
        setY(getY() + increment);
        int i=0;
        setImage(downSprites.get(i));
        if(i==0){
            i=1;
        }else if(i==1){
            i=0;
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
    }
    
    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
}

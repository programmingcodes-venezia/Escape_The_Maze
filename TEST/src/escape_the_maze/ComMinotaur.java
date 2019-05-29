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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Shushku
 */
public class ComMinotaur extends MovableObject{
    ArrayList<Image> leftSprites;
    ArrayList<Image> downSprites;
    ArrayList<Image> upSprites;
    ArrayList<Image> rightSprites;
    private Rectangle hitbox;

    public ComMinotaur(int x, int y, Dimension boardSize) {
        super(x,y,boardSize);
        leftSprites = new ArrayList(2);
        downSprites = new ArrayList(2);
        upSprites = new ArrayList(2);
        rightSprites = new ArrayList(2);
        loadImages();
        setImage(rightSprites.get(0));
    }
    
    
    
    
    
    
    
    
    public void loadImages(){
        File folder = new File("Com");
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
    
    public void drawCom(Graphics g){
        g.drawImage(getImage(), getX() - getImage().getWidth(null)/2, getY() - getImage().getHeight(null)/2, null);
        //need to implement hitbox
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        
        if(maze[x][y]==0){
            maze[x][y]=2;
            int dx= -1;
            int dy = 0;
            if(searchPath(maze, x + dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx= 1;
            dy = 0;
            if(searchPath(maze, x + dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx= 0;
            dy = -1;
            if(searchPath(maze, x + dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx= 0;
            dy = 1;
            if(searchPath(maze, x + dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
        }
        return false;
    }
    
}

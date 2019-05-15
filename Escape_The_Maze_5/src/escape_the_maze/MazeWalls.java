/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damiano
 */
public class MazeWalls extends MovableObject{
    private int x;
    private int y;
    private int width;
    private int height;
    private ArrayList<MazeWalls> mazeW;
    private String levelFile;
    private Rectangle r;
    private ArrayList<Rectangle> walls;

    public MazeWalls(String levelFile) {
        mazeW = new ArrayList<>(100);
        walls = new ArrayList<>(100);
        this.levelFile = levelFile;
        try {
            loadWallsFromFile();
        } catch (Exception ex) {
            Logger.getLogger(MazeWalls.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public MazeWalls() {
        
    }
    
    
    
       
    public void drawWalls(int level, Graphics g){
        switch(level){
            case 0:
                for(int i=0;i<walls.size();i++){
                    g.setColor(Color.red);
                    g.fillRect((int)walls.get(i).getX(), (int)walls.get(i).getY(), (int)walls.get(i).getWidth(), (int)walls.get(i).getHeight());
                }
                break;
            case 1:
                walls.clear();
                
                break;
        }
    }
    
    
    public void loadWallsFromFile()throws Exception{
        File file = new File("walls" + File.separator + levelFile + ".txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            int x = (Integer.parseInt(sc.next()));
            int y = (Integer.parseInt(sc.next()));           
            int w = (Integer.parseInt(sc.next()));
            int h = (Integer.parseInt(sc.next()));
            r = new Rectangle(x,y,w,h);
            this.walls.add(r);
        }
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    public MazeWalls getArrayWall(int i){
        return  this.mazeW.get(i);
    }
    
    public int getArrayDimension(){
        return this.mazeW.size();
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void isColliding(PlayerObject po){
        for(int i=0;i<walls.size();i++){
            int j=0;
            if(walls.get(i).intersects(po.getHitBox())){
                po.setLastDirection(j);
                System.out.println("Into if decremented");
                po.setIncrement(0);
            }
        }
    }
    
}

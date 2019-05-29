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
    private ArrayList<Rectangle> mazeW;
    private String levelFile;
    private Rectangle r;
    private int[][] walls;
    private ArrayList<Rectangle> walkAbleArea;
    private PlayerObject po;

    public MazeWalls(String levelFile, PlayerObject po ) {
        walls = new int[40][40];
        mazeW = new ArrayList<>(10);
        walkAbleArea = new ArrayList<>(10);
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
                for(int row=0;row<walls.length;row++){
                    for(int col=0;col< walls[0].length;col++){
                        Color color;
                        switch(walls[row][col]){
                        case 1: color = Color.BLACK;break;
                        case 9: color = Color.RED;break;
                        default: color = Color.WHITE;
                    
                        }
                        g.setColor(color);
                        g.fillRect(25*col, 25*row, 25, 25);
                        g.setColor(Color.black);
                        if(walls[row][col]==1){
                            Rectangle r = new Rectangle(25*col,25*row,25,25);
                            mazeW.add(r);
                        }else
                        if(walls[row][col]==0){
                            Rectangle r = new Rectangle(25*col,25*row,25,25);
                            walkAbleArea.add(r);
                        }

                        g.drawRect(25*col, 25*row, 25, 25);
                        
                    }
                }
            case 1:
                clearArray();
                
                break;
        }
    }
    
    
    public void loadWallsFromFile()throws Exception{
        File file = new File("walls" + File.separator + levelFile + ".txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            for(int row=0;row<walls.length;row++){
                for(int col=0;col< walls[0].length;col++){
                    walls[row][col] = (Integer.parseInt(sc.next()));
                }
            }
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
    
    
    public int getArrayDimension(){
        return this.mazeW.size();
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void isColliding(PlayerObject po){
        for(int i=0;i<mazeW.size();i++){
            int j=1;
            if(mazeW.get(i).intersects(po.getHitBox())){
                j=0;
                po.wereHasCollided(j);
                System.out.println("Into if decremented");
                po.setIncrement(0);
            }
        }
    }
    
//    public void walked(PlayerObject po){
//        for(int i=0;i<walkAbleArea.size();i++){
//            if(walkAbleArea.get(i).intersects(po.getHitBox())){
//                   
//            }else{
//                restoreMap();
//                                      
//            }
//        }
//    }
 
    public void clearArray(){
        for(int row=0;row<walls.length;row++){
            for(int col=0;col< walls[0].length;col++){
                walls[row][col] = 0;
            }
        }
    }
    
//    public void restoreMap(){
//        for(int row=0;row<walls.length;row++){
//            for(int col=0;col< walls[0].length;col++){
//                if(walls[row][col]==9){
//                    walls[row][col]=0;
//                }
//            }
//        }
//    }
    
}

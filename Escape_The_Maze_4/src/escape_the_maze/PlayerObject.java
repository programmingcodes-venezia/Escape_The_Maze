/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Shushku
 */
class PlayerObject extends MovableObject{
    
    ArrayList<Image> playerSprites;
    int increment;
    public PlayerObject(int x, int y, Dimension boardSize) {
        super(x, y, boardSize);
        increment = 1;
        playerSprites = new ArrayList(15);
    }

    @Override
    public void move() {
        
    }
    
    public void moveLeft(){
        setX(getX() - increment);
    }  
    
    public void moveRight(){
        setX(getX() + increment);
    } 
    
    public void moveUp(){
        setY(getY() - increment);
    }  
    
    public void moveDown(){
        setY(getY() + increment);
    }
    
    public void loadImages(){
        
    }
    
}

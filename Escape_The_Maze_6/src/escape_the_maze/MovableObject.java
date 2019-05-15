/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author capuzzo
 */
public abstract class MovableObject {
    protected Image image;
    private int x;
    private int y;
    private int width;
    private int height;
    protected Dimension boardSize;

    public MovableObject() {
    
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
    
    public MovableObject(int x, int y, Dimension boardSize)
    {
        this.x = x;
        this.y = y;
        this.boardSize = boardSize;
    }
    
    public void setImage(Image image)
    {
        this.image = image;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }
    
    public Image getImage()
    {
        return image;
    }
    
    public abstract void move();
    
    boolean isColliding(MovableObject mo)
    {
        int radius1;
        int radius2;
        if(width < height)
        {
            radius1 = width / 2;
            System.out.println("Radius 1 " + radius1 );
        }
        else
        {
            radius1 = height / 2;
            System.out.println("Radius 1 " + radius1 );
        }
        
        if(mo.getWidth() < mo.getHeight())
        {
            radius2 = mo.getWidth() / 2;
            System.out.println("Radius 2 " + radius2 );
        }
        else
        {
            radius2 = mo.getHeight() / 2;
            System.out.println("Radius 2 " + radius2 );
        }
        if(Math.sqrt(Math.pow(getX() + getWidth() / 2 - (mo.getX() + mo.getWidth() / 2), 2) +
            Math.pow(getY() + getHeight() / 2 - (mo.getY() + mo.getHeight() / 2), 2)) 
                < radius1 + radius2
                )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

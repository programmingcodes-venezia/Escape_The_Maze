/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Shushku
 */
public class DrawWalls {
    private String level;
    private ArrayList<Rectangle> walls;
    private Rectangle r;
            
    public DrawWalls(String level ) {
        this.level = level;
        walls = new ArrayList<>(100);
        
        //loadWalls();
    }
    
    public void drawTheWalls(Graphics g){
        g.setColor(Color.red);
        Rectangle r = new Rectangle(0, 0, 31, 1000);
        g.fillRect((int)r.getX(),(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());
        
        
    }
    
//    public void checkCollision(PlayerObject po){
//        int radius1;
//        int radius2;
//        for(int i=0;i<walls.size();i++){
//            if(po.getWidth() < po.getHeight())
//            {
//                radius1 = po.getWidth() / 2;
//            }
//            else
//            {
//                radius1 = height / 2;
//            }
//
//            if(r.getWidth() < r.getHeight())
//            {
//                radius2 = r.getWidth() / 2;
//            }
//            else
//            {
//                radius2 = r.getHeight() / 2;
//            }
//            if(Math.sqrt(Math.pow(x + width / 2 - (mo.getX() + mo.getWidth() / 2), 2) +
//                Math.pow(y + height / 2 - (mo.getY() + mo.getHeight() / 2), 2)) 
//                    < radius1 + radius2
//                    )
//            {
//                return true;
//            }
//            else
//            {
//                return false;
//            }
//        }
//    }
}

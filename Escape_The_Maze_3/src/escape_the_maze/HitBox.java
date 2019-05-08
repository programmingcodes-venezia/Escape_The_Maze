/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.Graphics;



/**
 *
 * @author Shushku
 */
public class HitBox {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    
    public HitBox(PlayerObject po) {
        x1 = po.getX();
        y1 = po.getY();
        x2 = x1 + 185;
        y2 = y1 + 185;
    }
    
    public void drawHitBox(Graphics g){
        g.drawLine(getX1(), getY1(), x2, getY1());
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
    
    
    
}

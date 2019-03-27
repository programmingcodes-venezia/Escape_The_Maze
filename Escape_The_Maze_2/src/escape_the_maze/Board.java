/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Shushku
 */
class Board extends JPanel implements Runnable{

    private final Thread boardThread;
    private final int B_WIDTH = 1000;
    private final int B_HEIGHT = 1000;
    GameLogic gl;
    public Dimension boardSize;

    Board() {
        boardSize = new Dimension(B_WIDTH, B_HEIGHT);

        gl = new GameLogic(boardSize);
        
        setBackground(Color.WHITE);
        
        setPreferredSize(boardSize);
        
//        GameKeyAdapter gKA = new GameKeyAdapter(gl);
        
        setFocusable(true);
        requestFocusInWindow();
        
//        addKeyListener(gKA);
        
        boardThread = new Thread(this);
        boardThread.setPriority(Thread.MAX_PRIORITY);
        
        
        boardThread.start();
        
        // this function is inherited by JPanel. It adds a listener in a new thread
        // that listens if the screen in resized. If so it calls the function
        // componentResized
        addComponentListener(new ComponentAdapter() 
        {  
        @Override
        public void componentResized(ComponentEvent evt) {
            boardSize.setSize(getSize());
            
        }
        });
    }
    
    
    
    
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(5);

            } catch (InterruptedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
//            gl.moveObjects();
//            gl.checkForCollisions();
            //gets paintComponent() to be called
            repaint();
        }
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        gl.drawObjects(g);
        String path = "player" + File.separator +  "player.png";
        Image img = (new ImageIcon(path)).getImage();
        Image level = (new ImageIcon("level.png")).getImage();
        g.drawImage(img, 469 - img.getWidth(null)/2, 736 - img.getHeight(null)/2, null);
        g.drawImage(level, 0, 0, this);
    }
    
}

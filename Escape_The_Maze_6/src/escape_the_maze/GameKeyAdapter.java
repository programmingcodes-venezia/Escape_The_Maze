/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Shushku
 */
class GameKeyAdapter extends KeyAdapter{
    private GameLogic gl;
        
        TimerTask task;
        Timer timer;
        
        public GameKeyAdapter(GameLogic gl)
        {
            this.gl = gl;
        }
    
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            
            if(timer!=null)
                return;
            
            task = new TimerTask(){
                
                @Override
                public void run(){
                    
            
                    switch(key)
                    {
                        case KeyEvent.VK_LEFT:
                        gl.getPlayerObject().moveLeft();
                        
                        break;
                        case KeyEvent.VK_RIGHT:
                        gl.getPlayerObject().moveRight();
                        
                        break;
                        case KeyEvent.VK_UP:
                        gl.getPlayerObject().moveUp();
                        
                        break;
                        case KeyEvent.VK_DOWN:
                        gl.getPlayerObject().moveDown();
                        
                        break;            
                    }
                }
            };
            timer= new Timer(true);
            timer.scheduleAtFixedRate(task, 0, 100);
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            if(timer!=null){
                timer.cancel();
                timer=null;
            }
        }
}

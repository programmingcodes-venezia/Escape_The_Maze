/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Shushku
 */
public class Escape_The_Maze extends JFrame{

    public Escape_The_Maze(){
        Board b = new Board();
        
        add(b);

        pack();
        
        setTitle("Escape The Maze");  
        
        
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    
    
    public static void main(String[] args) {
        JFrame jf = new Escape_The_Maze();
        jf.setVisible(true);
    }
    
}

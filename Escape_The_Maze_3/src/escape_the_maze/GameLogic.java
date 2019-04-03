/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Shushku
 */
class GameLogic {
    
    private ArrayList<Image> levels;
    private Image playerImage;
    private static int level;

    private Dimension boardSize;
    private int distanceFromBottom; 
    private PlayerObject po;
    
    public GameLogic(Dimension boardSize){
        
        this.boardSize = boardSize;
        System.out.println("boardsize address in GameLogic: " + this.boardSize.hashCode());
        levels = new ArrayList<>(20);
//        Carica le immagini del livello
        loadImages();
        level = 0;
        createPlayerObject();
        
        // crea i bordi del labirinto
//        createObjects();
        distanceFromBottom = 30;       
    }
    
    public void loadImages(){
        File folder = new File("levels");
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i<listOfFiles.length; i++){
            if(listOfFiles[i].isFile() /*|| !listOfFiles[i].getName().equals("")*/){
                Image levelSprite = (new ImageIcon(folder.toString()+ File.separator + listOfFiles[i].getName())).getImage();
                levels.add(levelSprite);
            }
        }
    }
    
    public void drawObjects(Graphics g){

        switch(level){
            case 0:
                g.drawImage(levels.get(level), 0, 0, null);
                po.setX(544);
                po.setY(669);
                po.drawPlayer(g);
                break;
        }
        
    }
    
    
    public void createPlayerObject(){
        po = new PlayerObject(0, 0, boardSize);
    }
    
    public PlayerObject getPlayerObject(){
        return po;
    }
    
    
//    public boolean isCompleted(){
//        
//        return i;
//    }
}

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
class GameLogic {
    
    private ArrayList<Image> images;
    private Image playerImage;

    private Dimension boardSize;
    private int distanceFromBottom; 
    private PlayerObject po;
    
    public GameLogic(Dimension boardSize){
        
        this.boardSize = boardSize;
        System.out.println("boardsize address in GameLogic: " + this.boardSize.hashCode());
        images = new ArrayList<>(20);
//        Carica le immagini del livello
        loadImages();
        
        // crea i bordi del labirinto
//        createObjects();
        distanceFromBottom = 30;
        
        // crea oggetto mobile dal giocatore
//        createPlayerObject();
        
    }
    
    public void loadImages(){
        
    }
}

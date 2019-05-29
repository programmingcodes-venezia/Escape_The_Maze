/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape_the_maze;

import java.util.ArrayList;

/**
 *
 * @author damiano
 */
public class AiMap {
    private String iD;
    private int x;
    private int y;
    private int weight;
    private ArrayList<AiMap> map;
    private AiMap nearUp;
    private AiMap nearLeft;
    private AiMap nearDown;
    private AiMap nearRight;
    
    
    public AiMap() {
        map = new ArrayList<>(100);
        
    }
    
    
    public void loadMap(){
        
    }
    
    
}

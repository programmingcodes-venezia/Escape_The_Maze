/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmodijkstra;

/**
 *
 * @author hu
 */
public class RamiAdiacente {
    private String nodeName;
    private int distance;
    
    public RamiAdiacente(String nodeName, int distance){
        this.nodeName= nodeName;
        this.distance= distance;
        
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
}

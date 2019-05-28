/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmodijkstra;
import java.util.ArrayList;
/**
 *
 * @author hu
 */
public class GrafoRete {
    ArrayList<Nodo> grafo = new ArrayList<>(10);
    
    public GrafoRete(){
        
        //Nodo A
        grafo.add(new Nodo("a", Integer.MAX_VALUE, "NULL", Stato.STIMATO));
        grafo.get(0).addRamiAdiacente("b", 2);
        grafo.get(0).addRamiAdiacente("g", 6);
        
        //Nodo B
        grafo.add(new Nodo("b", Integer.MAX_VALUE, "NULL", Stato.STIMATO));
        grafo.get(1).addRamiAdiacente("a", 2);
        grafo.get(1).addRamiAdiacente("c", 7);
        grafo.get(1).addRamiAdiacente("e", 2);
        
        //Nodo C
        grafo.add(new Nodo("c", Integer.MAX_VALUE, "NULL", Stato.STIMATO));
        grafo.get(2).addRamiAdiacente("b", 7);
        grafo.get(2).addRamiAdiacente("d", 3);
        grafo.get(2).addRamiAdiacente("f", 3);
        
        //Nodo D
        grafo.add(new Nodo("d", Integer.MAX_VALUE, "NULL", Stato.STIMATO));
        grafo.get(3).addRamiAdiacente("h", 2);
        grafo.get(3).addRamiAdiacente("c", 3);
       
        //Nodo E
        grafo.add(new Nodo("e", Integer.MAX_VALUE, "NULL", Stato.STIMATO));
        grafo.get(4).addRamiAdiacente("b", 2);
        grafo.get(4).addRamiAdiacente("g", 1);
        grafo.get(4).addRamiAdiacente("f", 2);
        
       
        //Nodo F
        grafo.add(new Nodo("f", Integer.MAX_VALUE, "NULL", Stato.STIMATO));
        grafo.get(5).addRamiAdiacente("h", 2);
        grafo.get(5).addRamiAdiacente("c", 3);
        grafo.get(5).addRamiAdiacente("e", 2);
        
        //Nodo G
        grafo.add(new Nodo("g", Integer.MAX_VALUE, "NULL", Stato.STIMATO));
        grafo.get(6).addRamiAdiacente("a", 6);
        grafo.get(6).addRamiAdiacente("e", 1);
        grafo.get(6).addRamiAdiacente("h", 4);
        
        
        //Nodo H
        grafo.add(new Nodo("h", Integer.MAX_VALUE, "NULL", Stato.STIMATO));
        grafo.get(7).addRamiAdiacente("d", 2);
        grafo.get(7).addRamiAdiacente("f", 2);
        grafo.get(7).addRamiAdiacente("g", 4);
        
        
    }
    
    
    
    
}

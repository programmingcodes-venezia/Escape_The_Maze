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
public class Nodo {
    private String nomeNodo;
    private int d;
    private String n;
    private Stato s;
    private ArrayList<RamiAdiacente> ramiAdiacenti = new ArrayList<>();
    private int distancePath;
    
    
    public Nodo(String nomeNodo, int d, String n, Stato s){
        this.nomeNodo = nomeNodo;
        this.d = d;
        this.n = n;
        this.s = s;
    }

    
    public void stampaInformazioni(){
        System.out.println("Nome nodo: "+ nomeNodo+
                           " D: "+d+
                           " N: "+n+
                           " S: "+s+
                           "\n Nodi adiacenti: ");
        
        for (int i=0; i<ramiAdiacenti.size(); ++i)
        {
            System.out.println("    Rame adiacente: "+ ramiAdiacenti.get(i).getNodeName()+" Distanza: "+ramiAdiacenti.get(i).getDistance());
        }
        
    }
    
    
    public ArrayList<RamiAdiacente> getRamiAdiacenti() {
        return ramiAdiacenti;
    }

    public void setRamiAdiacenti(ArrayList<RamiAdiacente> ramiAdiacenti) {
        this.ramiAdiacenti = ramiAdiacenti;
    }
    
    
    public void addRamiAdiacente(String nome, int n){
        ramiAdiacenti.add(new RamiAdiacente(nome, n));
    }
    

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public Stato getS() {
        return s;
    }

    public void setS(Stato s) {
        this.s = s;
    }

    public String getNomeNodo() {
        return nomeNodo;
    }

    public void setNomeNodo(String nomeNodo) {
        this.nomeNodo = nomeNodo;
    }

    public int getDistancePath() {
        return distancePath;
    }

    public void setDistancePath(int distancePath) {
        this.distancePath = distancePath;
    }
    
} 

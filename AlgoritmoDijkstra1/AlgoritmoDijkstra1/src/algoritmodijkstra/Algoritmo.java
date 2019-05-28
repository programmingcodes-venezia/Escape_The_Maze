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
public class Algoritmo {
    private final GrafoRete graforete;
    private final String nodeSorgente;
    private final String nodeDestinatario;
    private final int nodoSorg;
    private final int nodoDest;
    private int workingNode;
    
    public Algoritmo(String nodeSorgente, String nodeDestinatario)
    {
        graforete = new GrafoRete();
        this.nodeDestinatario=nodeDestinatario;
        this.nodeSorgente= nodeSorgente;
        nodoSorg= trovaIndiceNodoSorgente();
        nodoDest= trovaIndiceNodoDestinatario();
        workingNode= nodoSorg;
    }

    public final int trovaIndiceNodoSorgente()
    {
        for (int i=0; i<graforete.grafo.size(); ++i)
        {
            if (graforete.grafo.get(i).getNomeNodo().equals(nodeSorgente))
            {
                return i;
            }
        }
        return -1;//errore
    }
    
     public final int trovaIndiceNodoDestinatario()
    {
        for (int i=0; i<graforete.grafo.size(); ++i){
            if (graforete.grafo.get(i).getNomeNodo().equals(nodeDestinatario))
            {
                return i;
            }
        }
        return -1;//errore
    }
    
    public int trovaIndiceNodo(String n)
    {
        for (int i=0; i<graforete.grafo.size(); ++i)
        {
            if (graforete.grafo.get(i).getNomeNodo().equals(n))
            {
                return i;
            }
        }
        return -1;//errore
    }
    
    public int trovaDistanza(String a, String b)
    {
        int i = trovaIndiceNodo(a);
        for (int j=0; j<graforete.grafo.get(i).getRamiAdiacenti().size(); ++j)
        {
            if (graforete.grafo.get(i).getRamiAdiacenti().get(j).getNodeName().equals(b))
            {
                return graforete.grafo.get(i).getRamiAdiacenti().get(j).getDistance();
            }
        }
        return -1;
    }
 
    
    public void stampaPath(int nWN)
    {
        System.out.print("PATH: " + graforete.grafo.get(nWN).getNomeNodo()+ " ");
        do
        {
            System.out.print(graforete.grafo.get(nWN).getN() + " ");
            nWN =  trovaIndiceNodo(graforete.grafo.get(nWN).getN());
        }while(trovaIndiceNodo(graforete.grafo.get(nWN).getNomeNodo()) != nodoSorg);
    }
    
    public int distancePath(int nWN)
    {
        if(nWN == nodoSorg)
        {
            return 0;
        }
        int distance =0;
        do
        {
           int d= trovaDistanza(graforete.grafo.get(nWN).getNomeNodo(), graforete.grafo.get(nWN).getN());
          // System.out.println("distanza "+ d );
           distance += d;
            nWN = trovaIndiceNodo(graforete.grafo.get(nWN).getN());
        }while(trovaIndiceNodo(graforete.grafo.get(nWN).getNomeNodo()) != nodoSorg);
        return distance; 
    }
    
    
     public void distanzaTraNodiAdiacenti(int nWN)
    {
        for (int i=0; i<graforete.grafo.get(nWN).getRamiAdiacenti().size(); ++i)
        {
            if(graforete.grafo.get(trovaIndiceNodo(graforete.grafo.get(nWN).getRamiAdiacenti().get(i).getNodeName())).getS() == Stato.STIMATO)
            {
                graforete.grafo.get(trovaIndiceNodo(graforete.grafo.get(nWN).getRamiAdiacenti().get(i).getNodeName())).setD(distancePath(nWN));
            }
        }
    }
    
     
     public int nodoStimatoDistanzaMinima()
     {
         int indice=-1;
         int distanzaMin=Integer.MAX_VALUE;
         for (int i=0; i<graforete.grafo.size(); ++i)
         {
             if(graforete.grafo.get(i).getS()== Stato.STIMATO)
             {
                 if(graforete.grafo.get(i).getD()<distanzaMin)
                 {
                     indice = i;
                     distanzaMin = graforete.grafo.get(i).getD();
                 }
             }
         }
         return indice;
     }
    
    
    public int distanzaMinoreTraNodiAdiacenti(int nWN)
    {
       
        int nodeMinDistance = -1;
        for (int i=0; i<graforete.grafo.get(nWN).getRamiAdiacenti().size(); ++i)
        {
            if(graforete.grafo.get(nWN).getRamiAdiacenti().get(i).getDistance()< 
                    graforete.grafo.get(trovaIndiceNodo(graforete.grafo.get(nWN).getRamiAdiacenti().get(i).getNodeName())).getD()
                    && graforete.grafo.get(trovaIndiceNodo(graforete.grafo.get(nWN).getRamiAdiacenti().get(i).getNodeName())).getS() == Stato.STIMATO)
            {
                graforete.grafo.get(trovaIndiceNodo(graforete.grafo.get(nWN).getRamiAdiacenti().get(i).getNodeName())).setN(graforete.grafo.get(nWN).getNomeNodo());
                graforete.grafo.get(trovaIndiceNodo(graforete.grafo.get(nWN).getRamiAdiacenti().get(i).getNodeName())).setD(graforete.grafo.get(nWN).getRamiAdiacenti().get(i).getDistance());
               
                
                
            }else{
                continue;
            }
            nodeMinDistance = nodoStimatoDistanzaMinima();
        }
        return nodeMinDistance;
    }
   
    public void algoritmoD(){
        //Stampa iniziale
        for (int j=0; j < graforete.grafo.size(); ++j)
        {
            graforete.grafo.get(j).stampaInformazioni();
        }
 
        //A
        graforete.grafo.get(workingNode).setS(Stato.WORKNODE);
        int nodoMinore = distanzaMinoreTraNodiAdiacenti(workingNode);
        
        System.out.println("\n\n\n\n\n\n\n" );
        for (int j=0; j<graforete.grafo.size(); ++j)
        {
            graforete.grafo.get(j).stampaInformazioni();
        }
        
     
          
        while(workingNode != nodoDest)
        {
            workingNode = nodoMinore;
            graforete.grafo.get(workingNode).setS(Stato.WORKNODE);
            
            nodoMinore = distanzaMinoreTraNodiAdiacenti(workingNode);
            System.out.println("\n\n\n\n\n\n\n" );
            for (int j=0; j<graforete.grafo.size(); ++j)
            {
                graforete.grafo.get(j).stampaInformazioni();
            }
            stampaPath(workingNode);
            graforete.grafo.get(workingNode).setDistancePath(distancePath(workingNode));
            System.out.println("\nDistance Path: "+ graforete.grafo.get(workingNode).getDistancePath()); 
        }
    }
}


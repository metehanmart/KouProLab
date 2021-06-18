
package lab;

import static java.lang.invoke.MethodHandles.zero;


public class GraphShow {
    //noda ekleme
    private Map m;
    NodeWeighted []nodeweight;
    GraphWeighted graphWeighted;
    public GraphShow(){
        graphWeighted = new GraphWeighted(true);
        m = new Map();
        int size = m.getMap().size()*m.getMap().get(0).length();
        nodeweight = new NodeWeighted[size];
        int xekseni = m.getMap().get(0).length();
        int yekseni = m.getMap().size();
        int k=0;
        for(int i=0; i<yekseni; i++,k++){
            for(int j=0; j<xekseni; j++,k++){
                int indx = xekseni*i+j;
                nodeweight[indx] = new NodeWeighted(indx, Integer.toString(indx));
            }
        }
        //yollar arası masrafi hesaplama
        // ilk once yan yana olanlar
        int indx = 0;
        for(int y = 0; y < yekseni; y++){
            for(int x = 0; x + 1< xekseni; x++){
                indx = xekseni*y + x;
                if(m.getMap(x, y) == '1' && m.getMap(x+1, y) == '1'){
                    graphWeighted.addEdge(nodeweight[indx], nodeweight[indx+1], 1);
                }
                
            }
        }
        indx = 0;
        for(int y = 0; y < yekseni; y++){
            for(int x = xekseni-1; x - 1 >= 0; x--){
                indx = xekseni*y + x;
                if(m.getMap(x, y) == '1' && m.getMap(x-1, y) == '1'){
                    graphWeighted.addEdge(nodeweight[indx], nodeweight[indx-1], 1);
                }
                
            }
        }
        indx = 0;
        for(int x = 0; x < xekseni; x++){
            for(int y = 0; y+1 < yekseni; y++){
                indx = xekseni*y + x;
                if(m.getMap(x, y) == '1' && m.getMap(x, y+1) == '1'){
                    graphWeighted.addEdge(nodeweight[indx], nodeweight[indx+xekseni], 1);
                }
            }
        }
        indx = 0;
        for(int x = 0; x < xekseni; x++){
            for(int y = yekseni-1; y-1 >= 0; y--){
                indx = xekseni*y + x;
                if(m.getMap(x, y) == '1' && m.getMap(x, y-1) == '1'){
                    graphWeighted.addEdge(nodeweight[indx], nodeweight[indx-xekseni], 1);
                }
            }
        }
        
    }
    
    public String Show(int dusmanx,int dusmany,int kahramnx,int kahramany){
        return graphWeighted.DijkstraShortestPath(nodeweight[dusmany*m.getMap().get(0).length()+dusmanx],nodeweight[kahramany*m.getMap().get(0).length()+kahramnx]);
        
    }
}

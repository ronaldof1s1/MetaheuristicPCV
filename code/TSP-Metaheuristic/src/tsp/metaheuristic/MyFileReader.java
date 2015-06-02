/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.metaheuristic;
import java.io.*;




public class MyFileReader {
    
    Integer[][] readFile(String path) throws FileNotFoundException, IOException{
        BufferedReader bf;
        File f;
        f = new File(path);
        FileReader fr = new FileReader(f);
        bf = new BufferedReader(fr);
        String line;
        line = "";
        String[] words;
        Integer[][] graph;
        Integer size;
        size = -1;
        Integer[] xCoord, yCoord, distances;
        xCoord = new Integer[0];
        yCoord = new Integer[0];
        graph = new Integer[0][0];
       // distances = new Integer[0];
        
        while(bf.ready()){
            line = bf.readLine();
            if("EOF".equals(line)){
                break;
            }
            words = line.split("\\s+");
            
            if(null != words[0])
            switch (words[0]) {
                case "DIMENSION:":
                    size = Integer.parseInt(words[1]);
                    graph = new Integer[size][size];
                    xCoord = new Integer[size];
                    yCoord = new Integer[size];
                    break;
                case "NODE_COORD_SECTION":
                    while(bf.ready()){
                        line = bf.readLine();
                        words = line.split("\\s+");
                        xCoord[Integer.parseInt(words[0])] = Integer.parseInt(words[1]);
                        yCoord[Integer.parseInt(words[0])] = Integer.parseInt(words[2]);
                    }
                break;
            }
            
            //distances = new Integer[size];
            
            
            
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                graph[i][j] = distance(xCoord[i], yCoord[i], xCoord[j], yCoord[j]);
                if(i == j){
                    graph[i][j] = -1;
                }
            }
        }
        return graph;
    }

    int nint(Double x){
        x = x+0.5;
        Integer k;
        k = x.intValue();
        return k;
    }
    
    int distance(Integer x1, Integer y1, Integer x2, Integer y2){
        Double dist;
        dist = Math.sqrt( Math.pow(x1-x2, 2) + Math.pow(x1-x2, 2) ) ;
        return nint( dist );
    }
    
    //void parseDistances()
}

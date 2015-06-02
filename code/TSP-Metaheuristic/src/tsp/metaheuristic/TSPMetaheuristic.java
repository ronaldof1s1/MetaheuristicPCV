/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.metaheuristic;

import java.io.IOException;

/**
 *
 * @author ronaldofs
 */
public class TSPMetaheuristic {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        MyFileReader fr = new MyFileReader();
        Integer[][] readFile;
        readFile = fr.readFile("/home/ronaldofs/Documents/UFRN/2015.1/Trabalhos/PAA/Meta-heuristicas/code/TSP-Metaheuristic/build/classes/tsp/metaheuristic/test/test.tsp");
        //readFile = fr.readFile("tsp/metaheuristic/test/test.tsp");
    }
    
}

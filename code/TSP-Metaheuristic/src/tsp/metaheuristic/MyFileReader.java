/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.metaheuristic;
import java.io.*;
import java.nio.*;
import java.util.*;
/**
 *
 * @author ronaldofs
 */
public class MyFileReader {
    
    void readFile(String path) throws FileNotFoundException, IOException{
        BufferedReader bf;
        File f;
        f = new File(path);
        FileReader fr = new FileReader(f);
        bf = new BufferedReader(fr);
        while(!"EOF".equals(bf.readLine())){
            
        }
        
    }
}

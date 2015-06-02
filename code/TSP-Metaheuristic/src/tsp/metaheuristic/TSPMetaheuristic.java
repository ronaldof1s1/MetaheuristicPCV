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
public class TSPMetaheuristic
{

  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException
  {
    MyFileReader fr;
    Printer P;
    P = new Printer();
    fr = new MyFileReader();
    Integer[][] graph;
    graph = fr.readFile("test/test.tsp");
    P.printGraph(graph);
  }

}

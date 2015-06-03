/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.metaheuristic;

/**
 *
 * @author ronaldofs
 */
public class Printer
{

  void printGraph(Integer[][] graph)
  {
    for(int i = 0; i < graph.length; i++)
    {
      
      for(int j = 0; j < graph.length; j++)
      {
        System.out.print(graph[i][j] + "\t");
      }
      System.out.println("");
        
    }
  }
  
  void printCycle(Integer[] cycle)
  {
    for(int i = 0; i < cycle.length; i++)
    {
      System.out.print("V" + cycle[i] +"->");
    }
    System.out.println("V"+cycle[0]);
  }
 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.metaheuristic;

import java.util.ArrayList;

/**
 *
 * @author ronaldofs
 */
public class Metaheuristic
{
  Integer[][] neighborhood(Integer[][] graph, Integer[] solution, ArrayList<Integer[]> tabuTable)
  {
    Integer[][] neighborhood;
    neighborhood = new Integer[1][solution.length];
    return neighborhood;
  }
  
  Integer objective(Integer[][] graph, Integer[] solution)
  {
    TSP t = new TSP();
    Integer objective = t.cycleSize(graph, solution);
    return objective;
  }
  
  void buscaTabu(Integer tableSize, Integer[][] graph, Integer[] solution)
  {
    ArrayList<Integer[]> table;
    table = new ArrayList<>();
    
    for(int i = 0; i < solution.length; i++)
    {
      
    }
  }
}

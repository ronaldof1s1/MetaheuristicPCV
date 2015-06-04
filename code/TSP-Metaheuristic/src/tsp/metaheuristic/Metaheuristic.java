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
  Integer[] reverse(Integer[] list)
  {
    Integer[] temp;
    temp = new Integer[0];
    for(int i = 0; i < list.length/2; i++)
    {
      temp = swapNodes(list, i, list.length - i);
    }
    return temp;
  }
  Integer[] swapNodes(Integer[] list, int index1, int index2)
  {
    int temp = list[index1];
    list[index1] = list[index2];
    list[index2] = temp;
    return list;
  }
  
  ArrayList neighborhood(Integer[][] graph, Integer[] solution, ArrayList tabuTable)
  {
    ArrayList<Integer[]> neighborhood;
    neighborhood = new ArrayList<>();
    
    Integer[] move, tempSol;
    move = new Integer[2];
    Integer node = 0;
    move[0] = node;
    for(int i = 0; i < solution.length; )
    {
      move[1] = i;
      if(!(tabuTable.contains(move) && tabuTable.contains(reverse(move))))
      {
        tempSol = swapNodes(solution, move[1], move[2]);
        neighborhood.add(tempSol);
        tabuTable.add(move);
      }
    }
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
    ArrayList<Integer[]> neighbors1, neighbors2;
    
    Integer currObj, minObj;
    
    Integer[] bestSol;
    bestSol = solution;
    
    currObj = objective(graph, solution);
    minObj = currObj;
    for(int i = 0; i < solution.length; i++)
    {
      neighbors1 = neighborhood(graph, bestSol, table);
      for (Integer[] neighbor1 : neighbors1)
      {
        neighbors2 = neighborhood(graph, neighbor1, table);
        for(Integer[] neighbor2 : neighbors2)
        {
          currObj = objective(graph, neighbor2);
          if(currObj < minObj)
          {
            minObj = currObj;
            bestSol = neighbor2;
          }
        }
      }
    }
  }
}

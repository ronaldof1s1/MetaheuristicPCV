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
  int find(Integer[] list, int member)
  {
    for(int i = 0; i < list.length; i++)
    {
      if (list[i] == member)
      {
        return i;
      }
    }
    return -1;
  }
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
  Integer[] swapNodes(Integer[] list, int node1, int node2)
  {
    Printer P = new Printer();
    
    //System.out.println(node2);
    int index1 = find(list, node1);
    int index2 = find(list, node2);
    list[index1] = node2;
    list[index2] = node1;
    
    return list.clone();
  }
  
  ArrayList neighborhood(Integer[][] graph, Integer[] solution, ArrayList tabuTable, int tableSize)
  {
    ArrayList<Integer[]> neighborhood;
    neighborhood = new ArrayList<>();
    Printer P = new Printer();
    Integer[] move, tempSol;
    Integer node = 0;
    boolean cont;
    for(int i = 1; i < solution.length; i++)
    {
      move = new Integer[2];
      move[0] = node;
      move[1] = i;
      cont = tabuTable.contains(move);
      cont = cont && tabuTable.contains(reverse(move));
      if(!cont)
      {
        tempSol = swapNodes(solution.clone(), move[0], move[1]).clone();
        //P.printCycle(tempSol);
      
        neighborhood.add(tempSol.clone());
        
        if(tabuTable.size() >= tableSize)
        {
          tabuTable.remove(0);
        }
        tabuTable.add(move.clone());
        node = i;
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
  
  Integer[] buscaTabu(Integer tableSize, Integer[][] graph, Integer[] solution)
  {
    ArrayList<Integer[]> table;
    table = new ArrayList<>();
    ArrayList<Integer[]> neighbors1, neighbors2;
    Printer P = new Printer();
    Integer currObj, minObj;
    
    Integer[] bestSol;
    bestSol = solution.clone();
    //P.printCycle(bestSol);
    currObj = objective(graph, solution);
    minObj = currObj;
    for(int i = 0; i < solution.length; i++)
    {      
      neighbors1 = neighborhood(graph, bestSol.clone(), table, tableSize);
      for (Integer[] neighbor1 : neighbors1)
      {
        //P.printCycle(neighbor1);
        neighbors2 = neighborhood(graph, neighbor1.clone(), table, tableSize);
        for(Integer[] neighbor2 : neighbors2)
        {
          currObj = objective(graph, neighbor2);
          //System.out.println(currObj);
          //P.printCycle(neighbor2);
          if(currObj < minObj)
          {
            minObj = currObj;
            bestSol = neighbor2.clone();
            //System.out.println(minObj + "min obj");
            //P.printCycle(bestSol);
          }
        }
      }
    }
    return bestSol;
  }
}

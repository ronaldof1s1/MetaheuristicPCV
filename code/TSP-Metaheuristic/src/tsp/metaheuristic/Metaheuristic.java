/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.metaheuristic;

import java.util.ArrayList;
import java.util.Arrays;

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
  
  ArrayList neighborhood(Integer[][] graph, ArrayList<Integer> solution, ArrayList tabuTable, int tableSize)
  {
    ArrayList<ArrayList<Integer>> neighborhood;
    neighborhood = new ArrayList<>();
    Printer P = new Printer();
    Integer[] move;
    ArrayList<Integer> tempSol;
    Integer node = 0;
    boolean cont;
    for(int i = 1; i < solution.size(); i++)
    {
      move = new Integer[2];
      move[0] = node;
      move[1] = i;
      cont = tabuTable.contains(move);
      cont = cont && tabuTable.contains(reverse(move));
      if(!cont)
      {
        tempSol = swapNodes(solution.clone(), move[0], move[1]).clone();
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
  
  Integer objective(Integer[][] graph, ArrayList<Integer> solution)
  {
    int size = 0, n = solution.size()-1;
    for (int i = 0; i < n; i++)
    {
      int x = solution.get(i);
      int y = solution.get(i+1);
      size += graph[x][y];
    }
    size += graph[solution.get(n)][0];
    return size;
  }
  
  Integer[] buscaTabu(Integer tableSize, Integer[][] graph, Integer[] solution)
  {
    ArrayList<Integer[]> tabuTable;
    tabuTable = new ArrayList<>();
    ArrayList< ArrayList< Integer > > neighbors;
    Printer P = new Printer();
    int currObj, minObj;
    ArrayList< Integer > currSol, bestSol;
    currSol= new ArrayList<>(Arrays.asList(solution));
    //P.printCycle(bestSol);
    bestSol = new ArrayList<>(currSol);
    currObj = objective(graph, currSol);
    minObj = currObj;
    while(true)
    {
      neighbors = neighborhood(graph, currSol, tabuTable, tableSize);
    }
    return bestSol;
  }
}

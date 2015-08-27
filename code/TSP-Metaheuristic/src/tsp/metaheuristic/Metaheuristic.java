/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.metaheuristic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ronaldofs
 */
public class Metaheuristic
{
  Integer[] reverse(Integer[] list)
  {
    if(list.length >2)
    {
      System.out.println("DEU ERRO");
    }
    int temp = list[0];
    list[0] = list[1];
    list[1] = temp;
    return list;
  }
  
  ArrayList swapNodes3(ArrayList<Integer> list, int node1, int index2)
  {
    int index1 = list.indexOf(node1);
    list.set(index1, list.get(index2));
    list.set(index2, node1);
    return list;
  }
  
  ArrayList swapNodes2(ArrayList<Integer> list, int index1, int index2)
  {
    int nodeT = list.get(index1);
    list.set(index1, list.get(index2));
    list.set(index2, nodeT);
    return list;
  }
  
  ArrayList swapNodes(ArrayList<Integer> list, int node1, int node2)
  {
    Printer P = new Printer();
    
    //System.out.println(node2);
    int index1 = list.indexOf(node1);
    int index2 = list.indexOf(node2);
    list.set(index1, node2);
    list.set(index2, node1);
    
    return list;
  }
  
  ArrayList neighborhood(Integer[][] graph, ArrayList<Integer> solution, ArrayList tabuTable, int tableSize)
  {
    ArrayList<ArrayList<Integer>> neighborhood;
    neighborhood = new ArrayList<>();
    neighborhood.add(solution);
    Printer P = new Printer();
    Integer[] move;
    ArrayList<Integer> tempSol;
    Integer node = 0;
    boolean cont;
    Random R = new Random();
    for(int i = 1; i < solution.size(); i++)
    {
      
      move = new Integer[2];
      move[0] = node;
      move[1] = i;
      cont = tabuTable.contains(move);
      cont = cont && tabuTable.contains(reverse(move));
      if(!cont)
      {
        
        //tempSol = new ArrayList<>(swapNodes((ArrayList<Integer>) solution.clone(), move[0], move[1])); 
        tempSol = new ArrayList<>(swapNodes2((ArrayList<Integer>) solution.clone(), move[0], move[1])); 
        //tempSol = new ArrayList<>(swapNodes3((ArrayList<Integer>) solution.clone(), move[0], move[1])); 
        neighborhood.add(tempSol);
        //P.printCycle(tempSol);
        if(tabuTable.size() == tableSize)
        {
          tabuTable.remove(0);
        }
        node = R.nextInt(solution.size());
        tabuTable.add(move);
      }
    }
    return neighborhood;
  }
  
  Integer objective(Integer[][] graph, ArrayList<Integer> solution)
  {
    int size = 0;
    int n = solution.size()-1;
    int x, y;
    for (int i = 0; i < n; i++)
    {
      x = solution.get(i);
      y = solution.get(i + 1);
      size += graph[x][y];
    }
    x = solution.get(solution.size() -1);
    y = solution.get(0);
    size += graph[x][y];
    return size;
  }
  
  ArrayList buscaTabu(Integer tableSize, Integer[][] graph, Integer[] solution)
  {
    ArrayList<Integer[]> tabuTable;
    tabuTable = new ArrayList<>();
    ArrayList< ArrayList< Integer > > neighbors, neighbors1;
    Printer P = new Printer();
    int currObj, minObj;
    ArrayList< Integer > bestSol;
    int index;
    bestSol = new ArrayList<>(Arrays.asList(solution));
    currObj = objective(graph, bestSol);
    minObj = currObj;
    int chances = 5;
    boolean solFound;
    while(true)
    {
      solFound = false;
      
      neighbors1 = neighborhood(graph, bestSol, (ArrayList) tabuTable, tableSize);
      for(ArrayList<Integer> neighbor: neighbors1)
      {
        neighbors = neighborhood(graph, neighbor, tabuTable, tableSize);

        for (index = 0; index < neighbors.size(); index++)
        {
          currObj = objective(graph, neighbors.get(index));
          if(currObj < minObj)
          {
            bestSol = neighbors.get(index);
            solFound = true;
            minObj = currObj;
          }
        }
      }
      if(!solFound)
      {
        break;
        
      }
    }
    return bestSol;
  }
}

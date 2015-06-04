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
public class TSP
{
  
  Integer[] nextNeighbor(Integer[][] graph, Integer start, boolean[] visited)
  {
    Integer[] cycle = new Integer[graph.length];
    cycle[0] = start;
    visited[start] = true;
    Integer minEdge, currEdge, currNode;
    currNode = start;
    for(int i = 0; i < graph.length-1; i++)
    {
      minEdge = Integer.MAX_VALUE;
      for(int j = 0; j < graph.length; j++)
      {
        if(visited[j])
        {
          continue;
        }
        currEdge = graph[currNode][j];
        if(currEdge < minEdge && currEdge > 0)
        {
          minEdge = currEdge;
          cycle[i+1] = j;
          currNode = j;
        }
      }
      visited[cycle[i+1]] = true;
    }
    return cycle;
      
  }
  
  Integer cycleSize(Integer[][] graph, Integer[] cycle)
  {
    Integer size = 0;
    Integer x,y;
    for(int i = 0; i < graph.length-1; i++)
    {
      x = cycle[i]; y = cycle[i+1];
      size += graph[x][y];
    }
    x = cycle[graph.length-1];
    y = cycle[0];
    size += graph[x][y];
    return size;
  }
  
  Integer[] findInitialSolution(Integer[][] graph)
  {
    Integer[] cycle, minCycle;
    Integer size, minSize;
    minCycle = new Integer[graph.length];
    boolean[] visited;
    minSize = Integer.MAX_VALUE;
    
    for(int i = 0; i < graph.length; i++)
    {
      visited = new boolean[graph.length];
      cycle = nextNeighbor(graph, i,visited);
      size = cycleSize(graph, cycle);
      if(size < minSize)
      {
        minCycle = cycle;
        minSize = size;
      }
    }
    System.out.println(minSize);
    return minCycle;
  }
}

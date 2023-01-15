package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort_DFS {
    public void topologicalSort(int[][] graph, int v) {
        // Build Graph
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int x = 0; x < v; x++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : graph) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }
        //
        Stack<Integer> result = new Stack<>();
        boolean[] visited = new boolean[v];
        for (int currentNode = 0; currentNode < v; currentNode++) {
            if (!visited[currentNode]) {
                visit(adjacencyList, result, visited, new boolean[v], currentNode);
            }
        }
        while(!result.isEmpty()){
            System.out.println(result.pop());
        }
    }

    public void visit(List<List<Integer>> adjacencyList, Stack<Integer> result, boolean[] visited, boolean[] temp, int currentNode){
        if(visited[currentNode]){
            return;
        }
        if(temp[currentNode]){
            System.out.println("Cycle detected");
            return;
        }
        temp[currentNode] = true;
        for(int nextNode : adjacencyList.get(currentNode)){
            visit(adjacencyList, result, visited, temp, nextNode);
        }
        temp[currentNode] = false;
        visited[currentNode] = true;
        result.push(currentNode);
    }
}
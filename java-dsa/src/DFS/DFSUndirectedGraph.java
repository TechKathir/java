package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFSUndirectedGraph {
    List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        DFSUndirectedGraph undirectedGraph = new DFSUndirectedGraph();
        int nodes = 4;
        undirectedGraph.graph.add(Arrays.asList(0, 1, 2));
        undirectedGraph.graph.add(Arrays.asList(2, 3, 0));
        undirectedGraph.graph.add(Arrays.asList(1, 3, 0));
        undirectedGraph.graph.add(Arrays.asList(2, 3));
//        undirectedGraph.BFSBase(undirectedGraph.graph, nodes);
        undirectedGraph.BFSTraversalLoop(undirectedGraph.graph, 3, nodes);
    }

    private void BFSBase(List<List<Integer>> graph, int nodes) {
        boolean[] visited = new boolean[nodes];
        System.out.println("len  - " + visited.length);
        BFSTraversalRecursion(graph, 3, visited);
    }

    private void BFSTraversalRecursion(List<List<Integer>> graph, int startSource, boolean[] visited) {
        visited[startSource] = true;

        for (Integer integer : graph.get(startSource)) {
            if (!visited[integer]) {
                BFSTraversalRecursion(graph, integer, visited);
            }
        }
        System.out.println("v1 - " + startSource);
    }

    private void BFSTraversalLoop(List<List<Integer>> graph, int startSource, int nodes) {
        boolean[] visited = new boolean[nodes];
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(startSource);
        visited[startSource] = true;

        while (!integerStack.isEmpty()) {
            int val = integerStack.pop();
            for (Integer i : graph.get(val)) {
                if (!visited[i]) {
                    System.out.println("vo - " + i);
                    integerStack.push(i);
                    visited[i] = true;
                }
            }
            System.out.println(val);
        }
        System.out.println("v1 - " + startSource);
    }


}

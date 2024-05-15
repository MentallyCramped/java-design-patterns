package dev.abhay.behavioral.strategy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link ProblemSolver}, focusing on its behavior when provided with different
 * {@link Algorithm} implementations for graph traversal.
 */
public class ProblemSolverTest {

  private ProblemSolver<Graph, List<Integer>> solver;
  private Graph graph;

  private static class Graph {

    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
      this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int from, int to) {
      this.adjacencyList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
      this.adjacencyList.computeIfAbsent(to, k -> new ArrayList<>());
    }

    public List<Integer> getAdjacentNodes(int node) {
      return this.adjacencyList.getOrDefault(node, new ArrayList<>());
    }
  }

  private static class BFSAlgorithm implements Algorithm<Graph, List<Integer>> {

    private final int startNode;

    public BFSAlgorithm(int startNode) {
      this.startNode = startNode;
    }

    @Override
    public List<Integer> executeAlgorithm(Graph graph) {
      Set<Integer> visited = new HashSet<>();
      List<Integer> visitOrder = new ArrayList<>();
      Queue<Integer> queue = new ArrayDeque<>();

      visited.add(startNode);
      queue.add(startNode);
      visitOrder.add(startNode);

      while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int neighbor : graph.getAdjacentNodes(node)) {
          if (!visited.contains(neighbor)) {
            visited.add(neighbor);
            queue.add(neighbor);
            visitOrder.add(neighbor);
          }
        }
      }
      return visitOrder;
    }
  }

  private static class DFSAlgorithm implements Algorithm<Graph, List<Integer>> {

    private final int startNode;

    public DFSAlgorithm(int startNode) {
      this.startNode = startNode;
    }

    @Override
    public List<Integer> executeAlgorithm(Graph graph) {
      Set<Integer> visited = new HashSet<>();
      List<Integer> visitOrder = new ArrayList<>();
      Stack<Integer> stack = new Stack<>();

      stack.push(startNode);

      while (!stack.isEmpty()) {
        int node = stack.pop();
        if (!visited.contains(node)) {
          visited.add(node);
          visitOrder.add(node);
          List<Integer> neighbors = graph.getAdjacentNodes(node);
          Collections.reverse(neighbors);
          for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
              stack.push(neighbor);
            }
          }
        }
      }
      return visitOrder;
    }
  }

  @BeforeEach
  public void setup() {
    graph = new Graph();
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 3);

    solver = ProblemSolver.<Graph, List<Integer>>builder()
        .algorithm(new BFSAlgorithm(0))
        .build();
  }

  @Test
  public void testBFS() {
    List<Integer> bfsResult = solver.solveProblem(graph);
    Assertions.assertEquals(Arrays.asList(0, 1, 2, 3), bfsResult);
  }

  @Test
  public void testDFS() {
    solver.setAlgorithm(new DFSAlgorithm(0));
    List<Integer> dfsResult = solver.solveProblem(graph);
    Assertions.assertTrue(
        Arrays.asList(0, 2, 3, 1).equals(dfsResult) || Arrays.asList(0, 1, 3, 2).equals(dfsResult));
  }
}
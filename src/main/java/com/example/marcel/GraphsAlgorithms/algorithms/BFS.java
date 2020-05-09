package com.example.marcel.GraphsAlgorithms.algorithms;

import com.example.marcel.GraphsAlgorithms.models.Graph;
import com.example.marcel.GraphsAlgorithms.models.Node;
import com.example.marcel.GraphsAlgorithms.models.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Component
public class BFS {
    private Integer grid[][];
    private Node initial;
    private Node end;
    private Queue<Node> limits;
    private Graph graph;
    private static Integer pathX[] = {-1, 1, 0, 0};
    private static Integer pathY[] = {0, 0, 1, -1};

    public BFS() {
    }

    public BFS(Integer[][] grid, Node initial, Node end, Graph graph) {
        this.grid = grid;
        this.initial = initial;
        this.end = end;
        this.limits = new ArrayDeque<>();
        this.graph = graph;
    }

    public void search() {
        this.end.setParent(null);
        Node atual = this.initial;
        atual.setLevel(0);
        atual.setParent(null);
        this.limits.add(atual);
        while (!limits.isEmpty()) {
            atual = limits.poll();
            if (this.grid[atual.getX()][atual.getY()] != 1) {
                this.graph.addNode(atual);
                for (int i = 0; i < 4; ++i) {
                    Integer newX = Math.max(0, atual.getX() + pathX[i]);
                    newX = Math.min(15, newX);
                    Integer newY = Math.max(0, atual.getY() + pathY[i]);
                    newY = Math.min(19, newY);

                    if (this.end.getX() == newX && this.end.getY() == newY) {
                        this.grid[newX][newY] = 1;
                        this.end.setLevel(atual.getLevel() + 1);
                        this.end.setParent(new Pair(atual.getX(), atual.getY()));
                        this.graph.addNode(this.end);
                        return;
                    }

                    if (this.grid[newX][newY] != 1) {
                        Node nextNode = new Node(newX, newY, atual.getLevel() + 1, new Pair(atual.getX(), atual.getY()));
                        this.limits.add(nextNode);
                    }
                }
                this.grid[atual.getX()][atual.getY()] = 1;
            }
        }
    }

    public void definePath() {
        List<Node> path = new ArrayList<>();
        if (this.end.getParent() == null) {
            return;
        }

        Node current = this.end;
        while (current != null) {
            path.add(current);
            if (current.getParent() != null) {
                current = this.graph.getParentInGraph(new Node(current.getParent().getX(), current.getParent().getY()));
            } else {
                current = null;
            }
        }

        this.graph.setPath(path);

    }

    public Integer[][] getGrid() {
        return grid;
    }

    public void setGrid(Integer[][] grid) {
        this.grid = grid;
    }

    public Node getInitial() {
        return initial;
    }

    public void setInitial(Node initial) {
        this.initial = initial;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public Queue<Node> getLimits() {
        return limits;
    }

    public void setLimits(Queue<Node> limits) {
        this.limits = limits;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public static Integer[] getPathX() {
        return pathX;
    }

    public static void setPathX(Integer[] pathX) {
        BFS.pathX = pathX;
    }

    public static Integer[] getPathY() {
        return pathY;
    }

    public static void setPathY(Integer[] pathY) {
        BFS.pathY = pathY;
    }
}

package com.example.marcel.GraphsAlgorithms.models;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<Node> nodes;
    public List<Node> path;

    public List<Node> getPath() {
        return path;
    }

    public Graph() {
        this.nodes = new ArrayList<>();
        this.path = new ArrayList<>();
    }

    public Graph(List<Node> nodes, List<Node> path) {
        this.nodes = nodes;
        this.path = path;
    }

    public void setPath(List<Node> path) {
        this.path = path;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Node getParentInGraph(Node node) {
        int index = nodes.indexOf(node);
        if (index == -1) {
            return null;
        }
        return this.nodes.get(index);
    }
}

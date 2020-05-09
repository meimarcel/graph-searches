package com.example.marcel.GraphsAlgorithms.models;

import java.util.Objects;

public class Node implements Comparable<Node> {
    private Integer x;
    private Integer y;
    private Integer level;
    private Double peso;

    private Pair parent;

    public Node() {
    }

    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Node(Integer x, Integer y, Integer level, Pair parent) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.parent = parent;
    }

    public Node(Integer x, Integer y, Integer level, Pair parent, Double peso) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.parent = parent;
        this.peso = peso;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Pair getParent() {
        return parent;
    }

    public void setParent(Pair parent) {
        this.parent = parent;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(x, node.x) &&
                Objects.equals(y, node.y);
    }

    @Override
    public int compareTo(Node o) {
        int ans = (int) (this.peso - o.peso);
        if (ans != 0) {
            return (int) (this.peso - o.peso);
        } else {
            return (int) (10000000 * (this.peso - o.peso));
        }
    }
}

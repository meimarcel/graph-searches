package com.example.marcel.GraphsAlgorithms.models;

import java.util.Arrays;

public class Grid {
    private Integer[][] grid;
    private Integer initialX;
    private Integer initialY;
    private Integer endX;
    private Integer endY;

    public Grid() {
    }

    @Override
    public String toString() {
        return "Grid{" +
                "grid=" + Arrays.toString(grid) +
                ", initialX=" + initialX +
                ", initialY=" + initialY +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
    }

    public Grid(Integer[][] grid, Integer initialX, Integer initialY, Integer endX, Integer endY) {
        this.grid = grid;
        this.initialX = initialX;
        this.initialY = initialY;
        this.endX = endX;
        this.endY = endY;
    }

    public Integer[][] getGrid() {
        return grid;
    }

    public void setGrid(Integer[][] grid) {
        this.grid = grid;
    }

    public Integer getInitialX() {
        return initialX;
    }

    public void setInitialX(Integer initialX) {
        this.initialX = initialX;
    }

    public Integer getInitialY() {
        return initialY;
    }

    public void setInitialY(Integer initialY) {
        this.initialY = initialY;
    }

    public Integer getEndX() {
        return endX;
    }

    public void setEndX(Integer endX) {
        this.endX = endX;
    }

    public Integer getEndY() {
        return endY;
    }

    public void setEndY(Integer endY) {
        this.endY = endY;
    }
}

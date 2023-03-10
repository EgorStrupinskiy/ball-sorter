package com.innowise.ballsorter.entity;

import com.innowise.ballsorter.utils.Color;

public abstract class Ball {
    private Color color;
    private int size;
    private int weight;

    public Ball() {
    }

    protected Ball(Color color, int size, int weight) {
        this.color = color;
        this.size = size;
        this.weight = weight;
    }

    public abstract String getBallType();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball ball)) return false;

        if (getSize() != ball.getSize()) return false;
        if (getWeight() != ball.getWeight()) return false;
        return getColor() == ball.getColor();
    }

    @Override
    public int hashCode() {
        int result = getColor() != null ? getColor().hashCode() : 0;
        result = 31 * result + getSize();
        result = 31 * result + getWeight();
        return result;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color=" + color +
                ", size=" + size +
                ", weight=" + weight +
                '}';
    }
}

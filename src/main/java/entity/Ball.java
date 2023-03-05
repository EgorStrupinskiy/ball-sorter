package entity;

import utils.BallType;
import utils.Color;

public abstract class Ball {
    private Color color;
    private int size;
    private int weight;

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


    public Ball() {
    }

    public Ball(Color color, int size, int weight, BallType ballType) {
        this.color = color;
        this.size = size;
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
        return ", color=" + color +
                ", size=" + size +
                ", weight=" + weight +
                '}';
    }
}

package com.innowise.ballsorter.entity.comparator;

import com.innowise.ballsorter.entity.Ball;

import java.util.Comparator;

public class WeightComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball o1, Ball o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}

package com.innowise.ballsorter.entity.comparator;

import com.innowise.ballsorter.entity.Ball;

import java.util.Comparator;

public class BallTypeComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball o1, Ball o2) {
        return o1.getBallType().compareTo(o2.getBallType());
    }
}

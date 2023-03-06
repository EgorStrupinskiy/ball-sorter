package com.innowise.ballsorter.runner;

import com.innowise.ballsorter.entity.Ball;
import com.innowise.ballsorter.entity.FootballBall;
import com.innowise.ballsorter.entity.VolleyballBall;
import com.innowise.ballsorter.entity.comparator.ColorComparator;
import com.innowise.ballsorter.sorter.impl.HeapSorter;
import com.innowise.ballsorter.utils.Color;
import com.innowise.ballsorter.utils.Season;
import com.innowise.ballsorter.utils.SurfaceType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ball> list = new ArrayList<>();
        list.add(new VolleyballBall(Color.BLACK, 12, 200, SurfaceType.ASPHALT));
        list.add(new FootballBall(Color.RED, 14, 200, Season.SUMMER));
        list.add(new VolleyballBall(Color.WHITE, 10, 200, SurfaceType.SAND));
        list.add(new FootballBall(Color.GREEN, 10, 200, Season.WINTER));


        var sorter = new HeapSorter();
        sorter.sort(list, new ColorComparator());
        System.out.println(list);
    }
}

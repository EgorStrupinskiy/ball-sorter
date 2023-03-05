package com.innowise.ballsorter.runner;

import com.innowise.ballsorter.entity.comparator.BallTypeComparator;
import com.innowise.ballsorter.utils.SurfaceType;
import com.innowise.ballsorter.entity.Ball;
import com.innowise.ballsorter.entity.FootballBall;
import com.innowise.ballsorter.entity.VolleyballBall;
import com.innowise.ballsorter.utils.Color;
import com.innowise.ballsorter.utils.Season;
import com.innowise.ballsorter.entity.comparator.WeightComparator;
import com.innowise.ballsorter.sorter.impl.QuickSorter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ball> list = new ArrayList<>();
        list.add(new VolleyballBall(Color.BLACK, 12, 200,  SurfaceType.ASPHALT));
        list.add(new FootballBall(Color.BLACK, 14, 200,  Season.SUMMER));
        list.add(new VolleyballBall(Color.WHITE, 10, 200,  SurfaceType.SAND));
        list.add(new FootballBall(Color.GREEN, 10, 200,  Season.WINTER));

//        list.sort(new BallTypeComparator());
//        MergeSorter.mergeSort(list, new WeightComparator().thenComparing(new SizeComparator()));////////////////////
//        QuickSorter.quickSort(list, new WeightComparator().thenComparing(new SizeComparator()));
//        HeapSorter.heapSort(list, new WeightComparator().thenComparing(new BallTypeComparator()));
        var sorter = new QuickSorter();
        sorter.sort(list, new WeightComparator().thenComparing(new BallTypeComparator()));
        System.out.println(list);
    }
}

package com.innowise.ballsorter.sorter;

import com.innowise.ballsorter.entity.Ball;
import com.innowise.ballsorter.entity.FootballBall;
import com.innowise.ballsorter.entity.VolleyballBall;
import com.innowise.ballsorter.entity.comparator.SizeComparator;
import com.innowise.ballsorter.sorter.impl.HeapSorter;
import com.innowise.ballsorter.utils.Color;
import com.innowise.ballsorter.utils.Season;
import com.innowise.ballsorter.utils.SurfaceType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapSorterTest {
    @Test
    public void shouldSortListBySizeWhenListIsNotEmpty() {
        //given
        var comparator = new SizeComparator();
        var sorter = new HeapSorter();

        var actual = getBallsList();
        var expected = getBallsList();
        expected.sort(new SizeComparator());

        //when
        sorter.sort(actual, comparator);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyListWhenListIsEmpty() {
        //given
        var comparator = new SizeComparator();
        var sorter = new HeapSorter();

        var actual = getEmptyList();
        var expected = getEmptyList();

        //when
        sorter.sort(actual, comparator);

        //then
        assertEquals(expected, actual);
    }

    private List<Ball> getBallsList() {
        List<Ball> list = new ArrayList<>();
        list.add(new VolleyballBall(Color.BLACK, 12, 200, SurfaceType.ASPHALT));
        list.add(new FootballBall(Color.RED, 14, 200, Season.SUMMER));
        list.add(new VolleyballBall(Color.WHITE, 10, 200, SurfaceType.SAND));
        list.add(new FootballBall(Color.GREEN, 10, 200, Season.WINTER));
        return list;
    }

    private List<Ball> getEmptyList() {
        return new ArrayList<>();
    }
}

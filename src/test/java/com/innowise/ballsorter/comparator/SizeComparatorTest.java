package com.innowise.ballsorter.comparator;

import com.innowise.ballsorter.entity.Ball;
import com.innowise.ballsorter.entity.FootballBall;
import com.innowise.ballsorter.entity.comparator.SizeComparator;
import com.innowise.ballsorter.utils.Color;
import com.innowise.ballsorter.utils.Season;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeComparatorTest {
    @Test
    public void shouldReturnOneWhenFirstBallIsBiggerThanSecond() {
        //given
        var comparator = new SizeComparator();
        var first = getBall(10);
        var second = getBall(5);
        var expected = 1;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMinusOneWhenFirstBallIsSmallerThanSecond() {
        //given
        var comparator = new SizeComparator();
        var first = getBall(5);
        var second = getBall(10);
        var expected = -1;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroWhenFirstBallSizeEqualsToSecond() {
        //given
        var comparator = new SizeComparator();
        var first = getBall(10);
        var second = getBall(10);
        var expected = 0;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    private Ball getBall(int size){
        return new FootballBall(Color.BLACK, size, 40, Season.WINTER);
    }
}

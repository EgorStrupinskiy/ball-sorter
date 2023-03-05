package com.innowise.ballsorter.comparator;

import com.innowise.ballsorter.entity.Ball;
import com.innowise.ballsorter.entity.FootballBall;
import com.innowise.ballsorter.entity.comparator.WeightComparator;
import com.innowise.ballsorter.utils.Color;
import com.innowise.ballsorter.utils.Season;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightComparatorTest {
    @Test
    public void shouldReturnOneWhenFirstBallIsHeavierThanSecond() {
        //given
        var comparator = new WeightComparator();
        var first = getBall(10);
        var second = getBall(5);
        var expected = 1;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMinusOneWhenFirstBallIsLighterThanSecond() {
        //given
        var comparator = new WeightComparator();
        var first = getBall(5);
        var second = getBall(10);
        var expected = -1;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroWhenFirstBallWeightEqualsToSecond() {
        //given
        var comparator = new WeightComparator();
        var first = getBall(10);
        var second = getBall(10);
        var expected = 0;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    private Ball getBall(int weight) {
        return new FootballBall(Color.BLACK, 40, weight, Season.WINTER);
    }
}

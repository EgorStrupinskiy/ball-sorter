package com.innowise.ballsorter.comparator;
import com.innowise.ballsorter.entity.Ball;
import com.innowise.ballsorter.entity.FootballBall;
import com.innowise.ballsorter.entity.comparator.ColorComparator;
import com.innowise.ballsorter.utils.Color;
import com.innowise.ballsorter.utils.Season;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorComparatorTest {
    @Test
    public void shouldReturnNegativeWhenFirstBallIsGreenAndSecondBallIsRed() {
        //given
        var comparator = new ColorComparator();
        var first = getBall(Color.GREEN);
        var second = getBall(Color.RED);
        var expected = -4;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPositiveWhenFirstBallIsRedAndSecondBallIsGreen() {
        //given
        var comparator = new ColorComparator();
        var first = getBall(Color.RED);
        var second = getBall(Color.GREEN);
        var expected = 4;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroWhenTwoBallsAreGreen() {
        //given
        var comparator = new ColorComparator();
        var first = getBall(Color.GREEN);
        var second = getBall(Color.GREEN);
        var expected = 0;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    private Ball getBall(Color color){
        return new FootballBall(color, 40, 40, Season.WINTER);
    }
}

package com.innowise.ballsorter.comparator;

import com.innowise.ballsorter.entity.Ball;
import com.innowise.ballsorter.entity.FootballBall;
import com.innowise.ballsorter.entity.VolleyballBall;
import com.innowise.ballsorter.entity.comparator.BallTypeComparator;
import com.innowise.ballsorter.utils.Color;
import com.innowise.ballsorter.utils.Season;
import com.innowise.ballsorter.utils.SurfaceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTypeComparatorTest {
    @Test
    public void shouldReturnNegativeWhenFirstBallTypeIsFootballAndSecondBallTypeIsVolleyball() {
        //given
        var comparator = new BallTypeComparator();
        var first = getFootballBall();
        var second = getVolleyballBall();
        var expected = -16;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPositiveWhenFirstBallTypeIsVolleyballAndSecondBallTypeIsFootball() {
        //given
        var comparator = new BallTypeComparator();
        var first = getVolleyballBall();
        var second = getFootballBall();
        var expected = 16;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroWhenTwoBallsTypesAreFootball() {
        //given
        var comparator = new BallTypeComparator();
        var first = getFootballBall();
        var second = getFootballBall();
        var expected = 0;

        //when
        var actual = comparator.compare(first, second);

        //then
        assertEquals(expected, actual);
    }

    private Ball getFootballBall() {
        return new FootballBall(Color.RED, 40, 40, Season.WINTER);
    }

    private Ball getVolleyballBall() {
        return new VolleyballBall(Color.RED, 40, 40, SurfaceType.ASPHALT);
    }
}

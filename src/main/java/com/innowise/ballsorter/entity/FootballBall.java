package com.innowise.ballsorter.entity;

import com.innowise.ballsorter.utils.BallType;
import com.innowise.ballsorter.utils.Color;
import com.innowise.ballsorter.utils.Season;

public class FootballBall extends Ball {
    private Season season;

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public FootballBall() {
    }

    public FootballBall(Color color, int size, int weight, BallType ballType, Season season) {
        super(color, size, weight, ballType);
        this.season = season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballBall that)) return false;
        if (!super.equals(o)) return false;

        return getSeason() == that.getSeason();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getSeason() != null ? getSeason().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nFootballBall{" +
                "season=" + season +
                super.toString();
    }
}

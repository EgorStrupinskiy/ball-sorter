package com.innowise.ballsorter.entity;

import com.innowise.ballsorter.utils.Color;
import com.innowise.ballsorter.utils.SurfaceType;

public class VolleyballBall extends Ball {
    private SurfaceType surfaceType;

    public SurfaceType getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(SurfaceType surfaceType) {
        this.surfaceType = surfaceType;
    }

    public VolleyballBall() {

    }

    public VolleyballBall(Color color, int size, int weight, SurfaceType surfaceType) {
        super(color, size, weight);
        this.surfaceType = surfaceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VolleyballBall that)) return false;
        if (!super.equals(o)) return false;

        return getSurfaceType() == that.getSurfaceType();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getSurfaceType() != null ? getSurfaceType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nVolleyballBall{" +
                "surfaceType=" + surfaceType +
                super.toString();
    }
}

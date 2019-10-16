package ru.semenovmy.learning.drawfigures.model;

import android.graphics.PointF;

public class Line {

    private PointF mOrigin;
    private PointF mEnd;
    private int mColor;

    public Line(PointF origin, PointF end, int color) {
        mOrigin = origin;
        mEnd = end;
        mColor = color;
    }

    public PointF getOrigin() {
        return mOrigin;
    }

    public PointF getEnd() {
        return mEnd;
    }

    public void setEnd(PointF end) {
        mEnd = end;
    }

    public int getColor() {
        return mColor;
    }
}

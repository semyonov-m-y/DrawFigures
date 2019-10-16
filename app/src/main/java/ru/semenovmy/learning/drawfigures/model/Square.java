package ru.semenovmy.learning.drawfigures.model;

import android.graphics.PointF;

public class Square {

    private PointF mOrigin;
    private PointF mCurrent;
    private int mColor;

    public Square(PointF origin, int color) {
        mOrigin = origin;
        mCurrent = origin;
        mColor = color;
    }

    public PointF getOrigin() {
        return mOrigin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF current) {
        mCurrent = current;
    }

    public int getColor() {
        return mColor;
    }
}


package com.example.lab5;

import android.graphics.Point;
import android.graphics.PointF;

public class Box {
    private PointF mOrigin;
    private PointF mCurrent;

    public Box(PointF origin) {
        mOrigin = origin;
        mCurrent = origin;
    }

    public PointF getmOrigin() {
        return mOrigin;
    }

    public void setmOrigin(PointF mOrigin) {
        this.mOrigin = mOrigin;
    }

    public PointF getmCurrent() {
        return mCurrent;
    }

    public void setmCurrent(PointF mCurrent) {
        this.mCurrent = mCurrent;
    }
}

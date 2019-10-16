package ru.semenovmy.learning.drawfigures.model;

import android.graphics.Path;

public class Graph {

    private Path mPath;
    private int color;

    public Graph(Path path, int color) {
        mPath = path;
        this.color = color;
    }

    public Path getPath() {
        return mPath;
    }

    public int getColor() {
        return color;
    }
}

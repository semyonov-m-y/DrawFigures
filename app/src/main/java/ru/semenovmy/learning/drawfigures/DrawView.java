package ru.semenovmy.learning.drawfigures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ru.semenovmy.learning.drawfigures.model.FigureType;
import ru.semenovmy.learning.drawfigures.model.Graph;
import ru.semenovmy.learning.drawfigures.model.Line;
import ru.semenovmy.learning.drawfigures.model.Square;

public class DrawView extends View {

    private Path mDrawPath = new Path();
    private Paint mGraphPaint = new Paint();
    private List<Graph> mGraphss = new ArrayList<>();
    private Graph mGraph;

    private Paint mLinePaint = new Paint();
    private List<Line> mLines = new ArrayList<>();
    private Line mLine;

    private Paint mSquarePaint = new Paint();
    private List<Square> mSquares = new ArrayList<>();
    private Square mCurrentSquare;

    private int mCurrentColor;

    private FigureType mFigureType = FigureType.GRAPH;

    public DrawView(Context context) {
        this(context, null);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
    }

    private void setupPaint() {
        mGraphPaint.setColor(mCurrentColor);
        mGraphPaint.setAntiAlias(true);
        mGraphPaint.setStyle(Paint.Style.STROKE);
        mGraphPaint.setStrokeWidth(10f);

        mLinePaint.setColor(mCurrentColor);
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(10f);

        mSquarePaint.setColor(mCurrentColor);
        mSquarePaint.setAntiAlias(true);
        mSquarePaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        graphDraw(canvas);
        lineDraw(canvas);
        squareDraw(canvas);
    }

    private void graphDraw(Canvas canvas) {
        for (Graph graph : mGraphss) {
            mGraphPaint.setColor(graph.getColor());
            canvas.drawPath(graph.getPath(), mGraphPaint);
        }
    }

    private void lineDraw(Canvas canvas) {
        for (Line line : mLines) {
            float startX = line.getOrigin().x;
            float startY = line.getOrigin().y;
            float endX = line.getEnd().x;
            float endY = line.getEnd().y;
            mLinePaint.setColor(line.getColor());
            canvas.drawLine(startX, startY, endX, endY, mLinePaint);
        }
    }

    private void squareDraw(Canvas canvas) {
        for (Square square : mSquares) {
            float left = Math.min(square.getCurrent().x, square.getOrigin().x);
            float right = Math.max(square.getCurrent().x, square.getOrigin().x);
            float top = Math.min(square.getCurrent().y, square.getOrigin().y);
            float bottom = Math.max(square.getCurrent().y, square.getOrigin().y);
            mSquarePaint.setColor(square.getColor());
            canvas.drawRect(left, top, right, bottom, mSquarePaint);
        }
    }

    public void setDrawType(FigureType figureType) {
        mFigureType = figureType;
    }

    public void setPaintColor(int color) {
        mCurrentColor = color;
    }

    public void clear() {
        mLines.clear();
        mGraphss.clear();
        mSquares.clear();
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (mFigureType) {
            case GRAPH:
                graphMotionEvents(event);
                break;
            case LINE:
                lineMotionEvents(event);
                break;
            case SQUARE:
                squareMotionEvents(event);
                break;
            default:
                return super.onTouchEvent(event);
        }
        invalidate();
        return true;
    }

    private void graphMotionEvents(MotionEvent event) {
        int action = event.getAction();
        PointF currentPoint = new PointF(event.getX(), event.getY());

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mDrawPath = new Path();
                mDrawPath.moveTo(currentPoint.x, currentPoint.y);
                break;
            case MotionEvent.ACTION_MOVE:
                mDrawPath.lineTo(currentPoint.x, currentPoint.y);
                mGraph = new Graph(mDrawPath, mCurrentColor);
                mGraphss.add(mGraph);
            case MotionEvent.ACTION_CANCEL:
                break;
        }
    }

    private void lineMotionEvents(MotionEvent event) {
        int action = event.getAction();
        PointF currentPoint = new PointF(event.getX(), event.getY());

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLine = new Line(currentPoint, currentPoint, mCurrentColor);
                mLines.add(mLine);
                break;
            case MotionEvent.ACTION_MOVE:
                if (mLine != null) {
                    mLine.setEnd(currentPoint);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mLine = null;
                break;
        }
    }

    private void squareMotionEvents(MotionEvent event) {
        int action = event.getAction();
        PointF currentPoint = new PointF(event.getX(), event.getY());

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mCurrentSquare = new Square(currentPoint, mCurrentColor);
                mSquares.add(mCurrentSquare);
                break;
            case MotionEvent.ACTION_MOVE:
                if (mCurrentSquare != null) {
                    mCurrentSquare.setCurrent(currentPoint);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mCurrentSquare = null;
                break;
        }
    }
}

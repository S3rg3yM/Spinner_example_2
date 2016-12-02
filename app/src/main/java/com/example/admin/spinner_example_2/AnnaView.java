package com.example.admin.spinner_example_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

public class AnnaView extends View {

    private static final String TAG = "View";
    private int percent = 50;

    public void setPercent(int percent) {
        this.percent = percent;
    }

    Paint p;

    public AnnaView(Context context) {
        super(context);
    }

    public AnnaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        p = new Paint();

        p.setAntiAlias(true);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setStyle(Paint.Style.STROKE);
        this.setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG,"onDraw(Canvas canvas): ");

        int width = canvas.getWidth();
        int height = canvas.getHeight();
//        Log.d(TAG,"CanvasWidth = " + width);

        canvas.drawARGB(80, 102, 204, 255);
        p.setColor(Color.GREEN);
        p.setStrokeWidth(10);
        canvas.drawCircle(width/2, height/2, width*percent/200, p);
    }

    public AnnaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG,"onAttachedToWindow(): ");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG,"onDetachedFromWindow(): ");
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Log.d(TAG,"onVisibilityChanged(View changedView, int visibility): " + visibility);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG,"onMeasure(int widthMeasureSpec, int heightMeasureSpec): ");
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean onKeyU = super.onKeyDown(keyCode, event);
        Log.d(TAG,"onKeyUp(int keyCode, KeyEvent event): " + onKeyU);
        return onKeyU;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean onKeyD = super.onKeyDown(keyCode, event);
        Log.d(TAG,"onKeyDown(int keyCode, KeyEvent event): " + onKeyD);
        return onKeyD;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, "onSizeChanged(int w, int h, int oldw, int oldh): ");
    }
}

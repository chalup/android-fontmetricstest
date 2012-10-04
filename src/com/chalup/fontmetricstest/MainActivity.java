package com.chalup.fontmetricstest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends Activity {

  private static final String TEST_STRING = "Żyłę";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View fontMetricDemoVew = new View(this) {
      @SuppressLint("DrawAllocation")
      @Override
      protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        Paint testStringPaint = new Paint();
        testStringPaint.setColor(Color.BLACK);
        testStringPaint.setAntiAlias(true);
        testStringPaint.setTextSize(getMeasuredHeight() / 3);

        PointF origin = new PointF(getMeasuredWidth(), getMeasuredHeight() * 2 / 3);
        testStringPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(TEST_STRING, origin.x, origin.y, testStringPaint);

        Paint linesPaint = new Paint();
        linesPaint.setColor(Color.BLACK);
        linesPaint.setAntiAlias(false);
        linesPaint.setAlpha(64);

        Paint labelsPaint = new Paint();
        labelsPaint.setColor(Color.BLACK);
        labelsPaint.setAntiAlias(true);
        labelsPaint.setTextAlign(Paint.Align.LEFT);

        FontMetrics fontMetrics = testStringPaint.getFontMetrics();

        drawLabel(canvas, "top", origin.y, fontMetrics.top, linesPaint, labelsPaint, false);
        drawLabel(canvas, "-textSize", origin.y, -testStringPaint.getTextSize(), linesPaint, labelsPaint, true);
        drawLabel(canvas, "ascent", origin.y, fontMetrics.ascent, linesPaint, labelsPaint, false);
        drawLabel(canvas, "origin", origin.y, 0, linesPaint, labelsPaint, false);
        drawLabel(canvas, "descent-textSize", origin.y, fontMetrics.descent-testStringPaint.getTextSize(), linesPaint, labelsPaint, false);
        drawLabel(canvas, "descent", origin.y, fontMetrics.descent, linesPaint, labelsPaint, false);
        drawLabel(canvas, "bottom", origin.y, fontMetrics.bottom, linesPaint, labelsPaint, false);
        drawLabel(canvas, "leading", origin.y, fontMetrics.bottom + fontMetrics.leading, linesPaint, labelsPaint, true);
      }

      private void drawLabel(Canvas canvas, String label, float origin, float offset, Paint linesPaint, Paint labelsPaint, boolean indent) {
        canvas.drawLine(0, origin + offset, getMeasuredWidth(), origin + offset, linesPaint);
        canvas.drawText(label + ": "  + offset, indent ? getMeasuredWidth() / 2 : 0, origin + offset, labelsPaint);
      }
    };
    setContentView(fontMetricDemoVew, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
  }
}

package com.chalup.fontmetricstest;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View fontMetricDemoVew = new View(this) {
          @Override
          protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.RED);
          }
        };
        setContentView(fontMetricDemoVew, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }
}

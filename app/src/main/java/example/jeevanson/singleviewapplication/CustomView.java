package example.jeevanson.singleviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

    Paint paint;
    float touchX;
    float touchY;
    int backgroundColor;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public void setViewBackground(int red, int green, int blue) {

        backgroundColor = Color.rgb(red,green,blue);
        invalidate();
    }



    public CustomView(Context context, AttributeSet attr) {
        super(context,attr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        setViewBackground(0,0,0);
    }



    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawColor(backgroundColor);
        canvas.drawCircle(touchX,touchY,50,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        touchX = event.getX();
        touchY = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            paint.setColor(Color.WHITE);
        }

        if(event.getAction() == MotionEvent.ACTION_UP) {
            paint.setColor(Color.YELLOW);
        }

        if(event.getAction() == MotionEvent.ACTION_MOVE) {
            paint.setColor(Color.RED);
        }




        invalidate();

        return true;
    }
}

package example.jeevanson.singleviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class CustumView extends View {

    Paint paint;
    float touchX;
    float touchY;

    public CustumView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.YELLOW);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawColor(Color.RED);
        canvas.drawCircle(touchX,touchY,50,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        touchX = event.getX();
        touchY = event.getY();
        invalidate();

        return true;
    }
}

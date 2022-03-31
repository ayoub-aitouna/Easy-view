package project.savvycom.mylibrary.MyViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import project.savvycom.mylibrary.R;


public class MyLinearLayout extends LinearLayout {
    private static final String TAG = "GradientText_LOG";
    int StartColor;
    int EndColor;
    int color;
    int MyView_borderColor;
    int Angel = 0;
    int radius = 0;
    int radiusTopLeft = 0;
    int radiusTopRight = 0;
    int radiusBottomLeft = 0;
    int radiusBottomRight = 0;
    int MyView_borderWidth = 0;

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.MyView,
                0, 0);

        try {
            StartColor = a.getColor(R.styleable.MyView_MyView_startColor, 0);
            EndColor = a.getColor(R.styleable.MyView_MyView_endColor, 0);
            MyView_borderColor = a.getColor(R.styleable.MyView_MyView_borderColor, Color.parseColor("#c4c4c4"));
            color = a.getColor(R.styleable.MyView_MyView_color, Color.parseColor("#c4c4c4"));
            Angel = a.getInteger(R.styleable.MyView_MyView_angle, 0);
            radius = a.getInteger(R.styleable.MyView_MyView_radius, 0);
            radiusTopLeft = a.getInteger(R.styleable.MyView_MyView_radiusTopLeft, -1);
            radiusTopRight = a.getInteger(R.styleable.MyView_MyView_radiusTopRight, -1);
            radiusBottomLeft = a.getInteger(R.styleable.MyView_MyView_radiusBottomLeft, -1);
            radiusBottomRight = a.getInteger(R.styleable.MyView_MyView_radiusBottomRight, -1);
            MyView_borderWidth = a.getInteger(R.styleable.MyView_MyView_borderWidth, 0);
        } catch (Exception e) {
            Log.d(TAG, "GradientText: " + e.getMessage());
        } finally {
            a.recycle();
        }
        SetShape();
    }

    private void SetShape() {
        try {
            GradientDrawable shape = new GradientDrawable();
            shape.setShape(GradientDrawable.RECTANGLE);
            if (StartColor == -1 && EndColor == -1)
                shape.setColor(color);
            else {
                shape.setColors(new int[]{StartColor,
                        EndColor});
                shape.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                GradientDrawable.Orientation orientation;
                switch (Angel) {
                    case -45:
                        orientation = GradientDrawable.Orientation.BR_TL;
                        break;
                    case 45:
                        orientation = GradientDrawable.Orientation.BL_TR;

                        break;
                    case 90:
                        orientation = GradientDrawable.Orientation.BOTTOM_TOP;

                        break;
                    case -90:
                        orientation = GradientDrawable.Orientation.TOP_BOTTOM;

                        break;
                    case -180:
                        orientation = GradientDrawable.Orientation.LEFT_RIGHT;

                        break;
                    default:
                        orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                        break;
                }
                shape.setOrientation(orientation);
            }
            shape.setStroke(MyView_borderWidth, MyView_borderColor);
            shape.setCornerRadii(
                    new float[]{radiusTopLeft != -1 ? radiusTopLeft : radius, radiusTopLeft != -1 ? radiusTopLeft : radius,
                            radiusTopRight != -1 ? radiusTopRight : radius, radiusTopRight != -1 ? radiusTopRight : radius,
                            radiusBottomRight != -1 ? radiusBottomRight : radius, radiusBottomRight != -1 ? radiusBottomRight : radius,
                            radiusBottomLeft != -1 ? radiusBottomLeft : radius, radiusBottomLeft != -1 ? radiusBottomLeft : radius});

            this.setBackgroundDrawable(shape);

        } catch (Exception e) {
            Log.d(TAG, "SetShape: " + e.getMessage());
        }

    }

}

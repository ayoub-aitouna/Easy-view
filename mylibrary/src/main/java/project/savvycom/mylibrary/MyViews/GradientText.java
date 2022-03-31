package project.savvycom.mylibrary.MyViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;


import project.savvycom.mylibrary.R;

@SuppressLint("AppCompatCustomView")
public class GradientText extends TextView {
    private static final String TAG = "GradientText_LOG".toUpperCase();
    int StartColor = Color.parseColor("#FFFFFF");
    int EndColor = Color.parseColor("#000000");
    int Angel = 0;

    public GradientText(Context context) {
        super(context);
    }

    public GradientText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.GradientText,
                0, 0);

        try {
            StartColor = a.getColor(R.styleable.GradientText_startColor, Color.parseColor("#FFFFFF"));
            EndColor = a.getColor(R.styleable.GradientText_endColor, Color.parseColor("#000000"));
            Angel = a.getInteger(R.styleable.GradientText_angle, 0);
        } catch (Exception e) {
            Log.d(TAG, "GradientText: " + e.getMessage());
        } finally {
            a.recycle();
        }
        SetGradient(StartColor, EndColor, Angel);
    }

    public GradientText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GradientText(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    void SetGradient(int StartColor, int EndColor, int Angel) {
        try {
            this.setTextColor(StartColor);
            TextPaint paint = this.getPaint();
            float width = paint.measureText(this.getText().toString());
            float height = this.getTextSize();
            Shader textShader;
            switch (Angel) {
                case -45:
                    textShader = new LinearGradient(width, 0, 0, height,
                            new int[]{StartColor,
                                    EndColor}, null, Shader.TileMode.CLAMP);
                    break;
                case 45:
                    textShader = new LinearGradient(0, height, width, 0,
                            new int[]{StartColor,
                                    EndColor}, null, Shader.TileMode.CLAMP);
                    break;
                case 90:
                    textShader = new LinearGradient(width / 2, 0, width / 2, height,
                            new int[]{StartColor,
                                    EndColor}, null, Shader.TileMode.CLAMP);
                    break;
                case -90:
                    textShader = new LinearGradient(width / 2, height, width / 2, 0,
                            new int[]{StartColor,
                                    EndColor}, null, Shader.TileMode.CLAMP);
                    break;
                case -180:
                    textShader = new LinearGradient(width, height / 2, 0, height / 2,
                            new int[]{StartColor,
                                    EndColor}, null, Shader.TileMode.CLAMP);
                    break;
                default:
                    textShader = new LinearGradient(0, height / 2, width, height / 2,
                            new int[]{StartColor,
                                    EndColor}, null, Shader.TileMode.CLAMP);
                    break;
            }


            this.getPaint().setShader(textShader);

        } catch (Exception e) {
            Log.d(TAG, "SetGradient: " + e.getMessage() + "StartColor :" + StartColor + "  EndColor: " + EndColor);
        }
    }


}

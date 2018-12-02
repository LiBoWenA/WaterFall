package com.example.tiamo.threeday.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.tiamo.threeday.R;

import static com.example.tiamo.threeday.R.styleable.kjColor;

@SuppressLint("AppCompatCustomView")
public class WaterFallText extends TextView {

    public WaterFallText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.KongJian);
        int color = typedArray.getColor(R.styleable.kjColor_textcolor, Color.BLACK);

        setTextColor(color);
        //回收
        typedArray.recycle();
    }
}

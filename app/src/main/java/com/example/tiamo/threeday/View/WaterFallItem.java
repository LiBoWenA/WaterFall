package com.example.tiamo.threeday.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class WaterFallItem extends LinearLayout {

    private int mChildMacHeigh;
    private int mHSpace = 20;
    private int mVSpace = 20;

    public WaterFallItem(Context context) {
        super(context);
    }

    public WaterFallItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获得父容器的宽高
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int heigh = MeasureSpec.getSize(heightMeasureSpec);
        //测量孩子的宽高
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        findChildMaxHeigh();
        int left = 0,top = 0;
        int mCount = getChildCount();
        for (int i = 0; i < mCount; i++) {
            View view = getChildAt(i);
            if(left != 0){
                if((left+view.getMeasuredWidth()) > width){
                    top += mChildMacHeigh+mVSpace;
                    left = 0;
                }
            }
            left += view.getMeasuredWidth() +mHSpace;
        }
        //测量
        setMeasuredDimension(width,(top + mChildMacHeigh) > heigh ? heigh : top+mChildMacHeigh);
    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findChildMaxHeigh();
        int left = 0,top = 0;
        int mCount = getChildCount();
        for (int i = 0; i < mCount; i++) {
            View view = getChildAt(i);
            if(left != 0){
                if((left+view.getMeasuredWidth()) > getWidth()){
                    top += mChildMacHeigh+mVSpace;
                    left = 0;
                }
            }
            //安排孩子的位置
            view.layout(left,top,left+view.getMeasuredWidth(),top + mChildMacHeigh);
            left += view.getMeasuredWidth() +mHSpace;
        }

    }

    private void findChildMaxHeigh() {
        int count = getChildCount();
        mChildMacHeigh = 0;
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            if (view.getMeasuredHeight() > mChildMacHeigh){
                mChildMacHeigh = view.getMeasuredHeight();
            }
        }
    }
}

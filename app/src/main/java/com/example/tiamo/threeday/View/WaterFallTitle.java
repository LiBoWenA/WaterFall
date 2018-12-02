package com.example.tiamo.threeday.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.tiamo.threeday.R;

public class WaterFallTitle extends LinearLayout {
    Context context;
    public WaterFallTitle(Context context) {
        super(context);
        this.context = context;
        init();
    }


    public WaterFallTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        View view = View.inflate(context,R.layout.water_itemtitle,null);
        final EditText editText = view.findViewById(R.id.editText);
        view.findViewById(R.id.button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonClickLister != null){
                    buttonClickLister.OnButtonClick(editText.getText().toString());
                }
            }
        });
       addView(view);
    }

    //定义接口传得到editText的值
    OnButtonClickLister buttonClickLister;

    public void setOnButtonClickLister(OnButtonClickLister clickLister){
        buttonClickLister = clickLister;
    }

    public interface  OnButtonClickLister{
        void OnButtonClick(String str);
    }


}

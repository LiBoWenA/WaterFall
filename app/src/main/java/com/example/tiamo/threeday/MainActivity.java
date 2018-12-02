package com.example.tiamo.threeday;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tiamo.threeday.Bean.UserBean;
import com.example.tiamo.threeday.SQLite.Dao;
import com.example.tiamo.threeday.View.WaterFallItem;
import com.example.tiamo.threeday.View.WaterFallText;
import com.example.tiamo.threeday.View.WaterFallTitle;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Dao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        final WaterFallItem Search_history = findViewById(R.id.item_text);
        WaterFallItem hot = findViewById(R.id.item_texts);
        dao = new Dao(this);
        WaterFallTitle title = findViewById(R.id.title);
        final List<UserBean> query = dao.query();
        for (int i = 0; i < query.size(); i++) {
            TextView tv = new TextView(this);
            tv.setText(query.get(i).getTitle());
            tv.setTextColor(Color.RED);
            tv.setBackgroundResource(R.drawable.edit_bg);
            Search_history.addView(tv);
            final int index = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dao.del(query.get(index).getUuid());
                    Search_history.removeView(v);
                }
            });
        }
        title.setOnButtonClickLister(new WaterFallTitle.OnButtonClickLister() {
            @Override
            public void OnButtonClick(String str) {



                UUID uuid = UUID.randomUUID();
                TextView tv = new TextView(MainActivity.this);
                tv.setTag(uuid);
                tv.setTextColor(Color.RED);
                tv.setText(str);
                tv.setBackgroundResource(R.drawable.edit_bg);
                Search_history.addView(tv);
                dao.insert(uuid.toString(),str);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dao.del(v.getTag().toString());
                        Search_history.removeView(v);
                    }
                });
            }
        });

        for (int i = 0; i < 30; i++) {
            TextView tv = new TextView(MainActivity.this);
            tv.setText("数据 " + i);
            tv.setTextColor(Color.RED);
            tv.setBackgroundResource(R.drawable.edit_bg);
            hot.addView(tv);
        }
    }
}

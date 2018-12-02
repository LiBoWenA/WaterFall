package com.example.tiamo.threeday.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tiamo.threeday.Bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    MySQL mySQL;
    SQLiteDatabase database;

    public Dao(Context context) {
        mySQL = new MySQL(context);
        database = mySQL.getReadableDatabase();
    }

    public void insert(String uuid,String title){
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("uuid",uuid);
        database.insert("user",null,values);
    }

    public void del(String uuid){
        database.delete("user","uuid = ?",new String[]{uuid});
    }

    public List<UserBean> query(){
        List<UserBean> list = new ArrayList<>();
        Cursor query = database.query("user", null, null, null, null, null, null);
        while (query.moveToNext()){
            String title = query.getString(query.getColumnIndex("title"));
            String uuid = query.getString(query.getColumnIndex("uuid"));
            UserBean bean = new UserBean(title,uuid);
            list.add(bean);
        }
        return list;
    }
}

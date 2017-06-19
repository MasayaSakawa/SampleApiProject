package com.example.mobile03.url;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    AsyncNetworkTask task;
    AsyncNetworkTasks tasks;

    //URL
    private EditText editText1 = null;
    //商品名
    private EditText editText2 = null;
    //名前
    private EditText editText3 = null;
    //sql
    private String mode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //URL
        editText1 = (EditText) findViewById(R.id.editText1);
        //商品名
        editText2 = (EditText) findViewById(R.id.editText2);
        //名前
        editText3 = (EditText) findViewById(R.id.editText3);

        task = new AsyncNetworkTask(this);
        tasks = new AsyncNetworkTasks(this);
    }

    public void onClick(View v) {
        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();
        String str3 = editText3.getText().toString();
        String str4 = str2 + str3;

        switch(v.getId()) {
            //検索
            case R.id.button1:
                mode = "/find.json";
                task.execute("?" + str1 + mode + str4);
                break;
            //追加
            case R.id.button2:
                mode = "/add.json";
                task.execute("?" + str1 + mode + str4);
                break;
            //削除
            case R.id.button3:
                mode = "/delete.json";
                task.execute("?" + str1 + mode + str4);
                break;
            //キャンセル
            case R.id.button4:
                task.cancel(true);
                break;
            //一覧
            case R.id.button5:
                mode = "/index.json";
                tasks.execute("?" + str1 + mode + str4);
                break;
        }
    }
}


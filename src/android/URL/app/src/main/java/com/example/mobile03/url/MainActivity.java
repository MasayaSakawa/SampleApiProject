package com.example.mobile03.url;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    //URL
    private EditText editText1 = null;
    //商品名
    private EditText editText2 = null;
    //名前
    private EditText editText3 = null;
    //sql
    private String sql = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //URL
        editText1 = (EditText) findViewById(R.id.editText1);
        //商品名
        editText2 = (EditText) findViewById(R.id.editText2);
        //名前
        editText3 = (EditText) findViewById(R.id.editText3);

        final Button button1 = (Button) findViewById(R.id.button1);
    }
    public void onClick(View v) {
        // 入力された文字を取得
        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();
        String str3 = editText3.getText().toString();
        String str4 = "?" + str2 + str3;
        //押したボタンでの分岐
        switch(v.getId()){
            case R.id.button1:
                sql = "";
                break;
        }
        // 取得した文字をTextViewにセット！
        Uri uri = Uri.parse(str1 + str4 + sql);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
}
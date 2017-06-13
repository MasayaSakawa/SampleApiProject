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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new OnClickListener() {




            public void onClick(View v) {

                //URL
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                //商品名
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                //名前
                //EditText editText3 = (EditText) findViewById(R.id.editText3);



                // 入力された文字を取得

                String str1 = editText1.getText().toString();
                String str2 = editText2.getText().toString();
                String str3 = str1 + str2;

                //SQL
                String sql = "SELECT * from name WHERE";


                // 取得した文字をTextViewにセット！


                Uri uri = Uri.parse(str3 + sql);
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);


            }


        });

    }


}
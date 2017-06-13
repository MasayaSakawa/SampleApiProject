package com.example.mobile03.url;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends Activity {
    //URL
    private EditText editText1 = null;
    //商品名
    private EditText editText2 = null;
    //名前
    private EditText editText3 = null;
    //sql
    private String mode = null;

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
        String str4 = str2 + str3;
        //押したボタンでの分岐
        switch(v.getId()) {
            case R.id.button1:
                mode = "/SampleApi/data/productList.json";
                // 取得した文字をTextViewにセット！
                try {
                    URL uri = new  URL("http://" + str1 + str4 + mode);
                    HttpURLConnection con = (HttpURLConnection)uri.openConnection();
                    con.setRequestMethod("GET");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "Shift-JIS"));
                    /*StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    TextView txtResult = (TextView) findViewById(R.id.textResult);
                    txtResult.setText(builder.toString());*/
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("", "IOException" + e);
                }
                break;
        }
    }
}
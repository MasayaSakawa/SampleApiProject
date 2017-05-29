package com.example.mobile01.api;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn_onClick(View view) {
        WebView wv = (WebView) findViewById(R.id.wv);
        EditText editText = (EditText) findViewById(R.id.editText1);
        EditText editText1 = (EditText) findViewById(R.id.editText2);
        String str1 = editText.getText().toString();
        String str2 = editText1.getText().toString();
        String str3 = str1 + str2;
        wv.loadUrl(str3);
    }
}
package to.msn.wings.a1url;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView text = (TextView) findViewById(R.id.textview);

        Intent i = getIntent();
        //Intent in = getIntent();
        String data1 = i.getStringExtra("id");
        //String data2 = i.getStringExtra("KEY2");
        //String str = data1 + data2;
        text.setText(data1);
    }

    public void onClick(View v) {
        finish();
    }

}
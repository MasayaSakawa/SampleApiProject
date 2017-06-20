package to.msn.wings.sakawa_www;

/**
 * Created by 4163103 on 2017/06/19.
 */


import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncNetworkTasks extends AsyncTask<String, Integer, String> {
    private TextView txtResult;
    private ProgressBar progress;

    public AsyncNetworkTasks(Context context) {
        super();
        to.msn.wings.sakawa_www.MainActivity activity = (to.msn.wings.sakawa_www.MainActivity) context;
        txtResult = (TextView) activity.findViewById(R.id.txtResut);
        progress = (ProgressBar) activity.findViewById(R.id.progress);
    }

    @Override
    protected String doInBackground(String... params) {
        publishProgress(30);
        SystemClock.sleep(3000);
        publishProgress(60);
        StringBuilder builder = new StringBuilder();
        StringBuilder list = new StringBuilder();

        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "Shift-JIS"));
            String line;
            while ((line = reader.readLine()) != null){
                builder.append(line);
            }
            try {
                JSONObject json = new JSONObject(builder.toString());
                JSONArray products = json.getJSONArray("products");
                for (int i = 0; i < products.length(); i++) {
                    JSONObject product = products.getJSONObject(i);
                    list.append("id:");
                    list.append(product.getString("id")).append("name:");
                    list.append(product.getString("name")).append("price:");
                    list.append(product.getString("price")).append("円\n");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        publishProgress(100);
        return list.toString();
    }

    @Override
    protected void onPreExecute() {
        progress.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progress.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        txtResult.setText(result);
        progress.setVisibility(ProgressBar.GONE);
    }

    @Override
    protected void onCancelled() {
        txtResult.setText("キャンセルされました。");
        progress.setVisibility(ProgressBar.GONE);
    }
}

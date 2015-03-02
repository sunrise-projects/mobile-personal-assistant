package com.example.chit.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import org.joda.time.LocalTime;

import java.net.URL;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onStart() {
        super.onStart();

        //TextView textView = (TextView) findViewById(R.id.text_view);
       // textView.setText("Hello world!");

        LocalTime currentTime = new LocalTime();
        TextView textView2 = (TextView) findViewById(R.id.text_view);
        textView2.setText("The current local time is: " + currentTime);

        new RestCallTask().execute();


    }

    private class RestCallTask extends AsyncTask<URL, Integer, List<GitHubClient.Contributor>> {
        protected List<GitHubClient.Contributor> doInBackground(URL... urls) {

            GitHubClient cl = new GitHubClient();
            cl.getList();
            return cl.getList();
        }

        protected void onProgressUpdate(Integer... progress) {
            //setProgressPercent(progress[0]);
        }

        protected void onPostExecute(List<GitHubClient.Contributor> result) {
            StringBuilder a = new StringBuilder();
            for (GitHubClient.Contributor c : result) {
                a.append(":");
                a.append(c.login);
            }

            TextView textView2 = (TextView) findViewById(R.id.text_view);
            //textView2.setText("The current local time is: " + currentTime);
            textView2.setText(a.toString());

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

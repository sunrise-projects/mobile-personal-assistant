package com.example.chit.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.joda.time.LocalTime;

import java.net.URL;
import java.util.List;
import java.util.Locale;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.content.Intent;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends ActionBarActivity implements View.OnClickListener, OnInitListener {

    private int MY_DATA_CHECK_CODE = 0;
    private TextToSpeech myTTS;

    private int voiceInitStatus = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button speakButton = (Button)findViewById(R.id.increment);
        speakButton.setOnClickListener(this);

        Button speakButton2 = (Button)findViewById(R.id.decrement);
        speakButton2.setOnClickListener(this);

        //check for TTS data
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
    }



    //respond to button clicks
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.increment:
                //get the text entered
                EditText enteredText = (EditText)findViewById(R.id.counterText);
                String words = enteredText.getText().toString();
                speakWords(words);

                break;
            case R.id.decrement:
                // it was the second button
                new RestCallTask().execute();

                break;
        }


    }

    //speak the user text
    private void speakWords(String speech) {

        //speak straight away
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    //act on result of TTS data check
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                //the user has the necessary data - create the TTS
                myTTS = new TextToSpeech(this, this);
            }
            else {
                //no data - install it now
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }

    //setup TTS
    public void onInit(int initStatus) {

        //check for successful instantiation
        if (initStatus == TextToSpeech.SUCCESS) {
            voiceInitStatus = initStatus;
            if(myTTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE)
                myTTS.setLanguage(Locale.US);
        }
        else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
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
                a.append(", ");
                a.append(c.login);
            }

            TextView textView2 = (TextView) findViewById(R.id.text_view);
            //textView2.setText("The current local time is: " + currentTime);
            textView2.setText(a.toString());

            if (voiceInitStatus == TextToSpeech.SUCCESS) {
                myTTS.speak(a.toString(), TextToSpeech.QUEUE_FLUSH, null);
            }





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

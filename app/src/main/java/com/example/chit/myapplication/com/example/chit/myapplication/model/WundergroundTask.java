package com.example.chit.myapplication.com.example.chit.myapplication.model;

import android.os.AsyncTask;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chit.myapplication.GitHubClient;
import com.example.chit.myapplication.R;
import com.example.chit.myapplication.WundergroundClient;

import java.net.URL;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chit on 3/8/2015.
 */
public class WundergroundTask {

    public static class TodayForecast extends AsyncTask<String, Integer, String> {

        private TextToSpeech myTTS;

        public TodayForecast(TextToSpeech textToSpeech) {
            this.myTTS = textToSpeech;
        }

        protected String doInBackground(String... input) {
            WundergroundClient cl = new WundergroundClient();
            return cl.getTodayForecast();
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
            myTTS.speak(result, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public static class WeekForecast extends AsyncTask<String, Integer, String> {

        private TextToSpeech myTTS;

        public WeekForecast(TextToSpeech textToSpeech) {
            this.myTTS = textToSpeech;
        }

        protected String doInBackground(String... input) {
            WundergroundClient cl = new WundergroundClient();
            return cl.getFourDayForecast();
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
            myTTS.speak(result, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

}

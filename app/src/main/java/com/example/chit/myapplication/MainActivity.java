package com.example.chit.myapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.joda.time.LocalTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.content.Intent;
import android.widget.Toast;

import java.util.Locale;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chit.myapplication.com.example.chit.myapplication.model.QuestionPackage;
import com.example.chit.myapplication.com.example.chit.myapplication.model.WundergroundTask;

public class MainActivity extends ActionBarActivity implements View.OnClickListener, OnInitListener {

    private static final int READ_REQUEST_CODE = 42;

    private int MY_DATA_CHECK_CODE = 0;
    private TextToSpeech myTTS;

    private MainActivity mySelf;

    private int voiceInitStatus = 1;
    private boolean qaSession = false;
    private QuestionPackage questionPackage = null;

    private TextView txtSpeechInput;
    private Button btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    ClipboardManager.OnPrimaryClipChangedListener mPrimaryChangeListener = new ClipboardManager.OnPrimaryClipChangedListener() {
        public void onPrimaryClipChanged() {

            // this will be called whenever you copy something to the clipboard
            playClipBoard();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

        setContentView(R.layout.activity_main);

        Button speakButton = (Button)findViewById(R.id.btnSayWord);
        speakButton.setOnClickListener(this);

        Button speakButton2 = (Button)findViewById(R.id.btnRestClient);
        speakButton2.setOnClickListener(this);

        Button speakButton3 = (Button)findViewById(R.id.btnSayClipboard);
        speakButton3.setOnClickListener(this);



        //check for TTS data
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);

        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (Button)findViewById(R.id.btnSpeak);


        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

        mySelf = this;

        TextView tView = (TextView) findViewById(R.id.text_view);
        tView.setMovementMethod(new ScrollingMovementMethod());

        ClipboardManager clipboard = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.addPrimaryClipChangedListener(mPrimaryChangeListener);

        Button pickerBtn = (Button)findViewById(R.id.pickerBtn);
        pickerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                //intent.setType("image/*");
                intent.setType("*/*");
                //intent.setType("text/plain");
                startActivityForResult(intent, READ_REQUEST_CODE);
            }
        });


        Button pickerQABtn = (Button)findViewById(R.id.pickerQABtn);
        pickerQABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                qaSession = true;

                List<QuestionPackage> questions = new ArrayList<QuestionPackage>();

                QuestionPackage q1 = new QuestionPackage();
                q1.setQuestionText("What is your name");
                q1.setQuestionAnswer("a");
                HashMap<String,String> m1 = new HashMap<String, String>();
                m1.put("a","john doe");
                m1.put("b","jennifer gardner");
                m1.put("c","jennifer lawrence");
                q1.setQuestionChoices(m1);
                q1.setQuestionExplanation("john doe is your name.");

                questions.add(q1);

                q1 = new QuestionPackage();
                q1.setQuestionText("What is your last name");
                q1.setQuestionAnswer("a");
                m1 = new HashMap<String, String>();
                m1.put("a","doe");
                m1.put("b","gardner");
                m1.put("c","lawrence");
                q1.setQuestionChoices(m1);
                q1.setQuestionExplanation("");
                questions.add(q1);


                for(QuestionPackage item : questions ) {
                    questionPackage = item;
                    loopUntilAnswered(item);
                }


            }
        });


    }

    @Override
    public void onSupportActionModeStarted(ActionMode mode) {
        super.onSupportActionModeStarted(mode);
    }

    private void loopUntilAnswered(QuestionPackage item) {
        //int maxTimes = 3;
        //for(int i=0;i<maxTimes;i++)  {
            speakWordsQA(item.getQuestionText());
            speakWordsQA(" Please select on the following. ");
            for (Map.Entry<String, String> entry : item.getQuestionChoices().entrySet())
            {
                String key=entry.getKey();
                String value=entry.getValue();
                speakWordsQA(key+"."+" "+value);
            }
            int totalWait = item.getQuestionText().split(" ").length;
            sleep(10);
            //promptSpeechInput();
            String ret = promptSpeechInputQA();


        return;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                //myTTS.stop();
                //myTTS.playSilence(750, TextToSpeech.QUEUE_ADD, null);

            case KeyEvent.KEYCODE_VOLUME_DOWN:
                playClipBoard();
                return true;

            default:

                return super.dispatchKeyEvent(event);
        }
    }

    private void sleep(int delaySeconds) {
        try {
            Thread.sleep(delaySeconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    private String promptSpeechInputQA() {
        //ACTION_VOICE_SEARCH_HANDS_FREE
        //Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
        return "111";
    }

    /**
     * Showing google speech input dialog
     * */
    private void promptSpeechInput() {
        //ACTION_VOICE_SEARCH_HANDS_FREE
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //Intent intent = new Intent(RecognizerIntent.ACTION_VOICE_SEARCH_HANDS_FREE);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }


    private void playClipBoard() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        //clipboard.setText("Text to copy");
        //clipboard.getText();
        ClipData data = clipboard.getPrimaryClip();
        ClipData.Item item = data.getItemAt(0);
        String itemStr = item.getText().toString();

        TextView textView2 = (TextView) findViewById(R.id.text_view);
        //textView2.setText("The current local time is: " + currentTime);
        textView2.setText(itemStr);
        textView2.setMovementMethod(new ScrollingMovementMethod());

        myTTS.speak(itemStr, TextToSpeech.QUEUE_FLUSH, null);
    }
    //respond to button clicks
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.btnSayWord:
                //get the text entered
                EditText enteredText = (EditText)findViewById(R.id.counterText);
                String words = enteredText.getText().toString();
                speakWords(words);

                break;
            case R.id.btnRestClient:

                new RestCallTask().execute();

                break;
            case R.id.btnSayClipboard:
                playClipBoard();
                break;
        }


    }

    //speak the user text
    private void speakWordsQA(String speech) {

        //speak straight away
        myTTS.speak(speech, TextToSpeech.QUEUE_ADD, null);
    }
    //speak the user text
    private void speakWords(String speech) {

        //speak straight away
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    //act on result of TTS data check
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

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



        if (requestCode == REQ_CODE_SPEECH_INPUT) {

                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));

                    if(qaSession && !(questionPackage==null) ) {
                        String answer = result.get(0).toLowerCase();
                        if (answer.equalsIgnoreCase(questionPackage.getQuestionAnswer())) {
                            speakWordsQA("Correct.");
                        } else {
                            speakWordsQA("Wrong answer.");
                            //continue;
                        }
                    } else {
                        qaSession = false;

                        myTTS.speak(txtSpeechInput.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

                        String textInput = result.get(0).toString();
                        if (textInput.startsWith("what") && textInput.contains("time")) {
                            speakWords(Utils.getCurrentTime());
                        }

                        if (textInput.startsWith("what") && textInput.contains("weather") && textInput.contains("today")) {
                            new WundergroundTask.TodayForecast(myTTS).execute();
                        }

                        if (textInput.startsWith("what") && textInput.contains("weather") && textInput.contains("week")) {
                            new WundergroundTask.WeekForecast(myTTS).execute();
                        }
                    }
                }

            }

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (data != null) {
                uri = data.getData();
                TextView textView1 = (TextView) findViewById(R.id.text_view2);

                //String mimeType = getContentResolver().getType(uri);
                //textView1.setText(mimeType);

                try {
                    String content = readFileContent(uri);
                    textView1.setText(content);
                    speakWords(content);
                } catch (IOException e) {
                    textView1.setText("Error: "+e.getMessage());
                }



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

    private String readFileContent(Uri uri) throws IOException {

        InputStream inputStream =
                getContentResolver().openInputStream(uri);
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(
                        inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String currentline;
        while ((currentline = reader.readLine()) != null) {
            //stringBuilder.append(currentline + "\n");
            stringBuilder.append(currentline + "");
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    @Override
    public void onStart() {
        super.onStart();

        //TextView textView = (TextView) findViewById(R.id.text_view);
       // textView.setText("Hello world!");

        LocalTime currentTime = new LocalTime();
        TextView textView2 = (TextView) findViewById(R.id.text_view);
        textView2.setText("The current local time is: " + currentTime);

        //do this on button press
        //new RestCallTask().execute();


    }

    private class RestCallTask extends AsyncTask<URL, Integer, List<GitHubClient.Contributor>> {
        protected List<GitHubClient.Contributor> doInBackground(URL... urls) {


            try {
                GitHubClient cl = new GitHubClient();
                return cl.getList();
            } catch (Exception e) {
                Toast.makeText(mySelf, "Sorry!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }

            return Collections.EMPTY_LIST;
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

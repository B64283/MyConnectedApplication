package com.example.matthewdarke.myconnectedapplication;

/* ***************
  Matthew Darke  *
  Java 1 week 4  *
    term 1410    *
******************/






import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import javax.xml.transform.Result;


public class MainActivity extends Activity {
    public String TAG = "------ SPDebug";
    TextView output;
    //isOnline connection;
    Button searchBtn;
    //CheckConnection connection;
//public boolean isOnLine;
    public ProgressBar pb;
    List<MyTask> tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = (Button)findViewById(R.id.searchButton);
        //searchBtn.setOnClickListener(searchBtnClicked);


        //connection = new isOnLine(getApplicationContext());
        //Log.d(TAG,"onCreate");
        output = (TextView) findViewById(R.id.textView);
        output.setMovementMethod(new ScrollingMovementMethod());

        pb = (ProgressBar) findViewById(R.id.progressBar2);
        pb.setVisibility(View.INVISIBLE);

//need to update compiler Language to 7.1 to work
        tasks = new ArrayList<>();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            if (isOnLine()) {
                requestData("http://api.bigoven.com/recipe/47725?api_key=dvxdFclkhb2sXHylgPh3fFjhz0q1FE84");
            } else {
                Toast.makeText(this, "Network isnt available", Toast.LENGTH_LONG).show();
            }


            //return true;


        }
        return false;
    }


    private void requestData(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);
    }


    protected void updateDisplay(String message) {

        output.append(message + "\n");

    }

    ///Check if network is available standard code

    protected boolean isOnLine() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();

// this checks for two different states
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {


            return true;

        } else {

            return false;
        }
    }


    private class MyTask extends AsyncTask<String, String, String> {
        //has accsess to main thread
        @Override
        protected void onPreExecute() {
            updateDisplay("starting task");

            if (tasks.size() == 0) {
                pb.setVisibility(View.VISIBLE);

            }
            tasks.add(this);


        }


        @Override
        protected String doInBackground(String... params) {

          String content = HttpManager.getData(params[0]);

            return content;
        }

        //has accsess to main thread
        @Override
        protected void onPostExecute(String result) {
            updateDisplay(result);
            tasks.remove(this);
            if (tasks.size() == 0) {
                pb.setVisibility(View.INVISIBLE);

            }

        }


        @Override
        protected void onProgressUpdate(String... values) {
            updateDisplay(values[0]);
        }
    }






}

































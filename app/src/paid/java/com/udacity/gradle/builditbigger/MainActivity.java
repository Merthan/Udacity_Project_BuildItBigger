package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.biggerandroidlibrary.JokeActivity;
import com.example.biggerjavalibrary.JokesClass;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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

    public void tellAJoke(View view) {
        Toast.makeText(this,"telling joke",Toast.LENGTH_SHORT).show();

        new MyAsyncTask(new FinishedInterface() {
            @Override
            public void onFinished(String result) {
                Intent i=new Intent(MainActivity.this, JokeActivity.class);
                isNotEmpty[0]=!TextUtils.isEmpty(result);
               Log.d("ResultLog",result);
                if(isNotEmpty[0])i.putExtra(JokeActivity.EXTRA_JOKE,result);
                startActivity(i);
            }
        }).execute();



    }

    final static boolean[] isNotEmpty=new boolean[1];


}

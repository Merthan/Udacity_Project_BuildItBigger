package com.example.biggerandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String EXTRA_JOKE="extrajoke";
    TextView textView;
    String jokeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        textView=findViewById(R.id.textView);

        if(getIntent().hasExtra(EXTRA_JOKE)){
            jokeText=getIntent().getStringExtra(EXTRA_JOKE);
            textView.setText(jokeText);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_JOKE,textView.getText()+"");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(jokeText);
    }
}

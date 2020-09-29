package com.tanveerm.textswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private TextSwitcher mTextSwitcher;
    private Button mNextButton;
    private int stringIndex = 0;
    private String[] row = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN"};
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextSwitcher = findViewById(R.id.textSwitcher);
        mNextButton = findViewById(R.id.button);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stringIndex == row.length - 1) {
                    stringIndex = 0;
                    mTextSwitcher.setText(row[stringIndex]);
                } else {
                    mTextSwitcher.setText(row[++stringIndex]);
                }
            }
        });

        mTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                mTextView = new TextView(MainActivity.this);
                mTextView.setTextColor(Color.BLACK);
                mTextView.setTextSize(60);
                mTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                return mTextView;
            }
        });

        mTextSwitcher.setText(row[stringIndex]);
    }
}
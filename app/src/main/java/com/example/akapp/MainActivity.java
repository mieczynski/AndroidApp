package com.example.akapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {
    private Button reset;
    private Button start;
    public LinearLayout layout;
    public EditText size;
    public EditText countOfTest;
    public EditText typeOfStructure;
    public MainActivity act;
    public TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.act = this;
        this.start = (Button) findViewById(R.id.startButton);
        this.reset = (Button) findViewById(R.id.resetButton);
        this.layout = (LinearLayout) findViewById(R.id.linearLayout);
        this.size = (EditText) findViewById(R.id.editTextSize);
        this.countOfTest = (EditText) findViewById(R.id.editTextTests);
        this.typeOfStructure = (EditText) findViewById(R.id.editTextType);
        this.text= (TextView) findViewById(R.id.textView3);
        this.start.setOnClickListener(view -> {
            Integer valueOfType = Integer.valueOf(Integer.parseInt(MainActivity.this.typeOfStructure.getText().toString()));
            Integer valueOfSize = Integer.valueOf(Integer.parseInt(MainActivity.this.size.getText().toString()));
            Integer valueOfCount = Integer.valueOf(Integer.parseInt(MainActivity.this.countOfTest.getText().toString()));
            switch (valueOfType.intValue()) {
                case 1:
                    Tests.DoubleLinkedListTest(valueOfSize.intValue(), valueOfCount.intValue(), text);
                    return;
                case 2:
                    Tests.DynamicArrayTest(valueOfSize.intValue(), valueOfCount.intValue(), text);
                    return;
                case 3:
                    Tests.TreeTest(valueOfSize.intValue(), valueOfCount.intValue(), text);
                    return;
                default:
                    return;
            }
        });
        this.reset.setOnClickListener(view -> {
                    MainActivity.this.layout.removeAllViews();
                    size.setText("Size");
                    countOfTest.setText("Tests");
                    typeOfStructure.setText("Type of structure: 1. List 2. Array 3. Tree");
                    text.setText(" ");
        }
        );
    }
}
package com.evadummy.codingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.evadummy.codingtest.solutions.CompleteSearch2;
import com.evadummy.codingtest.solutions.CompleteSearch3;
import com.evadummy.codingtest.solutions.Solution;

public class MainActivity extends AppCompatActivity {

    private Solution mSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSolution = new CompleteSearch3();
    }
}
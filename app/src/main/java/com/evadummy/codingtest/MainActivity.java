package com.evadummy.codingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.evadummy.codingtest.solutions.Solution;
import com.evadummy.codingtest.solutions.SolutionCompleteSearch1;

public class MainActivity extends AppCompatActivity {

    private Solution mSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSolution = new SolutionCompleteSearch1();
    }
}
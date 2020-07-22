package com.evadummy.codingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.evadummy.codingtest.solutions.Solution;
import com.humaxdigital.automotive.codingtest.testcases.SolutionL3012;

public class MainActivity extends AppCompatActivity {

    private Solution mSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSolution = new SolutionL3012();
    }
}
package com.evadummy.codingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.humaxdigital.automotive.codingtest.testcases.SolutionL3012;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD:app/src/main/java/com/evadummy/codingtest/MainActivity.java


=======
        SolutionL3012 solutionL30002 = new SolutionL3012();
        solutionL30002.solution(3,5);
>>>>>>> testcase update:app/src/main/java/com/humaxdigital/automotive/codingtest/MainActivity.java
    }
}
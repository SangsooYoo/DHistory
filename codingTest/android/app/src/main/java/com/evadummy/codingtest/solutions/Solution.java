package com.evadummy.codingtest.solutions;

import android.os.Handler;

public abstract class Solution {
    public Solution() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runSolution();
            }
        }, 100);
    }

    public abstract int runSolution();
}

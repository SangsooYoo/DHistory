package com.evadummy.codingtest.solutions;

// https://programmers.co.kr/learn/courses/30/lessons/42839
//문제 설명
//        한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//        각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        numbers는 길이 1 이상 7 이하인 문자열입니다.
//        numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//        013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
//        입출력 예
//        numbers	return
//        17	3
//        011	2
//        입출력 예 설명
//        예제 #1
//        [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
//
//        예제 #2
//        [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
//
//        11과 011은 같은 숫자로 취급합니다.

import java.util.ArrayList;
import java.util.Arrays;

public class CompleteSearch2 extends Solution {
    @Override
    public int runSolution() {
        int[][] baseball = new int[4][3];
        baseball[0] = new int[]{546,1,0};
        baseball[1] = new int[]{671,1,0};
        baseball[2] = new int[]{578,2,0};
        baseball[3] = new int[]{579,2,0};
        solution(baseball);
        return 0;
    }

    public int solution(int[][] baseball) {
        int answer = 0;
        ArrayList<int[]> fullcases = new ArrayList<>();
        for(int id100 = 1; id100 < 10; id100++){
            for(int id10 = 1; id10 < 10; id10++){
                for(int id = 1; id < 10; id++){
                    if (id100!=id10 && id100!=id && id10!=id)
                        fullcases.add(new int[]{id100, id10, id});
                }
            }
        }

        for (int i = 0; i < baseball.length; i++){
            System.out.println("fullcases="+fullcases.size());
            int target1 = Math.floorMod(baseball[i][0], 10);
            int target100 = Math.floorDiv(baseball[i][0], 100);
            int target10 = Math.floorDiv( (baseball[i][0]-target100*100) , 10);
            int strike = baseball[i][1];
            int ball = baseball[i][2];
            int strikeCounter;
            int ballCounter;

            for (int caseidx = fullcases.size()-1; caseidx >= 0; caseidx--) {
                strikeCounter = 0;
                ballCounter = 0;
                int[] thiscase = fullcases.get(caseidx);
                //check strikes
                if (target1==thiscase[2])
                    strikeCounter++;
                if (target10==thiscase[1])
                    strikeCounter++;
                if (target100==thiscase[0])
                    strikeCounter++;
                //check balls
                if (target1==thiscase[1] || target1==thiscase[0])
                    ballCounter++;
                if (target10==thiscase[2] || target10==thiscase[0])
                    ballCounter++;
                if (target100==thiscase[2] || target100==thiscase[1])
                    ballCounter++;

                if (strike!=strikeCounter || ball!=ballCounter)
                    fullcases.remove(caseidx);
            }
        }

        for(int i=0; i <fullcases.size(); i++){
            if (i==fullcases.size()/2)System.out.println("this");
            System.out.println(Arrays.toString(fullcases.get(i)));
        }
        return fullcases.size();
    }
}

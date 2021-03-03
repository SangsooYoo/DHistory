package com.evadummy.codingtest.solutions;

import java.util.ArrayList;
import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/42839
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
public class CompleteSearch3 extends Solution {
    @Override
    public int runSolution() {
        solution("011");
        return 0;
    }

//    public int solution(String numbers) {
//        int answer = 0;
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i = 1; i <= numbers.length(); i++) {
//            ArrayList<String> value = getNumberList(numbers, i);
//            for(String sub: value){
//                System.out.println(sub);
//                hashSet.add(Integer.parseInt(sub));
//            }
//        }
//
//        for (int primeCandidate: hashSet) {
//            if (primeCandidate==0 || primeCandidate==1)
//                continue;
//
//            if (isPrime(primeCandidate)){
//                answer++;
//            }
//        }
//        System.out.println(answer);
//        return answer;
//    }
//
//    private ArrayList<String> getNumberList(String target, int length) {
//        ArrayList<String> retval = new ArrayList<>();
//        if (target.length()==1) {
//            retval.add(target);
//            return retval;
//        }
//
//        if (length==1) {
//            for (int i = 0; i < target.length(); i++) {
//                retval.add(target.charAt(i)+"");
//            }
//            return retval;
//        }
//
//        for (int i = 0; i < target.length(); i++) {
//            StringBuilder sb = new StringBuilder(target);
//            sb.deleteCharAt(i);
//            ArrayList<String> value = getNumberList(sb.toString(), length-1);
//            StringBuilder sb1 = new StringBuilder(target.charAt(i));
//            for(String sub: value){
//                retval.add( target.charAt(i)+sub);
//            }
//        }
//        return retval;
//    }
//
//    private boolean isPrime(int primeCandidate){
//        int i = 2;
//
//        while (i<primeCandidate) {
//            System.out.println(primeCandidate);
//            System.out.println("Mod="+Math.floorMod(primeCandidate, i));
//            if (Math.floorMod(primeCandidate, i++)==0) {
//                return false;
//            }
//        }
//        return true;
//    }
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) {
            System.out.println(prefix + " "+str);
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }
}

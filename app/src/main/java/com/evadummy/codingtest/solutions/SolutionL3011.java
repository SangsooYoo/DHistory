package com.evadummy.codingtest.solutions;


//위 그림에서 1번 마을에 있는 음식점은 [1, 2, 4, 5] 번 마을까지는 3 이하의 시간에 배달할 수 있습니다. 그러나 3번 마을까지는 3시간 이내로 배달할 수 있는 경로가 없으므로 3번 마을에서는 주문을 받지 않습니다. 따라서 1번 마을에 있는 음식점이 배달 주문을 받을 수 있는 마을은 4개가 됩니다.
//마을의 개수 N, 각 마을을 연결하는 도로의 정보 road, 음식 배달이 가능한 시간 K가 매개변수로 주어질 때, 음식 주문을 받을 수 있는 마을의 개수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//마을의 개수 N은 1 이상 50 이하의 자연수입니다.
//road의 길이(도로 정보의 개수)는 1 이상 2,000 이하입니다.
//road의 각 원소는 마을을 연결하고 있는 각 도로의 정보를 나타냅니다.
//road는 길이가 3인 배열이며, 순서대로 (a, b, c)를 나타냅니다.
//a, b(1 ≤ a, b ≤ N, a != b)는 도로가 연결하는 두 마을의 번호이며, c(1 ≤ c ≤ 10,000, c는 자연수)는 도로를 지나는데 걸리는 시간입니다.
//두 마을 a, b를 연결하는 도로는 여러 개가 있을 수 있습니다.
//한 도로의 정보가 여러 번 중복해서 주어지지 않습니다.
//K는 음식 배달이 가능한 시간을 나타내며, 1 이상 500,000 이하입니다.
//임의의 두 마을간에 항상 이동 가능한 경로가 존재합니다.
//1번 마을에 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수를 return 하면 됩니다.
//입출력 예
//N	road	K	result
//5	[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]	3	4
//6	[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]	4	4
//입출력 예 설명
//입출력 예 #1
//문제의 예시와 같습니다.
//
//입출력 예 #2
//주어진 마을과 도로의 모양은 아래 그림과 같습니다.
//image
//1번 마을에서 배달에 4시간 이하가 걸리는 마을은 [1, 2, 3, 5] 4개이므로 4를 return 합니다.
import com.evadummy.codingtest.solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class SolutionL3011 extends Solution {

    @Override
    public int runSolution() {
        return 0;
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for(int i = 0; i < road.length; i++) {
            System.out.println(Arrays.toString(road[i]));
        }

        int from;
        int to;
        int distance;
        HashMap<Integer, Integer> tree;

        for(int i = 0; i < road.length; i++) {
            from = road[i][0];
            to = road[i][1];
            distance = road[i][2];

            tree = map.get(from);
            if (tree==null){
                HashMap<Integer, Integer> newtree =  new HashMap<>();
                map.put(from, newtree);
                tree = newtree;
            }
            tree.put(to,distance);
        }

        ArrayList<Integer> nodeInPath = new ArrayList<>();
        nodeInPath.add(1);
        findNodesInDistance(map, 1, K, nodeInPath);

        return answer;
    }

    private void findNodesInDistance(HashMap<Integer, HashMap<Integer, Integer>> map, int thisDown, int remainDistance, ArrayList<Integer> nodeInPath){
        HashMap<Integer, Integer> distanceTree = map.get(thisDown);
        int distance;

        if (distanceTree.keySet().size()==nodeInPath.size()){
            // no more towns.
            return;
        }

        for (Integer townNum : distanceTree.keySet()){
            if (!nodeInPath.contains(townNum)) {
                distance = distanceTree.get(townNum);
                if (distance < remainDistance) {
                    nodeInPath.add(townNum);
                    findNodesInDistance(map, townNum, remainDistance-distance, nodeInPath);
                }
                else if (distance==remainDistance) {
                    nodeInPath.add(townNum);
                }
            }
        }
    }
}

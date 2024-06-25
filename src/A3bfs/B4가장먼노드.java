package A3bfs;

import java.util.*;

public class B4가장먼노드 {
    static List<List<Integer>> adjList;
    static int[] distance;
    public static void main(String[] args) {
        int[][]edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int n = 6;
        adjList = new ArrayList<>();
        distance = new int[n+1];
        Arrays.fill(distance, -1);
        for(int i=0; i<n+1; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] a : edge){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        int answer = bfs(1, n);
        System.out.println(answer);

    }
    static int bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 1;
        int count = 0;
        int maxDistance = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if(distance[temp] == maxDistance){
                count++;
            } else if (distance[temp] > maxDistance) {
                maxDistance = distance[temp];
                count = 1;
            }
            for (int target : adjList.get(temp)) {
//                target을 queue에 add하기 전에 true로 세팅
                if (distance[target] == -1) {
                    queue.add(target);
                    distance[target] = distance[temp] + 1;
                }
            }
        }
        return count;
    }
}
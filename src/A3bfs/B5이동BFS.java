package A3bfs;

import java.util.LinkedList;
import java.util.Queue;

public class B5이동BFS {
    public static void main(String[] args) {
        int start = 5;
        int target = 17;
        // -1, +1, 현재숫자+2 로 갈 수 있음.
        // 현재 dfs는 무한대로 감
        // bfs로 풀어야함
        // 가장 빠른 횟수
        // -1 *2 *2 +1 => 4회
        System.out.println(dfs(start, target));

    }

    static int dfs(int start, int target){
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {start, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            queue.add(new int[] {cur[0]-1, cur[1]+1});
            queue.add(new int[] {cur[0]+1, cur[1]+1});
            queue.add(new int[] {cur[0]*2, cur[1]+1});

            if(cur[0]-1 == target || cur[0]+1 == target || cur[0]*2 == target){
                return cur[1]+1;
            }
        }
        return -1;
    }
}

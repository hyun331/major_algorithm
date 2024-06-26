package A3bfs;

import java.util.Deque;
import java.util.LinkedList;

public class BStudy01게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1}, {1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    static boolean[][] visited;
    static int[] dRow = {1, -1, 0, 0};  // 동서남북으로 이동할 때 전진할 칸
    static int[] dCol = {0, 0, 1, -1};
    public static int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];

        answer = bfs(maps);
        return answer;
    }

    static int bfs(int[][] maps){
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});  //시작 위치 (0, 0), 0:몇칸 갔는지
        visited[0][0] = true;

        int n = maps.length;
        int m = maps[0].length;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];
            int length = now[2];

            // 상대 진영에 도착하면 도착하면
            if(row == n-1 && col == m-1){
                return length;
            }

            for(int i=0; i<4; i++){ //동서남북 한칸 이동
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                // 이동할 칸이 유효한 칸이면 queue에 넣고 방문표시
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !visited[nRow][nCol] && maps[nRow][nCol]==1){
                    queue.add(new int[]{nRow, nCol, length+1});
                    visited[nRow][nCol] = true; //queue에 넣고 visited true해줘야함. 그렇지 않으면 중복 칸이 들어갈 수 있음.
                }
            }
        }
        return -1;
    }
}

package A3bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BStudy게임맵최단거리 {

    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1}, {1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
    public static int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];

        answer = bfs(maps);
        return answer;
    }

    static int bfs(int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});  //시작 위치 (1,1), 0:몇칸 갔는지

        int n = maps.length;
        int m = maps[0].length;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int length = now[2];

            visited[x][y] = true;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
            }

//            System.out.println(x + ", "+y);
            if(x == m-1 && y == n-1){
                return length;
            }

            if(x+1<m && maps[x+1][y] == 1 && !visited[x+1][y]) {//동
                queue.add(new int[]{x+1, y, length+1});
            }
            if(x-1>=0 && maps[x-1][y]==1 && !visited[x-1][y]){//서
                queue.add(new int[]{x-1, y, length+1});
            }
            if(y+1 < n && maps[x][y+1]==1 && !visited[x][y+1]){
                queue.add(new int[]{x, y+1, length+1});
            }
            if(y-1 >= 0 && maps[x][y-1]==1 && !visited[x][y-1]){
                queue.add(new int[]{x, y-1, length+1});
            }

        }

        return -1;

    }


}

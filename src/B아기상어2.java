import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B아기상어2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];    // 입력받은 상어의 위치

        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }


        int[][] safeLength = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 1){ //현재 위치가 상어가 아닌 경우
                    // 각 위치마다 bfs를 해야하기 때문에 queue와 visited를 초기화 해야함
                    boolean[][] visited = new boolean[arr.length][arr[0].length];
                    Deque<int[]> queue = new LinkedList();
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;

                    safeLength[i][j] = bfs(arr, visited, queue);    // 상어를 만나면 bfs를 멈추고 안전거리 입력
                }
            }
        }

        //최댓값 구하기
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(max < safeLength[i][j]){
                    max = safeLength[i][j];
                }
            }
        }

        System.out.println(max);
    }

    public static int bfs(int[][] arr, boolean[][] visited, Deque<int[]>queue){
        int[] di = {-1, -1, -1, 0, 0, 1, 1, 1}; //가야할 방향 배열
        int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int i = now[0];
            int j = now[1];
            int sLength = now[2];   //안전거리
            for(int m=0; m<8; m++){
                int ni = i + di[m];
                int nj = j + dj[m];
                if(ni >=0 && ni <arr.length && nj >=0 && nj < arr[0].length){
                    if(!visited[ni][nj]){   //갈 곳이 방문하지 않았고
                        if(arr[ni][nj] == 1){   // 갈 곳에 상어가 있다면
                            return sLength+1;
                        }
                        queue.add(new int[]{ni, nj, sLength+1});
                        visited[ni][nj] = true;
                    }
                }

            }
        }
        return 0;
    }
}

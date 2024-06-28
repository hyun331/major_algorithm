import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B아기상어2_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];    // 입력받은 위치

        List<int[]> sharkList = new ArrayList<>();
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(num == 1){
                    sharkList.add(new int[]{i, j});
                }
            }
        }

        List<Integer> safeList = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                int min = Integer.MAX_VALUE;
                if(arr[i][j] != 1){
                    for(int[] shark : sharkList){
                        int num = Math.max(Math.abs(i-shark[0]), Math.abs(j-shark[1]));
                        if(min > num)
                            min = num;
                    }
                    safeList.add(min);
                }
            }
        }

        Collections.sort(safeList);
        System.out.println(safeList.get(safeList.size()-1));





    }


}

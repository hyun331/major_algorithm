package A3bfs;

import java.util.*;
public class BStudy아이템줍기 {
    public static void main(String[] args) {

        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};

        System.out.println(solution(rectangle, 1, 3, 7, 8));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Set<int[]> visited = new HashSet<>();

//        visited.add(new int[]{characterX, characterY});


        // 모든 좌표 0으로 초기화
        int[][] map = new int[50][50];



        while(characterX != itemX || characterY != itemY){
            for(int i=0; i<4; i++){
                int nx = dx[i];
                int ny = dy[i];


            }

        }
        return answer;
    }
}

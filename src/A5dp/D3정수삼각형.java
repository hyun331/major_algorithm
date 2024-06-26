package A5dp;

import java.util.Arrays;

public class D3정수삼각형 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;

        for(int i=n-1; i>0; i--) {
            //triangle 배열의 마지막 행에서 4와 5 중 큰 값이 2와 합쳐짐. 나머지들도 마찬가지.
            int[] maxArr = new int[triangle[i].length - 1];   // 둘 중에 더 큰 값을 넣는 배열. 마지막 행 예시 -> {5, 5, 6, 6}
            for (int j = 0; j < maxArr.length; j++) {
                maxArr[j] = Math.max(triangle[i][j], triangle[i][j + 1]);
                triangle[i - 1][j] += maxArr[j];  //윗 행과 합치기
            }
        }
        answer = triangle[0][0];
        return answer;
    }
}

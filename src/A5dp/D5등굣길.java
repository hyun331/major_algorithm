package A5dp;

public class D5등굣길 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2,2}}));
    }

    // m : 열
    // n : 행

    public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];

        int answer = 0;
        System.out.println("---------");
        for(int i=1; i<map.length; i++){
            for(int j=1;j<map[0].length; j++) {
                map[i][j] = 1;
            }
        }

        for (int[] puddle : puddles) {
            int waterM = puddle[0];
            int waterN = puddle[1];
            map[waterM][waterN] = 0;
        }




        for(int i=1; i< map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if(i==1 && j==1)
                    continue;
                if(map[i][j] != 0){
                    map[i][j] = map[i-1][j] + map[i][j-1];
                    map[i][j] %= 1000000007;
                }


            }

        }


//        System.out.println("----------------");
//        for(int i=0; i< map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        answer = map[m][n]%1000000007;
        return answer;
    }
}

package A5dp;

public class D5등굣길 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2,2},{3,3}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0;j<m; j++) {
                map[i][j] = 1;
            }
        }

        for(int i=0; i< puddles.length; i++){
            int waterM = puddles[i][0]-1;
            int waterN = puddles[i][1]-1;
            map[waterM][waterN] = 0;
        }




        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {

                System.out.print(map[i][j]);
            }
            System.out.println();
        }
//        for(int i=0; i<n; i++){
//            for(int j=0;j<m; j++){
//                if(map[i][j]!=0){
//                    if(j-1>=0 && i-1>=0 && map[i][j-1] != 0 && map[i-1][j]!=0){
//                        map[i][j] = map[i][j-1] + map[i-1][j];
//                    }
//                    else if((j-1<0 && i-1>=0) || (map[i-1][j]==0)){
//                        map[i][j] = map[i-1][j];
//                    }
//                    else if((j-1>=0 && i-1<0)|| (map[i][j-1]==0)){
//                        map[i][j] = map[i][j-1];
//                    }
//                }
//
//            }
//
//        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] != 0){

                    if(j-1<0 || i-1<0){
                        if(j-1<0 && i-1>=0){
                            map[i][j]
                        }
                    }
                    // 둘 다 유효한 경우
                    if(j-1>=0 && i-1>=0 && map[i-1][j]!=0 && map[i][j-1]!=0){
                        map[i][j] = map[i-1][j] + map[i][j-1];
                    }
                    else if((j-1<0 && i-1>=0) || ())
                }

                // 왼쪽만 유효한 경우
                // 위쪽만 유효한 경우

            }
        }

        System.out.println("----------------");
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }


        //System.out.println(map[n-1][m-1]);



        return map[n-1][m-1];
    }
}

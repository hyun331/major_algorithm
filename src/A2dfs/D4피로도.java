package A2dfs;

public class D4피로도 {
    static boolean[] visited;
    static int max = 0;
    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        visited = new boolean[dungeons.length];
        int k = 80;
        dfs(dungeons, k, 0);
    }

    static void dfs(int[][] dungeons, int k, int count){
        if(count>max){
            max = count;
        }
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k>= dungeons[i][0]){
                dfs(dungeons,  k-dungeons[i][1], count+1);
            }
        }
    }
}

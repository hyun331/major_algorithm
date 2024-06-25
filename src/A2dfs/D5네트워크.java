package A2dfs;

import java.util.ArrayList;

public class D5네트워크 {
    static ArrayList<Integer>[] list;
    static boolean visited[];
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};

        visited = new boolean[n];
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && computers[i][j] == 1)
                    list[i].add(j);
            }
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }

        System.out.println(count);




    }

    static void dfs(int v){
        if(visited[v])
            return;
        visited[v] = true;
        for(int i : list[v]){
            if(!visited[i])
                dfs(i);
        }



    }
}

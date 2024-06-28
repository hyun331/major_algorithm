import java.io.*;
import java.util.*;

public class 애너그램6443 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }


        for (int i = 0; i < N; i++) {
            char[] inputArr = input[i].toCharArray();
            Arrays.sort(inputArr);
            sb = new StringBuilder();
            boolean[] visited = new boolean[inputArr.length];
            Set<String> set = new TreeSet<>();
            getPermutations(inputArr, "", visited, set);
            for(String s : set){
                System.out.println(s);
            }

        }
    }

    static void getPermutations(char[] inputArr, String sb, boolean[] visited, Set<String> set) {
        if (sb.length() == inputArr.length) {


            set.add(sb);

            return;
        }

        for (int i = 0; i < inputArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getPermutations(inputArr, sb+inputArr[i], visited, set);
                visited[i] = false;
            }
        }
    }
}

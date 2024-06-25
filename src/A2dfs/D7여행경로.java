package A2dfs;

import java.util.*;

public class D7여행경로 {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        String[] answer = solution(tickets);
        System.out.println(Arrays.toString(answer));
    }


    static boolean[] visited;
    static List<String> answer;
    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();


        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0]))
                    return o1[1].compareTo(o2[1]);
                return 0;
            }
        });

        List<String> path = new ArrayList<>();
        ArrayList<String[]> paths = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", tickets, path, paths);


        Collections.sort(paths, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                String str1 = String.join("", o1);
                String str2 = String.join("", o2);
                return str1.compareTo(str2);
            }
        });

        if(!paths.isEmpty()){
            answer = Arrays.asList(paths.get(0));
        }

        return answer.toArray(new String[0]);
    }

    static void dfs(String start, String[][] tickets, List<String> path, ArrayList<String[]> paths) {
        if (path.size() == tickets.length + 1) {
            paths.add(path.toArray(new String[0]));
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && start.equals(tickets[i][0])){ //방문하지 않았고, 출발지가 티켓의 출발지와 일치하면
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, path, paths);

                path.remove(path.size()-1);
                visited[i] = false;

            }
        }

    }
}

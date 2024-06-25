package A2dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D7여행경로_팀원 {
    static List<String[]> paths;
    static LinkedList<String> path;
    static boolean[] used;

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[][] tickets2 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] answer = solution(tickets2);
        System.out.println(Arrays.toString(answer));
    }

    static int pathCmp(String[] a, String[] b) {
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return a[i].compareTo(b[i]);
            }
        }
        return 0;
    }

    static String[] minPath() {
        String[] answer = paths.get(0); //처음엔 0번째와 1번째 비교
        for (int i = 1; i < paths.size(); i++) {
            if (pathCmp(answer, paths.get(i)) > 0) {
                answer = paths.get(i);
            }
        }
        return answer;
    }

    static void dfs(String[][] tickets) {
        if (path.size() == tickets.length + 1) {    //티켓이 5개면 6개의 공항
            paths.add(path.toArray(new String[0])); //형변환
        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (!used[i] && path.getLast().equals(tickets[i][0])) { //가장 마지막에 있는 공항과 출발지가 같으면
                    path.add(tickets[i][1]);    //그 티켓의 도착지를 경로에 추가
                    used[i] = true;
                    dfs(tickets);
                    used[i] = false;        //전체 탐색하기 위해 path에 넣었던 내용을 다 없애기
                    path.removeLast();
                }
            }
        }
    }

    /*모든 가능한 경로 탐색 주어진 항공권으로 만들 수 있는 모든 경로를 탐색해야 합니다.
    백트래킹을 사용하면, 경로를 하나씩 만들어 가면서 조건에 맞지 않는 경로는 탐색을 중단하고, 다른 경로를 탐색할 수 있습니다.
*/
    public static String[] solution(String[][] tickets) {

        paths = new ArrayList<>();  // 최종 경로..
        path = new LinkedList<>();  // tmp같은 역할
        used = new boolean[tickets.length];

        path.add("ICN");
        dfs(tickets);
        return minPath();
    }
}

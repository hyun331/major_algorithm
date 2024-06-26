package A4greedy;

import java.util.*;

public class G2체육복 {

    public static void main(String[] args) {
        int[] lost = {1, 2};
        int[] reserve = {2, 3};

//        System.out.println(solution(5, lost, reserve));
//        System.out.println(solution(5, new int[]{2,4}, new int[]{1,3,5}));
        System.out.println(solution(5, new int[]{3,4}, new int[]{4,3}));

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;

        Set<Integer> lostSet = new HashSet<>();
        Arrays.sort(reserve);

        for(int l : lost){
            lostSet.add(l);
        }

        for(int i=0; i<reserve.length; i++){
            if(lostSet.contains(reserve[i])){
                lostSet.remove(reserve[i]);
                reserve[i] = -1;    //reserve에 썼다고 표시하기
                answer ++;
            }
        }

        for(int i=0; i<reserve.length; i++){
            if(reserve[i] == -1)
                continue;
            if(lostSet.contains(reserve[i]-1)){
                lostSet.remove(reserve[i]-1);
                reserve[i] = -1;
                answer ++;
            }else if(lostSet.contains(reserve[i]+1)){
                lostSet.remove(reserve[i]+1);
                reserve[i] = -1;

                answer ++;
            }

        }

        return answer;
    }
}


package A1Sort;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public static void main(String[] args) {
        int[] queue1= {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int sum = 0;
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum+=queue1[i]+queue2[i];
        }
        int half = sum/2;
        while(true){
            break;
        }

        System.out.println(answer);
    }
}

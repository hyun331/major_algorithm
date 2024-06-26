package A4greedy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class G3구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 80, 50, 10};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        Deque<Integer> queue = new LinkedList<>();

        // 내림차순으로 들어감
        for(int i=0; i<people.length; i++){
            queue.add(people[people.length-i-1]);
        }

        while(!queue.isEmpty()){
            int sum = queue.poll();
            if(sum<=limit){
                if(!queue.isEmpty()){
                    if(queue.peekLast() + sum <= limit){
                        sum += queue.pollLast();
                    }
                }
            }

            answer++;

        }

        return answer;
    }
}

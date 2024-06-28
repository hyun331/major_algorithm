package A7이분탐색;

import java.util.*;

public class B3입국심사 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7,10}));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long s = times[0];
        long e = (long)times[times.length-1]*n;
        long answer = 0;
        while(s<=e) {
            long mid = (s+e)/2;
            long temp = 0;
            for(int i=0;i<times.length;i++) {
                temp += (long)mid/times[i];
            }
            if(temp >= n) {
                answer=mid;
                e = mid-1;
            }else if(temp < n) {
                s = mid+1;
            }
        }
        return answer;
    }
}

package A6투포인터;

import java.awt.desktop.UserSessionEvent;
import java.util.*;

public class T2연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(sequence, 7)));

    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = {};
        List<int[]> list = new LinkedList<>();


        int start = 0;
        int end = 0;
        int sum = sequence[0];

        while(start<=end && end < sequence.length){
            if(sum == k){
                list.add(new int[]{start, end});
                sum -= sequence[start];
                start ++;
            }
            else if(sum < k && end < sequence.length-1){
                end++;
                sum+= sequence[end];
            }
            else{
                sum -= sequence[start];
                start ++;
            }
        }

        Collections.sort(list, (a,b)->{
            int aLength = a[1]-a[0];
            int bLength = b[1] - b[0];
            if(aLength == bLength){
                return a[0] - b[0];
            }
            return aLength - bLength;
        });
//        for(int[] a : list){
//            System.out.println(Arrays.toString(a));
//        }

        return list.get(0);
    }
}

package A6투포인터;

import java.util.Iterator;

public class T4슬라이딩윈도우 {
    public static void main(String[] args) {
        // 정수배열 nums와 정수 k가 주어졌을 때
        // 길이가 k 인 연속된 부분 배열의 최대합 구하기

        int[] nums = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        int maxSum = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;
        int sum = nums[0];
        while(end < nums.length-1){
            if(end - start < k-1){
                end++;
                sum += nums[end];
            }
            else{
                if(maxSum < sum)
                    maxSum = sum;
                end++;
                sum += nums[end];
                sum -= nums[start];
                start++;
            }
            //System.out.println("sum = "+sum);
        }

        System.out.println(maxSum);

    }
}

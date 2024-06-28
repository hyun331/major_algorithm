package A7이분탐색;

import java.util.Arrays;

public class B1Basic {
    // Binary Search
    public static void main(String[] args) {
        // 이분탐색은 사전에 정렬되어 있어야 한다.(일반적으로 오름차순)
        int[] arr = {1, 3, 5, 7, 9, 11 ,13, 15, 17, 19};
        int target = 7;


        int start = 0;
        int end = arr.length-1;

        int count = 0;
        while(start<=end){
            count++;
            int mid = (start+end)/2;
            if(arr[mid] == target){
                System.out.println("index = " + mid);
                break;
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }

            if(start == end && arr[start] != target){
                System.out.println("탐색 불가");
                return;
            }

        }

        System.out.println(count+"횟수만에 탐색");

        // 솔직히 이렇게 하면 되긴함
        System.out.println(Arrays.binarySearch(arr, target));

    }
}

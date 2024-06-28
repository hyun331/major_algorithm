package A6투포인터;

import java.util.*;

public class T1Basic {
    public static void main(String[] args) {
        // 투포인터 : start와 end를 0에서 시작(->구간합) or start 0, end는 마지막

        // 아래 배열에서 target이 될 수 있는 두 수의 조합릐 값을 모두 찾아라
        int[] nums2 = {5, 9, 7, 12, 3};
        int target = 10;

        // 이중 for문은 n^2
//        List<int[]> list =new ArrayList<>();
//        for(int i=0; i<nums.length; i++){
//            for(int j=i+1; j< nums.length; j++){
//                if(nums[i]+nums[j] == target){
//                    list.add(new int[]{nums[i], nums[j]});
//                }
//            }
//        }
//
//        for(int[] intArr : list){
//            System.out.println(Arrays.toString(intArr));
//        }


        // 투포인터 사용 -> nlogn
        // Arrays.sort를 통해 정렬 -> nlogn
//        Arrays.sort(nums2);
//        int start = 0;
//        int end = nums2.length-1;
//
//        List<int[]> list = new ArrayList<>();
//        while(start != end){
//            int sum = nums2[start] + nums2[end];
//            if(sum == target){
//                list.add(new int[]{nums2[start], nums2[end]});
//                start++;
//            }
//            else if(sum > target){
//                end--;
//            }
//            else{
//                start++;
//            }
//        }
//
//        for(int[] a : list){
//            System.out.println(Arrays.toString(a));
//        }


        // 구간합
        // 구간의 합이 10인 배열의 index의 처음과 끝을 리스트에 담기
//        int[] nums = {7, 8, 9, 2, 4, 5, 1, 3, 6};
//        int start = 0;
//        int end = 0;
//
//        int sum = nums[0];
//
//        List<int[]> list = new ArrayList<>();
//        while(start != nums.length-1){
//            if(end != nums.length-1){
//                if(sum < target){
//                    end++;
//                    sum += nums[end];
//                }
//                else if(sum > target){
//                    sum -= nums[start];
//                    start++;
//                }
//                else{
//                    list.add(new int[]{start, end});
//                    end++;
//                    sum += nums[end];
//                }
//            }
//            else{
//                if(target == sum){
//                    list.add(new int[]{start, end});
//                }
//                sum -= nums[start];
//                start++;
//            }
//        }
//        for(int[] a : list){
//            System.out.println(Arrays.toString(a));
//        }


        ////////////////////////////////
        // 강사님 코드

        int[] nums = {7, 8, 9, 2, 4, 5, 1, 3, 6};
        int start = 0;
        int end = 0;

        int sum = nums[0];
        while(start<=end && end<nums.length){
            if(sum  == target ){
                System.out.println(start+", "+end);
                sum -= nums[start];
                start ++;
            }
            else if(sum  < target && end<nums.length-1){
                end++;
                sum += nums[end];
            }
            else{
                sum -= nums[start];
                start++;
            }
        }



    }
}

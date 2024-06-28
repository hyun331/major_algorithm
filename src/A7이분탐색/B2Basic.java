package A7이분탐색;

import java.util.Arrays;

public class B2Basic {
    public static void main(String[] args) {
        // target을 찾되
        // target이 없으면 target 보다 큰 값 중 첫번째 값의 인덱스을 찾아라.
        int[] arr = {1, 3, 4, 5, 7, 8, 10};
        int target = 10;

        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;


            if(start == end && arr[mid]!=target){
                System.out.println("target 존재하지 않습니다.");
                System.out.println(target+"보다 큰 값 : "+arr[start]+"은 "+mid+"번 인덱스에 존재합니다.");
                break;
            }
            if(arr[mid] == target){
                System.out.println(mid+"번 인덱스에 존재");
                break;
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }

        }


        // binary search를 이용한 가까운 값 찾기
        int[] arr2 = {10, 20, 30};
        System.out.println(Arrays.binarySearch(arr2, 9));   //-1 : -1 | 10 | -2 | 20 | -3 | 30 | -4 이렇게 됨
        System.out.println(Arrays.binarySearch(arr2, 8));   //-1
        System.out.println(Arrays.binarySearch(arr2, 35));   //-4


        int index2 = Arrays.binarySearch(arr2, 17);
        if(index2 < 0){
            System.out.println(Math.abs(index2)-1); //절대값으로 바꾼 뒤 -1 하면 가까운 값의 인덱스가 나옴
        }else{
            System.out.println(index2);
        }



    }
}

package A1Sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class S1HeapSort구현 {
    static int[] arr = {7,6,5,8,3,5,9,1,6};
    static int sortedIndex = arr.length;
    public static void main(String[] args) {
        for(int i=arr.length/2-1; i>=0; i--){ //자식 노드가 있는 노드들만. 현재 i는 부모노드
            heapify(i); // 이게 끝나면 최초힙
        }

        for(int i=0; i<arr.length; i++){
            change(arr.length-i-1);
        }
//        System.out.println(Arrays.toString(arr));


        int[] arr2 = {7,6,5,8,3,5,9,1,6};
        Queue<Integer> pq = new PriorityQueue<>();
        for(int a : arr2)
            pq.add(a);
        System.out.println(pq);
    }

    static void change(int i){  //정렬될 인덱스
        int tmp = arr[0];
        arr[0] = arr[i];
        arr[i] = tmp;
        sortedIndex --; //정렬될 인덱스
        heapify(0);

    }

    static void heapify(int i){
        int left = i*2+1;
        int right = i*2+2;

        if(left > arr.length-1){    //자식 노드 없음!
            return;
        }

        int minIndex = i;
        if(right<sortedIndex)   //정렬된 곳의 인덱스가 left, right보다 큰 경우, left, right의 값을 비교하기
            minIndex = arr[left]<=arr[right] ? left : right;
        else if(right == sortedIndex)   //정렬될 곳의 인덱스가 오른쪽과 같으면 왼쪽이랑만 비교하기
            minIndex = arr[i]<arr[left] ? i : left;

        // 만약 정렬될 곳의 인덱스가 left보다 작거나 같으면 아무 작업 없음. minIndex = i로 초기화

        if(arr[i]>arr[minIndex]){
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
            heapify(minIndex);  //바꾼 곳의 인덱스 넣어줘서 heap으로 만들기
        }
    }
}

package A1Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class S1HeapSort구현_강사님 {
    public static void main(String[] args) {
        int[] arr ={7,6,5,8,3,5,9,1,6};
//        최초힙구성
        for(int i=arr.length/2-1; i>=0; i--){
            heapify(arr, arr.length-1, i);
        }

//        루트노드와 최하위노드를 change하면서 heapify i=8~0
        for(int i=arr.length-1 ; i>=0 ; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i-1,0);
        }
        System.out.println(Arrays.toString(arr));
    }
    static void heapify(int[]arr, int arrLength, int node){
//        왼쪽노드 : node2 + 1
//        오른쪽노드 : node2 + 2
//        check1 : 왼쪽, 오른쪽 노드가 배열의 길이보다 짧아야함
//        check2 : node를 제외한 left, right 중 가장 작은 노드로 다시 heapify
        int left = node*2 + 1;
        int right = node*2 + 2;
        if(left > arrLength)return;
        if(right > arrLength){
//            node랑 left만 비교
            if(arr[node] > arr[left]){
                int temp = arr[node];
                arr[node] = arr[left];
                arr[left] = temp;
                heapify(arr, arrLength, left);
            }
        }else {
//            node, left, right 모두 비교
            int index = 0;
            if(arr[node] > arr[left] || arr[node] > arr[right]){
                if(arr[left] > arr[right]){
                    index = right;
                }else {
                    index = left;
                }
                int temp = arr[node];
                arr[node] = arr[index];
                arr[index] = temp;
                heapify(arr, arrLength, index);
            }
        }
    }


}
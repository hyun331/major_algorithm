package A6투포인터;

public class T3숫자의표현 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        int start = 0;
        int end = 0;
        int sum = arr[0];

        while(start<=end){
            if(sum == n){
                answer++;
                sum -= arr[start];
                start ++;
            }
            else if(sum < n && end < arr.length-1){
                end++;
                sum += arr[end];
            }
            else{
                sum -= arr[start];
                start++;
            }
        }


        return answer;
    }
}

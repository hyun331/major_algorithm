package A5dp;

public class D1DpBasic {
    public static void main(String[] args) {
        // DP(Dynamic Programming) - 기억하기 알고리즘 or 규칙찾기(연역적(직관적으로 봤을 때 찾는것), 귀납적(예시->추론))
        //1, 4, 5로 13을 만들 수 있는 조합 중 가장 작은 조합
        // DFS, BFS로는 너무 오래 걸림
        // 12 9 8 중에 가장 작은 조합을 가진 조합의 개수 +1
        //Min(f(n-1), f(n-2), ...)+1
        // 1은 1개. 2는 2개, 3은 3개(1,1,1) 4는 1개(4), 5는 1개(5), 6은 2개(5,1)

        //최소한의 조합이므로 13에서 1, 4, 5를 빼준 값의 조합 + 1로 하면 됨.
        // 예) 11에서 1 두번 더해서 오는건 최소가 아니므로 필요없음
        int target = 13;
        int[] numbers = {1, 4, 5};
        int[] arr= new int[target+1];

        arr[1] = 1;
        for(int i=2; i<=target; i++){
            int min = Integer.MAX_VALUE;
            for(int n : numbers){
                if(i-n>=0 && min > arr[i-n])
                    min = arr[i-n];
            }
            arr[i] = min+1;
        }

        System.out.println(arr[13]);
    }

}

package A5dp;

public class D2멀리뛰기 {

    // 비슷한 문제 계단 오르기 문제
    // 한번에 한칸 또는 두칸 올라감. 30번째 계단에 오를 수 있는 경우의 수?
    // A(30) = A(29) + A(28) -> 이렇게 위에서 아래로 내려오면 너무 많음
    // 아래서부터 기억하면서 올라오기!
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
    public static long solution(int n) {
        long answer = 0;
        long[] how = new long[n+1];

        how[0] = 0;
        how[1] = 1;
        if(n>=2)
            how[2] = 2;

        if(n>=3){
            for(int i=3; i<=n; i++){
                how[i] = (how[i-1]+how[i-2])%1234567;
            }
        }
        answer = how[n];



        return answer;
    }
}

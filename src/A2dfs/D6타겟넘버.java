package A2dfs;

public class D6타겟넘버 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    private static int count = 0;
    public static int solution(int[] numbers, int target){
        int sum = 0;
        dfs(numbers, target, -1, sum);

        return count;
    }

    private static void dfs(int[] numbers, int target, int v, int sum){
        v++;
        if(v>=numbers.length){
            return;
        }

        else if(v< numbers.length-1){
            dfs(numbers, target, v, sum + numbers[v]);
            dfs(numbers, target, v, sum - numbers[v]);
        }
        else if(v == numbers.length-1){
            if(sum+numbers[v] == target){
                count++;
            }
            else if(sum-numbers[v] ==target){
                count++;
            }
        }

    }
}

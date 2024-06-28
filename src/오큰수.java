import java.util.*;

public class 오큰수 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] A = new int[N];

        String[] inputA = sc.nextLine().split(" ");
        int[] output = new int[N];  //출력배열

        //입력받기
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(inputA[i]);
            output[i] = -1; //출력 값 초기화
        }


        Stack<Integer> compareStack = new Stack<>();    //비교 stack
        for(int i=N-1; i>=0; i--){
            int nowNum = A[i];
            if(compareStack.isEmpty()){ //스택이 비어있으면 now보다 큰 값 없음. -1
                output[i] = -1;
            }
            else{
                if(compareStack.peek() > nowNum){   //now보다 큰값이 있으면 해당 값을 output에 넣어줌
                    output[i] = compareStack.peek();
                }
                else{
                    while(!compareStack.isEmpty()){
                        if(compareStack.peek() > nowNum){
                            output[i] = compareStack.peek();
                            break;
                        }
                        else    // now보다 큰 값이 나올 때까지 pop하기
                            compareStack.pop();
                    }
                }
            }
            compareStack.push(nowNum);

        }


        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            sb.append(output[i]+ " ");
        }
        sb.delete(sb.length()-1, sb.length());

        System.out.println(sb);

    }
}

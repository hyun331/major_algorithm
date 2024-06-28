package AStudy;

import java.util.*;

public class Study01해시_의상 {
    public static void main(String[] args) {
        //String[][] clothes2 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};


        System.out.println(solution(clothes));
    }
    // 이렇게 풀면 메모리 초과 발생
    public static int solution(String[][] clothes) {
        int answer = 0;

        Map<String, List<String>> map = new HashMap<>();
        List<String> category = new ArrayList<>();

        List<List<String>> combi = new ArrayList<>();   // 최종 조합
        List<String> tmp ;  //조합 만들기 위한 temp


        for(int i=0; i<clothes.length; i++){
            List<String> clothList;
            if(map.containsKey(clothes[i][1])){ //이미 맵에 있다면
                clothList = map.get(clothes[i][1]);
                clothList.add(clothes[i][0]);
                map.put(clothes[i][1], clothList);
            }
            else{   // 맵에 없다면 새로운 카테고리임
                clothList = new ArrayList<>();
                clothList.add(clothes[i][0]);
                map.put(clothes[i][1], clothList);
                category.add(clothes[i][1]);    // 옷 카테고리에 넣기
                //combi.add(Arrays.asList(clothes[i][1]));    // 크기가 1인 조합은 여기서 처리
            }
        }




        // 카테고리 조합 만들기
        for(int i=0; i<category.size(); i++){   //i=0~4 카테고리가 5개면 1~5개씩 있는 조합이 필요

            getCombi(i+1,0, combi, category, new ArrayList<>());

            System.out.println(combi);

        }


        for(int i=0; i<combi.size(); i++){
            List<String> list = combi.get(i);
            int sum = 1;
            for(String key : list){
                sum = sum * map.get(key).size();
            }
            answer += sum;
        }




        return answer;
    }

    static void getCombi(int size, int start, List<List<String>> combi, List<String> category, List<String> tmp){
        if(tmp.size() == size){
            combi.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=start; i<category.size(); i++){
            tmp.add(category.get(i));
            getCombi(size, i+1, combi, category, tmp);
            tmp.remove(tmp.size()-1);
        }

    }
}


// 이 방식으로 풀기
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            if (hashMap.containsKey(clothes[i][1])) hashMap.put(clothes[i][1], hashMap.get(clothes[i][1]) + 1);
            else hashMap.put(clothes[i][1], 2);
        }

        for (Iterator<Integer> i = hashMap.values().iterator(); i.hasNext(); )
            answer *= i.next();
        return answer -1;
    }
}
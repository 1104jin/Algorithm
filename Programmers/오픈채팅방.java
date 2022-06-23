import java.util.*;
import java.lang.*;
class Solution {
    public class Person{
        String name;
        String word;

        public Person (String name, String word){
            this.word = word;
            this.name = name;
        }
    }

    public String[] solution(String[] record) {
        //클래스 배열 생성
        ArrayList<Person> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for(int i =0; i < record.length;i++){
            String[] wordsList = record[i].split(" ");

            if(!wordsList[0].equals("Change")){
                if(wordsList[0].equals("Enter")){
                    list.add(new Person(wordsList[1], "님이 들어왔습니다."));
                }else{
                    list.add(new Person(wordsList[1], "님이 나갔습니다."));
                }
            }

            if(wordsList.length == 3){
                map.put(wordsList[1], wordsList[2]);
            }
        }
        String[] answer = new String[list.size()];

        for(int i = 0; i < list.size();i++){
            StringBuilder total = new StringBuilder();
            total.append(map.get(list.get(i).name));

            total.append(list.get(i).word);
            answer[i] = total.toString();
        }

        return answer;

    }
}
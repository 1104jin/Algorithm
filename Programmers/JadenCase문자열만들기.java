import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        //0.소문자로 변경
        s = s.toLowerCase();
        //1. 들어온 문자를 배열에 넣어준다.
        String[] temp = s.split("");
        
        //2. 확인용 isTrue 생성
        boolean isTrue = true;
        
        //배열 길이수만큼 반복
        for(String tempWord : temp){
            //isTrue가 true면 대문자로 변경
            answer +=  isTrue? tempWord.toUpperCase():tempWord;
            //띄어쓰기가 맞다면 isTrue true로 지정
            isTrue = tempWord.equals(" ") ? true : false;
        }
        
        
        
        return answer;
    }
}

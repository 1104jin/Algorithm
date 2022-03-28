import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        
        int date = 0;
        for(int i = 0; i < progresses.length;i++){
            while(progresses[i] + (date * speeds[i]) < 100){
                date++;
            }
            answer[date]++; 
        }
        
        int resultM = 0;
        for(int temp : answer){
            if(temp > 0)
            resultM++;
        }
        
        int[] result = new int[resultM];
        
        int i = 0;
        for(int num : answer){
            if(num != 0){ result[i] = num;
            i++;}
        }
        
        
        return result;
    }
}
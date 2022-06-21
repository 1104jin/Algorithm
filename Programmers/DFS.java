class Solution {
    //결과 값을 나타내는 수
    private int cnt;
    public int solution(int[] numbers, int target) {
        cnt = 0;
        //위치, 계산 결과, 배열, 타겟
        dfs(0,0, numbers,target);
        
        return cnt;
    }
    
    private void dfs(int num, int result, int[] numbers, int target){
        //숫자와 배열의 길이가 같다면
        if(num == numbers.length){
            //타겟과 결과 값이 같다면 cnt+1
            if(target == result) cnt++;
            return;
        }
        
        dfs(num+1, result + numbers[num], numbers, target); //덧셈 부분
        dfs(num+1, result - numbers[num], numbers, target); //뺄셈 부분
    }
}
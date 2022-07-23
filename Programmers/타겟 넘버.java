class Solution {
    private int cnt;
    public int solution(int[] numbers, int target) {
        cnt = 0;
        dfs(0,0, numbers,target);
        
        return cnt;
    }
    
    private void dfs(int num, int result, int[] numbers, int target){
        if(num == numbers.length){
            if(target == result) cnt++;
            return;
        }
        
        dfs(num+1, result + numbers[num], numbers, target); //더하기 부분
        dfs(num+1, result - numbers[num], numbers, target);
    }
}

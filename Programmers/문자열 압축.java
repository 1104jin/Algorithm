class Solution {
    public int solution(String s) {
        int answer = s.length();

        int cnt = 1;
        while(cnt != s.length() / 2 + 1){
            String temp = s.substring(0, cnt);
            int count = 1;
            String check = "";
            StringBuilder total = new StringBuilder();

            //몇개인지 확인
            for(int i = cnt; i <= s.length(); i+=cnt){
                //남은게 나누는 수보다 작은지 큰지 확인
                if(i + cnt >= s.length()){
                    check = s.substring(i, s.length());
                }
                else{
                    check = s.substring(i, i + cnt);
                }

                //비교
                if(check.equals(temp)){
                    count++;
                }else{
                    if(count != 1){
                        total.append(count);
                        count = 1;
                    }
                    total.append(temp);
                    temp = check;
                }
            }

            if(count == 1)
                total.append(temp);

            //비교
            answer = Math.min(answer, total.toString().length());

            cnt ++;
        }

        return answer;

    }
}
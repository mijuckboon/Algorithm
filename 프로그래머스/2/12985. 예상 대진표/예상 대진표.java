class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 0;
        int mod = 1;
        
        while(a != b) {
            mod *= 2;
            a = (int) Math.ceil( (float) a / mod) * mod; // 뒤에 있는 값으로 대체 (7, 8 -> 8; union find 아이디어)
            b = (int) Math.ceil( (float) b / mod) * mod;
            count += 1;
        }
        

        return count;
    }
}
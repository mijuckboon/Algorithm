class Solution {
    /* yellow = (hor - 2) * (ver - 2)
     * brown + yellow = hor * ver
     * -> 2 * (hor + ver) - 4 = brown
    */
    public int[] solution(int brown, int yellow) {
        // hor >= ver, 두 수의 합 이용
        int hor = (brown + 4) / 2 - 1;
        int ver = 1;
        
        // 곱에 대한 조건을 만족하면 두 수 반환        
        while ( (hor - 2) * (ver - 2) != yellow) {
            hor -= 1;
            ver += 1;
        }
        
        int[] lengths = {hor, ver};
        return lengths;
    }
}